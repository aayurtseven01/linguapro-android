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
}
