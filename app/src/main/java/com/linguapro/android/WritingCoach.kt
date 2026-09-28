package com.linguapro.android

data class WritingFeedback(val wordCount: Int, val strengths: List<String>, val suggestions: List<String>)

/** Lightweight transparent checks; this does not claim to grade grammar or CEFR writing proficiency. */
object WritingCoach {
    fun review(response: String, modelAnswer: String = ""): WritingFeedback {
        val text = response.trim()
        val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }
        val suggestions = mutableListOf<String>()
        val strengths = mutableListOf<String>()
        if (text.isEmpty()) suggestions += "Soruyu yanıtlayan en az bir tam cümle yaz."
        else {
            if (text.first().isLowerCase()) suggestions += "Cümleye büyük harfle başlamayı dene."
            if (text.last() !in listOf('.', '!', '?')) suggestions += "Cümle sonuna uygun noktalama işareti ekle."
            if (Regex(" {2,}").containsMatchIn(text)) suggestions += "Kelimeler arasında tek boşluk kullan."
            val lower = text.lowercase()
            if (Regex("(^|\\s)(i|we|you|they)\\s+is(\\s|$)").containsMatchIn(lower)) suggestions += "Özne-fiil uyumunu kontrol et: I/we/you/they ile genellikle am/are kullanılır."
            if (Regex("\\b(he|she|it) are\\b").containsMatchIn(lower)) suggestions += "He/she/it ile be fiilinin is biçimini kullan."
            if (Regex("\\bdoesn't\\s+[a-z]+s\\b").containsMatchIn(lower)) suggestions += "Doesn't sonrasında fiilin yalın biçimini kullan."
            if (words.size >= 3) strengths += "Yanıtın ${words.size} kelime içeriyor."
            if (text.firstOrNull()?.isUpperCase() == true) strengths += "Cümleye büyük harfle başlamışsın."
            if (text.lastOrNull() in listOf('.', '!', '?')) strengths += "Cümle sonu noktalaması var."
            if (modelAnswer.isNotBlank() && normalize(text) == normalize(modelAnswer)) strengths += "Yanıtın örnek yanıtla örtüşüyor."
            else if (modelAnswer.isNotBlank()) strengths += "Örnek yanıtla karşılaştır; aynı fikri farklı doğru kelimelerle de ifade edebilirsin."
        }
        return WritingFeedback(words.size, strengths, suggestions)
    }

    private fun normalize(text: String) = text.lowercase().replace(Regex("[^a-z0-9']+"), " ").trim().replace(Regex("\\s+"), " ")
}
