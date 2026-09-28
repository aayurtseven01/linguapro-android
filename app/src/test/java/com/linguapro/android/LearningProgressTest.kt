package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class LearningProgressTest {
    @Test fun `second lesson on same day does not increase streak`() {
        val day = LocalDate.parse("2026-09-29")
        assertEquals(4, StreakLogic.nextStreak(4, day, day))
    }

    @Test fun `studying on following day increments streak`() {
        val yesterday = LocalDate.parse("2026-09-28")
        assertEquals(5, StreakLogic.nextStreak(4, yesterday, yesterday.plusDays(1)))
    }

    @Test fun `missed day starts a new streak`() {
        val lastStudy = LocalDate.parse("2026-09-26")
        assertEquals(1, StreakLogic.nextStreak(7, lastStudy, LocalDate.parse("2026-09-29")))
    }

    @Test fun `first completed lesson starts a streak`() {
        assertEquals(1, StreakLogic.nextStreak(0, null, LocalDate.parse("2026-09-29")))
    }

    @Test fun `daily goal percentage is bounded`() {
        assertEquals(50, LearningProgress(todayXp = 10).dailyGoalPercent)
        assertEquals(100, LearningProgress(todayXp = 50).dailyGoalPercent)
    }
}
