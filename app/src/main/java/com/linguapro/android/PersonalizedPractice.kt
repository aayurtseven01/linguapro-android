package com.linguapro.android

/** Uses authored exercises; it never invents an answer key or a proficiency score. */
object PersonalizedPractice {
    fun build(
        language: String, level: String, lessons: List<LearningLesson>,
        mistakeIds: Set<String>, stats: Map<Skill, SkillTally>, maxExercises: Int = 8,
        recentExerciseIds: Set<String> = emptySet(), sessionSeed: Long = 0L
    ): LearningLesson {
        require(maxExercises in 1..20)
        val candidates = lessons.flatMap { it.exercises }.distinctBy { it.id }
        val weakest = Skill.entries.sortedBy { skill ->
            stats[skill]?.takeIf { it.attempts >= 3 }?.accuracyPercent ?: 100
        }
        val ranked = candidates.shuffled(kotlin.random.Random(sessionSeed)).sortedWith(
            compareByDescending<LearningExercise> { it.id in mistakeIds }
                .thenBy { it.id in recentExerciseIds }
                .thenBy { weakest.indexOf(it.skill) })
        val selected = linkedMapOf<String, LearningExercise>()
        ranked.filter { it.id in mistakeIds }.take(3.coerceAtMost(maxExercises)).forEach { selected[it.id] = it }
        weakest.forEach { skill ->
            if (selected.size < maxExercises) ranked.firstOrNull { it.skill == skill && it.id !in selected }?.let { selected[it.id] = it }
        }
        ranked.forEach { if (selected.size < maxExercises) selected.putIfAbsent(it.id, it) }
        val selectedIds = selected.keys
        val vocabulary = lessons.filter { lesson -> lesson.exercises.any { it.id in selectedIds } }
            .flatMap { it.targetVocabulary }.distinctBy { it.id }
        return LearningLesson("$language-$level-PRO", "Sana Özel Pratik", "Hatalarını pekiştir, farklı becerileri kısa bir oturumda çalış.", selected.values.toList(), vocabulary)
    }
}


/** Local session rotation is isolated by learner, language and level. */
class PracticeHistoryStore(context: android.content.Context, learnerKey: String, language: String, level: String) {
    private val prefs = context.applicationContext.getSharedPreferences(
        "practice_history_v1_${learnerKey.ifBlank { "guest" }}", android.content.Context.MODE_PRIVATE
    )
    private val key = "${language.uppercase(java.util.Locale.ROOT)}_$level"
    fun seed(): Long = prefs.getLong("${key}_seed", 0L)
    fun recentIds(): Set<String> = prefs.getStringSet("${key}_recent", emptySet()).orEmpty().toSet()
    fun rememberSession(exerciseIds: List<String>) {
        prefs.edit().putLong("${key}_seed", (seed() + 1).coerceAtLeast(0L))
            .putStringSet("${key}_recent", exerciseIds.take(20).toSet()).apply()
    }
}
