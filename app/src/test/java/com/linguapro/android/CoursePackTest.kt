package com.linguapro.android

import com.linguapro.android.data.content.CoursePackValidator
import java.io.File
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CoursePackTest {
    private val packJson = Json { ignoreUnknownKeys = true }
    @Test
    fun packagedContentIsValidAndCoversTwoCompleteLessonsAtEveryLevel() {
        val asset = File("src/main/assets/course_content_v1.json")
        assertTrue("Course JSON asset must exist", asset.isFile)
        val pack = packJson.decodeFromString<CourseContentPack>(asset.readText())

        assertTrue(CoursePackValidator.errors(pack).joinToString("\n"), CoursePackValidator.errors(pack).isEmpty())
        val lessonsByLevel = pack.units.flatMap { unit ->
            unit.lessons.map { unit.id.substringBefore('-') to it }
        }.groupBy({ it.first }, { it.second })
        assertEquals(setOf("A1", "A2", "B1", "B2", "C1", "C2"), lessonsByLevel.keys)
        lessonsByLevel.values.forEach { lessons ->
            assertEquals(2, lessons.size)
            lessons.forEach { lesson ->
                assertEquals(8, lesson.targetVocabulary.size)
                assertEquals(6, lesson.stages.size)
                assertEquals(6, lesson.exercises.size)
            }
        }
    }
}
