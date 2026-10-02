package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DailyWordsTest {

    private val allLangs = listOf("EN", "DE", "FR", "ES", "PT", "IT", "RU", "ZH", "JA", "KO")

    @Test
    fun everyLanguageHasALargeEnoughWordPool() {
        allLangs.forEach { lang ->
            assertTrue("$lang havuzu en az 100 kelime olmalı", DailyWords.pool(lang).size >= 100)
        }
    }

    @Test
    fun givesFiveDifferentWordsOnConsecutiveDays() {
        allLangs.forEach { lang ->
            val slots = DailyWords.pool(lang).size / 5
            // Aynı döngü içinde ardışık iki gün seç
            val day = (20_000L / slots) * slots
            val today = DailyWords.wordsFor(lang, day)
            val tomorrow = DailyWords.wordsFor(lang, day + 1)
            assertEquals(5, today.size)
            assertEquals(5, tomorrow.size)
            assertTrue(
                "$lang: ardışık günlerin kelimeleri farklı olmalı",
                today.map { it.id }.intersect(tomorrow.map { it.id }.toSet()).isEmpty()
            )
        }
    }

    @Test
    fun selectionIsDeterministic() {
        assertEquals(DailyWords.wordsFor("FR", 20_005L), DailyWords.wordsFor("FR", 20_005L))
        assertEquals(DailyWords.lessonFor("JA", 20_005L).exercises.map { it.id }, DailyWords.lessonFor("JA", 20_005L).exercises.map { it.id })
    }

    @Test
    fun lessonHasTenValidQuestionsAndVocabularyPreview() {
        allLangs.forEach { lang ->
            val lesson = DailyWords.lessonFor(lang, 20_010L)
            assertEquals("$lang-WORDS", lesson.id)
            assertEquals("$lang günlük kelime dersi 10 soru olmalı", 10, lesson.exercises.size)
            assertEquals("$lang ön-izleme 5 kelime kartı taşımalı", 5, lesson.targetVocabulary.size)
            lesson.exercises.forEach { exercise ->
                assertEquals("${exercise.id}: 3 benzersiz seçenek", 3, exercise.options.toSet().size)
                assertTrue("${exercise.id}: cevap seçeneklerde olmalı", exercise.options.contains(exercise.acceptedAnswers.first()))
            }
        }
    }

    @Test
    fun reviewQuestionsComeFromYesterdaysWords() {
        val yesterdayTerms = DailyWords.wordsFor("DE", 20_019L).map { it.termEn }.toSet()
        val lesson = DailyWords.lessonFor("DE", 20_020L)
        val reviewAnswers = lesson.exercises.filter { it.id.contains("-r") }.map { it.acceptedAnswers.first() }.toSet()
        assertEquals("Tekrar soruları dünün kelimelerinden gelmeli", yesterdayTerms, reviewAnswers)
    }
}
