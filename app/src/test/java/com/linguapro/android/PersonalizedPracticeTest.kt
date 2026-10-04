package com.linguapro.android

import org.junit.Assert.*
import org.junit.Test

class PersonalizedPracticeTest {
    @Test fun sessionPrioritizesMistakesWithoutDuplicatingExercises() {
        val lessons = WorldCatalog.units("EN", "A1").flatMap { it.lessons }
        val mistake = lessons.flatMap { it.exercises }.last()
        val session = PersonalizedPractice.build("EN", "A1", lessons, setOf(mistake.id), emptyMap())
        assertEquals("EN-A1-PRO", session.id)
        assertEquals(mistake.id, session.exercises.first().id)
        assertEquals(8, session.exercises.size)
        assertEquals(session.exercises.size, session.exercises.distinctBy { it.id }.size)
        assertTrue(session.exercises.map { it.skill }.distinct().size >= 4)
    }

    @Test fun everyLanguageUsesItsOwnAuthoredQuestions() {
        WorldCatalog.languages.forEach { language ->
            val lessons = WorldCatalog.units(language.code, "A1").flatMap { it.lessons }
            val session = PersonalizedPractice.build(language.code, "A1", lessons, emptySet(), mapOf(Skill.LISTENING to SkillTally(10, 2)))
            assertTrue(session.exercises.isNotEmpty())
            assertTrue(session.exercises.all { selected -> lessons.any { l -> l.exercises.any { it.id == selected.id } } })
        }
    }
}
