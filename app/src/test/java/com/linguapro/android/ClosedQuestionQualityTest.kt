package com.linguapro.android

import java.io.File
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertTrue
import org.junit.Test

class ClosedQuestionQualityTest {
    private val packJson = Json { ignoreUnknownKeys = true }
    @Test fun everyClosedQuestionHasExactlyOneAcceptedChoice() {
        val pack = packJson.decodeFromString<CourseContentPack>(File("src/main/assets/course_content_v1.json").readText())
        val lessons = CourseCatalog.allLessons() + WorldCatalog.allWorldLessons() + pack.units.flatMap { it.lessons }
        val problems = lessons.flatMap { it.exercises }.filter { it.options.isNotEmpty() }.mapNotNull { exercise ->
            val correctChoices = exercise.options.count { AnswerChecker.matchesClosed(it, exercise.acceptedAnswers) }
            if (correctChoices != 1) "${exercise.id}: $correctChoices accepted choices" else null
        }
        assertTrue(problems.take(30).joinToString("\n"), problems.isEmpty())
    }
}
