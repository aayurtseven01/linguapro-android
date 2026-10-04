package com.linguapro.android

/** Introductory scenarios for the nine non-English courses; not a claim of complete curriculum review. */
object WorldEditorialFoundation {
    private data class Scenario(
        val language: String, val name: String, val friend: String, val greeting: String, val goodbye: String,
        val introduction: String, val friendIntroduction: String, val dialogue: String,
        val grammarPrompt: String, val grammarAnswer: String, val wrongGrammar: List<String>,
        val rule: String, val form: String, val error: String
    )
    private val scenarios = listOf(
        Scenario("DE", "Anna", "Leo", "Hallo", "Auf Wiedersehen", "Ich heiße Anna.", "Ich heiße Leo.",
            "Hallo, ich heiße Anna. Wie heißt du? Ich heiße Leo. Freut mich! Mich auch.",
            "Ich ___ Anna.", "heiße", listOf("heißt", "heißen"), "Heißen adının ne olduğunu belirtir. Ich ile heiße, du ile heißt kullanılır.", "Ich heiße + ad", "Ich heißt yerine ich heiße yaz."),
        Scenario("FR", "Anna", "Léo", "Bonjour", "Au revoir", "Je m'appelle Anna.", "Je m'appelle Léo.",
            "Bonjour, je m'appelle Anna. Et toi ? Je m'appelle Léo. À bientôt ! À bientôt !",
            "Je ___ Anna.", "m'appelle", listOf("t'appelles", "s'appelle"), "S'appeler dönüşlü bir fiildir; je ile m'appelle, tu ile t'appelles kullanılır.", "Je m'appelle + ad", "Je s'appelle değil je m'appelle kullan."),
        Scenario("ES", "Ana", "Leo", "Hola", "Adiós", "Me llamo Ana.", "Me llamo Leo.",
            "Hola, me llamo Ana. ¿Cómo te llamas? Me llamo Leo. Mucho gusto. Igualmente.",
            "Me ___ Ana.", "llamo", listOf("llamas", "llama"), "Llamarse adını söylemek için kullanılır. Birinci tekil kişi: me llamo.", "Me llamo + ad", "Me llamas değil me llamo kullan; te llamas karşıdaki kişiyi anlatır."),
        Scenario("PT", "Ana", "Leo", "Olá", "Até logo", "Eu me chamo Ana.", "Eu me chamo Leo.",
            "Olá, eu me chamo Ana. E você? Eu me chamo Leo. Prazer! Prazer!",
            "Eu me ___ Ana.", "chamo", listOf("chama", "chamam"), "Brezilya Portekizcesinde eu me chamo ile adını söyleyebilirsin; eu ile chamo kullanılır.", "Eu me chamo + ad", "Eu me chama değil eu me chamo kullan. Bu derste Brezilya kullanımı esas alınır."),
        Scenario("IT", "Anna", "Leo", "Ciao", "Arrivederci", "Mi chiamo Anna.", "Mi chiamo Leo.",
            "Ciao, mi chiamo Anna. Come ti chiami? Mi chiamo Leo. Piacere! Piacere!",
            "Mi ___ Anna.", "chiamo", listOf("chiami", "chiama"), "Chiamarsi dönüşlü fiildir. Mi chiamo kendini, ti chiami karşıdaki kişiyi anlatır.", "Mi chiamo + ad", "Mi chiami değil mi chiamo kullan. Ciao samimi bir selamlaşmadır."),
        Scenario("RU", "Анна", "Лео", "Привет", "До свидания", "Меня зовут Анна.", "Меня зовут Лео.",
            "Привет! Меня зовут Анна. Как тебя зовут? Меня зовут Лео. Очень приятно! Мне тоже.",
            "___ зовут Анна. (Benim adım Anna.)", "Меня", listOf("Тебя", "Его"), "Меня зовут kalıbı adını söylemek için kullanılır. Тебя зовут karşıdakinin adını anlatır.", "Меня зовут + ad", "Bu kalıpta Я зовут değil Меня зовут kullan. Привет samimi selamlaşmadır."),
        Scenario("ZH", "安娜", "里奥", "你好", "再见", "我叫安娜。", "我叫里奥。",
            "你好，我叫安娜。你叫什么名字？我叫里奥。很高兴认识你！我也很高兴认识你。",
            "___叫安娜。 (Benim adım Anna.)", "我", listOf("你", "他"), "Mandarin Çincesinde 我叫 + ad ile kendini tanıtırsın. 我 ben, 你 sen, 他 o demektir.", "我叫 + ad", "Kendini tanıtırken 你叫 değil 我叫 kullan. Tonlar anlam ayırabilir; cihaz sesini dikkatle dinle."),
        Scenario("JA", "アンナ", "レオ", "こんにちは", "さようなら", "アンナです。", "レオです。",
            "こんにちは。アンナです。お名前は何ですか。レオです。よろしくお願いします。こちらこそ、よろしくお願いします。",
            "アンナ___。 (Anna'yım; kibar biçim.)", "です", listOf("ます", "を"), "İsimden sonra です kibar bir tanıtma cümlesi kurar. Bağlam açıkken özne söylenmeyebilir.", "ad + です", "İsimden sonra doğrudan ます ekleme; ます fiillerle kullanılır. Japonca tanışma ifadesi よろしくお願いします bire bir çeviriden çok sosyal işleviyle öğrenilir."),
        Scenario("KO", "안나", "레오", "안녕하세요", "안녕히 가세요", "저는 안나예요.", "저는 레오예요.",
            "안녕하세요. 저는 안나예요. 이름이 뭐예요? 저는 레오예요. 만나서 반가워요. 저도 반가워요.",
            "저는 안나___. (Ben Anna'yım; kibar günlük biçim.)", "예요", listOf("이에요", "을"), "Ünlüyle biten bir isimden sonra 예요, ünsüzle bitenden sonra 이에요 kullanılır. 안나 ünlüyle biter.", "저는 + ünlüyle biten isim + 예요", "안나 için 이에요 değil 예요 kullan. 안녕히 가세요, ayrılan kişiye söylenen vedadır; kalan kişiye 안녕히 계세요 denir.")
    ).associateBy { it.language }

    fun revise(unit: LearningUnit): LearningUnit {
        val code = unit.id.substringBefore('-')
        val data = scenarios[code] ?: return unit
        if (unit.id != "$code-A1-U1") return unit
        return unit.copy(lessons = unit.lessons.map {
            if (it.id == "$code-A1-U1-L1") build(data).copy(targetVocabulary = it.targetVocabulary) else it
        })
    }

    private fun build(s: Scenario): LearningLesson {
        val id = "${s.language}-A1-U1-L1"
        fun choice(suffix: String, skill: Skill, prompt: String, answer: String, wrong: List<String>, why: String,
                   context: String = "", audio: String? = null) = LearningExercise(
            "world-editorial-${s.language.lowercase()}-$suffix", skill,
            if (skill == Skill.LISTENING) "Tanışma konuşmasını dinle ve yanıtla" else "Bağlama göre doğru cevabı seç",
            prompt, context, (listOf(answer) + wrong).shuffled(kotlin.random.Random(suffix.hashCode())),
            listOf(answer), why, audio)
        return LearningLesson(id, "Bir tanışma konuşması", "Selamlayıp adımı söyleyebilir ve tanıştığım kişinin adını anlayabilirim.", listOf(
            choice("greet", Skill.VOCABULARY, "Tanışma konuşmasının başında '${s.greeting}' ne işe yarar?", "Selamlamak",
                listOf("Yaşını söylemek", "Ülkesini söylemek"), "Bu bağlamda ${s.greeting} bir selamlaşmadır. ${s.error}"),
            choice("listen-first", Skill.LISTENING, "İlk konuşmacının adı ne?", s.name, listOf(s.friend, "Elif"),
                "Konuşma ${s.introduction} ifadesiyle başlıyor; ilk konuşmacı ${s.name}.", audio = s.dialogue),
            choice("listen-second", Skill.LISTENING, "İkinci konuşmacı kendini nasıl tanıtıyor?", s.friendIntroduction,
                listOf(s.introduction, s.goodbye), "İkinci konuşmacı ${s.friendIntroduction} diyor. ${s.goodbye} bir vedalaşmadır.", audio = s.dialogue),
            choice("grammar", Skill.GRAMMAR, s.grammarPrompt, s.grammarAnswer, s.wrongGrammar, s.rule),
            choice("read", Skill.READING, "Bu metinde kişi kendisi hakkında hangi bilgiyi veriyor?", "Adını",
                listOf("Yaşını", "Telefon numarasını"), "${s.friendIntroduction} cümlesi adını verir; yaş veya numara yok.", context = s.friendIntroduction),
            choice("reply", Skill.READING, "Adını söylemek istiyorsun. Hangisi uygun?", s.introduction,
                listOf(s.greeting, s.goodbye), "${s.introduction} adını belirtir; yalnızca selamlaşmak veya vedalaşmak adını söylemez.", context = s.dialogue),
            LearningExercise("world-editorial-${s.language.lowercase()}-speak", Skill.SPEAKING, "Modeli dinle ve sesli tekrar et",
                "Modeli sesli söyle: ${s.introduction}", acceptedAnswers = listOf(s.introduction),
                explanationTr = "Anlamı: Benim adım ${s.name}. Bu görev tekrar alıştırmasıdır; serbest konuşma veya telaffuz puanı değildir.",
                modelAudioText = s.introduction, sampleAnswer = s.introduction),
            LearningExercise("world-editorial-${s.language.lowercase()}-write", Skill.WRITING, "Öğrendiğin tanışma kalıbıyla yaz",
                "Adının ${s.friend} olduğunu söyle. Bu dersteki tanışma kalıbını kullan.", acceptedAnswers = listOf(s.friendIntroduction),
                explanationTr = "${s.rule}\nModel yanıt: ${s.friendIntroduction} Başka doğal ifadeler de mümkündür; yazma görevi otomatik puanlanmaz.", sampleAnswer = s.friendIntroduction)
        ), grammarFocus = GrammarFocus("Adını söyleme", s.rule, s.form, s.introduction, "Benim adım ${s.name}.", s.error))
    }
}
