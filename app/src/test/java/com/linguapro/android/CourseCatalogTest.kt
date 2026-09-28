package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CourseCatalogTest {
    @Test fun hasEveryPlannedLevelInOrder() {
        assertEquals(listOf("A1", "A2", "B1", "B2", "C1"), CourseCatalog.levels)
        CourseCatalog.levels.forEach { assertTrue("$it must have units", CourseCatalog.units(it).isNotEmpty()) }
    }

    @Test fun allSeedLessonsHaveStableUniqueIdsAndActivities() {
        val lessons = CourseCatalog.allLessons()
        assertTrue(lessons.isNotEmpty())
        assertEquals(lessons.size, lessons.map { it.id }.toSet().size)
        val exerciseIds = lessons.flatMap { it.exercises }.map { it.id }
        assertEquals(exerciseIds.size, exerciseIds.toSet().size)
        lessons.forEach { lesson ->
            assertTrue("${lesson.id} needs a can-do outcome", lesson.canDo.isNotBlank())
            assertTrue("${lesson.id} needs activities", lesson.exercises.isNotEmpty())
            lesson.exercises.forEach { exercise ->
                assertTrue(exercise.id.isNotBlank())
                assertTrue(exercise.prompt.isNotBlank())
                assertTrue(exercise.acceptedAnswers.isNotEmpty())
                assertTrue(exercise.acceptedAnswers.all { it.isNotBlank() })
                if (exercise.options.isNotEmpty()) {
                    val optionSet = exercise.options.map(::normalize).toSet()
                    assertTrue("${exercise.id} answer key must match a choice", exercise.acceptedAnswers.any { normalize(it) in optionSet })
                }
            }
        }
    }

    @Test fun courseActivitiesIncludeAllCoreLanguageSkillsAcrossThePath() {
        CourseCatalog.levels.forEach { level ->
            val skills = CourseCatalog.units(level).flatMap { it.lessons }.flatMap { it.exercises }.map { it.skill }.toSet()
            assertTrue("$level should include receptive practice", Skill.LISTENING in skills || Skill.READING in skills)
            assertTrue("$level should include productive practice", Skill.SPEAKING in skills || Skill.WRITING in skills)
            assertTrue("$level should include language form/lexis", Skill.GRAMMAR in skills || Skill.VOCABULARY in skills)
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
