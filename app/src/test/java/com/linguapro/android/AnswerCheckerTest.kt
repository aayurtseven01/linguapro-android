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

    @Test
    fun acceptsExactChineseAfterPunctuationNormalization() {
        assertTrue(AnswerChecker.matches("我喝咖啡", listOf("我喝咖啡。")))
    }

    @Test
    fun acceptsMinorCjkSpeechVariation() {
        assertTrue(AnswerChecker.matches("我喝咖啡了", listOf("我喝咖啡。")))
    }

    @Test
    fun rejectsDifferentCjkSentence() {
        assertFalse(AnswerChecker.matches("今天天气很好", listOf("我喝咖啡。")))
    }

    @Test
    fun cjkSimilarityDoesNotWeakenEnglishChecks() {
        assertFalse(AnswerChecker.matches("yellow", listOf("hello")))
    }

    @Test
    fun rejectsNegationMismatch() {
        assertFalse(AnswerChecker.matches("I am not from Turkey", listOf("I am from Turkey.")))
        assertFalse(AnswerChecker.matches("I am from Turkey", listOf("I am not from Turkey.")))
        assertFalse(AnswerChecker.matches("Ich trinke keinen Kaffee", listOf("Ich trinke Kaffee.")))
    }

    @Test
    fun rejectsScrambledWordOrder() {
        assertFalse(AnswerChecker.matches("Turkey from am I", listOf("I am from Turkey.")))
    }

    @Test
    fun stillAcceptsSmallSpeechOmissions() {
        // Konusma tanima kucuk kelime dusurebilir; sira korunuyorsa kabul edilir.
        assertTrue(AnswerChecker.matches("We buy fruit at market", listOf("We buy fruit at the market.")))
    }
}
