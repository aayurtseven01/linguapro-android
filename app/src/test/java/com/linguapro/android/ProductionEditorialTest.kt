package com.linguapro.android

import java.io.File
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Assert.*
import org.junit.Test

class ProductionEditorialTest {
    @Test fun everyScenarioHasATaskSizedOriginalWritingModel() {
        val scenarios = ScenarioCurriculum.allScenarios()
        assertEquals(scenarios.map { it.unitId }.toSet(), WritingModels.all().keys)
        scenarios.forEach { scenario ->
            val level = scenario.unitId.substringBefore('-')
            val writing = CourseCatalog.units(level).single { it.id == scenario.unitId }.lessons[1].exercises.single { it.skill == Skill.WRITING }
            val model = writing.sampleAnswer!!
            assertEquals(WritingModels.forUnit(scenario.unitId), model)
            assertNotEquals("${scenario.unitId}: source text is not a response model", scenario.passage, model)
            assertEquals(scenario.passage, writing.context)
            assertTrue(model in writing.acceptedAnswers)
            val requirements = writing.writingRequirements!!
            assertEquals(3, requirements.checklistTr.size)
            val count = model.split(Regex("\\s+")).size
            requirements.minimumWords?.let { assertTrue("${scenario.unitId}: $count", count >= it) }
            requirements.maximumWords?.let { assertTrue("${scenario.unitId}: $count", count <= it) }
            val sentenceCount = model.split(Regex("(?<=[.!?])\\s+")).size
            if (level == "A1") assertEquals(scenario.unitId, 2, sentenceCount)
            if (level == "A2") assertTrue("${scenario.unitId}: $sentenceCount", sentenceCount in 3..4)
        }
    }

    @Test fun wordLessonsTeachContextThenRequireRecallWithoutShowingTheAnswer() {
        val units = CourseCatalog.levels.flatMap { CourseCatalog.units(it) }
        val lessons = units.flatMap { it.lessons }.filter { lesson -> lesson.exercises.any { it.id.matches(Regex("[abc][12]v[0-9]+e[0-9]+-recall")) } }
        assertEquals(66, lessons.size)
        var recalled = 0
        lessons.forEach { lesson ->
            val tasks = lesson.exercises.filter { it.id.endsWith("-recall") }
            assertEquals(3, tasks.size)
            assertTrue(lesson.targetVocabulary.size >= 3)
            tasks.forEach { task ->
                recalled++
                assertTrue(task.options.isEmpty() && task.context.isEmpty())
                val word = lesson.targetVocabulary.single { it.id.removeSuffix("-word") + "-recall" == task.id }
                assertFalse("The persistent learning outcome must not reveal the recall answer", lesson.canDo.contains(word.termEn, ignoreCase = true))
                assertTrue(AnswerChecker.matchesClosed(word.termEn, task.acceptedAnswers))
                val introduced = lesson.exercises.single { it.id == task.id.removeSuffix("-recall") }
                assertEquals(word.exampleEn, introduced.context)
                assertTrue(word.exampleTr.isNotBlank())
            }
        }
        assertEquals(198, recalled)
        val enrol = lessons.flatMap { it.exercises }.single { it.id == "b1v17e1-recall" }
        assertTrue(AnswerChecker.matchesClosed("enroll", enrol.acceptedAnswers))
        assertFalse(AnswerChecker.matchesClosed("leave", enrol.acceptedAnswers))
    }

    @Test fun repeatedEditorialApplicationDoesNotDuplicateExercisesOrVocabulary() {
        val once = EnglishLessonEditorial.revise(CourseVolumeC2.units.first())
        assertEquals(once, EnglishLessonEditorial.revise(once))
        assertEquals(once.lessons.flatMap { it.exercises }.size, once.lessons.flatMap { it.exercises }.map { it.id }.distinct().size)
    }

    @Test fun correctedInversionKeepsTheSubjectBetweenAuxiliaryAndParticiple() {
        val exercise = CourseCatalog.allLessons().flatMap { it.exercises }.single { it.id == "c2v11e7" }
        assertEquals("Seldom is a correction placed as prominently as the original error.", exercise.prompt.replace("___", exercise.acceptedAnswers.single()))
        assertFalse(AnswerChecker.matchesClosed("is placed a correction", exercise.acceptedAnswers))
        val prohibition = CourseCatalog.allLessons().flatMap { it.exercises }.single { it.id == "c2v2e7" }
        assertEquals("Under no circumstances should the terms be disclosed.", prohibition.prompt.replace("___", prohibition.acceptedAnswers.single()))
    }

    @Test fun writingLengthFeedbackSupportsTheTaskWithoutScoringMeaning() {
        val requirements = WritingModels.requirements("B1")
        val short = WritingCoach.review("I agree.", "", requirements)
        assertEquals(2, short.wordCount)
        assertTrue(short.suggestions.any { it.contains("en az 40") })
        val long = WritingCoach.review(List(61) { "word" }.joinToString(" ") + ".", "", requirements)
        assertTrue(long.suggestions.any { it.contains("en fazla 60") })
        val model = WritingModels.forUnit("B1-U1")
        assertFalse(WritingCoach.review(model, model, requirements).suggestions.any { it.contains("Görev en") })
    }

    @Test fun correctBaseVerbsAfterDoesNotAreNotFalselyFlagged() {
        listOf("She doesn't pass the test.", "He doesn't miss the bus.", "She doesn't discuss the result.").forEach {
            assertFalse(it, WritingCoach.review(it).suggestions.any { tip -> tip.contains("Doesn't") })
        }
        assertTrue(WritingCoach.review("She doesn’t goes there.").suggestions.any { it.contains("Doesn't") })
    }

    @Test fun nonLatinWritingDoesNotMatchAnUnrelatedModelAndAcceptsItsPunctuation() {
        assertFalse(WritingCoach.review("再见。", "你好。").strengths.any { it.contains("örtüşüyor") })
        val same = WritingCoach.review("你好。", "你好。")
        assertTrue(same.strengths.any { it.contains("örtüşüyor") })
        assertFalse(same.suggestions.any { it.contains("noktalama") })
        assertTrue(WritingCoach.review("Cafe\u0301.", "Café.").strengths.any { it.contains("örtüşüyor") })
    }

    @Test fun supplementalGrammarPromptsRemainAlignedAndAuditExportsAllEnglishLessons() {
        val pack = Json { ignoreUnknownKeys = true }.decodeFromString<CourseContentPack>(File("src/main/assets/course_content_v1.json").readText())
        pack.units.flatMap { it.lessons }.forEach { lesson ->
            val task = lesson.exercises.single { it.skill == Skill.GRAMMAR }
            val grammar = lesson.grammarFocus!!
            assertEquals(grammar.checkPromptTr, task.prompt)
            assertTrue(grammar.correctAnswer in task.acceptedAnswers)
        }
        val all = CourseCatalog.allLessons() + pack.units.flatMap { it.lessons }
        val folder = File("build/reports/catalog").apply { mkdirs() }
        File(folder, "english-lesson-audit.json").writeText(Json { prettyPrint = true }.encodeToString(all))
        File(folder, "production-editorial.txt").writeText(buildString {
            appendLine("English lessons exported for editorial review (including checkpoints and supplemental pack): ${all.size}")
            appendLine("Independent task-sized writing models and checklists: ${WritingModels.all().size}")
            appendLine("Word lessons with context and controlled recall: 66")
            appendLine("New controlled recall tasks: 198")
            appendLine("Core target vocabulary records: ${CourseCatalog.allLessons().sumOf { it.targetVocabulary.size }}")
            appendLine("Models are examples, not unique answers. Writing length checks do not grade meaning or CEFR proficiency.")
        })
    }
}
