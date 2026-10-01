package com.linguapro.android

/** Almanca (DE) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseDE {
    val units: List<LearningUnit> = listOf(
        LearningUnit("DE-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("DE-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("dea1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'Hallo' ne anlama gelir?", "", listOf("teşekkürler", "günaydın", "merhaba"), listOf("merhaba"), "Hallo, ich bin Anna. — Merhaba, ben Anna.", null, null),
                LearningExercise("dea1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'danke' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen / rica ederim"), listOf("teşekkürler"), "Danke schön! — Çok teşekkürler!", null, null),
                LearningExercise("dea1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'bitte' ne anlama gelir?", "", listOf("lütfen / rica ederim", "günaydın", "merhaba"), listOf("lütfen / rica ederim"), "Einen Kaffee, bitte. — Bir kahve, lütfen.", null, null))),
            LearningLesson("DE-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("dea1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, ich bin Anna.", "", listOf("bitte", "Hallo", "danke"), listOf("Hallo"), "Doğru cümle: Hallo, ich bin Anna. — Merhaba, ben Anna.", null, null),
                LearningExercise("dea1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, Herr Schmidt.", "", listOf("Guten Morgen", "ich heiße", "Hallo"), listOf("Guten Morgen"), "Doğru cümle: Guten Morgen, Herr Schmidt. — Günaydın Bay Schmidt.", null, null),
                LearningExercise("dea1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Bir kahve, lütfen.", "Benim adım Mehmet."), listOf("Benim adım Mehmet."), "Söylenen cümle: Ich heiße Mehmet.", "Ich heiße Mehmet.", null),
                LearningExercise("dea1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Guten Morgen, Herr Schmidt.", listOf("Günaydın Bay Schmidt.", "Çok teşekkürler!", "Benim adım Mehmet."), listOf("Günaydın Bay Schmidt."), "Cümlenin çevirisi: Günaydın Bay Schmidt.", null, null))),
            LearningLesson("DE-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("dea1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Ich ___ aus der Türkei.", "", listOf("komme", "kommst", "kommt"), listOf("komme"), "Ich öznesiyle fiil -e takısı alır: ich komme.", null, null),
                LearningExercise("dea1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Danke schön!", "", listOf(), listOf("Danke schön!"), "Türkçesi: Çok teşekkürler!", "Danke schön!", "Danke schön!"),
                LearningExercise("dea1u1e9", Skill.WRITING, "Cümleyi Almanca yaz", "Karşılığını yaz: Bir kahve, lütfen.", "", listOf(), listOf("Einen Kaffee, bitte."), "Örnek yanıt: Einen Kaffee, bitte.", null, "Einen Kaffee, bitte."))))),
        LearningUnit("DE-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("DE-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("dea1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'zwei' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "Ich habe zwei Brüder. — İki erkek kardeşim var.", null, null),
                LearningExercise("dea1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'zehn' ne anlama gelir?", "", listOf("on", "bugün", "saat"), listOf("on"), "Es ist zehn Uhr. — Saat on.", null, null),
                LearningExercise("dea1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'heute' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "Heute ist Montag. — Bugün pazartesi.", null, null))),
            LearningLesson("DE-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("dea1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Ich habe ___ Brüder.", "", listOf("zwei", "zehn", "heute"), listOf("zwei"), "Doğru cümle: Ich habe zwei Brüder. — İki erkek kardeşim var.", null, null),
                LearningExercise("dea1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Bis ___!", "", listOf("Uhr", "zwei", "morgen"), listOf("morgen"), "Doğru cümle: Bis morgen! — Yarın görüşürüz!", null, null),
                LearningExercise("dea1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaç?", "İki erkek kardeşim var."), listOf("Saat kaç?"), "Söylenen cümle: Wie viel Uhr ist es?", "Wie viel Uhr ist es?", null),
                LearningExercise("dea1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Bis morgen!", listOf("Saat on.", "Saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("DE-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("dea1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Wie ___ Uhr ist es?", "", listOf("viel", "viele", "mehr"), listOf("viel"), "Saat sorma kalıbı: Wie viel Uhr ist es?", null, null),
                LearningExercise("dea1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Es ist zehn Uhr.", "", listOf(), listOf("Es ist zehn Uhr."), "Türkçesi: Saat on.", "Es ist zehn Uhr.", "Es ist zehn Uhr."),
                LearningExercise("dea1u2e9", Skill.WRITING, "Cümleyi Almanca yaz", "Karşılığını yaz: Bugün pazartesi.", "", listOf(), listOf("Heute ist Montag."), "Örnek yanıt: Heute ist Montag.", null, "Heute ist Montag."))))),
        LearningUnit("DE-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("DE-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("dea1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'Wasser' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "Ein Wasser, bitte. — Bir su, lütfen.", null, null),
                LearningExercise("dea1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'Brot' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "Das Brot ist frisch. — Ekmek taze.", null, null),
                LearningExercise("dea1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'Kaffee' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "Ich trinke Kaffee. — Kahve içiyorum.", null, null))),
            LearningLesson("DE-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("dea1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Ein ___, bitte.", "", listOf("Brot", "Kaffee", "Wasser"), listOf("Wasser"), "Doğru cümle: Ein Wasser, bitte. — Bir su, lütfen.", null, null),
                LearningExercise("dea1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Der ___ ist rot.", "", listOf("Wasser", "Apfel", "Tee"), listOf("Apfel"), "Doğru cümle: Der Apfel ist rot. — Elma kırmızı.", null, null),
                LearningExercise("dea1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çay sıcak.", "Bir su, lütfen.", "Kahve içiyorum."), listOf("Çay sıcak."), "Söylenen cümle: Der Tee ist heiß.", "Der Tee ist heiß.", null),
                LearningExercise("dea1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Der Apfel ist rot.", listOf("Çay sıcak.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("DE-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("dea1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Ich ___ gern Tee.", "", listOf("trinke", "trinkst", "trinkt"), listOf("trinke"), "Ich öznesiyle: ich trinke.", null, null),
                LearningExercise("dea1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Das Brot ist frisch.", "", listOf(), listOf("Das Brot ist frisch."), "Türkçesi: Ekmek taze.", "Das Brot ist frisch.", "Das Brot ist frisch."),
                LearningExercise("dea1u3e9", Skill.WRITING, "Cümleyi Almanca yaz", "Karşılığını yaz: Kahve içiyorum.", "", listOf(), listOf("Ich trinke Kaffee."), "Örnek yanıt: Ich trinke Kaffee.", null, "Ich trinke Kaffee."))))),
        LearningUnit("DE-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("DE-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("dea1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'Familie' ne anlama gelir?", "", listOf("anne", "erkek kardeş", "aile"), listOf("aile"), "Meine Familie ist groß. — Ailem kalabalık.", null, null),
                LearningExercise("dea1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'Mutter' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "Meine Mutter ist zu Hause. — Annem evde.", null, null),
                LearningExercise("dea1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'Vater' ne anlama gelir?", "", listOf("baba", "erkek kardeş", "aile"), listOf("baba"), "Mein Vater arbeitet viel. — Babam çok çalışır.", null, null))),
            LearningLesson("DE-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("dea1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Meine ___ ist groß.", "", listOf("Vater", "Familie", "Mutter"), listOf("Familie"), "Doğru cümle: Meine Familie ist groß. — Ailem kalabalık.", null, null),
                LearningExercise("dea1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Mein ___ ist jung.", "", listOf("Bruder", "Freund", "Familie"), listOf("Bruder"), "Doğru cümle: Mein Bruder ist jung. — Erkek kardeşim genç.", null, null),
                LearningExercise("dea1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: Er ist mein Freund.", "Er ist mein Freund.", null),
                LearningExercise("dea1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Mein Bruder ist jung.", listOf("Erkek kardeşim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Erkek kardeşim genç."), "Cümlenin çevirisi: Erkek kardeşim genç.", null, null))),
            LearningLesson("DE-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("dea1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Das ist ___ Schwester.", "", listOf("meine", "mein", "meiner"), listOf("meine"), "Dişil isimle: meine Schwester.", null, null),
                LearningExercise("dea1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Meine Mutter ist zu Hause.", "", listOf(), listOf("Meine Mutter ist zu Hause."), "Türkçesi: Annem evde.", "Meine Mutter ist zu Hause.", "Meine Mutter ist zu Hause."),
                LearningExercise("dea1u4e9", Skill.WRITING, "Cümleyi Almanca yaz", "Karşılığını yaz: Babam çok çalışır.", "", listOf(), listOf("Mein Vater arbeitet viel."), "Örnek yanıt: Mein Vater arbeitet viel.", null, "Mein Vater arbeitet viel."))))),
        LearningUnit("DE-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("DE-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("dea1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'Haus' ne anlama gelir?", "", listOf("mağaza", "ev", "iş"), listOf("ev"), "Das Haus ist alt. — Ev eski.", null, null),
                LearningExercise("dea1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'Arbeit' ne anlama gelir?", "", listOf("iş", "şehir", "oturuyorum"), listOf("iş"), "Die Arbeit beginnt um neun. — İş dokuzda başlıyor.", null, null),
                LearningExercise("dea1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'Stadt' ne anlama gelir?", "", listOf("mağaza", "ev", "şehir"), listOf("şehir"), "Die Stadt ist schön. — Şehir güzel.", null, null))),
            LearningLesson("DE-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("dea1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Das ___ ist alt.", "", listOf("Haus", "Arbeit", "Stadt"), listOf("Haus"), "Doğru cümle: Das Haus ist alt. — Ev eski.", null, null),
                LearningExercise("dea1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Das ___ ist offen.", "", listOf("ich wohne", "Haus", "Geschäft"), listOf("Geschäft"), "Doğru cümle: Das Geschäft ist offen. — Mağaza açık.", null, null),
                LearningExercise("dea1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Berlin'de oturuyorum.", "Ev eski."), listOf("Berlin'de oturuyorum."), "Söylenen cümle: Ich wohne in Berlin.", "Ich wohne in Berlin.", null),
                LearningExercise("dea1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Das Geschäft ist offen.", listOf("İş dokuzda başlıyor.", "Berlin'de oturuyorum.", "Mağaza açık."), listOf("Mağaza açık."), "Cümlenin çevirisi: Mağaza açık.", null, null))),
            LearningLesson("DE-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("dea1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Wo ___ du?", "", listOf("wohnst", "wohne", "wohnt"), listOf("wohnst"), "Du öznesiyle: du wohnst.", null, null),
                LearningExercise("dea1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Die Arbeit beginnt um neun.", "", listOf(), listOf("Die Arbeit beginnt um neun."), "Türkçesi: İş dokuzda başlıyor.", "Die Arbeit beginnt um neun.", "Die Arbeit beginnt um neun."),
                LearningExercise("dea1u5e9", Skill.WRITING, "Cümleyi Almanca yaz", "Karşılığını yaz: Şehir güzel.", "", listOf(), listOf("Die Stadt ist schön."), "Örnek yanıt: Die Stadt ist schön.", null, "Die Stadt ist schön."))))),
        LearningUnit("DE-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("DE-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("dea1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'Zug' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "Der Zug kommt um neun. — Tren dokuzda geliyor.", null, null),
                LearningExercise("dea1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'Ticket' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "Ein Ticket nach Berlin, bitte. — Berlin'e bir bilet, lütfen.", null, null),
                LearningExercise("dea1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'Hotel' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "Das Hotel ist im Zentrum. — Otel merkezde.", null, null))),
            LearningLesson("DE-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("dea1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Der ___ kommt um neun.", "", listOf("Ticket", "Hotel", "Zug"), listOf("Zug"), "Doğru cümle: Der Zug kommt um neun. — Tren dokuzda geliyor.", null, null),
                LearningExercise("dea1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Gehen Sie ___.", "", listOf("Zug", "links", "Flughafen"), listOf("links"), "Doğru cümle: Gehen Sie links. — Sola gidin.", null, null),
                LearningExercise("dea1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: Der Flughafen ist weit.", "Der Flughafen ist weit.", null),
                LearningExercise("dea1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Gehen Sie links.", listOf("Havalimanı uzak.", "Sola gidin.", "Berlin'e bir bilet, lütfen."), listOf("Sola gidin."), "Cümlenin çevirisi: Sola gidin.", null, null))),
            LearningLesson("DE-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("dea1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Wann fährt der Zug ___?", "", listOf("ab", "an", "auf"), listOf("ab"), "Ayrılabilir fiil abfahren: Wann fährt der Zug ab?", null, null),
                LearningExercise("dea1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Ein Ticket nach Berlin, bitte.", "", listOf(), listOf("Ein Ticket nach Berlin, bitte."), "Türkçesi: Berlin'e bir bilet, lütfen.", "Ein Ticket nach Berlin, bitte.", "Ein Ticket nach Berlin, bitte."),
                LearningExercise("dea1u6e9", Skill.WRITING, "Cümleyi Almanca yaz", "Karşılığını yaz: Otel merkezde.", "", listOf(), listOf("Das Hotel ist im Zentrum."), "Örnek yanıt: Das Hotel ist im Zentrum.", null, "Das Hotel ist im Zentrum."))))))
}
