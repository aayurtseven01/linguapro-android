package com.linguapro.android

import java.text.Normalizer
import java.util.Locale

/** Lightweight offline checker for closed-answer and shadowing practice; not an AI language grader. */
object AnswerChecker {
    fun normalize(value: String): String = Normalizer.normalize(value.lowercase(Locale.ROOT), Normalizer.Form.NFD)
        .replace(Regex("\\p{Mn}+"), "")
        .replace("'", "")
        .replace(Regex("[^\\p{L}\\p{N}]+"), " ")
        .trim()

    fun matches(response: String, accepted: List<String>): Boolean {
        val normalizedResponse = normalize(response)
        if (normalizedResponse.isBlank()) return false
        return accepted.any { target ->
            val normalizedTarget = normalize(target)
            if (normalizedResponse == normalizedTarget) true
            else {
                val responseWords = normalizedResponse.split(Regex("\\s+")).toSet()
                val targetWords = normalizedTarget.split(Regex("\\s+")).toSet()
                val overlap = responseWords.intersect(targetWords).size.toFloat()
                val recall = overlap / targetWords.size.coerceAtLeast(1)
                val precision = overlap / responseWords.size.coerceAtLeast(1)
                val wordMatch = precision >= 0.72f && recall >= 0.72f
                // Boşluk kullanmayan yazı sistemleri (Çince/Japonca): kelime kesişimi çalışmaz,
                // tek parçalı hedeflerde karakter-ikilisi benzerliğiyle kısmi doğruluk tanınır.
                wordMatch || (targetWords.size == 1 && normalizedTarget.length >= 4 &&
                    bigramSimilarity(normalizedResponse.replace(" ", ""), normalizedTarget) >= 0.8f)
            }
        }
    }

    private fun bigramSimilarity(a: String, b: String): Float {
        if (a.length < 2 || b.length < 2) return if (a == b) 1f else 0f
        val bigramsA = (0 until a.length - 1).map { a.substring(it, it + 2) }.toSet()
        val bigramsB = (0 until b.length - 1).map { b.substring(it, it + 2) }.toSet()
        val intersection = bigramsA.intersect(bigramsB).size
        return 2f * intersection / (bigramsA.size + bigramsB.size)
    }
}
