package com.linguapro.android

/** Japonca (JA) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseJA {
    val units: List<LearningUnit> = listOf(
        LearningUnit("JA-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("JA-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'こんにちは' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "こんにちは、アンナです。 — Merhaba, ben Anna.", null, null),
                LearningExercise("jaa1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'ありがとう' ne anlama gelir?", "", listOf("memnun oldum", "teşekkürler", "lütfen (rica)"), listOf("teşekkürler"), "ありがとうございます。 — Teşekkür ederim.", null, null),
                LearningExercise("jaa1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'お願いします' ne anlama gelir?", "", listOf("lütfen (rica)", "hoşça kal", "merhaba"), listOf("lütfen (rica)"), "コーヒーをお願いします。 — Kahve lütfen.", null, null))),
            LearningLesson("JA-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___、アンナです。", "", listOf("お願いします", "こんにちは", "ありがとう"), listOf("こんにちは"), "Doğru cümle: こんにちは、アンナです。 — Merhaba, ben Anna.", null, null),
                LearningExercise("jaa1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___、また明日！", "", listOf("さようなら", "はじめまして", "こんにちは"), listOf("さようなら"), "Doğru cümle: さようなら、また明日！ — Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("jaa1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Kahve lütfen.", "Memnun oldum, ben Mehmet."), listOf("Memnun oldum, ben Mehmet."), "Söylenen cümle: はじめまして、メフメトです。", "はじめまして、メフメトです。", null),
                LearningExercise("jaa1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "さようなら、また明日！", listOf("Hoşça kal, yarın görüşürüz!", "Teşekkür ederim.", "Memnun oldum, ben Mehmet."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("JA-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "私はメフメト___。", "", listOf("です", "ます", "から"), listOf("です"), "Cümle sonu kibar koşaç: です.", null, null),
                LearningExercise("jaa1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: ありがとうございます。", "", listOf(), listOf("ありがとうございます。"), "Türkçesi: Teşekkür ederim.", "ありがとうございます。", "ありがとうございます。"),
                LearningExercise("jaa1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lütfen (rica)' ifadesinin Japonca karşılığı hangisi?", "", listOf("はじめまして", "お願いします", "こんにちは"), listOf("お願いします"), "Örnek: コーヒーをお願いします。 — Kahve lütfen.", null, null))))),
        LearningUnit("JA-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("JA-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'二' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "二人の兄弟がいます。 — İki kardeşim var.", null, null),
                LearningExercise("jaa1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'十' ne anlama gelir?", "", listOf("on", "bugün", "saat (...da)"), listOf("on"), "今、十時です。 — Saat şimdi on.", null, null),
                LearningExercise("jaa1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'今日' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "今日は月曜日です。 — Bugün pazartesi.", null, null))),
            LearningLesson("JA-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___人の兄弟がいます。", "", listOf("二", "十", "今日"), listOf("二"), "Doğru cümle: 二人の兄弟がいます。 — İki kardeşim var.", null, null),
                LearningExercise("jaa1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "また___！", "", listOf("時", "二", "明日"), listOf("明日"), "Doğru cümle: また明日！ — Yarın görüşürüz!", null, null),
                LearningExercise("jaa1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Şu an saat kaç?", "İki kardeşim var."), listOf("Şu an saat kaç?"), "Söylenen cümle: 今、何時ですか。", "今、何時ですか。", null),
                LearningExercise("jaa1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "また明日！", listOf("Saat şimdi on.", "Şu an saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("JA-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "今、何___ですか。", "", listOf("時", "分", "日"), listOf("時"), "Saat sorma kalıbı: 何時ですか。", null, null),
                LearningExercise("jaa1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 今、十時です。", "", listOf(), listOf("今、十時です。"), "Türkçesi: Saat şimdi on.", "今、十時です。", "今、十時です。"),
                LearningExercise("jaa1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bugün' ifadesinin Japonca karşılığı hangisi?", "", listOf("今日", "二", "時"), listOf("今日"), "Örnek: 今日は月曜日です。 — Bugün pazartesi.", null, null))))),
        LearningUnit("JA-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("JA-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'水' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "水をください。 — Su lütfen.", null, null),
                LearningExercise("jaa1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'パン' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "パンは新しいです。 — Ekmek taze.", null, null),
                LearningExercise("jaa1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'コーヒー' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "コーヒーを飲みます。 — Kahve içiyorum.", null, null))),
            LearningLesson("JA-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___をください。", "", listOf("パン", "コーヒー", "水"), listOf("水"), "Doğru cümle: 水をください。 — Su lütfen.", null, null),
                LearningExercise("jaa1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は赤いです。", "", listOf("水", "りんご", "お茶"), listOf("りんご"), "Doğru cümle: りんごは赤いです。 — Elma kırmızı.", null, null),
                LearningExercise("jaa1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çayı severim.", "Su lütfen.", "Kahve içiyorum."), listOf("Çayı severim."), "Söylenen cümle: お茶が好きです。", "お茶が好きです。", null),
                LearningExercise("jaa1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "りんごは赤いです。", listOf("Çayı severim.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("JA-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "コーヒー___飲みます。", "", listOf("を", "は", "に"), listOf("を"), "Nesne edatı: を.", null, null),
                LearningExercise("jaa1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: パンは新しいです。", "", listOf(), listOf("パンは新しいです。"), "Türkçesi: Ekmek taze.", "パンは新しいです。", "パンは新しいです。"),
                LearningExercise("jaa1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kahve' ifadesinin Japonca karşılığı hangisi?", "", listOf("水", "お茶", "コーヒー"), listOf("コーヒー"), "Örnek: コーヒーを飲みます。 — Kahve içiyorum.", null, null))))),
        LearningUnit("JA-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("JA-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'家族' ne anlama gelir?", "", listOf("anne", "ağabey", "aile"), listOf("aile"), "家族は大きいです。 — Ailem kalabalık.", null, null),
                LearningExercise("jaa1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'母' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "母は家にいます。 — Annem evde.", null, null),
                LearningExercise("jaa1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'父' ne anlama gelir?", "", listOf("baba", "ağabey", "aile"), listOf("baba"), "父はよく働きます。 — Babam çok çalışır.", null, null))),
            LearningLesson("JA-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は大きいです。", "", listOf("父", "家族", "母"), listOf("家族"), "Doğru cümle: 家族は大きいです。 — Ailem kalabalık.", null, null),
                LearningExercise("jaa1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は若いです。", "", listOf("兄", "友達", "家族"), listOf("兄"), "Doğru cümle: 兄は若いです。 — Ağabeyim genç.", null, null),
                LearningExercise("jaa1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: 彼は友達です。", "彼は友達です。", null),
                LearningExercise("jaa1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "兄は若いです。", listOf("Ağabeyim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null))),
            LearningLesson("JA-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "これは私___本です。", "", listOf("の", "を", "が"), listOf("の"), "Sahiplik edatı: の.", null, null),
                LearningExercise("jaa1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 母は家にいます。", "", listOf(), listOf("母は家にいます。"), "Türkçesi: Annem evde.", "母は家にいます。", "母は家にいます。"),
                LearningExercise("jaa1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baba' ifadesinin Japonca karşılığı hangisi?", "", listOf("友達", "父", "家族"), listOf("父"), "Örnek: 父はよく働きます。 — Babam çok çalışır.", null, null))))),
        LearningUnit("JA-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("JA-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'家' ne anlama gelir?", "", listOf("satın alırım", "ev", "iş"), listOf("ev"), "家は古いです。 — Ev eski.", null, null),
                LearningExercise("jaa1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'仕事' ne anlama gelir?", "", listOf("iş", "şehir / kasaba", "oturuyorum"), listOf("iş"), "仕事に行きます。 — İşe gidiyorum.", null, null),
                LearningExercise("jaa1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'町' ne anlama gelir?", "", listOf("satın alırım", "ev", "şehir / kasaba"), listOf("şehir / kasaba"), "町はきれいです。 — Şehir güzel.", null, null))),
            LearningLesson("JA-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は古いです。", "", listOf("家", "仕事", "町"), listOf("家"), "Doğru cümle: 家は古いです。 — Ev eski.", null, null),
                LearningExercise("jaa1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "果物を___。", "", listOf("住んでいます", "家", "買います"), listOf("買います"), "Doğru cümle: 果物を買います。 — Meyve alıyorum.", null, null),
                LearningExercise("jaa1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Tokyo'da oturuyorum.", "Ev eski."), listOf("Tokyo'da oturuyorum."), "Söylenen cümle: 東京に住んでいます。", "東京に住んでいます。", null),
                LearningExercise("jaa1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "果物を買います。", listOf("İşe gidiyorum.", "Tokyo'da oturuyorum.", "Meyve alıyorum."), listOf("Meyve alıyorum."), "Cümlenin çevirisi: Meyve alıyorum.", null, null))),
            LearningLesson("JA-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "東京___住んでいます。", "", listOf("に", "を", "へ"), listOf("に"), "Yer edatı: に.", null, null),
                LearningExercise("jaa1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 仕事に行きます。", "", listOf(), listOf("仕事に行きます。"), "Türkçesi: İşe gidiyorum.", "仕事に行きます。", "仕事に行きます。"),
                LearningExercise("jaa1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'şehir / kasaba' ifadesinin Japonca karşılığı hangisi?", "", listOf("町", "家", "住んでいます"), listOf("町"), "Örnek: 町はきれいです。 — Şehir güzel.", null, null))))),
        LearningUnit("JA-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("JA-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("jaa1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'電車' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "電車は九時に来ます。 — Tren dokuzda geliyor.", null, null),
                LearningExercise("jaa1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'切符' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "切符を一枚ください。 — Bir bilet lütfen.", null, null),
                LearningExercise("jaa1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'ホテル' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "ホテルは中心にあります。 — Otel merkezde.", null, null))),
            LearningLesson("JA-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("jaa1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___は九時に来ます。", "", listOf("切符", "ホテル", "電車"), listOf("電車"), "Doğru cümle: 電車は九時に来ます。 — Tren dokuzda geliyor.", null, null),
                LearningExercise("jaa1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___に曲がってください。", "", listOf("電車", "左", "空港"), listOf("左"), "Doğru cümle: 左に曲がってください。 — Sola dönün lütfen.", null, null),
                LearningExercise("jaa1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: 空港は遠いです。", "空港は遠いです。", null),
                LearningExercise("jaa1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "左に曲がってください。", listOf("Havalimanı uzak.", "Sola dönün lütfen.", "Bir bilet lütfen."), listOf("Sola dönün lütfen."), "Cümlenin çevirisi: Sola dönün lütfen.", null, null))),
            LearningLesson("JA-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("jaa1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "切符を一枚___。", "", listOf("ください", "います", "あります"), listOf("ください"), "Rica kalıbı: ください (lütfen verin).", null, null),
                LearningExercise("jaa1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 切符を一枚ください。", "", listOf(), listOf("切符を一枚ください。"), "Türkçesi: Bir bilet lütfen.", "切符を一枚ください。", "切符を一枚ください。"),
                LearningExercise("jaa1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Japonca karşılığı hangisi?", "", listOf("電車", "空港", "ホテル"), listOf("ホテル"), "Örnek: ホテルは中心にあります。 — Otel merkezde.", null, null))))))
}
