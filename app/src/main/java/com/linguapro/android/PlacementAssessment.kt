package com.linguapro.android

import java.util.Locale

data class PlacementQuestionResult(val level: String, val skill: Skill)
data class PlacementSummary(
    val level: String,
    val accuracyPercent: Int,
    val skillMastery: Map<String, Int>,
    val answered: Int,
    val correct: Int
)

/** Converts the adaptive diagnostic's observed answers into a level estimate and skill profile. */
object PlacementAssessment {
    private val levelOrder = listOf("A1", "A2", "B1", "B2", "C1")

    fun summarize(highestPassedIndex: Int, questions: List<PlacementQuestionResult>, correctIndices: Set<Int>): PlacementSummary {
        val total = questions.size
        val correct = correctIndices.count { it in questions.indices }
        val skillMastery = Skill.values().mapNotNull { skill ->
            val indices = questions.indices.filter { questions[it].skill == skill }
            if (indices.isEmpty()) null else {
                skill.name.lowercase(Locale.ROOT) to (indices.count { it in correctIndices } * 100 / indices.size)
            }
        }.toMap()
        return PlacementSummary(
            level = levelOrder[highestPassedIndex.coerceIn(0, levelOrder.lastIndex)],
            accuracyPercent = if (total == 0) 0 else correct * 100 / total,
            skillMastery = skillMastery,
            answered = total,
            correct = correct
        )
    }
}
