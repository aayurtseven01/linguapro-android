package com.linguapro.android.ui.home

import android.content.Context
import androidx.room.withTransaction
import com.linguapro.android.data.LocalAccountDataCleaner
import com.linguapro.android.data.local.LinguaDatabase
import com.linguapro.android.data.local.PendingLessonEvent
import com.linguapro.android.data.sync.LessonSyncWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.UUID
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.flow.flow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linguapro.android.TargetVocabulary
import com.linguapro.android.data.local.VocabularyEntity
import com.linguapro.android.LearningLesson
import com.linguapro.android.LearningUnit
import com.linguapro.android.data.local.ReviewCardEntity
import com.linguapro.android.data.preferences.UserSettings
import com.linguapro.android.data.preferences.UserSettingsRepository
import com.linguapro.android.data.repository.ReviewScheduleRepository
import com.linguapro.android.domain.model.CardDirection
import com.linguapro.android.domain.usecase.ReviewGrade
import com.linguapro.android.data.repository.LearningRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private data class LearnerContext(val learnerId: String = "guest", val level: String = "A1")

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class LearningDashboardViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val database: LinguaDatabase,
    private val accountDataCleaner: LocalAccountDataCleaner,
    private val learningRepository: LearningRepository,
    private val settingsRepository: UserSettingsRepository,
    private val reviewScheduleRepository: ReviewScheduleRepository
) : ViewModel() {
    private val learnerContext = MutableStateFlow(LearnerContext())
    private val contentJson = Json { ignoreUnknownKeys = true }

    private val progress = learnerContext.flatMapLatest { (learnerId, level) ->
        learningRepository.observeLessonProgress(learnerId, level)
    }
    private val completedCount = learnerContext.flatMapLatest { (learnerId, level) ->
        learningRepository.observeCompletedLessonCount(learnerId, level)
    }
    private val courseUnits = learnerContext.flatMapLatest { (_, level) ->
        learningRepository.observeLessons(level).map { rows ->
            rows.groupBy { it.unitId }.map { (unitId, lessonRows) ->
                val lessons = lessonRows.mapNotNull { row ->
                    runCatching { contentJson.decodeFromString<LearningLesson>(row.contentJson) }.getOrNull()
                }
                LearningUnit(unitId, lessonRows.first().unitTitle, lessonRows.first().unitSummary, lessons)
            }.filter { it.lessons.isNotEmpty() }
        }
    }
    private val reviewClock = MutableStateFlow(System.currentTimeMillis())
    private val clockTicks = flow {
        while (kotlin.coroutines.coroutineContext.isActive) {
            emit(System.currentTimeMillis())
            delay(60_000)
        }
    }
    private val tickingClock = combine(reviewClock, clockTicks) { manual, tick -> maxOf(manual, tick) }
    private val dueReviewCards = combine(learnerContext, tickingClock) { context, now -> context.learnerId to now }
        .flatMapLatest { (learnerId, now) -> reviewScheduleRepository.observeDue(learnerId, now) }

    val pendingSyncCount = learnerContext.flatMapLatest { (learnerId, _) ->
        database.pendingLessonEventDao().observeCount(learnerId)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    val errorMessage = MutableStateFlow<String?>(null)

    val uiState: StateFlow<LearningDashboardState> = combine(
        progress,
        completedCount,
        settingsRepository.settings,
        courseUnits,
        dueReviewCards
    ) { recentProgress, completed, settings, units, dueCards ->
        LearningDashboardState(
            completedLessonCount = completed,
            recentScores = recentProgress.take(5).mapNotNull { it.scorePercent },
            settings = settings,
            supplementalUnits = units,
            dueReviewCards = dueCards
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), LearningDashboardState())

    fun setLearnerContext(learnerKey: String, level: String) {
        learnerContext.value = LearnerContext(learnerKey.ifBlank { "guest" }, level)
        reviewClock.value = System.currentTimeMillis()
        if (learnerKey.isNotBlank()) LessonSyncWorker.schedule(context)
    }

    fun recordLesson(
        learnerKey: String, level: String, lessonId: String, scorePercent: Int?,
        vocabulary: List<TargetVocabulary>, countsTowardCourse: Boolean = true, done: (Boolean) -> Unit = {}
    ) {
        val learnerId = learnerKey.ifBlank { "guest" }
        viewModelScope.launch {
            try {
                val now = System.currentTimeMillis()
                database.withTransaction {
                    if (countsTowardCourse) learningRepository.recordLesson(learnerId, level, lessonId, scorePercent, now)
                    if (learnerKey.isNotBlank()) database.pendingLessonEventDao().enqueue(
                        PendingLessonEvent(UUID.randomUUID().toString(), learnerId, lessonId, scorePercent, countsTowardCourse, now)
                    )
                    database.vocabularyDao().upsertAll(vocabulary.distinctBy { it.id }.map { word ->
                        VocabularyEntity(word.id, level, lessonId.substringBeforeLast('-'), lessonId,
                            word.termEn, word.translationTr, word.exampleEn, word.exampleTr, word.emoji, word.termEn)
                    })
                    vocabulary.forEach { reviewScheduleRepository.addVocabularyForReview(learnerId, it.id, now) }
                }
                if (learnerKey.isNotBlank()) LessonSyncWorker.schedule(context)
                reviewClock.value = now
                done(true)
            } catch (error: Exception) {
                if (error is kotlinx.coroutines.CancellationException) throw error
                errorMessage.value = "Ders cihazına kaydedilemedi. Lütfen tekrar dene."
                done(false)
            }
        }
    }

    fun clearAccountData(uid: String, done: (String?) -> Unit) {
        viewModelScope.launch {
            try {
                accountDataCleaner.clear(uid)
                done(null)
            } catch (error: Exception) {
                if (error is kotlinx.coroutines.CancellationException) throw error
                done("Bulut hesabı silindi ancak cihazdaki temizleme tamamlanamadı.")
            }
        }
    }

    fun gradeReview(card: ReviewCardEntity, grade: ReviewGrade) {
        val learnerId = learnerContext.value.learnerId
        if (learnerId.isBlank() || card.learnerId != learnerId) return
        viewModelScope.launch {
            try {
                reviewScheduleRepository.grade(
                    learnerId,
                    card.vocabularyId,
                    CardDirection.valueOf(card.direction),
                    grade,
                    System.currentTimeMillis(),
                    card.lastReviewedAtEpochMillis
                )
            } catch (error: Exception) {
                if (error is kotlinx.coroutines.CancellationException) throw error
                errorMessage.value = "Tekrar sonucu kaydedilemedi. Lütfen yeniden dene."
            }
            reviewClock.value = System.currentTimeMillis()
        }
    }

    fun setDailyGoal(minutes: Int) = viewModelScope.launch { settingsRepository.setDailyGoal(minutes) }
}

data class LearningDashboardState(
    val completedLessonCount: Int = 0,
    val recentScores: List<Int> = emptyList(),
    val settings: UserSettings = UserSettings(),
    val supplementalUnits: List<LearningUnit> = emptyList(),
    val dueReviewCards: List<ReviewCardEntity> = emptyList()
)
