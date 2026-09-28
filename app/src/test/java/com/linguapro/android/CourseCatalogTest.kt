package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CourseCatalogTest {
    @Test fun hasEveryPlannedLevelInOrder() {
        assertEquals(listOf("A1", "A2", "B1", "B2", "C1"), CourseCatalog.levels)
        CourseCatalog.levels.forEach { assertEquals(12, CourseCatalog.units(it).size) }
        assertEquals(25, CourseCatalog.lessonCount("A1"))
        listOf("A2", "B1", "B2", "C1").forEach { assertEquals(24, CourseCatalog.lessonCount(it)) }
        assertEquals(121, CourseCatalog.allLessons().size)
    }

    @Test fun allSeedLessonsHaveStableUniqueIdsAndActivities() {
        val lessons = CourseCatalog.allLessons()
        assertTrue(lessons.isNotEmpty())
        assertEquals(lessons.size, lessons.map { it.id }.toSet().size)
        val exerciseIds = lessons.flatMap { it.exercises }.map { it.id }
        assertEquals(exerciseIds.size, exerciseIds.toSet().size)
        lessons.forEach { lesson ->
            assertTrue("${lesson.id} needs a can-do outcome", lesson.canDo.isNotBlank())
            assertTrue("${lesson.id} should have at least two varied activities", lesson.exercises.size >= 2)
            lesson.exercises.forEach { exercise ->
                assertTrue(exercise.id.isNotBlank())
                assertTrue(exercise.prompt.isNotBlank())
                assertTrue(exercise.acceptedAnswers.isNotEmpty())
                assertTrue(exercise.acceptedAnswers.all { it.isNotBlank() })
                if (exercise.options.isNotEmpty()) {
                    val optionSet = exercise.options.map(::normalize).toSet()
                    assertTrue("${exercise.id} answer key must match a choice", exercise.acceptedAnswers.any { normalize(it) in optionSet })
                }
                if (exercise.skill == Skill.LISTENING || exercise.skill == Skill.SPEAKING) {
                    assertFalse("${exercise.id} needs an audio model", exercise.modelAudioText.isNullOrBlank())
                }
                if (exercise.skill == Skill.READING) assertFalse("${exercise.id} needs a reading passage", exercise.context.isBlank())
                if (exercise.skill == Skill.WRITING) assertFalse("${exercise.id} needs a model response", exercise.sampleAnswer.isNullOrBlank())
            }
        }
    }

    @Test fun courseActivitiesIncludeEveryCoreSkillAtEachLevel() {
        CourseCatalog.levels.forEach { level ->
            val units = CourseCatalog.units(level)
            val skills = units.flatMap { it.lessons }.flatMap { it.exercises }.map { it.skill }.toSet()
            Skill.values().forEach { skill -> assertTrue("$level needs $skill activities", skill in skills) }
            units.forEach { unit ->
                val exerciseCount = unit.lessons.sumOf { it.exercises.size }
                assertTrue("${unit.id} needs multiple practice moments", exerciseCount >= 4)
            }
        }
    }

    @Test fun lessonPointerWrapsOnlyAtCourseBoundary() {
        CourseCatalog.levels.forEach { level ->
            val count = CourseCatalog.lessonCount(level)
            assertTrue(count > 0)
            assertEquals(CourseCatalog.lessonAt(level, 0).id, CourseCatalog.lessonAt(level, count).id)
        }
    }

    private fun normalize(value: String) = value.lowercase().replace(Regex("[^a-z0-9]+"), " ").trim()
}
