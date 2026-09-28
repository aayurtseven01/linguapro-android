package com.linguapro.android

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AnswerCheckerTest {
    @Test fun acceptsCaseAndPunctuationDifferences() {
        assertTrue(AnswerChecker.matches("hello, I'm Anna!", listOf("Hello I'm Anna")))
    }

    @Test fun acceptsTypicalSpeechRecognizerContractionVariant() {
        assertTrue(AnswerChecker.matches("Hello im Mehmet", listOf("Hello, I'm Mehmet.")))
    }

    @Test fun acceptsVerySmallSpeechRecognitionVariationButNotUnrelatedText() {
        assertTrue(AnswerChecker.matches("Would you be open to moving the deadline to Friday", listOf("Would you be open to moving the deadline to Friday?")))
        assertFalse(AnswerChecker.matches("I like apples", listOf("Would you be open to moving the deadline to Friday?")))
    }

    @Test fun rejectsBlankInput() {
        assertFalse(AnswerChecker.matches("   ", listOf("hello")))
    }
}
