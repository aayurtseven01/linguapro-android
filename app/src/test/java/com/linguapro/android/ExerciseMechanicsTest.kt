package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ExerciseMechanicsTest {

    private fun writing(id: String, answer: String) = LearningExercise(
        id, Skill.WRITING, "Cümleyi yaz", "İngilizcesi: test", "", listOf(), listOf(answer), "açıklama", null, answer
    )

    private fun listening(id: String) = LearningExercise(
        id, Skill.LISTENING, "Dinle", "Cümle ne anlatıyor?", "", listOf("a", "b", "c"), listOf("a"), "açıklama", "The lamp is next to the bed."
    )

    @Test
    fun shortWritingBecomesSentenceBuilderAndTilesAreDeterministic() {
        val exercise = writing("w1", "The lamp is next to the bed.")
        assertTrue(ExerciseMechanics.isSentenceBuilder(exercise))
        val tiles1 = ExerciseMechanics.builderTiles(exercise)
        val tiles2 = ExerciseMechanics.builderTiles(exercise)
        assertEquals(tiles1, tiles2) // aynı egzersiz her açılışta aynı fişler
        assertEquals(ExerciseMechanics.builderTarget(exercise).sorted(), tiles1.sorted()) // fişler = hedef kelimeler
        assertTrue(tiles1 != ExerciseMechanics.builderTarget(exercise)) // hazır çözüm sunulmaz
    }

    @Test
    fun longOrEmptyWritingStaysFreeText() {
        assertFalse(ExerciseMechanics.isSentenceBuilder(writing("w2", "a very long sentence that has far too many words to tile nicely")))
        assertFalse(ExerciseMechanics.isSentenceBuilder(writing("w3", "ok")))
    }

    @Test
    fun dictationSplitsListeningDeterministicallyAndBothVariantsExist() {
        val variants = (1..40).map { ExerciseMechanics.isDictation(listening("lst$it")) }
        assertTrue("dikte varyantı üretilmeli", variants.any { it })
        assertTrue("çoktan seçmeli varyant kalmalı", variants.any { !it })
        assertEquals(ExerciseMechanics.isDictation(listening("lst1")), ExerciseMechanics.isDictation(listening("lst1")))
    }

    @Test
    fun worldWritingExercisesAreBuilderEligible() {
        val builderCount = WorldCatalog.units("DE", "A1").flatMap { it.lessons }.flatMap { it.exercises }
            .count { ExerciseMechanics.isSentenceBuilder(it) }
        assertTrue("Almanca A1'de en az 3 cümle kurma egzersizi olmalı", builderCount >= 3)
    }

    @Test
    fun dictationNeverTargetsNoSpaceScripts() {
        // Hanzi/kana hedeflerde dikte üretilmez: kimlik karması ne olursa olsun çoktan seçmeli kalır
        for (i in 1..12) {
            val zh = LearningExercise("zh$i", Skill.LISTENING, "Dinle", "?", "", listOf("a", "b", "c"), listOf("a"), "", "我喝咖啡。")
            val ja = LearningExercise("ja$i", Skill.LISTENING, "Dinle", "?", "", listOf("a", "b", "c"), listOf("a"), "", "コーヒーを飲みます。")
            assertFalse(ExerciseMechanics.isDictation(zh))
            assertFalse(ExerciseMechanics.isDictation(ja))
        }
        // Korece boşluklu yazar: dikte açık kalır (karma uygun kimlikte true dönebilmeli)
        val koVariants = (1..40).map {
            ExerciseMechanics.isDictation(LearningExercise("ko$it", Skill.LISTENING, "", "", "", listOf(), listOf("x"), "", "커피를 마셔요."))
        }
        assertTrue(koVariants.any { it })
    }

    @Test
    fun russianAndKoreanWritingIsBuilderEligible() {
        for (lang in listOf("RU", "KO")) {
            val count = WorldCatalog.units(lang, "A1").flatMap { it.lessons }.flatMap { it.exercises }
                .count { ExerciseMechanics.isSentenceBuilder(it) }
            assertTrue("$lang A1 fiş dizme egzersizi içermeli (bulunan: $count)", count >= 3)
        }
    }

    @Test
    fun twoWordSentencesAreBuildableAndNeverPreSolved() {
        val exercise = LearningExercise("w2w", Skill.WRITING, "", "", "", listOf(), listOf("Мы пришли."), "", null, "Мы пришли.")
        assertTrue(ExerciseMechanics.isSentenceBuilder(exercise))
        assertTrue(ExerciseMechanics.builderTiles(exercise) != ExerciseMechanics.builderTarget(exercise))
        assertEquals(ExerciseMechanics.builderTarget(exercise).sorted(), ExerciseMechanics.builderTiles(exercise).sorted())
    }
}
