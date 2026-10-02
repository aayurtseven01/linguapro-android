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
                    val wordMatch = precision >= 0.72f && recall >= 0.72f
                    // Boşluk kullanmayan yazı sistemleri (Çince/Japonca): karakter-ikilisi benzerliği.
                    wordMatch || (targetWords.size == 1 && normalizedTarget.length >= 4 &&
                        bigramSimilarity(normalizedResponse.replace(" ", ""), normalizedTarget) >= 0.8f)
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

    private fun bigramSimilarity(a: String, b: String): Float {
        if (a.length < 2 || b.length < 2) return if (a == b) 1f else 0f
        val bigramsA = (0 until a.length - 1).map { a.substring(it, it + 2) }.toSet()
        val bigramsB = (0 until b.length - 1).map { b.substring(it, it + 2) }.toSet()
        val intersection = bigramsA.intersect(bigramsB).size
        return 2f * intersection / (bigramsA.size + bigramsB.size)
    }
}
