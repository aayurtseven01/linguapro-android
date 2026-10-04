package com.linguapro.android

/** Japonca (JA) tam müfredat: A1-C2, 36 ünite, 108 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseJA {
    val units: List<LearningUnit> = listOf(
        LearningUnit("JA-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("JA-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'こんにちは' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "こんにちは、アンナです。 — Merhaba, ben Anna.", null, null),
                LearningExercise("jaa1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'ありがとう' ne anlama gelir?", "", listOf("memnun oldum", "teşekkürler", "lütfen (rica)"), listOf("teşekkürler"), "ありがとうございます。 — Teşekkür ederim.", null, null),
                LearningExercise("jaa1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'お願いします' ne anlama gelir?", "", listOf("lütfen (rica)", "hoşça kal", "merhaba"), listOf("lütfen (rica)"), "コーヒーをお願いします。 — Kahve lütfen.", null, null)), listOf(
                TargetVocabulary("jaa1u1w1", "こんにちは", "merhaba", "ifade", "こんにちは、アンナです。", "Merhaba, ben Anna."),
                TargetVocabulary("jaa1u1w2", "ありがとう", "teşekkürler", "ifade", "ありがとうございます。", "Teşekkür ederim."),
                TargetVocabulary("jaa1u1w3", "お願いします", "lütfen (rica)", "ifade", "コーヒーをお願いします。", "Kahve lütfen."),
                TargetVocabulary("jaa1u1w4", "さようなら", "hoşça kal", "ifade", "さようなら、また明日！", "Hoşça kal, yarın görüşürüz!"),
                TargetVocabulary("jaa1u1w5", "はじめまして", "memnun oldum", "ifade", "はじめまして、メフメトです。", "Memnun oldum, ben Mehmet."))),
            LearningLesson("JA-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___、アンナです。", "", listOf("お願いします", "こんにちは", "ありがとう"), listOf("こんにちは"), "Doğru cümle: こんにちは、アンナです。 — Merhaba, ben Anna.", null, null),
                LearningExercise("jaa1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___、また明日！", "", listOf("さようなら", "はじめまして", "こんにちは"), listOf("さようなら"), "Doğru cümle: さようなら、また明日！ — Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("jaa1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Kahve lütfen.", "Memnun oldum, ben Mehmet."), listOf("Memnun oldum, ben Mehmet."), "Söylenen cümle: はじめまして、メフメトです。", "はじめまして、メフメトです。", null),
                LearningExercise("jaa1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "さようなら、また明日！", listOf("Hoşça kal, yarın görüşürüz!", "Teşekkür ederim.", "Memnun oldum, ben Mehmet."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("JA-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "私はメフメト___。", "", listOf("です", "ます", "から"), listOf("です"), "Cümle sonu kibar koşaç: です.", null, null),
                LearningExercise("jaa1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: ありがとうございます。", "", listOf(), listOf("ありがとうございます。"), "Türkçesi: Teşekkür ederim.", "ありがとうございます。", "ありがとうございます。"),
                LearningExercise("jaa1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lütfen (rica)' ifadesinin Japonca karşılığı hangisi?", "", listOf("はじめまして", "お願いします", "こんにちは"), listOf("お願いします"), "Örnek: コーヒーをお願いします。 — Kahve lütfen.", null, null))),
            LearningLesson("JA-A1-U1-L4", "Selamlaşma ve Tanışma — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa1u1e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("こんにちは、アンナです。"), "Söylenen cümle: こんにちは、アンナです。 — Merhaba, ben Anna.", "こんにちは、アンナです。", null),
                LearningExercise("jaa1u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Hoşça kal, yarın görüşürüz!", "Memnun oldum, ben Mehmet.", "Teşekkür ederim."), listOf("Teşekkür ederim."), "Söylenen cümle: ありがとうございます。", "ありがとうございます。", null),
                LearningExercise("jaa1u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'hoşça kal' ifadesinin Japonca karşılığı hangisi?", "", listOf("さようなら", "ありがとう", "はじめまして"), listOf("さようなら"), "Örnek: さようなら、また明日！ — Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("JA-A1-U1-L5", "Selamlaşma ve Tanışma — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa1u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "はじめまして、メフメトです。", listOf("Hoşça kal, yarın görüşürüz!", "Memnun oldum, ben Mehmet.", "Teşekkür ederim."), listOf("Memnun oldum, ben Mehmet."), "Cümlenin çevirisi: Memnun oldum, ben Mehmet.", null, null),
                LearningExercise("jaa1u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "さようなら、また明日！", listOf("Hoşça kal, yarın görüşürüz!", "Kahve lütfen.", "Memnun oldum, ben Mehmet."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("jaa1u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: こんにちは、アンナです。", "", listOf(), listOf("こんにちは、アンナです。"), "Türkçesi: Merhaba, ben Anna.", "こんにちは、アンナです。", "こんにちは、アンナです。"))))),
        LearningUnit("JA-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("JA-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'二' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "二人の兄弟がいます。 — İki kardeşim var.", null, null),
                LearningExercise("jaa1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'十' ne anlama gelir?", "", listOf("on", "bugün", "saat (...da)"), listOf("on"), "今、十時です。 — Saat şimdi on.", null, null),
                LearningExercise("jaa1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'今日' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "今日は月曜日です。 — Bugün pazartesi.", null, null)), listOf(
                TargetVocabulary("jaa1u2w1", "二", "iki", "ifade", "二人の兄弟がいます。", "İki kardeşim var."),
                TargetVocabulary("jaa1u2w2", "十", "on", "ifade", "今、十時です。", "Saat şimdi on."),
                TargetVocabulary("jaa1u2w3", "今日", "bugün", "ifade", "今日は月曜日です。", "Bugün pazartesi."),
                TargetVocabulary("jaa1u2w4", "明日", "yarın", "ifade", "また明日！", "Yarın görüşürüz!"),
                TargetVocabulary("jaa1u2w5", "時", "saat (...da)", "ifade", "今、何時ですか。", "Şu an saat kaç?"))),
            LearningLesson("JA-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___人の兄弟がいます。", "", listOf("二", "十", "今日"), listOf("二"), "Doğru cümle: 二人の兄弟がいます。 — İki kardeşim var.", null, null),
                LearningExercise("jaa1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "また___！", "", listOf("時", "二", "明日"), listOf("明日"), "Doğru cümle: また明日！ — Yarın görüşürüz!", null, null),
                LearningExercise("jaa1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Şu an saat kaç?", "İki kardeşim var."), listOf("Şu an saat kaç?"), "Söylenen cümle: 今、何時ですか。", "今、何時ですか。", null),
                LearningExercise("jaa1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "また明日！", listOf("Saat şimdi on.", "Şu an saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("JA-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "今、何___ですか。", "", listOf("時", "分", "日"), listOf("時"), "Saat sorma kalıbı: 何時ですか。", null, null),
                LearningExercise("jaa1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 今、十時です。", "", listOf(), listOf("今、十時です。"), "Türkçesi: Saat şimdi on.", "今、十時です。", "今、十時です。"),
                LearningExercise("jaa1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bugün' ifadesinin Japonca karşılığı hangisi?", "", listOf("今日", "二", "時"), listOf("今日"), "Örnek: 今日は月曜日です。 — Bugün pazartesi.", null, null))),
            LearningLesson("JA-A1-U2-L4", "Sayılar ve Zaman — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa1u2e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("二人の兄弟がいます。"), "Söylenen cümle: 二人の兄弟がいます。 — İki kardeşim var.", "二人の兄弟がいます。", null),
                LearningExercise("jaa1u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şu an saat kaç?", "Saat şimdi on.", "Yarın görüşürüz!"), listOf("Saat şimdi on."), "Söylenen cümle: 今、十時です。", "今、十時です。", null),
                LearningExercise("jaa1u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'yarın' ifadesinin Japonca karşılığı hangisi?", "", listOf("十", "時", "明日"), listOf("明日"), "Örnek: また明日！ — Yarın görüşürüz!", null, null))),
            LearningLesson("JA-A1-U2-L5", "Sayılar ve Zaman — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa1u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "今、何時ですか。", listOf("Şu an saat kaç?", "Saat şimdi on.", "Yarın görüşürüz!"), listOf("Şu an saat kaç?"), "Cümlenin çevirisi: Şu an saat kaç?", null, null),
                LearningExercise("jaa1u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "また明日！", listOf("Bugün pazartesi.", "Şu an saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null),
                LearningExercise("jaa1u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 二人の兄弟がいます。", "", listOf(), listOf("二人の兄弟がいます。"), "Türkçesi: İki kardeşim var.", "二人の兄弟がいます。", "二人の兄弟がいます。"))))),
        LearningUnit("JA-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("JA-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'水' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "水をください。 — Su lütfen.", null, null),
                LearningExercise("jaa1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'パン' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "パンは新しいです。 — Ekmek taze.", null, null),
                LearningExercise("jaa1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'コーヒー' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "コーヒーを飲みます。 — Kahve içiyorum.", null, null)), listOf(
                TargetVocabulary("jaa1u3w1", "水", "su", "ifade", "水をください。", "Su lütfen."),
                TargetVocabulary("jaa1u3w2", "パン", "ekmek", "ifade", "パンは新しいです。", "Ekmek taze."),
                TargetVocabulary("jaa1u3w3", "コーヒー", "kahve", "ifade", "コーヒーを飲みます。", "Kahve içiyorum."),
                TargetVocabulary("jaa1u3w4", "りんご", "elma", "ifade", "りんごは赤いです。", "Elma kırmızı."),
                TargetVocabulary("jaa1u3w5", "お茶", "çay", "ifade", "お茶が好きです。", "Çayı severim."))),
            LearningLesson("JA-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___をください。", "", listOf("パン", "コーヒー", "水"), listOf("水"), "Doğru cümle: 水をください。 — Su lütfen.", null, null),
                LearningExercise("jaa1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は赤いです。", "", listOf("水", "りんご", "お茶"), listOf("りんご"), "Doğru cümle: りんごは赤いです。 — Elma kırmızı.", null, null),
                LearningExercise("jaa1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çayı severim.", "Su lütfen.", "Kahve içiyorum."), listOf("Çayı severim."), "Söylenen cümle: お茶が好きです。", "お茶が好きです。", null),
                LearningExercise("jaa1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "りんごは赤いです。", listOf("Çayı severim.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("JA-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "コーヒー___飲みます。", "", listOf("を", "は", "に"), listOf("を"), "Nesne edatı: を.", null, null),
                LearningExercise("jaa1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: パンは新しいです。", "", listOf(), listOf("パンは新しいです。"), "Türkçesi: Ekmek taze.", "パンは新しいです。", "パンは新しいです。"),
                LearningExercise("jaa1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kahve' ifadesinin Japonca karşılığı hangisi?", "", listOf("水", "お茶", "コーヒー"), listOf("コーヒー"), "Örnek: コーヒーを飲みます。 — Kahve içiyorum.", null, null))),
            LearningLesson("JA-A1-U3-L4", "Yiyecek ve İçecek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa1u3e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("水をください。"), "Söylenen cümle: 水をください。 — Su lütfen.", "水をください。", null),
                LearningExercise("jaa1u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekmek taze.", "Elma kırmızı.", "Çayı severim."), listOf("Ekmek taze."), "Söylenen cümle: パンは新しいです。", "パンは新しいです。", null),
                LearningExercise("jaa1u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'elma' ifadesinin Japonca karşılığı hangisi?", "", listOf("お茶", "りんご", "パン"), listOf("りんご"), "Örnek: りんごは赤いです。 — Elma kırmızı.", null, null))),
            LearningLesson("JA-A1-U3-L5", "Yiyecek ve İçecek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa1u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "お茶が好きです。", listOf("Ekmek taze.", "Elma kırmızı.", "Çayı severim."), listOf("Çayı severim."), "Cümlenin çevirisi: Çayı severim.", null, null),
                LearningExercise("jaa1u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "りんごは赤いです。", listOf("Çayı severim.", "Elma kırmızı.", "Kahve içiyorum."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null),
                LearningExercise("jaa1u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 水をください。", "", listOf(), listOf("水をください。"), "Türkçesi: Su lütfen.", "水をください。", "水をください。"))))),
        LearningUnit("JA-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("JA-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'家族' ne anlama gelir?", "", listOf("anne", "ağabey", "aile"), listOf("aile"), "家族は大きいです。 — Ailem kalabalık.", null, null),
                LearningExercise("jaa1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'母' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "母は家にいます。 — Annem evde.", null, null),
                LearningExercise("jaa1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'父' ne anlama gelir?", "", listOf("baba", "ağabey", "aile"), listOf("baba"), "父はよく働きます。 — Babam çok çalışır.", null, null)), listOf(
                TargetVocabulary("jaa1u4w1", "家族", "aile", "ifade", "家族は大きいです。", "Ailem kalabalık."),
                TargetVocabulary("jaa1u4w2", "母", "anne", "ifade", "母は家にいます。", "Annem evde."),
                TargetVocabulary("jaa1u4w3", "父", "baba", "ifade", "父はよく働きます。", "Babam çok çalışır."),
                TargetVocabulary("jaa1u4w4", "兄", "ağabey", "ifade", "兄は若いです。", "Ağabeyim genç."),
                TargetVocabulary("jaa1u4w5", "友達", "arkadaş", "ifade", "彼は友達です。", "O benim arkadaşım."))),
            LearningLesson("JA-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は大きいです。", "", listOf("父", "家族", "母"), listOf("家族"), "Doğru cümle: 家族は大きいです。 — Ailem kalabalık.", null, null),
                LearningExercise("jaa1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は若いです。", "", listOf("兄", "友達", "家族"), listOf("兄"), "Doğru cümle: 兄は若いです。 — Ağabeyim genç.", null, null),
                LearningExercise("jaa1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: 彼は友達です。", "彼は友達です。", null),
                LearningExercise("jaa1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "兄は若いです。", listOf("Ağabeyim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null))),
            LearningLesson("JA-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "これは私___本です。", "", listOf("の", "を", "が"), listOf("の"), "Sahiplik edatı: の.", null, null),
                LearningExercise("jaa1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 母は家にいます。", "", listOf(), listOf("母は家にいます。"), "Türkçesi: Annem evde.", "母は家にいます。", "母は家にいます。"),
                LearningExercise("jaa1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baba' ifadesinin Japonca karşılığı hangisi?", "", listOf("友達", "父", "家族"), listOf("父"), "Örnek: 父はよく働きます。 — Babam çok çalışır.", null, null))),
            LearningLesson("JA-A1-U4-L4", "Aile ve İnsanlar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa1u4e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("家族は大きいです。"), "Söylenen cümle: 家族は大きいです。 — Ailem kalabalık.", "家族は大きいです。", null),
                LearningExercise("jaa1u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ağabeyim genç.", "O benim arkadaşım.", "Annem evde."), listOf("Annem evde."), "Söylenen cümle: 母は家にいます。", "母は家にいます。", null),
                LearningExercise("jaa1u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ağabey' ifadesinin Japonca karşılığı hangisi?", "", listOf("兄", "母", "友達"), listOf("兄"), "Örnek: 兄は若いです。 — Ağabeyim genç.", null, null))),
            LearningLesson("JA-A1-U4-L5", "Aile ve İnsanlar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa1u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼は友達です。", listOf("Ağabeyim genç.", "O benim arkadaşım.", "Annem evde."), listOf("O benim arkadaşım."), "Cümlenin çevirisi: O benim arkadaşım.", null, null),
                LearningExercise("jaa1u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "兄は若いです。", listOf("Ağabeyim genç.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null),
                LearningExercise("jaa1u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 家族は大きいです。", "", listOf(), listOf("家族は大きいです。"), "Türkçesi: Ailem kalabalık.", "家族は大きいです。", "家族は大きいです。"))))),
        LearningUnit("JA-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("JA-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'家' ne anlama gelir?", "", listOf("satın alırım", "ev", "iş"), listOf("ev"), "家は古いです。 — Ev eski.", null, null),
                LearningExercise("jaa1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'仕事' ne anlama gelir?", "", listOf("iş", "şehir / kasaba", "oturuyorum"), listOf("iş"), "仕事に行きます。 — İşe gidiyorum.", null, null),
                LearningExercise("jaa1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'町' ne anlama gelir?", "", listOf("satın alırım", "ev", "şehir / kasaba"), listOf("şehir / kasaba"), "町はきれいです。 — Şehir güzel.", null, null)), listOf(
                TargetVocabulary("jaa1u5w1", "家", "ev", "ifade", "家は古いです。", "Ev eski."),
                TargetVocabulary("jaa1u5w2", "仕事", "iş", "ifade", "仕事に行きます。", "İşe gidiyorum."),
                TargetVocabulary("jaa1u5w3", "町", "şehir / kasaba", "ifade", "町はきれいです。", "Şehir güzel."),
                TargetVocabulary("jaa1u5w4", "買います", "satın alırım", "ifade", "果物を買います。", "Meyve alıyorum."),
                TargetVocabulary("jaa1u5w5", "住んでいます", "oturuyorum", "ifade", "東京に住んでいます。", "Tokyo'da oturuyorum."))),
            LearningLesson("JA-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は古いです。", "", listOf("家", "仕事", "町"), listOf("家"), "Doğru cümle: 家は古いです。 — Ev eski.", null, null),
                LearningExercise("jaa1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "果物を___。", "", listOf("住んでいます", "家", "買います"), listOf("買います"), "Doğru cümle: 果物を買います。 — Meyve alıyorum.", null, null),
                LearningExercise("jaa1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Tokyo'da oturuyorum.", "Ev eski."), listOf("Tokyo'da oturuyorum."), "Söylenen cümle: 東京に住んでいます。", "東京に住んでいます。", null),
                LearningExercise("jaa1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "果物を買います。", listOf("İşe gidiyorum.", "Tokyo'da oturuyorum.", "Meyve alıyorum."), listOf("Meyve alıyorum."), "Cümlenin çevirisi: Meyve alıyorum.", null, null))),
            LearningLesson("JA-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "東京___住んでいます。", "", listOf("に", "を", "へ"), listOf("に"), "Yer edatı: に.", null, null),
                LearningExercise("jaa1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 仕事に行きます。", "", listOf(), listOf("仕事に行きます。"), "Türkçesi: İşe gidiyorum.", "仕事に行きます。", "仕事に行きます。"),
                LearningExercise("jaa1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'şehir / kasaba' ifadesinin Japonca karşılığı hangisi?", "", listOf("町", "家", "住んでいます"), listOf("町"), "Örnek: 町はきれいです。 — Şehir güzel.", null, null))),
            LearningLesson("JA-A1-U5-L4", "Günlük Yaşam ve Şehir — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa1u5e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("家は古いです。"), "Söylenen cümle: 家は古いです。 — Ev eski.", "家は古いです。", null),
                LearningExercise("jaa1u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Tokyo'da oturuyorum.", "İşe gidiyorum.", "Meyve alıyorum."), listOf("İşe gidiyorum."), "Söylenen cümle: 仕事に行きます。", "仕事に行きます。", null),
                LearningExercise("jaa1u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'satın alırım' ifadesinin Japonca karşılığı hangisi?", "", listOf("仕事", "住んでいます", "買います"), listOf("買います"), "Örnek: 果物を買います。 — Meyve alıyorum.", null, null))),
            LearningLesson("JA-A1-U5-L5", "Günlük Yaşam ve Şehir — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa1u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "東京に住んでいます。", listOf("Tokyo'da oturuyorum.", "İşe gidiyorum.", "Meyve alıyorum."), listOf("Tokyo'da oturuyorum."), "Cümlenin çevirisi: Tokyo'da oturuyorum.", null, null),
                LearningExercise("jaa1u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "果物を買います。", listOf("Şehir güzel.", "Tokyo'da oturuyorum.", "Meyve alıyorum."), listOf("Meyve alıyorum."), "Cümlenin çevirisi: Meyve alıyorum.", null, null),
                LearningExercise("jaa1u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 家は古いです。", "", listOf(), listOf("家は古いです。"), "Türkçesi: Ev eski.", "家は古いです。", "家は古いです。"))))),
        LearningUnit("JA-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("JA-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'電車' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "電車は九時に来ます。 — Tren dokuzda geliyor.", null, null),
                LearningExercise("jaa1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'切符' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "切符を一枚ください。 — Bir bilet lütfen.", null, null),
                LearningExercise("jaa1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'ホテル' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "ホテルは中心にあります。 — Otel merkezde.", null, null)), listOf(
                TargetVocabulary("jaa1u6w1", "電車", "tren", "ifade", "電車は九時に来ます。", "Tren dokuzda geliyor."),
                TargetVocabulary("jaa1u6w2", "切符", "bilet", "ifade", "切符を一枚ください。", "Bir bilet lütfen."),
                TargetVocabulary("jaa1u6w3", "ホテル", "otel", "ifade", "ホテルは中心にあります。", "Otel merkezde."),
                TargetVocabulary("jaa1u6w4", "左", "sol", "ifade", "左に曲がってください。", "Sola dönün lütfen."),
                TargetVocabulary("jaa1u6w5", "空港", "havalimanı", "ifade", "空港は遠いです。", "Havalimanı uzak."))),
            LearningLesson("JA-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は九時に来ます。", "", listOf("切符", "ホテル", "電車"), listOf("電車"), "Doğru cümle: 電車は九時に来ます。 — Tren dokuzda geliyor.", null, null),
                LearningExercise("jaa1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___に曲がってください。", "", listOf("電車", "左", "空港"), listOf("左"), "Doğru cümle: 左に曲がってください。 — Sola dönün lütfen.", null, null),
                LearningExercise("jaa1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: 空港は遠いです。", "空港は遠いです。", null),
                LearningExercise("jaa1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "左に曲がってください。", listOf("Havalimanı uzak.", "Sola dönün lütfen.", "Bir bilet lütfen."), listOf("Sola dönün lütfen."), "Cümlenin çevirisi: Sola dönün lütfen.", null, null))),
            LearningLesson("JA-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "切符を一枚___。", "", listOf("ください", "います", "あります"), listOf("ください"), "Rica kalıbı: ください (lütfen verin).", null, null),
                LearningExercise("jaa1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 切符を一枚ください。", "", listOf(), listOf("切符を一枚ください。"), "Türkçesi: Bir bilet lütfen.", "切符を一枚ください。", "切符を一枚ください。"),
                LearningExercise("jaa1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Japonca karşılığı hangisi?", "", listOf("電車", "空港", "ホテル"), listOf("ホテル"), "Örnek: ホテルは中心にあります。 — Otel merkezde.", null, null))),
            LearningLesson("JA-A1-U6-L4", "Seyahat Temelleri — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa1u6e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("電車は九時に来ます。"), "Söylenen cümle: 電車は九時に来ます。 — Tren dokuzda geliyor.", "電車は九時に来ます。", null),
                LearningExercise("jaa1u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bir bilet lütfen.", "Sola dönün lütfen.", "Havalimanı uzak."), listOf("Bir bilet lütfen."), "Söylenen cümle: 切符を一枚ください。", "切符を一枚ください。", null),
                LearningExercise("jaa1u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sol' ifadesinin Japonca karşılığı hangisi?", "", listOf("空港", "左", "切符"), listOf("左"), "Örnek: 左に曲がってください。 — Sola dönün lütfen.", null, null))),
            LearningLesson("JA-A1-U6-L5", "Seyahat Temelleri — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa1u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "空港は遠いです。", listOf("Bir bilet lütfen.", "Sola dönün lütfen.", "Havalimanı uzak."), listOf("Havalimanı uzak."), "Cümlenin çevirisi: Havalimanı uzak.", null, null),
                LearningExercise("jaa1u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "左に曲がってください。", listOf("Havalimanı uzak.", "Sola dönün lütfen.", "Otel merkezde."), listOf("Sola dönün lütfen."), "Cümlenin çevirisi: Sola dönün lütfen.", null, null),
                LearningExercise("jaa1u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 電車は九時に来ます。", "", listOf(), listOf("電車は九時に来ます。"), "Türkçesi: Tren dokuzda geliyor.", "電車は九時に来ます。", "電車は九時に来ます。"))))),
        LearningUnit("JA-A2-U1", "Geçmişten Bahsetmek", "Geçmişte olanları anlat.", listOf(
            LearningLesson("JA-A2-U1-L1", "Geçmişten Bahsetmek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'昨日' ne anlama gelir?", "", listOf("geçen hafta", "gördü/izledi", "dün"), listOf("dün"), "昨日、働きました。 — Dün çalıştım.", null, null),
                LearningExercise("jaa2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'先週' ne anlama gelir?", "", listOf("yolculuk", "geçen hafta", "satın aldı"), listOf("geçen hafta"), "先週、病気でした。 — Geçen hafta hastaydım.", null, null),
                LearningExercise("jaa2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'買いました' ne anlama gelir?", "", listOf("satın aldı", "gördü/izledi", "dün"), listOf("satın aldı"), "パンを買いました。 — Ekmek aldım.", null, null)), listOf(
                TargetVocabulary("jaa2u1w1", "昨日", "dün", "ifade", "昨日、働きました。", "Dün çalıştım."),
                TargetVocabulary("jaa2u1w2", "先週", "geçen hafta", "ifade", "先週、病気でした。", "Geçen hafta hastaydım."),
                TargetVocabulary("jaa2u1w3", "買いました", "satın aldı", "ifade", "パンを買いました。", "Ekmek aldım."),
                TargetVocabulary("jaa2u1w4", "見ました", "gördü/izledi", "ifade", "その映画を見ました。", "O filmi izledim."),
                TargetVocabulary("jaa2u1w5", "旅行", "yolculuk", "ifade", "旅行は楽しかったです。", "Yolculuk keyifliydi."))),
            LearningLesson("JA-A2-U1-L2", "Geçmişten Bahsetmek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___、働きました。", "", listOf("買いました", "昨日", "先週"), listOf("昨日"), "Doğru cümle: 昨日、働きました。 — Dün çalıştım.", null, null),
                LearningExercise("jaa2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "その映画を___。", "", listOf("見ました", "旅行", "昨日"), listOf("見ました"), "Doğru cümle: その映画を見ました。 — O filmi izledim.", null, null),
                LearningExercise("jaa2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dün çalıştım.", "Ekmek aldım.", "Yolculuk keyifliydi."), listOf("Yolculuk keyifliydi."), "Söylenen cümle: 旅行は楽しかったです。", "旅行は楽しかったです。", null),
                LearningExercise("jaa2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "その映画を見ました。", listOf("O filmi izledim.", "Geçen hafta hastaydım.", "Yolculuk keyifliydi."), listOf("O filmi izledim."), "Cümlenin çevirisi: O filmi izledim.", null, null))),
            LearningLesson("JA-A2-U1-L3", "Geçmişten Bahsetmek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "昨日、映画を___。", "", listOf("見ました", "見ます", "見ています"), listOf("見ました"), "Geçmiş kibar biçim: 見ました.", null, null),
                LearningExercise("jaa2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 先週、病気でした。", "", listOf(), listOf("先週、病気でした。"), "Türkçesi: Geçen hafta hastaydım.", "先週、病気でした。", "先週、病気でした。"),
                LearningExercise("jaa2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'satın aldı' ifadesinin Japonca karşılığı hangisi?", "", listOf("旅行", "買いました", "昨日"), listOf("買いました"), "Örnek: パンを買いました。 — Ekmek aldım.", null, null))),
            LearningLesson("JA-A2-U1-L4", "Geçmişten Bahsetmek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa2u1e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("昨日、働きました。"), "Söylenen cümle: 昨日、働きました。 — Dün çalıştım.", "昨日、働きました。", null),
                LearningExercise("jaa2u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O filmi izledim.", "Yolculuk keyifliydi.", "Geçen hafta hastaydım."), listOf("Geçen hafta hastaydım."), "Söylenen cümle: 先週、病気でした。", "先週、病気でした。", null),
                LearningExercise("jaa2u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gördü/izledi' ifadesinin Japonca karşılığı hangisi?", "", listOf("見ました", "先週", "旅行"), listOf("見ました"), "Örnek: その映画を見ました。 — O filmi izledim.", null, null))),
            LearningLesson("JA-A2-U1-L5", "Geçmişten Bahsetmek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa2u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "旅行は楽しかったです。", listOf("O filmi izledim.", "Yolculuk keyifliydi.", "Geçen hafta hastaydım."), listOf("Yolculuk keyifliydi."), "Cümlenin çevirisi: Yolculuk keyifliydi.", null, null),
                LearningExercise("jaa2u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "その映画を見ました。", listOf("O filmi izledim.", "Ekmek aldım.", "Yolculuk keyifliydi."), listOf("O filmi izledim."), "Cümlenin çevirisi: O filmi izledim.", null, null),
                LearningExercise("jaa2u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 昨日、働きました。", "", listOf(), listOf("昨日、働きました。"), "Türkçesi: Dün çalıştım.", "昨日、働きました。", "昨日、働きました。"))))),
        LearningUnit("JA-A2-U2", "Alışveriş ve Para", "Fiyat sor, ödeme yap.", listOf(
            LearningLesson("JA-A2-U2-L1", "Alışveriş ve Para — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'お金' ne anlama gelir?", "", listOf("kaç para", "para", "pahalı"), listOf("para"), "お金が足りません。 — Param yetmiyor.", null, null),
                LearningExercise("jaa2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'高い' ne anlama gelir?", "", listOf("pahalı", "ucuz", "ödemek"), listOf("pahalı"), "この電話は高いです。 — Bu telefon pahalı.", null, null),
                LearningExercise("jaa2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'安い' ne anlama gelir?", "", listOf("kaç para", "para", "ucuz"), listOf("ucuz"), "パンは安いです。 — Ekmek ucuz.", null, null)), listOf(
                TargetVocabulary("jaa2u2w1", "お金", "para", "ifade", "お金が足りません。", "Param yetmiyor."),
                TargetVocabulary("jaa2u2w2", "高い", "pahalı", "ifade", "この電話は高いです。", "Bu telefon pahalı."),
                TargetVocabulary("jaa2u2w3", "安い", "ucuz", "ifade", "パンは安いです。", "Ekmek ucuz."),
                TargetVocabulary("jaa2u2w4", "いくら", "kaç para", "ifade", "これはいくらですか。", "Bu kaç para?"),
                TargetVocabulary("jaa2u2w5", "払います", "ödemek", "ifade", "カードで払います。", "Kartla ödüyorum."))),
            LearningLesson("JA-A2-U2-L2", "Alışveriş ve Para — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___が足りません。", "", listOf("お金", "高い", "安い"), listOf("お金"), "Doğru cümle: お金が足りません。 — Param yetmiyor.", null, null),
                LearningExercise("jaa2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "これは___ですか。", "", listOf("払います", "お金", "いくら"), listOf("いくら"), "Doğru cümle: これはいくらですか。 — Bu kaç para?", null, null),
                LearningExercise("jaa2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekmek ucuz.", "Kartla ödüyorum.", "Param yetmiyor."), listOf("Kartla ödüyorum."), "Söylenen cümle: カードで払います。", "カードで払います。", null),
                LearningExercise("jaa2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "これはいくらですか。", listOf("Bu telefon pahalı.", "Kartla ödüyorum.", "Bu kaç para?"), listOf("Bu kaç para?"), "Cümlenin çevirisi: Bu kaç para?", null, null))),
            LearningLesson("JA-A2-U2-L3", "Alışveriş ve Para — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "これは___ですか。", "", listOf("いくら", "いくつ", "どこ"), listOf("いくら"), "Fiyat sorma: いくらですか。", null, null),
                LearningExercise("jaa2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: この電話は高いです。", "", listOf(), listOf("この電話は高いです。"), "Türkçesi: Bu telefon pahalı.", "この電話は高いです。", "この電話は高いです。"),
                LearningExercise("jaa2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ucuz' ifadesinin Japonca karşılığı hangisi?", "", listOf("安い", "お金", "払います"), listOf("安い"), "Örnek: パンは安いです。 — Ekmek ucuz.", null, null))),
            LearningLesson("JA-A2-U2-L4", "Alışveriş ve Para — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa2u2e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("お金が足りません。"), "Söylenen cümle: お金が足りません。 — Param yetmiyor.", "お金が足りません。", null),
                LearningExercise("jaa2u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kartla ödüyorum.", "Bu telefon pahalı.", "Bu kaç para?"), listOf("Bu telefon pahalı."), "Söylenen cümle: この電話は高いです。", "この電話は高いです。", null),
                LearningExercise("jaa2u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kaç para' ifadesinin Japonca karşılığı hangisi?", "", listOf("高い", "払います", "いくら"), listOf("いくら"), "Örnek: これはいくらですか。 — Bu kaç para?", null, null))),
            LearningLesson("JA-A2-U2-L5", "Alışveriş ve Para — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa2u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "カードで払います。", listOf("Kartla ödüyorum.", "Bu telefon pahalı.", "Bu kaç para?"), listOf("Kartla ödüyorum."), "Cümlenin çevirisi: Kartla ödüyorum.", null, null),
                LearningExercise("jaa2u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "これはいくらですか。", listOf("Ekmek ucuz.", "Kartla ödüyorum.", "Bu kaç para?"), listOf("Bu kaç para?"), "Cümlenin çevirisi: Bu kaç para?", null, null),
                LearningExercise("jaa2u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: お金が足りません。", "", listOf(), listOf("お金が足りません。"), "Türkçesi: Param yetmiyor.", "お金が足りません。", "お金が足りません。"))))),
        LearningUnit("JA-A2-U3", "Sağlık ve Vücut", "Rahatsızlığını anlat, randevu al.", listOf(
            LearningLesson("JA-A2-U3-L1", "Sağlık ve Vücut — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'病気' ne anlama gelir?", "", listOf("hastalık", "doktor", "eczane"), listOf("hastalık"), "今日は病気です。 — Bugün hastayım.", null, null),
                LearningExercise("jaa2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'医者' ne anlama gelir?", "", listOf("baş", "ağrıyor", "doktor"), listOf("doktor"), "医者は十時に来ます。 — Doktor onda geliyor.", null, null),
                LearningExercise("jaa2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'頭' ne anlama gelir?", "", listOf("hastalık", "baş", "eczane"), listOf("baş"), "頭が痛いです。 — Başım ağrıyor.", null, null)), listOf(
                TargetVocabulary("jaa2u3w1", "病気", "hastalık", "ifade", "今日は病気です。", "Bugün hastayım."),
                TargetVocabulary("jaa2u3w2", "医者", "doktor", "ifade", "医者は十時に来ます。", "Doktor onda geliyor."),
                TargetVocabulary("jaa2u3w3", "頭", "baş", "ifade", "頭が痛いです。", "Başım ağrıyor."),
                TargetVocabulary("jaa2u3w4", "薬局", "eczane", "ifade", "薬局は閉まっています。", "Eczane kapalı."),
                TargetVocabulary("jaa2u3w5", "痛い", "ağrıyor", "ifade", "足が痛いです。", "Ayağım ağrıyor."))),
            LearningLesson("JA-A2-U3-L2", "Sağlık ve Vücut — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "今日は___です。", "", listOf("医者", "頭", "病気"), listOf("病気"), "Doğru cümle: 今日は病気です。 — Bugün hastayım.", null, null),
                LearningExercise("jaa2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は閉まっています。", "", listOf("病気", "薬局", "痛い"), listOf("薬局"), "Doğru cümle: 薬局は閉まっています。 — Eczane kapalı.", null, null),
                LearningExercise("jaa2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ayağım ağrıyor.", "Bugün hastayım.", "Başım ağrıyor."), listOf("Ayağım ağrıyor."), "Söylenen cümle: 足が痛いです。", "足が痛いです。", null),
                LearningExercise("jaa2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "薬局は閉まっています。", listOf("Ayağım ağrıyor.", "Eczane kapalı.", "Doktor onda geliyor."), listOf("Eczane kapalı."), "Cümlenin çevirisi: Eczane kapalı.", null, null))),
            LearningLesson("JA-A2-U3-L3", "Sağlık ve Vücut — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "頭___痛いです。", "", listOf("が", "を", "に"), listOf("が"), "Özne edatı: 頭が痛い.", null, null),
                LearningExercise("jaa2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 医者は十時に来ます。", "", listOf(), listOf("医者は十時に来ます。"), "Türkçesi: Doktor onda geliyor.", "医者は十時に来ます。", "医者は十時に来ます。"),
                LearningExercise("jaa2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baş' ifadesinin Japonca karşılığı hangisi?", "", listOf("病気", "痛い", "頭"), listOf("頭"), "Örnek: 頭が痛いです。 — Başım ağrıyor.", null, null))),
            LearningLesson("JA-A2-U3-L4", "Sağlık ve Vücut — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa2u3e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("今日は病気です。"), "Söylenen cümle: 今日は病気です。 — Bugün hastayım.", "今日は病気です。", null),
                LearningExercise("jaa2u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Doktor onda geliyor.", "Eczane kapalı.", "Ayağım ağrıyor."), listOf("Doktor onda geliyor."), "Söylenen cümle: 医者は十時に来ます。", "医者は十時に来ます。", null),
                LearningExercise("jaa2u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'eczane' ifadesinin Japonca karşılığı hangisi?", "", listOf("痛い", "薬局", "医者"), listOf("薬局"), "Örnek: 薬局は閉まっています。 — Eczane kapalı.", null, null))),
            LearningLesson("JA-A2-U3-L5", "Sağlık ve Vücut — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa2u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "足が痛いです。", listOf("Doktor onda geliyor.", "Eczane kapalı.", "Ayağım ağrıyor."), listOf("Ayağım ağrıyor."), "Cümlenin çevirisi: Ayağım ağrıyor.", null, null),
                LearningExercise("jaa2u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "薬局は閉まっています。", listOf("Ayağım ağrıyor.", "Eczane kapalı.", "Başım ağrıyor."), listOf("Eczane kapalı."), "Cümlenin çevirisi: Eczane kapalı.", null, null),
                LearningExercise("jaa2u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 今日は病気です。", "", listOf(), listOf("今日は病気です。"), "Türkçesi: Bugün hastayım.", "今日は病気です。", "今日は病気です。"))))),
        LearningUnit("JA-A2-U4", "Hava Durumu ve Doğa", "Havayı ve mevsimleri anlat.", listOf(
            LearningLesson("JA-A2-U4-L1", "Hava Durumu ve Doğa — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'天気' ne anlama gelir?", "", listOf("yağmur", "soğuk", "hava durumu"), listOf("hava durumu"), "今日は天気がいいです。 — Bugün hava güzel.", null, null),
                LearningExercise("jaa2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'雨' ne anlama gelir?", "", listOf("sıcak", "yağmur", "güneş"), listOf("yağmur"), "明日は雨が降ります。 — Yarın yağmur yağacak.", null, null),
                LearningExercise("jaa2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'太陽' ne anlama gelir?", "", listOf("güneş", "soğuk", "hava durumu"), listOf("güneş"), "太陽が出ています。 — Güneş çıkmış durumda.", null, null)), listOf(
                TargetVocabulary("jaa2u4w1", "天気", "hava durumu", "ifade", "今日は天気がいいです。", "Bugün hava güzel."),
                TargetVocabulary("jaa2u4w2", "雨", "yağmur", "ifade", "明日は雨が降ります。", "Yarın yağmur yağacak."),
                TargetVocabulary("jaa2u4w3", "太陽", "güneş", "ifade", "太陽が出ています。", "Güneş çıkmış durumda."),
                TargetVocabulary("jaa2u4w4", "寒い", "soğuk", "ifade", "冬は寒いです。", "Kışın hava soğuk olur."),
                TargetVocabulary("jaa2u4w5", "暑い", "sıcak", "ifade", "夏は暑いです。", "Yazın hava sıcak olur."))),
            LearningLesson("JA-A2-U4-L2", "Hava Durumu ve Doğa — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "今日は___がいいです。", "", listOf("太陽", "天気", "雨"), listOf("天気"), "Doğru cümle: 今日は天気がいいです。 — Bugün hava güzel.", null, null),
                LearningExercise("jaa2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "冬は___です。", "", listOf("寒い", "暑い", "天気"), listOf("寒い"), "Doğru cümle: 冬は寒いです。 — Kışın hava soğuk olur.", null, null),
                LearningExercise("jaa2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün hava güzel.", "Güneş çıkmış durumda.", "Yazın hava sıcak olur."), listOf("Yazın hava sıcak olur."), "Söylenen cümle: 夏は暑いです。", "夏は暑いです。", null),
                LearningExercise("jaa2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "冬は寒いです。", listOf("Kışın hava soğuk olur.", "Yarın yağmur yağacak.", "Yazın hava sıcak olur."), listOf("Kışın hava soğuk olur."), "Cümlenin çevirisi: Kışın hava soğuk olur.", null, null))),
            LearningLesson("JA-A2-U4-L3", "Hava Durumu ve Doğa — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "明日は雨が___。", "", listOf("降ります", "降りました", "降って"), listOf("降ります"), "Hava: 雨が降ります (yağmur yağar).", null, null),
                LearningExercise("jaa2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 明日は雨が降ります。", "", listOf(), listOf("明日は雨が降ります。"), "Türkçesi: Yarın yağmur yağacak.", "明日は雨が降ります。", "明日は雨が降ります。"),
                LearningExercise("jaa2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'güneş' ifadesinin Japonca karşılığı hangisi?", "", listOf("暑い", "太陽", "天気"), listOf("太陽"), "Örnek: 太陽が出ています。 — Güneş çıkmış durumda.", null, null))),
            LearningLesson("JA-A2-U4-L4", "Hava Durumu ve Doğa — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa2u4e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("今日は天気がいいです。"), "Söylenen cümle: 今日は天気がいいです。 — Bugün hava güzel.", "今日は天気がいいです。", null),
                LearningExercise("jaa2u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kışın hava soğuk olur.", "Yazın hava sıcak olur.", "Yarın yağmur yağacak."), listOf("Yarın yağmur yağacak."), "Söylenen cümle: 明日は雨が降ります。", "明日は雨が降ります。", null),
                LearningExercise("jaa2u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'soğuk' ifadesinin Japonca karşılığı hangisi?", "", listOf("寒い", "雨", "暑い"), listOf("寒い"), "Örnek: 冬は寒いです。 — Kışın hava soğuk olur.", null, null))),
            LearningLesson("JA-A2-U4-L5", "Hava Durumu ve Doğa — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa2u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "夏は暑いです。", listOf("Kışın hava soğuk olur.", "Yazın hava sıcak olur.", "Yarın yağmur yağacak."), listOf("Yazın hava sıcak olur."), "Cümlenin çevirisi: Yazın hava sıcak olur.", null, null),
                LearningExercise("jaa2u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "冬は寒いです。", listOf("Kışın hava soğuk olur.", "Güneş çıkmış durumda.", "Yazın hava sıcak olur."), listOf("Kışın hava soğuk olur."), "Cümlenin çevirisi: Kışın hava soğuk olur.", null, null),
                LearningExercise("jaa2u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 今日は天気がいいです。", "", listOf(), listOf("今日は天気がいいです。"), "Türkçesi: Bugün hava güzel.", "今日は天気がいいです。", "今日は天気がいいです。"))))),
        LearningUnit("JA-A2-U5", "İş ve Okul", "İş ve eğitim hayatından bahset.", listOf(
            LearningLesson("JA-A2-U5-L1", "İş ve Okul — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'オフィス' ne anlama gelir?", "", listOf("öğretmen", "ofis", "ders çalışma"), listOf("ofis"), "オフィスは中心にあります。 — Ofis merkezde.", null, null),
                LearningExercise("jaa2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'勉強' ne anlama gelir?", "", listOf("ders çalışma", "sınav", "toplantı"), listOf("ders çalışma"), "日本語を勉強します。 — Japonca çalışıyorum.", null, null),
                LearningExercise("jaa2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'試験' ne anlama gelir?", "", listOf("öğretmen", "ofis", "sınav"), listOf("sınav"), "試験は金曜日です。 — Sınav cuma günü.", null, null)), listOf(
                TargetVocabulary("jaa2u5w1", "オフィス", "ofis", "ifade", "オフィスは中心にあります。", "Ofis merkezde."),
                TargetVocabulary("jaa2u5w2", "勉強", "ders çalışma", "ifade", "日本語を勉強します。", "Japonca çalışıyorum."),
                TargetVocabulary("jaa2u5w3", "試験", "sınav", "ifade", "試験は金曜日です。", "Sınav cuma günü."),
                TargetVocabulary("jaa2u5w4", "先生", "öğretmen", "ifade", "先生は全部説明します。", "Öğretmen her şeyi açıklıyor."),
                TargetVocabulary("jaa2u5w5", "会議", "toplantı", "ifade", "会議は九時に始まります。", "Toplantı dokuzda başlıyor."))),
            LearningLesson("JA-A2-U5-L2", "İş ve Okul — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は中心にあります。", "", listOf("オフィス", "勉強", "試験"), listOf("オフィス"), "Doğru cümle: オフィスは中心にあります。 — Ofis merkezde.", null, null),
                LearningExercise("jaa2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は全部説明します。", "", listOf("会議", "オフィス", "先生"), listOf("先生"), "Doğru cümle: 先生は全部説明します。 — Öğretmen her şeyi açıklıyor.", null, null),
                LearningExercise("jaa2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sınav cuma günü.", "Toplantı dokuzda başlıyor.", "Ofis merkezde."), listOf("Toplantı dokuzda başlıyor."), "Söylenen cümle: 会議は九時に始まります。", "会議は九時に始まります。", null),
                LearningExercise("jaa2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "先生は全部説明します。", listOf("Japonca çalışıyorum.", "Toplantı dokuzda başlıyor.", "Öğretmen her şeyi açıklıyor."), listOf("Öğretmen her şeyi açıklıyor."), "Cümlenin çevirisi: Öğretmen her şeyi açıklıyor.", null, null))),
            LearningLesson("JA-A2-U5-L3", "İş ve Okul — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "日本語を___します。", "", listOf("勉強", "会議", "試験"), listOf("勉強"), "Suru fiili: 勉強します.", null, null),
                LearningExercise("jaa2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 日本語を勉強します。", "", listOf(), listOf("日本語を勉強します。"), "Türkçesi: Japonca çalışıyorum.", "日本語を勉強します。", "日本語を勉強します。"),
                LearningExercise("jaa2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sınav' ifadesinin Japonca karşılığı hangisi?", "", listOf("試験", "オフィス", "会議"), listOf("試験"), "Örnek: 試験は金曜日です。 — Sınav cuma günü.", null, null))),
            LearningLesson("JA-A2-U5-L4", "İş ve Okul — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa2u5e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("オフィスは中心にあります。"), "Söylenen cümle: オフィスは中心にあります。 — Ofis merkezde.", "オフィスは中心にあります。", null),
                LearningExercise("jaa2u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Toplantı dokuzda başlıyor.", "Japonca çalışıyorum.", "Öğretmen her şeyi açıklıyor."), listOf("Japonca çalışıyorum."), "Söylenen cümle: 日本語を勉強します。", "日本語を勉強します。", null),
                LearningExercise("jaa2u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'öğretmen' ifadesinin Japonca karşılığı hangisi?", "", listOf("勉強", "会議", "先生"), listOf("先生"), "Örnek: 先生は全部説明します。 — Öğretmen her şeyi açıklıyor.", null, null))),
            LearningLesson("JA-A2-U5-L5", "İş ve Okul — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa2u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "会議は九時に始まります。", listOf("Toplantı dokuzda başlıyor.", "Japonca çalışıyorum.", "Öğretmen her şeyi açıklıyor."), listOf("Toplantı dokuzda başlıyor."), "Cümlenin çevirisi: Toplantı dokuzda başlıyor.", null, null),
                LearningExercise("jaa2u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "先生は全部説明します。", listOf("Sınav cuma günü.", "Toplantı dokuzda başlıyor.", "Öğretmen her şeyi açıklıyor."), listOf("Öğretmen her şeyi açıklıyor."), "Cümlenin çevirisi: Öğretmen her şeyi açıklıyor.", null, null),
                LearningExercise("jaa2u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: オフィスは中心にあります。", "", listOf(), listOf("オフィスは中心にあります。"), "Türkçesi: Ofis merkezde.", "オフィスは中心にあります。", "オフィスは中心にあります。"))))),
        LearningUnit("JA-A2-U6", "Planlar ve Gelecek", "Gelecek planlarını anlat.", listOf(
            LearningLesson("JA-A2-U6-L1", "Planlar ve Gelecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'週末' ne anlama gelir?", "", listOf("hafta sonu", "plan", "gelecek yıl"), listOf("hafta sonu"), "週末は休みます。 — Hafta sonu dinlenirim.", null, null),
                LearningExercise("jaa2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'計画' ne anlama gelir?", "", listOf("tatil/izin", "program/plan", "plan"), listOf("plan"), "夏の計画があります。 — Yaz için bir planım var.", null, null),
                LearningExercise("jaa2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'休み' ne anlama gelir?", "", listOf("hafta sonu", "tatil/izin", "gelecek yıl"), listOf("tatil/izin"), "休みはもうすぐ始まります。 — Tatil yakında başlıyor.", null, null)), listOf(
                TargetVocabulary("jaa2u6w1", "週末", "hafta sonu", "ifade", "週末は休みます。", "Hafta sonu dinlenirim."),
                TargetVocabulary("jaa2u6w2", "計画", "plan", "ifade", "夏の計画があります。", "Yaz için bir planım var."),
                TargetVocabulary("jaa2u6w3", "休み", "tatil/izin", "ifade", "休みはもうすぐ始まります。", "Tatil yakında başlıyor."),
                TargetVocabulary("jaa2u6w4", "来年", "gelecek yıl", "ifade", "来年、日本へ行きます。", "Gelecek yıl Japonya'ya gideceğim."),
                TargetVocabulary("jaa2u6w5", "予定", "program/plan", "ifade", "明日の予定は何ですか。", "Yarınki programın ne?"))),
            LearningLesson("JA-A2-U6-L2", "Planlar ve Gelecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は休みます。", "", listOf("計画", "休み", "週末"), listOf("週末"), "Doğru cümle: 週末は休みます。 — Hafta sonu dinlenirim.", null, null),
                LearningExercise("jaa2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___、日本へ行きます。", "", listOf("週末", "来年", "予定"), listOf("来年"), "Doğru cümle: 来年、日本へ行きます。 — Gelecek yıl Japonya'ya gideceğim.", null, null),
                LearningExercise("jaa2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yarınki programın ne?", "Hafta sonu dinlenirim.", "Tatil yakında başlıyor."), listOf("Yarınki programın ne?"), "Söylenen cümle: 明日の予定は何ですか。", "明日の予定は何ですか。", null),
                LearningExercise("jaa2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "来年、日本へ行きます。", listOf("Yarınki programın ne?", "Gelecek yıl Japonya'ya gideceğim.", "Yaz için bir planım var."), listOf("Gelecek yıl Japonya'ya gideceğim."), "Cümlenin çevirisi: Gelecek yıl Japonya'ya gideceğim.", null, null))),
            LearningLesson("JA-A2-U6-L3", "Planlar ve Gelecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "来年、日本へ___つもりです。", "", listOf("行く", "行きます", "行って"), listOf("行く"), "Niyet kalıbı: 辞書形 + つもりです.", null, null),
                LearningExercise("jaa2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 夏の計画があります。", "", listOf(), listOf("夏の計画があります。"), "Türkçesi: Yaz için bir planım var.", "夏の計画があります。", "夏の計画があります。"),
                LearningExercise("jaa2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'tatil/izin' ifadesinin Japonca karşılığı hangisi?", "", listOf("週末", "予定", "休み"), listOf("休み"), "Örnek: 休みはもうすぐ始まります。 — Tatil yakında başlıyor.", null, null))),
            LearningLesson("JA-A2-U6-L4", "Planlar ve Gelecek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jaa2u6e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("週末は休みます。"), "Söylenen cümle: 週末は休みます。 — Hafta sonu dinlenirim.", "週末は休みます。", null),
                LearningExercise("jaa2u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yaz için bir planım var.", "Gelecek yıl Japonya'ya gideceğim.", "Yarınki programın ne?"), listOf("Yaz için bir planım var."), "Söylenen cümle: 夏の計画があります。", "夏の計画があります。", null),
                LearningExercise("jaa2u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gelecek yıl' ifadesinin Japonca karşılığı hangisi?", "", listOf("予定", "来年", "計画"), listOf("来年"), "Örnek: 来年、日本へ行きます。 — Gelecek yıl Japonya'ya gideceğim.", null, null))),
            LearningLesson("JA-A2-U6-L5", "Planlar ve Gelecek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jaa2u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "明日の予定は何ですか。", listOf("Yaz için bir planım var.", "Gelecek yıl Japonya'ya gideceğim.", "Yarınki programın ne?"), listOf("Yarınki programın ne?"), "Cümlenin çevirisi: Yarınki programın ne?", null, null),
                LearningExercise("jaa2u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "来年、日本へ行きます。", listOf("Yarınki programın ne?", "Gelecek yıl Japonya'ya gideceğim.", "Tatil yakında başlıyor."), listOf("Gelecek yıl Japonya'ya gideceğim."), "Cümlenin çevirisi: Gelecek yıl Japonya'ya gideceğim.", null, null),
                LearningExercise("jaa2u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 週末は休みます。", "", listOf(), listOf("週末は休みます。"), "Türkçesi: Hafta sonu dinlenirim.", "週末は休みます。", "週末は休みます。"))))),
        LearningUnit("JA-B1-U1", "Deneyimler ve Anılar", "Anılarını ayrıntılarıyla paylaş.", listOf(
            LearningLesson("JA-B1-U1-L1", "Deneyimler ve Anılar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'経験' ne anlama gelir?", "", listOf("hatırlıyor", "o dönemde", "deneyim"), listOf("deneyim"), "あの経験は私を変えました。 — O deneyim beni değiştirdi.", null, null),
                LearningExercise("jab1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'覚えています' ne anlama gelir?", "", listOf("anı", "hatırlıyor", "çocukluk dönemi"), listOf("hatırlıyor"), "子供のころを覚えています。 — Çocukluğumu hatırlıyorum.", null, null),
                LearningExercise("jab1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'子供のころ' ne anlama gelir?", "", listOf("çocukluk dönemi", "o dönemde", "deneyim"), listOf("çocukluk dönemi"), "子供のころは幸せでした。 — Çocuklukta mutluydum.", null, null)), listOf(
                TargetVocabulary("jab1u1w1", "経験", "deneyim", "ifade", "あの経験は私を変えました。", "O deneyim beni değiştirdi."),
                TargetVocabulary("jab1u1w2", "覚えています", "hatırlıyor", "ifade", "子供のころを覚えています。", "Çocukluğumu hatırlıyorum."),
                TargetVocabulary("jab1u1w3", "子供のころ", "çocukluk dönemi", "ifade", "子供のころは幸せでした。", "Çocuklukta mutluydum."),
                TargetVocabulary("jab1u1w4", "当時", "o dönemde", "ifade", "当時は田舎に住んでいました。", "O dönemde kırsalda yaşıyorduk."),
                TargetVocabulary("jab1u1w5", "思い出", "anı", "ifade", "この思い出は大切です。", "Bu anı çok değerli."))),
            LearningLesson("JA-B1-U1-L2", "Deneyimler ve Anılar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "あの___は私を変えました。", "", listOf("子供のころ", "経験", "覚えています"), listOf("経験"), "Doğru cümle: あの経験は私を変えました。 — O deneyim beni değiştirdi.", null, null),
                LearningExercise("jab1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は田舎に住んでいました。", "", listOf("当時", "思い出", "経験"), listOf("当時"), "Doğru cümle: 当時は田舎に住んでいました。 — O dönemde kırsalda yaşıyorduk.", null, null),
                LearningExercise("jab1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O deneyim beni değiştirdi.", "Çocuklukta mutluydum.", "Bu anı çok değerli."), listOf("Bu anı çok değerli."), "Söylenen cümle: この思い出は大切です。", "この思い出は大切です。", null),
                LearningExercise("jab1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "当時は田舎に住んでいました。", listOf("O dönemde kırsalda yaşıyorduk.", "Çocukluğumu hatırlıyorum.", "Bu anı çok değerli."), listOf("O dönemde kırsalda yaşıyorduk."), "Cümlenin çevirisi: O dönemde kırsalda yaşıyorduk.", null, null))),
            LearningLesson("JA-B1-U1-L3", "Deneyimler ve Anılar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "子供のころ、田舎に___いました。", "", listOf("住んで", "住み", "住む"), listOf("住んで"), "Süreklilik: 住んでいました.", null, null),
                LearningExercise("jab1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 子供のころを覚えています。", "", listOf(), listOf("子供のころを覚えています。"), "Türkçesi: Çocukluğumu hatırlıyorum.", "子供のころを覚えています。", "子供のころを覚えています。"),
                LearningExercise("jab1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'çocukluk dönemi' ifadesinin Japonca karşılığı hangisi?", "", listOf("思い出", "子供のころ", "経験"), listOf("子供のころ"), "Örnek: 子供のころは幸せでした。 — Çocuklukta mutluydum.", null, null))),
            LearningLesson("JA-B1-U1-L4", "Deneyimler ve Anılar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab1u1e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("あの経験は私を変えました。"), "Söylenen cümle: あの経験は私を変えました。 — O deneyim beni değiştirdi.", "あの経験は私を変えました。", null),
                LearningExercise("jab1u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O dönemde kırsalda yaşıyorduk.", "Bu anı çok değerli.", "Çocukluğumu hatırlıyorum."), listOf("Çocukluğumu hatırlıyorum."), "Söylenen cümle: 子供のころを覚えています。", "子供のころを覚えています。", null),
                LearningExercise("jab1u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'o dönemde' ifadesinin Japonca karşılığı hangisi?", "", listOf("当時", "覚えています", "思い出"), listOf("当時"), "Örnek: 当時は田舎に住んでいました。 — O dönemde kırsalda yaşıyorduk.", null, null))),
            LearningLesson("JA-B1-U1-L5", "Deneyimler ve Anılar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab1u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この思い出は大切です。", listOf("O dönemde kırsalda yaşıyorduk.", "Bu anı çok değerli.", "Çocukluğumu hatırlıyorum."), listOf("Bu anı çok değerli."), "Cümlenin çevirisi: Bu anı çok değerli.", null, null),
                LearningExercise("jab1u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "当時は田舎に住んでいました。", listOf("O dönemde kırsalda yaşıyorduk.", "Çocuklukta mutluydum.", "Bu anı çok değerli."), listOf("O dönemde kırsalda yaşıyorduk."), "Cümlenin çevirisi: O dönemde kırsalda yaşıyorduk.", null, null),
                LearningExercise("jab1u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: あの経験は私を変えました。", "", listOf(), listOf("あの経験は私を変えました。"), "Türkçesi: O deneyim beni değiştirdi.", "あの経験は私を変えました。", "あの経験は私を変えました。"))))),
        LearningUnit("JA-B1-U2", "Medya ve Teknoloji", "Teknoloji ve haberler hakkında konuş.", listOf(
            LearningLesson("JA-B1-U2-L1", "Medya ve Teknoloji — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'ニュース' ne anlama gelir?", "", listOf("bağlantı", "haberler", "cihaz"), listOf("haberler"), "夜にニュースを見ます。 — Akşamları haber izlerim.", null, null),
                LearningExercise("jab1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'端末' ne anlama gelir?", "", listOf("cihaz", "indirme", "ekran"), listOf("cihaz"), "この端末は新しいです。 — Bu cihaz yeni.", null, null),
                LearningExercise("jab1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'ダウンロード' ne anlama gelir?", "", listOf("bağlantı", "haberler", "indirme"), listOf("indirme"), "アプリをダウンロードしたいです。 — Uygulamayı indirmek istiyorum.", null, null)), listOf(
                TargetVocabulary("jab1u2w1", "ニュース", "haberler", "ifade", "夜にニュースを見ます。", "Akşamları haber izlerim."),
                TargetVocabulary("jab1u2w2", "端末", "cihaz", "ifade", "この端末は新しいです。", "Bu cihaz yeni."),
                TargetVocabulary("jab1u2w3", "ダウンロード", "indirme", "ifade", "アプリをダウンロードしたいです。", "Uygulamayı indirmek istiyorum."),
                TargetVocabulary("jab1u2w4", "接続", "bağlantı", "ifade", "接続が遅いです。", "Bağlantı yavaş."),
                TargetVocabulary("jab1u2w5", "画面", "ekran", "ifade", "画面が明るすぎます。", "Ekran fazla parlak."))),
            LearningLesson("JA-B1-U2-L2", "Medya ve Teknoloji — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "夜に___を見ます。", "", listOf("ニュース", "端末", "ダウンロード"), listOf("ニュース"), "Doğru cümle: 夜にニュースを見ます。 — Akşamları haber izlerim.", null, null),
                LearningExercise("jab1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___が遅いです。", "", listOf("画面", "ニュース", "接続"), listOf("接続"), "Doğru cümle: 接続が遅いです。 — Bağlantı yavaş.", null, null),
                LearningExercise("jab1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Uygulamayı indirmek istiyorum.", "Ekran fazla parlak.", "Akşamları haber izlerim."), listOf("Ekran fazla parlak."), "Söylenen cümle: 画面が明るすぎます。", "画面が明るすぎます。", null),
                LearningExercise("jab1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "接続が遅いです。", listOf("Bu cihaz yeni.", "Ekran fazla parlak.", "Bağlantı yavaş."), listOf("Bağlantı yavaş."), "Cümlenin çevirisi: Bağlantı yavaş.", null, null))),
            LearningLesson("JA-B1-U2-L3", "Medya ve Teknoloji — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "アプリをダウンロード___ことができます。", "", listOf("する", "します", "して"), listOf("する"), "Yeterlilik kalıbı: 辞書形 + ことができる.", null, null),
                LearningExercise("jab1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: この端末は新しいです。", "", listOf(), listOf("この端末は新しいです。"), "Türkçesi: Bu cihaz yeni.", "この端末は新しいです。", "この端末は新しいです。"),
                LearningExercise("jab1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'indirme' ifadesinin Japonca karşılığı hangisi?", "", listOf("ダウンロード", "ニュース", "画面"), listOf("ダウンロード"), "Örnek: アプリをダウンロードしたいです。 — Uygulamayı indirmek istiyorum.", null, null))),
            LearningLesson("JA-B1-U2-L4", "Medya ve Teknoloji — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab1u2e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("夜にニュースを見ます。"), "Söylenen cümle: 夜にニュースを見ます。 — Akşamları haber izlerim.", "夜にニュースを見ます。", null),
                LearningExercise("jab1u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekran fazla parlak.", "Bu cihaz yeni.", "Bağlantı yavaş."), listOf("Bu cihaz yeni."), "Söylenen cümle: この端末は新しいです。", "この端末は新しいです。", null),
                LearningExercise("jab1u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bağlantı' ifadesinin Japonca karşılığı hangisi?", "", listOf("端末", "画面", "接続"), listOf("接続"), "Örnek: 接続が遅いです。 — Bağlantı yavaş.", null, null))),
            LearningLesson("JA-B1-U2-L5", "Medya ve Teknoloji — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab1u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "画面が明るすぎます。", listOf("Ekran fazla parlak.", "Bu cihaz yeni.", "Bağlantı yavaş."), listOf("Ekran fazla parlak."), "Cümlenin çevirisi: Ekran fazla parlak.", null, null),
                LearningExercise("jab1u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "接続が遅いです。", listOf("Uygulamayı indirmek istiyorum.", "Ekran fazla parlak.", "Bağlantı yavaş."), listOf("Bağlantı yavaş."), "Cümlenin çevirisi: Bağlantı yavaş.", null, null),
                LearningExercise("jab1u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 夜にニュースを見ます。", "", listOf(), listOf("夜にニュースを見ます。"), "Türkçesi: Akşamları haber izlerim.", "夜にニュースを見ます。", "夜にニュースを見ます。"))))),
        LearningUnit("JA-B1-U3", "Duygular ve İlişkiler", "Duygularını ve ilişkilerini anlat.", listOf(
            LearningLesson("JA-B1-U3-L1", "Duygular ve İlişkiler — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'友情' ne anlama gelir?", "", listOf("arkadaşlık", "güven", "kavga"), listOf("arkadaşlık"), "私たちの友情は強いです。 — Arkadaşlığımız güçlü.", null, null),
                LearningExercise("jab1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'信頼' ne anlama gelir?", "", listOf("hayal kırıklığı", "duygu/his", "güven"), listOf("güven"), "信頼には時間がかかります。 — Güven zaman alır.", null, null),
                LearningExercise("jab1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'がっかり' ne anlama gelir?", "", listOf("arkadaşlık", "hayal kırıklığı", "kavga"), listOf("hayal kırıklığı"), "結果にがっかりしました。 — Sonuçtan hayal kırıklığına uğradım.", null, null)), listOf(
                TargetVocabulary("jab1u3w1", "友情", "arkadaşlık", "ifade", "私たちの友情は強いです。", "Arkadaşlığımız güçlü."),
                TargetVocabulary("jab1u3w2", "信頼", "güven", "ifade", "信頼には時間がかかります。", "Güven zaman alır."),
                TargetVocabulary("jab1u3w3", "がっかり", "hayal kırıklığı", "ifade", "結果にがっかりしました。", "Sonuçtan hayal kırıklığına uğradım."),
                TargetVocabulary("jab1u3w4", "けんか", "kavga", "ifade", "私たちはあまりけんかしません。", "Pek kavga etmeyiz."),
                TargetVocabulary("jab1u3w5", "気持ち", "duygu/his", "ifade", "不思議な気持ちです。", "Tuhaf bir his."))),
            LearningLesson("JA-B1-U3-L2", "Duygular ve İlişkiler — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "私たちの___は強いです。", "", listOf("信頼", "がっかり", "友情"), listOf("友情"), "Doğru cümle: 私たちの友情は強いです。 — Arkadaşlığımız güçlü.", null, null),
                LearningExercise("jab1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "私たちはあまり___しません。", "", listOf("友情", "けんか", "気持ち"), listOf("けんか"), "Doğru cümle: 私たちはあまりけんかしません。 — Pek kavga etmeyiz.", null, null),
                LearningExercise("jab1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Tuhaf bir his.", "Arkadaşlığımız güçlü.", "Sonuçtan hayal kırıklığına uğradım."), listOf("Tuhaf bir his."), "Söylenen cümle: 不思議な気持ちです。", "不思議な気持ちです。", null),
                LearningExercise("jab1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "私たちはあまりけんかしません。", listOf("Tuhaf bir his.", "Pek kavga etmeyiz.", "Güven zaman alır."), listOf("Pek kavga etmeyiz."), "Cümlenin çevirisi: Pek kavga etmeyiz.", null, null))),
            LearningLesson("JA-B1-U3-L3", "Duygular ve İlişkiler — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "結果___がっかりしました。", "", listOf("に", "を", "で"), listOf("に"), "Edat: ...にがっかりする.", null, null),
                LearningExercise("jab1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 信頼には時間がかかります。", "", listOf(), listOf("信頼には時間がかかります。"), "Türkçesi: Güven zaman alır.", "信頼には時間がかかります。", "信頼には時間がかかります。"),
                LearningExercise("jab1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'hayal kırıklığı' ifadesinin Japonca karşılığı hangisi?", "", listOf("友情", "気持ち", "がっかり"), listOf("がっかり"), "Örnek: 結果にがっかりしました。 — Sonuçtan hayal kırıklığına uğradım.", null, null))),
            LearningLesson("JA-B1-U3-L4", "Duygular ve İlişkiler — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab1u3e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("私たちの友情は強いです。"), "Söylenen cümle: 私たちの友情は強いです。 — Arkadaşlığımız güçlü.", "私たちの友情は強いです。", null),
                LearningExercise("jab1u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Güven zaman alır.", "Pek kavga etmeyiz.", "Tuhaf bir his."), listOf("Güven zaman alır."), "Söylenen cümle: 信頼には時間がかかります。", "信頼には時間がかかります。", null),
                LearningExercise("jab1u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kavga' ifadesinin Japonca karşılığı hangisi?", "", listOf("気持ち", "けんか", "信頼"), listOf("けんか"), "Örnek: 私たちはあまりけんかしません。 — Pek kavga etmeyiz.", null, null))),
            LearningLesson("JA-B1-U3-L5", "Duygular ve İlişkiler — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab1u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "不思議な気持ちです。", listOf("Güven zaman alır.", "Pek kavga etmeyiz.", "Tuhaf bir his."), listOf("Tuhaf bir his."), "Cümlenin çevirisi: Tuhaf bir his.", null, null),
                LearningExercise("jab1u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "私たちはあまりけんかしません。", listOf("Tuhaf bir his.", "Pek kavga etmeyiz.", "Sonuçtan hayal kırıklığına uğradım."), listOf("Pek kavga etmeyiz."), "Cümlenin çevirisi: Pek kavga etmeyiz.", null, null),
                LearningExercise("jab1u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 私たちの友情は強いです。", "", listOf(), listOf("私たちの友情は強いです。"), "Türkçesi: Arkadaşlığımız güçlü.", "私たちの友情は強いです。", "私たちの友情は強いです。"))))),
        LearningUnit("JA-B1-U4", "Kültür ve Gelenekler", "Gelenekleri ve kültürü tanıt.", listOf(
            LearningLesson("JA-B1-U4-L1", "Kültür ve Gelenekler — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'習慣' ne anlama gelir?", "", listOf("festival/bayram", "gelenek", "âdet/alışkanlık"), listOf("âdet/alışkanlık"), "この習慣はとても古いです。 — Bu âdet çok eski.", null, null),
                LearningExercise("jab1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'祭り' ne anlama gelir?", "", listOf("toplum", "festival/bayram", "kutlamak"), listOf("festival/bayram"), "祭りは三日間続きます。 — Festival üç gün sürüyor.", null, null),
                LearningExercise("jab1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'祝います' ne anlama gelir?", "", listOf("kutlamak", "gelenek", "âdet/alışkanlık"), listOf("kutlamak"), "一緒に祝います。 — Birlikte kutluyoruz.", null, null)), listOf(
                TargetVocabulary("jab1u4w1", "習慣", "âdet/alışkanlık", "ifade", "この習慣はとても古いです。", "Bu âdet çok eski."),
                TargetVocabulary("jab1u4w2", "祭り", "festival/bayram", "ifade", "祭りは三日間続きます。", "Festival üç gün sürüyor."),
                TargetVocabulary("jab1u4w3", "祝います", "kutlamak", "ifade", "一緒に祝います。", "Birlikte kutluyoruz."),
                TargetVocabulary("jab1u4w4", "伝統", "gelenek", "ifade", "伝統は続いています。", "Gelenek sürüyor."),
                TargetVocabulary("jab1u4w5", "社会", "toplum", "ifade", "社会は速く変わります。", "Toplum hızla değişiyor."))),
            LearningLesson("JA-B1-U4-L2", "Kültür ve Gelenekler — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "この___はとても古いです。", "", listOf("祝います", "習慣", "祭り"), listOf("習慣"), "Doğru cümle: この習慣はとても古いです。 — Bu âdet çok eski.", null, null),
                LearningExercise("jab1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は続いています。", "", listOf("伝統", "社会", "習慣"), listOf("伝統"), "Doğru cümle: 伝統は続いています。 — Gelenek sürüyor.", null, null),
                LearningExercise("jab1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu âdet çok eski.", "Birlikte kutluyoruz.", "Toplum hızla değişiyor."), listOf("Toplum hızla değişiyor."), "Söylenen cümle: 社会は速く変わります。", "社会は速く変わります。", null),
                LearningExercise("jab1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "伝統は続いています。", listOf("Gelenek sürüyor.", "Festival üç gün sürüyor.", "Toplum hızla değişiyor."), listOf("Gelenek sürüyor."), "Cümlenin çevirisi: Gelenek sürüyor.", null, null))),
            LearningLesson("JA-B1-U4-L3", "Kültür ve Gelenekler — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "この祭りは五月に___。", "", listOf("行われます", "行います", "行きます"), listOf("行われます"), "Edilgen: 行われます (düzenlenir).", null, null),
                LearningExercise("jab1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 祭りは三日間続きます。", "", listOf(), listOf("祭りは三日間続きます。"), "Türkçesi: Festival üç gün sürüyor.", "祭りは三日間続きます。", "祭りは三日間続きます。"),
                LearningExercise("jab1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kutlamak' ifadesinin Japonca karşılığı hangisi?", "", listOf("社会", "祝います", "習慣"), listOf("祝います"), "Örnek: 一緒に祝います。 — Birlikte kutluyoruz.", null, null))),
            LearningLesson("JA-B1-U4-L4", "Kültür ve Gelenekler — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab1u4e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("この習慣はとても古いです。"), "Söylenen cümle: この習慣はとても古いです。 — Bu âdet çok eski.", "この習慣はとても古いです。", null),
                LearningExercise("jab1u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Gelenek sürüyor.", "Toplum hızla değişiyor.", "Festival üç gün sürüyor."), listOf("Festival üç gün sürüyor."), "Söylenen cümle: 祭りは三日間続きます。", "祭りは三日間続きます。", null),
                LearningExercise("jab1u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gelenek' ifadesinin Japonca karşılığı hangisi?", "", listOf("伝統", "祭り", "社会"), listOf("伝統"), "Örnek: 伝統は続いています。 — Gelenek sürüyor.", null, null))),
            LearningLesson("JA-B1-U4-L5", "Kültür ve Gelenekler — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab1u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "社会は速く変わります。", listOf("Gelenek sürüyor.", "Toplum hızla değişiyor.", "Festival üç gün sürüyor."), listOf("Toplum hızla değişiyor."), "Cümlenin çevirisi: Toplum hızla değişiyor.", null, null),
                LearningExercise("jab1u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "伝統は続いています。", listOf("Gelenek sürüyor.", "Birlikte kutluyoruz.", "Toplum hızla değişiyor."), listOf("Gelenek sürüyor."), "Cümlenin çevirisi: Gelenek sürüyor.", null, null),
                LearningExercise("jab1u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: この習慣はとても古いです。", "", listOf(), listOf("この習慣はとても古いです。"), "Türkçesi: Bu âdet çok eski.", "この習慣はとても古いです。", "この習慣はとても古いです。"))))),
        LearningUnit("JA-B1-U5", "Spor ve Sağlıklı Yaşam", "Sağlıklı yaşam alışkanlıklarını anlat.", listOf(
            LearningLesson("JA-B1-U5-L1", "Spor ve Sağlıklı Yaşam — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'健康' ne anlama gelir?", "", listOf("antrenman", "sağlık", "spor/hareket"), listOf("sağlık"), "健康が一番大切です。 — Sağlık en önemlisidir.", null, null),
                LearningExercise("jab1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'運動' ne anlama gelir?", "", listOf("spor/hareket", "yemek/beslenme", "kaçınmak"), listOf("spor/hareket"), "毎日運動するべきです。 — Her gün hareket etmeli.", null, null),
                LearningExercise("jab1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'食事' ne anlama gelir?", "", listOf("antrenman", "sağlık", "yemek/beslenme"), listOf("yemek/beslenme"), "バランスのいい食事が大事です。 — Dengeli beslenme önemli.", null, null)), listOf(
                TargetVocabulary("jab1u5w1", "健康", "sağlık", "ifade", "健康が一番大切です。", "Sağlık en önemlisidir."),
                TargetVocabulary("jab1u5w2", "運動", "spor/hareket", "ifade", "毎日運動するべきです。", "Her gün hareket etmeli."),
                TargetVocabulary("jab1u5w3", "食事", "yemek/beslenme", "ifade", "バランスのいい食事が大事です。", "Dengeli beslenme önemli."),
                TargetVocabulary("jab1u5w4", "トレーニング", "antrenman", "ifade", "週に三回トレーニングします。", "Haftada üç kez antrenman yaparım."),
                TargetVocabulary("jab1u5w5", "避けます", "kaçınmak", "ifade", "砂糖を避けます。", "Şekerden kaçınırım."))),
            LearningLesson("JA-B1-U5-L2", "Spor ve Sağlıklı Yaşam — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___が一番大切です。", "", listOf("健康", "運動", "食事"), listOf("健康"), "Doğru cümle: 健康が一番大切です。 — Sağlık en önemlisidir.", null, null),
                LearningExercise("jab1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "週に三回___します。", "", listOf("避けます", "健康", "トレーニング"), listOf("トレーニング"), "Doğru cümle: 週に三回トレーニングします。 — Haftada üç kez antrenman yaparım.", null, null),
                LearningExercise("jab1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dengeli beslenme önemli.", "Şekerden kaçınırım.", "Sağlık en önemlisidir."), listOf("Şekerden kaçınırım."), "Söylenen cümle: 砂糖を避けます。", "砂糖を避けます。", null),
                LearningExercise("jab1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "週に三回トレーニングします。", listOf("Her gün hareket etmeli.", "Şekerden kaçınırım.", "Haftada üç kez antrenman yaparım."), listOf("Haftada üç kez antrenman yaparım."), "Cümlenin çevirisi: Haftada üç kez antrenman yaparım.", null, null))),
            LearningLesson("JA-B1-U5-L3", "Spor ve Sağlıklı Yaşam — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "砂糖を___ほうがいいです。", "", listOf("避けた", "避ける", "避けて"), listOf("避けた"), "Tavsiye kalıbı: た形 + ほうがいい.", null, null),
                LearningExercise("jab1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 毎日運動するべきです。", "", listOf(), listOf("毎日運動するべきです。"), "Türkçesi: Her gün hareket etmeli.", "毎日運動するべきです。", "毎日運動するべきです。"),
                LearningExercise("jab1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'yemek/beslenme' ifadesinin Japonca karşılığı hangisi?", "", listOf("食事", "健康", "避けます"), listOf("食事"), "Örnek: バランスのいい食事が大事です。 — Dengeli beslenme önemli.", null, null))),
            LearningLesson("JA-B1-U5-L4", "Spor ve Sağlıklı Yaşam — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab1u5e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("健康が一番大切です。"), "Söylenen cümle: 健康が一番大切です。 — Sağlık en önemlisidir.", "健康が一番大切です。", null),
                LearningExercise("jab1u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şekerden kaçınırım.", "Her gün hareket etmeli.", "Haftada üç kez antrenman yaparım."), listOf("Her gün hareket etmeli."), "Söylenen cümle: 毎日運動するべきです。", "毎日運動するべきです。", null),
                LearningExercise("jab1u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'antrenman' ifadesinin Japonca karşılığı hangisi?", "", listOf("運動", "避けます", "トレーニング"), listOf("トレーニング"), "Örnek: 週に三回トレーニングします。 — Haftada üç kez antrenman yaparım.", null, null))),
            LearningLesson("JA-B1-U5-L5", "Spor ve Sağlıklı Yaşam — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab1u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "砂糖を避けます。", listOf("Şekerden kaçınırım.", "Her gün hareket etmeli.", "Haftada üç kez antrenman yaparım."), listOf("Şekerden kaçınırım."), "Cümlenin çevirisi: Şekerden kaçınırım.", null, null),
                LearningExercise("jab1u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "週に三回トレーニングします。", listOf("Dengeli beslenme önemli.", "Şekerden kaçınırım.", "Haftada üç kez antrenman yaparım."), listOf("Haftada üç kez antrenman yaparım."), "Cümlenin çevirisi: Haftada üç kez antrenman yaparım.", null, null),
                LearningExercise("jab1u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 健康が一番大切です。", "", listOf(), listOf("健康が一番大切です。"), "Türkçesi: Sağlık en önemlisidir.", "健康が一番大切です。", "健康が一番大切です。"))))),
        LearningUnit("JA-B1-U6", "Görüş Bildirmek", "Fikrini gerekçeleriyle savun.", listOf(
            LearningLesson("JA-B1-U6-L1", "Görüş Bildirmek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'意見' ne anlama gelir?", "", listOf("görüş", "katılma (fikre)", "sebep"), listOf("görüş"), "これは私の意見です。 — Bu benim görüşüm.", null, null),
                LearningExercise("jab1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'賛成' ne anlama gelir?", "", listOf("karşı çıkma", "ikna olma", "katılma (fikre)"), listOf("katılma (fikre)"), "私は賛成です。 — Ben katılıyorum.", null, null),
                LearningExercise("jab1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'反対' ne anlama gelir?", "", listOf("görüş", "karşı çıkma", "sebep"), listOf("karşı çıkma"), "その案に反対です。 — O öneriye karşıyım.", null, null)), listOf(
                TargetVocabulary("jab1u6w1", "意見", "görüş", "ifade", "これは私の意見です。", "Bu benim görüşüm."),
                TargetVocabulary("jab1u6w2", "賛成", "katılma (fikre)", "ifade", "私は賛成です。", "Ben katılıyorum."),
                TargetVocabulary("jab1u6w3", "反対", "karşı çıkma", "ifade", "その案に反対です。", "O öneriye karşıyım."),
                TargetVocabulary("jab1u6w4", "理由", "sebep", "ifade", "いい理由があります。", "İyi bir sebep var."),
                TargetVocabulary("jab1u6w5", "納得", "ikna olma", "ifade", "まだ納得できません。", "Henüz ikna olamadım."))),
            LearningLesson("JA-B1-U6-L2", "Görüş Bildirmek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "これは私の___です。", "", listOf("賛成", "反対", "意見"), listOf("意見"), "Doğru cümle: これは私の意見です。 — Bu benim görüşüm.", null, null),
                LearningExercise("jab1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "いい___があります。", "", listOf("意見", "理由", "納得"), listOf("理由"), "Doğru cümle: いい理由があります。 — İyi bir sebep var.", null, null),
                LearningExercise("jab1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Henüz ikna olamadım.", "Bu benim görüşüm.", "O öneriye karşıyım."), listOf("Henüz ikna olamadım."), "Söylenen cümle: まだ納得できません。", "まだ納得できません。", null),
                LearningExercise("jab1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "いい理由があります。", listOf("Henüz ikna olamadım.", "İyi bir sebep var.", "Ben katılıyorum."), listOf("İyi bir sebep var."), "Cümlenin çevirisi: İyi bir sebep var.", null, null))),
            LearningLesson("JA-B1-U6-L3", "Görüş Bildirmek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "私は彼の意見に___です。", "", listOf("賛成", "反対して", "理由"), listOf("賛成"), "Kalıp: ...に賛成です (fikre katılmak).", null, null),
                LearningExercise("jab1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 私は賛成です。", "", listOf(), listOf("私は賛成です。"), "Türkçesi: Ben katılıyorum.", "私は賛成です。", "私は賛成です。"),
                LearningExercise("jab1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'karşı çıkma' ifadesinin Japonca karşılığı hangisi?", "", listOf("意見", "納得", "反対"), listOf("反対"), "Örnek: その案に反対です。 — O öneriye karşıyım.", null, null))),
            LearningLesson("JA-B1-U6-L4", "Görüş Bildirmek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab1u6e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("これは私の意見です。"), "Söylenen cümle: これは私の意見です。 — Bu benim görüşüm.", "これは私の意見です。", null),
                LearningExercise("jab1u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ben katılıyorum.", "İyi bir sebep var.", "Henüz ikna olamadım."), listOf("Ben katılıyorum."), "Söylenen cümle: 私は賛成です。", "私は賛成です。", null),
                LearningExercise("jab1u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sebep' ifadesinin Japonca karşılığı hangisi?", "", listOf("納得", "理由", "賛成"), listOf("理由"), "Örnek: いい理由があります。 — İyi bir sebep var.", null, null))),
            LearningLesson("JA-B1-U6-L5", "Görüş Bildirmek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab1u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "まだ納得できません。", listOf("Ben katılıyorum.", "İyi bir sebep var.", "Henüz ikna olamadım."), listOf("Henüz ikna olamadım."), "Cümlenin çevirisi: Henüz ikna olamadım.", null, null),
                LearningExercise("jab1u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "いい理由があります。", listOf("Henüz ikna olamadım.", "İyi bir sebep var.", "O öneriye karşıyım."), listOf("İyi bir sebep var."), "Cümlenin çevirisi: İyi bir sebep var.", null, null),
                LearningExercise("jab1u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: これは私の意見です。", "", listOf(), listOf("これは私の意見です。"), "Türkçesi: Bu benim görüşüm.", "これは私の意見です。", "これは私の意見です。"))))),
        LearningUnit("JA-B2-U1", "Kariyer ve İş Dünyası", "İş görüşmesi ve kariyer dilinde ustalaş.", listOf(
            LearningLesson("JA-B2-U1-L1", "Kariyer ve İş Dünyası — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'履歴書' ne anlama gelir?", "", listOf("mülakat", "sorumluluk", "özgeçmiş"), listOf("özgeçmiş"), "履歴書は短くまとめます。 — Özgeçmişi kısa tutarım.", null, null),
                LearningExercise("jab2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'面接' ne anlama gelir?", "", listOf("kariyer", "mülakat", "işe alım"), listOf("mülakat"), "面接はうまくいきました。 — Mülakat iyi geçti.", null, null),
                LearningExercise("jab2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'採用' ne anlama gelir?", "", listOf("işe alım", "sorumluluk", "özgeçmiş"), listOf("işe alım"), "彼女は会社に採用されました。 — Şirkete işe alındı.", null, null)), listOf(
                TargetVocabulary("jab2u1w1", "履歴書", "özgeçmiş", "ifade", "履歴書は短くまとめます。", "Özgeçmişi kısa tutarım."),
                TargetVocabulary("jab2u1w2", "面接", "mülakat", "ifade", "面接はうまくいきました。", "Mülakat iyi geçti."),
                TargetVocabulary("jab2u1w3", "採用", "işe alım", "ifade", "彼女は会社に採用されました。", "Şirkete işe alındı."),
                TargetVocabulary("jab2u1w4", "責任", "sorumluluk", "ifade", "責任を引き受けます。", "Sorumluluğu üstleniyorum."),
                TargetVocabulary("jab2u1w5", "キャリア", "kariyer", "ifade", "彼女のキャリアは順調です。", "Kariyeri yolunda gidiyor."))),
            LearningLesson("JA-B2-U1-L2", "Kariyer ve İş Dünyası — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は短くまとめます。", "", listOf("採用", "履歴書", "面接"), listOf("履歴書"), "Doğru cümle: 履歴書は短くまとめます。 — Özgeçmişi kısa tutarım.", null, null),
                LearningExercise("jab2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___を引き受けます。", "", listOf("責任", "キャリア", "履歴書"), listOf("責任"), "Doğru cümle: 責任を引き受けます。 — Sorumluluğu üstleniyorum.", null, null),
                LearningExercise("jab2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Özgeçmişi kısa tutarım.", "Şirkete işe alındı.", "Kariyeri yolunda gidiyor."), listOf("Kariyeri yolunda gidiyor."), "Söylenen cümle: 彼女のキャリアは順調です。", "彼女のキャリアは順調です。", null),
                LearningExercise("jab2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "責任を引き受けます。", listOf("Sorumluluğu üstleniyorum.", "Mülakat iyi geçti.", "Kariyeri yolunda gidiyor."), listOf("Sorumluluğu üstleniyorum."), "Cümlenin çevirisi: Sorumluluğu üstleniyorum.", null, null))),
            LearningLesson("JA-B2-U1-L3", "Kariyer ve İş Dünyası — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "彼女は会社に___されました。", "", listOf("採用", "面接", "履歴"), listOf("採用"), "Edilgen: 採用されました (işe alındı).", null, null),
                LearningExercise("jab2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 面接はうまくいきました。", "", listOf(), listOf("面接はうまくいきました。"), "Türkçesi: Mülakat iyi geçti.", "面接はうまくいきました。", "面接はうまくいきました。"),
                LearningExercise("jab2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'işe alım' ifadesinin Japonca karşılığı hangisi?", "", listOf("キャリア", "採用", "履歴書"), listOf("採用"), "Örnek: 彼女は会社に採用されました。 — Şirkete işe alındı.", null, null))),
            LearningLesson("JA-B2-U1-L4", "Kariyer ve İş Dünyası — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab2u1e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("履歴書は短くまとめます。"), "Söylenen cümle: 履歴書は短くまとめます。 — Özgeçmişi kısa tutarım.", "履歴書は短くまとめます。", null),
                LearningExercise("jab2u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sorumluluğu üstleniyorum.", "Kariyeri yolunda gidiyor.", "Mülakat iyi geçti."), listOf("Mülakat iyi geçti."), "Söylenen cümle: 面接はうまくいきました。", "面接はうまくいきました。", null),
                LearningExercise("jab2u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sorumluluk' ifadesinin Japonca karşılığı hangisi?", "", listOf("責任", "面接", "キャリア"), listOf("責任"), "Örnek: 責任を引き受けます。 — Sorumluluğu üstleniyorum.", null, null))),
            LearningLesson("JA-B2-U1-L5", "Kariyer ve İş Dünyası — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab2u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼女のキャリアは順調です。", listOf("Sorumluluğu üstleniyorum.", "Kariyeri yolunda gidiyor.", "Mülakat iyi geçti."), listOf("Kariyeri yolunda gidiyor."), "Cümlenin çevirisi: Kariyeri yolunda gidiyor.", null, null),
                LearningExercise("jab2u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "責任を引き受けます。", listOf("Sorumluluğu üstleniyorum.", "Şirkete işe alındı.", "Kariyeri yolunda gidiyor."), listOf("Sorumluluğu üstleniyorum."), "Cümlenin çevirisi: Sorumluluğu üstleniyorum.", null, null),
                LearningExercise("jab2u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 履歴書は短くまとめます。", "", listOf(), listOf("履歴書は短くまとめます。"), "Türkçesi: Özgeçmişi kısa tutarım.", "履歴書は短くまとめます。", "履歴書は短くまとめます。"))))),
        LearningUnit("JA-B2-U2", "Çevre ve Sürdürülebilirlik", "Çevre sorunlarını tartış.", listOf(
            LearningLesson("JA-B2-U2-L1", "Çevre ve Sürdürülebilirlik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'環境' ne anlama gelir?", "", listOf("çöp", "çevre", "iklim değişikliği"), listOf("çevre"), "環境を守らなければなりません。 — Çevreyi korumalıyız.", null, null),
                LearningExercise("jab2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'気候変動' ne anlama gelir?", "", listOf("iklim değişikliği", "sürdürülebilir", "yenilenebilir"), listOf("iklim değişikliği"), "気候変動はみんなに影響します。 — İklim değişikliği herkesi etkiliyor.", null, null),
                LearningExercise("jab2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'持続可能' ne anlama gelir?", "", listOf("çöp", "çevre", "sürdürülebilir"), listOf("sürdürülebilir"), "持続可能な解決策が必要です。 — Sürdürülebilir çözümler gerekli.", null, null)), listOf(
                TargetVocabulary("jab2u2w1", "環境", "çevre", "ifade", "環境を守らなければなりません。", "Çevreyi korumalıyız."),
                TargetVocabulary("jab2u2w2", "気候変動", "iklim değişikliği", "ifade", "気候変動はみんなに影響します。", "İklim değişikliği herkesi etkiliyor."),
                TargetVocabulary("jab2u2w3", "持続可能", "sürdürülebilir", "ifade", "持続可能な解決策が必要です。", "Sürdürülebilir çözümler gerekli."),
                TargetVocabulary("jab2u2w4", "ごみ", "çöp", "ifade", "ごみは分別します。", "Çöp ayrıştırılır."),
                TargetVocabulary("jab2u2w5", "再生可能", "yenilenebilir", "ifade", "再生可能エネルギーは未来です。", "Yenilenebilir enerji gelecektir."))),
            LearningLesson("JA-B2-U2-L2", "Çevre ve Sürdürülebilirlik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___を守らなければなりません。", "", listOf("環境", "気候変動", "持続可能"), listOf("環境"), "Doğru cümle: 環境を守らなければなりません。 — Çevreyi korumalıyız.", null, null),
                LearningExercise("jab2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は分別します。", "", listOf("再生可能", "環境", "ごみ"), listOf("ごみ"), "Doğru cümle: ごみは分別します。 — Çöp ayrıştırılır.", null, null),
                LearningExercise("jab2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sürdürülebilir çözümler gerekli.", "Yenilenebilir enerji gelecektir.", "Çevreyi korumalıyız."), listOf("Yenilenebilir enerji gelecektir."), "Söylenen cümle: 再生可能エネルギーは未来です。", "再生可能エネルギーは未来です。", null),
                LearningExercise("jab2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "ごみは分別します。", listOf("İklim değişikliği herkesi etkiliyor.", "Yenilenebilir enerji gelecektir.", "Çöp ayrıştırılır."), listOf("Çöp ayrıştırılır."), "Cümlenin çevirisi: Çöp ayrıştırılır.", null, null))),
            LearningLesson("JA-B2-U2-L3", "Çevre ve Sürdürülebilirlik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "ごみが少ない___、環境にいいです。", "", listOf("ほど", "だけ", "ばかり"), listOf("ほど"), "Karşılaştırma: ...ほど...(ne kadar az, o kadar iyi).", null, null),
                LearningExercise("jab2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 気候変動はみんなに影響します。", "", listOf(), listOf("気候変動はみんなに影響します。"), "Türkçesi: İklim değişikliği herkesi etkiliyor.", "気候変動はみんなに影響します。", "気候変動はみんなに影響します。"),
                LearningExercise("jab2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sürdürülebilir' ifadesinin Japonca karşılığı hangisi?", "", listOf("持続可能", "環境", "再生可能"), listOf("持続可能"), "Örnek: 持続可能な解決策が必要です。 — Sürdürülebilir çözümler gerekli.", null, null))),
            LearningLesson("JA-B2-U2-L4", "Çevre ve Sürdürülebilirlik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab2u2e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("環境を守らなければなりません。"), "Söylenen cümle: 環境を守らなければなりません。 — Çevreyi korumalıyız.", "環境を守らなければなりません。", null),
                LearningExercise("jab2u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yenilenebilir enerji gelecektir.", "İklim değişikliği herkesi etkiliyor.", "Çöp ayrıştırılır."), listOf("İklim değişikliği herkesi etkiliyor."), "Söylenen cümle: 気候変動はみんなに影響します。", "気候変動はみんなに影響します。", null),
                LearningExercise("jab2u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'çöp' ifadesinin Japonca karşılığı hangisi?", "", listOf("気候変動", "再生可能", "ごみ"), listOf("ごみ"), "Örnek: ごみは分別します。 — Çöp ayrıştırılır.", null, null))),
            LearningLesson("JA-B2-U2-L5", "Çevre ve Sürdürülebilirlik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab2u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "再生可能エネルギーは未来です。", listOf("Yenilenebilir enerji gelecektir.", "İklim değişikliği herkesi etkiliyor.", "Çöp ayrıştırılır."), listOf("Yenilenebilir enerji gelecektir."), "Cümlenin çevirisi: Yenilenebilir enerji gelecektir.", null, null),
                LearningExercise("jab2u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "ごみは分別します。", listOf("Sürdürülebilir çözümler gerekli.", "Yenilenebilir enerji gelecektir.", "Çöp ayrıştırılır."), listOf("Çöp ayrıştırılır."), "Cümlenin çevirisi: Çöp ayrıştırılır.", null, null),
                LearningExercise("jab2u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 環境を守らなければなりません。", "", listOf(), listOf("環境を守らなければなりません。"), "Türkçesi: Çevreyi korumalıyız.", "環境を守らなければなりません。", "環境を守らなければなりません。"))))),
        LearningUnit("JA-B2-U3", "Bilim ve Yenilik", "Bilimsel gelişmeleri aktar.", listOf(
            LearningLesson("JA-B2-U3-L1", "Bilim ve Yenilik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'研究' ne anlama gelir?", "", listOf("araştırma", "keşif", "kanıtlama"), listOf("araştırma"), "研究は続いています。 — Araştırma sürüyor.", null, null),
                LearningExercise("jab2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'発見' ne anlama gelir?", "", listOf("ilerleme", "sonuç", "keşif"), listOf("keşif"), "重要な発見でした。 — Önemli bir keşifti.", null, null),
                LearningExercise("jab2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'進歩' ne anlama gelir?", "", listOf("araştırma", "ilerleme", "kanıtlama"), listOf("ilerleme"), "進歩は明らかです。 — İlerleme ortada.", null, null)), listOf(
                TargetVocabulary("jab2u3w1", "研究", "araştırma", "ifade", "研究は続いています。", "Araştırma sürüyor."),
                TargetVocabulary("jab2u3w2", "発見", "keşif", "ifade", "重要な発見でした。", "Önemli bir keşifti."),
                TargetVocabulary("jab2u3w3", "進歩", "ilerleme", "ifade", "進歩は明らかです。", "İlerleme ortada."),
                TargetVocabulary("jab2u3w4", "証明", "kanıtlama", "ifade", "理論が証明されました。", "Teori kanıtlandı."),
                TargetVocabulary("jab2u3w5", "結果", "sonuç", "ifade", "結果に驚きました。", "Sonuca şaşırdık."))),
            LearningLesson("JA-B2-U3-L2", "Bilim ve Yenilik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は続いています。", "", listOf("発見", "進歩", "研究"), listOf("研究"), "Doğru cümle: 研究は続いています。 — Araştırma sürüyor.", null, null),
                LearningExercise("jab2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "理論が___されました。", "", listOf("研究", "証明", "結果"), listOf("証明"), "Doğru cümle: 理論が証明されました。 — Teori kanıtlandı.", null, null),
                LearningExercise("jab2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sonuca şaşırdık.", "Araştırma sürüyor.", "İlerleme ortada."), listOf("Sonuca şaşırdık."), "Söylenen cümle: 結果に驚きました。", "結果に驚きました。", null),
                LearningExercise("jab2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "理論が証明されました。", listOf("Sonuca şaşırdık.", "Teori kanıtlandı.", "Önemli bir keşifti."), listOf("Teori kanıtlandı."), "Cümlenin çevirisi: Teori kanıtlandı.", null, null))),
            LearningLesson("JA-B2-U3-L3", "Bilim ve Yenilik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "理論が___されました。", "", listOf("証明", "研究", "発見して"), listOf("証明"), "Edilgen: 証明されました (kanıtlandı).", null, null),
                LearningExercise("jab2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 重要な発見でした。", "", listOf(), listOf("重要な発見でした。"), "Türkçesi: Önemli bir keşifti.", "重要な発見でした。", "重要な発見でした。"),
                LearningExercise("jab2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ilerleme' ifadesinin Japonca karşılığı hangisi?", "", listOf("研究", "結果", "進歩"), listOf("進歩"), "Örnek: 進歩は明らかです。 — İlerleme ortada.", null, null))),
            LearningLesson("JA-B2-U3-L4", "Bilim ve Yenilik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab2u3e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("研究は続いています。"), "Söylenen cümle: 研究は続いています。 — Araştırma sürüyor.", "研究は続いています。", null),
                LearningExercise("jab2u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Önemli bir keşifti.", "Teori kanıtlandı.", "Sonuca şaşırdık."), listOf("Önemli bir keşifti."), "Söylenen cümle: 重要な発見でした。", "重要な発見でした。", null),
                LearningExercise("jab2u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kanıtlama' ifadesinin Japonca karşılığı hangisi?", "", listOf("結果", "証明", "発見"), listOf("証明"), "Örnek: 理論が証明されました。 — Teori kanıtlandı.", null, null))),
            LearningLesson("JA-B2-U3-L5", "Bilim ve Yenilik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab2u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "結果に驚きました。", listOf("Önemli bir keşifti.", "Teori kanıtlandı.", "Sonuca şaşırdık."), listOf("Sonuca şaşırdık."), "Cümlenin çevirisi: Sonuca şaşırdık.", null, null),
                LearningExercise("jab2u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "理論が証明されました。", listOf("Sonuca şaşırdık.", "Teori kanıtlandı.", "İlerleme ortada."), listOf("Teori kanıtlandı."), "Cümlenin çevirisi: Teori kanıtlandı.", null, null),
                LearningExercise("jab2u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 研究は続いています。", "", listOf(), listOf("研究は続いています。"), "Türkçesi: Araştırma sürüyor.", "研究は続いています。", "研究は続いています。"))))),
        LearningUnit("JA-B2-U4", "Toplum ve Güncel Konular", "Toplumsal konularda görüş geliştir.", listOf(
            LearningLesson("JA-B2-U4-L1", "Toplum ve Güncel Konular — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'正義' ne anlama gelir?", "", listOf("eşitlik", "yoksulluk", "adalet"), listOf("adalet"), "正義は基本的な価値です。 — Adalet temel bir değerdir.", null, null),
                LearningExercise("jab2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'平等' ne anlama gelir?", "", listOf("tartışma", "eşitlik", "vatandaş"), listOf("eşitlik"), "法の下の平等。 — Yasa önünde eşitlik.", null, null),
                LearningExercise("jab2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'市民' ne anlama gelir?", "", listOf("vatandaş", "yoksulluk", "adalet"), listOf("vatandaş"), "すべての市民に権利があります。 — Her vatandaşın hakları vardır.", null, null)), listOf(
                TargetVocabulary("jab2u4w1", "正義", "adalet", "ifade", "正義は基本的な価値です。", "Adalet temel bir değerdir."),
                TargetVocabulary("jab2u4w2", "平等", "eşitlik", "ifade", "法の下の平等。", "Yasa önünde eşitlik."),
                TargetVocabulary("jab2u4w3", "市民", "vatandaş", "ifade", "すべての市民に権利があります。", "Her vatandaşın hakları vardır."),
                TargetVocabulary("jab2u4w4", "貧困", "yoksulluk", "ifade", "貧困と戦わなければなりません。", "Yoksullukla mücadele etmeliyiz."),
                TargetVocabulary("jab2u4w5", "議論", "tartışma", "ifade", "議論は続いています。", "Tartışma sürüyor."))),
            LearningLesson("JA-B2-U4-L2", "Toplum ve Güncel Konular — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は基本的な価値です。", "", listOf("市民", "正義", "平等"), listOf("正義"), "Doğru cümle: 正義は基本的な価値です。 — Adalet temel bir değerdir.", null, null),
                LearningExercise("jab2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___と戦わなければなりません。", "", listOf("貧困", "議論", "正義"), listOf("貧困"), "Doğru cümle: 貧困と戦わなければなりません。 — Yoksullukla mücadele etmeliyiz.", null, null),
                LearningExercise("jab2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Adalet temel bir değerdir.", "Her vatandaşın hakları vardır.", "Tartışma sürüyor."), listOf("Tartışma sürüyor."), "Söylenen cümle: 議論は続いています。", "議論は続いています。", null),
                LearningExercise("jab2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "貧困と戦わなければなりません。", listOf("Yoksullukla mücadele etmeliyiz.", "Yasa önünde eşitlik.", "Tartışma sürüyor."), listOf("Yoksullukla mücadele etmeliyiz."), "Cümlenin çevirisi: Yoksullukla mücadele etmeliyiz.", null, null))),
            LearningLesson("JA-B2-U4-L3", "Toplum ve Güncel Konular — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "難しい___、続けます。", "", listOf("けれども", "から", "ので"), listOf("けれども"), "Zıtlık bağlacı: けれども (-e rağmen).", null, null),
                LearningExercise("jab2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 法の下の平等。", "", listOf(), listOf("法の下の平等。"), "Türkçesi: Yasa önünde eşitlik.", "法の下の平等。", "法の下の平等。"),
                LearningExercise("jab2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'vatandaş' ifadesinin Japonca karşılığı hangisi?", "", listOf("議論", "市民", "正義"), listOf("市民"), "Örnek: すべての市民に権利があります。 — Her vatandaşın hakları vardır.", null, null))),
            LearningLesson("JA-B2-U4-L4", "Toplum ve Güncel Konular — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab2u4e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("正義は基本的な価値です。"), "Söylenen cümle: 正義は基本的な価値です。 — Adalet temel bir değerdir.", "正義は基本的な価値です。", null),
                LearningExercise("jab2u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yoksullukla mücadele etmeliyiz.", "Tartışma sürüyor.", "Yasa önünde eşitlik."), listOf("Yasa önünde eşitlik."), "Söylenen cümle: 法の下の平等。", "法の下の平等。", null),
                LearningExercise("jab2u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'yoksulluk' ifadesinin Japonca karşılığı hangisi?", "", listOf("貧困", "平等", "議論"), listOf("貧困"), "Örnek: 貧困と戦わなければなりません。 — Yoksullukla mücadele etmeliyiz.", null, null))),
            LearningLesson("JA-B2-U4-L5", "Toplum ve Güncel Konular — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab2u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "議論は続いています。", listOf("Yoksullukla mücadele etmeliyiz.", "Tartışma sürüyor.", "Yasa önünde eşitlik."), listOf("Tartışma sürüyor."), "Cümlenin çevirisi: Tartışma sürüyor.", null, null),
                LearningExercise("jab2u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "貧困と戦わなければなりません。", listOf("Yoksullukla mücadele etmeliyiz.", "Her vatandaşın hakları vardır.", "Tartışma sürüyor."), listOf("Yoksullukla mücadele etmeliyiz."), "Cümlenin çevirisi: Yoksullukla mücadele etmeliyiz.", null, null),
                LearningExercise("jab2u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 正義は基本的な価値です。", "", listOf(), listOf("正義は基本的な価値です。"), "Türkçesi: Adalet temel bir değerdir.", "正義は基本的な価値です。", "正義は基本的な価値です。"))))),
        LearningUnit("JA-B2-U5", "Sanat ve Edebiyat", "Sanat eserlerini yorumla.", listOf(
            LearningLesson("JA-B2-U5-L1", "Sanat ve Edebiyat — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'絵画' ne anlama gelir?", "", listOf("etkileyici", "tablo/resim", "roman"), listOf("tablo/resim"), "絵画は美術館にあります。 — Tablo müzede.", null, null),
                LearningExercise("jab2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'小説' ne anlama gelir?", "", listOf("roman", "sergi", "yazar"), listOf("roman"), "小説は四百ページあります。 — Roman dört yüz sayfa.", null, null),
                LearningExercise("jab2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'展覧会' ne anlama gelir?", "", listOf("etkileyici", "tablo/resim", "sergi"), listOf("sergi"), "展覧会は明日始まります。 — Sergi yarın başlıyor.", null, null)), listOf(
                TargetVocabulary("jab2u5w1", "絵画", "tablo/resim", "ifade", "絵画は美術館にあります。", "Tablo müzede."),
                TargetVocabulary("jab2u5w2", "小説", "roman", "ifade", "小説は四百ページあります。", "Roman dört yüz sayfa."),
                TargetVocabulary("jab2u5w3", "展覧会", "sergi", "ifade", "展覧会は明日始まります。", "Sergi yarın başlıyor."),
                TargetVocabulary("jab2u5w4", "印象的", "etkileyici", "ifade", "印象的な作品です。", "Etkileyici bir eser."),
                TargetVocabulary("jab2u5w5", "作家", "yazar", "ifade", "作家は今晩朗読します。", "Yazar bu akşam okuma yapıyor."))),
            LearningLesson("JA-B2-U5-L2", "Sanat ve Edebiyat — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は美術館にあります。", "", listOf("絵画", "小説", "展覧会"), listOf("絵画"), "Doğru cümle: 絵画は美術館にあります。 — Tablo müzede.", null, null),
                LearningExercise("jab2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___な作品です。", "", listOf("作家", "絵画", "印象的"), listOf("印象的"), "Doğru cümle: 印象的な作品です。 — Etkileyici bir eser.", null, null),
                LearningExercise("jab2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sergi yarın başlıyor.", "Yazar bu akşam okuma yapıyor.", "Tablo müzede."), listOf("Yazar bu akşam okuma yapıyor."), "Söylenen cümle: 作家は今晩朗読します。", "作家は今晩朗読します。", null),
                LearningExercise("jab2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "印象的な作品です。", listOf("Roman dört yüz sayfa.", "Yazar bu akşam okuma yapıyor.", "Etkileyici bir eser."), listOf("Etkileyici bir eser."), "Cümlenin çevirisi: Etkileyici bir eser.", null, null))),
            LearningLesson("JA-B2-U5-L3", "Sanat ve Edebiyat — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "私が___いる小説は面白いです。", "", listOf("読んで", "読み", "読む"), listOf("読んで"), "İlgi cümlesi + süreklilik: 読んでいる小説.", null, null),
                LearningExercise("jab2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 小説は四百ページあります。", "", listOf(), listOf("小説は四百ページあります。"), "Türkçesi: Roman dört yüz sayfa.", "小説は四百ページあります。", "小説は四百ページあります。"),
                LearningExercise("jab2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sergi' ifadesinin Japonca karşılığı hangisi?", "", listOf("展覧会", "絵画", "作家"), listOf("展覧会"), "Örnek: 展覧会は明日始まります。 — Sergi yarın başlıyor.", null, null))),
            LearningLesson("JA-B2-U5-L4", "Sanat ve Edebiyat — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab2u5e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("絵画は美術館にあります。"), "Söylenen cümle: 絵画は美術館にあります。 — Tablo müzede.", "絵画は美術館にあります。", null),
                LearningExercise("jab2u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yazar bu akşam okuma yapıyor.", "Roman dört yüz sayfa.", "Etkileyici bir eser."), listOf("Roman dört yüz sayfa."), "Söylenen cümle: 小説は四百ページあります。", "小説は四百ページあります。", null),
                LearningExercise("jab2u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'etkileyici' ifadesinin Japonca karşılığı hangisi?", "", listOf("小説", "作家", "印象的"), listOf("印象的"), "Örnek: 印象的な作品です。 — Etkileyici bir eser.", null, null))),
            LearningLesson("JA-B2-U5-L5", "Sanat ve Edebiyat — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab2u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "作家は今晩朗読します。", listOf("Yazar bu akşam okuma yapıyor.", "Roman dört yüz sayfa.", "Etkileyici bir eser."), listOf("Yazar bu akşam okuma yapıyor."), "Cümlenin çevirisi: Yazar bu akşam okuma yapıyor.", null, null),
                LearningExercise("jab2u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "印象的な作品です。", listOf("Sergi yarın başlıyor.", "Yazar bu akşam okuma yapıyor.", "Etkileyici bir eser."), listOf("Etkileyici bir eser."), "Cümlenin çevirisi: Etkileyici bir eser.", null, null),
                LearningExercise("jab2u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 絵画は美術館にあります。", "", listOf(), listOf("絵画は美術館にあります。"), "Türkçesi: Tablo müzede.", "絵画は美術館にあります。", "絵画は美術館にあります。"))))),
        LearningUnit("JA-B2-U6", "Tartışma ve İkna", "Karşıt görüşleri dengeli biçimde tart.", listOf(
            LearningLesson("JA-B2-U6-L1", "Tartışma ve İkna — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jab2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'論点' ne anlama gelir?", "", listOf("argüman/tartışma noktası", "bir yandan", "karşı argüman"), listOf("argüman/tartışma noktası"), "論点は明確です。 — Tartışma noktası net.", null, null),
                LearningExercise("jab2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'一方で' ne anlama gelir?", "", listOf("öte yandan", "sonuç/çıkarım", "bir yandan"), listOf("bir yandan"), "一方で高いです。 — Bir yandan pahalı.", null, null),
                LearningExercise("jab2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'他方で' ne anlama gelir?", "", listOf("argüman/tartışma noktası", "öte yandan", "karşı argüman"), listOf("öte yandan"), "他方で便利です。 — Öte yandan kullanışlı.", null, null)), listOf(
                TargetVocabulary("jab2u6w1", "論点", "argüman/tartışma noktası", "ifade", "論点は明確です。", "Tartışma noktası net."),
                TargetVocabulary("jab2u6w2", "一方で", "bir yandan", "ifade", "一方で高いです。", "Bir yandan pahalı."),
                TargetVocabulary("jab2u6w3", "他方で", "öte yandan", "ifade", "他方で便利です。", "Öte yandan kullanışlı."),
                TargetVocabulary("jab2u6w4", "反論", "karşı argüman", "ifade", "反論があります。", "Bir karşı argümanım var."),
                TargetVocabulary("jab2u6w5", "結論", "sonuç/çıkarım", "ifade", "結論は明らかです。", "Çıkarım açık."))),
            LearningLesson("JA-B2-U6-L2", "Tartışma ve İkna — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jab2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は明確です。", "", listOf("一方で", "他方で", "論点"), listOf("論点"), "Doğru cümle: 論点は明確です。 — Tartışma noktası net.", null, null),
                LearningExercise("jab2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___があります。", "", listOf("論点", "反論", "結論"), listOf("反論"), "Doğru cümle: 反論があります。 — Bir karşı argümanım var.", null, null),
                LearningExercise("jab2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çıkarım açık.", "Tartışma noktası net.", "Öte yandan kullanışlı."), listOf("Çıkarım açık."), "Söylenen cümle: 結論は明らかです。", "結論は明らかです。", null),
                LearningExercise("jab2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "反論があります。", listOf("Çıkarım açık.", "Bir karşı argümanım var.", "Bir yandan pahalı."), listOf("Bir karşı argümanım var."), "Cümlenin çevirisi: Bir karşı argümanım var.", null, null))),
            LearningLesson("JA-B2-U6-L3", "Tartışma ve İkna — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jab2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "一方で高いですが、___便利です。", "", listOf("他方で", "一方で", "その上に"), listOf("他方で"), "Kalıp: 一方で...他方で...", null, null),
                LearningExercise("jab2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 一方で高いです。", "", listOf(), listOf("一方で高いです。"), "Türkçesi: Bir yandan pahalı.", "一方で高いです。", "一方で高いです。"),
                LearningExercise("jab2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'öte yandan' ifadesinin Japonca karşılığı hangisi?", "", listOf("論点", "結論", "他方で"), listOf("他方で"), "Örnek: 他方で便利です。 — Öte yandan kullanışlı.", null, null))),
            LearningLesson("JA-B2-U6-L4", "Tartışma ve İkna — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jab2u6e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("論点は明確です。"), "Söylenen cümle: 論点は明確です。 — Tartışma noktası net.", "論点は明確です。", null),
                LearningExercise("jab2u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bir yandan pahalı.", "Bir karşı argümanım var.", "Çıkarım açık."), listOf("Bir yandan pahalı."), "Söylenen cümle: 一方で高いです。", "一方で高いです。", null),
                LearningExercise("jab2u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'karşı argüman' ifadesinin Japonca karşılığı hangisi?", "", listOf("結論", "反論", "一方で"), listOf("反論"), "Örnek: 反論があります。 — Bir karşı argümanım var.", null, null))),
            LearningLesson("JA-B2-U6-L5", "Tartışma ve İkna — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jab2u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "結論は明らかです。", listOf("Bir yandan pahalı.", "Bir karşı argümanım var.", "Çıkarım açık."), listOf("Çıkarım açık."), "Cümlenin çevirisi: Çıkarım açık.", null, null),
                LearningExercise("jab2u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "反論があります。", listOf("Çıkarım açık.", "Bir karşı argümanım var.", "Öte yandan kullanışlı."), listOf("Bir karşı argümanım var."), "Cümlenin çevirisi: Bir karşı argümanım var.", null, null),
                LearningExercise("jab2u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 論点は明確です。", "", listOf(), listOf("論点は明確です。"), "Türkçesi: Tartışma noktası net.", "論点は明確です。", "論点は明確です。"))))),
        LearningUnit("JA-C1-U1", "Akademik Dil", "Akademik metinleri çözümle ve üret.", listOf(
            LearningLesson("JA-C1-U1-L1", "Akademik Dil — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'論文' ne anlama gelir?", "", listOf("çözümleme", "kaynak (alıntı)", "makale/tez"), listOf("makale/tez"), "この論文は議論を呼んでいます。 — Bu makale tartışma yaratıyor.", null, null),
                LearningExercise("jac1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'分析' ne anlama gelir?", "", listOf("yöntem", "çözümleme", "inceleme/değerlendirme"), listOf("çözümleme"), "分析は十年のデータを扱います。 — Çözümleme on yıllık veriyi ele alıyor.", null, null),
                LearningExercise("jac1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'検討' ne anlama gelir?", "", listOf("inceleme/değerlendirme", "kaynak (alıntı)", "makale/tez"), listOf("inceleme/değerlendirme"), "明日この問題を検討します。 — Bu konuyu yarın değerlendireceğiz.", null, null)), listOf(
                TargetVocabulary("jac1u1w1", "論文", "makale/tez", "ifade", "この論文は議論を呼んでいます。", "Bu makale tartışma yaratıyor."),
                TargetVocabulary("jac1u1w2", "分析", "çözümleme", "ifade", "分析は十年のデータを扱います。", "Çözümleme on yıllık veriyi ele alıyor."),
                TargetVocabulary("jac1u1w3", "検討", "inceleme/değerlendirme", "ifade", "明日この問題を検討します。", "Bu konuyu yarın değerlendireceğiz."),
                TargetVocabulary("jac1u1w4", "出典", "kaynak (alıntı)", "ifade", "出典は信頼できます。", "Kaynak güvenilir."),
                TargetVocabulary("jac1u1w5", "手法", "yöntem", "ifade", "この手法は有望です。", "Bu yöntem umut verici."))),
            LearningLesson("JA-C1-U1-L2", "Akademik Dil — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "この___は議論を呼んでいます。", "", listOf("検討", "論文", "分析"), listOf("論文"), "Doğru cümle: この論文は議論を呼んでいます。 — Bu makale tartışma yaratıyor.", null, null),
                LearningExercise("jac1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は信頼できます。", "", listOf("出典", "手法", "論文"), listOf("出典"), "Doğru cümle: 出典は信頼できます。 — Kaynak güvenilir.", null, null),
                LearningExercise("jac1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu makale tartışma yaratıyor.", "Bu konuyu yarın değerlendireceğiz.", "Bu yöntem umut verici."), listOf("Bu yöntem umut verici."), "Söylenen cümle: この手法は有望です。", "この手法は有望です。", null),
                LearningExercise("jac1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "出典は信頼できます。", listOf("Kaynak güvenilir.", "Çözümleme on yıllık veriyi ele alıyor.", "Bu yöntem umut verici."), listOf("Kaynak güvenilir."), "Cümlenin çevirisi: Kaynak güvenilir.", null, null))),
            LearningLesson("JA-C1-U1-L3", "Akademik Dil — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "研究___よると、数は増えています。", "", listOf("に", "を", "が"), listOf("に"), "Atıf kalıbı: ...によると (-e göre).", null, null),
                LearningExercise("jac1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 分析は十年のデータを扱います。", "", listOf(), listOf("分析は十年のデータを扱います。"), "Türkçesi: Çözümleme on yıllık veriyi ele alıyor.", "分析は十年のデータを扱います。", "分析は十年のデータを扱います。"),
                LearningExercise("jac1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'inceleme/değerlendirme' ifadesinin Japonca karşılığı hangisi?", "", listOf("手法", "検討", "論文"), listOf("検討"), "Örnek: 明日この問題を検討します。 — Bu konuyu yarın değerlendireceğiz.", null, null))),
            LearningLesson("JA-C1-U1-L4", "Akademik Dil — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac1u1e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("この論文は議論を呼んでいます。"), "Söylenen cümle: この論文は議論を呼んでいます。 — Bu makale tartışma yaratıyor.", "この論文は議論を呼んでいます。", null),
                LearningExercise("jac1u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kaynak güvenilir.", "Bu yöntem umut verici.", "Çözümleme on yıllık veriyi ele alıyor."), listOf("Çözümleme on yıllık veriyi ele alıyor."), "Söylenen cümle: 分析は十年のデータを扱います。", "分析は十年のデータを扱います。", null),
                LearningExercise("jac1u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kaynak (alıntı)' ifadesinin Japonca karşılığı hangisi?", "", listOf("出典", "分析", "手法"), listOf("出典"), "Örnek: 出典は信頼できます。 — Kaynak güvenilir.", null, null))),
            LearningLesson("JA-C1-U1-L5", "Akademik Dil — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac1u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この手法は有望です。", listOf("Kaynak güvenilir.", "Bu yöntem umut verici.", "Çözümleme on yıllık veriyi ele alıyor."), listOf("Bu yöntem umut verici."), "Cümlenin çevirisi: Bu yöntem umut verici.", null, null),
                LearningExercise("jac1u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "出典は信頼できます。", listOf("Kaynak güvenilir.", "Bu konuyu yarın değerlendireceğiz.", "Bu yöntem umut verici."), listOf("Kaynak güvenilir."), "Cümlenin çevirisi: Kaynak güvenilir.", null, null),
                LearningExercise("jac1u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: この論文は議論を呼んでいます。", "", listOf(), listOf("この論文は議論を呼んでいます。"), "Türkçesi: Bu makale tartışma yaratıyor.", "この論文は議論を呼んでいます。", "この論文は議論を呼んでいます。"))))),
        LearningUnit("JA-C1-U2", "Soyut Kavramlar", "Soyut düşünceleri akıcı ifade et.", listOf(
            LearningLesson("JA-C1-U2-L1", "Soyut Kavramlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'知覚' ne anlama gelir?", "", listOf("düşünce/anlayış", "algı", "bilinç"), listOf("algı"), "知覚はよく私たちを欺きます。 — Algı bizi sık yanıltır.", null, null),
                LearningExercise("jac1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'意識' ne anlama gelir?", "", listOf("bilinç", "kavram", "kavrayış/idrak"), listOf("bilinç"), "意識はまだ謎です。 — Bilinç hâlâ bir muamma.", null, null),
                LearningExercise("jac1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'概念' ne anlama gelir?", "", listOf("düşünce/anlayış", "algı", "kavram"), listOf("kavram"), "この概念は定義しにくいです。 — Bu kavramı tanımlamak zor.", null, null)), listOf(
                TargetVocabulary("jac1u2w1", "知覚", "algı", "ifade", "知覚はよく私たちを欺きます。", "Algı bizi sık yanıltır."),
                TargetVocabulary("jac1u2w2", "意識", "bilinç", "ifade", "意識はまだ謎です。", "Bilinç hâlâ bir muamma."),
                TargetVocabulary("jac1u2w3", "概念", "kavram", "ifade", "この概念は定義しにくいです。", "Bu kavramı tanımlamak zor."),
                TargetVocabulary("jac1u2w4", "観念", "düşünce/anlayış", "ifade", "この観念は広く共有されています。", "Bu anlayış geniş kabul görüyor."),
                TargetVocabulary("jac1u2w5", "認識", "kavrayış/idrak", "ifade", "認識は経験で変わります。", "Kavrayış deneyimle değişir."))),
            LearningLesson("JA-C1-U2-L2", "Soyut Kavramlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___はよく私たちを欺きます。", "", listOf("知覚", "意識", "概念"), listOf("知覚"), "Doğru cümle: 知覚はよく私たちを欺きます。 — Algı bizi sık yanıltır.", null, null),
                LearningExercise("jac1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "この___は広く共有されています。", "", listOf("認識", "知覚", "観念"), listOf("観念"), "Doğru cümle: この観念は広く共有されています。 — Bu anlayış geniş kabul görüyor.", null, null),
                LearningExercise("jac1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu kavramı tanımlamak zor.", "Kavrayış deneyimle değişir.", "Algı bizi sık yanıltır."), listOf("Kavrayış deneyimle değişir."), "Söylenen cümle: 認識は経験で変わります。", "認識は経験で変わります。", null),
                LearningExercise("jac1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この観念は広く共有されています。", listOf("Bilinç hâlâ bir muamma.", "Kavrayış deneyimle değişir.", "Bu anlayış geniş kabul görüyor."), listOf("Bu anlayış geniş kabul görüyor."), "Cümlenin çevirisi: Bu anlayış geniş kabul görüyor.", null, null))),
            LearningLesson("JA-C1-U2-L3", "Soyut Kavramlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "見方によって結果が___。", "", listOf("変わります", "変えます", "変わって"), listOf("変わります"), "Geçişsiz fiil: 結果が変わる.", null, null),
                LearningExercise("jac1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 意識はまだ謎です。", "", listOf(), listOf("意識はまだ謎です。"), "Türkçesi: Bilinç hâlâ bir muamma.", "意識はまだ謎です。", "意識はまだ謎です。"),
                LearningExercise("jac1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kavram' ifadesinin Japonca karşılığı hangisi?", "", listOf("概念", "知覚", "認識"), listOf("概念"), "Örnek: この概念は定義しにくいです。 — Bu kavramı tanımlamak zor.", null, null))),
            LearningLesson("JA-C1-U2-L4", "Soyut Kavramlar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac1u2e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("知覚はよく私たちを欺きます。"), "Söylenen cümle: 知覚はよく私たちを欺きます。 — Algı bizi sık yanıltır.", "知覚はよく私たちを欺きます。", null),
                LearningExercise("jac1u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kavrayış deneyimle değişir.", "Bilinç hâlâ bir muamma.", "Bu anlayış geniş kabul görüyor."), listOf("Bilinç hâlâ bir muamma."), "Söylenen cümle: 意識はまだ謎です。", "意識はまだ謎です。", null),
                LearningExercise("jac1u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'düşünce/anlayış' ifadesinin Japonca karşılığı hangisi?", "", listOf("意識", "認識", "観念"), listOf("観念"), "Örnek: この観念は広く共有されています。 — Bu anlayış geniş kabul görüyor.", null, null))),
            LearningLesson("JA-C1-U2-L5", "Soyut Kavramlar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac1u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "認識は経験で変わります。", listOf("Kavrayış deneyimle değişir.", "Bilinç hâlâ bir muamma.", "Bu anlayış geniş kabul görüyor."), listOf("Kavrayış deneyimle değişir."), "Cümlenin çevirisi: Kavrayış deneyimle değişir.", null, null),
                LearningExercise("jac1u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この観念は広く共有されています。", listOf("Bu kavramı tanımlamak zor.", "Kavrayış deneyimle değişir.", "Bu anlayış geniş kabul görüyor."), listOf("Bu anlayış geniş kabul görüyor."), "Cümlenin çevirisi: Bu anlayış geniş kabul görüyor.", null, null),
                LearningExercise("jac1u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 知覚はよく私たちを欺きます。", "", listOf(), listOf("知覚はよく私たちを欺きます。"), "Türkçesi: Algı bizi sık yanıltır.", "知覚はよく私たちを欺きます。", "知覚はよく私たちを欺きます。"))))),
        LearningUnit("JA-C1-U3", "Deyimler ve Mecazlar", "Deyimleri doğal bağlamda kullan.", listOf(
            LearningLesson("JA-C1-U3-L1", "Deyimler ve Mecazlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'一石二鳥' ne anlama gelir?", "", listOf("bir taşla iki kuş", "çok yoğun olmak", "boşa nasihat"), listOf("bir taşla iki kuş"), "それは一石二鳥です。 — Bu bir taşla iki kuş.", null, null),
                LearningExercise("jac1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'猫の手も借りたい' ne anlama gelir?", "", listOf("kuyu dibindeki kurbağa", "beklenmedik şans", "çok yoğun olmak"), listOf("çok yoğun olmak"), "今日は猫の手も借りたいほど忙しいです。 — Bugün kedi pençesi bile ödünç alınacak kadar yoğunum.", null, null),
                LearningExercise("jac1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'井の中の蛙' ne anlama gelir?", "", listOf("bir taşla iki kuş", "kuyu dibindeki kurbağa", "boşa nasihat"), listOf("kuyu dibindeki kurbağa"), "井の中の蛙になるな。 — Kuyudaki kurbağa olma.", null, null)), listOf(
                TargetVocabulary("jac1u3w1", "一石二鳥", "bir taşla iki kuş", "ifade", "それは一石二鳥です。", "Bu bir taşla iki kuş."),
                TargetVocabulary("jac1u3w2", "猫の手も借りたい", "çok yoğun olmak", "ifade", "今日は猫の手も借りたいほど忙しいです。", "Bugün kedi pençesi bile ödünç alınacak kadar yoğunum."),
                TargetVocabulary("jac1u3w3", "井の中の蛙", "kuyu dibindeki kurbağa", "ifade", "井の中の蛙になるな。", "Kuyudaki kurbağa olma."),
                TargetVocabulary("jac1u3w4", "馬の耳に念仏", "boşa nasihat", "ifade", "彼に言っても馬の耳に念仏です。", "Ona söylemek atın kulağına dua okumak gibi."),
                TargetVocabulary("jac1u3w5", "棚からぼたもち", "beklenmedik şans", "ifade", "棚からぼたもちでした。", "Raftan botamochi düştü; beklenmedik şanstı."))),
            LearningLesson("JA-C1-U3-L2", "Deyimler ve Mecazlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "それは___です。", "", listOf("猫の手も借りたい", "井の中の蛙", "一石二鳥"), listOf("一石二鳥"), "Doğru cümle: それは一石二鳥です。 — Bu bir taşla iki kuş.", null, null),
                LearningExercise("jac1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "彼に言っても___です。", "", listOf("一石二鳥", "馬の耳に念仏", "棚からぼたもち"), listOf("馬の耳に念仏"), "Doğru cümle: 彼に言っても馬の耳に念仏です。 — Ona söylemek atın kulağına dua okumak gibi.", null, null),
                LearningExercise("jac1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Raftan botamochi düştü; beklenmedik şanstı.", "Bu bir taşla iki kuş.", "Kuyudaki kurbağa olma."), listOf("Raftan botamochi düştü; beklenmedik şanstı."), "Söylenen cümle: 棚からぼたもちでした。", "棚からぼたもちでした。", null),
                LearningExercise("jac1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼に言っても馬の耳に念仏です。", listOf("Raftan botamochi düştü; beklenmedik şanstı.", "Ona söylemek atın kulağına dua okumak gibi.", "Bugün kedi pençesi bile ödünç alınacak kadar yoğunum."), listOf("Ona söylemek atın kulağına dua okumak gibi."), "Cümlenin çevirisi: Ona söylemek atın kulağına dua okumak gibi.", null, null))),
            LearningLesson("JA-C1-U3-L3", "Deyimler ve Mecazlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "一石二___。", "", listOf("鳥", "魚", "馬"), listOf("鳥"), "Yojijukugo: 一石二鳥 (bir taşla iki kuş).", null, null),
                LearningExercise("jac1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 今日は猫の手も借りたいほど忙しいです。", "", listOf(), listOf("今日は猫の手も借りたいほど忙しいです。"), "Türkçesi: Bugün kedi pençesi bile ödünç alınacak kadar yoğunum.", "今日は猫の手も借りたいほど忙しいです。", "今日は猫の手も借りたいほど忙しいです。"),
                LearningExercise("jac1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kuyu dibindeki kurbağa' ifadesinin Japonca karşılığı hangisi?", "", listOf("一石二鳥", "棚からぼたもち", "井の中の蛙"), listOf("井の中の蛙"), "Örnek: 井の中の蛙になるな。 — Kuyudaki kurbağa olma.", null, null))),
            LearningLesson("JA-C1-U3-L4", "Deyimler ve Mecazlar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac1u3e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("それは一石二鳥です。"), "Söylenen cümle: それは一石二鳥です。 — Bu bir taşla iki kuş.", "それは一石二鳥です。", null),
                LearningExercise("jac1u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün kedi pençesi bile ödünç alınacak kadar yoğunum.", "Ona söylemek atın kulağına dua okumak gibi.", "Raftan botamochi düştü; beklenmedik şanstı."), listOf("Bugün kedi pençesi bile ödünç alınacak kadar yoğunum."), "Söylenen cümle: 今日は猫の手も借りたいほど忙しいです。", "今日は猫の手も借りたいほど忙しいです。", null),
                LearningExercise("jac1u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'boşa nasihat' ifadesinin Japonca karşılığı hangisi?", "", listOf("棚からぼたもち", "馬の耳に念仏", "猫の手も借りたい"), listOf("馬の耳に念仏"), "Örnek: 彼に言っても馬の耳に念仏です。 — Ona söylemek atın kulağına dua okumak gibi.", null, null))),
            LearningLesson("JA-C1-U3-L5", "Deyimler ve Mecazlar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac1u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "棚からぼたもちでした。", listOf("Bugün kedi pençesi bile ödünç alınacak kadar yoğunum.", "Ona söylemek atın kulağına dua okumak gibi.", "Raftan botamochi düştü; beklenmedik şanstı."), listOf("Raftan botamochi düştü; beklenmedik şanstı."), "Cümlenin çevirisi: Raftan botamochi düştü; beklenmedik şanstı.", null, null),
                LearningExercise("jac1u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼に言っても馬の耳に念仏です。", listOf("Raftan botamochi düştü; beklenmedik şanstı.", "Ona söylemek atın kulağına dua okumak gibi.", "Kuyudaki kurbağa olma."), listOf("Ona söylemek atın kulağına dua okumak gibi."), "Cümlenin çevirisi: Ona söylemek atın kulağına dua okumak gibi.", null, null),
                LearningExercise("jac1u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: それは一石二鳥です。", "", listOf(), listOf("それは一石二鳥です。"), "Türkçesi: Bu bir taşla iki kuş.", "それは一石二鳥です。", "それは一石二鳥です。"))))),
        LearningUnit("JA-C1-U4", "Resmî Yazışma", "Resmî mektup ve e-posta dilinde ustalaş.", listOf(
            LearningLesson("JA-C1-U4-L1", "Resmî Yazışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'拝啓' ne anlama gelir?", "", listOf("ek (dosya)", "saygılarımla (mektup sonu)", "saygıdeğer (mektup girişi)"), listOf("saygıdeğer (mektup girişi)"), "拝啓 春の候、... — Saygıdeğer, bahar mevsiminde...", null, null),
                LearningExercise("jac1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'添付' ne anlama gelir?", "", listOf("iş nezaketi selamı", "ek (dosya)", "ilişkin (resmî)"), listOf("ek (dosya)"), "履歴書を添付します。 — Özgeçmişi ekliyorum.", null, null),
                LearningExercise("jac1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'につきまして' ne anlama gelir?", "", listOf("ilişkin (resmî)", "saygılarımla (mektup sonu)", "saygıdeğer (mektup girişi)"), listOf("ilişkin (resmî)"), "その件につきましてご連絡します。 — O konuya ilişkin bilgi vereceğiz.", null, null)), listOf(
                TargetVocabulary("jac1u4w1", "拝啓", "saygıdeğer (mektup girişi)", "ifade", "拝啓 春の候、...", "Saygıdeğer, bahar mevsiminde..."),
                TargetVocabulary("jac1u4w2", "添付", "ek (dosya)", "ifade", "履歴書を添付します。", "Özgeçmişi ekliyorum."),
                TargetVocabulary("jac1u4w3", "につきまして", "ilişkin (resmî)", "ifade", "その件につきましてご連絡します。", "O konuya ilişkin bilgi vereceğiz."),
                TargetVocabulary("jac1u4w4", "敬具", "saygılarımla (mektup sonu)", "ifade", "敬具", "Saygılarımla"),
                TargetVocabulary("jac1u4w5", "お世話になっております", "iş nezaketi selamı", "ifade", "いつもお世話になっております。", "Her zaman yardımlarınız için teşekkürler."))),
            LearningLesson("JA-C1-U4-L2", "Resmî Yazışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 春の候、...", "", listOf("につきまして", "拝啓", "添付"), listOf("拝啓"), "Doğru cümle: 拝啓 春の候、... — Saygıdeğer, bahar mevsiminde...", null, null),
                LearningExercise("jac1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___", "", listOf("敬具", "お世話になっております", "拝啓"), listOf("敬具"), "Doğru cümle: 敬具 — Saygılarımla", null, null),
                LearningExercise("jac1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Saygıdeğer, bahar mevsiminde...", "O konuya ilişkin bilgi vereceğiz.", "Her zaman yardımlarınız için teşekkürler."), listOf("Her zaman yardımlarınız için teşekkürler."), "Söylenen cümle: いつもお世話になっております。", "いつもお世話になっております。", null),
                LearningExercise("jac1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "敬具", listOf("Saygılarımla", "Özgeçmişi ekliyorum.", "Her zaman yardımlarınız için teşekkürler."), listOf("Saygılarımla"), "Cümlenin çevirisi: Saygılarımla", null, null))),
            LearningLesson("JA-C1-U4-L3", "Resmî Yazışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "いつも___になっております。", "", listOf("お世話", "お願い", "お疲れ"), listOf("お世話"), "İş nezaketi: お世話になっております.", null, null),
                LearningExercise("jac1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 履歴書を添付します。", "", listOf(), listOf("履歴書を添付します。"), "Türkçesi: Özgeçmişi ekliyorum.", "履歴書を添付します。", "履歴書を添付します。"),
                LearningExercise("jac1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ilişkin (resmî)' ifadesinin Japonca karşılığı hangisi?", "", listOf("お世話になっております", "につきまして", "拝啓"), listOf("につきまして"), "Örnek: その件につきましてご連絡します。 — O konuya ilişkin bilgi vereceğiz.", null, null))),
            LearningLesson("JA-C1-U4-L4", "Resmî Yazışma — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac1u4e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("拝啓 春の候、..."), "Söylenen cümle: 拝啓 春の候、... — Saygıdeğer, bahar mevsiminde...", "拝啓 春の候、...", null),
                LearningExercise("jac1u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Saygılarımla", "Her zaman yardımlarınız için teşekkürler.", "Özgeçmişi ekliyorum."), listOf("Özgeçmişi ekliyorum."), "Söylenen cümle: 履歴書を添付します。", "履歴書を添付します。", null),
                LearningExercise("jac1u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'saygılarımla (mektup sonu)' ifadesinin Japonca karşılığı hangisi?", "", listOf("敬具", "添付", "お世話になっております"), listOf("敬具"), "Örnek: 敬具 — Saygılarımla", null, null))),
            LearningLesson("JA-C1-U4-L5", "Resmî Yazışma — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac1u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "いつもお世話になっております。", listOf("Saygılarımla", "Her zaman yardımlarınız için teşekkürler.", "Özgeçmişi ekliyorum."), listOf("Her zaman yardımlarınız için teşekkürler."), "Cümlenin çevirisi: Her zaman yardımlarınız için teşekkürler.", null, null),
                LearningExercise("jac1u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "敬具", listOf("Saygılarımla", "O konuya ilişkin bilgi vereceğiz.", "Her zaman yardımlarınız için teşekkürler."), listOf("Saygılarımla"), "Cümlenin çevirisi: Saygılarımla", null, null),
                LearningExercise("jac1u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 拝啓 春の候、...", "", listOf(), listOf("拝啓 春の候、..."), "Türkçesi: Saygıdeğer, bahar mevsiminde...", "拝啓 春の候、...", "拝啓 春の候、..."))))),
        LearningUnit("JA-C1-U5", "Müzakere ve Diplomasi", "İncelikli müzakere dili kur.", listOf(
            LearningLesson("JA-C1-U5-L1", "Müzakere ve Diplomasi — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'交渉' ne anlama gelir?", "", listOf("anlaşma/mutabakat", "müzakere", "uzlaşma"), listOf("müzakere"), "交渉は何時間も続きました。 — Müzakere saatlerce sürdü.", null, null),
                LearningExercise("jac1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'妥協' ne anlama gelir?", "", listOf("uzlaşma", "taviz", "duruş/pozisyon"), listOf("uzlaşma"), "妥協は公平です。 — Uzlaşma adil.", null, null),
                LearningExercise("jac1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'譲歩' ne anlama gelir?", "", listOf("anlaşma/mutabakat", "müzakere", "taviz"), listOf("taviz"), "譲歩が必要でした。 — Taviz gerekliydi.", null, null)), listOf(
                TargetVocabulary("jac1u5w1", "交渉", "müzakere", "ifade", "交渉は何時間も続きました。", "Müzakere saatlerce sürdü."),
                TargetVocabulary("jac1u5w2", "妥協", "uzlaşma", "ifade", "妥協は公平です。", "Uzlaşma adil."),
                TargetVocabulary("jac1u5w3", "譲歩", "taviz", "ifade", "譲歩が必要でした。", "Taviz gerekliydi."),
                TargetVocabulary("jac1u5w4", "合意", "anlaşma/mutabakat", "ifade", "合意は遅く成立しました。", "Mutabakat geç sağlandı."),
                TargetVocabulary("jac1u5w5", "立場", "duruş/pozisyon", "ifade", "私たちの立場は変わりません。", "Duruşumuz değişmiyor."))),
            LearningLesson("JA-C1-U5-L2", "Müzakere ve Diplomasi — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は何時間も続きました。", "", listOf("交渉", "妥協", "譲歩"), listOf("交渉"), "Doğru cümle: 交渉は何時間も続きました。 — Müzakere saatlerce sürdü.", null, null),
                LearningExercise("jac1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は遅く成立しました。", "", listOf("立場", "交渉", "合意"), listOf("合意"), "Doğru cümle: 合意は遅く成立しました。 — Mutabakat geç sağlandı.", null, null),
                LearningExercise("jac1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Taviz gerekliydi.", "Duruşumuz değişmiyor.", "Müzakere saatlerce sürdü."), listOf("Duruşumuz değişmiyor."), "Söylenen cümle: 私たちの立場は変わりません。", "私たちの立場は変わりません。", null),
                LearningExercise("jac1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "合意は遅く成立しました。", listOf("Uzlaşma adil.", "Duruşumuz değişmiyor.", "Mutabakat geç sağlandı."), listOf("Mutabakat geç sağlandı."), "Cümlenin çevirisi: Mutabakat geç sağlandı.", null, null))),
            LearningLesson("JA-C1-U5-L3", "Müzakere ve Diplomasi — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "私たちは合意に___しました。", "", listOf("達", "着", "届"), listOf("達"), "Kalıp: 合意に達する (mutabakata varmak).", null, null),
                LearningExercise("jac1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 妥協は公平です。", "", listOf(), listOf("妥協は公平です。"), "Türkçesi: Uzlaşma adil.", "妥協は公平です。", "妥協は公平です。"),
                LearningExercise("jac1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'taviz' ifadesinin Japonca karşılığı hangisi?", "", listOf("譲歩", "交渉", "立場"), listOf("譲歩"), "Örnek: 譲歩が必要でした。 — Taviz gerekliydi.", null, null))),
            LearningLesson("JA-C1-U5-L4", "Müzakere ve Diplomasi — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac1u5e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("交渉は何時間も続きました。"), "Söylenen cümle: 交渉は何時間も続きました。 — Müzakere saatlerce sürdü.", "交渉は何時間も続きました。", null),
                LearningExercise("jac1u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Duruşumuz değişmiyor.", "Uzlaşma adil.", "Mutabakat geç sağlandı."), listOf("Uzlaşma adil."), "Söylenen cümle: 妥協は公平です。", "妥協は公平です。", null),
                LearningExercise("jac1u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'anlaşma/mutabakat' ifadesinin Japonca karşılığı hangisi?", "", listOf("妥協", "立場", "合意"), listOf("合意"), "Örnek: 合意は遅く成立しました。 — Mutabakat geç sağlandı.", null, null))),
            LearningLesson("JA-C1-U5-L5", "Müzakere ve Diplomasi — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac1u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "私たちの立場は変わりません。", listOf("Duruşumuz değişmiyor.", "Uzlaşma adil.", "Mutabakat geç sağlandı."), listOf("Duruşumuz değişmiyor."), "Cümlenin çevirisi: Duruşumuz değişmiyor.", null, null),
                LearningExercise("jac1u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "合意は遅く成立しました。", listOf("Taviz gerekliydi.", "Duruşumuz değişmiyor.", "Mutabakat geç sağlandı."), listOf("Mutabakat geç sağlandı."), "Cümlenin çevirisi: Mutabakat geç sağlandı.", null, null),
                LearningExercise("jac1u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 交渉は何時間も続きました。", "", listOf(), listOf("交渉は何時間も続きました。"), "Türkçesi: Müzakere saatlerce sürdü.", "交渉は何時間も続きました。", "交渉は何時間も続きました。"))))),
        LearningUnit("JA-C1-U6", "İnce Anlam Farkları", "Yakın anlamlı ifadeleri ayırt et.", listOf(
            LearningLesson("JA-C1-U6-L1", "İnce Anlam Farkları — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'どうやら' ne anlama gelir?", "", listOf("anlaşılan", "sözde/adıyla bilinen", "titiz/ayrıntılı"), listOf("anlaşılan"), "どうやら彼が正しいようです。 — Anlaşılan o haklı.", null, null),
                LearningExercise("jac1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'いわゆる' ne anlama gelir?", "", listOf("etkili", "muhtemelen", "sözde/adıyla bilinen"), listOf("sözde/adıyla bilinen"), "いわゆる専門家が話しました。 — Sözde bir uzman konuştu.", null, null),
                LearningExercise("jac1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'効果的' ne anlama gelir?", "", listOf("anlaşılan", "etkili", "titiz/ayrıntılı"), listOf("etkili"), "この方法は効果的です。 — Bu yöntem etkili.", null, null)), listOf(
                TargetVocabulary("jac1u6w1", "どうやら", "anlaşılan", "ifade", "どうやら彼が正しいようです。", "Anlaşılan o haklı."),
                TargetVocabulary("jac1u6w2", "いわゆる", "sözde/adıyla bilinen", "ifade", "いわゆる専門家が話しました。", "Sözde bir uzman konuştu."),
                TargetVocabulary("jac1u6w3", "効果的", "etkili", "ifade", "この方法は効果的です。", "Bu yöntem etkili."),
                TargetVocabulary("jac1u6w4", "綿密", "titiz/ayrıntılı", "ifade", "綿密な計画が必要です。", "Titiz bir plan gerekli."),
                TargetVocabulary("jac1u6w5", "おそらく", "muhtemelen", "ifade", "おそらく間違いでしょう。", "Muhtemelen bir hata."))),
            LearningLesson("JA-C1-U6-L2", "İnce Anlam Farkları — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___彼が正しいようです。", "", listOf("いわゆる", "効果的", "どうやら"), listOf("どうやら"), "Doğru cümle: どうやら彼が正しいようです。 — Anlaşılan o haklı.", null, null),
                LearningExercise("jac1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___な計画が必要です。", "", listOf("どうやら", "綿密", "おそらく"), listOf("綿密"), "Doğru cümle: 綿密な計画が必要です。 — Titiz bir plan gerekli.", null, null),
                LearningExercise("jac1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Muhtemelen bir hata.", "Anlaşılan o haklı.", "Bu yöntem etkili."), listOf("Muhtemelen bir hata."), "Söylenen cümle: おそらく間違いでしょう。", "おそらく間違いでしょう。", null),
                LearningExercise("jac1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "綿密な計画が必要です。", listOf("Muhtemelen bir hata.", "Titiz bir plan gerekli.", "Sözde bir uzman konuştu."), listOf("Titiz bir plan gerekli."), "Cümlenin çevirisi: Titiz bir plan gerekli.", null, null))),
            LearningLesson("JA-C1-U6-L3", "İnce Anlam Farkları — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___彼が正しいようです。", "", listOf("どうやら", "いわゆる", "おそらくは"), listOf("どうやら"), "どうやら...ようだ: kanıta dayalı izlenim.", null, null),
                LearningExercise("jac1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: いわゆる専門家が話しました。", "", listOf(), listOf("いわゆる専門家が話しました。"), "Türkçesi: Sözde bir uzman konuştu.", "いわゆる専門家が話しました。", "いわゆる専門家が話しました。"),
                LearningExercise("jac1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'etkili' ifadesinin Japonca karşılığı hangisi?", "", listOf("どうやら", "おそらく", "効果的"), listOf("効果的"), "Örnek: この方法は効果的です。 — Bu yöntem etkili.", null, null))),
            LearningLesson("JA-C1-U6-L4", "İnce Anlam Farkları — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac1u6e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("どうやら彼が正しいようです。"), "Söylenen cümle: どうやら彼が正しいようです。 — Anlaşılan o haklı.", "どうやら彼が正しいようです。", null),
                LearningExercise("jac1u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sözde bir uzman konuştu.", "Titiz bir plan gerekli.", "Muhtemelen bir hata."), listOf("Sözde bir uzman konuştu."), "Söylenen cümle: いわゆる専門家が話しました。", "いわゆる専門家が話しました。", null),
                LearningExercise("jac1u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'titiz/ayrıntılı' ifadesinin Japonca karşılığı hangisi?", "", listOf("おそらく", "綿密", "いわゆる"), listOf("綿密"), "Örnek: 綿密な計画が必要です。 — Titiz bir plan gerekli.", null, null))),
            LearningLesson("JA-C1-U6-L5", "İnce Anlam Farkları — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac1u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "おそらく間違いでしょう。", listOf("Sözde bir uzman konuştu.", "Titiz bir plan gerekli.", "Muhtemelen bir hata."), listOf("Muhtemelen bir hata."), "Cümlenin çevirisi: Muhtemelen bir hata.", null, null),
                LearningExercise("jac1u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "綿密な計画が必要です。", listOf("Muhtemelen bir hata.", "Titiz bir plan gerekli.", "Bu yöntem etkili."), listOf("Titiz bir plan gerekli."), "Cümlenin çevirisi: Titiz bir plan gerekli.", null, null),
                LearningExercise("jac1u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: どうやら彼が正しいようです。", "", listOf(), listOf("どうやら彼が正しいようです。"), "Türkçesi: Anlaşılan o haklı.", "どうやら彼が正しいようです。", "どうやら彼が正しいようです。"))))),
        LearningUnit("JA-C2-U1", "Üslup ve İncelik", "Üslubu bağlama göre ustaca ayarla.", listOf(
            LearningLesson("JA-C2-U1-L1", "Üslup ve İncelik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'微妙' ne anlama gelir?", "", listOf("konuşma tonu", "özlü", "incelikli/nazik"), listOf("incelikli/nazik"), "言葉の微妙な違いは難しいです。 — Sözcüklerin incelikli farkları zordur.", null, null),
                LearningExercise("jac2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'口調' ne anlama gelir?", "", listOf("ince/zarif", "konuşma tonu", "ima"), listOf("konuşma tonu"), "彼の口調は少し皮肉でした。 — Konuşma tonu biraz alaycıydı.", null, null),
                LearningExercise("jac2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'ほのめかし' ne anlama gelir?", "", listOf("ima", "özlü", "incelikli/nazik"), listOf("ima"), "彼女だけがほのめかしに気づきました。 — İmayı yalnızca o fark etti.", null, null)), listOf(
                TargetVocabulary("jac2u1w1", "微妙", "incelikli/nazik", "ifade", "言葉の微妙な違いは難しいです。", "Sözcüklerin incelikli farkları zordur."),
                TargetVocabulary("jac2u1w2", "口調", "konuşma tonu", "ifade", "彼の口調は少し皮肉でした。", "Konuşma tonu biraz alaycıydı."),
                TargetVocabulary("jac2u1w3", "ほのめかし", "ima", "ifade", "彼女だけがほのめかしに気づきました。", "İmayı yalnızca o fark etti."),
                TargetVocabulary("jac2u1w4", "簡潔", "özlü", "ifade", "彼の答えは簡潔でした。", "Yanıtı özlüydü."),
                TargetVocabulary("jac2u1w5", "繊細", "ince/zarif", "ifade", "繊細な表現が光ります。", "İnce ifadeler göz dolduruyor."))),
            LearningLesson("JA-C2-U1-L2", "Üslup ve İncelik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "言葉の___な違いは難しいです。", "", listOf("ほのめかし", "微妙", "口調"), listOf("微妙"), "Doğru cümle: 言葉の微妙な違いは難しいです。 — Sözcüklerin incelikli farkları zordur.", null, null),
                LearningExercise("jac2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "彼の答えは___でした。", "", listOf("簡潔", "繊細", "微妙"), listOf("簡潔"), "Doğru cümle: 彼の答えは簡潔でした。 — Yanıtı özlüydü.", null, null),
                LearningExercise("jac2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sözcüklerin incelikli farkları zordur.", "İmayı yalnızca o fark etti.", "İnce ifadeler göz dolduruyor."), listOf("İnce ifadeler göz dolduruyor."), "Söylenen cümle: 繊細な表現が光ります。", "繊細な表現が光ります。", null),
                LearningExercise("jac2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼の答えは簡潔でした。", listOf("Yanıtı özlüydü.", "Konuşma tonu biraz alaycıydı.", "İnce ifadeler göz dolduruyor."), listOf("Yanıtı özlüydü."), "Cümlenin çevirisi: Yanıtı özlüydü.", null, null))),
            LearningLesson("JA-C2-U1-L3", "Üslup ve İncelik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "彼のスピーチは短くて___でした。", "", listOf("簡潔", "簡単さ", "簡略に"), listOf("簡潔"), "Na-sıfat: 簡潔でした.", null, null),
                LearningExercise("jac2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 彼の口調は少し皮肉でした。", "", listOf(), listOf("彼の口調は少し皮肉でした。"), "Türkçesi: Konuşma tonu biraz alaycıydı.", "彼の口調は少し皮肉でした。", "彼の口調は少し皮肉でした。"),
                LearningExercise("jac2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ima' ifadesinin Japonca karşılığı hangisi?", "", listOf("繊細", "ほのめかし", "微妙"), listOf("ほのめかし"), "Örnek: 彼女だけがほのめかしに気づきました。 — İmayı yalnızca o fark etti.", null, null))),
            LearningLesson("JA-C2-U1-L4", "Üslup ve İncelik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac2u1e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("言葉の微妙な違いは難しいです。"), "Söylenen cümle: 言葉の微妙な違いは難しいです。 — Sözcüklerin incelikli farkları zordur.", "言葉の微妙な違いは難しいです。", null),
                LearningExercise("jac2u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yanıtı özlüydü.", "İnce ifadeler göz dolduruyor.", "Konuşma tonu biraz alaycıydı."), listOf("Konuşma tonu biraz alaycıydı."), "Söylenen cümle: 彼の口調は少し皮肉でした。", "彼の口調は少し皮肉でした。", null),
                LearningExercise("jac2u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'özlü' ifadesinin Japonca karşılığı hangisi?", "", listOf("簡潔", "口調", "繊細"), listOf("簡潔"), "Örnek: 彼の答えは簡潔でした。 — Yanıtı özlüydü.", null, null))),
            LearningLesson("JA-C2-U1-L5", "Üslup ve İncelik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac2u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "繊細な表現が光ります。", listOf("Yanıtı özlüydü.", "İnce ifadeler göz dolduruyor.", "Konuşma tonu biraz alaycıydı."), listOf("İnce ifadeler göz dolduruyor."), "Cümlenin çevirisi: İnce ifadeler göz dolduruyor.", null, null),
                LearningExercise("jac2u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼の答えは簡潔でした。", listOf("Yanıtı özlüydü.", "İmayı yalnızca o fark etti.", "İnce ifadeler göz dolduruyor."), listOf("Yanıtı özlüydü."), "Cümlenin çevirisi: Yanıtı özlüydü.", null, null),
                LearningExercise("jac2u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 言葉の微妙な違いは難しいです。", "", listOf(), listOf("言葉の微妙な違いは難しいです。"), "Türkçesi: Sözcüklerin incelikli farkları zordur.", "言葉の微妙な違いは難しいです。", "言葉の微妙な違いは難しいです。"))))),
        LearningUnit("JA-C2-U2", "Edebî Dil", "Edebî metinlerin katmanlarını çözümle.", listOf(
            LearningLesson("JA-C2-U2-L1", "Edebî Dil — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'隠喩' ne anlama gelir?", "", listOf("lirik", "metafor", "simge"), listOf("metafor"), "隠喩が全文を貫いています。 — Metafor bütün metni kat ediyor.", null, null),
                LearningExercise("jac2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'象徴' ne anlama gelir?", "", listOf("simge", "anlatıcı", "ironi"), listOf("simge"), "海は自由の象徴です。 — Deniz özgürlüğün simgesidir.", null, null),
                LearningExercise("jac2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'語り手' ne anlama gelir?", "", listOf("lirik", "metafor", "anlatıcı"), listOf("anlatıcı"), "語り手が何度も変わります。 — Anlatıcı defalarca değişiyor.", null, null)), listOf(
                TargetVocabulary("jac2u2w1", "隠喩", "metafor", "ifade", "隠喩が全文を貫いています。", "Metafor bütün metni kat ediyor."),
                TargetVocabulary("jac2u2w2", "象徴", "simge", "ifade", "海は自由の象徴です。", "Deniz özgürlüğün simgesidir."),
                TargetVocabulary("jac2u2w3", "語り手", "anlatıcı", "ifade", "語り手が何度も変わります。", "Anlatıcı defalarca değişiyor."),
                TargetVocabulary("jac2u2w4", "叙情的", "lirik", "ifade", "文体はとても叙情的です。", "Üslup çok lirik."),
                TargetVocabulary("jac2u2w5", "皮肉", "ironi", "ifade", "この文章の皮肉は明らかです。", "Bu metindeki ironi çok açık."))),
            LearningLesson("JA-C2-U2-L2", "Edebî Dil — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___が全文を貫いています。", "", listOf("隠喩", "象徴", "語り手"), listOf("隠喩"), "Doğru cümle: 隠喩が全文を貫いています。 — Metafor bütün metni kat ediyor.", null, null),
                LearningExercise("jac2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "文体はとても___です。", "", listOf("皮肉", "隠喩", "叙情的"), listOf("叙情的"), "Doğru cümle: 文体はとても叙情的です。 — Üslup çok lirik.", null, null),
                LearningExercise("jac2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Anlatıcı defalarca değişiyor.", "Bu metindeki ironi çok açık.", "Metafor bütün metni kat ediyor."), listOf("Bu metindeki ironi çok açık."), "Söylenen cümle: この文章の皮肉は明らかです。", "この文章の皮肉は明らかです。", null),
                LearningExercise("jac2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文体はとても叙情的です。", listOf("Deniz özgürlüğün simgesidir.", "Bu metindeki ironi çok açık.", "Üslup çok lirik."), listOf("Üslup çok lirik."), "Cümlenin çevirisi: Üslup çok lirik.", null, null))),
            LearningLesson("JA-C2-U2-L3", "Edebî Dil — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "この文章の___は明らかです。", "", listOf("皮肉", "皮膚", "肉皮"), listOf("皮肉"), "İsim: 文章の皮肉 (metnin ironisi).", null, null),
                LearningExercise("jac2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 海は自由の象徴です。", "", listOf(), listOf("海は自由の象徴です。"), "Türkçesi: Deniz özgürlüğün simgesidir.", "海は自由の象徴です。", "海は自由の象徴です。"),
                LearningExercise("jac2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'anlatıcı' ifadesinin Japonca karşılığı hangisi?", "", listOf("語り手", "隠喩", "皮肉"), listOf("語り手"), "Örnek: 語り手が何度も変わります。 — Anlatıcı defalarca değişiyor.", null, null))),
            LearningLesson("JA-C2-U2-L4", "Edebî Dil — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac2u2e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("隠喩が全文を貫いています。"), "Söylenen cümle: 隠喩が全文を貫いています。 — Metafor bütün metni kat ediyor.", "隠喩が全文を貫いています。", null),
                LearningExercise("jac2u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu metindeki ironi çok açık.", "Deniz özgürlüğün simgesidir.", "Üslup çok lirik."), listOf("Deniz özgürlüğün simgesidir."), "Söylenen cümle: 海は自由の象徴です。", "海は自由の象徴です。", null),
                LearningExercise("jac2u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lirik' ifadesinin Japonca karşılığı hangisi?", "", listOf("象徴", "皮肉", "叙情的"), listOf("叙情的"), "Örnek: 文体はとても叙情的です。 — Üslup çok lirik.", null, null))),
            LearningLesson("JA-C2-U2-L5", "Edebî Dil — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac2u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この文章の皮肉は明らかです。", listOf("Bu metindeki ironi çok açık.", "Deniz özgürlüğün simgesidir.", "Üslup çok lirik."), listOf("Bu metindeki ironi çok açık."), "Cümlenin çevirisi: Bu metindeki ironi çok açık.", null, null),
                LearningExercise("jac2u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文体はとても叙情的です。", listOf("Anlatıcı defalarca değişiyor.", "Bu metindeki ironi çok açık.", "Üslup çok lirik."), listOf("Üslup çok lirik."), "Cümlenin çevirisi: Üslup çok lirik.", null, null),
                LearningExercise("jac2u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 隠喩が全文を貫いています。", "", listOf(), listOf("隠喩が全文を貫いています。"), "Türkçesi: Metafor bütün metni kat ediyor.", "隠喩が全文を貫いています。", "隠喩が全文を貫いています。"))))),
        LearningUnit("JA-C2-U3", "Uzmanlık Söylemi", "Uzmanlık alanı söylemine hâkim ol.", listOf(
            LearningLesson("JA-C2-U3-L1", "Uzmanlık Söylemi — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'専門用語' ne anlama gelir?", "", listOf("uzmanlık terimi", "söylem", "ikna gücü"), listOf("uzmanlık terimi"), "専門用語は正確であるべきです。 — Terimler kesin olmalı.", null, null),
                LearningExercise("jac2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'言説' ne anlama gelir?", "", listOf("inceleme yazısı", "ayırt etme", "söylem"), listOf("söylem"), "学術的言説には規範があります。 — Akademik söylemin normları vardır.", null, null),
                LearningExercise("jac2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'論考' ne anlama gelir?", "", listOf("uzmanlık terimi", "inceleme yazısı", "ikna gücü"), listOf("inceleme yazısı"), "この論考は三部構成です。 — Bu inceleme üç bölümden oluşuyor.", null, null)), listOf(
                TargetVocabulary("jac2u3w1", "専門用語", "uzmanlık terimi", "ifade", "専門用語は正確であるべきです。", "Terimler kesin olmalı."),
                TargetVocabulary("jac2u3w2", "言説", "söylem", "ifade", "学術的言説には規範があります。", "Akademik söylemin normları vardır."),
                TargetVocabulary("jac2u3w3", "論考", "inceleme yazısı", "ifade", "この論考は三部構成です。", "Bu inceleme üç bölümden oluşuyor."),
                TargetVocabulary("jac2u3w4", "説得力", "ikna gücü", "ifade", "説得力のある議論です。", "İkna gücü yüksek bir tartışma."),
                TargetVocabulary("jac2u3w5", "区別", "ayırt etme", "ifade", "この二つの概念を区別すべきです。", "Bu iki kavram ayırt edilmeli."))),
            LearningLesson("JA-C2-U3-L2", "Uzmanlık Söylemi — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は正確であるべきです。", "", listOf("言説", "論考", "専門用語"), listOf("専門用語"), "Doğru cümle: 専門用語は正確であるべきです。 — Terimler kesin olmalı.", null, null),
                LearningExercise("jac2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___のある議論です。", "", listOf("専門用語", "説得力", "区別"), listOf("説得力"), "Doğru cümle: 説得力のある議論です。 — İkna gücü yüksek bir tartışma.", null, null),
                LearningExercise("jac2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu iki kavram ayırt edilmeli.", "Terimler kesin olmalı.", "Bu inceleme üç bölümden oluşuyor."), listOf("Bu iki kavram ayırt edilmeli."), "Söylenen cümle: この二つの概念を区別すべきです。", "この二つの概念を区別すべきです。", null),
                LearningExercise("jac2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "説得力のある議論です。", listOf("Bu iki kavram ayırt edilmeli.", "İkna gücü yüksek bir tartışma.", "Akademik söylemin normları vardır."), listOf("İkna gücü yüksek bir tartışma."), "Cümlenin çevirisi: İkna gücü yüksek bir tartışma.", null, null))),
            LearningLesson("JA-C2-U3-L3", "Uzmanlık Söylemi — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___のある議論は批評家をも納得させます。", "", listOf("説得力", "説明書", "説話力"), listOf("説得力"), "Kalıp: 説得力のある (ikna gücü olan).", null, null),
                LearningExercise("jac2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 学術的言説には規範があります。", "", listOf(), listOf("学術的言説には規範があります。"), "Türkçesi: Akademik söylemin normları vardır.", "学術的言説には規範があります。", "学術的言説には規範があります。"),
                LearningExercise("jac2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'inceleme yazısı' ifadesinin Japonca karşılığı hangisi?", "", listOf("専門用語", "区別", "論考"), listOf("論考"), "Örnek: この論考は三部構成です。 — Bu inceleme üç bölümden oluşuyor.", null, null))),
            LearningLesson("JA-C2-U3-L4", "Uzmanlık Söylemi — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac2u3e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("専門用語は正確であるべきです。"), "Söylenen cümle: 専門用語は正確であるべきです。 — Terimler kesin olmalı.", "専門用語は正確であるべきです。", null),
                LearningExercise("jac2u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Akademik söylemin normları vardır.", "İkna gücü yüksek bir tartışma.", "Bu iki kavram ayırt edilmeli."), listOf("Akademik söylemin normları vardır."), "Söylenen cümle: 学術的言説には規範があります。", "学術的言説には規範があります。", null),
                LearningExercise("jac2u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ikna gücü' ifadesinin Japonca karşılığı hangisi?", "", listOf("区別", "説得力", "言説"), listOf("説得力"), "Örnek: 説得力のある議論です。 — İkna gücü yüksek bir tartışma.", null, null))),
            LearningLesson("JA-C2-U3-L5", "Uzmanlık Söylemi — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac2u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この二つの概念を区別すべきです。", listOf("Akademik söylemin normları vardır.", "İkna gücü yüksek bir tartışma.", "Bu iki kavram ayırt edilmeli."), listOf("Bu iki kavram ayırt edilmeli."), "Cümlenin çevirisi: Bu iki kavram ayırt edilmeli.", null, null),
                LearningExercise("jac2u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "説得力のある議論です。", listOf("Bu iki kavram ayırt edilmeli.", "İkna gücü yüksek bir tartışma.", "Bu inceleme üç bölümden oluşuyor."), listOf("İkna gücü yüksek bir tartışma."), "Cümlenin çevirisi: İkna gücü yüksek bir tartışma.", null, null),
                LearningExercise("jac2u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 専門用語は正確であるべきです。", "", listOf(), listOf("専門用語は正確であるべきです。"), "Türkçesi: Terimler kesin olmalı.", "専門用語は正確であるべきです。", "専門用語は正確であるべきです。"))))),
        LearningUnit("JA-C2-U4", "Kültürel Derinlik", "Kültürel referansları derinlemesine kavra.", listOf(
            LearningLesson("JA-C2-U4-L1", "Kültürel Derinlik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'世界観' ne anlama gelir?", "", listOf("mizaç", "kökleşmiş", "dünya görüşü"), listOf("dünya görüşü"), "彼の世界観は揺らぎました。 — Dünya görüşü sarsıldı.", null, null),
                LearningExercise("jac2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'気質' ne anlama gelir?", "", listOf("miras", "mizaç", "zamanın ruhu"), listOf("mizaç"), "地域によって気質が違います。 — Mizaç bölgeye göre değişir.", null, null),
                LearningExercise("jac2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'時代精神' ne anlama gelir?", "", listOf("zamanın ruhu", "kökleşmiş", "dünya görüşü"), listOf("zamanın ruhu"), "この小説は時代精神を捉えています。 — Bu roman zamanın ruhunu yakalıyor.", null, null)), listOf(
                TargetVocabulary("jac2u4w1", "世界観", "dünya görüşü", "ifade", "彼の世界観は揺らぎました。", "Dünya görüşü sarsıldı."),
                TargetVocabulary("jac2u4w2", "気質", "mizaç", "ifade", "地域によって気質が違います。", "Mizaç bölgeye göre değişir."),
                TargetVocabulary("jac2u4w3", "時代精神", "zamanın ruhu", "ifade", "この小説は時代精神を捉えています。", "Bu roman zamanın ruhunu yakalıyor."),
                TargetVocabulary("jac2u4w4", "根付いた", "kökleşmiş", "ifade", "この伝統は文化に深く根付いています。", "Bu gelenek kültüre derin kök salmış."),
                TargetVocabulary("jac2u4w5", "遺産", "miras", "ifade", "文化遺産は守られています。", "Kültürel miras korunuyor."))),
            LearningLesson("JA-C2-U4-L2", "Kültürel Derinlik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "彼の___は揺らぎました。", "", listOf("時代精神", "世界観", "気質"), listOf("世界観"), "Doğru cümle: 彼の世界観は揺らぎました。 — Dünya görüşü sarsıldı.", null, null),
                LearningExercise("jac2u4e5", Skill.VOCABULARY, "Doğru anlamı seç", "'根付いた' ne anlama gelir?", "", listOf("zamanın ruhu", "kökleşmiş", "dünya görüşü"), listOf("kökleşmiş"), "この伝統は文化に深く根付いています。 — Bu gelenek kültüre derin kök salmış.", null, null),
                LearningExercise("jac2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dünya görüşü sarsıldı.", "Bu roman zamanın ruhunu yakalıyor.", "Kültürel miras korunuyor."), listOf("Kültürel miras korunuyor."), "Söylenen cümle: 文化遺産は守られています。", "文化遺産は守られています。", null),
                LearningExercise("jac2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この伝統は文化に深く根付いています。", listOf("Bu gelenek kültüre derin kök salmış.", "Mizaç bölgeye göre değişir.", "Kültürel miras korunuyor."), listOf("Bu gelenek kültüre derin kök salmış."), "Cümlenin çevirisi: Bu gelenek kültüre derin kök salmış.", null, null))),
            LearningLesson("JA-C2-U4-L3", "Kültürel Derinlik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "この伝統は文化に深く___います。", "", listOf("根付いて", "根付き", "根付く"), listOf("根付いて"), "Durum bildirme: 根付いています.", null, null),
                LearningExercise("jac2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 地域によって気質が違います。", "", listOf(), listOf("地域によって気質が違います。"), "Türkçesi: Mizaç bölgeye göre değişir.", "地域によって気質が違います。", "地域によって気質が違います。"),
                LearningExercise("jac2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'zamanın ruhu' ifadesinin Japonca karşılığı hangisi?", "", listOf("遺産", "時代精神", "世界観"), listOf("時代精神"), "Örnek: この小説は時代精神を捉えています。 — Bu roman zamanın ruhunu yakalıyor.", null, null))),
            LearningLesson("JA-C2-U4-L4", "Kültürel Derinlik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac2u4e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("彼の世界観は揺らぎました。"), "Söylenen cümle: 彼の世界観は揺らぎました。 — Dünya görüşü sarsıldı.", "彼の世界観は揺らぎました。", null),
                LearningExercise("jac2u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu gelenek kültüre derin kök salmış.", "Kültürel miras korunuyor.", "Mizaç bölgeye göre değişir."), listOf("Mizaç bölgeye göre değişir."), "Söylenen cümle: 地域によって気質が違います。", "地域によって気質が違います。", null),
                LearningExercise("jac2u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kökleşmiş' ifadesinin Japonca karşılığı hangisi?", "", listOf("根付いた", "気質", "遺産"), listOf("根付いた"), "Örnek: この伝統は文化に深く根付いています。 — Bu gelenek kültüre derin kök salmış.", null, null))),
            LearningLesson("JA-C2-U4-L5", "Kültürel Derinlik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac2u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文化遺産は守られています。", listOf("Bu gelenek kültüre derin kök salmış.", "Kültürel miras korunuyor.", "Mizaç bölgeye göre değişir."), listOf("Kültürel miras korunuyor."), "Cümlenin çevirisi: Kültürel miras korunuyor.", null, null),
                LearningExercise("jac2u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "この伝統は文化に深く根付いています。", listOf("Bu gelenek kültüre derin kök salmış.", "Bu roman zamanın ruhunu yakalıyor.", "Kültürel miras korunuyor."), listOf("Bu gelenek kültüre derin kök salmış."), "Cümlenin çevirisi: Bu gelenek kültüre derin kök salmış.", null, null),
                LearningExercise("jac2u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 彼の世界観は揺らぎました。", "", listOf(), listOf("彼の世界観は揺らぎました。"), "Türkçesi: Dünya görüşü sarsıldı.", "彼の世界観は揺らぎました。", "彼の世界観は揺らぎました。"))))),
        LearningUnit("JA-C2-U5", "Retorik Ustalığı", "Retorik araçları etkili kullan.", listOf(
            LearningLesson("JA-C2-U5-L1", "Retorik Ustalığı — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'修辞' ne anlama gelir?", "", listOf("keskin", "retorik", "mecazlı ifade"), listOf("retorik"), "彼の修辞は見事です。 — Retoriği kusursuz.", null, null),
                LearningExercise("jac2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'比喩表現' ne anlama gelir?", "", listOf("mecazlı ifade", "belagat", "üslup heybeti"), listOf("mecazlı ifade"), "比喩表現がさりげなく効いています。 — Mecazlı ifadeler incelikle etki ediyor.", null, null),
                LearningExercise("jac2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'雄弁' ne anlama gelir?", "", listOf("keskin", "retorik", "belagat"), listOf("belagat"), "彼女の雄弁は有名です。 — Belagati meşhur.", null, null)), listOf(
                TargetVocabulary("jac2u5w1", "修辞", "retorik", "ifade", "彼の修辞は見事です。", "Retoriği kusursuz."),
                TargetVocabulary("jac2u5w2", "比喩表現", "mecazlı ifade", "ifade", "比喩表現がさりげなく効いています。", "Mecazlı ifadeler incelikle etki ediyor."),
                TargetVocabulary("jac2u5w3", "雄弁", "belagat", "ifade", "彼女の雄弁は有名です。", "Belagati meşhur."),
                TargetVocabulary("jac2u5w4", "鋭い", "keskin", "ifade", "彼の批評は非常に鋭いです。", "Eleştirisi son derece keskin."),
                TargetVocabulary("jac2u5w5", "風格", "üslup heybeti", "ifade", "文章に風格があります。", "Yazıda asil bir hava var."))),
            LearningLesson("JA-C2-U5-L2", "Retorik Ustalığı — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "彼の___は見事です。", "", listOf("修辞", "比喩表現", "雄弁"), listOf("修辞"), "Doğru cümle: 彼の修辞は見事です。 — Retoriği kusursuz.", null, null),
                LearningExercise("jac2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "彼の批評は非常に___です。", "", listOf("風格", "修辞", "鋭い"), listOf("鋭い"), "Doğru cümle: 彼の批評は非常に鋭いです。 — Eleştirisi son derece keskin.", null, null),
                LearningExercise("jac2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Belagati meşhur.", "Yazıda asil bir hava var.", "Retoriği kusursuz."), listOf("Yazıda asil bir hava var."), "Söylenen cümle: 文章に風格があります。", "文章に風格があります。", null),
                LearningExercise("jac2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼の批評は非常に鋭いです。", listOf("Mecazlı ifadeler incelikle etki ediyor.", "Yazıda asil bir hava var.", "Eleştirisi son derece keskin."), listOf("Eleştirisi son derece keskin."), "Cümlenin çevirisi: Eleştirisi son derece keskin.", null, null))),
            LearningLesson("JA-C2-U5-L3", "Retorik Ustalığı — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "彼の批評は非常に___です。", "", listOf("鋭い", "鋭さ", "鋭く"), listOf("鋭い"), "İ-sıfat yüklem: 鋭いです.", null, null),
                LearningExercise("jac2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 比喩表現がさりげなく効いています。", "", listOf(), listOf("比喩表現がさりげなく効いています。"), "Türkçesi: Mecazlı ifadeler incelikle etki ediyor.", "比喩表現がさりげなく効いています。", "比喩表現がさりげなく効いています。"),
                LearningExercise("jac2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'belagat' ifadesinin Japonca karşılığı hangisi?", "", listOf("雄弁", "修辞", "風格"), listOf("雄弁"), "Örnek: 彼女の雄弁は有名です。 — Belagati meşhur.", null, null))),
            LearningLesson("JA-C2-U5-L4", "Retorik Ustalığı — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac2u5e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("彼の修辞は見事です。"), "Söylenen cümle: 彼の修辞は見事です。 — Retoriği kusursuz.", "彼の修辞は見事です。", null),
                LearningExercise("jac2u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yazıda asil bir hava var.", "Mecazlı ifadeler incelikle etki ediyor.", "Eleştirisi son derece keskin."), listOf("Mecazlı ifadeler incelikle etki ediyor."), "Söylenen cümle: 比喩表現がさりげなく効いています。", "比喩表現がさりげなく効いています。", null),
                LearningExercise("jac2u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'keskin' ifadesinin Japonca karşılığı hangisi?", "", listOf("比喩表現", "風格", "鋭い"), listOf("鋭い"), "Örnek: 彼の批評は非常に鋭いです。 — Eleştirisi son derece keskin.", null, null))),
            LearningLesson("JA-C2-U5-L5", "Retorik Ustalığı — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac2u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文章に風格があります。", listOf("Yazıda asil bir hava var.", "Mecazlı ifadeler incelikle etki ediyor.", "Eleştirisi son derece keskin."), listOf("Yazıda asil bir hava var."), "Cümlenin çevirisi: Yazıda asil bir hava var.", null, null),
                LearningExercise("jac2u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼の批評は非常に鋭いです。", listOf("Belagati meşhur.", "Yazıda asil bir hava var.", "Eleştirisi son derece keskin."), listOf("Eleştirisi son derece keskin."), "Cümlenin çevirisi: Eleştirisi son derece keskin.", null, null),
                LearningExercise("jac2u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 彼の修辞は見事です。", "", listOf(), listOf("彼の修辞は見事です。"), "Türkçesi: Retoriği kusursuz.", "彼の修辞は見事です。", "彼の修辞は見事です。"))))),
        LearningUnit("JA-C2-U6", "Ana Dil Düzeyinde Akıcılık", "Ana dil konuşuru düzeyinde incelik kazan.", listOf(
            LearningLesson("JA-C2-U6-L1", "Ana Dil Düzeyinde Akıcılık — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jac2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'使いこなす' ne anlama gelir?", "", listOf("ustaca kullanmak", "rahatlıkla", "doğal telaffuz"), listOf("ustaca kullanmak"), "彼女は五か国語を使いこなします。 — Beş dili ustaca kullanıyor.", null, null),
                LearningExercise("jac2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'楽々と' ne anlama gelir?", "", listOf("rafinelik", "akıcı", "rahatlıkla"), listOf("rahatlıkla"), "楽々と文体を切り替えます。 — Üslubu rahatlıkla değiştiriyor.", null, null),
                LearningExercise("jac2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'洗練' ne anlama gelir?", "", listOf("ustaca kullanmak", "rafinelik", "doğal telaffuz"), listOf("rafinelik"), "洗練された表現です。 — Rafine bir ifade.", null, null)), listOf(
                TargetVocabulary("jac2u6w1", "使いこなす", "ustaca kullanmak", "ifade", "彼女は五か国語を使いこなします。", "Beş dili ustaca kullanıyor."),
                TargetVocabulary("jac2u6w2", "楽々と", "rahatlıkla", "ifade", "楽々と文体を切り替えます。", "Üslubu rahatlıkla değiştiriyor."),
                TargetVocabulary("jac2u6w3", "洗練", "rafinelik", "ifade", "洗練された表現です。", "Rafine bir ifade."),
                TargetVocabulary("jac2u6w4", "自然な発音", "doğal telaffuz", "ifade", "自然な発音で話します。", "Doğal bir telaffuzla konuşuyor."),
                TargetVocabulary("jac2u6w5", "流暢", "akıcı", "ifade", "彼女は日本語を流暢に話します。", "Japoncayı akıcı konuşuyor."))),
            LearningLesson("JA-C2-U6-L2", "Ana Dil Düzeyinde Akıcılık — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jac2u6e4", Skill.VOCABULARY, "Doğru anlamı seç", "'使いこなす' ne anlama gelir?", "", listOf("ustaca kullanmak", "rafinelik", "akıcı"), listOf("ustaca kullanmak"), "彼女は五か国語を使いこなします。 — Beş dili ustaca kullanıyor.", null, null),
                LearningExercise("jac2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___で話します。", "", listOf("使いこなす", "自然な発音", "流暢"), listOf("自然な発音"), "Doğru cümle: 自然な発音で話します。 — Doğal bir telaffuzla konuşuyor.", null, null),
                LearningExercise("jac2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Japoncayı akıcı konuşuyor.", "Beş dili ustaca kullanıyor.", "Rafine bir ifade."), listOf("Japoncayı akıcı konuşuyor."), "Söylenen cümle: 彼女は日本語を流暢に話します。", "彼女は日本語を流暢に話します。", null),
                LearningExercise("jac2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "自然な発音で話します。", listOf("Japoncayı akıcı konuşuyor.", "Doğal bir telaffuzla konuşuyor.", "Üslubu rahatlıkla değiştiriyor."), listOf("Doğal bir telaffuzla konuşuyor."), "Cümlenin çevirisi: Doğal bir telaffuzla konuşuyor.", null, null))),
            LearningLesson("JA-C2-U6-L3", "Ana Dil Düzeyinde Akıcılık — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jac2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "彼女は日本語を___話します。", "", listOf("流暢に", "流暢だ", "流暢の"), listOf("流暢に"), "Na-sıfat zarf hali: 流暢に話す.", null, null),
                LearningExercise("jac2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 楽々と文体を切り替えます。", "", listOf(), listOf("楽々と文体を切り替えます。"), "Türkçesi: Üslubu rahatlıkla değiştiriyor.", "楽々と文体を切り替えます。", "楽々と文体を切り替えます。"),
                LearningExercise("jac2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'rafinelik' ifadesinin Japonca karşılığı hangisi?", "", listOf("使いこなす", "流暢", "洗練"), listOf("洗練"), "Örnek: 洗練された表現です。 — Rafine bir ifade.", null, null))),
            LearningLesson("JA-C2-U6-L4", "Ana Dil Düzeyinde Akıcılık — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("jac2u6e11", Skill.LISTENING, "Dinle ve duyduğun cümleyi yaz", "Duyduğun cümleyi yaz", "", listOf(), listOf("彼女は五か国語を使いこなします。"), "Söylenen cümle: 彼女は五か国語を使いこなします。 — Beş dili ustaca kullanıyor.", "彼女は五か国語を使いこなします。", null),
                LearningExercise("jac2u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Üslubu rahatlıkla değiştiriyor.", "Doğal bir telaffuzla konuşuyor.", "Japoncayı akıcı konuşuyor."), listOf("Üslubu rahatlıkla değiştiriyor."), "Söylenen cümle: 楽々と文体を切り替えます。", "楽々と文体を切り替えます。", null),
                LearningExercise("jac2u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'doğal telaffuz' ifadesinin Japonca karşılığı hangisi?", "", listOf("流暢", "自然な発音", "楽々と"), listOf("自然な発音"), "Örnek: 自然な発音で話します。 — Doğal bir telaffuzla konuşuyor.", null, null))),
            LearningLesson("JA-C2-U6-L5", "Ana Dil Düzeyinde Akıcılık — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("jac2u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "彼女は日本語を流暢に話します。", listOf("Üslubu rahatlıkla değiştiriyor.", "Doğal bir telaffuzla konuşuyor.", "Japoncayı akıcı konuşuyor."), listOf("Japoncayı akıcı konuşuyor."), "Cümlenin çevirisi: Japoncayı akıcı konuşuyor.", null, null),
                LearningExercise("jac2u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "自然な発音で話します。", listOf("Japoncayı akıcı konuşuyor.", "Doğal bir telaffuzla konuşuyor.", "Rafine bir ifade."), listOf("Doğal bir telaffuzla konuşuyor."), "Cümlenin çevirisi: Doğal bir telaffuzla konuşuyor.", null, null),
                LearningExercise("jac2u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 彼女は五か国語を使いこなします。", "", listOf(), listOf("彼女は五か国語を使いこなします。"), "Türkçesi: Beş dili ustaca kullanıyor.", "彼女は五か国語を使いこなします。", "彼女は五か国語を使いこなします。"))))))
}
