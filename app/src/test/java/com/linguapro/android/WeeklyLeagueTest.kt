package com.linguapro.android

import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Test

class WeeklyLeagueTest {
    @Test fun weeklyWindowResetsOnMondayAndSurvivesYearBoundaries() {
        assertEquals("2026-09-28", WeeklyLeague.weekKey(LocalDate.parse("2026-10-04")))
        assertEquals("2026-10-05", WeeklyLeague.weekKey(LocalDate.parse("2026-10-05")))
        assertEquals("2025-12-29", WeeklyLeague.weekKey(LocalDate.parse("2026-01-01")))
    }
}
