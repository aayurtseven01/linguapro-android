package com.linguapro.android

import android.content.Context

data class SkillTally(val attempts: Int = 0, val correct: Int = 0) {
    val accuracyPercent: Int? get() = if (attempts == 0) null else correct.coerceIn(0, attempts) * 100 / attempts
}

object SkillProgressLogic {
    fun record(current: SkillTally, isCorrect: Boolean) = SkillTally(
        attempts = current.attempts + 1,
        correct = current.correct + if (isCorrect) 1 else 0
    )

    fun weakest(stats: Map<Skill, SkillTally>, minimumAttempts: Int = 3): Skill? =
        stats.filterValues { it.attempts >= minimumAttempts }
            .minByOrNull { (_, tally) -> tally.accuracyPercent ?: 100 }
            ?.key
}

class SkillProgressStore(context: Context, learnerKey: String) {
    private val prefs = context.applicationContext.getSharedPreferences(
        "skill_progress_${learnerKey.ifBlank { "guest" }}", Context.MODE_PRIVATE
    )

    fun read(): Map<Skill, SkillTally> = Skill.values().associateWith { skill ->
        SkillTally(
            attempts = prefs.getInt("${skill.name}_attempts", 0),
            correct = prefs.getInt("${skill.name}_correct", 0)
        )
    }

    fun record(skill: Skill, isCorrect: Boolean): Map<Skill, SkillTally> {
        val updated = SkillProgressLogic.record(read().getValue(skill), isCorrect)
        prefs.edit()
            .putInt("${skill.name}_attempts", updated.attempts)
            .putInt("${skill.name}_correct", updated.correct)
            .apply()
        return read()
    }
}
