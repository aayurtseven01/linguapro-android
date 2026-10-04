package com.linguapro.android

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asAndroidBitmap
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

    private fun screenshot(name: String) {
        compose.waitForIdle()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val target = File(context.filesDir, "qa-screenshots/$name.png")
        target.parentFile!!.mkdirs()
        target.outputStream().use { compose.onRoot().captureToImage().asAndroidBitmap().compress(Bitmap.CompressFormat.PNG, 100, it) }
    }
}
