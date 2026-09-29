package com.linguapro.android.domain.usecase

import kotlin.math.roundToInt
import kotlin.math.roundToLong

/** Four learner-facing choices mapped to classic SM-2 quality scores. */
enum class ReviewGrade(val quality: Int) {
    AGAIN(0), HARD(3), GOOD(4), EASY(5)
}

data class Sm2State(
    val repetitions: Int = 0,
    val intervalDays: Double = 0.0,
    val easeFactor: Double = 2.5,
    val lapseCount: Int = 0,
    val dueAtEpochMillis: Long = 0L,
    val lastReviewedAtEpochMillis: Long? = null
)

object Sm2Scheduler {
    const val MIN_EASE_FACTOR = 1.3
    const val SHORT_RETRY_MILLIS = 10 * 60 * 1000L
    private const val DAY_MILLIS = 24 * 60 * 60 * 1000.0

    fun review(state: Sm2State, grade: ReviewGrade, reviewedAtEpochMillis: Long): Sm2State {
        require(state.repetitions >= 0) { "Repetition count cannot be negative." }
        require(state.intervalDays >= 0.0 && state.intervalDays.isFinite()) { "Interval must be finite and non-negative." }
        require(state.easeFactor >= MIN_EASE_FACTOR && state.easeFactor.isFinite()) { "Ease factor must be at least 1.3." }
        require(state.lapseCount >= 0)

        val quality = grade.quality
        val difficulty = 5 - quality
        val nextEase = (state.easeFactor + (0.1 - difficulty * (0.08 + difficulty * 0.02)))
            .coerceAtLeast(MIN_EASE_FACTOR)

        if (quality < 3) {
            return state.copy(
                repetitions = 0,
                intervalDays = 1.0,
                easeFactor = nextEase,
                lapseCount = state.lapseCount + 1,
                dueAtEpochMillis = reviewedAtEpochMillis + SHORT_RETRY_MILLIS,
                lastReviewedAtEpochMillis = reviewedAtEpochMillis
            )
        }

        val nextRepetitions = state.repetitions + 1
        val nextInterval = when (state.repetitions) {
            0 -> 1.0
            1 -> 6.0
            else -> (state.intervalDays * nextEase).roundToInt().coerceAtLeast(1).toDouble()
        }
        return state.copy(
            repetitions = nextRepetitions,
            intervalDays = nextInterval,
            easeFactor = nextEase,
            dueAtEpochMillis = reviewedAtEpochMillis + (nextInterval * DAY_MILLIS).roundToLong(),
            lastReviewedAtEpochMillis = reviewedAtEpochMillis
        )
    }
}
