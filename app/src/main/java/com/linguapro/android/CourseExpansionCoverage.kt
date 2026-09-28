package com.linguapro.android

/** Capstone tranche completing a balanced 12-unit path at every CEFR level. */
object CourseExpansionCoverage {
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
        "A2" to listOf(
            unit("A2", 11, "Community & Local Information", "Ask about local services and understand practical public information.",
                lesson("A2", 11, 1, "Find a local service", "Read a simple notice and find a service location.",
                    ex("a2-community-read", Skill.READING, "Kütüphane duyurusunu oku", "When does the library close on Saturday?", "at one o'clock", "Cumartesi kapanış saati 13.00.", listOf("at one o'clock", "at five o'clock", "at six o'clock"), passage = "Town Library: Monday to Friday, 9 a.m.–6 p.m.; Saturday, 10 a.m.–1 p.m.; closed Sunday."),
                    ex("a2-community-vocab", Skill.VOCABULARY, "Hizmet kelimesini seç", "You borrow books from a…", "library", "Library, kitap ödünç alınan kütüphanedir.", listOf("library", "bakery", "clinic"))),
                lesson("A2", 11, 2, "Ask for local information", "Ask a polite question about opening times.",
                    ex("a2-community-listen", Skill.LISTENING, "Bilgi masası konuşmasını dinle", "What time does the clinic open?", "eight thirty", "Görevli kliniğin 8.30'da açıldığını söylüyor.", listOf("eight o'clock", "eight thirty", "nine thirty"), audio = "The clinic opens at eight thirty on weekdays and at nine on Saturdays."),
                    ex("a2-community-speak", Skill.SPEAKING, "Açılış saatini kibarca sor", "Ask what time the office opens.", "What time does the office open?", "What time does…? saat sormak için kullanılır.", audio = "Could you tell me what time the office opens?", sample = "Could you tell me what time the office opens?"))),
            unit("A2", 12, "Workplace Communication & Follow-up", "Clarify a simple work task and send a concise update.",
                lesson("A2", 12, 1, "Clarify a task", "Check a deadline and confirm what needs to be done.",
                    ex("a2-work-clarify-read", Skill.READING, "İş notunu oku", "When is the draft due?", "by Thursday", "Notta ilk taslağın perşembeye kadar gönderilmesi isteniyor.", listOf("by Tuesday", "by Thursday", "by Monday"), passage = "Hi, please prepare the first draft of the event schedule. Could you send it to me by Thursday afternoon?"),
                    ex("a2-work-clarify-grammar", Skill.GRAMMAR, "Kibar rica kalıbını tamamla", "Could you ___ me the updated schedule?", "send", "Could you + fiilin yalın biçimiyle kibar istek kurulur.", listOf("send", "sending", "sent"))),
                lesson("A2", 12, 2, "A short progress update", "Say what is finished and what remains.",
                    ex("a2-work-update-listen", Skill.LISTENING, "Güncellemeyi dinle", "What does the speaker still need to do?", "check the room booking", "Konuşmacı oda rezervasyonunu hâlâ kontrol etmesi gerektiğini söylüyor.", listOf("send the invitations", "check the room booking", "print the posters"), audio = "The invitations are ready. I still need to check the room booking, and then I'll send the final update."),
                    ex("a2-work-update-write", Skill.WRITING, "Bir cümlelik iş güncellemesi yaz", "Say one task is ready and another is not finished.", "The invitations are ready.", "Tamamlanan işi ve kalan adımı kısaca belirt.", sample = "The invitations are ready, but I still need to check the room booking.")))
        ),
        "B1" to listOf(
            unit("B1", 11, "Culture, Events & Shared Experiences", "Describe an event and explain how it affected people.",
                lesson("B1", 11, 1, "A community event", "Understand an event report and identify a participant's reaction.",
                    ex("b1-event-read", Skill.READING, "Etkinlik haberini oku", "Why did visitors enjoy the event?", "they could try local food", "Ziyaretçiler yerel yemekleri deneyebildikleri için etkinlikten hoşlanmış.", listOf("the event was indoors", "they could try local food", "tickets were expensive"), passage = "The town's spring festival attracted families from nearby villages. Visitors enjoyed live music and local food, while children took part in craft workshops."),
                    ex("b1-event-vocab", Skill.VOCABULARY, "En uygun etkinlik fiilini seç", "At a workshop, participants can…", "take part", "Take part, bir etkinliğe katılmak anlamına gelir.", listOf("take part", "take place", "take off"))),
                lesson("B1", 11, 2, "Share an experience", "Tell a short story and describe a personal reaction.",
                    ex("b1-experience-listen", Skill.LISTENING, "Etkinlik anısını dinle", "What surprised the speaker?", "how welcoming everyone was", "Konuşmacı katılımcıların ne kadar sıcak davrandığına şaşırmış.", listOf("the weather", "how welcoming everyone was", "the ticket price"), audio = "I expected the event to be formal, but everyone was so welcoming that I quickly felt at home."),
                    ex("b1-experience-write", Skill.WRITING, "Bir etkinlik hakkındaki düşünceni yaz", "Describe one thing you enjoyed and why.", "I enjoyed the music.", "Deneyim ve nedenini geçmiş zamanla anlat.", sample = "I enjoyed the live music because it created a relaxed atmosphere."))),
            unit("B1", 12, "Career Growth & Feedback", "Discuss work goals, respond to feedback and plan a practical next step.",
                lesson("B1", 12, 1, "Respond to feedback", "Understand constructive feedback and identify a next action.",
                    ex("b1-feedback-read", Skill.READING, "Geri bildirim notunu oku", "What should Maya improve?", "the structure of her report", "Not, raporun daha açık bir yapıya ihtiyaç duyduğunu söylüyor.", listOf("the colour of the slides", "the structure of her report", "her meeting time"), passage = "Your research is thorough. To make the report easier to follow, group the findings under clear headings and move the recommendation to the opening summary."),
                    ex("b1-feedback-grammar", Skill.GRAMMAR, "Amaç bildiren yapıyı seç", "She reorganized the report ___ make it clearer.", "to", "To + fiil, yapılan eylemin amacını bildirir.", listOf("to", "for", "so"))),
                lesson("B1", 12, 2, "Set a career next step", "Describe a work goal and a concrete action toward it.",
                    ex("b1-career-listen2", Skill.LISTENING, "Kariyer görüşmesini dinle", "What will Arda do next?", "lead a small project", "Arda önce küçük bir projeye liderlik edeceğini söylüyor.", listOf("change companies", "lead a small project", "start a degree"), audio = "I'd like to become a team lead. My manager suggested that I lead a small project first."),
                    ex("b1-career-write2", Skill.WRITING, "Hedef ve ilk adımını yaz", "Write one career goal and one action.", "I want to improve my skills.", "Hedefini ve ulaşmak için atacağın ilk adımı belirt.", sample = "I want to move into project management, so I plan to lead a small project this year.")))
        ),
        "B2" to listOf(
            unit("B2", 11, "Public Speaking & Persuasive Structure", "Structure a short presentation and support a recommendation with reasons.",
                lesson("B2", 11, 1, "Open a presentation", "Signal the purpose and roadmap of a professional talk.",
                    ex("b2-talk-listen", Skill.LISTENING, "Sunum açılışını dinle", "What will the presentation cover?", "the pilot results and next steps", "Konuşmacı pilot bulgularını ve önerilen sonraki adımları sunacağını söylüyor.", listOf("the annual budget only", "the pilot results and next steps", "the team holiday plan"), audio = "Today I'll present the pilot results, explain two limitations and outline the next steps."),
                    ex("b2-talk-vocab", Skill.VOCABULARY, "Sunumda geçiş ifadesini seç", "To introduce the final part of a talk, say…", "Finally, I'll outline the next steps.", "Finally, sunumun son bölümüne geçildiğini açıkça gösterir.", listOf("Finally, I'll outline the next steps.", "Anyway, that's all random.", "I was saying whatever."))),
                lesson("B2", 11, 2, "Make a persuasive case", "Present a recommendation, evidence and a measured caveat.",
                    ex("b2-persuade-read", Skill.READING, "Öneri paragrafını oku", "What evidence supports the proposal?", "a reduction in response times", "Özet, yanıt sürelerindeki düşüşü dayanak gösteriyor.", listOf("a staff survey only", "a reduction in response times", "an unrelated cost estimate"), passage = "In the six-week pilot, median response time fell by 14%. Although the sample covered two teams, the result supports a controlled expansion with monitoring."),
                    ex("b2-persuade-write", Skill.WRITING, "Öneri ve sınırlılığını birlikte yaz", "Recommend expansion while acknowledging a small sample.", "The pilot supports expansion.", "Öneri, kanıtı ve örneklem sınırlılığını birlikte ele almalı.", sample = "The 14% reduction supports a controlled expansion, although the two-team sample warrants continued monitoring."))),
            unit("B2", 12, "Change Management & Organizational Culture", "Explain a change, anticipate concerns and support an orderly transition.",
                lesson("B2", 12, 1, "Explain a change", "Summarize the rationale for a process change and its practical impact.",
                    ex("b2-change-read", Skill.READING, "Değişiklik duyurusunu oku", "Why is the new process being introduced?", "to reduce duplicated work", "Duyuru yeni akışın tekrar eden işleri azaltmayı amaçladığını belirtiyor.", listOf("to remove customer support", "to reduce duplicated work", "to shorten lunch breaks"), passage = "From next month, requests will be logged in one shared system. This should reduce duplicated work and make ownership clearer. The old tracker will remain available for two weeks."),
                    ex("b2-change-grammar", Skill.GRAMMAR, "Beklenen sonucu seç", "The shared tracker is intended ___ duplicated requests.", "to reduce", "Be intended to + fiil, amaçlanan sonucu anlatır.", listOf("to reduce", "reducing", "reduce to"))),
                lesson("B2", 12, 2, "Address transition concerns", "Acknowledge a concern and propose a time-bound safeguard.",
                    ex("b2-transition-listen", Skill.LISTENING, "Geçiş planını dinle", "How long will the two systems overlap?", "two weeks", "Konuşmacı eski ve yeni sistemin iki hafta birlikte kullanılacağını söylüyor.", listOf("two days", "two weeks", "two months"), audio = "We'll run both systems for two weeks, provide daily support and review unresolved requests every Friday."),
                    ex("b2-transition-speak", Skill.SPEAKING, "Kaygıyı kabul edip güvence sun", "Say that support will be available during the transition.", "Support will be available during the transition", "Önce kaygıyı kabul et, ardından somut güvence sun.", audio = "I understand the concern; support will be available throughout the transition.", sample = "I understand the concern, and a support lead will be available throughout the two-week transition.")))
        ),
        "C1" to listOf(
            unit("C1", 11, "Synthesis Across Conflicting Sources", "Reconcile sources that share a finding but differ in interpretation or scope.",
                lesson("C1", 11, 1, "Compare source perspectives", "Identify common evidence and a meaningful difference in emphasis.",
                    ex("c1-compare-read", Skill.READING, "İki kaynak özetini oku", "What do both reports find?", "participation increased", "Her iki rapor da katılımın yükseldiğini bildiriyor.", listOf("costs disappeared", "participation increased", "the programme ended"), passage = "Report A records a rise in participation after the service moved online, while noting limited access in rural areas. Report B also finds higher participation but emphasizes that long-term outcomes remain unknown."),
                    ex("c1-compare-vocab", Skill.VOCABULARY, "İki yorumu karşılaştıran ifadeyi seç", "Both reports find higher participation; ___, they differ on access and long-term outcomes.", "however", "However, ortak bulgudan sonra yorum farkını belirtir.", listOf("however", "therefore", "for example"))),
                lesson("C1", 11, 2, "Write a synthesis", "Combine a shared finding, a limitation and an appropriately cautious conclusion.",
                    ex("c1-synthesis-write3", Skill.WRITING, "Dengeli bir sentez paragrafı yaz", "Summarize increased participation and unresolved outcomes.", "Participation increased.", "Sentez, ortak bulguyu ve bilinmeyen sonuçları birlikte taşımalı.", sample = "Both reports indicate higher participation following the online shift; however, rural access and long-term outcomes remain insufficiently established."),
                    ex("c1-synthesis-grammar3", Skill.GRAMMAR, "Temkinli çıkarımı seç", "The pattern ___ suggest wider access, but further evidence is needed.", "may", "May, kesinlik iddiası olmadan olası bir çıkarım sunar.", listOf("may", "must conclusively", "cannot possibly")))),
            unit("C1", 12, "Executive Communication & Strategic Decisions", "Deliver concise recommendations that expose assumptions and define review criteria.",
                lesson("C1", 12, 1, "Write an executive summary", "State a decision, rationale and condition in a concise summary.",
                    ex("c1-exec-read", Skill.READING, "Yönetici özetini oku", "What condition must be met before expansion?", "an independent review confirms equitable access", "Özet, genişleme öncesi adil erişimin bağımsız incelemeyle doğrulanmasını şart koşuyor.", listOf("the pilot is forgotten", "an independent review confirms equitable access", "all reporting stops"), passage = "Recommendation: extend the pilot to two additional regions, subject to an independent review confirming equitable access and a clear appeal route."),
                    ex("c1-exec-vocab", Skill.VOCABULARY, "Karar özetinde koşul bildiren ifadeyi seç", "Expansion is recommended, ___ independent review.", "subject to", "Subject to, kararın belirli bir koşula bağlı olduğunu bildirir.", listOf("subject to", "apart from", "in case of"))),
                lesson("C1", 12, 2, "Define a decision review", "Set a proportionate review condition and communicate accountability.",
                    ex("c1-review-listen", Skill.LISTENING, "Karar toplantısını dinle", "When will the decision be reviewed?", "after the first quarter", "Konuşmacılar kararı ilk çeyrekten sonra gözden geçirecek.", listOf("tomorrow morning", "after the first quarter", "in five years"), audio = "Let's authorize a limited rollout and review the access data after the first quarter before making a permanent decision."),
                    ex("c1-review-speak", Skill.SPEAKING, "Koşullu karar öner", "Say: Approve a limited rollout and review access data after one quarter.", "Approve a limited rollout and review access data after one quarter", "Kapsamı, ölçütü ve gözden geçirme zamanını açıkça ifade et.", audio = "I recommend a limited rollout, with an access review after the first quarter.", sample = "I recommend a limited rollout, with an independent access review after the first quarter.")))
        )
    )

    fun units(level: String): List<LearningUnit> = content[level].orEmpty()
}
