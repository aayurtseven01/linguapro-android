package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DailyWordsTest {

    private val allLangs = listOf("EN", "DE", "FR", "ES", "PT", "IT", "RU", "ZH", "JA", "KO")

    @Test
    fun everyLanguageHasALargeEnoughWordPool() {
        allLangs.forEach { lang ->
            val pool = DailyWords.pool(lang)
            assertTrue("$lang havuzu en az 230 kelime olmalı (müfredat + sınav bankası)", pool.size >= 230)
            assertEquals("$lang havuzunda kelime tekrarı olmamalı", pool.size, pool.map { it.termEn.lowercase() }.toSet().size)
        }
    }

    @Test
    fun examBankEntriesCarryOfficialTierLabels() {
        val expected = mapOf(
            "DE" to listOf("Goethe"), "FR" to listOf("DELF", "DALF"), "ES" to listOf("DELE"),
            "PT" to listOf("CAPLE"), "IT" to listOf("CILS"), "RU" to listOf("TORFL"),
            "ZH" to listOf("HSK"), "JA" to listOf("JLPT"), "KO" to listOf("TOPIK"), "EN" to listOf("Oxford")
        )
        expected.forEach { (lang, labels) ->
            val bank = ExamVocabulary.bank(lang)
            assertTrue("$lang sınav bankası en az 100 kelime olmalı", bank.size >= 100)
            assertTrue(
                "$lang kademe etiketi ${labels.joinToString("/")} içermeli",
                bank.all { word -> labels.any { word.partOfSpeech.contains(it) } }
            )
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
