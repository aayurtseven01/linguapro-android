package com.linguapro.android

import org.junit.Assert.*
import org.junit.Test

class EditorialCurriculumTest {
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
