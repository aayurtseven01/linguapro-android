package com.linguapro.android

/** Original supplemental units extending the starter seed. Each activity has an auditable answer key/model. */
object CourseExpansion {
    private fun activity(
        id: String, skill: Skill, instruction: String, prompt: String, answer: String,
        explanation: String, options: List<String> = emptyList(), passage: String = "",
        audio: String? = null, sample: String? = null
    ) = LearningExercise(
        id = id, skill = skill, instructionTr = instruction, prompt = prompt,
        context = passage, options = options, acceptedAnswers = listOf(answer),
        explanationTr = explanation, modelAudioText = audio, sampleAnswer = sample
    )

    private fun lesson(level: String, unit: Int, number: Int, title: String, outcome: String,
                       vararg activities: LearningExercise) = LearningLesson(
        "$level-U$unit-L$number", title, outcome, activities.toList()
    )

    private fun unit(level: String, number: Int, title: String, summary: String,
                     first: LearningLesson, second: LearningLesson) = LearningUnit(
        "$level-U$number", title, summary, listOf(first, second)
    )

    private val content: Map<String, List<LearningUnit>> = mapOf(
        "A1" to listOf(
            unit("A1", 6, "Around Town", "Ask for and understand simple directions and transport information.",
                lesson("A1", 6, 1, "Find the library", "Ask where a familiar place is and follow a short direction.",
                    activity("a1-town-listen", Skill.LISTENING, "Yön tarifini dinle", "Where is the bank?", "next to the post office", "Konuşmacı bankanın postanenin yanında olduğunu söylüyor.", listOf("next to the post office", "behind the station", "opposite the school"), audio = "The bank is next to the post office."),
                    activity("a1-town-grammar", Skill.GRAMMAR, "Doğru edatı seç", "The café is ___ the station and the park.", "between", "Between iki yer arasında konum bildirir.", listOf("between", "under", "at"))),
                lesson("A1", 6, 2, "How do I get there?", "Name a simple transport option and give a short direction.",
                    activity("a1-town-read", Skill.READING, "Bilgi notunu oku", "Which bus goes to the museum?", "bus 4", "Bilgi notunda müzeye giden otobüs 4 olarak belirtiliyor.", listOf("bus 2", "bus 4", "bus 14"), passage = "City Museum: Take bus 4 from the town centre. Get off at King Street. The museum is opposite the park."),
                    activity("a1-town-speak", Skill.SPEAKING, "Yön sormayı sesli söyle", "Say: Excuse me, where is the bus station?", "Excuse me where is the bus station", "Kibarca dikkat çekip where is…? ile yer sor.", audio = "Excuse me, where is the bus station?", sample = "Excuse me, where is the bus station?"))),
            unit("A1", 7, "Weather & Clothes", "Describe today's weather and choose suitable clothes.",
                lesson("A1", 7, 1, "What's the weather like?", "Understand a simple forecast and describe the weather.",
                    activity("a1-weather-listen", Skill.LISTENING, "Hava durumu tahminini dinle", "What is the weather like this afternoon?", "rainy", "Tahminde öğleden sonra yağmur beklendiği söyleniyor.", listOf("sunny", "rainy", "windy"), audio = "It is sunny this morning, but rainy this afternoon."),
                    activity("a1-weather-vocab", Skill.VOCABULARY, "Uygun kelimeyi seç", "You need an umbrella when it is…", "rainy", "Şemsiyeyi yağmurlu havada kullanırız.", listOf("rainy", "cloudy", "warm"))),
                lesson("A1", 7, 2, "Getting dressed", "Name familiar clothes and describe what someone is wearing.",
                    activity("a1-clothes-read", Skill.READING, "Kısa mesajı oku", "What is Nora wearing?", "a blue coat", "Mesaj Nora'nın mavi bir mont giydiğini söylüyor.", listOf("a blue coat", "a red dress", "black shoes"), passage = "It's cold today. I'm wearing my blue coat and warm boots. See you at the café!"),
                    activity("a1-clothes-grammar", Skill.GRAMMAR, "Boşluğu tamamla", "He ___ wearing a jacket today.", "is", "Tekil he ile present continuous yapısında is kullanılır.", listOf("am", "is", "are"))))
        ),
        "A2" to listOf(
            unit("A2", 4, "Work & Everyday Services", "Handle routine workplace exchanges and ask for practical help.",
                lesson("A2", 4, 1, "A busy workday", "Describe a routine and ask a colleague for help.",
                    activity("a2-work-read", Skill.READING, "İş mesajını oku", "What time does the meeting start?", "half past two", "Mesaj toplantının 14.30'da başladığını belirtiyor.", listOf("two o'clock", "half past two", "three thirty"), passage = "Hi team, our planning meeting starts at 2:30 in Room 5. Please bring the weekly figures."),
                    activity("a2-work-speak", Skill.SPEAKING, "Kibarca yardım iste", "Say: Could you send me the file before lunch?", "Could you send me the file before lunch", "Could you…? iş ortamında kibar rica başlatır.", audio = "Could you send me the file before lunch?", sample = "Could you send me the file before lunch?")),
                lesson("A2", 4, 2, "At the service desk", "Explain a simple problem and understand a service response.",
                    activity("a2-service-listen", Skill.LISTENING, "Çalışanla konuşmayı dinle", "When will the technician arrive?", "tomorrow morning", "Çalışan teknisyenin yarın sabah geleceğini söylüyor.", listOf("this afternoon", "tomorrow morning", "Friday evening"), audio = "The technician is busy today. He can come tomorrow morning."),
                    activity("a2-service-grammar", Skill.GRAMMAR, "Doğru yapıyı seç", "I ___ my key, so I can't open the door.", "have lost", "Şimdiki sonuçla ilgili yakın geçmiş deneyimi present perfect anlatabilir.", listOf("lost yesterday", "have lost", "am losing")))),
            unit("A2", 5, "Health & Invitations", "Talk about familiar symptoms, give basic advice and make plans.",
                lesson("A2", 5, 1, "How are you feeling?", "Describe a common symptom and understand simple advice.",
                    activity("a2-health-read2", Skill.READING, "Doktor notunu oku", "What should Omar do?", "rest and drink water", "Not dinlenmesini ve su içmesini öneriyor.", listOf("run five kilometres", "rest and drink water", "skip lunch"), passage = "Omar has a sore throat and feels tired. The nurse says: Rest at home today and drink plenty of water."),
                    activity("a2-health-grammar2", Skill.GRAMMAR, "Tavsiye cümlesini tamamla", "You have a headache. You ___ take a break.", "should", "Should, basit tavsiye verir.", listOf("should", "might to", "are"))),
                lesson("A2", 5, 2, "Making weekend plans", "Invite someone and agree on a simple arrangement.",
                    activity("a2-plan-listen2", Skill.LISTENING, "Planı dinle", "Where will they meet?", "outside the cinema", "İki kişi sinemanın dışında buluşmayı kararlaştırıyor.", listOf("at the station", "outside the cinema", "at the café"), audio = "Let's meet outside the cinema at six, before the film."),
                    activity("a2-plan-write2", Skill.WRITING, "Kısa bir davet mesajı yaz", "Invite a friend to meet on Saturday.", "Would you like to meet on Saturday?", "Davetini açık ve kibar bir soruyla yaz.", sample = "Would you like to meet on Saturday afternoon?")))
        ),
        "B1" to listOf(
            unit("B1", 4, "Learning & Career", "Discuss skills, plans and experience in study and work contexts.",
                lesson("B1", 4, 1, "Choosing a course", "Compare learning options and explain a preference.",
                    activity("b1-course-read", Skill.READING, "Kurs tanıtımını oku", "Which course includes live practice?", "the evening course", "Akşam kursu haftalık canlı konuşma oturumu sunuyor.", listOf("the online self-study course", "the evening course", "the weekend exam course"), passage = "The online course has recorded lessons. The evening course meets twice a week and includes a live speaking workshop. The weekend course focuses on exam practice."),
                    activity("b1-course-grammar", Skill.GRAMMAR, "İlgi cümlesini tamamla", "A mentor is someone ___ can guide your career.", "who", "İnsanlar için who ilgi zamiri kullanılır.", listOf("who", "where", "which"))),
                lesson("B1", 4, 2, "A professional introduction", "Summarize relevant experience and ask a follow-up question.",
                    activity("b1-career-listen", Skill.LISTENING, "Tanışma konuşmasını dinle", "How long has Eda worked in design?", "for three years", "Eda tasarım alanında üç yıldır çalıştığını belirtiyor.", listOf("for one year", "for three years", "for ten years"), audio = "I've worked in product design for three years, mostly with education teams."),
                    activity("b1-career-write", Skill.WRITING, "Kısa profesyonel tanıtım yaz", "Write one sentence about your experience and one goal.", "I have experience and a clear goal.", "Deneyimini ve hedefini kısa, anlaşılır iki cümlede sun.", sample = "I have worked in customer support for two years, and I hope to move into team leadership."))),
            unit("B1", 5, "Media & The Environment", "Understand a short report and explain causes and consequences.",
                lesson("B1", 5, 1, "A local news report", "Identify the main event and a supporting detail.",
                    activity("b1-news-read", Skill.READING, "Haber notunu oku", "Why was the road closed?", "a fallen tree", "Yol, fırtınada düşen ağaç nedeniyle kapatıldı.", listOf("a fallen tree", "a sports event", "road repairs"), passage = "A short storm hit the coast last night. A tree fell across the main road, so the road was closed for two hours. No one was hurt."),
                    activity("b1-news-vocab", Skill.VOCABULARY, "Sonuç bildiren kelimeyi seç", "The storm damaged the road; ___, buses used another route.", "therefore", "Therefore önceki durumun sonucunu bildirir.", listOf("therefore", "unless", "despite"))),
                lesson("B1", 5, 2, "Small changes, shared impact", "Describe a practical environmental action and its likely effect.",
                    activity("b1-green-listen", Skill.LISTENING, "Öneriyi dinle", "What does the speaker suggest?", "using a refillable bottle", "Konuşmacı tek kullanımlık şişe yerine yeniden doldurulabilir şişe öneriyor.", listOf("buying more plastic", "using a refillable bottle", "driving alone"), audio = "If more people carried a refillable bottle, we could reduce single-use plastic."),
                    activity("b1-green-speak", Skill.SPEAKING, "Bir öneri ve gerekçe söyle", "Suggest one way to reduce waste and explain why.", "We can reuse bags to reduce waste", "Önerini can ile, gerekçeni to ile veya because ile ekle.", audio = "We can reuse bags to reduce waste.", sample = "We can reuse shopping bags because this reduces single-use plastic.")))
        ),
        "B2" to listOf(
            unit("B2", 4, "Academic Discussion & Evidence", "Evaluate claims, qualify conclusions and contribute to structured discussion.",
                lesson("B2", 4, 1, "Separate claim from evidence", "Distinguish a measured result from an interpretation.",
                    activity("b2-evidence-read2", Skill.READING, "Araştırma özetini oku", "What did the study directly measure?", "weekly screen time", "Özet ölçülen değişkenin haftalık ekran süresi olduğunu söylüyor.", listOf("weekly screen time", "long-term memory", "teacher confidence"), passage = "In a six-week pilot with 120 learners, the team measured weekly screen time. Participants reported higher satisfaction, although the study did not test long-term retention."),
                    activity("b2-evidence-vocab2", Skill.VOCABULARY, "Temkinli sonucu seç", "The pilot is encouraging, but it does not ___ prove long-term impact.", "by itself", "By itself, tek başına anlamı katar ve kanıt sınırını belirtir.", listOf("by itself", "at random", "in advance"))),
                lesson("B2", 4, 2, "Respond to a counterargument", "Acknowledge an opposing point and answer with a reason.",
                    activity("b2-counter-speak", Skill.SPEAKING, "Karşı görüşü tanıyarak yanıtla", "Say: While cost is a concern, the phased plan limits risk.", "While cost is a concern the phased plan limits risk", "While karşıt görüşü kabul edip kendi gerekçene geçmeni sağlar.", audio = "While cost is a concern, the phased plan limits risk.", sample = "While cost is a concern, a phased plan gives us time to evaluate results."),
                    activity("b2-counter-grammar", Skill.GRAMMAR, "Cümleyi tamamla", "The results were promising, ___ the sample was small.", "although", "Although yan cümleyle karşıtlık kurar.", listOf("although", "therefore", "unless")))),
            unit("B2", 5, "Culture & Diplomatic Communication", "Handle disagreement and adapt language to audience and context.",
                lesson("B2", 5, 1, "Disagree constructively", "Challenge an idea without dismissing the speaker.",
                    activity("b2-diplomacy-listen", Skill.LISTENING, "Toplantı yanıtını dinle", "What is Daniel's main concern?", "the delivery timeline", "Daniel ürün fikrine değil teslim zamanına ilişkin çekincesini belirtiyor.", listOf("the product idea", "the delivery timeline", "the meeting room"), audio = "I can see the value of the proposal. My main concern is whether the delivery timeline is realistic."),
                    activity("b2-diplomacy-phrase", Skill.VOCABULARY, "Yapıcı ifadeyi seç", "Which phrase invites clarification politely?", "Could you elaborate on that point?", "Could you elaborate…? nazikçe ayrıntı istemek için kullanılır.", listOf("That's nonsense.", "Could you elaborate on that point?", "You are wrong."))),
                lesson("B2", 5, 2, "Choose the right register", "Rewrite a direct request for a professional audience.",
                    activity("b2-register-write2", Skill.WRITING, "İsteği profesyonel ve kibar yaz", "Ask a colleague to review a draft by Thursday.", "Could you review the draft by Thursday?", "Kibar rica ve net zaman sınırı kullan.", sample = "Would you be able to review the draft by Thursday afternoon?"),
                    activity("b2-register-read2", Skill.READING, "E-postanın tonunu değerlendir", "What does the sender need?", "confirmation of the revised date", "Gönderen güncellenmiş tarihi teyit etmek istiyor.", listOf("a new budget", "confirmation of the revised date", "a longer report"), passage = "Thanks for the update. To keep the team aligned, could you confirm whether the revised delivery date is now 18 October?"))))
        ),
        "C1" to listOf(
            unit("C1", 4, "Complex Arguments & Rhetoric", "Synthesize evidence, signal concessions and calibrate certainty.",
                lesson("C1", 4, 1, "Concession and qualification", "Present a concession before stating a qualified conclusion.",
                    activity("c1-concession-read", Skill.READING, "Analiz paragrafını oku", "What condition limits the recommendation?", "regular outcome monitoring", "Öneri sonuçların düzenli izlenmesi koşuluna bağlanıyor.", listOf("a larger marketing budget", "regular outcome monitoring", "immediate nationwide adoption"), passage = "The early indicators support a targeted expansion, notwithstanding the uneven participation across regions. Any wider rollout should remain contingent on quarterly outcome monitoring."),
                    activity("c1-concession-grammar", Skill.GRAMMAR, "Anlamca uygun bağlacı seç", "___ the initial gains, the evidence remains provisional.", "Notwithstanding", "Notwithstanding, isim öbeğiyle resmî karşıtlık kurar.", listOf("Notwithstanding", "Because of", "In order to"))),
                lesson("C1", 4, 2, "Synthesize competing evidence", "Combine a benefit and limitation in a concise conclusion.",
                    activity("c1-synthesis-speak2", Skill.SPEAKING, "Dengeli bir sonuç sun", "Summarize a benefit and a limitation before recommending a pilot.", "The benefit is clear but the evidence is limited", "Önce güçlü yanı, sonra kanıt sınırını belirtip ölçülü öneri sun.", audio = "The potential benefit is clear, but the evidence remains limited; a monitored pilot would be proportionate.", sample = "Although the potential benefit is substantial, the evidence is limited, so a monitored pilot would be proportionate."),
                    activity("c1-synthesis-vocab2", Skill.VOCABULARY, "Ölçülü akademik sonucu seç", "Taken together, the findings ___ further investigation.", "warrant", "Warrant, bulguların araştırmayı haklı çıkardığını ölçülü biçimde anlatır.", listOf("warrant", "guarantee", "eliminate")))),
            unit("C1", 5, "Leadership & Negotiation", "Lead nuanced discussions, surface assumptions and negotiate workable outcomes.",
                lesson("C1", 5, 1, "Surface an assumption", "Identify an unstated assumption and ask a precise question.",
                    activity("c1-assumption-read", Skill.READING, "Toplantı özetini oku", "Which assumption is not yet supported?", "that all teams have equal capacity", "Özet, ekip kapasitesinin eşit olduğunu henüz göstermiyor.", listOf("that all teams have equal capacity", "that the pilot has ended", "that the budget was approved"), passage = "The proposal assumes that each regional team can adopt the new process at the same pace. Yet the report provides no staffing data to support this assumption."),
                    activity("c1-assumption-phrase", Skill.SPEAKING, "Varsayımı nazikçe sorgula", "Say: What evidence supports the assumption that capacity is consistent?", "What evidence supports the assumption that capacity is consistent", "What evidence supports…? varsayımın dayanağını profesyonelce sorgular.", audio = "What evidence supports the assumption that capacity is consistent?", sample = "Could we clarify what evidence supports the assumption that capacity is consistent?")),
                lesson("C1", 5, 2, "Negotiate a workable compromise", "Reframe disagreement around shared constraints and propose a conditional option.",
                    activity("c1-negotiate-listen", Skill.LISTENING, "Müzakereyi dinle", "What condition do both parties accept?", "a review after the pilot", "Taraflar pilot sonrasında değerlendirme yapılmasını kabul ediyor.", listOf("an immediate full launch", "a review after the pilot", "no further measurement"), audio = "We can begin with two regions, provided that we review the outcomes before expanding."),
                    activity("c1-negotiate-write", Skill.WRITING, "Koşullu bir uzlaşma önerisi yaz", "Propose a limited pilot with a review condition.", "We could run a pilot and review the results", "Koşullu öneri, sınırı ve değerlendirme ölçütünü açıkça belirtir.", sample = "We could run a three-month pilot, provided that we review participation and outcomes before any expansion.")))
        )
    )

    fun units(level: String): List<LearningUnit> = content[level].orEmpty()
}
