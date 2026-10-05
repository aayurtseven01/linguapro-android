package com.linguapro.android

import kotlin.math.abs

/**
 * Duolingo tarzı ders içi mekanik seçimi. Mekanikler mevcut içerikten DETERMİNİSTİK
 * olarak türetilir: içerik modeli ve kurs dosyaları değişmez, her egzersiz her
 * açılışta aynı mekanikle oynanır.
 *
 * - Cümle kurma (fiş dizme): kısa yazma hedefleri (2-8 kelime) serbest metin yerine
 *   karıştırılmış kelime fişlerinin doğru SIRAYLA dizilmesiyle oynanır ve otomatik puanlanır.
 * - Duyduğunu yaz: dinleme sorularının yarısı çoktan seçmeli yerine dikte olarak oynanır.
 */
object ExerciseMechanics {

    /** Kısa yazma hedefleri fiş dizme (cümle kurma) olarak oynanır. */
    fun isSentenceBuilder(exercise: LearningExercise): Boolean {
        if (exercise.skill != Skill.WRITING || exercise.options.isNotEmpty() || exercise.writingRequirements != null) return false
        return builderTarget(exercise).size in 2..8
    }

    /** Hedef cümlenin kelime dizisi (fişlerin doğru sırası). */
    fun builderTarget(exercise: LearningExercise): List<String> =
        exercise.acceptedAnswers.firstOrNull().orEmpty().trim()
            .split(" ").filter { it.isNotBlank() }

    /** Fişler: hedef kelimeler, egzersiz kimliğiyle tohumlanmış SABİT karışıklıkta. */
    fun builderTiles(exercise: LearningExercise): List<String> {
        val target = builderTarget(exercise)
        val shuffled = target.shuffled(kotlin.random.Random(exercise.id.hashCode().toLong()))
        // Karışık dizilim hedefle aynı çıkarsa (kısa cümlelerde olabilir) bir adım döndür.
        return if (shuffled == target && target.size > 1) shuffled.drop(1) + shuffled.first() else shuffled
    }

    /** Boşluksuz yazı (hanzi/kana): dikte IME gerektirir, bu hedeflerde dikte üretilmez. */
    private fun hasNoSpaceScript(text: String): Boolean =
        text.any { it in '\u4e00'..'\u9fff' || it in '\u3040'..'\u30ff' }

    /**
     * Dinleme sorularının yaklaşık yarısı "duyduğunu yaz" (dikte) olarak oynanır.
     * Çince/Japonca hedefler hariç: bu dillerde soru çoktan seçmeli kalır (IME bariyeri).
     */
    fun isDictation(exercise: LearningExercise): Boolean =
        exercise.skill == Skill.LISTENING &&
            !exercise.modelAudioText.isNullOrBlank() &&
            !hasNoSpaceScript(exercise.modelAudioText) &&
            abs(exercise.id.hashCode()) % 2 == 0
}
