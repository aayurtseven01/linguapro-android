package com.linguapro.android.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linguapro.android.LearningLesson
import com.linguapro.android.LearningUnit
import com.linguapro.android.data.preferences.UserSettings
import com.linguapro.android.data.preferences.UserSettingsRepository
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
    private val learningRepository: LearningRepository,
    private val settingsRepository: UserSettingsRepository
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

    val uiState: StateFlow<LearningDashboardState> = combine(
        progress,
        completedCount,
        settingsRepository.settings,
        courseUnits
    ) { recentProgress, completed, settings, units ->
        LearningDashboardState(
            completedLessonCount = completed,
            recentScores = recentProgress.take(5).mapNotNull { it.scorePercent },
            settings = settings,
            supplementalUnits = units
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), LearningDashboardState())

    fun setLearnerContext(learnerKey: String, level: String) {
        learnerContext.value = LearnerContext(learnerKey.ifBlank { "guest" }, level)
    }

    fun recordLesson(learnerKey: String, level: String, lessonId: String, scorePercent: Int?) {
        val learnerId = learnerKey.ifBlank { "guest" }
        viewModelScope.launch {
            learningRepository.recordLesson(learnerId, level, lessonId, scorePercent)
        }
    }
}

data class LearningDashboardState(
    val completedLessonCount: Int = 0,
    val recentScores: List<Int> = emptyList(),
    val settings: UserSettings = UserSettings(),
    val supplementalUnits: List<LearningUnit> = emptyList()
)
