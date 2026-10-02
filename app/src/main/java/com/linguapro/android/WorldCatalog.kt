package com.linguapro.android

/** Eğitim dili tanımı: kod, Türkçe ad, bayrak ve TTS/konuşma tanıma dili etiketi. */
data class WorldLanguage(val code: String, val nameTr: String, val flag: String, val speechTag: String)

/** Çok dilli kurs kataloğu: 10 dilin tamamında A1-C2 müfredat; İngilizce CourseCatalog un geniş kataloğuna yönlenir. */
object WorldCatalog {
    val languages: List<WorldLanguage> = listOf(
        WorldLanguage("EN", "İngilizce", "🇬🇧", "en-US"),
        WorldLanguage("DE", "Almanca", "🇩🇪", "de-DE"),
        WorldLanguage("FR", "Fransızca", "🇫🇷", "fr-FR"),
        WorldLanguage("ES", "İspanyolca", "🇪🇸", "es-ES"),
        WorldLanguage("PT", "Portekizce", "🇵🇹", "pt-PT"),
        WorldLanguage("IT", "İtalyanca", "🇮🇹", "it-IT"),
        WorldLanguage("RU", "Rusça", "🇷🇺", "ru-RU"),
        WorldLanguage("ZH", "Çince", "🇨🇳", "zh-CN"),
        WorldLanguage("JA", "Japonca", "🇯🇵", "ja-JP"),
        WorldLanguage("KO", "Korece", "🇰🇷", "ko-KR")
    )

    private fun withCheckpoint(unit: LearningUnit): LearningUnit {
        val pool = unit.lessons.flatMap { it.exercises }
        if (pool.isEmpty()) return unit
        val quiz = pool.shuffled(kotlin.random.Random(unit.id.hashCode().toLong()))
            .take(5)
            .map { it.copy(id = "${it.id}-cp") }
        val checkpoint = LearningLesson(
            "${unit.id}-CP",
            "Checkpoint: ${unit.title}",
            "Üniteyi en az yüzde 80 başarıyla geç.",
            quiz
        )
        return unit.copy(lessons = unit.lessons + checkpoint)
    }

    private val worldUnits: Map<String, List<LearningUnit>> = mapOf(
        "DE" to WorldCourseDE.units,
        "FR" to WorldCourseFR.units,
        "ES" to WorldCourseES.units,
        "PT" to WorldCoursePT.units,
        "IT" to WorldCourseIT.units,
        "RU" to WorldCourseRU.units,
        "ZH" to WorldCourseZH.units,
        "JA" to WorldCourseJA.units,
        "KO" to WorldCourseKO.units
    ).mapValues { (_, units) -> units.map { withCheckpoint(it) } }

    fun language(code: String): WorldLanguage = languages.firstOrNull { it.code == code } ?: languages.first()

    fun availableLevels(lang: String): List<String> = CourseCatalog.levels

    fun units(lang: String, level: String): List<LearningUnit> =
        if (lang == "EN") CourseCatalog.units(level)
        else worldUnits[lang].orEmpty().filter { it.id.startsWith("$lang-$level-") }

    private val allWorldLessonsCache: List<LearningLesson> by lazy { worldUnits.values.flatten().flatMap { it.lessons } }
    fun allWorldLessons(): List<LearningLesson> = allWorldLessonsCache

    /** Ders kimliğinden hedef dilin Türkçe adını döndürür; İngilizce ve bilinmeyenler için "İngilizce". */
    fun languageNameForLesson(lessonId: String): String {
        val prefix = lessonId.substringBefore('-')
        return languages.firstOrNull { it.code == prefix }?.nameTr ?: "İngilizce"
    }

    /** Dersin kimliğinden konuşma/TTS dili etiketini türetir; İngilizce derslerde kullanıcı aksanı korunur. */
    fun speechTagForLesson(lessonId: String, fallback: String): String {
        val prefix = lessonId.substringBefore('-')
        return languages.firstOrNull { it.code == prefix && it.code != "EN" }?.speechTag ?: fallback
    }
}
