package com.linguapro.android

/** İspanyolca (ES) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseES {
    val units: List<LearningUnit> = listOf(
        LearningUnit("ES-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("ES-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("esa1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'hola' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "¡Hola! Soy Ana. — Merhaba! Ben Ana.", null, null),
                LearningExercise("esa1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'gracias' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen"), listOf("teşekkürler"), "¡Muchas gracias! — Çok teşekkürler!", null, null),
                LearningExercise("esa1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'por favor' ne anlama gelir?", "", listOf("lütfen", "hoşça kal", "merhaba"), listOf("lütfen"), "Un café, por favor. — Bir kahve, lütfen.", null, null))),
            LearningLesson("ES-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("esa1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "¡___! Soy Ana.", "", listOf("por favor", "Hola", "gracias"), listOf("Hola"), "Doğru cümle: ¡Hola! Soy Ana. — Merhaba! Ben Ana.", null, null),
                LearningExercise("esa1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, hasta mañana.", "", listOf("Adiós", "me llamo", "hola"), listOf("Adiós"), "Doğru cümle: Adiós, hasta mañana. — Hoşça kal, yarın görüşürüz.", null, null),
                LearningExercise("esa1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba! Ben Ana.", "Bir kahve, lütfen.", "Benim adım Mehmet."), listOf("Benim adım Mehmet."), "Söylenen cümle: Me llamo Mehmet.", "Me llamo Mehmet.", null),
                LearningExercise("esa1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Adiós, hasta mañana.", listOf("Hoşça kal, yarın görüşürüz.", "Çok teşekkürler!", "Benim adım Mehmet."), listOf("Hoşça kal, yarın görüşürüz."), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz.", null, null))),
            LearningLesson("ES-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("esa1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Yo ___ de Turquía.", "", listOf("soy", "eres", "es"), listOf("soy"), "Yo öznesiyle ser: yo soy.", null, null),
                LearningExercise("esa1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: ¡Muchas gracias!", "", listOf(), listOf("¡Muchas gracias!"), "Türkçesi: Çok teşekkürler!", "¡Muchas gracias!", "¡Muchas gracias!"),
                LearningExercise("esa1u1e9", Skill.WRITING, "Cümleyi İspanyolca yaz", "Karşılığını yaz: Bir kahve, lütfen.", "", listOf(), listOf("Un café, por favor."), "Örnek yanıt: Un café, por favor.", null, "Un café, por favor."))))),
        LearningUnit("ES-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("ES-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("esa1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'dos' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "Tengo dos hermanos. — İki erkek kardeşim var.", null, null),
                LearningExercise("esa1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'diez' ne anlama gelir?", "", listOf("on", "bugün", "saat"), listOf("on"), "Son las diez. — Saat on.", null, null),
                LearningExercise("esa1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'hoy' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "Hoy es lunes. — Bugün pazartesi.", null, null))),
            LearningLesson("ES-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("esa1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Tengo ___ hermanos.", "", listOf("dos", "diez", "hoy"), listOf("dos"), "Doğru cümle: Tengo dos hermanos. — İki erkek kardeşim var.", null, null),
                LearningExercise("esa1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "¡Hasta ___!", "", listOf("hora", "dos", "mañana"), listOf("mañana"), "Doğru cümle: ¡Hasta mañana! — Yarın görüşürüz!", null, null),
                LearningExercise("esa1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaçta başlıyor?", "İki erkek kardeşim var."), listOf("Saat kaçta başlıyor?"), "Söylenen cümle: ¿A qué hora empieza?", "¿A qué hora empieza?", null),
                LearningExercise("esa1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "¡Hasta mañana!", listOf("Saat on.", "Saat kaçta başlıyor?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("ES-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("esa1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "¿Qué ___ es?", "", listOf("hora", "horas", "tiempo"), listOf("hora"), "Saat sorma: ¿Qué hora es?", null, null),
                LearningExercise("esa1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Son las diez.", "", listOf(), listOf("Son las diez."), "Türkçesi: Saat on.", "Son las diez.", "Son las diez."),
                LearningExercise("esa1u2e9", Skill.WRITING, "Cümleyi İspanyolca yaz", "Karşılığını yaz: Bugün pazartesi.", "", listOf(), listOf("Hoy es lunes."), "Örnek yanıt: Hoy es lunes.", null, "Hoy es lunes."))))),
        LearningUnit("ES-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("ES-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("esa1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'agua' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "Un agua, por favor. — Bir su, lütfen.", null, null),
                LearningExercise("esa1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'pan' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "El pan está fresco. — Ekmek taze.", null, null),
                LearningExercise("esa1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'café' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "Bebo un café. — Bir kahve içiyorum.", null, null))),
            LearningLesson("ES-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("esa1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Un ___, por favor.", "", listOf("pan", "café", "agua"), listOf("agua"), "Doğru cümle: Un agua, por favor. — Bir su, lütfen.", null, null),
                LearningExercise("esa1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "La ___ es roja.", "", listOf("agua", "manzana", "té"), listOf("manzana"), "Doğru cümle: La manzana es roja. — Elma kırmızı.", null, null),
                LearningExercise("esa1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çay sıcak.", "Bir su, lütfen.", "Bir kahve içiyorum."), listOf("Çay sıcak."), "Söylenen cümle: El té está caliente.", "El té está caliente.", null),
                LearningExercise("esa1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "La manzana es roja.", listOf("Çay sıcak.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("ES-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("esa1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Yo ___ té.", "", listOf("bebo", "bebes", "bebe"), listOf("bebo"), "Yo öznesiyle beber: bebo.", null, null),
                LearningExercise("esa1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: El pan está fresco.", "", listOf(), listOf("El pan está fresco."), "Türkçesi: Ekmek taze.", "El pan está fresco.", "El pan está fresco."),
                LearningExercise("esa1u3e9", Skill.WRITING, "Cümleyi İspanyolca yaz", "Karşılığını yaz: Bir kahve içiyorum.", "", listOf(), listOf("Bebo un café."), "Örnek yanıt: Bebo un café.", null, "Bebo un café."))))),
        LearningUnit("ES-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("ES-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("esa1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'familia' ne anlama gelir?", "", listOf("anne", "erkek kardeş", "aile"), listOf("aile"), "Mi familia es grande. — Ailem kalabalık.", null, null),
                LearningExercise("esa1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'madre' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "Mi madre está en casa. — Annem evde.", null, null),
                LearningExercise("esa1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'padre' ne anlama gelir?", "", listOf("baba", "erkek kardeş", "aile"), listOf("baba"), "Mi padre trabaja mucho. — Babam çok çalışır.", null, null))),
            LearningLesson("ES-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("esa1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Mi ___ es grande.", "", listOf("padre", "familia", "madre"), listOf("familia"), "Doğru cümle: Mi familia es grande. — Ailem kalabalık.", null, null),
                LearningExercise("esa1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Mi ___ es joven.", "", listOf("hermano", "amigo", "familia"), listOf("hermano"), "Doğru cümle: Mi hermano es joven. — Erkek kardeşim genç.", null, null),
                LearningExercise("esa1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: Es mi amigo.", "Es mi amigo.", null),
                LearningExercise("esa1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Mi hermano es joven.", listOf("Erkek kardeşim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Erkek kardeşim genç."), "Cümlenin çevirisi: Erkek kardeşim genç.", null, null))),
            LearningLesson("ES-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("esa1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Esta es ___ hermana.", "", listOf("mi", "mis", "yo"), listOf("mi"), "Sahiplik sıfatı: mi hermana.", null, null),
                LearningExercise("esa1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Mi madre está en casa.", "", listOf(), listOf("Mi madre está en casa."), "Türkçesi: Annem evde.", "Mi madre está en casa.", "Mi madre está en casa."),
                LearningExercise("esa1u4e9", Skill.WRITING, "Cümleyi İspanyolca yaz", "Karşılığını yaz: Babam çok çalışır.", "", listOf(), listOf("Mi padre trabaja mucho."), "Örnek yanıt: Mi padre trabaja mucho.", null, "Mi padre trabaja mucho."))))),
        LearningUnit("ES-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("ES-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("esa1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'casa' ne anlama gelir?", "", listOf("mağaza", "ev", "iş"), listOf("ev"), "La casa es vieja. — Ev eski.", null, null),
                LearningExercise("esa1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'trabajo' ne anlama gelir?", "", listOf("iş", "şehir", "yaşıyorum"), listOf("iş"), "El trabajo empieza a las nueve. — İş dokuzda başlıyor.", null, null),
                LearningExercise("esa1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'ciudad' ne anlama gelir?", "", listOf("mağaza", "ev", "şehir"), listOf("şehir"), "La ciudad es bonita. — Şehir güzel.", null, null))),
            LearningLesson("ES-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("esa1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "La ___ es vieja.", "", listOf("casa", "trabajo", "ciudad"), listOf("casa"), "Doğru cümle: La casa es vieja. — Ev eski.", null, null),
                LearningExercise("esa1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "La ___ está abierta.", "", listOf("vivo", "casa", "tienda"), listOf("tienda"), "Doğru cümle: La tienda está abierta. — Mağaza açık.", null, null),
                LearningExercise("esa1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Madrid'de yaşıyorum.", "Ev eski."), listOf("Madrid'de yaşıyorum."), "Söylenen cümle: Vivo en Madrid.", "Vivo en Madrid.", null),
                LearningExercise("esa1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "La tienda está abierta.", listOf("İş dokuzda başlıyor.", "Madrid'de yaşıyorum.", "Mağaza açık."), listOf("Mağaza açık."), "Cümlenin çevirisi: Mağaza açık.", null, null))),
            LearningLesson("ES-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("esa1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "¿Dónde ___ tú?", "", listOf("vives", "vivo", "vive"), listOf("vives"), "Tú öznesiyle vivir: vives.", null, null),
                LearningExercise("esa1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: El trabajo empieza a las nueve.", "", listOf(), listOf("El trabajo empieza a las nueve."), "Türkçesi: İş dokuzda başlıyor.", "El trabajo empieza a las nueve.", "El trabajo empieza a las nueve."),
                LearningExercise("esa1u5e9", Skill.WRITING, "Cümleyi İspanyolca yaz", "Karşılığını yaz: Şehir güzel.", "", listOf(), listOf("La ciudad es bonita."), "Örnek yanıt: La ciudad es bonita.", null, "La ciudad es bonita."))))),
        LearningUnit("ES-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("ES-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("esa1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'tren' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "El tren llega a las nueve. — Tren dokuzda geliyor.", null, null),
                LearningExercise("esa1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'billete' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "Un billete para Madrid, por favor. — Madrid'e bir bilet, lütfen.", null, null),
                LearningExercise("esa1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'hotel' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "El hotel está en el centro. — Otel merkezde.", null, null))),
            LearningLesson("ES-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("esa1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "El ___ llega a las nueve.", "", listOf("billete", "hotel", "tren"), listOf("tren"), "Doğru cümle: El tren llega a las nueve. — Tren dokuzda geliyor.", null, null),
                LearningExercise("esa1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Gire a la ___.", "", listOf("tren", "izquierda", "aeropuerto"), listOf("izquierda"), "Doğru cümle: Gire a la izquierda. — Sola dönün.", null, null),
                LearningExercise("esa1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: El aeropuerto está lejos.", "El aeropuerto está lejos.", null),
                LearningExercise("esa1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Gire a la izquierda.", listOf("Havalimanı uzak.", "Sola dönün.", "Madrid'e bir bilet, lütfen."), listOf("Sola dönün."), "Cümlenin çevirisi: Sola dönün.", null, null))),
            LearningLesson("ES-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("esa1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "El tren sale ___ las nueve.", "", listOf("a", "en", "de"), listOf("a"), "Saat belirtirken: a las nueve.", null, null),
                LearningExercise("esa1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Un billete para Madrid, por favor.", "", listOf(), listOf("Un billete para Madrid, por favor."), "Türkçesi: Madrid'e bir bilet, lütfen.", "Un billete para Madrid, por favor.", "Un billete para Madrid, por favor."),
                LearningExercise("esa1u6e9", Skill.WRITING, "Cümleyi İspanyolca yaz", "Karşılığını yaz: Otel merkezde.", "", listOf(), listOf("El hotel está en el centro."), "Örnek yanıt: El hotel está en el centro.", null, "El hotel está en el centro."))))))
}
