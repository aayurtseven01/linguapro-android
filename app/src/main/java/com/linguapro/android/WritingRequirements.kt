package com.linguapro.android

import kotlinx.serialization.Serializable

@Serializable
data class WritingRequirements(
    val checklistTr: List<String>,
    val minimumWords: Int? = null,
    val maximumWords: Int? = null
)

object WritingModels {
    private val answers = WritingModelsA1.answers + WritingModelsA2.answers + WritingModelsB1.answers +
        WritingModelsB2.answers + WritingModelsC1.answers + WritingModelsC2.answers
    fun forUnit(unitId: String): String = requireNotNull(answers[unitId]) { "Missing writing model: $unitId" }
    fun all(): Map<String, String> = answers
    fun requirements(level: String): WritingRequirements = when (level) {
        "A1" -> WritingRequirements(listOf("İki kısa cümle yazdım.", "Her cümlede metinden bir bilgi verdim.", "Kişi, yer veya zamanı doğru aktardım."))
        "A2" -> WritingRequirements(listOf("Üç veya dört kısa cümle yazdım.", "Olay sırasını veya nedenini açıkladım.", "Metinde olmayan bir ayrıntıyı gerçekmiş gibi eklemedim."))
        "B1" -> WritingRequirements(listOf("Durumu, nedenini ve sonucunu aktardım.", "Cümleleri uygun bağlaçlarla ilişkilendirdim.", "Özetimi metindeki bilgilerle sınırladım."), 40, 60)
        "B2" -> WritingRequirements(listOf("Kararı değerlendiren açık bir görüş verdim.", "Metinden bir gerekçe ve bir sınırlılık kullandım.", "Kendi önerimi metindeki olgudan ayırdım."), 60, 90)
        "C1" -> WritingRequirements(listOf("Kaynağın iddiasını doğru özetledim.", "Kanıtın veya yorumun sınırını belirttim.", "Kendi değerlendirmemi açıkça ayırdım ve kesinliği ölçülü tuttum."), 80, 120)
        else -> WritingRequirements(listOf("Açık ve örtük anlamı birbirinden ayırdım.", "Üslubun etkisini veya alternatif bir yorumu değerlendirdim.", "Yorumumu metindeki ayrıntılara dayandırdım; bilinmeyenleri kesinleştirmedim."), 100, 140)
    }
}
