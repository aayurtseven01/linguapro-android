package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Test

class PlacementAssessmentTest {
    @Test fun `reports level and skill accuracy for answered questions`() {
        val questions = listOf(
            PlacementQuestionResult("A1", Skill.GRAMMAR),
            PlacementQuestionResult("A1", Skill.READING),
            PlacementQuestionResult("A2", Skill.GRAMMAR)
        )
        val result = PlacementAssessment.summarize(1, questions, setOf(0, 2))
        assertEquals("A2", result.level)
        assertEquals(66, result.accuracyPercent)
        assertEquals(100, result.skillMastery["grammar"])
        assertEquals(0, result.skillMastery["reading"])
        assertEquals(3, result.answered)
        assertEquals(2, result.correct)
    }

    @Test fun `an unanswered assessment defaults conservatively to A1`() {
        val result = PlacementAssessment.summarize(-1, emptyList(), emptySet())
        assertEquals("A1", result.level)
        assertEquals(0, result.accuracyPercent)
        assertEquals(emptyMap<String, Int>(), result.skillMastery)
    }
}
