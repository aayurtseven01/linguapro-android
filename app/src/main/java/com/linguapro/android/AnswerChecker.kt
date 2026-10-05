package com.linguapro.android

import java.text.Normalizer
import java.util.Locale

/** Lightweight offline checker for closed-answer and shadowing practice; not an AI language grader. */
object AnswerChecker {
    /** Closed questions must not accept a distractor through speech-recognition tolerance. */
    fun matchesClosed(response: String, accepted: List<String>): Boolean {
        fun key(value: String): String = Normalizer.normalize(value.lowercase(Locale.ROOT), Normalizer.Form.NFC)
            .replace("'", "").replace(Regex("[^\\p{L}\\p{N}\\p{M}]+"), " ").trim()
        val responseKey = key(response)
        return responseKey.isNotBlank() && accepted.any { key(it) == responseKey }
    }
    fun normalize(value: String): String = Normalizer.normalize(value.lowercase(Locale.ROOT), Normalizer.Form.NFC)
        .replace("'", "")
        .replace(Regex("[^\\p{L}\\p{N}\\p{M}]+"), " ")
        .trim()

    /** Olumsuzluk belirteçleri: yanıt ile hedef arasında olumsuzluk uyuşmazlığı varsa yanıt reddedilir. */
    private val negationTokens = setOf(
        "not", "no", "never", "none", "neither", "nor",
        "dont", "doesnt", "didnt", "isnt", "arent", "wasnt", "werent",
        "cant", "cannot", "wont", "shouldnt", "couldnt", "wouldnt", "havent", "hasnt", "hadnt",
        "nicht", "kein", "keine", "keinen", "nie", "niemals",
        "pas", "jamais", "rien", "aucun", "aucune",
        "nunca", "jamas", "nada", "ningun", "ninguna",
        "nao", "nem", "nenhum", "nenhuma",
        "non", "mai", "niente", "nessuno", "nessuna",
        "не", "нет", "никогда", "ничего",
        "안", "못"
    )

    fun matches(response: String, accepted: List<String>): Boolean {
        val normalizedResponse = normalize(response)
        if (normalizedResponse.isBlank()) return false
        return accepted.any { target ->
            val normalizedTarget = normalize(target)
            if (normalizedResponse == normalizedTarget) true
            else {
                val responseWords = normalizedResponse.split(Regex("\\s+"))
                val targetWords = normalizedTarget.split(Regex("\\s+"))
                // Olumsuzluk uyuşmazlığı: "I am from Turkey" hedefine "I am not from Turkey" kabul edilmez.
                val negationMismatch =
                    responseWords.any { it in negationTokens } != targetWords.any { it in negationTokens }
                if (negationMismatch) false
                else {
                    // Sıra duyarlı eşleşme: ortak en uzun alt dizi (LCS) üzerinden kesinlik/duyarlılık.
                    // Küme kesişiminden farkı: karıştırılmış kelime sırası ("Turkey from am I") artık geçmez.
                    val lcs = longestCommonSubsequence(responseWords, targetWords).toFloat()
                    val recall = lcs / targetWords.size.coerceAtLeast(1)
                    val precision = lcs / responseWords.size.coerceAtLeast(1)
                    val fillers = setOf("a", "an", "the", "please", "uh", "um")
                    // Missing articles/fillers are tolerated; changing a name, number, verb or place is not.
                    val sameContent = responseWords.filterNot { it in fillers } == targetWords.filterNot { it in fillers }
                    val wordMatch = precision >= 0.72f && recall >= 0.72f && sameContent
                    // Never infer semantic correctness from character similarity. CJK spacing
                    // may vary in speech recognition, but characters must remain unchanged.
                    val cjk = normalizedTarget.any { it in '\u3400'..'\u9fff' || it in '\u3040'..'\u30ff' || it in '\uac00'..'\ud7af' }
                    wordMatch || (cjk && normalizedResponse.replace(" ", "") == normalizedTarget.replace(" ", ""))
                }
            }
        }
    }

    private fun longestCommonSubsequence(a: List<String>, b: List<String>): Int {
        val dp = Array(a.size + 1) { IntArray(b.size + 1) }
        for (i in 1..a.size) for (j in 1..b.size) {
            dp[i][j] = if (a[i - 1] == b[j - 1]) dp[i - 1][j - 1] + 1 else maxOf(dp[i - 1][j], dp[i][j - 1])
        }
        return dp[a.size][b.size]
    }

}
