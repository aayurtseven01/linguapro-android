package com.linguapro.android

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class ScenarioCurriculumTest {
    private val units get() = CourseCatalog.levels.flatMap { CourseCatalog.units(it) }
    @Test fun everyEnglishUnitHasAnOriginalScenario() {
        val scenarios = ScenarioCurriculum.allScenarios()
        assertEquals(126, scenarios.size)
        assertEquals(units.map { it.id }.toSet(), scenarios.map { it.unitId }.toSet())
        assertEquals(listOf(20, 24, 26, 24, 20, 12), CourseCatalog.levels.map { level -> scenarios.count { it.unitId.startsWith("$level-") } })
        assertEquals(126, scenarios.map { it.passage }.distinct().size)
        assertEquals(126, scenarios.map { it.transferPassage }.distinct().size)
    }
    @Test fun contextualLessonsDeliverEightActivitiesAndAnOpenWritingTask() {
        units.forEach { unit ->
            val scenario = ScenarioCurriculum.allScenarios().single { it.unitId == unit.id }
            val lesson = unit.lessons[1]
            assertEquals(8, lesson.exercises.size)
            assertTrue(lesson.title.endsWith("Bağlamda uygulama"))
            assertEquals(8, lesson.exercises.map { it.id }.distinct().size)
            val listening = lesson.exercises.single { it.id.endsWith("-listen") }
            assertEquals(Skill.LISTENING, listening.skill)
            assertEquals(scenario.passage, listening.modelAudioText)
            assertTrue(listening.context.isEmpty())
            assertEquals(scenario.passage, lesson.exercises.single { it.id.endsWith("-read") }.context)
            val writing = lesson.exercises.single { it.skill == Skill.WRITING }
            assertEquals(scenario.passage, writing.context)
            assertTrue(writing.options.isEmpty())
            assertTrue(writing.explanationTr.contains("otomatik puanlanmaz"))
            assertTrue(writing.prompt.isNotBlank())
        }
    }
    @Test fun allCheckpointsHaveFiveClosedQuestionsAndAnUnseenTransferPassage() {
        var transferred = 0
        units.forEach { unit ->
            val checkpoint = unit.lessons.single { it.id.endsWith("-CP") }
            assertEquals(5, checkpoint.exercises.size)
            assertEquals(unit.id, 5, checkpoint.exercises.map { Triple(it.prompt, it.context + it.modelAudioText.orEmpty(), it.acceptedAnswers) }.distinct().size)
            assertTrue(checkpoint.exercises.all { it.options.size == 3 && it.skill != Skill.WRITING && it.skill != Skill.SPEAKING })
            checkpoint.exercises.forEach { q -> assertEquals(q.id, 1, q.options.count { AnswerChecker.matchesClosed(it, q.acceptedAnswers) }) }
            val teaching = unit.lessons.filterNot { it.id.endsWith("-CP") }.flatMap { it.exercises }.flatMap { listOf(it.context, it.modelAudioText.orEmpty()) }
            val transfer = checkpoint.exercises.filter { it.id.endsWith("-transfer") }
            transfer.forEach { assertFalse(it.id, it.context in teaching); transferred++ }
            assertTrue(checkpoint.exercises.any { (it.modelAudioText ?: it.context).let { text -> text.isNotBlank() && text !in teaching } })
        }
        assertEquals(119, transferred)
    }
    @Test fun authoredQuestionsHaveDistinctChoicesAndPassagesGrowAcrossLevels() {
        val scenarios = ScenarioCurriculum.allScenarios()
        scenarios.forEach { s ->
            assertNotEquals(s.passage, s.transferPassage)
            listOf(s.listening, s.reading, s.transfer).forEach { q ->
                assertTrue(q.prompt.isNotBlank() && q.explanationTr.isNotBlank())
                val exercise = ScenarioCurriculum.question(s.unitId + q.prompt, Skill.READING, q, s.passage)
                assertEquals(3, exercise.options.distinct().size)
                assertEquals(1, exercise.options.count { AnswerChecker.matchesClosed(it, exercise.acceptedAnswers) })
            }
        }
        val medians = CourseCatalog.levels.map { level ->
            val lengths = scenarios.filter { it.unitId.startsWith("$level-") }.map { it.passage.split(Regex("\\s+")).size }.sorted()
            lengths[lengths.size / 2]
        }
        assertTrue(medians.toString(), medians.zipWithNext().all { (a,b) -> b > a })
        File("build/reports/catalog/scenario-coverage.txt").apply {
            parentFile.mkdirs()
            writeText("English units revised: 126\nContextual teaching questions: 252\nNew unseen transfer questions delivered: 119\nPreviously authored unseen checkpoint questions retained: 35\nLevel passage median word counts: $medians\nAll 126 checkpoints contain five closed questions.\nStructural validation does not certify CEFR calibration or expert review.\n")
        }
    }
}
