package com.linguapro.android

/** İtalyanca (IT) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseIT {
    val units: List<LearningUnit> = listOf(
        LearningUnit("IT-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("IT-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("ita1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'ciao' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "Ciao, sono Anna. — Merhaba, ben Anna.", null, null),
                LearningExercise("ita1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'grazie' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen"), listOf("teşekkürler"), "Grazie mille! — Çok teşekkürler!", null, null),
                LearningExercise("ita1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'per favore' ne anlama gelir?", "", listOf("lütfen", "hoşça kal", "merhaba"), listOf("lütfen"), "Un caffè, per favore. — Bir kahve, lütfen.", null, null))),
            LearningLesson("IT-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("ita1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, sono Anna.", "", listOf("per favore", "Ciao", "grazie"), listOf("Ciao"), "Doğru cümle: Ciao, sono Anna. — Merhaba, ben Anna.", null, null),
                LearningExercise("ita1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, a domani!", "", listOf("Arrivederci", "mi chiamo", "ciao"), listOf("Arrivederci"), "Doğru cümle: Arrivederci, a domani! — Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("ita1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Bir kahve, lütfen.", "Benim adım Mehmet."), listOf("Benim adım Mehmet."), "Söylenen cümle: Mi chiamo Mehmet.", "Mi chiamo Mehmet.", null),
                LearningExercise("ita1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Arrivederci, a domani!", listOf("Hoşça kal, yarın görüşürüz!", "Çok teşekkürler!", "Benim adım Mehmet."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("IT-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("ita1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Io ___ della Turchia.", "", listOf("sono", "sei", "è"), listOf("sono"), "Io öznesiyle essere: io sono.", null, null),
                LearningExercise("ita1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Grazie mille!", "", listOf(), listOf("Grazie mille!"), "Türkçesi: Çok teşekkürler!", "Grazie mille!", "Grazie mille!"),
                LearningExercise("ita1u1e9", Skill.WRITING, "Cümleyi İtalyanca yaz", "Karşılığını yaz: Bir kahve, lütfen.", "", listOf(), listOf("Un caffè, per favore."), "Örnek yanıt: Un caffè, per favore.", null, "Un caffè, per favore."))))),
        LearningUnit("IT-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("IT-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("ita1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'due' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "Ho due fratelli. — İki erkek kardeşim var.", null, null),
                LearningExercise("ita1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'dieci' ne anlama gelir?", "", listOf("on", "bugün", "saat"), listOf("on"), "Sono le dieci. — Saat on.", null, null),
                LearningExercise("ita1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'oggi' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "Oggi è lunedì. — Bugün pazartesi.", null, null))),
            LearningLesson("IT-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("ita1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Ho ___ fratelli.", "", listOf("due", "dieci", "oggi"), listOf("due"), "Doğru cümle: Ho due fratelli. — İki erkek kardeşim var.", null, null),
                LearningExercise("ita1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "A ___!", "", listOf("ora", "due", "domani"), listOf("domani"), "Doğru cümle: A domani! — Yarın görüşürüz!", null, null),
                LearningExercise("ita1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaç?", "İki erkek kardeşim var."), listOf("Saat kaç?"), "Söylenen cümle: Che ora è?", "Che ora è?", null),
                LearningExercise("ita1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "A domani!", listOf("Saat on.", "Saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("IT-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("ita1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Che ___ è?", "", listOf("ora", "ore", "tempo"), listOf("ora"), "Saat sorma: Che ora è?", null, null),
                LearningExercise("ita1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Sono le dieci.", "", listOf(), listOf("Sono le dieci."), "Türkçesi: Saat on.", "Sono le dieci.", "Sono le dieci."),
                LearningExercise("ita1u2e9", Skill.WRITING, "Cümleyi İtalyanca yaz", "Karşılığını yaz: Bugün pazartesi.", "", listOf(), listOf("Oggi è lunedì."), "Örnek yanıt: Oggi è lunedì.", null, "Oggi è lunedì."))))),
        LearningUnit("IT-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("IT-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("ita1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'acqua' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "Un bicchiere di acqua, per favore. — Bir bardak su, lütfen.", null, null),
                LearningExercise("ita1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'pane' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "Il pane è fresco. — Ekmek taze.", null, null),
                LearningExercise("ita1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'caffè' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "Bevo un caffè. — Bir kahve içiyorum.", null, null))),
            LearningLesson("IT-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("ita1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Un bicchiere di ___, per favore.", "", listOf("pane", "caffè", "acqua"), listOf("acqua"), "Doğru cümle: Un bicchiere di acqua, per favore. — Bir bardak su, lütfen.", null, null),
                LearningExercise("ita1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "La ___ è rossa.", "", listOf("acqua", "mela", "tè"), listOf("mela"), "Doğru cümle: La mela è rossa. — Elma kırmızı.", null, null),
                LearningExercise("ita1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çay sıcak.", "Bir bardak su, lütfen.", "Bir kahve içiyorum."), listOf("Çay sıcak."), "Söylenen cümle: Il tè è caldo.", "Il tè è caldo.", null),
                LearningExercise("ita1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "La mela è rossa.", listOf("Çay sıcak.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("IT-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("ita1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Io ___ il tè.", "", listOf("bevo", "bevi", "beve"), listOf("bevo"), "Io öznesiyle bere: bevo.", null, null),
                LearningExercise("ita1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Il pane è fresco.", "", listOf(), listOf("Il pane è fresco."), "Türkçesi: Ekmek taze.", "Il pane è fresco.", "Il pane è fresco."),
                LearningExercise("ita1u3e9", Skill.WRITING, "Cümleyi İtalyanca yaz", "Karşılığını yaz: Bir kahve içiyorum.", "", listOf(), listOf("Bevo un caffè."), "Örnek yanıt: Bevo un caffè.", null, "Bevo un caffè."))))),
        LearningUnit("IT-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("IT-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("ita1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'famiglia' ne anlama gelir?", "", listOf("anne", "erkek kardeş", "aile"), listOf("aile"), "La mia famiglia è grande. — Ailem kalabalık.", null, null),
                LearningExercise("ita1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'madre' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "Mia madre è a casa. — Annem evde.", null, null),
                LearningExercise("ita1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'padre' ne anlama gelir?", "", listOf("baba", "erkek kardeş", "aile"), listOf("baba"), "Mio padre lavora molto. — Babam çok çalışır.", null, null))),
            LearningLesson("IT-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("ita1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "La mia ___ è grande.", "", listOf("padre", "famiglia", "madre"), listOf("famiglia"), "Doğru cümle: La mia famiglia è grande. — Ailem kalabalık.", null, null),
                LearningExercise("ita1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Mio ___ è giovane.", "", listOf("fratello", "amico", "famiglia"), listOf("fratello"), "Doğru cümle: Mio fratello è giovane. — Erkek kardeşim genç.", null, null),
                LearningExercise("ita1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: È il mio amico.", "È il mio amico.", null),
                LearningExercise("ita1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Mio fratello è giovane.", listOf("Erkek kardeşim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Erkek kardeşim genç."), "Cümlenin çevirisi: Erkek kardeşim genç.", null, null))),
            LearningLesson("IT-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("ita1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Questa è ___ sorella.", "", listOf("mia", "mio", "mie"), listOf("mia"), "Dişil tekil: mia sorella.", null, null),
                LearningExercise("ita1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Mia madre è a casa.", "", listOf(), listOf("Mia madre è a casa."), "Türkçesi: Annem evde.", "Mia madre è a casa.", "Mia madre è a casa."),
                LearningExercise("ita1u4e9", Skill.WRITING, "Cümleyi İtalyanca yaz", "Karşılığını yaz: Babam çok çalışır.", "", listOf(), listOf("Mio padre lavora molto."), "Örnek yanıt: Mio padre lavora molto.", null, "Mio padre lavora molto."))))),
        LearningUnit("IT-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("IT-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("ita1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'casa' ne anlama gelir?", "", listOf("mağaza", "ev", "iş"), listOf("ev"), "La casa è vecchia. — Ev eski.", null, null),
                LearningExercise("ita1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'lavoro' ne anlama gelir?", "", listOf("iş", "şehir", "oturuyorum"), listOf("iş"), "Il lavoro comincia alle nove. — İş dokuzda başlıyor.", null, null),
                LearningExercise("ita1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'città' ne anlama gelir?", "", listOf("mağaza", "ev", "şehir"), listOf("şehir"), "La città è bella. — Şehir güzel.", null, null))),
            LearningLesson("IT-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("ita1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "La ___ è vecchia.", "", listOf("casa", "lavoro", "città"), listOf("casa"), "Doğru cümle: La casa è vecchia. — Ev eski.", null, null),
                LearningExercise("ita1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Il ___ è aperto.", "", listOf("abito", "casa", "negozio"), listOf("negozio"), "Doğru cümle: Il negozio è aperto. — Mağaza açık.", null, null),
                LearningExercise("ita1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Roma'da oturuyorum.", "Ev eski."), listOf("Roma'da oturuyorum."), "Söylenen cümle: Abito a Roma.", "Abito a Roma.", null),
                LearningExercise("ita1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Il negozio è aperto.", listOf("İş dokuzda başlıyor.", "Roma'da oturuyorum.", "Mağaza açık."), listOf("Mağaza açık."), "Cümlenin çevirisi: Mağaza açık.", null, null))),
            LearningLesson("IT-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("ita1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Dove ___ tu?", "", listOf("abiti", "abito", "abita"), listOf("abiti"), "Tu öznesiyle abitare: abiti.", null, null),
                LearningExercise("ita1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Il lavoro comincia alle nove.", "", listOf(), listOf("Il lavoro comincia alle nove."), "Türkçesi: İş dokuzda başlıyor.", "Il lavoro comincia alle nove.", "Il lavoro comincia alle nove."),
                LearningExercise("ita1u5e9", Skill.WRITING, "Cümleyi İtalyanca yaz", "Karşılığını yaz: Şehir güzel.", "", listOf(), listOf("La città è bella."), "Örnek yanıt: La città è bella.", null, "La città è bella."))))),
        LearningUnit("IT-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("IT-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("ita1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'treno' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "Il treno arriva alle nove. — Tren dokuzda geliyor.", null, null),
                LearningExercise("ita1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'biglietto' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "Un biglietto per Roma, per favore. — Roma'ya bir bilet, lütfen.", null, null),
                LearningExercise("ita1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'albergo' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "L'albergo è in centro. — Otel merkezde.", null, null))),
            LearningLesson("IT-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("ita1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Il ___ arriva alle nove.", "", listOf("biglietto", "albergo", "treno"), listOf("treno"), "Doğru cümle: Il treno arriva alle nove. — Tren dokuzda geliyor.", null, null),
                LearningExercise("ita1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Giri a ___.", "", listOf("treno", "sinistra", "aeroporto"), listOf("sinistra"), "Doğru cümle: Giri a sinistra. — Sola dönün.", null, null),
                LearningExercise("ita1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: L'aeroporto è lontano.", "L'aeroporto è lontano.", null),
                LearningExercise("ita1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Giri a sinistra.", listOf("Havalimanı uzak.", "Sola dönün.", "Roma'ya bir bilet, lütfen."), listOf("Sola dönün."), "Cümlenin çevirisi: Sola dönün.", null, null))),
            LearningLesson("IT-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("ita1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Il treno parte ___ nove.", "", listOf("alle", "a", "in"), listOf("alle"), "Saat belirtirken: alle nove.", null, null),
                LearningExercise("ita1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Un biglietto per Roma, per favore.", "", listOf(), listOf("Un biglietto per Roma, per favore."), "Türkçesi: Roma'ya bir bilet, lütfen.", "Un biglietto per Roma, per favore.", "Un biglietto per Roma, per favore."),
                LearningExercise("ita1u6e9", Skill.WRITING, "Cümleyi İtalyanca yaz", "Karşılığını yaz: Otel merkezde.", "", listOf(), listOf("L'albergo è in centro."), "Örnek yanıt: L'albergo è in centro.", null, "L'albergo è in centro."))))))
}
