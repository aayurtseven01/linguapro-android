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
                precision >= 0.72f && recall >= 0.72f
            }
        }
    }
}
