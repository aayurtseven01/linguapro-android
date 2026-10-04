package com.linguapro.android

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import com.linguapro.android.data.content.CoursePackValidator

class EditorialCurriculumTest {
    @Test fun everyWorldLanguageHasAnAuthoredIntroductoryScenario() {
        WorldCatalog.languages.filterNot { it.code == "EN" }.forEach { language ->
            val lesson = WorldCatalog.units(language.code, "A1").first().lessons.first()
            assertEquals("${language.code}-A1-U1-L1", lesson.id)
            assertEquals(8, lesson.exercises.size)
            assertEquals(Skill.entries.toSet(), lesson.exercises.map { it.skill }.toSet())
            assertTrue(lesson.exercises.all { it.id.startsWith("world-editorial-") })
            assertTrue(lesson.grammarFocus!!.commonTurkishErrorTr.isNotBlank())
            lesson.exercises.filter { it.options.isNotEmpty() }.forEach { question ->
                assertEquals(1, question.options.count { AnswerChecker.matchesClosed(it, question.acceptedAnswers) })
            }
        }
        val korean = WorldCatalog.units("KO", "A1").first().lessons.first()
        assertTrue(korean.grammarFocus!!.commonTurkishErrorTr.contains("안녕히 계세요"))
        val portuguese = WorldCatalog.units("PT", "A1").first().lessons.first()
        assertTrue(portuguese.grammarFocus!!.explanationTr.contains("Brezilya"))
    }

    @Test fun installedSupplementalPackStillMeetsItsSchemaAfterEditorialRevision() {
        val original = Json { ignoreUnknownKeys = true }.decodeFromString<CourseContentPack>(
            File("src/main/assets/course_content_v1.json").readText())
        val revised = original.copy(units = original.units.map { ContentEditorialPolicy.revise(EditorialCurriculum.revise(it)) })
        assertTrue(CoursePackValidator.errors(revised).joinToString("\n"), CoursePackValidator.errors(revised).isEmpty())
        val twice = revised.copy(units = revised.units.map { ContentEditorialPolicy.revise(it) })
        assertEquals(revised, twice)
    }

    @Test fun revisedLessonsReachLearnersWithStableIdsAndEightActivities() {
        val revised = EditorialCurriculum.revisedLessons()
        assertEquals(15, revised.size)
        revised.forEach { expected ->
            val actual = CourseCatalog.allLessons().single { it.id == expected.id }
            assertEquals(expected.title, actual.title)
            assertEquals(8, actual.exercises.size)
            assertTrue(actual.canDo.endsWith("bilirim."))
            assertNotNull(actual.grammarFocus)
            assertTrue(actual.targetVocabulary.size >= 2)
            assertEquals(Skill.entries.toSet(), actual.exercises.map { it.skill }.toSet())
            val listening = actual.exercises.filter { it.skill == Skill.LISTENING }
            assertEquals(2, listening.size)
            assertEquals(listening[0].modelAudioText, listening[1].modelAudioText)
            assertNotEquals(listening[0].prompt, listening[1].prompt)
            actual.exercises.filter { it.options.isNotEmpty() }.forEach { exercise ->
                assertEquals(1, exercise.options.count { AnswerChecker.matchesClosed(it, exercise.acceptedAnswers) })
            }
        }
        assertEquals(CourseCatalog.levels.toSet(), revised.map { it.id.substringBefore('-') }.toSet())
        val teachingExercises = (CourseCatalog.allLessons() + WorldCatalog.allWorldLessons())
            .filterNot { it.id.endsWith("-CP") }.flatMap { it.exercises }
        val report = File("build/reports/catalog/content-quality.txt")
        report.parentFile.mkdirs()
        report.writeText(buildString {
            appendLine("Rewritten English lessons: ${revised.size}")
            appendLine("New teaching activities: ${revised.sumOf { it.exercises.size }}")
            appendLine("Rewritten world introduction lessons: 9")
            appendLine("New world introduction activities: 72")
            appendLine("New assessment activities: 35")
            appendLine("Legacy vocabulary tasks with explicit meaning: ${teachingExercises.count { it.prompt.startsWith("Anlam:") }}")
            appendLine("Scenario lesson IDs: ${revised.joinToString { it.id }}")
            appendLine("This report verifies structural contracts, not expert language review or CEFR calibration.")
        })
    }

    @Test fun assessmentsUseUnseenPassagesAndOnlyScorableTasks() {
        val ids = listOf("A1-U1", "A1-U2", "A2-U1", "B1-U1", "B2-U1", "C1-U1", "C2-U1")
        ids.forEach { id ->
            val unit = CourseCatalog.units(id.substringBefore('-')).single { it.id == id }
            val assessment = unit.lessons.single { it.id.endsWith("-CP") }
            assertEquals(5, assessment.exercises.size)
            assertTrue(assessment.exercises.all { it.options.size == 3 })
            val teachingPassages = unit.lessons.filterNot { it.id.endsWith("-CP") }
                .flatMap { it.exercises }.flatMap { listOf(it.context, it.modelAudioText.orEmpty()) }.filter { it.isNotBlank() }
            assessment.exercises.forEach { question ->
                assertTrue(question.id.startsWith("editorial-"))
                assertFalse(question.skill == Skill.WRITING)
                val passage = question.modelAudioText ?: question.context
                if (passage.isNotBlank()) assertFalse("$id must test transfer", passage in teachingPassages)
            }
        }
    }

    @Test fun ambiguousVocabularyBlanksNowExposeTheIntendedMeaning() {
        val questions = (CourseCatalog.allLessons() + WorldCatalog.allWorldLessons()).flatMap { it.exercises }
        val affected = questions.filter { it.skill == Skill.VOCABULARY && it.prompt.contains("___") &&
            it.explanationTr.startsWith("Doğru cümle:") && it.explanationTr.contains(" — ") && it.context.isBlank() }
        assertTrue("Expected coverage across legacy language courses", affected.size > 500)
        affected.forEach { assertTrue(it.id, it.prompt.startsWith("Anlam:")) }
        val example = WorldCatalog.units("DE", "A1").flatMap { it.lessons }.flatMap { it.exercises }
            .single { it.id == "dea1u2e4" }
        assertTrue(example.prompt.contains("İki erkek kardeşim var."))
    }

    @Test fun writingModelsAndSpeechContractsRemainHonest() {
        val lessons = CourseCatalog.allLessons() + WorldCatalog.allWorldLessons()
        lessons.flatMap { it.exercises }.filter { it.skill == Skill.WRITING && !it.sampleAnswer.isNullOrBlank() }
            .forEach { assertTrue(it.id, it.sampleAnswer in it.acceptedAnswers) }
        val original = LearningExercise("open-speak", Skill.SPEAKING, "Görüşünü ifade et", "Discuss both options.",
            acceptedAnswers = listOf("Both options have advantages."), explanationTr = "Örnek.",
            modelAudioText = "Both options have advantages.")
        val revised = ContentEditorialPolicy.revise(original)
        assertEquals("Modeli sesli söyle: Both options have advantages.", revised.prompt)
        assertEquals(listOf(revised.modelAudioText), revised.acceptedAnswers)
        assertEquals(revised, ContentEditorialPolicy.revise(revised))
    }
}
