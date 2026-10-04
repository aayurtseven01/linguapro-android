package com.linguapro.android.data.repository

import androidx.room.withTransaction
import com.linguapro.android.data.local.LinguaDatabase
import com.linguapro.android.data.local.ReviewCardDao
import com.linguapro.android.data.local.ReviewCardEntity
import com.linguapro.android.data.local.VocabularyDao
import com.linguapro.android.domain.model.CardDirection
import com.linguapro.android.domain.usecase.ReviewGrade
import com.linguapro.android.domain.usecase.Sm2Scheduler
import com.linguapro.android.domain.usecase.Sm2State
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class ReviewScheduleRepository @Inject constructor(
    private val cards: ReviewCardDao,
    private val vocabulary: VocabularyDao,
    private val database: LinguaDatabase
) {
    fun observeDue(learnerId: String, nowEpochMillis: Long): Flow<List<ReviewCardEntity>> =
        cards.observeDue(learnerId, nowEpochMillis)

    fun observeDueCount(learnerId: String, nowEpochMillis: Long): Flow<Int> =
        cards.observeDueCount(learnerId, nowEpochMillis)

    suspend fun addVocabularyForReview(learnerId: String, vocabularyId: String, nowEpochMillis: Long) {
        require(learnerId.isNotBlank())
        require(vocabularyId.isNotBlank())
        val word = vocabulary.getById(vocabularyId) ?: return
        val newCards = CardDirection.entries.mapNotNull { direction ->
            val directionName = direction.name
            if (cards.getCard(learnerId, vocabularyId, directionName) != null) return@mapNotNull null
            val (front, back) = when (direction) {
                CardDirection.EN_TO_TR -> word.lemma to word.translationTr
                CardDirection.TR_TO_EN -> word.translationTr to word.lemma
            }
            ReviewCardEntity(
                id = "$learnerId:$vocabularyId:$directionName",
                learnerId = learnerId,
                vocabularyId = vocabularyId,
                frontText = front,
                backText = back,
                direction = directionName,
                dueAtEpochMillis = nowEpochMillis
            )
        }
        if (newCards.isNotEmpty()) cards.upsertAll(newCards)
    }

    suspend fun grade(
        learnerId: String,
        vocabularyId: String,
        direction: CardDirection,
        grade: ReviewGrade,
        reviewedAtEpochMillis: Long,
        expectedLastReviewedAtEpochMillis: Long?
    ): ReviewCardEntity? = database.withTransaction {
        require(learnerId.isNotBlank())
        val current = cards.getCard(learnerId, vocabularyId, direction.name)
            ?: return@withTransaction null
        if (current.lastReviewedAtEpochMillis != expectedLastReviewedAtEpochMillis) return@withTransaction current
        val updated = Sm2Scheduler.review(
            Sm2State(
                repetitions = current.repetitions,
                intervalDays = current.intervalDays,
                easeFactor = current.easeFactor,
                lapseCount = current.lapseCount,
                dueAtEpochMillis = current.dueAtEpochMillis,
                lastReviewedAtEpochMillis = current.lastReviewedAtEpochMillis
            ),
            grade,
            reviewedAtEpochMillis
        )
        val saved = current.copy(
            repetitions = updated.repetitions,
            intervalDays = updated.intervalDays,
            easeFactor = updated.easeFactor,
            lapseCount = updated.lapseCount,
            dueAtEpochMillis = updated.dueAtEpochMillis,
            lastReviewedAtEpochMillis = updated.lastReviewedAtEpochMillis
        )
        cards.upsert(saved)
        saved
    }
}

