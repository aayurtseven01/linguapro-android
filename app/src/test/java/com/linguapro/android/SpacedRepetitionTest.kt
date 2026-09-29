package com.linguapro.android

import com.linguapro.android.domain.usecase.ReviewGrade
import com.linguapro.android.domain.usecase.Sm2Scheduler
import com.linguapro.android.domain.usecase.Sm2State
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SpacedRepetitionTest {
    @Test
    fun goodReviewsFollowClassicFirstAndSecondIntervals() {
        val first = Sm2Scheduler.review(Sm2State(), ReviewGrade.GOOD, 1_000L)
        val second = Sm2Scheduler.review(first, ReviewGrade.GOOD, first.dueAtEpochMillis)
        assertEquals(1, first.repetitions)
        assertEquals(1.0, first.intervalDays, 0.0)
        assertEquals(2, second.repetitions)
        assertEquals(6.0, second.intervalDays, 0.0)
        assertEquals(second.dueAtEpochMillis, second.lastReviewedAtEpochMillis!! + 6 * 24 * 60 * 60 * 1000L)
    }

    @Test
    fun againSchedulesShortRetryAndResetsRepetitions() {
        val state = Sm2State(repetitions = 5, intervalDays = 30.0, easeFactor = 2.0, lapseCount = 2)
        val reviewedAt = 100_000L
        val result = Sm2Scheduler.review(state, ReviewGrade.AGAIN, reviewedAt)
        assertEquals(0, result.repetitions)
        assertEquals(1.0, result.intervalDays, 0.0)
        assertEquals(3, result.lapseCount)
        assertEquals(reviewedAt + Sm2Scheduler.SHORT_RETRY_MILLIS, result.dueAtEpochMillis)
    }

    @Test
    fun easeFactorNeverDropsBelowSm2Minimum() {
        var state = Sm2State(easeFactor = Sm2Scheduler.MIN_EASE_FACTOR)
        repeat(20) { state = Sm2Scheduler.review(state, ReviewGrade.HARD, it.toLong()) }
        assertTrue(state.easeFactor >= Sm2Scheduler.MIN_EASE_FACTOR)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rejectsNegativeRepetitionState() {
        Sm2Scheduler.review(Sm2State(repetitions = -1), ReviewGrade.GOOD, 0L)
    }
}
