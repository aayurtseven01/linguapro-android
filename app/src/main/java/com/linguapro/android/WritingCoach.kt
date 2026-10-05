package com.linguapro.android

data class WritingFeedback(val wordCount: Int, val strengths: List<String>, val suggestions: List<String>)

/** Lightweight transparent checks; this does not claim to grade grammar or CEFR writing proficiency. */
object WritingCoach {
    /** Task length only; passing this check says nothing about grammar or meaning. */
    fun submissionError(response: String, requirements: WritingRequirements? = null): String? {
        val text = response.trim()
        if (text.isBlank()) return "Soruyu yanıtlayan bir metin yaz."
        if (text.count { it.isLetter() } < 4) return "Soruyu yanıtlayan bir cümle yaz; tek harf veya işaret yeterli değil."
        val count = text.split(Regex("\\s+")).count { token -> token.any { it.isLetterOrDigit() } }
        requirements?.minimumWords?.let { minimum ->
            if (count < minimum) return "Bu görev için en az $minimum kelime yazmalısın; şu an $count kelime var."
        }
        requirements?.maximumWords?.let { maximum ->
            if (count > maximum) return "Bu görev için en fazla $maximum kelime yazmalısın; şu an $count kelime var."
        }
        return null
    }

    private val terminalMarks = setOf('.', '!', '?', '。', '！', '？')
    private val inflectedVerbs = setOf("goes", "does", "has", "likes", "wants", "needs", "works", "plays", "speaks", "lives",
        "makes", "takes", "sends", "uses", "tries", "watches", "studies", "reads", "writes", "starts", "finishes",
        "knows", "feels", "shows", "helps", "keeps", "comes", "leaves", "thinks", "says", "gives", "asks", "gets")
    fun review(response: String, modelAnswer: String = "", requirements: WritingRequirements? = null): WritingFeedback {
        val text = response.trim()
        val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }
        val suggestions = mutableListOf<String>()
        val strengths = mutableListOf<String>()
        requirements?.minimumWords?.let { minimum ->
            if (words.size < minimum) suggestions += "Görev en az $minimum kelime istiyor; şu an ${words.size} kelime var. Ana bilgiye gerekçe veya açıklama ekle."
        }
        requirements?.maximumWords?.let { maximum ->
            if (words.size > maximum) suggestions += "Görev en fazla $maximum kelime istiyor; şu an ${words.size} kelime var. Tekrarları çıkarıp ana fikri koru."
        }
        if (text.isEmpty()) suggestions += "Soruyu yanıtlayan en az bir tam cümle yaz."
        else {
            if (text.first().isLowerCase()) suggestions += "Cümleye büyük harfle başlamayı dene."
            if (text.last() !in terminalMarks) suggestions += "Cümle sonuna uygun noktalama işareti ekle."
            if (Regex(" {2,}").containsMatchIn(text)) suggestions += "Kelimeler arasında tek boşluk kullan."
            val lower = text.lowercase(java.util.Locale.ROOT).replace('’', '\'')
            if (Regex("(^|\\s)(i|we|you|they)\\s+is(\\s|$)").containsMatchIn(lower)) suggestions += "Özne-fiil uyumunu kontrol et: I/we/you/they ile genellikle am/are kullanılır."
            if (Regex("\\b(he|she|it) are\\b").containsMatchIn(lower)) suggestions += "He/she/it ile be fiilinin is biçimini kullan."
            val afterDoesNot = Regex("\\bdoesn't\\s+([a-z]+)\\b").findAll(lower).map { it.groupValues[1] }
            if (afterDoesNot.any { it in inflectedVerbs }) suggestions += "Doesn't sonrasında fiilin yalın biçimini kullan."
            if (words.size >= 3) strengths += "Yanıtın ${words.size} kelime içeriyor."
            if (text.firstOrNull()?.isUpperCase() == true) strengths += "Cümleye büyük harfle başlamışsın."
            if (text.lastOrNull() in terminalMarks) strengths += "Cümle sonu noktalaması var."
            if (modelAnswer.isNotBlank() && normalize(text) == normalize(modelAnswer)) strengths += "Yanıtın örnek yanıtla örtüşüyor."
            else if (modelAnswer.isNotBlank()) strengths += "Örnek yanıtla karşılaştır; aynı fikri farklı doğru kelimelerle de ifade edebilirsin."
        }
        return WritingFeedback(words.size, strengths, suggestions)
    }

    private fun normalize(text: String) = java.text.Normalizer.normalize(text.lowercase(java.util.Locale.ROOT), java.text.Normalizer.Form.NFC)
        .replace(Regex("[^\\p{L}\\p{N}\\p{M}']+"), " ").trim().replace(Regex("\\s+"), " ")
}

