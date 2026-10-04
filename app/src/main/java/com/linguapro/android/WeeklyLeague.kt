package com.linguapro.android

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.temporal.TemporalAdjusters

/** All countries share the same Monday/UTC ranking window. */
object WeeklyLeague {
    fun weekKey(day: LocalDate = LocalDate.now(ZoneOffset.UTC)): String =
        day.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toString()
}
