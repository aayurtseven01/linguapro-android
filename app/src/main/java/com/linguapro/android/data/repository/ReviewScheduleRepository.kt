package com.linguapro.android.data.repository

import com.linguapro.android.data.local.ReviewCardDao
import com.linguapro.android.data.local.ReviewCardEntity
import com.linguapro.android.domain.model.CardDirection
import com.linguapro.android.domain.usecase.ReviewGrade
import com.linguapro.android.domain.usecase.Sm2Scheduler
import com.linguapro.android.domain.usecase.Sm2State
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class ReviewScheduleRepository @Inject constructor(private val cards: ReviewCardDao) {
    fun observeDue(learnerId: String, nowEpochMillis: Long): Flow<List<ReviewCardEntity>> =
        cards.observeDue(learnerId, nowEpochMillis)

    fun observeDueCount(learnerId: String, nowEpochMillis: Long): Flow<Int> =
        cards.observeDueCount(learnerId, nowEpochMillis)

    suspend fun addVocabularyForReview(learnerId: String, vocabularyId: String, nowEpochMillis: Long) {
        require(learnerId.isNotBlank())
        require(vocabularyId.isNotBlank())
        val newCards = CardDirection.entries.mapNotNull { direction ->
            val directionName = direction.name
            if (cards.getCard(learnerId, vocabularyId, directionName) != null) return@mapNotNull null
            ReviewCardEntity(
                id = "$learnerId:$vocabularyId:$directionName",
                learnerId = learnerId,
                vocabularyId = vocabularyId,
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
        reviewedAtEpochMillis: Long
    ): ReviewCardEntity {
        val id = "$learnerId:$vocabularyId:${direction.name}"
        val current = cards.getCard(learnerId, vocabularyId, direction.name)
            ?: ReviewCardEntity(id, learnerId, vocabularyId, direction.name, dueAtEpochMillis = reviewedAtEpochMillis)
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
        return saved
    }
}
