package com.linguapro.android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class StoryExpansionFlowTest {
    @get:Rule val compose = createComposeRule()

    @Test fun libraryStartsAtTheSelectedLevelAndAllowsChangingLevels() {
        val advanced = StoryCatalog.byId("DE-C2-S2")!!
        val elementary = StoryCatalog.byId("DE-A2-S2")!!
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize()) {
            StoriesListScreen("DE", emptySet(), {}, {}, initialLevel = "C2")
        } } }
        compose.onNodeWithText(advanced.title).assertExists()
        compose.onNodeWithText(elementary.title).assertDoesNotExist()
        compose.onNodeWithText("A2").performScrollTo().performClick()
        compose.onNodeWithText(elementary.title).assertExists()
        compose.onNodeWithText(advanced.title).assertDoesNotExist()
    }

    @Test fun translationsAreOptionalAndAnswersRevealEvidenceFeedback() {
        val story = StoryCatalog.byId("EN-B1-S2")!!
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize()) {
            StoryPlayerScreen(story, soundOn = false, onFinished = { _, _ -> }, onBack = {})
        } } }
        compose.onNodeWithText(story.lines.first().text).assertExists()
        compose.onNodeWithText(story.lines.first().tr).assertDoesNotExist()
        compose.onNodeWithText("Türkçe çevirileri göster").performScrollTo().performClick()
        compose.onNodeWithText(story.lines.first().tr).assertExists()
        repeat(story.lines.size - 1) {
            compose.onNodeWithText("Devam  ▸").performScrollTo().performClick()
        }
        compose.onNodeWithText("Sorulara geç  ▸").performScrollTo().performClick()
        val question = story.questions.first()
        compose.onNodeWithText(question.options[(question.correct + 1) % question.options.size]).performScrollTo().performClick()
        compose.onNodeWithText(question.explanationTr).performScrollTo().assertIsDisplayed()
    }
}
