package com.linguapro.android

/** Original scenario lessons. Stable lesson IDs preserve existing progress and server allowlists. */
object EditorialCurriculum {
    private data class Choice(val question: String, val answer: String, val wrong1: String, val wrong2: String, val why: String)
    private fun c(q: String, a: String, b: String, d: String, why: String) = Choice(q, a, b, d, why)
    private fun activity(id: String, skill: Skill, choice: Choice, passage: String = "", audio: String? = null) =
        LearningExercise(id, skill, when (skill) {
            Skill.LISTENING -> "Konuşmayı dinle ve soruyu yanıtla"
            Skill.READING -> "Metinden kanıt bularak yanıtla"
            Skill.GRAMMAR -> "Bağlama uygun yapıyı seç"
            else -> "Bağlama uygun ifadeyi seç"
        }, choice.question, passage, listOf(choice.answer, choice.wrong1, choice.wrong2)
            .shuffled(kotlin.random.Random(id.hashCode())), listOf(choice.answer), choice.why, audio)

    private fun lesson(
        id: String, title: String, outcome: String, dialogue: String,
        listen: Choice, detail: Choice, passage: String, read: Choice,
        vocab: Choice, grammar: Choice, reply: Choice,
        speak: String, speakTr: String, writingTr: String, answers: List<String>,
        rule: GrammarFocus, words: List<TargetVocabulary>
    ): LearningLesson {
        val prefix = "editorial-${id.lowercase()}"
        return LearningLesson(id, title, outcome, listOf(
            activity("$prefix-vocab", Skill.VOCABULARY, vocab),
            activity("$prefix-listen-main", Skill.LISTENING, listen, audio = dialogue),
            activity("$prefix-listen-detail", Skill.LISTENING, detail, audio = dialogue),
            activity("$prefix-grammar", Skill.GRAMMAR, grammar),
            activity("$prefix-read", Skill.READING, read, passage = passage),
            activity("$prefix-reply", Skill.READING, reply, passage = dialogue),
            LearningExercise("$prefix-speak", Skill.SPEAKING, "Modeli dinle ve sesli tekrar et",
                "Say: $speak", acceptedAnswers = listOf(speak), explanationTr = "$speakTr\nBu görev model cümleyi tekrar etme alıştırmasıdır.",
                modelAudioText = speak, sampleAnswer = speak),
            LearningExercise("$prefix-write", Skill.WRITING, "Verilen anlamı İngilizce yaz",
                writingTr, acceptedAnswers = answers, explanationTr = "${rule.explanationTr}\nÖrnek: ${answers.first()}", sampleAnswer = answers.first())
        ), words, rule)
    }
    private fun g(title: String, explanation: String, form: String, en: String, tr: String, error: String) =
        GrammarFocus(title, explanation, form, en, tr, error)
    private fun w(id: String, term: String, tr: String, pos: String, en: String, exTr: String) =
        TargetVocabulary("editorial-$id", term, tr, pos, en, exTr)

    private val lessons: Map<String, LearningLesson> = listOf(
        lesson("A1-U1-L1", "Merhaba, ben Elif", "Birini selamlayıp adını söyleyebilirim.",
            "Hello! I'm Elif. Hi, Elif. I'm Ben. Nice to meet you. Nice to meet you, too.",
            c("Who says 'I'm Elif'?", "Elif", "Ben", "Anna", "I'm Elif, 'Ben Elif'im' demektir; konuşmacı kendi adını söylüyor."),
            c("What does Ben say when he meets Elif?", "Nice to meet you.", "Good night.", "See you tomorrow.", "İlk tanışmada Nice to meet you denir; vedalaşma ifadesi değildir."),
            "Hi! My name is Ada. I'm a student. Nice to meet you!",
            c("What is the student's name?", "Ada", "Elif", "Ben", "My name is Ada cümlesi öğrencinin adını açıkça verir."),
            c("Birine ilk kez rastladığında hangisi 'merhaba' anlamına gelir?", "Hello", "Goodbye", "Good night", "Hello selamlaşmadır. Goodbye vedalaşma, Good night ise iyi geceler demektir."),
            c("I ___ Elif.", "am", "is", "are", "I öznesiyle am kullanılır. I'm, I am ifadesinin kısa biçimidir."),
            c("Elif: 'Nice to meet you.' Ben nasıl karşılık verir?", "Nice to meet you, too.", "My name is tomorrow.", "Good night, too.", "Too burada 'ben de' anlamı katar ve tanışma ifadesine karşılık verir."),
            "Hello, I'm Elif.", "Merhaba, ben Elif.", "Merhaba, ben Ben. (Hello ile başla.)", listOf("Hello, I'm Ben.", "Hello, I am Ben."),
            g("I am / I'm", "Türkçedeki 'Ben Elif'im' ifadesinde İngilizce am gerekir. I am = I'm.", "I + am + isim", "I am Elif.", "Ben Elif'im.", "I Elif eksiktir; am fiilini ekle."),
            listOf(w("hello", "hello", "merhaba", "selamlaşma", "Hello, I'm Elif.", "Merhaba, ben Elif."), w("nice-meet", "nice to meet you", "tanıştığıma memnun oldum", "ifade", "Nice to meet you, Ben.", "Tanıştığıma memnun oldum, Ben."))),
        lesson("A1-U1-L2", "Nerelisin?", "Nereli olduğunu sorup ülke adıyla cevap verebilirim.",
            "Where are you from, Ben? I'm from Canada. And you? I'm from Türkiye.",
            c("Where is Ben from?", "Canada", "Türkiye", "Italy", "Ben, I'm from Canada diyor. İkinci ülke diğer konuşmacının cevabıdır."),
            c("Which question asks about a country of origin?", "Where are you from?", "What is your name?", "How old are you?", "Where ... from? kişinin nereli olduğunu sorar; adı veya yaşı sormaz."),
            "My name is Luca. I'm from Italy. My friend Elif is from Türkiye. We are students.",
            c("Who is from Türkiye?", "Elif", "Luca", "Both Luca and Elif", "Metindeki My friend Elif is from Türkiye cümlesine bak; Luca İtalya'dan."),
            c("I'm ___ Canada. 'Kanadalıyım' anlamını tamamla.", "from", "at", "on", "Ülke kökenini belirtirken from kullanılır. At ve on burada köken bildirmez."),
            c("Where ___ you from?", "are", "am", "is", "You öznesinin be biçimi are olur; soruda öznenin önüne gelir."),
            c("Ben: 'And you?' Elif nereli olduğunu nasıl söyler?", "I'm from Türkiye.", "I'm Türkiye from.", "I'm name Elif.", "Sıra: özne + am + from + ülke adı."),
            "Where are you from?", "Nerelisin?", "Ben Kanada'danım. (from kullan.)", listOf("I'm from Canada.", "I am from Canada."),
            g("Köken sorma", "Where are you from? sorusuna I'm from + ülke ile cevap verilir.", "Where + are + you + from?", "I'm from Canada.", "Ben Kanada'danım.", "You ile am değil are kullanılır."),
            listOf(w("from", "from", "-den / -dan", "edat", "I'm from Italy.", "Ben İtalya'danım."), w("country", "country", "ülke", "isim", "Canada is a country.", "Kanada bir ülkedir."))),
        lesson("A1-U1-L3", "Adını harfler misin?", "Bir adın yazılışını sorup duyduğum harfleri ayırt edebilirim.",
            "What's your name? Lea. Can you spell that, please? L, E, A. Thank you, Lea.",
            c("What is the name?", "Lea", "Lee", "Lia", "Duyulan harfler L, E, A; ikinci harf E, son harf A."),
            c("Why does the speaker say 'Can you spell that, please?'", "To ask for the letters", "To ask for a country", "To say goodbye", "Spell, bir kelimenin harflerini sırayla söylemek veya yazmak demektir."),
            "Registration card: First name: Leo. Last name: Park. Country: Canada.",
            c("What is Leo's last name?", "Park", "Leo", "Canada", "Last name soyadını belirtir; first name ad, country ise ülkedir."),
            c("'spell' bu konuşmada ne demektir?", "harflerini söylemek", "selamlamak", "yaşını söylemek", "Adın yazılışını sorarken spell kullanılır."),
            c("Can you spell ___ name, please? (Senin adın.)", "your", "you", "I", "İsimden önce sahiplik için your gerekir. You özne zamiridir."),
            c("Görevli: 'Can you spell Leo?' Uygun cevap hangisi?", "L, E, O.", "I'm from Canada.", "Nice to meet you.", "Soru adın harflerini istediği için L, E, O doğrudan cevap verir."),
            "Can you spell your name, please?", "Adını harfler misin, lütfen?", "Adın ne? (What is ile başla.)", listOf("What is your name?", "What's your name?"),
            g("Your + isim", "Your, 'senin' demektir ve isimden önce gelir: your name.", "your + name", "What is your name?", "Adın ne?", "You name yerine your name yaz."),
            listOf(w("spell", "spell", "harflerini söylemek", "fiil", "Can you spell Lea?", "Lea adını harfler misin?"), w("last-name", "last name", "soyadı", "isim", "My last name is Park.", "Soyadım Park."))),
        lesson("A1-U2-L1", "Ailemi tanıtıyorum", "Yakın aile üyelerini tanıtıp kimin kim olduğunu anlayabilirim.",
            "This is my brother, Leo. Is he a student? Yes, he is. And this is my mother, Anna.",
            c("Who is Leo?", "The speaker's brother", "The speaker's father", "The speaker's mother", "This is my brother, Leo ifadesi Leo'nun erkek kardeş olduğunu açıkça söylüyor."),
            c("Is Leo a student?", "Yes, he is.", "No, he isn't.", "We don't know.", "Is he a student? sorusuna Yes, he is cevabı veriliyor."),
            "I'm Sam. I live with my mother, my father and my sister Mia. Mia is ten. There are four people in our family.",
            c("How many children are named in the text?", "Two", "Three", "Four", "Sam ve Mia iki çocuktur. Four, anne ve babayla birlikte bütün aileyi sayar."),
            c("Annenin senden başka kız çocuğu, senin neyin olur?", "sister", "mother", "father", "Sister kız kardeştir. 'Senden başka' ifadesi kişinin kendisini cevap olarak düşünmesini önler."),
            c("This is ___ brother. (Benim erkek kardeşim.)", "my", "I", "me", "My bir isimden önce sahiplik bildirir; I özne, me nesne zamiridir."),
            c("'Is he your brother?' sorusuna olumlu cevap ver.", "Yes, he is.", "Yes, she is.", "Yes, I am.", "Sorunun öznesi he olduğundan cevapta da he is kullanılır."),
            "This is my brother.", "Bu benim erkek kardeşim.", "Bu benim kız kardeşim. (This is ile başla.)", listOf("This is my sister."),
            g("Aile üyelerini tanıtma", "This is + my + aile üyesi, yakındaki birini tanıtmak için kullanılır.", "This is my + isim", "This is my mother.", "Bu benim annem.", "This my mother eksiktir; is gerekir."),
            listOf(w("brother", "brother", "erkek kardeş", "isim", "Leo is my brother.", "Leo benim erkek kardeşim."), w("sister", "sister", "kız kardeş", "isim", "Mia is my sister.", "Mia benim kız kardeşim."))),
        lesson("A1-U2-L2", "Günlük rutinim", "Basit bir günlük rutini anlayıp saat belirterek anlatabilirim.",
            "I get up at seven. Do you have breakfast at home? Yes, at half past seven. Then I go to work at eight.",
            c("What time does the speaker get up?", "At seven", "At half past seven", "At eight", "Get up uyanıp kalkmaktır. Yedi buçuk kahvaltı, sekiz işe gitme saatidir."),
            c("Where does the speaker have breakfast?", "At home", "At work", "At school", "At home sorusuna Yes cevabı verilerek kahvaltının evde olduğu doğrulanıyor."),
            "Elif gets up at six. She has breakfast at seven and takes the bus at eight. On Sundays, she gets up at nine.",
            c("What is different on Sundays?", "She gets up later.", "She takes an earlier bus.", "She has breakfast at six.", "Normalde altıda, pazar günü dokuzda kalkar; yani daha geç kalkar. Metin pazar otobüsü hakkında bilgi vermez."),
            c("'have breakfast' hangi eylemdir?", "kahvaltı yapmak", "işe gitmek", "yatmak", "İngilizcede bu öğün için have breakfast kalıbı kullanılır."),
            c("I ___ breakfast at seven.", "have", "has", "having", "I ile geniş zamanda have kullanılır. Has, he/she/it ile kullanılır."),
            c("'What time do you get up?' sorusuna cevap ver.", "At seven.", "At home.", "My brother.", "What time saat sorar. At home yer belirtir ve bu soruya cevap olmaz."),
            "I get up at seven.", "Saat yedide kalkarım.", "Saat sekizde işe giderim. (I go ile başla.)", listOf("I go to work at eight.", "I go to work at 8."),
            g("Rutinler ve saatler", "I ile fiilin yalın biçimini, belirli saatlerle at kullan.", "I + fiil + at + saat", "I have breakfast at seven.", "Saat yedide kahvaltı yaparım.", "I has veya in seven yerine I have ve at seven kullan."),
            listOf(w("get-up", "get up", "kalkmak", "fiil", "I get up at seven.", "Saat yedide kalkarım."), w("breakfast", "breakfast", "kahvaltı", "isim", "I have breakfast at home.", "Evde kahvaltı yaparım."))),
        lesson("A2-U1-L1", "İstasyonda bilet alıyorum", "Kalkış saatini ve peronu öğrenip tek yön bilet isteyebilirim.",
            "A single ticket to York, please. The next train leaves at nine thirty from platform four. How much is it? Twelve pounds.",
            c("When does the next train leave?", "At nine thirty", "At nine fifteen", "At four", "Nine thirty saat 9.30'dur. Four, peron numarasıdır."),
            c("Which platform does the passenger need?", "Platform four", "Platform twelve", "Platform nine", "Duyuruda from platform four deniyor. Twelve bilet fiyatıdır."),
            "York service: Departure 09:30. Platform 4. Single fare £12. Return fare £20. Tickets must be bought before boarding.",
            c("What must you do before boarding?", "Buy a ticket", "Return at twenty past nine", "Go to platform twelve", "Must be bought before boarding, trene binmeden bilet alınması gerektiğini belirtir."),
            c("A 'single ticket' buys which journey?", "One way", "There and back", "Unlimited journeys", "Single tek yön, return gidiş-dönüş biletidir."),
            c("When ___ the next train leave?", "does", "do", "is", "The next train tekil öznedir; geniş zaman sorusu does + leave ile kurulur."),
            c("Görevli: 'Single or return?' Sadece gidiş istiyorsun.", "Single, please.", "Platform four, please.", "Nine thirty, please.", "Single or return bilet türünü sorar; peron veya saati değil."),
            "A single ticket to York, please.", "York'a tek yön bilet, lütfen.", "Bir sonraki tren ne zaman kalkıyor? (When / next train / leave kullan.)", listOf("When does the next train leave?"),
            g("Kalkış saatini sorma", "Geniş zamanda tekil özneyle does kullan; asıl fiil leave biçiminde kalır.", "When + does + özne + leave?", "When does the train leave?", "Tren ne zaman kalkıyor?", "Does ile leaves yazma; When does it leave? de."),
            listOf(w("single-ticket", "single ticket", "tek yön bilet", "isim", "I'd like a single ticket.", "Tek yön bilet istiyorum."), w("platform", "platform", "peron", "isim", "The train leaves from platform four.", "Tren dört numaralı perondan kalkıyor."))),
        lesson("A2-U1-L2", "Hafta sonu gezisi", "Tamamlanmış bir gezinin olay sırasını geçmiş zamanda anlatabilirim.",
            "How was your weekend? Great! I went to İzmir on Saturday. Did you stay with friends? No, I stayed in a small hotel. On Sunday, I visited the market.",
            c("Where did the visitor stay?", "In a small hotel", "With friends", "At the market", "Arkadaşlarında kalma sorusuna No diyor ve küçük bir oteli belirtiyor."),
            c("When did the visitor go to the market?", "On Sunday", "On Saturday", "On Friday", "On Sunday, I visited the market cümlesi günü verir."),
            "On Saturday, Leo arrived in İzmir and checked into a hotel. The market was closed that evening, so he visited it on Sunday morning before going home.",
            c("Why did Leo wait until Sunday to visit the market?", "It was closed on Saturday evening.", "His hotel was closed.", "He arrived on Sunday.", "So neden-sonuç kurar: pazar kapalı olduğu için ziyareti ertesi güne bırakır."),
            c("'checked into a hotel' ne demektir?", "otele giriş kaydı yaptırdı", "otelden ayrıldı", "pazara yürüdü", "Check in otele giriş, check out otelden çıkış işlemidir."),
            c("Last weekend, I ___ to İzmir.", "went", "go", "gone", "Go fiilinin geçmiş zaman biçimi went'tir. Last weekend tamamlanmış geçmiş zaman belirtir."),
            c("'Did you stay with friends?' sorusuna olumsuz cevap ver.", "No, I didn't.", "No, I don't.", "No, I wasn't.", "Did ile sorulan geçmiş zaman sorusuna didn't ile cevap verilir."),
            "I stayed in a small hotel.", "Küçük bir otelde kaldım.", "Geçen hafta sonu İzmir'e gittim. (Last weekend ile başla.)", listOf("Last weekend, I went to İzmir.", "Last weekend, I went to Izmir."),
            g("Past simple", "Tamamlanmış olaylarda geçmiş zaman kullanılır: go → went; stay → stayed.", "özne + geçmiş zaman fiili", "I went to İzmir.", "İzmir'e gittim.", "Did sorusunda went değil go kullan: Did you go?"),
            listOf(w("stay", "stay", "kalmak", "fiil", "We stayed in a hotel.", "Bir otelde kaldık."), w("visit", "visit", "ziyaret etmek", "fiil", "I visited the market.", "Pazarı ziyaret ettim."))),
        lesson("B1-U1-L1", "Toplantı için ortak zaman", "Kibar bir toplantı talebini anlayıp uygun zamanı netleştirebilirim.",
            "Could we meet on Tuesday at ten? I'm afraid I'm busy then. Would Wednesday at two work? Yes, that works for me. Let's meet in Room Five.",
            c("When will they meet?", "Wednesday at two", "Tuesday at ten", "Wednesday at ten", "İlk teklif reddediliyor; kabul edilen ikinci teklif Wednesday at two."),
            c("Why do they reject Tuesday?", "One person is busy.", "Room Five is closed.", "The meeting is cancelled.", "I'm afraid I'm busy then, salı için uygun olmadığını kibarca belirtir."),
            "Hi Maya, thanks for suggesting Wednesday at two. I can attend, but I need to leave by three. Could we cover the budget first? Best, Alex.",
            c("Why does Alex want to discuss the budget first?", "He has limited time.", "He cannot attend.", "Maya rejected Wednesday.", "Alex üçe kadar ayrılması gerektiğini söylüyor. Toplantıya katılabiliyor, fakat süresi sınırlı."),
            c("'That works for me' bu konuşmada ne demektir?", "Bu zaman bana uygun.", "Benim için çalışıyor.", "Toplantıyı iptal edelim.", "Burada work, önerilen zamanın uygun olması anlamında kullanılır; birinin çalışması değildir."),
            c("Would Wednesday at two ___ for you?", "work", "works", "working", "Would yardımcı fiilinden sonra yalın fiil work gelir."),
            c("Tuesday is impossible. Offer an alternative politely.", "Would Wednesday at two work?", "You must come on Tuesday.", "I was there yesterday.", "Would ... work? karşı tarafa seçenek sunar ve kibar bir alternatif oluşturur."),
            "Would Wednesday at two work for you?", "Çarşamba saat iki sana uygun olur mu?", "Bir toplantı planlamak istiyorum. (I'd like / schedule kullan.)", listOf("I'd like to schedule a meeting.", "I would like to schedule a meeting."),
            g("Kibar öneri", "Would + özne + yalın fiil bir önerinin uygunluğunu sorabilir.", "Would + zaman + work?", "Would Friday work?", "Cuma uygun olur mu?", "Would works değil would work kullan."),
            listOf(w("schedule", "schedule", "planlamak", "fiil", "Let's schedule a meeting.", "Bir toplantı planlayalım."), w("attend", "attend", "katılmak", "fiil", "I can attend on Wednesday.", "Çarşamba katılabilirim."))),
        lesson("B1-U1-L2", "İş deneyimi ve sonuç", "Geçmiş bir projeyi, gecikmenin nedenini ve sonucunu ayırt edebilirim.",
            "Have you worked on a website before? Yes, I've worked on three so far. On the last project, the client changed the brief, so we delivered a week late. In the end, they were happy with the design.",
            c("Why was the last project late?", "The client changed the brief.", "The team had no experience.", "The website was cancelled.", "So bağlacı değişen brief ile gecikme arasında neden-sonuç kuruyor."),
            c("How did the client feel about the final design?", "Happy", "Unhappy", "The speaker does not say.", "In the end, they were happy ifadesi sonuçtaki memnuniyeti belirtir."),
            "Our team has built three websites this year. We finished the latest one in June. Although delivery was delayed by a week, the client approved the final version and asked us to maintain it.",
            c("Which detail suggests the client still trusts the team?", "The client asked them to maintain the website.", "Delivery was delayed.", "The team finished in June.", "Bakım işini aynı ekibe vermesi güvenin sürdüğünü gösterir. Gecikme tek başına güven göstergesi değildir."),
            c("A project 'brief' is...", "a description of requirements", "a delivery vehicle", "a short holiday", "İş bağlamında brief, yapılacak işin beklenti ve gereksinimlerini açıklayan özettir."),
            c("I ___ on three projects so far.", "have worked", "am work", "have working", "So far bugüne kadarki deneyimi belirtir; have + past participle: have worked."),
            c("Someone asks about experience, without a finished date. Choose the answer.", "I've worked on three websites so far.", "I am work on three websites.", "I have working yesterday.", "Have worked, bugüne kadarki deneyimi ifade eder; diğer seçeneklerin fiil yapıları hatalıdır."),
            "The client changed the brief, so we delivered late.", "Müşteri iş tanımını değiştirdi, bu yüzden geç teslim ettik.", "Şimdiye kadar üç projede çalıştım. (so far kullan.)", listOf("I have worked on three projects so far.", "I've worked on three projects so far."),
            g("Deneyim ve bitmiş olay", "So far ile present perfect kullan; June gibi tamamlanmış zaman için past simple kullan.", "have/has + past participle", "We finished it in June.", "Haziranda bitirdik.", "We have finished it in June yerine We finished it in June kullan."),
            listOf(w("brief", "brief", "iş tanımı / gereksinim özeti", "isim", "The client changed the brief.", "Müşteri iş tanımını değiştirdi."), w("maintain", "maintain", "bakımını yapmak", "fiil", "We maintain the website.", "Sitenin bakımını yapıyoruz."))),
        lesson("B2-U1-L1", "Görüşü gerekçeyle savunma", "Bir öneriyi değerlendirip olumlu yönünü ve sınırını birlikte ifade edebilirim.",
            "The proposal could reduce travel costs. However, remote staff might feel isolated. Could we test it with one team first? That would give us evidence before making a company-wide change.",
            c("What do the speakers propose?", "A trial with one team", "An immediate company-wide change", "Cancelling all remote work", "Bir ekiple deneme öneriliyor; şirket genelinde karar daha sonra verilecek."),
            c("What risk do they mention?", "Staff might feel isolated.", "Travel costs will certainly double.", "No one can use a computer.", "Might feel isolated olası sosyal risktir; kesin bir sonuç iddia edilmez."),
            "A small trial found that remote staff completed more tasks, but the participants volunteered and already had suitable home offices. The results may therefore not represent the whole company.",
            c("Why should the company be cautious about generalising?", "The participants may not represent all staff.", "No tasks were completed.", "The trial proves remote work always fails.", "Gönüllülük ve uygun ev ofisleri örneklemi sınırlar. Bu, sonuçların herkese aktarılmasını zorlaştırır."),
            c("The plan is promising; ___, the evidence is limited.", "however", "therefore", "similarly", "Olumlu değerlendirme ile sınırlılık karşıtlık oluşturur; however uygundur."),
            c("If we ___ the launch, we could collect more evidence.", "delayed", "will delayed", "have delaying", "Varsayımsal ikinci koşulda if + past simple, could + yalın fiil kullanılır."),
            c("Support a trial while acknowledging uncertainty.", "A trial could help, although the results may not generalise.", "A trial proves every employee will benefit.", "Uncertainty means evidence is unnecessary.", "Could ve may kesinliği sınırlar; although ise olumlu noktayla sınırlılığı birlikte taşır."),
            "The proposal is promising; however, we need more evidence.", "Öneri umut verici; ancak daha fazla kanıta ihtiyacımız var.", "Öneri umut verici; ancak daha fazla kanıta ihtiyacımız var. (promising / however / evidence kullan.)", listOf("The proposal is promising; however, we need more evidence.", "The proposal is promising. However, we need more evidence."),
            g("Dengeli karşıtlık", "However iki fikir arasındaki karşıtlığı gösterir. İki bağımsız cümleyi nokta veya noktalı virgülle ayır.", "cümle; however, cümle", "The plan is useful; however, it has risks.", "Plan yararlı; ancak riskleri var.", "However neden bildiren because ile aynı anlamda değildir."),
            listOf(w("trial", "trial", "deneme / pilot uygulama", "isim", "We should run a trial.", "Bir pilot uygulama yapmalıyız."), w("evidence", "evidence", "kanıt", "isim", "We need more evidence.", "Daha fazla kanıta ihtiyacımız var."))),
        lesson("B2-U1-L2", "Teslim tarihi için uzlaşma", "Bir pazarlıkta değişen teklifi takip edip son anlaşmayı netleştirebilirim.",
            "Could you deliver the final report on Friday? I can send a draft then, but the final version needs two more days. Sunday is fine if the draft arrives on Friday. Agreed.",
            c("When is the final report due?", "Sunday", "Friday", "Monday", "Cuma taslak, iki gün sonra pazar nihai rapor teslimi üzerinde anlaşılıyor."),
            c("What condition does the client set?", "The draft must arrive on Friday.", "The final report must arrive on Friday.", "There must be no draft.", "If the draft arrives on Friday koşulu, pazar tesliminin kabul şartıdır."),
            "Thanks for the call. To confirm: you will send the draft by Friday at 5 p.m., and the final report by Sunday at noon. Please tell us immediately if either date becomes impossible.",
            c("What should happen if a deadline cannot be met?", "The supplier should notify the client immediately.", "The supplier should silently change the date.", "The client should cancel without discussion.", "Please tell us immediately ... doğrudan haber verme yükümlülüğünü belirtir."),
            c("In this email, 'by Sunday at noon' means...", "no later than Sunday at noon", "only after Sunday at noon", "every Sunday at noon", "By bir son teslim sınırı koyar; daha erken teslim mümkündür."),
            c("Would you be open to ___ the deadline?", "moving", "move", "moved", "Be open to ifadesindeki to edattır; ardından -ing biçimi gelir."),
            c("Confirm the agreed arrangement precisely.", "I'll send the draft Friday and the final report Sunday.", "I'll send something soon.", "Everything is due Friday.", "İki teslimi ayrı ayrı belirtmek belirsizliği önler ve anlaşmayı doğru yansıtır."),
            "Would you be open to moving the deadline to Sunday?", "Son teslim tarihini pazara almaya açık olur musunuz?", "Taslağı cumaya kadar gönderebilirim. (draft / by Friday kullan.)", listOf("I can send the draft by Friday."),
            g("Edattan sonra -ing", "Be open to + -ing, bir değişikliğe açık olmayı kibarca sorar.", "be open to + moving", "Would you be open to moving the deadline?", "Son teslim tarihini değiştirmeye açık olur musunuz?", "Bu kalıpta to move yerine to moving kullan."),
            listOf(w("draft", "draft", "taslak", "isim", "The draft is ready.", "Taslak hazır."), w("deadline", "deadline", "son teslim tarihi", "isim", "We agreed on a deadline.", "Bir son teslim tarihi üzerinde anlaştık."))),
        lesson("C1-U1-L1", "Kanıtın sınırını belirtme", "Bir araştırma sonucunu kanıt gücüne uygun biçimde ifade edebilirim.",
            "The pilot suggests that the programme may help. But only twenty volunteers took part, and there was no comparison group. We should describe the findings as preliminary, rather than as proof of effectiveness.",
            c("What conclusion does the speaker support?", "The programme may help, but the evidence is preliminary.", "The programme has been conclusively proven effective.", "The programme cannot possibly help.", "Suggests ve may olasılığı belirtir. Preliminary, sonucun henüz kesinleşmediğini gösterir."),
            c("Which limitation is explicitly mentioned?", "There was no comparison group.", "The participants were all paid employees.", "The trial lasted twenty years.", "Konuşmacı karşılaştırma grubunun olmadığını açıkça belirtiyor; diğer ayrıntılar söylenmiyor."),
            "Participants reported improvement after the intervention. However, without a comparison group, it is unclear whether the change resulted from the programme, normal recovery, or participants' expectations. A larger controlled study is warranted.",
            c("Why is a controlled study warranted?", "Alternative explanations have not been ruled out.", "Self-reports always prove causation.", "Normal recovery has been shown to be impossible.", "İyileşme gözlemi tek başına sebebi ayırt etmez. Kontrol grubu alternatif açıklamaları değerlendirmeye yardım eder."),
            c("Calling findings 'preliminary' signals that they are...", "initial and subject to further testing", "fabricated and therefore useless", "final and beyond challenge", "Preliminary, ilk aşamadaki bulgudur; sahte veya kesin anlamına gelmez."),
            c("The evidence ___ suggest a benefit, but further study is needed.", "appears to", "appear to", "appearing to", "Evidence sayılamayan tekil isimdir; appears to + yalın fiil kullanılır."),
            c("Choose the claim that matches the evidence.", "The findings suggest a possible benefit, though causation remains uncertain.", "The findings prove that all patients will improve.", "The lack of a control group proves there was no improvement.", "Olası fayda ile nedensellik belirsizliğini ayırır; kontrol eksikliği iyileşmenin hiç olmadığını kanıtlamaz."),
            "The findings should be treated as preliminary.", "Bulgular ön sonuçlar olarak değerlendirilmelidir.", "Bulgular ön sonuçlar olarak değerlendirilmelidir. (findings / treated / preliminary kullan.)", listOf("The findings should be treated as preliminary."),
            g("Kanıta göre ihtiyat", "Appears to, may ve should be treated as preliminary ifadeleri kesinlik düzeyini sınırlar.", "should + be + past participle", "The findings should be treated as preliminary.", "Bulgular ön sonuçlar olarak değerlendirilmelidir.", "Suggests ifadesini proves ile değiştirirsen iddianın gücünü artırırsın."),
            listOf(w("preliminary", "preliminary", "ön / henüz kesinleşmemiş", "sıfat", "These are preliminary findings.", "Bunlar ön bulgulardır."), w("comparison-group", "comparison group", "karşılaştırma grubu", "isim", "There was no comparison group.", "Karşılaştırma grubu yoktu."))),
        lesson("C1-U1-L2", "Görüşleri adil özetleme", "İki farklı görüşün ortak noktasını ve asıl anlaşmazlığını ayırt edebilirim.",
            "We should launch now and learn from feedback. I agree that feedback matters, but a rushed launch could damage trust. Then perhaps we can begin with a limited pilot. That would address my main concern.",
            c("What do both speakers value?", "Learning from feedback", "Avoiding all public testing", "Launching without safeguards", "İkinci konuşmacı feedback matters diyerek geri bildirimin önemini kabul ediyor."),
            c("What compromise addresses the concern?", "A limited pilot", "A nationwide launch immediately", "Permanent cancellation", "Limited pilot, öğrenmeye izin verirken acele geniş çaplı lansman riskini sınırlar."),
            "The first speaker prioritises rapid learning, whereas the second emphasises the risk to public trust. Their disagreement concerns the scale and timing of testing, not whether feedback is useful. A limited pilot offers a possible bridge between the positions.",
            c("Which summary distorts the second speaker's position?", "The second speaker rejects learning from users.", "The second speaker is concerned about trust.", "The second speaker accepts a limited pilot.", "Geri bildirimi reddettiği söylenemez; ikinci konuşmacı önemini açıkça kabul eder."),
            c("A 'bridge between the positions' is...", "a way to reconcile some of their differences", "proof that the positions are identical", "a reason to ignore both views", "Bridge mecazen görüşleri yakınlaştıran ortak çözümü anlatır; görüşlerin aynı olduğunu iddia etmez."),
            c("___ both speakers value feedback, they differ on timing.", "Although", "Because of", "Despite of", "Although + cümle karşıtlık kurar. Because of isim ister; despite of standart bir yapı değildir."),
            c("Summarise both views without misrepresenting either.", "Both value feedback, but they disagree about the risks of an immediate launch.", "One wants feedback and the other rejects it entirely.", "Both insist on an immediate full launch.", "Ortak nokta geri bildirim, anlaşmazlık ise hemen geniş çapta başlamanın riskidir."),
            "Both speakers value feedback, but they differ on timing.", "İki konuşmacı da geri bildirime değer veriyor, ancak zamanlama konusunda ayrılıyorlar.", "İki konuşmacı da geri bildirime değer veriyor, ancak zamanlama konusunda ayrılıyorlar. (Both speakers / value / differ on kullan.)", listOf("Both speakers value feedback, but they differ on timing."),
            g("Karşıt görüşleri birleştirme", "Although + cümle, ortak veya olumlu bir noktaya rağmen süren ayrılığı belirtir.", "Although + cümle, cümle", "Although they agree on the goal, they differ on timing.", "Hedefte anlaşıyorlar, ancak zamanlamada ayrılıyorlar.", "Although ile aynı bağlama bir de but ekleme."),
            listOf(w("prioritise", "prioritise", "öncelik vermek", "fiil", "They prioritise rapid learning.", "Hızlı öğrenmeye öncelik veriyorlar."), w("public-trust", "public trust", "kamuoyu güveni", "isim", "A rushed launch could damage public trust.", "Acele bir lansman kamuoyu güvenini zedeleyebilir."))),
        lesson("C2-U1-L1", "Deyim, ton ve örtük eleştiri", "Bir deyimin bağlama kattığı tutumu ve örtük eleştiriyi ayırt edebilirim.",
            "The director says we're merely tightening our belts. That's one way of putting it: three teams have lost half their staff. Still, we shouldn't throw in the towel before seeing whether the new plan works.",
            c("What does 'That's one way of putting it' imply here?", "The director's wording understates the cuts.", "The speaker fully endorses the director's wording.", "The speaker does not understand any words.", "İşten çıkarmaların büyüklüğü, tightening our belts ifadesinin hafif kaldığını ima eden bir karşılıkla anlatılıyor."),
            c("What does the speaker advise despite the cuts?", "Not giving up before testing the plan", "Ignoring the impact on staff", "Resigning immediately without review", "Throw in the towel vazgeçmektir; shouldn't ile henüz vazgeçilmemesi öneriliyor."),
            "The memo described the closures as 'minor operational adjustments'. Employees, whose entire departments were disappearing, found that phrasing evasive. The author had softened the language so far that it obscured the scale of the decision.",
            c("Why did employees object to the wording?", "It minimised the magnitude of the closures.", "It openly exaggerated the closures.", "It used a precise numerical description.", "Minor adjustments ile departmanların bütünüyle kapanması arasındaki fark, ifadenin küçültücü olduğunu gösterir."),
            c("In this context, 'tightening our belts' means...", "reducing spending", "changing the dress code", "expanding every department", "Deyim maddi kısıntı yapmayı anlatır. Kemer veya kıyafet burada gerçek anlamda kullanılmıyor."),
            c("Little ___ how extensive the cuts would be.", "did they realise", "they did realised", "they realising", "Sınırlayıcı little başa geldiğinde devrik yapı gerekir: did + özne + yalın fiil."),
            c("Choose a neutral, transparent alternative to 'minor adjustments'.", "The company will close three departments.", "A few tiny improvements are on the way.", "Nothing of consequence will change.", "Somut kapanma bilgisini açıkça verir; diğer ifadeler kararı küçültür veya gizler."),
            "We shouldn't throw in the towel before testing the plan.", "Planı denemeden vazgeçmemeliyiz.", "Planı denemeden vazgeçmemeliyiz. (throw in the towel / before testing kullan.)", listOf("We shouldn't throw in the towel before testing the plan.", "We should not throw in the towel before testing the plan."),
            g("Little ile devrik yapı", "Olumsuz veya sınırlayıcı little başta olduğunda yardımcı fiil öznenin önüne geçer.", "Little + did + özne + yalın fiil", "Little did they realise how serious it was.", "Ne kadar ciddi olduğunu pek fark etmediler.", "Did'den sonra realised değil realise kullan."),
            listOf(w("tighten-belts", "tighten our belts", "harcamaları kısmak", "deyim", "We need to tighten our belts.", "Harcamalarımızı kısmamız gerekiyor."), w("throw-towel", "throw in the towel", "pes etmek / vazgeçmek", "deyim", "Don't throw in the towel yet.", "Henüz pes etme."))),
        lesson("C2-U1-L2", "Resmî üslupta mecaz seçimi", "Deyimin anlamını koruyarak resmî bir karşılık seçebilirim.",
            "Leaving the old supplier was a blessing in disguise. The transition was painful, though. Yes, but the faults we found were only the tip of the iceberg. The review uncovered much deeper problems.",
            c("How does the speaker now view leaving the supplier?", "As an initially difficult change with a beneficial outcome", "As a benefit that was obvious from the start", "As a change with no positive consequences", "Blessing in disguise başlangıçta kötü görünen fakat sonradan yararlı olan gelişmeyi anlatır."),
            c("What does 'the tip of the iceberg' suggest?", "The visible faults were a small part of a larger problem.", "All the faults had already been identified.", "The supplier worked in a cold climate.", "Buzdağının görünen kısmı, daha büyük ve görünmeyen sorunların küçük bir bölümüdür."),
            "For a formal audit report, the editor replaced 'the tip of the iceberg' with 'an indication of more extensive underlying failures'. She retained the implication that the visible defects did not capture the full scale of the problem.",
            c("What changed in the revision?", "The register became more formal while the implication remained.", "The meaning became the opposite.", "The editor removed the suggestion of hidden problems.", "Mecaz daha açık resmî ifadeye dönüştürülüyor; daha kapsamlı sorunlar olduğu anlamı korunuyor."),
            c("Which formal phrase best replaces 'burn bridges' in a resignation letter?", "irreparably damage professional relationships", "improve every professional relationship", "construct a new transport route", "Burn bridges, geri dönüşü zor biçimde ilişkileri bozmak demektir; literal köprü inşası değildir."),
            c("Had we reviewed the records earlier, we ___ the failures sooner.", "would have identified", "would identified", "had identifying", "Had we reviewed, if we had reviewed yerine devrik üçüncü koşuldur; sonuç would have + past participle olur."),
            c("Choose wording suitable for a formal audit report.", "The initial defects indicated more extensive underlying failures.", "The whole thing was a total train wreck, obviously.", "A blessing in disguise proves every supplier is unreliable.", "İlk ifade kapsamı ölçülü ve somut biçimde anlatır. Diğerleri aşırı gündelik veya dayanaksız genellemedir."),
            "The visible defects were only the tip of the iceberg.", "Görünen kusurlar daha büyük bir sorunun yalnızca küçük bir bölümüydü.", "Görünen kusurlar buzdağının yalnızca görünen kısmıydı. (visible defects / tip of the iceberg kullan.)", listOf("The visible defects were only the tip of the iceberg."),
            g("If olmadan üçüncü koşul", "Had + özne + past participle, geçmişte gerçekleşmemiş bir koşulu resmî biçimde ifade eder.", "Had + özne + V3, would have + V3", "Had we checked, we would have noticed.", "Kontrol etseydik fark ederdik.", "Had we checked yapısına ayrıca if ekleme."),
            listOf(w("blessing-disguise", "a blessing in disguise", "sonradan hayra dönüşen olumsuz gelişme", "deyim", "The setback was a blessing in disguise.", "Aksilik sonradan hayra dönüştü."), w("iceberg", "the tip of the iceberg", "daha büyük bir sorunun görünen küçük kısmı", "deyim", "These faults are the tip of the iceberg.", "Bu kusurlar daha büyük sorunun görünen küçük kısmı.")))
    ).associateBy { it.id }

    fun revise(unit: LearningUnit): LearningUnit = unit.copy(lessons = unit.lessons.map { lessons[it.id] ?: it })
    fun revisedLessons(): List<LearningLesson> = lessons.values.toList()

    private data class Assessment(val passage: String, val questions: List<Choice>)
    private val assessments = mapOf(
        "A1-U1" to Assessment("Hello, I'm Nora. I'm from Spain. My friend is Tom. He is from Canada. My last name is Diaz. D, I, A, Z.", listOf(
            c("Where is Nora from?", "Spain", "Canada", "Italy", "Nora I'm from Spain diyor; Canada arkadaşının ülkesi."),
            c("What is Nora's last name?", "Diaz", "Nora", "Tom", "My last name is Diaz ifadesi soyadını verir."),
            c("Who is from Canada?", "Tom", "Nora", "Both Nora and Tom", "He zamiri önceki cümledeki Tom'a gönderme yapıyor."),
            c("Tom ile ilk kez tanışıyorsun. Hangisi uygun?", "Nice to meet you, Tom.", "My country is your name.", "You from am Canada.", "İlk tanışmada Nice to meet you kullanılır."),
            c("Where ___ Nora from?", "is", "are", "am", "Nora tekil üçüncü kişidir; is kullanılır.")
        )),
        "A1-U2" to Assessment("I'm Dan. My sister is Eva. I get up at six and have breakfast at seven. Eva gets up at eight. Our mother goes to work at nine.", listOf(
            c("Who is Eva?", "Dan's sister", "Dan's mother", "Dan's father", "Dan My sister is Eva diyor."),
            c("When does Dan have breakfast?", "At seven", "At six", "At eight", "Altı kalkma, yedi kahvaltı saatidir."),
            c("Who gets up later, Dan or Eva?", "Eva", "Dan", "They get up at the same time.", "Dan altıda, Eva sekizde kalkar; Eva daha geç kalkar."),
            c("What happens at nine?", "Their mother goes to work.", "Dan gets up.", "Eva has breakfast.", "At nine annelerinin işe gitmesini belirtir; Eva'nın kahvaltı saati söylenmez."),
            c("This is ___ sister, Eva. (Benim.)", "my", "me", "I", "My isimden önce sahiplik bildirir.")
        )),
        "A2-U1" to Assessment("Yesterday, I bought a return ticket to Bath for eighteen pounds. The train left at ten fifteen from platform two. I visited a museum and came home in the evening.", listOf(
            c("What kind of ticket did the traveller buy?", "Return", "Single", "A season ticket", "Return gidiş-dönüş bilettir."),
            c("What time did the train leave?", "Ten fifteen", "Ten fifty", "Two o'clock", "Ten fifteen saat 10.15; two peron numarasıdır."),
            c("What did the traveller do in Bath?", "Visited a museum", "Stayed for a week", "Bought eighteen tickets", "Museum ziyareti açıkça anlatılıyor; bir haftalık konaklama yok."),
            c("Was the traveller home that evening?", "Yes", "No", "The text does not say.", "Came home in the evening ifadesi eve dönüşü doğrular."),
            c("Yesterday, the train ___ at ten fifteen.", "left", "leave", "leaving", "Yesterday bitmiş geçmiş zamandır; leave → left.")
        )),
        "B1-U1" to Assessment("Could we review the project on Thursday morning? I can't then, but Friday afternoon is free. Fine, let's meet at three on Friday. I've completed two similar projects so far. Last month, I finished the second one a day early.", listOf(
            c("When is the agreed meeting?", "Friday at three", "Thursday morning", "Friday morning", "Thursday reddediliyor; kabul edilen zaman Friday at three."),
            c("How many similar projects has the speaker completed?", "Two", "Three", "One", "Two similar projects deneyim sayısıdır; three toplantı saati."),
            c("What happened last month?", "The speaker finished the second project early.", "The speaker cancelled both projects.", "The speaker changed the meeting to Thursday.", "Last month, I finished the second one a day early ifadesine dayanır."),
            c("Choose a polite request for a different time.", "Would Monday afternoon work for you?", "You will come when I say.", "Friday was three projects.", "Would ... work for you? karşı tarafın uygunluğunu sorar."),
            c("I ___ two similar projects so far.", "have completed", "am complete", "have completing", "So far ile have + completed kullanılır.")
        )),
        "B2-U1" to Assessment("We could release the full product next week, but the tests have only covered a small group. Let's send a draft plan on Tuesday and run a limited trial first. If the trial reveals no serious issues, we can discuss a wider release on Friday.", listOf(
            c("What will be sent on Tuesday?", "A draft plan", "The full product", "A final audit", "Tuesday teslimi taslak plandır; full release kararı verilmemiştir."),
            c("What do they agree to do before considering a wider release?", "Run a limited trial", "Skip the remaining tests", "Cancel the product permanently", "Limited trial önce gelir; geniş yayın denemeye bağlıdır."),
            c("Which claim overstates their agreement?", "A full release is guaranteed on Friday.", "They plan to discuss a wider release on Friday.", "The draft plan is due Tuesday.", "Discuss bir kararın tartışılmasıdır; release is guaranteed anlamına gelmez."),
            c("Why is the initial evidence limited?", "Only a small group has been tested.", "The product has already failed everywhere.", "The draft was delivered late.", "Small group testlerin kapsamını sınırlar; genel başarısızlık kanıtı değildir."),
            c("Would you be open to ___ a limited trial?", "running", "run", "ran", "Be open to yapısında to edattır ve -ing ister.")
        )),
        "C1-U1" to Assessment("The study reports a modest improvement, although participation was voluntary and there was no control group. One reviewer calls for a larger controlled study; another supports a small pilot while gathering further evidence. Both regard the initial results as promising, rather than conclusive.", listOf(
            c("What do both reviewers agree on?", "The results are promising but not conclusive.", "The programme has been conclusively proven.", "No further evidence could be useful.", "Both ve rather than conclusive ortak ihtiyatlı değerlendirmeyi verir."),
            c("What does the second reviewer support?", "A small pilot with continued evidence gathering", "A full rollout without evaluation", "Abandoning all testing", "While gathering further evidence pilotla değerlendirmeyi birlikte önerir."),
            c("Which causal claim is justified?", "The source of the improvement remains uncertain.", "Voluntary participation proves causation.", "The study rules out all alternative explanations.", "Kontrol grubu yokken iyileşmenin nedenini kesin ayırt etmek mümkün değildir."),
            c("What is the substantive difference between the reviewers?", "How to proceed while the evidence is incomplete", "Whether the reported results are conclusive", "Whether any improvement was reported", "İkisi de bulguları umut verici fakat kesinleşmemiş görüyor; sonraki adımda ayrılıyorlar."),
            c("___ the results are promising, the evidence remains limited.", "Although", "Despite of", "Because of", "Although ardından tam cümle alır; because of isim ister, despite of hatalıdır.")
        )),
        "C2-U1" to Assessment("The chair called the shutdown a minor adjustment. 'An adjustment with rather major consequences,' the representative replied. An internal review later found that the visible defects were only a fraction of deeper failures. The formal report recommended preserving professional relationships during the transition.", listOf(
            c("What does the representative's reply imply?", "The chair's wording minimises the consequences.", "The representative thinks the consequences are trivial.", "The representative rejects the existence of a shutdown.", "Minor ile rather major arasındaki karşıtlık örtük eleştiriyi kurar."),
            c("What did the review discover?", "More extensive failures beneath the visible defects", "That the visible defects were the only failures", "That the shutdown had no consequences", "Only a fraction of deeper failures daha kapsamlı gizli sorunlara işaret eder."),
            c("Which idiom matches the review's finding?", "The tip of the iceberg", "A blessing in disguise", "Tightening our belts", "Görünen sorunların daha büyük sorunun küçük bölümü olması tip of the iceberg anlamıdır."),
            c("Which formal wording preserves 'don't burn your bridges'?", "Avoid irreparably damaging professional relationships.", "Terminate every relationship immediately.", "Construct additional physical bridges.", "İlişkileri kalıcı biçimde bozmamak deyimin resmî karşılığıdır."),
            c("Had the board acted earlier, it ___ some disruption.", "might have prevented", "might prevented", "had prevent", "Devrik geçmiş koşulun sonucu might have + past participle ile kurulabilir.")
        ))
    )

    fun checkpointFor(unit: LearningUnit): LearningLesson? {
        val assessment = assessments[unit.id] ?: return null
        val skills = listOf(Skill.LISTENING, Skill.LISTENING, Skill.READING, Skill.READING, Skill.GRAMMAR)
        return LearningLesson("${unit.id}-CP", "Yeni senaryo: ${unit.title}",
            "Yeni bir bağlamda öğrendiklerini uygula; beş soruda en az yüzde 80 başarı göster.",
            assessment.questions.mapIndexed { index, choice ->
                activity("editorial-${unit.id.lowercase()}-assessment-$index", skills[index], choice,
                    passage = if (skills[index] == Skill.READING) assessment.passage else "",
                    audio = if (skills[index] == Skill.LISTENING) assessment.passage else null)
            })
    }
}
