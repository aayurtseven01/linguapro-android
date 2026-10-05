package com.linguapro.android

import org.junit.Assert.*
import org.junit.Test

class PersonalizedPracticeTest {
    @Test fun recentQuestionsRotateButMistakesKeepTheirPriority() {
        val lessons = WorldCatalog.units("EN", "A1").flatMap { it.lessons }
        val first = PersonalizedPractice.build("EN", "A1", lessons, emptySet(), emptyMap())
        val recent = first.exercises.map { it.id }.toSet()
        val next = PersonalizedPractice.build("EN", "A1", lessons, emptySet(), emptyMap(), recentExerciseIds = recent, sessionSeed = 1)
        assertTrue(next.exercises.none { it.id in recent })
        assertEquals(next, PersonalizedPractice.build("EN", "A1", lessons, emptySet(), emptyMap(), recentExerciseIds = recent, sessionSeed = 1))
        val mistake = first.exercises.first().id
        val retry = PersonalizedPractice.build("EN", "A1", lessons, setOf(mistake), emptyMap(), recentExerciseIds = recent, sessionSeed = 2)
        assertEquals(mistake, retry.exercises.first().id)
        assertEquals(8, retry.exercises.map { it.id }.toSet().size)
    }

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

