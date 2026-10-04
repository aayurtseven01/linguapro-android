package com.linguapro.android

/** Uses authored exercises; it never invents an answer key or a proficiency score. */
object PersonalizedPractice {
    fun build(
        language: String, level: String, lessons: List<LearningLesson>,
        mistakeIds: Set<String>, stats: Map<Skill, SkillTally>, maxExercises: Int = 8
    ): LearningLesson {
        require(maxExercises in 1..20)
        val candidates = lessons.flatMap { it.exercises }.distinctBy { it.id }
        val weakest = Skill.entries.sortedBy { skill ->
            stats[skill]?.takeIf { it.attempts >= 3 }?.accuracyPercent ?: 100
        }
        val ranked = candidates.sortedWith(compareByDescending<LearningExercise> { it.id in mistakeIds }
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
