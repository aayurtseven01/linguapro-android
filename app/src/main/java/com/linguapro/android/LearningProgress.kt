package com.linguapro.android

import android.content.Context
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/** Local learner-facing practice summary. It is never used for billing/entitlements. */
data class LearningProgress(
    val streakDays: Int = 0,
    val totalXp: Int = 0,
    val todayXp: Int = 0,
    val lastStudyDate: String = "",
    val streakFreezes: Int = 0,
    val todayStudySeconds: Int = 0
) {
    fun studyGoalPercent(minutes: Int): Int = (todayStudySeconds.toLong() * 100 / (minutes.coerceAtLeast(1) * 60)).toInt().coerceIn(0, 100)
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
        val freezes = prefs.getInt(KEY_FREEZES, 0)
        val streak = prefs.getInt(KEY_STREAK, 0).let { saved ->
            val parsed = runCatching { LocalDate.parse(lastDate) }.getOrNull()
            when {
                parsed == null -> 0
                ChronoUnit.DAYS.between(parsed, today) <= 1 -> saved
                // Dün atlandı ama Seri Dondurucu hazır: seri görünümde korunur, sonraki derste tüketilir.
                StreakFreezeLogic.shouldConsume(parsed, today, freezes) -> saved
                else -> 0
            }
        }
        val todayXp = if (lastDate == today.toString()) prefs.getInt(KEY_TODAY_XP, 0) else 0
        val studySeconds = if (lastDate == today.toString()) prefs.getInt(KEY_STUDY_SECONDS, 0) else 0
        return LearningProgress(streak, prefs.getInt(KEY_TOTAL_XP, 0), todayXp, lastDate, streakFreezes = freezes, todayStudySeconds = studySeconds)
    }

    fun recordLesson(score: Int?, today: LocalDate = LocalDate.now(), studiedSeconds: Int = 0): LearningProgress {
        val priorDate = runCatching { LocalDate.parse(prefs.getString(KEY_DATE, "").orEmpty()) }.getOrNull()
        val priorStreak = prefs.getInt(KEY_STREAK, 0)
        val oldTodayXp = if (priorDate == today) prefs.getInt(KEY_TODAY_XP, 0) else 0
        val awardedXp = LessonScoring.xpForCompletion(score)
        val freezes = prefs.getInt(KEY_FREEZES, 0)
        val consumeFreeze = StreakFreezeLogic.shouldConsume(priorDate, today, freezes)
        val effectivePrior = if (consumeFreeze) today.minusDays(1) else priorDate
        if (consumeFreeze) prefs.edit().putInt(KEY_FREEZES, freezes - 1).apply()
        val streak = StreakLogic.nextStreak(priorStreak, effectivePrior, today)
        val todayXp = oldTodayXp + awardedXp
        val studySeconds = (if (priorDate == today) prefs.getInt(KEY_STUDY_SECONDS, 0) else 0) + studiedSeconds.coerceIn(0, 7200)
        prefs.edit()
            .putString(KEY_DATE, today.toString())
            .putInt(KEY_STREAK, streak)
            .putInt(KEY_TODAY_XP, todayXp)
            .putInt(KEY_TOTAL_XP, prefs.getInt(KEY_TOTAL_XP, 0) + awardedXp)
            .putInt(KEY_STUDY_SECONDS, studySeconds)
            .apply()
        return LearningProgress(streak, prefs.getInt(KEY_TOTAL_XP, 0), todayXp, today.toString(), studySeconds)
    }

    /** Gunluk gorev odulu gibi ders disi XP ekler; seri ve gunluk hedef sayaclarini da gunceller. */
    fun addBonusXp(xp: Int, today: LocalDate = LocalDate.now()): LearningProgress {
        val priorDate = runCatching { LocalDate.parse(prefs.getString(KEY_DATE, "").orEmpty()) }.getOrNull()
        val oldTodayXp = if (priorDate == today) prefs.getInt(KEY_TODAY_XP, 0) else 0
        val freezes = prefs.getInt(KEY_FREEZES, 0)
        val consumeFreeze = StreakFreezeLogic.shouldConsume(priorDate, today, freezes)
        val effectivePrior = if (consumeFreeze) today.minusDays(1) else priorDate
        if (consumeFreeze) prefs.edit().putInt(KEY_FREEZES, freezes - 1).apply()
        val streak = StreakLogic.nextStreak(prefs.getInt(KEY_STREAK, 0), effectivePrior, today)
        prefs.edit()
            .putString(KEY_DATE, today.toString())
            .putInt(KEY_STREAK, streak)
            .putInt(KEY_TODAY_XP, oldTodayXp + xp)
            .putInt(KEY_TOTAL_XP, prefs.getInt(KEY_TOTAL_XP, 0) + xp)
            .putInt(KEY_STUDY_SECONDS, if (priorDate == today) prefs.getInt(KEY_STUDY_SECONDS, 0) else 0)
            .apply()
        return read(today)
    }

    /** Elmas Dükkânı: Seri Dondurucu satın alımı. */
    fun addStreakFreeze(today: LocalDate = LocalDate.now()): LearningProgress {
        prefs.edit().putInt(KEY_FREEZES, prefs.getInt(KEY_FREEZES, 0) + 1).apply()
        return read(today)
    }

    private companion object {
        const val KEY_STUDY_SECONDS = "study_seconds"
        const val KEY_DATE = "last_study_date"
        const val KEY_STREAK = "streak_days"
        const val KEY_TODAY_XP = "today_xp"
        const val KEY_TOTAL_XP = "total_xp"
        const val KEY_FREEZES = "streak_freezes"
    }
}
