package com.linguapro.android

import android.content.Context
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/** Local learner-facing practice summary. It is never used for billing/entitlements. */
data class LearningProgress(
    val streakDays: Int = 0,
    val totalXp: Int = 0,
    val todayXp: Int = 0,
    val lastStudyDate: String = ""
) {
    val dailyGoalPercent: Int get() = (todayXp * 100 / DAILY_XP_GOAL).coerceIn(0, 100)
    val dailyGoalReached: Boolean get() = todayXp >= DAILY_XP_GOAL

    companion object { const val DAILY_XP_GOAL = 20 }
}

/** Pure date transition, separately testable and safe across duplicate lessons in one day. */
object StreakLogic {
    fun nextStreak(current: Int, lastStudyDate: LocalDate?, today: LocalDate): Int = when {
        lastStudyDate == today -> current.coerceAtLeast(1)
        lastStudyDate == today.minusDays(1) -> current.coerceAtLeast(0) + 1
        else -> 1
    }
}

class LearningProgressStore(context: Context, learnerKey: String) {
    private val prefsName = "learner_progress_v1_${learnerKey.ifBlank { "guest" }}"
    private val prefs = context.applicationContext.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    fun read(today: LocalDate = LocalDate.now()): LearningProgress {
        val lastDate = prefs.getString(KEY_DATE, "").orEmpty()
        val streak = prefs.getInt(KEY_STREAK, 0).let { saved ->
            val parsed = runCatching { LocalDate.parse(lastDate) }.getOrNull()
            if (parsed == null || ChronoUnit.DAYS.between(parsed, today) > 1) 0 else saved
        }
        val todayXp = if (lastDate == today.toString()) prefs.getInt(KEY_TODAY_XP, 0) else 0
        return LearningProgress(streak, prefs.getInt(KEY_TOTAL_XP, 0), todayXp, lastDate)
    }

    fun recordLesson(score: Int, today: LocalDate = LocalDate.now()): LearningProgress {
        val priorDate = runCatching { LocalDate.parse(prefs.getString(KEY_DATE, "").orEmpty()) }.getOrNull()
        val priorStreak = prefs.getInt(KEY_STREAK, 0)
        val oldTodayXp = if (priorDate == today) prefs.getInt(KEY_TODAY_XP, 0) else 0
        val awardedXp = xpForScore(score)
        val streak = StreakLogic.nextStreak(priorStreak, priorDate, today)
        val todayXp = oldTodayXp + awardedXp
        prefs.edit()
            .putString(KEY_DATE, today.toString())
            .putInt(KEY_STREAK, streak)
            .putInt(KEY_TODAY_XP, todayXp)
            .putInt(KEY_TOTAL_XP, prefs.getInt(KEY_TOTAL_XP, 0) + awardedXp)
            .apply()
        return LearningProgress(streak, prefs.getInt(KEY_TOTAL_XP, 0), todayXp, today.toString())
    }

    private fun xpForScore(score: Int): Int = (10 + score.coerceIn(0, 100) / 10).coerceAtMost(20)

    private companion object {
        const val KEY_DATE = "last_study_date"
        const val KEY_STREAK = "streak_days"
        const val KEY_TODAY_XP = "today_xp"
        const val KEY_TOTAL_XP = "total_xp"
    }
}
