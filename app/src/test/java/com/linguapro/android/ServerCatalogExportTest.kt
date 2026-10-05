package com.linguapro.android

import java.io.File
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import kotlinx.serialization.decodeFromString
import org.junit.Test

/** The server's reward allowlist must follow the actual authored course ids. */
class ServerCatalogExportTest {
    private val packJson = Json { ignoreUnknownKeys = true }
    @Test fun exportCanonicalLessonIds() {
        val pack = packJson.decodeFromString<CourseContentPack>(File("src/main/assets/course_content_v1.json").readText())
        val ids = (CourseCatalog.allLessons() + WorldCatalog.allWorldLessons() + pack.units.flatMap { it.lessons }).map { it.id }.distinct().sorted()
        assertTrue(ids.isNotEmpty())
        val folder = File("build/reports/catalog").apply { mkdirs() }
        File(folder, "lesson-ids.json").writeText(Json.encodeToString(ids))
        val serverFile = File("../functions/src/course-ids.json")
        assertTrue("Server reward allowlist must exist", serverFile.isFile)
        assertEquals("Course changes must update the server allowlist", ids, Json.decodeFromString<List<String>>(serverFile.readText()))
    }
}
