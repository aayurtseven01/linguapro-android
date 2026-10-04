package com.linguapro.android

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.linguapro.android.billing.ProBillingState
import com.linguapro.android.billing.ProScreenContent
import com.linguapro.android.ui.onboarding.PlanScreen
import com.linguapro.android.ui.profile.ProfileScreen
import java.io.File
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductFlowTest {
    @get:Rule val compose = createComposeRule()

    @Test fun learnerChoosesAGoalBeforePlacement() {
        var chosen = "10"
        var started = false
        compose.setContent {
            var plan by remember { mutableStateOf("10") }
            LinguaTheme { Box(Modifier.fillMaxSize().background(BgBottom)) {
                PlanScreen(plan, { plan = it; chosen = it }, {}, { started = true })
            } }
        }
        screenshot("study-plan-top")
        compose.onNodeWithText("Yoğun çalışma").performClick()
        assertEquals("20", chosen)
        compose.onNodeWithText("Seviyemi belirle").performScrollTo().performClick()
        assertEquals(true, started)
        screenshot("study-plan-bottom")
    }

    @Test fun accountRemovalRequiresPasswordAndDoesNotInvokeDeletionUntilConfirmed() {
        var suppliedPassword: String? = null
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize().background(BgBottom)) {
            ProfileScreen("Test Öğrenci", "test@example.test", "A1", 0, LearningProgress(), "test_user", "", {}, {}, {}, {}, {}, { suppliedPassword = it })
        } } }
        compose.onNodeWithText("Hesabı ve verileri sil").performScrollTo().performClick()
        compose.onNodeWithText("Evet, kalıcı olarak sil").assertIsNotEnabled()
        assertEquals(null, suppliedPassword)
        compose.onNodeWithText("Mevcut şifre").performTextInput("test-password")
        screenshot("delete-confirmation")
        compose.onNodeWithText("Evet, kalıcı olarak sil").performClick()
        assertEquals("test-password", suppliedPassword)
    }

    @Test fun unavailableProKeepsFreeLearningAvailableAndCannotStartCheckout() {
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize().background(BgBottom)) {
            ProScreenContent(ProBillingState(message = "Pro yakında. Şimdilik ücretsiz derslerine devam edebilirsin."), {}, {}, { error("Checkout must not be available") }, {})
        } } }
        compose.onNodeWithText("Google Play ile abone ol").assertDoesNotExist()
        screenshot("pro-preview")
        compose.onNodeWithText("Ücretsiz öğrenmeye devam et").performScrollTo().assertIsEnabled()
    }


    @Test fun writingShowsSourceAndCriteriaThenAcceptsAnAlternativeWithoutAFalseScore() {
        val originalLesson = CourseCatalog.units("B1").first().lessons[1]
        val writing = originalLesson.exercises.single { it.skill == Skill.WRITING }
        val lesson = originalLesson.copy(id = "writing-ui-test", exercises = listOf(writing),
            targetVocabulary = emptyList(), grammarFocus = null, stages = emptyList())
        var completed = false
        var completionScore: Int? = 999
        compose.setContent { LinguaTheme { Box(Modifier.fillMaxSize().background(BgBottom)) {
            LearningLessonScreen(lesson, 0, {}, { _, _, _ -> error("Open writing must not be scored") },
                { score, _ -> completionScore = score; completed = true })
        } } }
        compose.onNodeWithText(writing.context).assertExists()
        compose.onNodeWithText("• ${writing.writingRequirements!!.checklistTr.first()}").performScrollTo().assertIsDisplayed()
        compose.onNodeWithText("Örnek yanıt: ${writing.sampleAnswer}").assertDoesNotExist()
        val answer = "The customer asked for changes near the deadline. The team explained the extra time needed and agreed to show the design first. The working website would follow on Monday. Sending an email afterwards helped everyone understand the agreement and avoided promising a final delivery on Friday."
        compose.onNode(hasSetTextAction()).performScrollTo().performTextInput(answer)
        compose.onNodeWithText("Kelime sayısı: ${answer.split(Regex("\\s+")).size} • Hedef: 40–60").assertExists()
        screenshot("writing-task")
        compose.onNodeWithText("Yanıtı kontrol et").performScrollTo().performClick()
        compose.onNodeWithText("Yanıtın kaydedildi").performScrollTo().assertIsDisplayed()
        compose.onNodeWithText("Örnek yanıt: ${writing.sampleAnswer}").assertExists()
        compose.onNodeWithText("Dersi tamamla").performScrollTo().performClick()
        compose.onNodeWithText("Öğrenme yoluma dön").performScrollTo().performClick()
        assertEquals(true, completed)
        org.junit.Assert.assertNull(completionScore)
    }

    private fun screenshot(name: String) {
        // PixelCopy-backed capture is reliable on API 26+. API 24 still runs all behavior checks.
        if (Build.VERSION.SDK_INT < 26) return
        compose.waitForIdle()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val target = File(context.filesDir, "qa-screenshots/$name.png")
        target.parentFile!!.mkdirs()
        val bitmap = if (name == "delete-confirmation") {
            // Dialog owns a separate Window; root PixelCopy can capture the underlying Activity.
            compose.onNodeWithText("Hesap silinsin mi?").assertIsDisplayed()
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().uiAutomation.takeScreenshot()
        } else compose.onRoot().captureToImage().asAndroidBitmap()
        target.outputStream().use { bitmap.compress(Bitmap.CompressFormat.PNG, 100, it) }
    }
}
