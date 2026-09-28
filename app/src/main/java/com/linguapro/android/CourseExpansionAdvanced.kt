package com.linguapro.android

/** Second authored content tranche: practical transfer, discourse and higher-order communication. */
object CourseExpansionAdvanced {
    private fun ex(id: String, skill: Skill, instruction: String, prompt: String, answer: String,
                   explanation: String, options: List<String> = emptyList(), passage: String = "",
                   audio: String? = null, sample: String? = null) = LearningExercise(
        id, skill, instruction, prompt, passage, options, listOf(answer), explanation, audio, sample
    )
    private fun lesson(level: String, unit: Int, n: Int, title: String, outcome: String, vararg ex: LearningExercise) =
        LearningLesson("$level-U$unit-L$n", title, outcome, ex.toList())
    private fun unit(level: String, n: Int, title: String, summary: String, a: LearningLesson, b: LearningLesson) =
        LearningUnit("$level-U$n", title, summary, listOf(a, b))

    private val content = mapOf(
        "A1" to listOf(
            unit("A1", 8, "Time & Daily Schedules", "Ask and answer about times and familiar weekly routines.",
                lesson("A1", 8, 1, "What time is it?", "Understand a time and say when a familiar activity starts.",
                    ex("a1-time-listen", Skill.LISTENING, "Saat bilgisini dinle", "What time does the lesson start?", "at nine o'clock", "Konuşmacı dersin saat dokuzda başladığını söylüyor.", listOf("at eight o'clock", "at nine o'clock", "at ten o'clock"), audio = "The English lesson starts at nine o'clock."),
                    ex("a1-time-grammar", Skill.GRAMMAR, "Doğru edatı seç", "My bus leaves ___ seven fifteen.", "at", "Saatlerden önce at kullanılır.", listOf("at", "in", "on"))),
                lesson("A1", 8, 2, "My weekly routine", "Ask about a weekly activity and understand a simple timetable.",
                    ex("a1-schedule-read", Skill.READING, "Programı oku", "When does Ali play football?", "on Friday", "Programda futbol antrenmanı cuma günü.", listOf("on Monday", "on Friday", "on Sunday"), passage = "Ali's week: Monday—English class; Wednesday—visit Grandma; Friday—football practice; Sunday—family lunch."),
                    ex("a1-schedule-write", Skill.WRITING, "Haftalık rutininden bir cümle yaz", "Write when you study English.", "I study English on Monday.", "Günlerden önce on kullanılır; kendi gününü seçebilirsin.", sample = "I study English on Monday and Thursday."))),
            unit("A1", 9, "Hobbies & What I Can Do", "Talk about free-time interests and simple abilities.",
                lesson("A1", 9, 1, "Things I enjoy", "Name a hobby and ask another person about an interest.",
                    ex("a1-hobby-listen2", Skill.LISTENING, "Hobiyi dinle", "What does Deniz enjoy doing?", "painting", "Deniz boş zamanında resim yapmaktan hoşlandığını söylüyor.", listOf("painting", "swimming", "cooking"), audio = "In my free time, I enjoy painting pictures of the sea."),
                    ex("a1-hobby-grammar2", Skill.GRAMMAR, "Boşluğu tamamla", "She likes ___ to music.", "listening", "Like + -ing biçimi bir etkinliği sevdiğini anlatır.", listOf("listen", "listening", "listens"))),
                lesson("A1", 9, 2, "Can you swim?", "Ask and answer whether someone can do a familiar activity.",
                    ex("a1-ability-read", Skill.READING, "Kısa profili oku", "What can Mert do?", "ride a bike", "Profil Mert'in bisiklet sürebildiğini söylüyor.", listOf("ride a bike", "play the piano", "drive a car"), passage = "I'm Mert. I can ride a bike and cook pasta, but I can't swim yet."),
                    ex("a1-ability-speak", Skill.SPEAKING, "Yetenek hakkında soru sor", "Say: Can you play the guitar?", "Can you play the guitar", "Can + kişi + fiilin yalın hâliyle yetenek sorulur.", audio = "Can you play the guitar?", sample = "Can you play the guitar?")))
        ),
        "A2" to listOf(
            unit("A2", 6, "Travel Plans & Reservations", "Arrange a simple trip and confirm practical travel details.",
                lesson("A2", 6, 1, "Book a room", "Ask about accommodation and confirm dates and facilities.",
                    ex("a2-hotel-read", Skill.READING, "Rezervasyon e-postasını oku", "How many nights is the booking?", "three nights", "Rezervasyon cuma-pazartesi, yani üç gece.", listOf("one night", "three nights", "five nights"), passage = "Hello, we have booked a double room from Friday 12 June to Monday 15 June. Breakfast is included."),
                    ex("a2-hotel-phrase", Skill.SPEAKING, "Bir olanağı sor", "Ask whether breakfast is included.", "Is breakfast included?", "Is ... included? bir hizmetin fiyata dahil olup olmadığını sorar.", audio = "Is breakfast included?", sample = "Could you tell me whether breakfast is included?")),
                lesson("A2", 6, 2, "Travel changes", "Understand a travel update and respond to a changed plan.",
                    ex("a2-travel-listen", Skill.LISTENING, "Seyahat duyurusunu dinle", "What time is the new departure?", "eleven forty", "Duyuruda yeni kalkış saati 11.40 olarak veriliyor.", listOf("ten forty", "eleven forty", "twelve fifteen"), audio = "The 10:40 train is delayed. It will now leave at 11:40 from platform six."),
                    ex("a2-travel-grammar", Skill.GRAMMAR, "Gelecek planını tamamla", "We ___ staying near the station tonight.", "are", "Planlanmış yakın gelecek için present continuous kullanılabilir.", listOf("are", "is", "do")))),
            unit("A2", 7, "Shopping & Consumer Choices", "Ask about products, compare options and handle a simple return.",
                lesson("A2", 7, 1, "Compare two products", "Compare familiar products using a simple adjective form.",
                    ex("a2-shop-read", Skill.READING, "Ürün açıklamalarını oku", "Which bag is lighter?", "the blue bag", "Tabloda mavi çanta 500 gram, siyah çanta 800 gram.", listOf("the blue bag", "the black bag", "they weigh the same"), passage = "Blue bag: 500 g, £24. Black bag: 800 g, £20. Both bags are waterproof."),
                    ex("a2-shop-grammar", Skill.GRAMMAR, "Karşılaştırmayı seç", "The blue bag is ___ than the black one.", "lighter", "Light sıfatının comparative biçimi lighter'dır.", listOf("light", "lighter", "lightest"))),
                lesson("A2", 7, 2, "Exchange an item", "Explain a simple problem and ask for an exchange politely.",
                    ex("a2-return-listen", Skill.LISTENING, "Mağaza konuşmasını dinle", "Why does the customer want an exchange?", "the size is too small", "Müşteri ayakkabının küçük geldiğini belirtiyor.", listOf("the colour is wrong", "the size is too small", "the price changed"), audio = "These shoes are too small. Could I exchange them for a larger size?"),
                    ex("a2-return-write", Skill.WRITING, "Bir ürünü değiştirmek için kısa rica yaz", "Ask to exchange a shirt for a larger size.", "Could I exchange this shirt for a larger size?", "Sorununu ve istediğin çözümü kibarca belirt.", sample = "Could I exchange this shirt for a larger size, please?")))
        ),
        "B1" to listOf(
            unit("B1", 6, "Digital Communication", "Communicate clearly online and manage common technology problems.",
                lesson("B1", 6, 1, "A clear project message", "Write a concise update with status, next action and timing.",
                    ex("b1-digital-read", Skill.READING, "Ekip mesajını oku", "What is the next action?", "review the prototype", "Mesaj, prototipin ekip tarafından incelenmesini istiyor.", listOf("rewrite the brief", "review the prototype", "cancel the call"), passage = "The first prototype is ready. Please add comments by Wednesday; then I'll revise the screens before Friday's client call."),
                    ex("b1-digital-write", Skill.WRITING, "Durum ve sonraki adımı içeren mesaj yaz", "Tell your team a draft is ready for review.", "The draft is ready for review.", "Kısa güncellemede durum ve istenen eylemi açıkla.", sample = "The draft is ready for review. Please send your comments by Thursday.")),
                lesson("B1", 6, 2, "Solve a connection problem", "Describe a technology problem and understand troubleshooting advice.",
                    ex("b1-tech-listen", Skill.LISTENING, "Destek konuşmasını dinle", "What should Maya try first?", "restart the router", "Teknisyen önce yönlendiriciyi yeniden başlatmasını söylüyor.", listOf("replace the laptop", "restart the router", "change her email"), audio = "The connection keeps dropping. First, restart the router and wait two minutes."),
                    ex("b1-tech-grammar", Skill.GRAMMAR, "Tavsiye kalıbını seç", "If the page still doesn't load, ___ the browser cache.", "clear", "If + present simple sonrasında emir cümlesi kullanılabilir.", listOf("clear", "clearing", "cleared")))),
            unit("B1", 7, "Culture & Life Decisions", "Discuss personal choices, compare viewpoints and explain a reason.",
                lesson("B1", 7, 1, "A different perspective", "Identify a speaker's reason and respond with a balanced opinion.",
                    ex("b1-perspective-read", Skill.READING, "Kısa görüş yazısını oku", "Why does Jo prefer cycling to work?", "it helps her feel active", "Jo, işe bisikletle gitmenin kendisini daha aktif hissettirdiğini belirtiyor.", listOf("it is always faster", "it helps her feel active", "her office is closed"), passage = "I started cycling to work last spring. It takes a little longer than the bus, but I arrive feeling more awake and I don't need to find parking."),
                    ex("b1-perspective-speak", Skill.SPEAKING, "Tercihini gerekçeyle açıkla", "Say one way you prefer to travel and why.", "I prefer the train because it is comfortable", "Tercih + because ile nedenini açıkça bağla.", audio = "I prefer travelling by train because I can read on the way.", sample = "I prefer travelling by train because it is comfortable and reliable.")),
                lesson("B1", 7, 2, "Make a practical decision", "Compare two options and recommend one for a stated purpose.",
                    ex("b1-choice-grammar", Skill.GRAMMAR, "Koşul cümlesini tamamla", "If we leave before six, we ___ avoid the traffic.", "will", "First conditional: If + present simple, will + fiilin yalın biçimi.", listOf("will", "would", "did")),
                    ex("b1-choice-vocab", Skill.VOCABULARY, "En uygun öneri ifadesini seç", "To make a recommendation, you can say…", "I'd recommend the earlier train.", "I'd recommend… nazikçe öneri sunar.", listOf("I'd recommend the earlier train.", "I recommend you the earlier.", "You must earlier train."))))
        ),
        "B2" to listOf(
            unit("B2", 6, "Presenting Data & Recommendations", "Describe trends accurately and connect evidence to an actionable recommendation.",
                lesson("B2", 6, 1, "Describe a trend", "Summarize a data trend without overstating what it proves.",
                    ex("b2-data-read", Skill.READING, "Grafik açıklamasını oku", "What happened to response time?", "it fell by 12%", "Açıklamada yanıt süresinin yüzde 12 düştüğü belirtiliyor.", listOf("it rose by 12%", "it fell by 12%", "it did not change"), passage = "After the new support rota began, average response time fell by 12% over eight weeks. The report cautions that seasonal demand also decreased."),
                    ex("b2-data-vocab", Skill.VOCABULARY, "Ölçülü sonuç fiilini seç", "The figures ___ an improvement, although other factors may have contributed.", "indicate", "Indicate, verinin bir sonuca işaret ettiğini kesin kanıt iddiası olmadan anlatır.", listOf("indicate", "guarantee", "eliminate"))),
                lesson("B2", 6, 2, "Recommend the next step", "Make a recommendation and name a measurable follow-up.",
                    ex("b2-recommend-write2", Skill.WRITING, "Kanıta dayalı öneri yaz", "Recommend a small trial and one way to measure it.", "We should run a small trial.", "Uygulanabilir öneri, ölçülebilir bir takip ölçütüyle güçlenir.", sample = "We should run a six-week trial and compare response times with the previous period."),
                    ex("b2-recommend-grammar2", Skill.GRAMMAR, "Uygun bağlacı seç", "The trend is positive; ___, the sample is too small for a firm conclusion.", "nevertheless", "Nevertheless olumlu bulguya rağmen sınırlılığı vurgular.", listOf("nevertheless", "for instance", "as a result")))),
            unit("B2", 7, "Facilitation & Conflict Resolution", "Clarify disagreement, paraphrase positions and agree on a practical next step.",
                lesson("B2", 7, 1, "Paraphrase before responding", "Restate a colleague's concern fairly before offering a response.",
                    ex("b2-paraphrase-listen", Skill.LISTENING, "Toplantı konuşmasını dinle", "What is Leila worried about?", "the workload during the transition", "Leila geçiş döneminde ekibin iş yükünden kaygılı.", listOf("the product colour", "the workload during the transition", "the office location"), audio = "The new process could help, but I'm concerned that the team will have to manage both systems during the transition."),
                    ex("b2-paraphrase-speak", Skill.SPEAKING, "Kaygıyı adil biçimde yeniden ifade et", "Say: So your main concern is the temporary extra workload.", "So your main concern is the temporary extra workload", "So your main concern is… karşı tarafı doğru anladığını teyit eder.", audio = "So your main concern is the temporary extra workload.", sample = "So your main concern is the temporary extra workload during the transition.")),
                lesson("B2", 7, 2, "Agree on a next step", "Propose an action that addresses a shared constraint.",
                    ex("b2-resolution-read", Skill.READING, "Toplantı kararını oku", "What did the group agree to do?", "test the process with one team", "Grup önce süreci tek ekiple denemeyi seçiyor.", listOf("replace the whole system", "test the process with one team", "delay the project indefinitely"), passage = "The team agreed to test the process with one department for a month, document the extra workload and meet again before a wider rollout."),
                    ex("b2-resolution-write", Skill.WRITING, "Toplantı için kısa eylem maddesi yaz", "Record who will test a process and when the group will review it.", "The team will test the process.", "Eylem maddesinde sorumlu, eylem ve gözden geçirme zamanı belirt.", sample = "The operations team will test the process for one month; we will review the results on 12 November.")))
        ),
        "C1" to listOf(
            unit("C1", 6, "Academic Writing & Source Evaluation", "Synthesize sources, signal attribution and distinguish evidence from inference.",
                lesson("C1", 6, 1, "Attribute a claim precisely", "Report a source's finding without presenting it as universal fact.",
                    ex("c1-source-read", Skill.READING, "Araştırma özetini oku", "What does the study not establish?", "that the effect lasts long term", "Çalışmanın kısa süresi, etkinin uzun dönemli olup olmadığını göstermiyor.", listOf("that participants completed the survey", "that the effect lasts long term", "that the pilot had two sites"), passage = "Across two sites, participants reported improved confidence after eight weeks. Because the study had no follow-up phase, it cannot establish whether the change persisted."),
                    ex("c1-source-vocab", Skill.VOCABULARY, "Kaynağa dayalı ölçülü aktarımı seç", "The authors ___ that confidence improved during the pilot.", "report", "Report, bulguyu kaynağa atfederek aktarır.", listOf("report", "prove universally", "guarantee"))),
                lesson("C1", 6, 2, "Synthesize two sources", "Combine findings that support a theme but differ in scope.",
                    ex("c1-sources-grammar", Skill.GRAMMAR, "İki kaynağı karşılaştıran bağlacı seç", "___ the first study focused on confidence, the second measured retention.", "Whereas", "Whereas iki kaynak arasındaki anlamlı farkı gösterir.", listOf("Whereas", "Therefore", "Unless")),
                    ex("c1-sources-write", Skill.WRITING, "İki bulguyu temkinli biçimde sentezle", "Write a balanced sentence about confidence and long-term retention.", "The evidence is promising.", "Sentezde iki bulgunun kapsamını ve sınırını görünür kıl.", sample = "While both studies suggest short-term benefits, only the second examines retention, and neither establishes a long-term effect."))),
            unit("C1", 7, "Ethics, Policy & Public Communication", "Evaluate trade-offs and communicate a conditional, audience-aware recommendation.",
                lesson("C1", 7, 1, "Weigh competing priorities", "Acknowledge competing public interests and identify a condition for action.",
                    ex("c1-policy-read", Skill.READING, "Politika notunu oku", "What safeguard does the author recommend?", "an independent review", "Yazar uygulamadan önce bağımsız değerlendirme öneriyor.", listOf("immediate expansion", "an independent review", "removing all reporting"), passage = "The policy could widen access, yet inconsistent outcomes may disproportionately affect smaller providers. The author recommends an independent review before expanding the scheme."),
                    ex("c1-policy-grammar", Skill.GRAMMAR, "Koşullu öneriyi tamamla", "Expansion would be justified, provided that outcomes ___ independently.", "are monitored", "Provided that ile koşul eklenir; edilgen yapı sonuçların izlenmesini anlatır.", listOf("are monitored", "monitor", "will monitor"))),
                lesson("C1", 7, 2, "Communicate a nuanced recommendation", "Deliver a concise recommendation that anticipates a reasonable objection.",
                    ex("c1-policy-speak", Skill.SPEAKING, "Çekinceyi tanıyan öneri sun", "Recommend a limited rollout with independent monitoring.", "A limited rollout is appropriate", "Öneri, kapsamı ve güvence koşulunu açıkça belirtir.", audio = "A limited rollout appears appropriate, provided that an independent review monitors access and outcomes.", sample = "A limited rollout appears proportionate, provided that access and outcomes are independently monitored."),
                    ex("c1-policy-write", Skill.WRITING, "Paydaşlara kısa ve dengeli bir sonuç yaz", "State one likely benefit, one risk and a condition for proceeding.", "The policy may improve access.", "Kamuya yönelik sonuçta yarar, risk ve koşul dengeli olmalı.", sample = "The policy may improve access, although uneven implementation remains a risk; proceeding should therefore depend on transparent, independent monitoring.")))
        )
    )

    fun units(level: String): List<LearningUnit> = content[level].orEmpty()
}
