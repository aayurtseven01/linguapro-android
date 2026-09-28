package com.linguapro.android

/** Content is data, separate from presentation, so editors/reviewers can audit learning objectives. */
enum class Skill { LISTENING, READING, SPEAKING, WRITING, GRAMMAR, VOCABULARY }

data class LearningExercise(
    val id: String,
    val skill: Skill,
    val instructionTr: String,
    val prompt: String,
    val context: String = "",
    val options: List<String> = emptyList(),
    val acceptedAnswers: List<String> = emptyList(),
    val explanationTr: String,
    val modelAudioText: String? = null,
    val sampleAnswer: String? = null
)

data class LearningLesson(
    val id: String,
    val title: String,
    val canDo: String,
    val exercises: List<LearningExercise>
)

data class LearningUnit(
    val id: String,
    val title: String,
    val summary: String,
    val lessons: List<LearningLesson>
)

object CourseCatalog {
    val levels: List<String> = listOf("A1", "A2", "B1", "B2", "C1")

    private fun e(id: String, skill: Skill, instruction: String, prompt: String,
                  answer: String, explanation: String, options: List<String> = emptyList(),
                  context: String = "", audio: String? = null, sample: String? = null) =
        LearningExercise(id, skill, instruction, prompt, context, options, listOf(answer), explanation, audio, sample)

    private fun lesson(level: String, id: String, title: String, canDo: String, vararg exercises: LearningExercise) =
        LearningLesson("$level-$id", title, canDo, exercises.toList())

    private val catalog: Map<String, List<LearningUnit>> = mapOf(
        "A1" to listOf(
            LearningUnit("A1-U1", "Hello & Introductions", "Greetings, names and basic personal information.", listOf(
                lesson("A1", "U1-L1", "Hello!", "Greet someone and introduce yourself.",
                    e("a1-greet-listen", Skill.LISTENING, "Dinle ve doğru cevabı seç", "What does Anna say?", "Hello, I'm Anna.", "'I'm' is the short form of 'I am'.", listOf("Goodbye, Anna.", "Hello, I'm Anna.", "Where is Anna?"), audio = "Hello, I'm Anna."),
                    e("a1-greet-grammar", Skill.GRAMMAR, "Boşluğu tamamla", "I ___ Mehmet.", "am", "I ile am kullanılır: I am Mehmet.", listOf("is", "am", "are")),
                    e("a1-greet-speak", Skill.SPEAKING, "Cümleyi sesli söyle", "Say: Hello, I'm Mehmet.", "Hello, I'm Mehmet.", "Önce selam ver, sonra adını söyle.", audio = "Hello, I'm Mehmet.", sample = "Hello, I'm Mehmet."),
                    e("a1-greet-write", Skill.WRITING, "Kendini tanıt: İngilizce yaz", "Write: Merhaba, ben Ayşe.", "Hello, I'm Ayşe.", "Hello, I'm … kalıbıyla başlayabilirsin.", sample = "Hello, I'm Ayşe.")),
                lesson("A1", "U1-L2", "Where are you from?", "Ask and answer a simple question about country.",
                    e("a1-country-vocab", Skill.VOCABULARY, "Doğru anlamı seç", "'Türkiye' in English is…", "Türkiye", "Ülke adı İngilizcede de Türkiye olarak kullanılabilir.", listOf("Turkish", "Türkiye", "Turk")),
                    e("a1-country-grammar", Skill.GRAMMAR, "Doğru seçeneği seç", "Where ___ you from?", "are", "You ile are kullanılır: Where are you from?", listOf("is", "are", "am")),
                    e("a1-country-read", Skill.READING, "Metni oku ve yanıtla", "Where is Elif from?", "Türkiye", "Metinde 'I'm from Türkiye' diyor.", listOf("Italy", "Türkiye", "Spain"), context = "Hi! I'm Elif. I'm from Türkiye. Nice to meet you."),
                    e("a1-country-write", Skill.WRITING, "Kendi cevabını yaz", "Complete: I'm from ___.", "Türkiye", "Kendi ülkenin adını yaz. Örnek cevap Türkiye.", sample = "I'm from Türkiye.")),
                lesson("A1", "U1-L3", "Can you spell it?", "Ask for and give a name's spelling.",
                    e("a1-spell-dialogue", Skill.LISTENING, "Dinle ve harfleri seç", "How do you spell L-E-A?", "Lea", "İsim harf harf söylenir.", listOf("Lee", "Lea", "Lia"), audio = "L E A. Lea."),
                    e("a1-spell-phrase", Skill.SPEAKING, "İfadeyi tekrar et", "Say: How do you spell your name?", "How do you spell your name?", "'How do you spell…?' yazılışı sormak için kullanılır.", audio = "How do you spell your name?", sample = "How do you spell your name?"))))),
            LearningUnit("A1-U2", "People & Everyday Life", "Describe people and talk about simple routines.", listOf(
                lesson("A1", "U2-L1", "This is my family", "Name close family members and describe one person.",
                    e("a1-family-vocab", Skill.VOCABULARY, "Doğru kelimeyi seç", "Your mother's daughter is your…", "sister", "Mother's daughter (you or another girl) is a sister.", listOf("sister", "uncle", "grandfather")),
                    e("a1-family-grammar", Skill.GRAMMAR, "Boşluğu tamamla", "This is ___ brother.", "my", "my sahiplik bildirir: my brother.", listOf("I", "my", "me")),
                    e("a1-family-read", Skill.READING, "Metni oku", "How many people are in Sam's family?", "four", "Metinde Sam, anne, baba ve kız kardeş var.", listOf("two", "three", "four"), context = "This is my family. My mother is Lisa. My father is Tom. I have one sister. We are four.")),
                lesson("A1", "U2-L2", "My day", "Understand and write a simple daily routine.",
                    e("a1-routine-grammar", Skill.GRAMMAR, "Doğru fiili seç", "I ___ breakfast at seven.", "have", "I ile temel geniş zamanda fiilin yalın biçimi kullanılır.", listOf("has", "have", "having")),
                    e("a1-routine-listen", Skill.LISTENING, "Dinle ve saati seç", "What time does Mia get up?", "seven", "Mia 'I get up at seven' diyor.", listOf("six", "seven", "eight"), audio = "I get up at seven."),
                    e("a1-routine-write", Skill.WRITING, "Günlük rutininden bir cümle yaz", "Write one sentence beginning: I get up…", "I get up at seven.", "Saat için at kullan: at seven.", sample = "I get up at seven."))))),
        "A2" to listOf(
            LearningUnit("A2-U1", "Travel & Getting Around", "Ask for travel information and handle simple arrangements.", listOf(
                lesson("A2", "U1-L1", "At the station", "Ask when a train leaves and understand a short announcement.",
                    e("a2-station-listen", Skill.LISTENING, "Duyuruyu dinle", "What time does the train leave?", "nine thirty", "The announcement says nine thirty.", listOf("nine fifteen", "nine thirty", "ten thirty"), audio = "The train to Ankara leaves at nine thirty."),
                    e("a2-station-grammar", Skill.GRAMMAR, "Doğru soruyu seç", "Ask about departure time:", "When does it leave?", "Present simple soru: When does + subject + base verb?", listOf("When it leaves?", "When does it leave?", "When do it leave?")),
                    e("a2-station-speak", Skill.SPEAKING, "Bilet gişesinde söyle", "Ask for a ticket to Ankara.", "A ticket to Ankara, please.", "Kibar bir istek için please kullan.", audio = "A ticket to Ankara, please.", sample = "A ticket to Ankara, please.")),
                lesson("A2", "U1-L2", "A weekend away", "Describe a completed trip using simple past.",
                    e("a2-trip-read", Skill.READING, "Notu oku", "Where did Leo stay?", "a small hotel", "Metinde 'I stayed in a small hotel' yazıyor.", listOf("a campsite", "a small hotel", "a friend's house"), context = "Last weekend I went to İzmir. I stayed in a small hotel and visited the old market."),
                    e("a2-trip-grammar", Skill.GRAMMAR, "Doğru fiili seç", "Last year, we ___ Cappadocia.", "visited", "Geçmişte tamamlanmış eylem: visit → visited.", listOf("visit", "visited", "visiting")),
                    e("a2-trip-write", Skill.WRITING, "Geçmiş bir gezi hakkında bir cümle yaz", "Complete: Last weekend, I…", "visited", "Örnek: Last weekend, I visited İzmir.", sample = "Last weekend, I visited İzmir."))))),
        "B1" to listOf(
            LearningUnit("B1-U1", "Everyday & Work Conversations", "Share experiences and manage routine workplace communication.", listOf(
                lesson("B1", "U1-L1", "Schedule a meeting", "Make a polite request and agree on a meeting time.",
                    e("b1-meeting-phrase", Skill.SPEAKING, "İfadeyi sesli söyle", "Say: I'd like to schedule a meeting.", "I'd like to schedule a meeting.", "I'd like to… kibar bir talep başlatır.", audio = "I'd like to schedule a meeting.", sample = "I'd like to schedule a meeting."),
                    e("b1-meeting-grammar", Skill.GRAMMAR, "Doğru yapıyı seç", "I'd like ___ a meeting.", "to schedule", "Would like + to + fiilin yalın biçimi.", listOf("schedule", "to schedule", "scheduling")),
                    e("b1-meeting-read", Skill.READING, "E-postayı oku", "What does Alex suggest?", "Tuesday at ten", "Alex salı saat onda buluşmayı öneriyor.", listOf("Monday at ten", "Tuesday at ten", "Tuesday at two"), context = "Hi Maya, could we meet to discuss the launch? I'm free Tuesday at 10. Best, Alex.")),
                lesson("B1", "U1-L2", "Tell a work story", "Describe a past experience and explain its result.",
                    e("b1-story-grammar", Skill.GRAMMAR, "Boşluğu tamamla", "I ___ on three international projects so far.", "have worked", "So far, bugüne kadar devam eden deneyim için present perfect kullanılır.", listOf("worked", "have worked", "am working")),
                    e("b1-story-listen", Skill.LISTENING, "Dinle ve ana fikri seç", "Why was the team late?", "The client changed the brief.", "Konuşmacı gecikme sebebi olarak değişen brief'i açıklıyor.", listOf("The train was late.", "The client changed the brief.", "The team was on holiday."), audio = "We had to revise the design because the client changed the brief."),
                    e("b1-story-write", Skill.WRITING, "Bir deneyimini iki kısa cümleyle anlat", "Write about a project you have completed.", "I have completed a project.", "Zaman ifadesi ve sonuç ekle; örnek cevap tek olası yanıt değildir.", sample = "I have completed a project for a new client. We delivered it on time."))))),
        "B2" to listOf(
            LearningUnit("B2-U1", "Meetings & Persuasion", "Contribute clearly to a discussion and support a position with reasons.", listOf(
                lesson("B2", "U1-L1", "Make your point", "Present and qualify an opinion in a meeting.",
                    e("b2-point-vocab", Skill.VOCABULARY, "Bağlaçla en uygun tamamlamayı seç", "The proposal is promising; ___, we need more data.", "however", "However, önceki fikre karşıt/dengeleyici nokta ekler.", listOf("however", "because", "therefore")),
                    e("b2-point-grammar", Skill.GRAMMAR, "Doğru seçeneği seç", "If we ___ the launch, we could improve quality.", "delayed", "İkinci koşul: If + past simple, would/could + base verb.", listOf("delay", "delayed", "will delay")),
                    e("b2-point-write", Skill.WRITING, "Görüş + gerekçe yaz", "Should a team work remotely? Give one reason.", "Remote work can improve focus.", "Görüşünü gerekçeyle destekle; model cevap örnektir.", sample = "Remote work can improve focus because employees have fewer interruptions.")),
                lesson("B2", "U1-L2", "Negotiate a deadline", "Suggest a compromise and clarify constraints.",
                    e("b2-negotiate-listen", Skill.LISTENING, "Konuşmayı dinle", "What compromise do they reach?", "A Friday draft and a final version Monday.", "Taraflar önce taslak, sonra nihai teslim üzerinde anlaşıyor.", listOf("Cancel the project.", "A Friday draft and a final version Monday.", "Deliver everything today."), audio = "I can send you a draft by Friday, then the final version on Monday."),
                    e("b2-negotiate-phrase", Skill.SPEAKING, "Kibar karşı teklif et", "Say: Would you be open to moving the deadline to Friday?", "Would you be open to moving the deadline to Friday?", "Would you be open to…? yumuşak bir karşı teklif sunar.", audio = "Would you be open to moving the deadline to Friday?", sample = "Would you be open to moving the deadline to Friday?"))))),
        "C1" to listOf(
            LearningUnit("C1-U1", "Nuance & Professional Influence", "Synthesize perspectives, qualify claims and adapt register.", listOf(
                lesson("C1", "U1-L1", "Qualify a claim", "Use precise hedging to express a cautious conclusion.",
                    e("c1-hedge-vocab", Skill.VOCABULARY, "Akademik/iş bağlamına en uygun ifadeyi seç", "The evidence ___ suggests a link, but is not conclusive.", "appears to", "Appears to, kesinlik iddiasını ölçülü biçimde sınırlar.", listOf("proves", "appears to", "obviously proves")),
                    e("c1-hedge-read", Skill.READING, "Parçayı oku", "What limitation does the author mention?", "The sample is small.", "Yazar, sonuçları genellemeyi sınırlayan küçük örneklemden söz ediyor.", listOf("The sample is small.", "The method is illegal.", "The data is too old."), context = "The pilot produced encouraging results. However, given the small sample, the findings should be treated as provisional."),
                    e("c1-hedge-write", Skill.WRITING, "İddiayı daha temkinli yeniden yaz", "Rewrite cautiously: This proves the policy works.", "This suggests the policy may work.", "C1'de kesin iddiayı evidence ile orantılı biçimde sınırla.", sample = "This suggests the policy may be effective, although further evidence is needed.")),
                lesson("C1", "U1-L2", "Synthesize viewpoints", "Summarize two positions and state a balanced conclusion.",
                    e("c1-synthesis-listen", Skill.LISTENING, "Görüşmeleri dinle", "What do both speakers agree on?", "The rollout needs evaluation.", "İkisi de uygulamanın sonuçlarının ölçülmesini destekliyor.", listOf("The plan should be abandoned.", "The rollout needs evaluation.", "Costs do not matter."), audio = "Although we differ on timing, we agree that the rollout should be carefully evaluated."),
                    e("c1-synthesis-grammar", Skill.GRAMMAR, "Anlamı koruyan geçiş ifadesini seç", "___ the benefits, the proposal carries significant risks.", "Notwithstanding", "Notwithstanding = -e rağmen; resmî/ileri register.", listOf("Notwithstanding", "Because", "So that")),
                    e("c1-synthesis-speak", Skill.SPEAKING, "İki tarafı özetleyen bir cümle söyle", "Summarize both views before giving a conclusion.", "Both options have advantages.", "Önce ortak/karşıt noktaları adil biçimde özetle.", audio = "Both options have advantages.", sample = "While both options have advantages, the phased approach appears less risky."))))),
    )

    fun units(level: String): List<LearningUnit> = catalog[level] ?: catalog.getValue("A1")
    fun firstLesson(level: String): LearningLesson = units(level).first().lessons.first()
    fun lessonAt(level: String, lessonIndex: Int): LearningLesson {
        val lessons = units(level).flatMap { it.lessons }
        return lessons[lessonIndex.mod(lessons.size)]
    }
    fun lessonCount(level: String): Int = units(level).sumOf { it.lessons.size }
    fun allLessons(): List<LearningLesson> = levels.flatMap { level -> units(level).flatMap { it.lessons } }
}
