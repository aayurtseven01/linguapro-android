package com.linguapro.android

data class ScenarioQuestion(val prompt: String, val correct: String, val wrong1: String, val wrong2: String, val explanationTr: String)
data class UnitScenario(val unitId: String, val passage: String, val listening: ScenarioQuestion, val reading: ScenarioQuestion,
    val transferPassage: String, val transfer: ScenarioQuestion)
internal fun sq(prompt: String, answer: String, wrong1: String, wrong2: String, explanation: String) =
    ScenarioQuestion(prompt, answer, wrong1, wrong2, explanation)

/** A complete A1–C2 English scenario bank, distinct from device/audio and expert-review certification. */
object ScenarioCurriculum {
    private val scenarios by lazy {
        (ScenarioBankA1.items + ScenarioBankA2.items + ScenarioBankB1.items + ScenarioBankB2.items + ScenarioBankC1.items + ScenarioBankC2.items)
            .associateBy { it.unitId }
    }
    fun allScenarios(): List<UnitScenario> = scenarios.values.toList()
    fun question(id: String, skill: Skill, data: ScenarioQuestion, passage: String): LearningExercise = LearningExercise(
        id, skill, if (skill == Skill.LISTENING) "Metni dinle; ana fikri ve ayrıntıları ayırt et" else "Metni oku; cevabını metindeki kanıta dayandır",
        data.prompt, if (skill == Skill.READING) passage else "",
        listOf(data.correct, data.wrong1, data.wrong2).shuffled(kotlin.random.Random(id.hashCode())),
        listOf(data.correct), data.explanationTr, if (skill == Skill.LISTENING) passage else null)

    fun revise(unit: LearningUnit): LearningUnit {
        val scenario = scenarios[unit.id] ?: return unit
        val target = unit.lessons.getOrNull(1) ?: return unit
        val pool = unit.lessons.flatMap { it.exercises }
        fun reuse(suffix: String, exercise: LearningExercise) = exercise.copy(id = "scenario-${unit.id.lowercase()}-$suffix")
        val level = unit.id.substringBefore('-')
        val grammar = target.exercises.firstOrNull { it.skill == Skill.GRAMMAR } ?: pool.firstOrNull { it.skill == Skill.GRAMMAR } ?: grammarReview(level)
        val model = scenario.passage.substringBefore('.') + "."
        val speaking = pool.firstOrNull { it.skill == Skill.SPEAKING && !it.modelAudioText.isNullOrBlank() }
            ?: LearningExercise("model", Skill.SPEAKING, "Modeli dinle ve sesli tekrar et", "Say: $model",
                acceptedAnswers = listOf(model), explanationTr = "Metnin ilk cümlesini anlamını düşünerek tekrar et. Bu bir model tekrar görevidir.",
                modelAudioText = model, sampleAnswer = model)
        val vocabulary = pool.firstOrNull { it.skill == Skill.VOCABULARY }
            ?: pool.firstOrNull { it.skill == Skill.READING } ?: grammar
        val listening = pool.firstOrNull { it.skill == Skill.LISTENING } ?: speaking.copy(
            skill = Skill.LISTENING, instructionTr = "Dinle ve duyduğun cümleyi yaz", prompt = "Duyduğun model cümleyi yaz.",
            acceptedAnswers = listOf(speaking.modelAudioText!!))
        val reading = pool.firstOrNull { it.skill == Skill.READING } ?: grammar
        val production = when (level) {
            "A1" -> "Metindeki kişi, yer veya zaman hakkında iki kısa İngilizce cümle yaz. Her cümlede bir bilgi ver."
            "A2" -> "Metindeki durumu üç veya dört kısa İngilizce cümleyle anlat. Olay sırasını veya bir nedeni açıkla."
            "B1" -> "Durumu, nedenini ve sonucunu 40–60 İngilizce kelimeyle özetle. Metinde olmayan ayrıntıları gerçekmiş gibi ekleme."
            "B2" -> "Metindeki kararı 60–90 İngilizce kelimeyle değerlendir. Bir gerekçe ve bir sınırlılık belirt."
            "C1" -> "Metnin iddiasını ve kanıtının sınırını 80–120 İngilizce kelimeyle değerlendir. Kaynağın görüşüyle kendi yorumunu ayır."
            else -> "Metnin açık ve örtük anlamını 100–140 İngilizce kelimeyle yorumla. Üslubun etkisini veya alternatif yorumu değerlendir; kesinliği kanıtla orantılı tut."
        }
        val revised = target.copy(title = "${unit.title} — Bağlamda uygulama",
            canDo = when (level) {
                "A1" -> "Kısa bir metindeki kişi, yer ve zaman bilgisini ayırt edebilirim."
                "A2" -> "Günlük bir durumun ayrıntılarını ve olay sırasını açıklayabilirim."
                "B1" -> "Bir durumun nedenini ve sonucunu bağlantılı cümlelerle özetleyebilirim."
                "B2" -> "Bir kararın gerekçesini ve sınırlılıklarını değerlendirip görüşümü destekleyebilirim."
                "C1" -> "İddia ile kanıtı ayırıp çıkarımın sınırını temkinli bir dille açıklayabilirim."
                else -> "Örtük anlamı, üslubu ve alternatif yorumları metindeki kanıtla değerlendirebilirim."
            },
            exercises = listOf(
                reuse("recall", vocabulary),
                question("scenario-${unit.id.lowercase()}-listen", Skill.LISTENING, scenario.listening, scenario.passage),
                reuse("language", grammar),
                question("scenario-${unit.id.lowercase()}-read", Skill.READING, scenario.reading, scenario.passage),
                reuse("listen-review", listening), reuse("read-review", reading), reuse("speak", speaking),
                LearningExercise("scenario-${unit.id.lowercase()}-write", Skill.WRITING,
                    "Öğrendiğini kendi cümlelerinle ifade et", production, context = scenario.passage,
                    acceptedAnswers = listOf(WritingModels.forUnit(unit.id)),
                    explanationTr = "Önce ana bilgiyi seç, ardından bu seviyenin görev ölçütlerini kontrol et. Aşağıdaki yanıt görevi karşılayan bir örnektir; tek doğru cevap değildir. Yazın otomatik puanlanmaz.",
                    sampleAnswer = WritingModels.forUnit(unit.id), writingRequirements = WritingModels.requirements(level))
            ))
        return unit.copy(lessons = unit.lessons.map { if (it.id == target.id) revised else it })
    }

    private fun grammarReview(level: String): LearningExercise {
        val task = when (level) {
            "A1" -> sq("She ___ at home.", "is", "am", "are", "She ile is kullanılır; I ile am, you/we/they ile are kullanılır.")
            "A2" -> sq("Yesterday, we ___ the museum.", "visited", "visit", "visiting", "Yesterday tamamlanmış geçmiş zamanı belirtir: visit → visited.")
            "B1" -> sq("I ___ in this town since 2019.", "have lived", "live", "am living", "Since 2019 geçmişten şimdiye süren durumu belirtir; present perfect kullanılır.")
            "B2" -> sq("If we had more time, we ___ review the proposal.", "could", "will", "are", "Varsayımsal durumda if + past simple, could/would + yalın fiil kullanılır.")
            "C1" -> sq("Not only ___ the costs, but we also reduced delays.", "did we reduce", "we reduced", "we did reduced", "Not only cümlenin başında olduğunda devrik yapı gerekir: did + özne + yalın fiil.")
            else -> sq("Had the evidence been stronger, the conclusion ___ more defensible.", "would have been", "would been", "has being", "Had ile devrik geçmiş koşul, would have + past participle sonuç yapısıyla birleşir.")
        }
        return LearningExercise("review-grammar", Skill.GRAMMAR, "Seviyenin temel yapısını tekrar et", task.prompt,
            options = listOf(task.correct, task.wrong1, task.wrong2), acceptedAnswers = listOf(task.correct), explanationTr = task.explanationTr)
    }

    fun checkpointFor(unit: LearningUnit): LearningLesson? {
        val scenario = scenarios[unit.id] ?: return null
        val closed = unit.lessons.flatMap { it.exercises }.filter { it.options.isNotEmpty() && it.skill != Skill.WRITING && it.skill != Skill.SPEAKING }
            .distinctBy { Triple(it.prompt, it.context + it.modelAudioText.orEmpty(), it.acceptedAnswers) }
            .shuffled(kotlin.random.Random(unit.id.hashCode())).take(4)
        if (closed.size != 4) return null
        return LearningLesson("${unit.id}-CP", "Kazanım kontrolü: ${unit.title}",
            "Yeni bir durumda anlamı ayırt et ve ünite kazanımlarını en az yüzde 80 başarıyla uygula.",
            listOf(question("scenario-${unit.id.lowercase()}-transfer", Skill.READING, scenario.transfer, scenario.transferPassage)) +
                closed.map { it.copy(id = "${it.id}-cp") })
    }
}
