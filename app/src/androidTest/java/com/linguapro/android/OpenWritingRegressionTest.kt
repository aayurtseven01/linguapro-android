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
