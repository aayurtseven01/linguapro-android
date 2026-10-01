package com.linguapro.android

/** Portekizce (PT) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCoursePT {
    val units: List<LearningUnit> = listOf(
        LearningUnit("PT-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("PT-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("pta1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'olá' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "Olá, eu sou a Ana. — Merhaba, ben Ana.", null, null),
                LearningExercise("pta1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'obrigado' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen"), listOf("teşekkürler"), "Muito obrigado! — Çok teşekkürler!", null, null),
                LearningExercise("pta1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'por favor' ne anlama gelir?", "", listOf("lütfen", "hoşça kal", "merhaba"), listOf("lütfen"), "Um café, por favor. — Bir kahve, lütfen.", null, null))),
            LearningLesson("PT-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("pta1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, eu sou a Ana.", "", listOf("por favor", "Olá", "obrigado"), listOf("Olá"), "Doğru cümle: Olá, eu sou a Ana. — Merhaba, ben Ana.", null, null),
                LearningExercise("pta1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, até amanhã!", "", listOf("Adeus", "me chamo", "olá"), listOf("Adeus"), "Doğru cümle: Adeus, até amanhã! — Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("pta1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Ana.", "Bir kahve, lütfen.", "Benim adım Mehmet."), listOf("Benim adım Mehmet."), "Söylenen cümle: Me chamo Mehmet.", "Me chamo Mehmet.", null),
                LearningExercise("pta1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Adeus, até amanhã!", listOf("Hoşça kal, yarın görüşürüz!", "Çok teşekkürler!", "Benim adım Mehmet."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("PT-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("pta1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Eu ___ da Turquia.", "", listOf("sou", "és", "é"), listOf("sou"), "Eu öznesiyle ser: eu sou.", null, null),
                LearningExercise("pta1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Muito obrigado!", "", listOf(), listOf("Muito obrigado!"), "Türkçesi: Çok teşekkürler!", "Muito obrigado!", "Muito obrigado!"),
                LearningExercise("pta1u1e9", Skill.WRITING, "Cümleyi Portekizce yaz", "Karşılığını yaz: Bir kahve, lütfen.", "", listOf(), listOf("Um café, por favor."), "Örnek yanıt: Um café, por favor.", null, "Um café, por favor."))))),
        LearningUnit("PT-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("PT-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("pta1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'dois' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "Tenho dois irmãos. — İki erkek kardeşim var.", null, null),
                LearningExercise("pta1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'dez' ne anlama gelir?", "", listOf("on", "bugün", "saat"), listOf("on"), "São dez horas. — Saat on.", null, null),
                LearningExercise("pta1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'hoje' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "Hoje é segunda-feira. — Bugün pazartesi.", null, null))),
            LearningLesson("PT-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("pta1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Tenho ___ irmãos.", "", listOf("dois", "dez", "hoje"), listOf("dois"), "Doğru cümle: Tenho dois irmãos. — İki erkek kardeşim var.", null, null),
                LearningExercise("pta1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Até ___!", "", listOf("hora", "dois", "amanhã"), listOf("amanhã"), "Doğru cümle: Até amanhã! — Yarın görüşürüz!", null, null),
                LearningExercise("pta1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaçta başlıyor?", "İki erkek kardeşim var."), listOf("Saat kaçta başlıyor?"), "Söylenen cümle: A que hora começa?", "A que hora começa?", null),
                LearningExercise("pta1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Até amanhã!", listOf("Saat on.", "Saat kaçta başlıyor?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("PT-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("pta1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Que ___ são?", "", listOf("horas", "hora", "tempo"), listOf("horas"), "Saat sorma: Que horas são?", null, null),
                LearningExercise("pta1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: São dez horas.", "", listOf(), listOf("São dez horas."), "Türkçesi: Saat on.", "São dez horas.", "São dez horas."),
                LearningExercise("pta1u2e9", Skill.WRITING, "Cümleyi Portekizce yaz", "Karşılığını yaz: Bugün pazartesi.", "", listOf(), listOf("Hoje é segunda-feira."), "Örnek yanıt: Hoje é segunda-feira.", null, "Hoje é segunda-feira."))))),
        LearningUnit("PT-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("PT-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("pta1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'água' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "Uma água, por favor. — Bir su, lütfen.", null, null),
                LearningExercise("pta1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'pão' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "O pão está fresco. — Ekmek taze.", null, null),
                LearningExercise("pta1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'café' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "Bebo um café. — Bir kahve içiyorum.", null, null))),
            LearningLesson("PT-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("pta1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Uma ___, por favor.", "", listOf("pão", "café", "água"), listOf("água"), "Doğru cümle: Uma água, por favor. — Bir su, lütfen.", null, null),
                LearningExercise("pta1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "A ___ é vermelha.", "", listOf("água", "maçã", "chá"), listOf("maçã"), "Doğru cümle: A maçã é vermelha. — Elma kırmızı.", null, null),
                LearningExercise("pta1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çay sıcak.", "Bir su, lütfen.", "Bir kahve içiyorum."), listOf("Çay sıcak."), "Söylenen cümle: O chá está quente.", "O chá está quente.", null),
                LearningExercise("pta1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "A maçã é vermelha.", listOf("Çay sıcak.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("PT-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("pta1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Eu ___ chá.", "", listOf("bebo", "bebes", "bebe"), listOf("bebo"), "Eu öznesiyle beber: bebo.", null, null),
                LearningExercise("pta1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: O pão está fresco.", "", listOf(), listOf("O pão está fresco."), "Türkçesi: Ekmek taze.", "O pão está fresco.", "O pão está fresco."),
                LearningExercise("pta1u3e9", Skill.WRITING, "Cümleyi Portekizce yaz", "Karşılığını yaz: Bir kahve içiyorum.", "", listOf(), listOf("Bebo um café."), "Örnek yanıt: Bebo um café.", null, "Bebo um café."))))),
        LearningUnit("PT-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("PT-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("pta1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'família' ne anlama gelir?", "", listOf("anne", "erkek kardeş", "aile"), listOf("aile"), "Minha família é grande. — Ailem kalabalık.", null, null),
                LearningExercise("pta1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'mãe' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "Minha mãe está em casa. — Annem evde.", null, null),
                LearningExercise("pta1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'pai' ne anlama gelir?", "", listOf("baba", "erkek kardeş", "aile"), listOf("baba"), "Meu pai trabalha muito. — Babam çok çalışır.", null, null))),
            LearningLesson("PT-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("pta1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Minha ___ é grande.", "", listOf("pai", "família", "mãe"), listOf("família"), "Doğru cümle: Minha família é grande. — Ailem kalabalık.", null, null),
                LearningExercise("pta1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Meu ___ é jovem.", "", listOf("irmão", "amigo", "família"), listOf("irmão"), "Doğru cümle: Meu irmão é jovem. — Erkek kardeşim genç.", null, null),
                LearningExercise("pta1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: Ele é meu amigo.", "Ele é meu amigo.", null),
                LearningExercise("pta1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Meu irmão é jovem.", listOf("Erkek kardeşim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Erkek kardeşim genç."), "Cümlenin çevirisi: Erkek kardeşim genç.", null, null))),
            LearningLesson("PT-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("pta1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Esta é ___ irmã.", "", listOf("minha", "meu", "meus"), listOf("minha"), "Dişil isimle: minha irmã.", null, null),
                LearningExercise("pta1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Minha mãe está em casa.", "", listOf(), listOf("Minha mãe está em casa."), "Türkçesi: Annem evde.", "Minha mãe está em casa.", "Minha mãe está em casa."),
                LearningExercise("pta1u4e9", Skill.WRITING, "Cümleyi Portekizce yaz", "Karşılığını yaz: Babam çok çalışır.", "", listOf(), listOf("Meu pai trabalha muito."), "Örnek yanıt: Meu pai trabalha muito.", null, "Meu pai trabalha muito."))))),
        LearningUnit("PT-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("PT-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("pta1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'casa' ne anlama gelir?", "", listOf("mağaza", "ev", "iş"), listOf("ev"), "A casa é velha. — Ev eski.", null, null),
                LearningExercise("pta1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'trabalho' ne anlama gelir?", "", listOf("iş", "şehir", "oturuyorum"), listOf("iş"), "O trabalho começa às nove. — İş dokuzda başlıyor.", null, null),
                LearningExercise("pta1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'cidade' ne anlama gelir?", "", listOf("mağaza", "ev", "şehir"), listOf("şehir"), "A cidade é bonita. — Şehir güzel.", null, null))),
            LearningLesson("PT-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("pta1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "A ___ é velha.", "", listOf("casa", "trabalho", "cidade"), listOf("casa"), "Doğru cümle: A casa é velha. — Ev eski.", null, null),
                LearningExercise("pta1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "A ___ está aberta.", "", listOf("moro", "casa", "loja"), listOf("loja"), "Doğru cümle: A loja está aberta. — Mağaza açık.", null, null),
                LearningExercise("pta1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Lizbon'da oturuyorum.", "Ev eski."), listOf("Lizbon'da oturuyorum."), "Söylenen cümle: Moro em Lisboa.", "Moro em Lisboa.", null),
                LearningExercise("pta1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "A loja está aberta.", listOf("İş dokuzda başlıyor.", "Lizbon'da oturuyorum.", "Mağaza açık."), listOf("Mağaza açık."), "Cümlenin çevirisi: Mağaza açık.", null, null))),
            LearningLesson("PT-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("pta1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Onde você ___?", "", listOf("mora", "moro", "moram"), listOf("mora"), "Você öznesiyle morar: mora.", null, null),
                LearningExercise("pta1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: O trabalho começa às nove.", "", listOf(), listOf("O trabalho começa às nove."), "Türkçesi: İş dokuzda başlıyor.", "O trabalho começa às nove.", "O trabalho começa às nove."),
                LearningExercise("pta1u5e9", Skill.WRITING, "Cümleyi Portekizce yaz", "Karşılığını yaz: Şehir güzel.", "", listOf(), listOf("A cidade é bonita."), "Örnek yanıt: A cidade é bonita.", null, "A cidade é bonita."))))),
        LearningUnit("PT-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("PT-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("pta1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'trem' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "O trem chega às nove. — Tren dokuzda geliyor.", null, null),
                LearningExercise("pta1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'bilhete' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "Um bilhete para Lisboa, por favor. — Lizbon'a bir bilet, lütfen.", null, null),
                LearningExercise("pta1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'hotel' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "O hotel fica no centro. — Otel merkezde.", null, null))),
            LearningLesson("PT-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("pta1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "O ___ chega às nove.", "", listOf("bilhete", "hotel", "trem"), listOf("trem"), "Doğru cümle: O trem chega às nove. — Tren dokuzda geliyor.", null, null),
                LearningExercise("pta1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Vire à ___.", "", listOf("trem", "esquerda", "aeroporto"), listOf("esquerda"), "Doğru cümle: Vire à esquerda. — Sola dönün.", null, null),
                LearningExercise("pta1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: O aeroporto é longe.", "O aeroporto é longe.", null),
                LearningExercise("pta1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Vire à esquerda.", listOf("Havalimanı uzak.", "Sola dönün.", "Lizbon'a bir bilet, lütfen."), listOf("Sola dönün."), "Cümlenin çevirisi: Sola dönün.", null, null))),
            LearningLesson("PT-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("pta1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "O trem sai ___ nove horas.", "", listOf("às", "de", "em"), listOf("às"), "Saat belirtirken: às nove horas.", null, null),
                LearningExercise("pta1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Um bilhete para Lisboa, por favor.", "", listOf(), listOf("Um bilhete para Lisboa, por favor."), "Türkçesi: Lizbon'a bir bilet, lütfen.", "Um bilhete para Lisboa, por favor.", "Um bilhete para Lisboa, por favor."),
                LearningExercise("pta1u6e9", Skill.WRITING, "Cümleyi Portekizce yaz", "Karşılığını yaz: Otel merkezde.", "", listOf(), listOf("O hotel fica no centro."), "Örnek yanıt: O hotel fica no centro.", null, "O hotel fica no centro."))))))
}
