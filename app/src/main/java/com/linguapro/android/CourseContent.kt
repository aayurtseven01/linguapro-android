package com.linguapro.android

import kotlinx.serialization.Serializable

/** Content is data, separate from presentation, so editors/reviewers can audit learning objectives. */
@Serializable
enum class Skill { LISTENING, READING, SPEAKING, WRITING, GRAMMAR, VOCABULARY }

@Serializable
data class TargetVocabulary(
    val id: String,
    val termEn: String,
    val translationTr: String,
    val partOfSpeech: String,
    val exampleEn: String,
    val exampleTr: String,
    val emoji: String = "📘"
)

@Serializable
data class GrammarFocus(
    val titleTr: String,
    val explanationTr: String,
    val form: String,
    val englishExample: String,
    val turkishEquivalent: String,
    val commonTurkishErrorTr: String,
    val checkPromptTr: String = "",
    val correctAnswer: String = "",
    val checkOptions: List<String> = emptyList()
)

@Serializable
enum class LessonStageType { VOCABULARY, GRAMMAR, LISTENING, READING, WRITING, SPEAKING }

@Serializable
data class LessonStage(
    val type: LessonStageType,
    val titleTr: String,
    val instructionTr: String,
    val modelText: String = "",
    val translationTr: String = ""
)

@Serializable
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

@Serializable
data class LearningLesson(
    val id: String,
    val title: String,
    val canDo: String,
    val exercises: List<LearningExercise>,
    val targetVocabulary: List<TargetVocabulary> = emptyList(),
    val grammarFocus: GrammarFocus? = null,
    val stages: List<LessonStage> = emptyList()
)

@Serializable
data class LearningUnit(
    val id: String,
    val title: String,
    val summary: String,
    val lessons: List<LearningLesson>
)

@Serializable
data class CourseContentPack(
    val schemaVersion: Int,
    val contentVersion: String,
    val units: List<LearningUnit>
)

object CourseCatalog {
    val levels: List<String> = listOf("A1", "A2", "B1", "B2", "C1")

    private fun e(id: String, skill: Skill, instruction: String, prompt: String,
                  answer: String, explanation: String, options: List<String> = emptyList(),
                  context: String = "", audio: String? = null, sample: String? = null) =
        LearningExercise(id, skill, instruction, prompt, context, options, listOf(answer), explanation, audio, sample)

    private fun lesson(level: String, id: String, title: String, canDo: String, vararg exercises: LearningExercise) =
        LearningLesson("$level-$id", title, canDo, exercises.toList())

    private fun extraUnit(
        level: String, number: Int, title: String, summary: String,
        title1: String, outcome1: String, first1: LearningExercise, second1: LearningExercise,
        title2: String, outcome2: String, first2: LearningExercise, second2: LearningExercise
    ) = LearningUnit("$level-U$number", title, summary, listOf(
        lesson(level, "U${number}-L1", title1, outcome1, first1, second1),
        lesson(level, "U${number}-L2", title2, outcome2, first2, second2)
    ))

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
                    e("a1-spell-phrase", Skill.SPEAKING, "İfadeyi tekrar et", "Say: How do you spell your name?", "How do you spell your name?", "'How do you spell…?' yazılışı sormak için kullanılır.", audio = "How do you spell your name?", sample = "How do you spell your name?")))),
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

    private val additionalUnits: Map<String, List<LearningUnit>> = mapOf(
        "A1" to listOf(
            extraUnit("A1", 3, "Food & Café", "Order food and ask for a simple item.",
                "A drink, please", "Order a drink politely.",
                e("a1-food-listen", Skill.LISTENING, "Siparişi dinle", "What would the customer like?", "tea", "The customer asks for tea.", listOf("tea", "coffee", "water"), audio = "A cup of tea, please."),
                e("a1-food-grammar", Skill.GRAMMAR, "En kibar isteği seç", "___ I have a coffee, please?", "Can", "Can I have…? basit ve kibar bir istektir.", listOf("Can", "Am", "Does")),
                "At the market", "Ask the price and identify a quantity.",
                e("a1-market-read", Skill.READING, "Fiyat etiketini oku", "How much are the apples?", "two pounds", "Etikette apples: £2 yazıyor.", listOf("one pound", "two pounds", "three pounds"), context = "Apples £2 per bag. Oranges £3 per bag."),
                e("a1-market-speak", Skill.SPEAKING, "Fiyatı sor", "Say: How much is this?", "How much is this?", "How much is this? bir ürünün fiyatını sormak için kullanılır.", audio = "How much is this?", sample = "How much is this?")),
            extraUnit("A1", 4, "My Home & Neighborhood", "Name rooms and say where familiar objects are.",
                "Rooms at home", "Understand a simple home description.",
                e("a1-home-read", Skill.READING, "Evi anlatan metni oku", "Where is the table?", "in the kitchen", "Metin masanın mutfakta olduğunu söylüyor.", listOf("in the bedroom", "in the kitchen", "in the garden"), context = "My home is small. There is a table in the kitchen and a bed in the bedroom."),
                e("a1-home-grammar", Skill.GRAMMAR, "Doğru seçeneği seç", "There ___ a bed in the room.", "is", "Tekil isimle there is kullanılır.", listOf("is", "are", "am")),
                "Places near me", "Name a familiar place and ask where it is.",
                e("a1-place-vocab", Skill.VOCABULARY, "Kelimeyi tamamla", "You buy bread at a…", "bakery", "Bakery ekmek alınan fırındır.", listOf("bakery", "library", "station")),
                e("a1-place-write", Skill.WRITING, "Yakınındaki bir yeri yaz", "Complete: There is a ___ near my home.", "shop", "Örnek cevap: There is a shop near my home.", sample = "There is a shop near my home.")),
            extraUnit("A1", 5, "Free Time & Review", "Talk about hobbies and complete a short everyday mission.",
                "What do you like?", "Ask and answer about a simple hobby.",
                e("a1-hobby-grammar", Skill.GRAMMAR, "Doğru fiili seç", "I like ___ music.", "listening to", "Like + -ing yaygın hobi anlatımıdır.", listOf("listen", "listening to", "listened")),
                e("a1-hobby-speak", Skill.SPEAKING, "Hobini sesli söyle", "Say: I like reading.", "I like reading.", "I like + activity-ing hobileri anlatır.", audio = "I like reading.", sample = "I like reading."),
                "A1 review mission", "Combine a greeting, a personal detail and a simple request.",
                e("a1-review-listen", Skill.LISTENING, "Kısa konuşmayı dinle", "What does the speaker need?", "a map", "Konuşmacı şehir haritası istiyor.", listOf("a map", "a ticket", "a menu"), audio = "Hello, I'm Deniz. I'm from Türkiye. Can I have a map, please?"),
                e("a1-review-write", Skill.WRITING, "Kendin hakkında iki bilgi yaz", "Write your name and country in English.", "I'm from Türkiye.", "Kısa, anlaşılır iki kişisel cümle yaz.", sample = "I'm Ece. I'm from Türkiye."))
        ),
        "A2" to listOf(
            extraUnit("A2", 2, "Food, Health & Requests", "Handle everyday services and describe a simple problem.",
                "At the pharmacy", "Explain a familiar symptom and understand a simple suggestion.",
                e("a2-health-listen", Skill.LISTENING, "Eczacı konuşmasını dinle", "What should the customer do?", "take one tablet", "The instruction is to take one tablet.", listOf("take one tablet", "drink coffee", "call a taxi"), audio = "Take one tablet twice a day, and drink plenty of water."),
                e("a2-health-grammar", Skill.GRAMMAR, "Tavsiye kalıbını seç", "You ___ drink more water.", "should", "Should basit tavsiye vermek için kullanılır.", listOf("should", "would", "did")),
                "Make a polite request", "Ask for help and clarify a simple service detail.",
                e("a2-request-speak", Skill.SPEAKING, "Kibarca yardım iste", "Say: Could you help me, please?", "Could you help me, please?", "Could you…? can'den daha kibar duyulur.", audio = "Could you help me, please?", sample = "Could you help me, please?"),
                e("a2-request-write", Skill.WRITING, "Kısa bir mesaj yaz", "Ask a friend to call you after work.", "Could you call me after work?", "Kısa mesajda isteği ve zamanı belirt.", sample = "Could you call me after work?")),
            extraUnit("A2", 3, "Plans & Experiences", "Talk about near-future plans and compare familiar options.",
                "Weekend plans", "Describe a simple intention using going to.",
                e("a2-plan-grammar", Skill.GRAMMAR, "Boşluğu tamamla", "We are ___ visit our grandparents.", "going to", "Plan/intention: be + going to + base verb.", listOf("going to", "go to", "will to")),
                e("a2-plan-listen", Skill.LISTENING, "Planı dinle", "What are they going to do on Saturday?", "visit a museum", "Konuşmacılar cumartesi müzeyi ziyaret edecek.", listOf("visit a museum", "watch a match", "stay at home"), audio = "On Saturday, we're going to visit the new museum."),
                "Choose a place", "Compare two familiar places and explain a preference.",
                e("a2-compare-grammar", Skill.GRAMMAR, "Karşılaştırmayı seç", "The train is ___ than the bus.", "faster", "Kısa sıfatlarda comparative için -er kullanılır.", listOf("fast", "faster", "fastest")),
                e("a2-compare-write", Skill.WRITING, "İki ulaşım türünü karşılaştır", "Complete: The bus is ___ than the train.", "cheaper", "Cheaper, cheaper anlamında karşılaştırma biçimidir.", sample = "The bus is cheaper than the train."))
        ),
        "B1" to listOf(
            extraUnit("B1", 2, "Stories & Experiences", "Narrate events clearly and connect them to present experience.",
                "A memorable day", "Describe the order of events in a familiar story.",
                e("b1-story-order", Skill.GRAMMAR, "Olay sırasını seç", "___ we arrived, the presentation had already started.", "When", "When olay zamanını bağlar; past perfect daha önceki olayı gösterir.", listOf("When", "Although", "Unless")),
                e("b1-story-read", Skill.READING, "Hikâyeyi oku", "Why did Lina miss the bus?", "She left home late.", "Lina evden geç çıktığını söylüyor.", listOf("She left home late.", "The bus broke down.", "She forgot her bag."), context = "I left home late, so I missed the bus. Luckily, my colleague gave me a lift."),
                "Explain a result", "Explain what changed after a work or study experience.",
                e("b1-result-vocab", Skill.VOCABULARY, "Neden-sonuç bağlacını seç", "The file was missing; ___, we delayed the report.", "therefore", "Therefore sonuç bildirir.", listOf("therefore", "meanwhile", "although")),
                e("b1-result-write", Skill.WRITING, "Deneyim ve sonucu bağla", "Write one sentence with because or so.", "I was late because the bus was delayed.", "Neden ile sonucu açıkça ilişkilendir.", sample = "I was late because the bus was delayed.")),
            extraUnit("B1", 3, "Opinions & Problem Solving", "State a view, support it and agree on a practical next step.",
                "Give a reasoned opinion", "Express an opinion and one supporting reason.",
                e("b1-opinion-phrase", Skill.SPEAKING, "Görüş bildir", "Say: In my opinion, we should start earlier.", "In my opinion, we should start earlier.", "Görüş + should + fiil öneri verir.", audio = "In my opinion, we should start earlier.", sample = "In my opinion, we should start earlier."),
                e("b1-opinion-grammar", Skill.GRAMMAR, "Koşul cümlesini tamamla", "If we leave now, we ___ arrive on time.", "will", "First conditional: if + present, will + base verb.", listOf("will", "would", "did")),
                "Write a clear work email", "Write a short update with a request and a deadline.",
                e("b1-email-read", Skill.READING, "E-postayı oku", "When does Jamie need the draft?", "Thursday", "Jamie taslağı perşembeye kadar istiyor.", listOf("Tuesday", "Thursday", "Friday"), context = "Hi, could you send me the first draft by Thursday? I will review it before the client meeting."),
                e("b1-email-write", Skill.WRITING, "Kısa iş güncellemesi yaz", "Tell a colleague when you will send a draft.", "I will send the draft tomorrow.", "Kısa güncelleme: durum + net zaman.", sample = "I will send the draft tomorrow."))
        ),
        "B2" to listOf(
            extraUnit("B2", 2, "Reports & Evidence", "Summarize evidence and distinguish a claim from its support.",
                "Evaluate a claim", "Identify the evidence that supports a conclusion.",
                e("b2-evidence-read", Skill.READING, "Raporu oku", "What supports the recommendation?", "A six-month pilot", "Öneri altı aylık pilot sonuçlarına dayanıyor.", listOf("A six-month pilot", "A personal guess", "A customer quote only"), context = "A six-month pilot reduced response times by 18%. The report recommends a phased expansion, while noting that the sample covered only two regions."),
                e("b2-evidence-vocab", Skill.VOCABULARY, "Kanıtı sınırlayan ifadeyi seç", "The findings are promising, ___ the small sample.", "given", "Given burada 'göz önünde bulundurulduğunda' anlamı katar.", listOf("given", "despite of", "whereas of")),
                "Present a recommendation", "Make a recommendation and acknowledge one limitation.",
                e("b2-recommend-speak", Skill.SPEAKING, "Önerini ve sınırını söyle", "Recommend a pilot before a full launch.", "We should run a pilot first.", "Öneriyi açıkça ifade edip sınırlılığı da kabul et.", audio = "We should run a pilot first.", sample = "We should run a pilot first, as the evidence is still limited."),
                e("b2-recommend-write", Skill.WRITING, "Bir öneriyi gerekçelendir", "Write a recommendation with one piece of evidence.", "The pilot improved response time.", "İddia ve kanıtı birbirine bağla.", sample = "I recommend a phased launch because the pilot improved response time.")),
            extraUnit("B2", 3, "Culture, Register & Nuance", "Adapt wording to a professional audience and manage disagreement.",
                "Disagree diplomatically", "Disagree without dismissing a colleague's point.",
                e("b2-diplomatic-phrase", Skill.SPEAKING, "Nazikçe karşı çık", "Say: I see your point; however, I have a different concern.", "I see your point however I have a different concern", "Önce karşı tarafın noktasını kabul et, sonra çekinceni açıkla.", audio = "I see your point; however, I have a different concern.", sample = "I see your point; however, I have a different concern."),
                e("b2-register-vocab", Skill.VOCABULARY, "Profesyonel e-postaya uygun ifadeyi seç", "Could you ___ the revised file by noon?", "send", "Doğrudan ama nazik rica profesyonel bağlama uygundur.", listOf("send", "gimme", "hand over me")),
                "Clarify an implied meaning", "Infer a cautious response from a short exchange.",
                e("b2-infer-listen", Skill.LISTENING, "Yanıtı dinle", "Is Priya fully convinced?", "No, she wants more evidence.", "'I'd need to see the figures first' temkinli olduğunu gösterir.", listOf("Yes, completely.", "No, she wants more evidence.", "She has not heard the idea."), audio = "That could work. I'd need to see the figures first."),
                e("b2-infer-write", Skill.WRITING, "Kibar bir takip sorusu yaz", "Ask when the figures will be available.", "When will the figures be available?", "Açık, nazik ve bağlama uygun soru kur.", sample = "Could you let me know when the figures will be available?"))
        ),
        "C1" to listOf(
            extraUnit("C1", 2, "Register & Rhetoric", "Adapt register and use rhetorical choices with control.",
                "Shift register", "Rephrase an informal request for a formal audience.",
                e("c1-register-vocab", Skill.VOCABULARY, "Daha resmî seçeneği işaretle", "We need to fix this ASAP.", "We should address this as a priority.", "Address this as a priority resmî ve profesyonel tondadır.", listOf("We should address this as a priority.", "Let's fix this thing now.", "Sort it out ASAP.")),
                e("c1-register-write", Skill.WRITING, "Resmî bir yeniden ifade yaz", "Rewrite: Send me the report today.", "Could you send me the report by the end of today?", "Kibarlık ve net zaman sınırı ekle.", sample = "Could you send me the report by the end of today?"),
                "Frame a persuasive case", "Anticipate a counterargument and respond proportionately.",
                e("c1-rhetoric-read", Skill.READING, "Argümanı oku", "What qualification does the writer make?", "The recommendation depends on continued monitoring.", "Yazar öneriyi izleme koşuluna bağlıyor.", listOf("The recommendation depends on continued monitoring.", "The plan has no risks.", "The data is irrelevant."), context = "The evidence supports a phased rollout, provided that outcomes are monitored and the policy is revised if access gaps widen."),
                e("c1-rhetoric-speak", Skill.SPEAKING, "Karşı görüşü tanıyarak yanıt ver", "Say: That concern is valid; the question is how we mitigate it.", "That concern is valid the question is how we mitigate it", "Geçerli çekinceyi kabul et, sonra çözüm odağına geç.", audio = "That concern is valid; the question is how we mitigate it.", sample = "That concern is valid; the question is how we mitigate it.")),
            extraUnit("C1", 3, "Synthesis & Independent Use", "Integrate evidence from viewpoints and produce a concise conclusion.",
                "Compare two viewpoints", "Identify agreement and a meaningful difference.",
                e("c1-viewpoints-listen", Skill.LISTENING, "İki konuşmacıyı dinle", "Where do they disagree?", "The pace of implementation.", "İkisi hedefte hemfikir, ancak uygulama hızında ayrışıyor.", listOf("The goal itself.", "The pace of implementation.", "Whether evaluation is useful."), audio = "We both support the goal. I favour a gradual rollout, while Sam would move faster."),
                e("c1-viewpoints-grammar", Skill.GRAMMAR, "Karşıtlığı en iyi bağlayan yapıyı seç", "___ both speakers support the goal, they differ on timing.", "Although", "Although karşıt iki bilgiyi aynı cümlede dengeler.", listOf("Although", "Because", "Unless")),
                "Write a concise synthesis", "Combine two views and conclude with an evidence-based recommendation.",
                e("c1-synthesis-write", Skill.WRITING, "İki görüşü bir cümlede sentezle", "Write a balanced conclusion about pace and risk.", "A phased rollout may reduce risk.", "Sentez, iki görüşü adil özetleyip gerekçeli sonuç sunar.", sample = "Although faster implementation may capture benefits sooner, a phased rollout allows risks to be monitored."),
                e("c1-synthesis-vocab", Skill.VOCABULARY, "Sonuç bildiren akademik ifadeyi seç", "Taken together, the findings ___.", "suggest a cautious expansion", "Taken together, evidence sentezine dayalı sonuç başlatır.", listOf("suggest a cautious expansion", "prove every claim", "ignore the sample")))
        )
    )

    private val completeCatalog: Map<String, List<LearningUnit>> = levels.associateWith { level ->
        catalog.getValue(level) + additionalUnits[level].orEmpty() + CourseExpansion.units(level) + CourseExpansionAdvanced.units(level) + CourseExpansionMastery.units(level) + CourseExpansionCoverage.units(level)
    }

    fun units(level: String): List<LearningUnit> = completeCatalog[level] ?: if (level == "C2") emptyList() else completeCatalog.getValue("A1")
    fun firstLesson(level: String): LearningLesson = units(level).first().lessons.first()
    fun lessonAt(level: String, lessonIndex: Int): LearningLesson {
        val lessons = units(level).flatMap { it.lessons }
        return lessons[lessonIndex.mod(lessons.size)]
    }
    fun lessonCount(level: String): Int = units(level).sumOf { it.lessons.size }
    fun allLessons(): List<LearningLesson> = levels.flatMap { level -> units(level).flatMap { it.lessons } }
}
