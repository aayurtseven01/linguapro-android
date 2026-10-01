package com.linguapro.android

/** Rusça (RU) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseRU {
    val units: List<LearningUnit> = listOf(
        LearningUnit("RU-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("RU-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("rua1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'привет' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kalın", "merhaba"), listOf("merhaba"), "Привет, я Анна. — Merhaba, ben Anna.", null, null),
                LearningExercise("rua1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'спасибо' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen / rica ederim"), listOf("teşekkürler"), "Большое спасибо! — Çok teşekkürler!", null, null),
                LearningExercise("rua1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'пожалуйста' ne anlama gelir?", "", listOf("lütfen / rica ederim", "hoşça kalın", "merhaba"), listOf("lütfen / rica ederim"), "Кофе, пожалуйста. — Kahve, lütfen.", null, null))),
            LearningLesson("RU-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("rua1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, я Анна.", "", listOf("пожалуйста", "Привет", "спасибо"), listOf("Привет"), "Doğru cümle: Привет, я Анна. — Merhaba, ben Anna.", null, null),
                LearningExercise("rua1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, до завтра!", "", listOf("До свидания", "меня зовут", "привет"), listOf("До свидания"), "Doğru cümle: До свидания, до завтра! — Hoşça kalın, yarına görüşürüz!", null, null),
                LearningExercise("rua1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Kahve, lütfen.", "Benim adım Mehmet."), listOf("Benim adım Mehmet."), "Söylenen cümle: Меня зовут Мехмет.", "Меня зовут Мехмет.", null),
                LearningExercise("rua1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "До свидания, до завтра!", listOf("Hoşça kalın, yarına görüşürüz!", "Çok teşekkürler!", "Benim adım Mehmet."), listOf("Hoşça kalın, yarına görüşürüz!"), "Cümlenin çevirisi: Hoşça kalın, yarına görüşürüz!", null, null))),
            LearningLesson("RU-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("rua1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Как тебя ___?", "", listOf("зовут", "звать", "зову"), listOf("зовут"), "Tanışma kalıbı: Как тебя зовут? (Adın ne?)", null, null),
                LearningExercise("rua1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Большое спасибо!", "", listOf(), listOf("Большое спасибо!"), "Türkçesi: Çok teşekkürler!", "Большое спасибо!", "Большое спасибо!"),
                LearningExercise("rua1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lütfen / rica ederim' ifadesinin Rusça karşılığı hangisi?", "", listOf("меня зовут", "пожалуйста", "привет"), listOf("пожалуйста"), "Örnek: Кофе, пожалуйста. — Kahve, lütfen.", null, null))))),
        LearningUnit("RU-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("RU-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("rua1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'два' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "У меня два брата. — İki erkek kardeşim var.", null, null),
                LearningExercise("rua1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'десять' ne anlama gelir?", "", listOf("on", "bugün", "saat"), listOf("on"), "Сейчас десять часов. — Saat şimdi on.", null, null),
                LearningExercise("rua1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'сегодня' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "Сегодня понедельник. — Bugün pazartesi.", null, null))),
            LearningLesson("RU-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("rua1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "У меня ___ брата.", "", listOf("два", "десять", "сегодня"), listOf("два"), "Doğru cümle: У меня два брата. — İki erkek kardeşim var.", null, null),
                LearningExercise("rua1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "До ___!", "", listOf("час", "два", "завтра"), listOf("завтра"), "Doğru cümle: До завтра! — Yarına görüşürüz!", null, null),
                LearningExercise("rua1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaç?", "İki erkek kardeşim var."), listOf("Saat kaç?"), "Söylenen cümle: Который час?", "Который час?", null),
                LearningExercise("rua1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "До завтра!", listOf("Saat şimdi on.", "Saat kaç?", "Yarına görüşürüz!"), listOf("Yarına görüşürüz!"), "Cümlenin çevirisi: Yarına görüşürüz!", null, null))),
            LearningLesson("RU-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("rua1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Который ___?", "", listOf("час", "часа", "часов"), listOf("час"), "Saat sorma kalıbı: Который час?", null, null),
                LearningExercise("rua1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Сейчас десять часов.", "", listOf(), listOf("Сейчас десять часов."), "Türkçesi: Saat şimdi on.", "Сейчас десять часов.", "Сейчас десять часов."),
                LearningExercise("rua1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bugün' ifadesinin Rusça karşılığı hangisi?", "", listOf("сегодня", "два", "час"), listOf("сегодня"), "Örnek: Сегодня понедельник. — Bugün pazartesi.", null, null))))),
        LearningUnit("RU-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("RU-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("rua1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'вода' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "Вода холодная. — Su soğuk.", null, null),
                LearningExercise("rua1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'хлеб' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "Хлеб свежий. — Ekmek taze.", null, null),
                LearningExercise("rua1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'кофе' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "Я пью кофе. — Kahve içiyorum.", null, null))),
            LearningLesson("RU-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("rua1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ холодная.", "", listOf("хлеб", "кофе", "Вода"), listOf("Вода"), "Doğru cümle: Вода холодная. — Su soğuk.", null, null),
                LearningExercise("rua1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ красное.", "", listOf("вода", "Яблоко", "чай"), listOf("Яблоко"), "Doğru cümle: Яблоко красное. — Elma kırmızı.", null, null),
                LearningExercise("rua1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çayı severim.", "Su soğuk.", "Kahve içiyorum."), listOf("Çayı severim."), "Söylenen cümle: Я люблю чай.", "Я люблю чай.", null),
                LearningExercise("rua1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Яблоко красное.", listOf("Çayı severim.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("RU-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("rua1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Я ___ кофе.", "", listOf("пью", "пьёшь", "пьёт"), listOf("пью"), "Я öznesiyle пить: я пью.", null, null),
                LearningExercise("rua1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Хлеб свежий.", "", listOf(), listOf("Хлеб свежий."), "Türkçesi: Ekmek taze.", "Хлеб свежий.", "Хлеб свежий."),
                LearningExercise("rua1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kahve' ifadesinin Rusça karşılığı hangisi?", "", listOf("вода", "чай", "кофе"), listOf("кофе"), "Örnek: Я пью кофе. — Kahve içiyorum.", null, null))))),
        LearningUnit("RU-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("RU-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("rua1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'семья' ne anlama gelir?", "", listOf("anne", "erkek kardeş", "aile"), listOf("aile"), "Моя семья большая. — Ailem kalabalık.", null, null),
                LearningExercise("rua1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'мама' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "Мама дома. — Annem evde.", null, null),
                LearningExercise("rua1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'папа' ne anlama gelir?", "", listOf("baba", "erkek kardeş", "aile"), listOf("baba"), "Папа много работает. — Babam çok çalışır.", null, null))),
            LearningLesson("RU-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("rua1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Моя ___ большая.", "", listOf("папа", "семья", "мама"), listOf("семья"), "Doğru cümle: Моя семья большая. — Ailem kalabalık.", null, null),
                LearningExercise("rua1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Мой ___ молодой.", "", listOf("брат", "друг", "семья"), listOf("брат"), "Doğru cümle: Мой брат молодой. — Erkek kardeşim genç.", null, null),
                LearningExercise("rua1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: Он мой друг.", "Он мой друг.", null),
                LearningExercise("rua1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Мой брат молодой.", listOf("Erkek kardeşim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Erkek kardeşim genç."), "Cümlenin çevirisi: Erkek kardeşim genç.", null, null))),
            LearningLesson("RU-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("rua1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Это ___ сестра.", "", listOf("моя", "мой", "моё"), listOf("моя"), "Dişil isimle: моя сестра.", null, null),
                LearningExercise("rua1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Мама дома.", "", listOf(), listOf("Мама дома."), "Türkçesi: Annem evde.", "Мама дома.", "Мама дома."),
                LearningExercise("rua1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baba' ifadesinin Rusça karşılığı hangisi?", "", listOf("друг", "папа", "семья"), listOf("папа"), "Örnek: Папа много работает. — Babam çok çalışır.", null, null))))),
        LearningUnit("RU-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("RU-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("rua1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'дом' ne anlama gelir?", "", listOf("mağaza", "ev", "iş"), listOf("ev"), "Дом старый. — Ev eski.", null, null),
                LearningExercise("rua1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'работа' ne anlama gelir?", "", listOf("iş", "şehir", "yaşıyorum"), listOf("iş"), "Работа интересная. — İş ilginç.", null, null),
                LearningExercise("rua1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'город' ne anlama gelir?", "", listOf("mağaza", "ev", "şehir"), listOf("şehir"), "Город красивый. — Şehir güzel.", null, null))),
            LearningLesson("RU-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("rua1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ старый.", "", listOf("Дом", "работа", "город"), listOf("Дом"), "Doğru cümle: Дом старый. — Ev eski.", null, null),
                LearningExercise("rua1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ закрыт.", "", listOf("я живу", "дом", "Магазин"), listOf("Магазин"), "Doğru cümle: Магазин закрыт. — Mağaza kapalı.", null, null),
                LearningExercise("rua1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Moskova'da yaşıyorum.", "Ev eski."), listOf("Moskova'da yaşıyorum."), "Söylenen cümle: Я живу в Москве.", "Я живу в Москве.", null),
                LearningExercise("rua1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Магазин закрыт.", listOf("İş ilginç.", "Moskova'da yaşıyorum.", "Mağaza kapalı."), listOf("Mağaza kapalı."), "Cümlenin çevirisi: Mağaza kapalı.", null, null))),
            LearningLesson("RU-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("rua1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Я ___ в Москве.", "", listOf("живу", "живёшь", "живёт"), listOf("живу"), "Я öznesiyle жить: я живу.", null, null),
                LearningExercise("rua1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Работа интересная.", "", listOf(), listOf("Работа интересная."), "Türkçesi: İş ilginç.", "Работа интересная.", "Работа интересная."),
                LearningExercise("rua1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'şehir' ifadesinin Rusça karşılığı hangisi?", "", listOf("город", "дом", "я живу"), listOf("город"), "Örnek: Город красивый. — Şehir güzel.", null, null))))),
        LearningUnit("RU-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("RU-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("rua1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'поезд' ne anlama gelir?", "", listOf("tren", "bilet", "sola"), listOf("tren"), "Поезд приходит в девять. — Tren dokuzda geliyor.", null, null),
                LearningExercise("rua1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'билет' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "Один билет, пожалуйста. — Bir bilet, lütfen.", null, null),
                LearningExercise("rua1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'гостиница' ne anlama gelir?", "", listOf("tren", "otel", "sola"), listOf("otel"), "Гостиница в центре. — Otel merkezde.", null, null))),
            LearningLesson("RU-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("rua1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ приходит в девять.", "", listOf("билет", "гостиница", "Поезд"), listOf("Поезд"), "Doğru cümle: Поезд приходит в девять. — Tren dokuzda geliyor.", null, null),
                LearningExercise("rua1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "Идите ___.", "", listOf("поезд", "налево", "аэропорт"), listOf("налево"), "Doğru cümle: Идите налево. — Sola gidin.", null, null),
                LearningExercise("rua1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel merkezde."), listOf("Havalimanı uzak."), "Söylenen cümle: Аэропорт далеко.", "Аэропорт далеко.", null),
                LearningExercise("rua1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "Идите налево.", listOf("Havalimanı uzak.", "Sola gidin.", "Bir bilet, lütfen."), listOf("Sola gidin."), "Cümlenin çevirisi: Sola gidin.", null, null))),
            LearningLesson("RU-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("rua1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "Поезд приходит ___ девять.", "", listOf("в", "на", "у"), listOf("в"), "Saat belirtirken: в девять (saat dokuzda).", null, null),
                LearningExercise("rua1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: Один билет, пожалуйста.", "", listOf(), listOf("Один билет, пожалуйста."), "Türkçesi: Bir bilet, lütfen.", "Один билет, пожалуйста.", "Один билет, пожалуйста."),
                LearningExercise("rua1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Rusça karşılığı hangisi?", "", listOf("поезд", "аэропорт", "гостиница"), listOf("гостиница"), "Örnek: Гостиница в центре. — Otel merkezde.", null, null))))))
}
