package com.linguapro.android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class OpenWritingRegressionTest {
    @get:Rule val compose = createComposeRule()
    @Test fun typedModelRepetitionDoesNotCreateSpeakingEvidence() {
        val source = CourseCatalog.units("A1").first().lessons.first()
        val item = source.exercises.first { it.skill == Skill.SPEAKING && it.options.isEmpty() }
        val lesson = source.copy(exercises = listOf(item), targetVocabulary = emptyList(), grammarFocus = null, stages = emptyList())
        var measured: Skill? = null
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize()) {
            LearningLessonScreen(lesson, 0, {}, { _, skill, _ -> measured = skill }, { _, _ -> })
        } } }
        compose.onNode(hasSetTextAction()).performScrollTo().performTextInput(item.acceptedAnswers.first())
        compose.onNodeWithText("Yanıtı kontrol et").performScrollTo().performClick()
        compose.runOnIdle { org.junit.Assert.assertEquals(Skill.WRITING, measured) }
    }

    @Test fun mutedListeningFallbackRecordsReadingInsteadOfListening() {
        val context = androidx.test.core.app.ApplicationProvider.getApplicationContext<android.content.Context>()
        val prefs = context.getSharedPreferences("lingua_course", android.content.Context.MODE_PRIVATE)
        val previous = prefs.getBoolean("sound_on", true)
        prefs.edit().putBoolean("sound_on", false).commit()
        try {
            val source = CourseCatalog.units("A1").first().lessons.first()
            val item = source.exercises.first { it.skill == Skill.LISTENING }
            val lesson = source.copy(exercises = listOf(item), targetVocabulary = emptyList(), grammarFocus = null, stages = emptyList())
            var measured: Skill? = null
            compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize()) {
                LearningLessonScreen(lesson, 0, {}, { _, skill, _ -> measured = skill }, { _, _ -> })
            } } }
            compose.onNodeWithText(item.acceptedAnswers.first()).performScrollTo().performClick()
            compose.onNodeWithText("Yanıtı kontrol et").performScrollTo().performClick()
            compose.runOnIdle { org.junit.Assert.assertEquals(Skill.READING, measured) }
        } finally { prefs.edit().putBoolean("sound_on", previous).commit() }
    }

    @Test fun incompleteWritingStaysEditableAndIsNotScored() {
        val source = CourseCatalog.units("A1").first().lessons[1]
        val writing = source.exercises.first { it.skill == Skill.WRITING }.copy(
            options = emptyList(), writingRequirements = WritingRequirements(emptyList(), 4, 12)
        )
        val lesson = source.copy(exercises = listOf(writing), targetVocabulary = emptyList(), grammarFocus = null, stages = emptyList())
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize()) {
            LearningLessonScreen(lesson, 0, {}, { _, _, _ -> error("Open writing must not be scored") }, { _, _ -> })
        } } }
        compose.onNode(hasSetTextAction()).performScrollTo().performTextInput("a")
        compose.onNodeWithText("Yanıtı kontrol et").performScrollTo().performClick()
        compose.onNodeWithText("Yanıtın kaydedildi").assertDoesNotExist()
        compose.onNode(hasSetTextAction()).performScrollTo().performTextReplacement("I come from Türkiye.")
        compose.onNodeWithText("Yanıtı kontrol et").performScrollTo().performClick()
        compose.onNodeWithText("Yanıtın kaydedildi").performScrollTo().assertIsDisplayed()
    }

    @Test fun allThreeShortScenarioTasksAcceptIndependentAnswersWithoutScoring() {
        fun lesson(id: String): LearningLesson {
            val source = CourseCatalog.units("A1").single { it.id == id }.lessons[1]
            return source.copy(exercises = source.exercises.filter { it.skill == Skill.WRITING },
                targetVocabulary = emptyList(), grammarFocus = null, stages = emptyList())
        }
        var current by mutableStateOf(lesson("A1-U1"))
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize()) {
            LearningLessonScreen(current, 0, {}, { _, _, _ -> error("Open production must not be scored") }, { _, _ -> })
        } } }
        listOf(
            "A1-U1" to "Omar comes from Türkiye. Nina comes from Spain.",
            "A1-U10" to "Their friend brings them water. The person feels tired.",
            "A1-U20" to "The season is winter. It is sunny today."
        ).forEach { (id, answer) ->
            compose.runOnIdle { current = lesson(id) }
            compose.onNode(hasSetTextAction()).performScrollTo().performTextInput(answer)
            compose.onNodeWithText("Yanıtı kontrol et").performScrollTo().performClick()
            compose.onNodeWithText("Yanıtın kaydedildi").performScrollTo().assertIsDisplayed()
        }
    }
}

