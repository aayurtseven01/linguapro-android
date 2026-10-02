package com.linguapro.android

/** Korece (KO) tam müfredat: A1-C2, 36 ünite, 108 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseKO {
    val units: List<LearningUnit> = listOf(
        LearningUnit("KO-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("KO-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'안녕하세요' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kalın", "merhaba"), listOf("merhaba"), "안녕하세요, 안나예요. — Merhaba, ben Anna.", null, null),
                LearningExercise("koa1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'감사합니다' ne anlama gelir?", "", listOf("ben (konu)", "teşekkürler", "lütfen (verin)"), listOf("teşekkürler"), "정말 감사합니다. — Gerçekten teşekkür ederim.", null, null),
                LearningExercise("koa1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'주세요' ne anlama gelir?", "", listOf("lütfen (verin)", "hoşça kalın", "merhaba"), listOf("lütfen (verin)"), "커피 주세요. — Kahve lütfen.", null, null)), listOf(
                TargetVocabulary("koa1u1w1", "안녕하세요", "merhaba", "ifade", "안녕하세요, 안나예요.", "Merhaba, ben Anna."),
                TargetVocabulary("koa1u1w2", "감사합니다", "teşekkürler", "ifade", "정말 감사합니다.", "Gerçekten teşekkür ederim."),
                TargetVocabulary("koa1u1w3", "주세요", "lütfen (verin)", "ifade", "커피 주세요.", "Kahve lütfen."),
                TargetVocabulary("koa1u1w4", "안녕히 가세요", "hoşça kalın", "ifade", "안녕히 가세요, 내일 봐요!", "Hoşça kalın, yarın görüşürüz!"),
                TargetVocabulary("koa1u1w5", "저는", "ben (konu)", "ifade", "저는 메흐메트예요.", "Ben Mehmet'im."))),
            LearningLesson("KO-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, 안나예요.", "", listOf("주세요", "안녕하세요", "감사합니다"), listOf("안녕하세요"), "Doğru cümle: 안녕하세요, 안나예요. — Merhaba, ben Anna.", null, null),
                LearningExercise("koa1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___, 내일 봐요!", "", listOf("안녕히 가세요", "저는", "안녕하세요"), listOf("안녕히 가세요"), "Doğru cümle: 안녕히 가세요, 내일 봐요! — Hoşça kalın, yarın görüşürüz!", null, null),
                LearningExercise("koa1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Kahve lütfen.", "Ben Mehmet'im."), listOf("Ben Mehmet'im."), "Söylenen cümle: 저는 메흐메트예요.", "저는 메흐메트예요.", null),
                LearningExercise("koa1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "안녕히 가세요, 내일 봐요!", listOf("Hoşça kalın, yarın görüşürüz!", "Gerçekten teşekkür ederim.", "Ben Mehmet'im."), listOf("Hoşça kalın, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kalın, yarın görüşürüz!", null, null))),
            LearningLesson("KO-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "저___ 학생이에요.", "", listOf("는", "가", "를"), listOf("는"), "Konu edatı: 는.", null, null),
                LearningExercise("koa1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 정말 감사합니다.", "", listOf(), listOf("정말 감사합니다."), "Türkçesi: Gerçekten teşekkür ederim.", "정말 감사합니다.", "정말 감사합니다."),
                LearningExercise("koa1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lütfen (verin)' ifadesinin Korece karşılığı hangisi?", "", listOf("저는", "주세요", "안녕하세요"), listOf("주세요"), "Örnek: 커피 주세요. — Kahve lütfen.", null, null))))),
        LearningUnit("KO-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("KO-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'둘' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "둘 다 좋아요. — İkisi de iyi.", null, null),
                LearningExercise("koa1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'열' ne anlama gelir?", "", listOf("on", "bugün", "zaman"), listOf("on"), "지금 열 시예요. — Saat şimdi on.", null, null),
                LearningExercise("koa1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'오늘' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "오늘은 월요일이에요. — Bugün pazartesi.", null, null)), listOf(
                TargetVocabulary("koa1u2w1", "둘", "iki", "ifade", "둘 다 좋아요.", "İkisi de iyi."),
                TargetVocabulary("koa1u2w2", "열", "on", "ifade", "지금 열 시예요.", "Saat şimdi on."),
                TargetVocabulary("koa1u2w3", "오늘", "bugün", "ifade", "오늘은 월요일이에요.", "Bugün pazartesi."),
                TargetVocabulary("koa1u2w4", "내일", "yarın", "ifade", "내일 봐요!", "Yarın görüşürüz!"),
                TargetVocabulary("koa1u2w5", "시간", "zaman", "ifade", "시간이 없어요.", "Zaman yok."))),
            LearningLesson("KO-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 다 좋아요.", "", listOf("둘", "열", "오늘"), listOf("둘"), "Doğru cümle: 둘 다 좋아요. — İkisi de iyi.", null, null),
                LearningExercise("koa1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 봐요!", "", listOf("시간", "둘", "내일"), listOf("내일"), "Doğru cümle: 내일 봐요! — Yarın görüşürüz!", null, null),
                LearningExercise("koa1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Zaman yok.", "İkisi de iyi."), listOf("Zaman yok."), "Söylenen cümle: 시간이 없어요.", "시간이 없어요.", null),
                LearningExercise("koa1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "내일 봐요!", listOf("Saat şimdi on.", "Zaman yok.", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("KO-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "지금 몇 ___예요?", "", listOf("시", "분", "일"), listOf("시"), "Saat sorma kalıbı: 몇 시예요?", null, null),
                LearningExercise("koa1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 지금 열 시예요.", "", listOf(), listOf("지금 열 시예요."), "Türkçesi: Saat şimdi on.", "지금 열 시예요.", "지금 열 시예요."),
                LearningExercise("koa1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bugün' ifadesinin Korece karşılığı hangisi?", "", listOf("오늘", "둘", "시간"), listOf("오늘"), "Örnek: 오늘은 월요일이에요. — Bugün pazartesi.", null, null))))),
        LearningUnit("KO-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("KO-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'물' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "물 주세요. — Su lütfen.", null, null),
                LearningExercise("koa1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'빵' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "빵이 신선해요. — Ekmek taze.", null, null),
                LearningExercise("koa1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'커피' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "커피를 마셔요. — Kahve içiyorum.", null, null)), listOf(
                TargetVocabulary("koa1u3w1", "물", "su", "ifade", "물 주세요.", "Su lütfen."),
                TargetVocabulary("koa1u3w2", "빵", "ekmek", "ifade", "빵이 신선해요.", "Ekmek taze."),
                TargetVocabulary("koa1u3w3", "커피", "kahve", "ifade", "커피를 마셔요.", "Kahve içiyorum."),
                TargetVocabulary("koa1u3w4", "사과", "elma", "ifade", "사과가 빨개요.", "Elma kırmızı."),
                TargetVocabulary("koa1u3w5", "차", "çay", "ifade", "차를 좋아해요.", "Çayı severim."))),
            LearningLesson("KO-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 주세요.", "", listOf("빵", "커피", "물"), listOf("물"), "Doğru cümle: 물 주세요. — Su lütfen.", null, null),
                LearningExercise("koa1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 빨개요.", "", listOf("물", "사과", "차"), listOf("사과"), "Doğru cümle: 사과가 빨개요. — Elma kırmızı.", null, null),
                LearningExercise("koa1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çayı severim.", "Su lütfen.", "Kahve içiyorum."), listOf("Çayı severim."), "Söylenen cümle: 차를 좋아해요.", "차를 좋아해요.", null),
                LearningExercise("koa1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "사과가 빨개요.", listOf("Çayı severim.", "Elma kırmızı.", "Ekmek taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("KO-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "커피___ 마셔요.", "", listOf("를", "가", "는"), listOf("를"), "Nesne edatı: 를.", null, null),
                LearningExercise("koa1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 빵이 신선해요.", "", listOf(), listOf("빵이 신선해요."), "Türkçesi: Ekmek taze.", "빵이 신선해요.", "빵이 신선해요."),
                LearningExercise("koa1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kahve' ifadesinin Korece karşılığı hangisi?", "", listOf("물", "차", "커피"), listOf("커피"), "Örnek: 커피를 마셔요. — Kahve içiyorum.", null, null))))),
        LearningUnit("KO-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("KO-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'가족' ne anlama gelir?", "", listOf("anne", "ağabey", "aile"), listOf("aile"), "가족이 많아요. — Ailem kalabalık.", null, null),
                LearningExercise("koa1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'어머니' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "어머니는 집에 계세요. — Annem evde.", null, null),
                LearningExercise("koa1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'아버지' ne anlama gelir?", "", listOf("baba", "ağabey", "aile"), listOf("baba"), "아버지는 일을 많이 하세요. — Babam çok çalışır.", null, null)), listOf(
                TargetVocabulary("koa1u4w1", "가족", "aile", "ifade", "가족이 많아요.", "Ailem kalabalık."),
                TargetVocabulary("koa1u4w2", "어머니", "anne", "ifade", "어머니는 집에 계세요.", "Annem evde."),
                TargetVocabulary("koa1u4w3", "아버지", "baba", "ifade", "아버지는 일을 많이 하세요.", "Babam çok çalışır."),
                TargetVocabulary("koa1u4w4", "형", "ağabey", "ifade", "형은 젊어요.", "Ağabeyim genç."),
                TargetVocabulary("koa1u4w5", "친구", "arkadaş", "ifade", "그는 제 친구예요.", "O benim arkadaşım."))),
            LearningLesson("KO-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 많아요.", "", listOf("아버지", "가족", "어머니"), listOf("가족"), "Doğru cümle: 가족이 많아요. — Ailem kalabalık.", null, null),
                LearningExercise("koa1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___은 젊어요.", "", listOf("형", "친구", "가족"), listOf("형"), "Doğru cümle: 형은 젊어요. — Ağabeyim genç.", null, null),
                LearningExercise("koa1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam çok çalışır.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: 그는 제 친구예요.", "그는 제 친구예요.", null),
                LearningExercise("koa1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "형은 젊어요.", listOf("Ağabeyim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null))),
            LearningLesson("KO-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "이것은 제 책___.", "", listOf("이에요", "예요", "있어요"), listOf("이에요"), "Ünsüzle biten isimden sonra koşaç: 이에요.", null, null),
                LearningExercise("koa1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 어머니는 집에 계세요.", "", listOf(), listOf("어머니는 집에 계세요."), "Türkçesi: Annem evde.", "어머니는 집에 계세요.", "어머니는 집에 계세요."),
                LearningExercise("koa1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baba' ifadesinin Korece karşılığı hangisi?", "", listOf("친구", "아버지", "가족"), listOf("아버지"), "Örnek: 아버지는 일을 많이 하세요. — Babam çok çalışır.", null, null))))),
        LearningUnit("KO-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("KO-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'집' ne anlama gelir?", "", listOf("satın almak", "ev", "iş"), listOf("ev"), "집이 오래됐어요. — Ev eski.", null, null),
                LearningExercise("koa1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'일' ne anlama gelir?", "", listOf("iş", "şehir", "yaşamak"), listOf("iş"), "일하러 가요. — İşe gidiyorum.", null, null),
                LearningExercise("koa1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'도시' ne anlama gelir?", "", listOf("satın almak", "ev", "şehir"), listOf("şehir"), "도시가 아름다워요. — Şehir güzel.", null, null)), listOf(
                TargetVocabulary("koa1u5w1", "집", "ev", "ifade", "집이 오래됐어요.", "Ev eski."),
                TargetVocabulary("koa1u5w2", "일", "iş", "ifade", "일하러 가요.", "İşe gidiyorum."),
                TargetVocabulary("koa1u5w3", "도시", "şehir", "ifade", "도시가 아름다워요.", "Şehir güzel."),
                TargetVocabulary("koa1u5w4", "사다", "satın almak", "ifade", "과일을 사요.", "Meyve alıyorum."),
                TargetVocabulary("koa1u5w5", "살다", "yaşamak", "ifade", "서울에 살아요.", "Seul'de yaşıyorum."))),
            LearningLesson("KO-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 오래됐어요.", "", listOf("집", "일", "도시"), listOf("집"), "Doğru cümle: 집이 오래됐어요. — Ev eski.", null, null),
                LearningExercise("koa1u5e5", Skill.VOCABULARY, "Doğru anlamı seç", "'사다' ne anlama gelir?", "", listOf("satın almak", "ev", "şehir"), listOf("satın almak"), "과일을 사요. — Meyve alıyorum.", null, null),
                LearningExercise("koa1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şehir güzel.", "Seul'de yaşıyorum.", "Ev eski."), listOf("Seul'de yaşıyorum."), "Söylenen cümle: 서울에 살아요.", "서울에 살아요.", null),
                LearningExercise("koa1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "과일을 사요.", listOf("İşe gidiyorum.", "Seul'de yaşıyorum.", "Meyve alıyorum."), listOf("Meyve alıyorum."), "Cümlenin çevirisi: Meyve alıyorum.", null, null))),
            LearningLesson("KO-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "서울___ 살아요.", "", listOf("에", "를", "은"), listOf("에"), "Yer edatı: 에.", null, null),
                LearningExercise("koa1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 일하러 가요.", "", listOf(), listOf("일하러 가요."), "Türkçesi: İşe gidiyorum.", "일하러 가요.", "일하러 가요."),
                LearningExercise("koa1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'şehir' ifadesinin Korece karşılığı hangisi?", "", listOf("도시", "집", "살다"), listOf("도시"), "Örnek: 도시가 아름다워요. — Şehir güzel.", null, null))))),
        LearningUnit("KO-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("KO-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'기차' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "기차가 아홉 시에 와요. — Tren dokuzda geliyor.", null, null),
                LearningExercise("koa1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'표' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "표 한 장 주세요. — Bir bilet lütfen.", null, null),
                LearningExercise("koa1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'호텔' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "호텔은 시내에 있어요. — Otel şehir merkezinde.", null, null)), listOf(
                TargetVocabulary("koa1u6w1", "기차", "tren", "ifade", "기차가 아홉 시에 와요.", "Tren dokuzda geliyor."),
                TargetVocabulary("koa1u6w2", "표", "bilet", "ifade", "표 한 장 주세요.", "Bir bilet lütfen."),
                TargetVocabulary("koa1u6w3", "호텔", "otel", "ifade", "호텔은 시내에 있어요.", "Otel şehir merkezinde."),
                TargetVocabulary("koa1u6w4", "왼쪽", "sol", "ifade", "왼쪽으로 가세요.", "Sola gidin."),
                TargetVocabulary("koa1u6w5", "공항", "havalimanı", "ifade", "공항이 멀어요.", "Havalimanı uzak."))),
            LearningLesson("KO-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 아홉 시에 와요.", "", listOf("표", "호텔", "기차"), listOf("기차"), "Doğru cümle: 기차가 아홉 시에 와요. — Tren dokuzda geliyor.", null, null),
                LearningExercise("koa1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___으로 가세요.", "", listOf("기차", "왼쪽", "공항"), listOf("왼쪽"), "Doğru cümle: 왼쪽으로 가세요. — Sola gidin.", null, null),
                LearningExercise("koa1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel şehir merkezinde."), listOf("Havalimanı uzak."), "Söylenen cümle: 공항이 멀어요.", "공항이 멀어요.", null),
                LearningExercise("koa1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "왼쪽으로 가세요.", listOf("Havalimanı uzak.", "Sola gidin.", "Bir bilet lütfen."), listOf("Sola gidin."), "Cümlenin çevirisi: Sola gidin.", null, null))),
            LearningLesson("KO-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "표 한 장 ___.", "", listOf("주세요", "있어요", "가요"), listOf("주세요"), "Rica kalıbı: 주세요.", null, null),
                LearningExercise("koa1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 표 한 장 주세요.", "", listOf(), listOf("표 한 장 주세요."), "Türkçesi: Bir bilet lütfen.", "표 한 장 주세요.", "표 한 장 주세요."),
                LearningExercise("koa1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Korece karşılığı hangisi?", "", listOf("기차", "공항", "호텔"), listOf("호텔"), "Örnek: 호텔은 시내에 있어요. — Otel şehir merkezinde.", null, null))))),
        LearningUnit("KO-A2-U1", "Geçmişten Bahsetmek", "Geçmişte olanları anlat.", listOf(
            LearningLesson("KO-A2-U1-L1", "Geçmişten Bahsetmek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'어제' ne anlama gelir?", "", listOf("geçen hafta", "gördü/izledi", "dün"), listOf("dün"), "어제 일했어요. — Dün çalıştım.", null, null),
                LearningExercise("koa2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'지난주' ne anlama gelir?", "", listOf("yolculuk", "geçen hafta", "satın aldı"), listOf("geçen hafta"), "지난주에 아팠어요. — Geçen hafta hastaydım.", null, null),
                LearningExercise("koa2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'샀어요' ne anlama gelir?", "", listOf("satın aldı", "gördü/izledi", "dün"), listOf("satın aldı"), "빵을 샀어요. — Ekmek aldım.", null, null)), listOf(
                TargetVocabulary("koa2u1w1", "어제", "dün", "ifade", "어제 일했어요.", "Dün çalıştım."),
                TargetVocabulary("koa2u1w2", "지난주", "geçen hafta", "ifade", "지난주에 아팠어요.", "Geçen hafta hastaydım."),
                TargetVocabulary("koa2u1w3", "샀어요", "satın aldı", "ifade", "빵을 샀어요.", "Ekmek aldım."),
                TargetVocabulary("koa2u1w4", "봤어요", "gördü/izledi", "ifade", "그 영화를 봤어요.", "O filmi izledim."),
                TargetVocabulary("koa2u1w5", "여행", "yolculuk", "ifade", "여행이 즐거웠어요.", "Yolculuk keyifliydi."))),
            LearningLesson("KO-A2-U1-L2", "Geçmişten Bahsetmek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 일했어요.", "", listOf("샀어요", "어제", "지난주"), listOf("어제"), "Doğru cümle: 어제 일했어요. — Dün çalıştım.", null, null),
                LearningExercise("koa2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그 영화를 ___.", "", listOf("봤어요", "여행", "어제"), listOf("봤어요"), "Doğru cümle: 그 영화를 봤어요. — O filmi izledim.", null, null),
                LearningExercise("koa2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dün çalıştım.", "Ekmek aldım.", "Yolculuk keyifliydi."), listOf("Yolculuk keyifliydi."), "Söylenen cümle: 여행이 즐거웠어요.", "여행이 즐거웠어요.", null),
                LearningExercise("koa2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "그 영화를 봤어요.", listOf("O filmi izledim.", "Geçen hafta hastaydım.", "Yolculuk keyifliydi."), listOf("O filmi izledim."), "Cümlenin çevirisi: O filmi izledim.", null, null))),
            LearningLesson("KO-A2-U1-L3", "Geçmişten Bahsetmek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "어제 영화를 ___.", "", listOf("봤어요", "봐요", "볼 거예요"), listOf("봤어요"), "Geçmiş zaman: 봤어요.", null, null),
                LearningExercise("koa2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 지난주에 아팠어요.", "", listOf(), listOf("지난주에 아팠어요."), "Türkçesi: Geçen hafta hastaydım.", "지난주에 아팠어요.", "지난주에 아팠어요."),
                LearningExercise("koa2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'satın aldı' ifadesinin Korece karşılığı hangisi?", "", listOf("여행", "샀어요", "어제"), listOf("샀어요"), "Örnek: 빵을 샀어요. — Ekmek aldım.", null, null))))),
        LearningUnit("KO-A2-U2", "Alışveriş ve Para", "Fiyat sor, ödeme yap.", listOf(
            LearningLesson("KO-A2-U2-L1", "Alışveriş ve Para — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'돈' ne anlama gelir?", "", listOf("kaç para", "para", "pahalı"), listOf("para"), "돈이 부족해요. — Param yetmiyor.", null, null),
                LearningExercise("koa2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'비싸요' ne anlama gelir?", "", listOf("pahalı", "ucuz", "hesabı ödemek"), listOf("pahalı"), "이 전화는 비싸요. — Bu telefon pahalı.", null, null),
                LearningExercise("koa2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'싸요' ne anlama gelir?", "", listOf("kaç para", "para", "ucuz"), listOf("ucuz"), "빵이 싸요. — Ekmek ucuz.", null, null)), listOf(
                TargetVocabulary("koa2u2w1", "돈", "para", "ifade", "돈이 부족해요.", "Param yetmiyor."),
                TargetVocabulary("koa2u2w2", "비싸요", "pahalı", "ifade", "이 전화는 비싸요.", "Bu telefon pahalı."),
                TargetVocabulary("koa2u2w3", "싸요", "ucuz", "ifade", "빵이 싸요.", "Ekmek ucuz."),
                TargetVocabulary("koa2u2w4", "얼마예요", "kaç para", "ifade", "이거 얼마예요?", "Bu kaç para?"),
                TargetVocabulary("koa2u2w5", "계산해요", "hesabı ödemek", "ifade", "제가 계산할게요.", "Hesabı ben ödeyeyim."))),
            LearningLesson("KO-A2-U2-L2", "Alışveriş ve Para — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 부족해요.", "", listOf("돈", "비싸요", "싸요"), listOf("돈"), "Doğru cümle: 돈이 부족해요. — Param yetmiyor.", null, null),
                LearningExercise("koa2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "이거 ___?", "", listOf("계산해요", "돈", "얼마예요"), listOf("얼마예요"), "Doğru cümle: 이거 얼마예요? — Bu kaç para?", null, null),
                LearningExercise("koa2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekmek ucuz.", "Hesabı ben ödeyeyim.", "Param yetmiyor."), listOf("Hesabı ben ödeyeyim."), "Söylenen cümle: 제가 계산할게요.", "제가 계산할게요.", null),
                LearningExercise("koa2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "이거 얼마예요?", listOf("Bu telefon pahalı.", "Hesabı ben ödeyeyim.", "Bu kaç para?"), listOf("Bu kaç para?"), "Cümlenin çevirisi: Bu kaç para?", null, null))),
            LearningLesson("KO-A2-U2-L3", "Alışveriş ve Para — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "이거 ___?", "", listOf("얼마예요", "몇 개예요", "어디예요"), listOf("얼마예요"), "Fiyat sorma: 얼마예요?", null, null),
                LearningExercise("koa2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 이 전화는 비싸요.", "", listOf(), listOf("이 전화는 비싸요."), "Türkçesi: Bu telefon pahalı.", "이 전화는 비싸요.", "이 전화는 비싸요."),
                LearningExercise("koa2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ucuz' ifadesinin Korece karşılığı hangisi?", "", listOf("싸요", "돈", "계산해요"), listOf("싸요"), "Örnek: 빵이 싸요. — Ekmek ucuz.", null, null))))),
        LearningUnit("KO-A2-U3", "Sağlık ve Vücut", "Rahatsızlığını anlat, randevu al.", listOf(
            LearningLesson("KO-A2-U3-L1", "Sağlık ve Vücut — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'아파요' ne anlama gelir?", "", listOf("ağrıyor/hasta", "doktor", "eczane"), listOf("ağrıyor/hasta"), "머리가 아파요. — Başım ağrıyor.", null, null),
                LearningExercise("koa2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'의사' ne anlama gelir?", "", listOf("baş", "hastane", "doktor"), listOf("doktor"), "의사가 열 시에 와요. — Doktor onda geliyor.", null, null),
                LearningExercise("koa2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'머리' ne anlama gelir?", "", listOf("ağrıyor/hasta", "baş", "eczane"), listOf("baş"), "머리가 무거워요. — Başım ağır.", null, null)), listOf(
                TargetVocabulary("koa2u3w1", "아파요", "ağrıyor/hasta", "ifade", "머리가 아파요.", "Başım ağrıyor."),
                TargetVocabulary("koa2u3w2", "의사", "doktor", "ifade", "의사가 열 시에 와요.", "Doktor onda geliyor."),
                TargetVocabulary("koa2u3w3", "머리", "baş", "ifade", "머리가 무거워요.", "Başım ağır."),
                TargetVocabulary("koa2u3w4", "약국", "eczane", "ifade", "약국이 문을 닫았어요.", "Eczane kapandı."),
                TargetVocabulary("koa2u3w5", "병원", "hastane", "ifade", "병원에 가야 해요.", "Hastaneye gitmem gerek."))),
            LearningLesson("KO-A2-U3-L2", "Sağlık ve Vücut — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "머리가 ___.", "", listOf("의사", "머리", "아파요"), listOf("아파요"), "Doğru cümle: 머리가 아파요. — Başım ağrıyor.", null, null),
                LearningExercise("koa2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 문을 닫았어요.", "", listOf("아파요", "약국", "병원"), listOf("약국"), "Doğru cümle: 약국이 문을 닫았어요. — Eczane kapandı.", null, null),
                LearningExercise("koa2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Hastaneye gitmem gerek.", "Başım ağrıyor.", "Başım ağır."), listOf("Hastaneye gitmem gerek."), "Söylenen cümle: 병원에 가야 해요.", "병원에 가야 해요.", null),
                LearningExercise("koa2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "약국이 문을 닫았어요.", listOf("Hastaneye gitmem gerek.", "Eczane kapandı.", "Doktor onda geliyor."), listOf("Eczane kapandı."), "Cümlenin çevirisi: Eczane kapandı.", null, null))),
            LearningLesson("KO-A2-U3-L3", "Sağlık ve Vücut — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "머리___ 아파요.", "", listOf("가", "를", "에"), listOf("가"), "Özne edatı: 머리가 아파요.", null, null),
                LearningExercise("koa2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 의사가 열 시에 와요.", "", listOf(), listOf("의사가 열 시에 와요."), "Türkçesi: Doktor onda geliyor.", "의사가 열 시에 와요.", "의사가 열 시에 와요."),
                LearningExercise("koa2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baş' ifadesinin Korece karşılığı hangisi?", "", listOf("아파요", "병원", "머리"), listOf("머리"), "Örnek: 머리가 무거워요. — Başım ağır.", null, null))))),
        LearningUnit("KO-A2-U4", "Hava Durumu ve Doğa", "Havayı ve mevsimleri anlat.", listOf(
            LearningLesson("KO-A2-U4-L1", "Hava Durumu ve Doğa — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'날씨' ne anlama gelir?", "", listOf("yağmur", "soğuk", "hava durumu"), listOf("hava durumu"), "오늘 날씨가 좋아요. — Bugün hava güzel.", null, null),
                LearningExercise("koa2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'비' ne anlama gelir?", "", listOf("sıcak", "yağmur", "güneş"), listOf("yağmur"), "내일 비가 와요. — Yarın yağmur yağacak.", null, null),
                LearningExercise("koa2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'해' ne anlama gelir?", "", listOf("güneş", "soğuk", "hava durumu"), listOf("güneş"), "해가 났어요. — Güneş çıktı.", null, null)), listOf(
                TargetVocabulary("koa2u4w1", "날씨", "hava durumu", "ifade", "오늘 날씨가 좋아요.", "Bugün hava güzel."),
                TargetVocabulary("koa2u4w2", "비", "yağmur", "ifade", "내일 비가 와요.", "Yarın yağmur yağacak."),
                TargetVocabulary("koa2u4w3", "해", "güneş", "ifade", "해가 났어요.", "Güneş çıktı."),
                TargetVocabulary("koa2u4w4", "추워요", "soğuk", "ifade", "겨울은 추워요.", "Kışın hava soğuk olur."),
                TargetVocabulary("koa2u4w5", "더워요", "sıcak", "ifade", "여름은 더워요.", "Yazın hava sıcak olur."))),
            LearningLesson("KO-A2-U4-L2", "Hava Durumu ve Doğa — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "오늘 ___가 좋아요.", "", listOf("해", "날씨", "비"), listOf("날씨"), "Doğru cümle: 오늘 날씨가 좋아요. — Bugün hava güzel.", null, null),
                LearningExercise("koa2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "겨울은 ___.", "", listOf("추워요", "더워요", "날씨"), listOf("추워요"), "Doğru cümle: 겨울은 추워요. — Kışın hava soğuk olur.", null, null),
                LearningExercise("koa2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün hava güzel.", "Güneş çıktı.", "Yazın hava sıcak olur."), listOf("Yazın hava sıcak olur."), "Söylenen cümle: 여름은 더워요.", "여름은 더워요.", null),
                LearningExercise("koa2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "겨울은 추워요.", listOf("Kışın hava soğuk olur.", "Yarın yağmur yağacak.", "Yazın hava sıcak olur."), listOf("Kışın hava soğuk olur."), "Cümlenin çevirisi: Kışın hava soğuk olur.", null, null))),
            LearningLesson("KO-A2-U4-L3", "Hava Durumu ve Doğa — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "내일 비가 ___.", "", listOf("와요", "갔어요", "해요"), listOf("와요"), "Hava: 비가 와요 (yağmur yağıyor).", null, null),
                LearningExercise("koa2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 내일 비가 와요.", "", listOf(), listOf("내일 비가 와요."), "Türkçesi: Yarın yağmur yağacak.", "내일 비가 와요.", "내일 비가 와요."),
                LearningExercise("koa2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'güneş' ifadesinin Korece karşılığı hangisi?", "", listOf("더워요", "해", "날씨"), listOf("해"), "Örnek: 해가 났어요. — Güneş çıktı.", null, null))))),
        LearningUnit("KO-A2-U5", "İş ve Okul", "İş ve eğitim hayatından bahset.", listOf(
            LearningLesson("KO-A2-U5-L1", "İş ve Okul — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'사무실' ne anlama gelir?", "", listOf("öğretmen", "ofis", "ders çalışmak"), listOf("ofis"), "사무실이 시내에 있어요. — Ofis şehir merkezinde.", null, null),
                LearningExercise("koa2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'공부해요' ne anlama gelir?", "", listOf("ders çalışmak", "sınav", "toplantı"), listOf("ders çalışmak"), "한국어를 공부해요. — Korece çalışıyorum.", null, null),
                LearningExercise("koa2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'시험' ne anlama gelir?", "", listOf("öğretmen", "ofis", "sınav"), listOf("sınav"), "시험은 금요일이에요. — Sınav cuma günü.", null, null)), listOf(
                TargetVocabulary("koa2u5w1", "사무실", "ofis", "ifade", "사무실이 시내에 있어요.", "Ofis şehir merkezinde."),
                TargetVocabulary("koa2u5w2", "공부해요", "ders çalışmak", "ifade", "한국어를 공부해요.", "Korece çalışıyorum."),
                TargetVocabulary("koa2u5w3", "시험", "sınav", "ifade", "시험은 금요일이에요.", "Sınav cuma günü."),
                TargetVocabulary("koa2u5w4", "선생님", "öğretmen", "ifade", "선생님이 다 설명해요.", "Öğretmen her şeyi açıklıyor."),
                TargetVocabulary("koa2u5w5", "회의", "toplantı", "ifade", "회의는 아홉 시에 시작해요.", "Toplantı dokuzda başlıyor."))),
            LearningLesson("KO-A2-U5-L2", "İş ve Okul — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 시내에 있어요.", "", listOf("사무실", "공부해요", "시험"), listOf("사무실"), "Doğru cümle: 사무실이 시내에 있어요. — Ofis şehir merkezinde.", null, null),
                LearningExercise("koa2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 다 설명해요.", "", listOf("회의", "사무실", "선생님"), listOf("선생님"), "Doğru cümle: 선생님이 다 설명해요. — Öğretmen her şeyi açıklıyor.", null, null),
                LearningExercise("koa2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sınav cuma günü.", "Toplantı dokuzda başlıyor.", "Ofis şehir merkezinde."), listOf("Toplantı dokuzda başlıyor."), "Söylenen cümle: 회의는 아홉 시에 시작해요.", "회의는 아홉 시에 시작해요.", null),
                LearningExercise("koa2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "선생님이 다 설명해요.", listOf("Korece çalışıyorum.", "Toplantı dokuzda başlıyor.", "Öğretmen her şeyi açıklıyor."), listOf("Öğretmen her şeyi açıklıyor."), "Cümlenin çevirisi: Öğretmen her şeyi açıklıyor.", null, null))),
            LearningLesson("KO-A2-U5-L3", "İş ve Okul — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "한국어를 ___.", "", listOf("공부해요", "회의해요", "시험이에요"), listOf("공부해요"), "Nesne + 하다 fiili: 공부해요.", null, null),
                LearningExercise("koa2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 한국어를 공부해요.", "", listOf(), listOf("한국어를 공부해요."), "Türkçesi: Korece çalışıyorum.", "한국어를 공부해요.", "한국어를 공부해요."),
                LearningExercise("koa2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sınav' ifadesinin Korece karşılığı hangisi?", "", listOf("시험", "사무실", "회의"), listOf("시험"), "Örnek: 시험은 금요일이에요. — Sınav cuma günü.", null, null))))),
        LearningUnit("KO-A2-U6", "Planlar ve Gelecek", "Gelecek planlarını anlat.", listOf(
            LearningLesson("KO-A2-U6-L1", "Planlar ve Gelecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'주말' ne anlama gelir?", "", listOf("hafta sonu", "plan", "gelecek yıl"), listOf("hafta sonu"), "주말에 쉬어요. — Hafta sonu dinlenirim.", null, null),
                LearningExercise("koa2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'계획' ne anlama gelir?", "", listOf("tatil/izin", "gelecek", "plan"), listOf("plan"), "여름 계획이 있어요. — Yaz için bir planım var.", null, null),
                LearningExercise("koa2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'휴가' ne anlama gelir?", "", listOf("hafta sonu", "tatil/izin", "gelecek yıl"), listOf("tatil/izin"), "휴가가 곧 시작돼요. — Tatil yakında başlıyor.", null, null)), listOf(
                TargetVocabulary("koa2u6w1", "주말", "hafta sonu", "ifade", "주말에 쉬어요.", "Hafta sonu dinlenirim."),
                TargetVocabulary("koa2u6w2", "계획", "plan", "ifade", "여름 계획이 있어요.", "Yaz için bir planım var."),
                TargetVocabulary("koa2u6w3", "휴가", "tatil/izin", "ifade", "휴가가 곧 시작돼요.", "Tatil yakında başlıyor."),
                TargetVocabulary("koa2u6w4", "내년", "gelecek yıl", "ifade", "내년에 한국에 가요.", "Gelecek yıl Kore'ye gidiyorum."),
                TargetVocabulary("koa2u6w5", "미래", "gelecek", "ifade", "미래를 준비해요.", "Geleceğe hazırlanıyorum."))),
            LearningLesson("KO-A2-U6-L2", "Planlar ve Gelecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___에 쉬어요.", "", listOf("계획", "휴가", "주말"), listOf("주말"), "Doğru cümle: 주말에 쉬어요. — Hafta sonu dinlenirim.", null, null),
                LearningExercise("koa2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___에 한국에 가요.", "", listOf("주말", "내년", "미래"), listOf("내년"), "Doğru cümle: 내년에 한국에 가요. — Gelecek yıl Kore'ye gidiyorum.", null, null),
                LearningExercise("koa2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Geleceğe hazırlanıyorum.", "Hafta sonu dinlenirim.", "Tatil yakında başlıyor."), listOf("Geleceğe hazırlanıyorum."), "Söylenen cümle: 미래를 준비해요.", "미래를 준비해요.", null),
                LearningExercise("koa2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "내년에 한국에 가요.", listOf("Geleceğe hazırlanıyorum.", "Gelecek yıl Kore'ye gidiyorum.", "Yaz için bir planım var."), listOf("Gelecek yıl Kore'ye gidiyorum."), "Cümlenin çevirisi: Gelecek yıl Kore'ye gidiyorum.", null, null))),
            LearningLesson("KO-A2-U6-L3", "Planlar ve Gelecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "내년에 한국에 ___ 거예요.", "", listOf("갈", "가는", "갔다"), listOf("갈"), "Gelecek zaman: -(으)ㄹ 거예요.", null, null),
                LearningExercise("koa2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 여름 계획이 있어요.", "", listOf(), listOf("여름 계획이 있어요."), "Türkçesi: Yaz için bir planım var.", "여름 계획이 있어요.", "여름 계획이 있어요."),
                LearningExercise("koa2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'tatil/izin' ifadesinin Korece karşılığı hangisi?", "", listOf("주말", "미래", "휴가"), listOf("휴가"), "Örnek: 휴가가 곧 시작돼요. — Tatil yakında başlıyor.", null, null))))),
        LearningUnit("KO-B1-U1", "Deneyimler ve Anılar", "Anılarını ayrıntılarıyla paylaş.", listOf(
            LearningLesson("KO-B1-U1-L1", "Deneyimler ve Anılar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'경험' ne anlama gelir?", "", listOf("hatırlamak", "o zamanlar", "deneyim"), listOf("deneyim"), "그 경험이 저를 바꿨어요. — O deneyim beni değiştirdi.", null, null),
                LearningExercise("kob1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'기억해요' ne anlama gelir?", "", listOf("anı", "hatırlamak", "çocukluk"), listOf("hatırlamak"), "어린 시절을 기억해요. — Çocukluğumu hatırlıyorum.", null, null),
                LearningExercise("kob1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'어린 시절' ne anlama gelir?", "", listOf("çocukluk", "o zamanlar", "deneyim"), listOf("çocukluk"), "어린 시절은 행복했어요. — Çocukluğum mutluydu.", null, null)), listOf(
                TargetVocabulary("kob1u1w1", "경험", "deneyim", "ifade", "그 경험이 저를 바꿨어요.", "O deneyim beni değiştirdi."),
                TargetVocabulary("kob1u1w2", "기억해요", "hatırlamak", "ifade", "어린 시절을 기억해요.", "Çocukluğumu hatırlıyorum."),
                TargetVocabulary("kob1u1w3", "어린 시절", "çocukluk", "ifade", "어린 시절은 행복했어요.", "Çocukluğum mutluydu."),
                TargetVocabulary("kob1u1w4", "그때", "o zamanlar", "ifade", "그때 우리는 시골에 살았어요.", "O zamanlar kırsalda yaşıyorduk."),
                TargetVocabulary("kob1u1w5", "추억", "anı", "ifade", "이 추억은 소중해요.", "Bu anı çok değerli."))),
            LearningLesson("KO-B1-U1-L2", "Deneyimler ve Anılar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그 ___이 저를 바꿨어요.", "", listOf("어린 시절", "경험", "기억해요"), listOf("경험"), "Doğru cümle: 그 경험이 저를 바꿨어요. — O deneyim beni değiştirdi.", null, null),
                LearningExercise("kob1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 우리는 시골에 살았어요.", "", listOf("그때", "추억", "경험"), listOf("그때"), "Doğru cümle: 그때 우리는 시골에 살았어요. — O zamanlar kırsalda yaşıyorduk.", null, null),
                LearningExercise("kob1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O deneyim beni değiştirdi.", "Çocukluğum mutluydu.", "Bu anı çok değerli."), listOf("Bu anı çok değerli."), "Söylenen cümle: 이 추억은 소중해요.", "이 추억은 소중해요.", null),
                LearningExercise("kob1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "그때 우리는 시골에 살았어요.", listOf("O zamanlar kırsalda yaşıyorduk.", "Çocukluğumu hatırlıyorum.", "Bu anı çok değerli."), listOf("O zamanlar kırsalda yaşıyorduk."), "Cümlenin çevirisi: O zamanlar kırsalda yaşıyorduk.", null, null))),
            LearningLesson("KO-B1-U1-L3", "Deneyimler ve Anılar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "어렸을 때 시골에 ___.", "", listOf("살았어요", "살아요", "살 거예요"), listOf("살았어요"), "Geçmiş zaman: 살았어요.", null, null),
                LearningExercise("kob1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 어린 시절을 기억해요.", "", listOf(), listOf("어린 시절을 기억해요."), "Türkçesi: Çocukluğumu hatırlıyorum.", "어린 시절을 기억해요.", "어린 시절을 기억해요."),
                LearningExercise("kob1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'çocukluk' ifadesinin Korece karşılığı hangisi?", "", listOf("추억", "어린 시절", "경험"), listOf("어린 시절"), "Örnek: 어린 시절은 행복했어요. — Çocukluğum mutluydu.", null, null))))),
        LearningUnit("KO-B1-U2", "Medya ve Teknoloji", "Teknoloji ve haberler hakkında konuş.", listOf(
            LearningLesson("KO-B1-U2-L1", "Medya ve Teknoloji — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'뉴스' ne anlama gelir?", "", listOf("bağlantı", "haberler", "cihaz"), listOf("haberler"), "저녁에 뉴스를 봐요. — Akşamları haber izlerim.", null, null),
                LearningExercise("kob1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'기기' ne anlama gelir?", "", listOf("cihaz", "indirme", "ekran"), listOf("cihaz"), "이 기기는 새것이에요. — Bu cihaz yeni.", null, null),
                LearningExercise("kob1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'다운로드' ne anlama gelir?", "", listOf("bağlantı", "haberler", "indirme"), listOf("indirme"), "앱을 다운로드하고 싶어요. — Uygulamayı indirmek istiyorum.", null, null)), listOf(
                TargetVocabulary("kob1u2w1", "뉴스", "haberler", "ifade", "저녁에 뉴스를 봐요.", "Akşamları haber izlerim."),
                TargetVocabulary("kob1u2w2", "기기", "cihaz", "ifade", "이 기기는 새것이에요.", "Bu cihaz yeni."),
                TargetVocabulary("kob1u2w3", "다운로드", "indirme", "ifade", "앱을 다운로드하고 싶어요.", "Uygulamayı indirmek istiyorum."),
                TargetVocabulary("kob1u2w4", "연결", "bağlantı", "ifade", "연결이 느려요.", "Bağlantı yavaş."),
                TargetVocabulary("kob1u2w5", "화면", "ekran", "ifade", "화면이 너무 밝아요.", "Ekran fazla parlak."))),
            LearningLesson("KO-B1-U2-L2", "Medya ve Teknoloji — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "저녁에 ___를 봐요.", "", listOf("뉴스", "기기", "다운로드"), listOf("뉴스"), "Doğru cümle: 저녁에 뉴스를 봐요. — Akşamları haber izlerim.", null, null),
                LearningExercise("kob1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 느려요.", "", listOf("화면", "뉴스", "연결"), listOf("연결"), "Doğru cümle: 연결이 느려요. — Bağlantı yavaş.", null, null),
                LearningExercise("kob1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Uygulamayı indirmek istiyorum.", "Ekran fazla parlak.", "Akşamları haber izlerim."), listOf("Ekran fazla parlak."), "Söylenen cümle: 화면이 너무 밝아요.", "화면이 너무 밝아요.", null),
                LearningExercise("kob1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "연결이 느려요.", listOf("Bu cihaz yeni.", "Ekran fazla parlak.", "Bağlantı yavaş."), listOf("Bağlantı yavaş."), "Cümlenin çevirisi: Bağlantı yavaş.", null, null))),
            LearningLesson("KO-B1-U2-L3", "Medya ve Teknoloji — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "앱을 다운로드___ 싶어요.", "", listOf("하고", "해서", "하면"), listOf("하고"), "İstek kalıbı: -고 싶어요.", null, null),
                LearningExercise("kob1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 이 기기는 새것이에요.", "", listOf(), listOf("이 기기는 새것이에요."), "Türkçesi: Bu cihaz yeni.", "이 기기는 새것이에요.", "이 기기는 새것이에요."),
                LearningExercise("kob1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'indirme' ifadesinin Korece karşılığı hangisi?", "", listOf("다운로드", "뉴스", "화면"), listOf("다운로드"), "Örnek: 앱을 다운로드하고 싶어요. — Uygulamayı indirmek istiyorum.", null, null))))),
        LearningUnit("KO-B1-U3", "Duygular ve İlişkiler", "Duygularını ve ilişkilerini anlat.", listOf(
            LearningLesson("KO-B1-U3-L1", "Duygular ve İlişkiler — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'우정' ne anlama gelir?", "", listOf("arkadaşlık", "güven", "tartışmak/kavga etmek"), listOf("arkadaşlık"), "우리 우정은 강해요. — Arkadaşlığımız güçlü.", null, null),
                LearningExercise("kob1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'신뢰' ne anlama gelir?", "", listOf("hayal kırıklığı", "duygu", "güven"), listOf("güven"), "신뢰는 시간이 걸려요. — Güven zaman alır.", null, null),
                LearningExercise("kob1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'실망' ne anlama gelir?", "", listOf("arkadaşlık", "hayal kırıklığı", "tartışmak/kavga etmek"), listOf("hayal kırıklığı"), "결과에 실망했어요. — Sonuçtan hayal kırıklığına uğradım.", null, null)), listOf(
                TargetVocabulary("kob1u3w1", "우정", "arkadaşlık", "ifade", "우리 우정은 강해요.", "Arkadaşlığımız güçlü."),
                TargetVocabulary("kob1u3w2", "신뢰", "güven", "ifade", "신뢰는 시간이 걸려요.", "Güven zaman alır."),
                TargetVocabulary("kob1u3w3", "실망", "hayal kırıklığı", "ifade", "결과에 실망했어요.", "Sonuçtan hayal kırıklığına uğradım."),
                TargetVocabulary("kob1u3w4", "다퉈요", "tartışmak/kavga etmek", "ifade", "우리는 거의 안 다퉈요.", "Neredeyse hiç kavga etmeyiz."),
                TargetVocabulary("kob1u3w5", "감정", "duygu", "ifade", "이상한 감정이에요.", "Tuhaf bir duygu."))),
            LearningLesson("KO-B1-U3-L2", "Duygular ve İlişkiler — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "우리 ___은 강해요.", "", listOf("신뢰", "실망", "우정"), listOf("우정"), "Doğru cümle: 우리 우정은 강해요. — Arkadaşlığımız güçlü.", null, null),
                LearningExercise("kob1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "우리는 거의 안 ___.", "", listOf("우정", "다퉈요", "감정"), listOf("다퉈요"), "Doğru cümle: 우리는 거의 안 다퉈요. — Neredeyse hiç kavga etmeyiz.", null, null),
                LearningExercise("kob1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Tuhaf bir duygu.", "Arkadaşlığımız güçlü.", "Sonuçtan hayal kırıklığına uğradım."), listOf("Tuhaf bir duygu."), "Söylenen cümle: 이상한 감정이에요.", "이상한 감정이에요.", null),
                LearningExercise("kob1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "우리는 거의 안 다퉈요.", listOf("Tuhaf bir duygu.", "Neredeyse hiç kavga etmeyiz.", "Güven zaman alır."), listOf("Neredeyse hiç kavga etmeyiz."), "Cümlenin çevirisi: Neredeyse hiç kavga etmeyiz.", null, null))),
            LearningLesson("KO-B1-U3-L3", "Duygular ve İlişkiler — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "결과___ 실망했어요.", "", listOf("에", "를", "가"), listOf("에"), "Edat: ...에 실망하다.", null, null),
                LearningExercise("kob1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 신뢰는 시간이 걸려요.", "", listOf(), listOf("신뢰는 시간이 걸려요."), "Türkçesi: Güven zaman alır.", "신뢰는 시간이 걸려요.", "신뢰는 시간이 걸려요."),
                LearningExercise("kob1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'hayal kırıklığı' ifadesinin Korece karşılığı hangisi?", "", listOf("우정", "감정", "실망"), listOf("실망"), "Örnek: 결과에 실망했어요. — Sonuçtan hayal kırıklığına uğradım.", null, null))))),
        LearningUnit("KO-B1-U4", "Kültür ve Gelenekler", "Gelenekleri ve kültürü tanıt.", listOf(
            LearningLesson("KO-B1-U4-L1", "Kültür ve Gelenekler — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'풍습' ne anlama gelir?", "", listOf("festival/bayram", "toplum", "âdet"), listOf("âdet"), "이 풍습은 아주 오래됐어요. — Bu âdet çok eski.", null, null),
                LearningExercise("kob1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'축제' ne anlama gelir?", "", listOf("düzenlenmek", "festival/bayram", "gelenek"), listOf("festival/bayram"), "축제는 사흘 동안 계속돼요. — Festival üç gün sürüyor.", null, null),
                LearningExercise("kob1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'전통' ne anlama gelir?", "", listOf("gelenek", "toplum", "âdet"), listOf("gelenek"), "전통이 이어지고 있어요. — Gelenek sürüyor.", null, null)), listOf(
                TargetVocabulary("kob1u4w1", "풍습", "âdet", "ifade", "이 풍습은 아주 오래됐어요.", "Bu âdet çok eski."),
                TargetVocabulary("kob1u4w2", "축제", "festival/bayram", "ifade", "축제는 사흘 동안 계속돼요.", "Festival üç gün sürüyor."),
                TargetVocabulary("kob1u4w3", "전통", "gelenek", "ifade", "전통이 이어지고 있어요.", "Gelenek sürüyor."),
                TargetVocabulary("kob1u4w4", "사회", "toplum", "ifade", "사회가 빨리 변해요.", "Toplum hızla değişiyor."),
                TargetVocabulary("kob1u4w5", "열려요", "düzenlenmek", "ifade", "축제는 오월에 열려요.", "Festival mayısta düzenlenir."))),
            LearningLesson("KO-B1-U4-L2", "Kültür ve Gelenekler — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "이 ___은 아주 오래됐어요.", "", listOf("전통", "풍습", "축제"), listOf("풍습"), "Doğru cümle: 이 풍습은 아주 오래됐어요. — Bu âdet çok eski.", null, null),
                LearningExercise("kob1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 빨리 변해요.", "", listOf("사회", "열려요", "풍습"), listOf("사회"), "Doğru cümle: 사회가 빨리 변해요. — Toplum hızla değişiyor.", null, null),
                LearningExercise("kob1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu âdet çok eski.", "Gelenek sürüyor.", "Festival mayısta düzenlenir."), listOf("Festival mayısta düzenlenir."), "Söylenen cümle: 축제는 오월에 열려요.", "축제는 오월에 열려요.", null),
                LearningExercise("kob1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "사회가 빨리 변해요.", listOf("Toplum hızla değişiyor.", "Festival üç gün sürüyor.", "Festival mayısta düzenlenir."), listOf("Toplum hızla değişiyor."), "Cümlenin çevirisi: Toplum hızla değişiyor.", null, null))),
            LearningLesson("KO-B1-U4-L3", "Kültür ve Gelenekler — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "축제는 오월에 ___.", "", listOf("열려요", "열어요", "열었어요"), listOf("열려요"), "Edilgen: 열리다 (düzenlenmek).", null, null),
                LearningExercise("kob1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 축제는 사흘 동안 계속돼요.", "", listOf(), listOf("축제는 사흘 동안 계속돼요."), "Türkçesi: Festival üç gün sürüyor.", "축제는 사흘 동안 계속돼요.", "축제는 사흘 동안 계속돼요."),
                LearningExercise("kob1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gelenek' ifadesinin Korece karşılığı hangisi?", "", listOf("열려요", "전통", "풍습"), listOf("전통"), "Örnek: 전통이 이어지고 있어요. — Gelenek sürüyor.", null, null))))),
        LearningUnit("KO-B1-U5", "Spor ve Sağlıklı Yaşam", "Sağlıklı yaşam alışkanlıklarını anlat.", listOf(
            LearningLesson("KO-B1-U5-L1", "Spor ve Sağlıklı Yaşam — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'건강' ne anlama gelir?", "", listOf("kaçınmak", "sağlık", "spor yapmak"), listOf("sağlık"), "건강이 제일 중요해요. — Sağlık en önemlisi.", null, null),
                LearningExercise("kob1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'운동해요' ne anlama gelir?", "", listOf("spor yapmak", "beslenme düzeni", "alışkanlık"), listOf("spor yapmak"), "매일 운동해요. — Her gün spor yaparım.", null, null),
                LearningExercise("kob1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'식단' ne anlama gelir?", "", listOf("kaçınmak", "sağlık", "beslenme düzeni"), listOf("beslenme düzeni"), "건강한 식단이 중요해요. — Sağlıklı beslenme düzeni önemli.", null, null)), listOf(
                TargetVocabulary("kob1u5w1", "건강", "sağlık", "ifade", "건강이 제일 중요해요.", "Sağlık en önemlisi."),
                TargetVocabulary("kob1u5w2", "운동해요", "spor yapmak", "ifade", "매일 운동해요.", "Her gün spor yaparım."),
                TargetVocabulary("kob1u5w3", "식단", "beslenme düzeni", "ifade", "건강한 식단이 중요해요.", "Sağlıklı beslenme düzeni önemli."),
                TargetVocabulary("kob1u5w4", "피해요", "kaçınmak", "ifade", "설탕을 피해요.", "Şekerden kaçınırım."),
                TargetVocabulary("kob1u5w5", "습관", "alışkanlık", "ifade", "좋은 습관을 만들어요.", "İyi alışkanlıklar ediniyorum."))),
            LearningLesson("KO-B1-U5-L2", "Spor ve Sağlıklı Yaşam — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 제일 중요해요.", "", listOf("건강", "운동해요", "식단"), listOf("건강"), "Doğru cümle: 건강이 제일 중요해요. — Sağlık en önemlisi.", null, null),
                LearningExercise("kob1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "설탕을 ___.", "", listOf("습관", "건강", "피해요"), listOf("피해요"), "Doğru cümle: 설탕을 피해요. — Şekerden kaçınırım.", null, null),
                LearningExercise("kob1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sağlıklı beslenme düzeni önemli.", "İyi alışkanlıklar ediniyorum.", "Sağlık en önemlisi."), listOf("İyi alışkanlıklar ediniyorum."), "Söylenen cümle: 좋은 습관을 만들어요.", "좋은 습관을 만들어요.", null),
                LearningExercise("kob1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "설탕을 피해요.", listOf("Her gün spor yaparım.", "İyi alışkanlıklar ediniyorum.", "Şekerden kaçınırım."), listOf("Şekerden kaçınırım."), "Cümlenin çevirisi: Şekerden kaçınırım.", null, null))),
            LearningLesson("KO-B1-U5-L3", "Spor ve Sağlıklı Yaşam — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "설탕을 ___ 게 좋아요.", "", listOf("피하는", "피해서", "피한"), listOf("피하는"), "Tavsiye: -는 게 좋아요.", null, null),
                LearningExercise("kob1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 매일 운동해요.", "", listOf(), listOf("매일 운동해요."), "Türkçesi: Her gün spor yaparım.", "매일 운동해요.", "매일 운동해요."),
                LearningExercise("kob1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'beslenme düzeni' ifadesinin Korece karşılığı hangisi?", "", listOf("식단", "건강", "습관"), listOf("식단"), "Örnek: 건강한 식단이 중요해요. — Sağlıklı beslenme düzeni önemli.", null, null))))),
        LearningUnit("KO-B1-U6", "Görüş Bildirmek", "Fikrini gerekçeleriyle savun.", listOf(
            LearningLesson("KO-B1-U6-L1", "Görüş Bildirmek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'의견' ne anlama gelir?", "", listOf("görüş", "katılma (fikre)", "sebep"), listOf("görüş"), "이것이 제 의견이에요. — Bu benim görüşüm.", null, null),
                LearningExercise("kob1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'찬성' ne anlama gelir?", "", listOf("karşı çıkma", "ikna", "katılma (fikre)"), listOf("katılma (fikre)"), "저는 찬성해요. — Ben katılıyorum.", null, null),
                LearningExercise("kob1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'반대' ne anlama gelir?", "", listOf("görüş", "karşı çıkma", "sebep"), listOf("karşı çıkma"), "그 생각에 반대해요. — O düşünceye karşıyım.", null, null)), listOf(
                TargetVocabulary("kob1u6w1", "의견", "görüş", "ifade", "이것이 제 의견이에요.", "Bu benim görüşüm."),
                TargetVocabulary("kob1u6w2", "찬성", "katılma (fikre)", "ifade", "저는 찬성해요.", "Ben katılıyorum."),
                TargetVocabulary("kob1u6w3", "반대", "karşı çıkma", "ifade", "그 생각에 반대해요.", "O düşünceye karşıyım."),
                TargetVocabulary("kob1u6w4", "이유", "sebep", "ifade", "좋은 이유가 있어요.", "İyi bir sebep var."),
                TargetVocabulary("kob1u6w5", "설득", "ikna", "ifade", "저를 설득할 수 없어요.", "Beni ikna edemezsiniz."))),
            LearningLesson("KO-B1-U6-L2", "Görüş Bildirmek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "이것이 제 ___이에요.", "", listOf("찬성", "반대", "의견"), listOf("의견"), "Doğru cümle: 이것이 제 의견이에요. — Bu benim görüşüm.", null, null),
                LearningExercise("kob1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "좋은 ___가 있어요.", "", listOf("의견", "이유", "설득"), listOf("이유"), "Doğru cümle: 좋은 이유가 있어요. — İyi bir sebep var.", null, null),
                LearningExercise("kob1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Beni ikna edemezsiniz.", "Bu benim görüşüm.", "O düşünceye karşıyım."), listOf("Beni ikna edemezsiniz."), "Söylenen cümle: 저를 설득할 수 없어요.", "저를 설득할 수 없어요.", null),
                LearningExercise("kob1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "좋은 이유가 있어요.", listOf("Beni ikna edemezsiniz.", "İyi bir sebep var.", "Ben katılıyorum."), listOf("İyi bir sebep var."), "Cümlenin çevirisi: İyi bir sebep var.", null, null))),
            LearningLesson("KO-B1-U6-L3", "Görüş Bildirmek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "저는 그 의견에 ___해요.", "", listOf("찬성", "반대로", "이유"), listOf("찬성"), "Kalıp: ...에 찬성하다 (fikre katılmak).", null, null),
                LearningExercise("kob1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 저는 찬성해요.", "", listOf(), listOf("저는 찬성해요."), "Türkçesi: Ben katılıyorum.", "저는 찬성해요.", "저는 찬성해요."),
                LearningExercise("kob1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'karşı çıkma' ifadesinin Korece karşılığı hangisi?", "", listOf("의견", "설득", "반대"), listOf("반대"), "Örnek: 그 생각에 반대해요. — O düşünceye karşıyım.", null, null))))),
        LearningUnit("KO-B2-U1", "Kariyer ve İş Dünyası", "İş görüşmesi ve kariyer dilinde ustalaş.", listOf(
            LearningLesson("KO-B2-U1-L1", "Kariyer ve İş Dünyası — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'이력서' ne anlama gelir?", "", listOf("mülakat", "sorumluluk", "özgeçmiş"), listOf("özgeçmiş"), "이력서는 짧게 써요. — Özgeçmişi kısa yazarım.", null, null),
                LearningExercise("kob2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'면접' ne anlama gelir?", "", listOf("kariyer", "mülakat", "işe alım"), listOf("mülakat"), "면접이 잘 됐어요. — Mülakat iyi geçti.", null, null),
                LearningExercise("kob2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'채용' ne anlama gelir?", "", listOf("işe alım", "sorumluluk", "özgeçmiş"), listOf("işe alım"), "그녀는 회사에 채용되었어요. — Şirkete işe alındı.", null, null)), listOf(
                TargetVocabulary("kob2u1w1", "이력서", "özgeçmiş", "ifade", "이력서는 짧게 써요.", "Özgeçmişi kısa yazarım."),
                TargetVocabulary("kob2u1w2", "면접", "mülakat", "ifade", "면접이 잘 됐어요.", "Mülakat iyi geçti."),
                TargetVocabulary("kob2u1w3", "채용", "işe alım", "ifade", "그녀는 회사에 채용되었어요.", "Şirkete işe alındı."),
                TargetVocabulary("kob2u1w4", "책임", "sorumluluk", "ifade", "책임을 질게요.", "Sorumluluğu üstleneceğim."),
                TargetVocabulary("kob2u1w5", "경력", "kariyer", "ifade", "경력이 빨리 쌓이고 있어요.", "Kariyeri hızla ilerliyor."))),
            LearningLesson("KO-B2-U1-L2", "Kariyer ve İş Dünyası — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___는 짧게 써요.", "", listOf("채용", "이력서", "면접"), listOf("이력서"), "Doğru cümle: 이력서는 짧게 써요. — Özgeçmişi kısa yazarım.", null, null),
                LearningExercise("kob2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___을 질게요.", "", listOf("책임", "경력", "이력서"), listOf("책임"), "Doğru cümle: 책임을 질게요. — Sorumluluğu üstleneceğim.", null, null),
                LearningExercise("kob2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Özgeçmişi kısa yazarım.", "Şirkete işe alındı.", "Kariyeri hızla ilerliyor."), listOf("Kariyeri hızla ilerliyor."), "Söylenen cümle: 경력이 빨리 쌓이고 있어요.", "경력이 빨리 쌓이고 있어요.", null),
                LearningExercise("kob2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "책임을 질게요.", listOf("Sorumluluğu üstleneceğim.", "Mülakat iyi geçti.", "Kariyeri hızla ilerliyor."), listOf("Sorumluluğu üstleneceğim."), "Cümlenin çevirisi: Sorumluluğu üstleneceğim.", null, null))),
            LearningLesson("KO-B2-U1-L3", "Kariyer ve İş Dünyası — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "그녀는 회사에 채용___.", "", listOf("되었어요", "했어요", "시켰어요"), listOf("되었어요"), "Edilgen: 채용되다 (işe alınmak).", null, null),
                LearningExercise("kob2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 면접이 잘 됐어요.", "", listOf(), listOf("면접이 잘 됐어요."), "Türkçesi: Mülakat iyi geçti.", "면접이 잘 됐어요.", "면접이 잘 됐어요."),
                LearningExercise("kob2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'işe alım' ifadesinin Korece karşılığı hangisi?", "", listOf("경력", "채용", "이력서"), listOf("채용"), "Örnek: 그녀는 회사에 채용되었어요. — Şirkete işe alındı.", null, null))))),
        LearningUnit("KO-B2-U2", "Çevre ve Sürdürülebilirlik", "Çevre sorunlarını tartış.", listOf(
            LearningLesson("KO-B2-U2-L1", "Çevre ve Sürdürülebilirlik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'환경' ne anlama gelir?", "", listOf("çöp", "çevre", "iklim değişikliği"), listOf("çevre"), "환경을 보호해야 해요. — Çevreyi korumalıyız.", null, null),
                LearningExercise("kob2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'기후 변화' ne anlama gelir?", "", listOf("iklim değişikliği", "sürdürülebilir", "yenilenebilir"), listOf("iklim değişikliği"), "기후 변화는 모두에게 영향을 줘요. — İklim değişikliği herkesi etkiliyor.", null, null),
                LearningExercise("kob2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'지속 가능' ne anlama gelir?", "", listOf("çöp", "çevre", "sürdürülebilir"), listOf("sürdürülebilir"), "지속 가능한 해결책이 필요해요. — Sürdürülebilir çözümler gerekli.", null, null)), listOf(
                TargetVocabulary("kob2u2w1", "환경", "çevre", "ifade", "환경을 보호해야 해요.", "Çevreyi korumalıyız."),
                TargetVocabulary("kob2u2w2", "기후 변화", "iklim değişikliği", "ifade", "기후 변화는 모두에게 영향을 줘요.", "İklim değişikliği herkesi etkiliyor."),
                TargetVocabulary("kob2u2w3", "지속 가능", "sürdürülebilir", "ifade", "지속 가능한 해결책이 필요해요.", "Sürdürülebilir çözümler gerekli."),
                TargetVocabulary("kob2u2w4", "쓰레기", "çöp", "ifade", "쓰레기를 분리해요.", "Çöpü ayrıştırıyoruz."),
                TargetVocabulary("kob2u2w5", "재생 가능", "yenilenebilir", "ifade", "재생 가능 에너지가 미래예요.", "Yenilenebilir enerji gelecektir."))),
            LearningLesson("KO-B2-U2-L2", "Çevre ve Sürdürülebilirlik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___을 보호해야 해요.", "", listOf("환경", "기후 변화", "지속 가능"), listOf("환경"), "Doğru cümle: 환경을 보호해야 해요. — Çevreyi korumalıyız.", null, null),
                LearningExercise("kob2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___를 분리해요.", "", listOf("재생 가능", "환경", "쓰레기"), listOf("쓰레기"), "Doğru cümle: 쓰레기를 분리해요. — Çöpü ayrıştırıyoruz.", null, null),
                LearningExercise("kob2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sürdürülebilir çözümler gerekli.", "Yenilenebilir enerji gelecektir.", "Çevreyi korumalıyız."), listOf("Yenilenebilir enerji gelecektir."), "Söylenen cümle: 재생 가능 에너지가 미래예요.", "재생 가능 에너지가 미래예요.", null),
                LearningExercise("kob2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "쓰레기를 분리해요.", listOf("İklim değişikliği herkesi etkiliyor.", "Yenilenebilir enerji gelecektir.", "Çöpü ayrıştırıyoruz."), listOf("Çöpü ayrıştırıyoruz."), "Cümlenin çevirisi: Çöpü ayrıştırıyoruz.", null, null))),
            LearningLesson("KO-B2-U2-L3", "Çevre ve Sürdürülebilirlik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "쓰레기가 적을___ 환경에 좋아요.", "", listOf("수록", "도록", "니까"), listOf("수록"), "Karşılaştırma: -(으)ㄹ수록 (oldukça).", null, null),
                LearningExercise("kob2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 기후 변화는 모두에게 영향을 줘요.", "", listOf(), listOf("기후 변화는 모두에게 영향을 줘요."), "Türkçesi: İklim değişikliği herkesi etkiliyor.", "기후 변화는 모두에게 영향을 줘요.", "기후 변화는 모두에게 영향을 줘요."),
                LearningExercise("kob2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sürdürülebilir' ifadesinin Korece karşılığı hangisi?", "", listOf("지속 가능", "환경", "재생 가능"), listOf("지속 가능"), "Örnek: 지속 가능한 해결책이 필요해요. — Sürdürülebilir çözümler gerekli.", null, null))))),
        LearningUnit("KO-B2-U3", "Bilim ve Yenilik", "Bilimsel gelişmeleri aktar.", listOf(
            LearningLesson("KO-B2-U3-L1", "Bilim ve Yenilik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'연구' ne anlama gelir?", "", listOf("araştırma", "keşif", "kanıtlama"), listOf("araştırma"), "연구가 계속되고 있어요. — Araştırma devam ediyor.", null, null),
                LearningExercise("kob2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'발견' ne anlama gelir?", "", listOf("ilerleme/gelişme", "sonuç", "keşif"), listOf("keşif"), "중요한 발견이었어요. — Önemli bir keşifti.", null, null),
                LearningExercise("kob2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'발전' ne anlama gelir?", "", listOf("araştırma", "ilerleme/gelişme", "kanıtlama"), listOf("ilerleme/gelişme"), "발전이 뚜렷해요. — Gelişme belirgin.", null, null)), listOf(
                TargetVocabulary("kob2u3w1", "연구", "araştırma", "ifade", "연구가 계속되고 있어요.", "Araştırma devam ediyor."),
                TargetVocabulary("kob2u3w2", "발견", "keşif", "ifade", "중요한 발견이었어요.", "Önemli bir keşifti."),
                TargetVocabulary("kob2u3w3", "발전", "ilerleme/gelişme", "ifade", "발전이 뚜렷해요.", "Gelişme belirgin."),
                TargetVocabulary("kob2u3w4", "증명", "kanıtlama", "ifade", "이론이 증명되었어요.", "Teori kanıtlandı."),
                TargetVocabulary("kob2u3w5", "결과", "sonuç", "ifade", "결과에 놀랐어요.", "Sonuca şaşırdık."))),
            LearningLesson("KO-B2-U3-L2", "Bilim ve Yenilik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 계속되고 있어요.", "", listOf("발견", "발전", "연구"), listOf("연구"), "Doğru cümle: 연구가 계속되고 있어요. — Araştırma devam ediyor.", null, null),
                LearningExercise("kob2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "이론이 ___되었어요.", "", listOf("연구", "증명", "결과"), listOf("증명"), "Doğru cümle: 이론이 증명되었어요. — Teori kanıtlandı.", null, null),
                LearningExercise("kob2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sonuca şaşırdık.", "Araştırma devam ediyor.", "Gelişme belirgin."), listOf("Sonuca şaşırdık."), "Söylenen cümle: 결과에 놀랐어요.", "결과에 놀랐어요.", null),
                LearningExercise("kob2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "이론이 증명되었어요.", listOf("Sonuca şaşırdık.", "Teori kanıtlandı.", "Önemli bir keşifti."), listOf("Teori kanıtlandı."), "Cümlenin çevirisi: Teori kanıtlandı.", null, null))),
            LearningLesson("KO-B2-U3-L3", "Bilim ve Yenilik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "이론이 ___되었어요.", "", listOf("증명", "연구서", "발견해"), listOf("증명"), "Edilgen: 증명되다 (kanıtlanmak).", null, null),
                LearningExercise("kob2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 중요한 발견이었어요.", "", listOf(), listOf("중요한 발견이었어요."), "Türkçesi: Önemli bir keşifti.", "중요한 발견이었어요.", "중요한 발견이었어요."),
                LearningExercise("kob2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ilerleme/gelişme' ifadesinin Korece karşılığı hangisi?", "", listOf("연구", "결과", "발전"), listOf("발전"), "Örnek: 발전이 뚜렷해요. — Gelişme belirgin.", null, null))))),
        LearningUnit("KO-B2-U4", "Toplum ve Güncel Konular", "Toplumsal konularda görüş geliştir.", listOf(
            LearningLesson("KO-B2-U4-L1", "Toplum ve Güncel Konular — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'정의' ne anlama gelir?", "", listOf("eşitlik", "yoksulluk", "adalet"), listOf("adalet"), "정의는 기본 가치예요. — Adalet temel bir değerdir.", null, null),
                LearningExercise("kob2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'평등' ne anlama gelir?", "", listOf("tartışma", "eşitlik", "vatandaş"), listOf("eşitlik"), "법 앞의 평등. — Yasa önünde eşitlik.", null, null),
                LearningExercise("kob2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'시민' ne anlama gelir?", "", listOf("vatandaş", "yoksulluk", "adalet"), listOf("vatandaş"), "모든 시민에게 권리가 있어요. — Her vatandaşın hakları vardır.", null, null)), listOf(
                TargetVocabulary("kob2u4w1", "정의", "adalet", "ifade", "정의는 기본 가치예요.", "Adalet temel bir değerdir."),
                TargetVocabulary("kob2u4w2", "평등", "eşitlik", "ifade", "법 앞의 평등.", "Yasa önünde eşitlik."),
                TargetVocabulary("kob2u4w3", "시민", "vatandaş", "ifade", "모든 시민에게 권리가 있어요.", "Her vatandaşın hakları vardır."),
                TargetVocabulary("kob2u4w4", "빈곤", "yoksulluk", "ifade", "빈곤과 싸워야 해요.", "Yoksullukla mücadele etmeliyiz."),
                TargetVocabulary("kob2u4w5", "토론", "tartışma", "ifade", "토론이 계속돼요.", "Tartışma sürüyor."))),
            LearningLesson("KO-B2-U4-L2", "Toplum ve Güncel Konular — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___는 기본 가치예요.", "", listOf("시민", "정의", "평등"), listOf("정의"), "Doğru cümle: 정의는 기본 가치예요. — Adalet temel bir değerdir.", null, null),
                LearningExercise("kob2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___과 싸워야 해요.", "", listOf("빈곤", "토론", "정의"), listOf("빈곤"), "Doğru cümle: 빈곤과 싸워야 해요. — Yoksullukla mücadele etmeliyiz.", null, null),
                LearningExercise("kob2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Adalet temel bir değerdir.", "Her vatandaşın hakları vardır.", "Tartışma sürüyor."), listOf("Tartışma sürüyor."), "Söylenen cümle: 토론이 계속돼요.", "토론이 계속돼요.", null),
                LearningExercise("kob2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "빈곤과 싸워야 해요.", listOf("Yoksullukla mücadele etmeliyiz.", "Yasa önünde eşitlik.", "Tartışma sürüyor."), listOf("Yoksullukla mücadele etmeliyiz."), "Cümlenin çevirisi: Yoksullukla mücadele etmeliyiz.", null, null))),
            LearningLesson("KO-B2-U4-L3", "Toplum ve Güncel Konular — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "어렵___ 계속해요.", "", listOf("지만", "니까", "려고"), listOf("지만"), "Zıtlık eki: -지만 (-e rağmen).", null, null),
                LearningExercise("kob2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 법 앞의 평등.", "", listOf(), listOf("법 앞의 평등."), "Türkçesi: Yasa önünde eşitlik.", "법 앞의 평등.", "법 앞의 평등."),
                LearningExercise("kob2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'vatandaş' ifadesinin Korece karşılığı hangisi?", "", listOf("토론", "시민", "정의"), listOf("시민"), "Örnek: 모든 시민에게 권리가 있어요. — Her vatandaşın hakları vardır.", null, null))))),
        LearningUnit("KO-B2-U5", "Sanat ve Edebiyat", "Sanat eserlerini yorumla.", listOf(
            LearningLesson("KO-B2-U5-L1", "Sanat ve Edebiyat — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'그림' ne anlama gelir?", "", listOf("etkileyici", "tablo/resim", "roman"), listOf("tablo/resim"), "그림이 박물관에 있어요. — Tablo müzede.", null, null),
                LearningExercise("kob2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'소설' ne anlama gelir?", "", listOf("roman", "sergi", "yazar"), listOf("roman"), "소설은 사백 페이지예요. — Roman dört yüz sayfa.", null, null),
                LearningExercise("kob2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'전시회' ne anlama gelir?", "", listOf("etkileyici", "tablo/resim", "sergi"), listOf("sergi"), "전시회가 내일 열려요. — Sergi yarın açılıyor.", null, null)), listOf(
                TargetVocabulary("kob2u5w1", "그림", "tablo/resim", "ifade", "그림이 박물관에 있어요.", "Tablo müzede."),
                TargetVocabulary("kob2u5w2", "소설", "roman", "ifade", "소설은 사백 페이지예요.", "Roman dört yüz sayfa."),
                TargetVocabulary("kob2u5w3", "전시회", "sergi", "ifade", "전시회가 내일 열려요.", "Sergi yarın açılıyor."),
                TargetVocabulary("kob2u5w4", "인상적", "etkileyici", "ifade", "인상적인 작품이에요.", "Etkileyici bir eser."),
                TargetVocabulary("kob2u5w5", "작가", "yazar", "ifade", "작가가 오늘 밤 낭독해요.", "Yazar bu akşam okuma yapıyor."))),
            LearningLesson("KO-B2-U5-L2", "Sanat ve Edebiyat — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 박물관에 있어요.", "", listOf("그림", "소설", "전시회"), listOf("그림"), "Doğru cümle: 그림이 박물관에 있어요. — Tablo müzede.", null, null),
                LearningExercise("kob2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___인 작품이에요.", "", listOf("작가", "그림", "인상적"), listOf("인상적"), "Doğru cümle: 인상적인 작품이에요. — Etkileyici bir eser.", null, null),
                LearningExercise("kob2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sergi yarın açılıyor.", "Yazar bu akşam okuma yapıyor.", "Tablo müzede."), listOf("Yazar bu akşam okuma yapıyor."), "Söylenen cümle: 작가가 오늘 밤 낭독해요.", "작가가 오늘 밤 낭독해요.", null),
                LearningExercise("kob2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "인상적인 작품이에요.", listOf("Roman dört yüz sayfa.", "Yazar bu akşam okuma yapıyor.", "Etkileyici bir eser."), listOf("Etkileyici bir eser."), "Cümlenin çevirisi: Etkileyici bir eser.", null, null))),
            LearningLesson("KO-B2-U5-L3", "Sanat ve Edebiyat — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "제가 읽___ 있는 소설은 재미있어요.", "", listOf("고", "서", "게"), listOf("고"), "Süreklilik: -고 있다.", null, null),
                LearningExercise("kob2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 소설은 사백 페이지예요.", "", listOf(), listOf("소설은 사백 페이지예요."), "Türkçesi: Roman dört yüz sayfa.", "소설은 사백 페이지예요.", "소설은 사백 페이지예요."),
                LearningExercise("kob2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sergi' ifadesinin Korece karşılığı hangisi?", "", listOf("전시회", "그림", "작가"), listOf("전시회"), "Örnek: 전시회가 내일 열려요. — Sergi yarın açılıyor.", null, null))))),
        LearningUnit("KO-B2-U6", "Tartışma ve İkna", "Karşıt görüşleri dengeli biçimde tart.", listOf(
            LearningLesson("KO-B2-U6-L1", "Tartışma ve İkna — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("kob2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'논점' ne anlama gelir?", "", listOf("tartışma noktası", "bir yandan", "karşı argüman"), listOf("tartışma noktası"), "논점이 명확해요. — Tartışma noktası net.", null, null),
                LearningExercise("kob2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'한편' ne anlama gelir?", "", listOf("öte yandan", "sonuç/çıkarım", "bir yandan"), listOf("bir yandan"), "한편으로는 비싸요. — Bir yandan pahalı.", null, null),
                LearningExercise("kob2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'반면에' ne anlama gelir?", "", listOf("tartışma noktası", "öte yandan", "karşı argüman"), listOf("öte yandan"), "반면에 유용해요. — Öte yandan faydalı.", null, null)), listOf(
                TargetVocabulary("kob2u6w1", "논점", "tartışma noktası", "ifade", "논점이 명확해요.", "Tartışma noktası net."),
                TargetVocabulary("kob2u6w2", "한편", "bir yandan", "ifade", "한편으로는 비싸요.", "Bir yandan pahalı."),
                TargetVocabulary("kob2u6w3", "반면에", "öte yandan", "ifade", "반면에 유용해요.", "Öte yandan faydalı."),
                TargetVocabulary("kob2u6w4", "반박", "karşı argüman", "ifade", "반박이 있어요.", "Bir karşı argümanım var."),
                TargetVocabulary("kob2u6w5", "결론", "sonuç/çıkarım", "ifade", "결론이 분명해요.", "Çıkarım açık."))),
            LearningLesson("KO-B2-U6-L2", "Tartışma ve İkna — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("kob2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 명확해요.", "", listOf("한편", "반면에", "논점"), listOf("논점"), "Doğru cümle: 논점이 명확해요. — Tartışma noktası net.", null, null),
                LearningExercise("kob2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 있어요.", "", listOf("논점", "반박", "결론"), listOf("반박"), "Doğru cümle: 반박이 있어요. — Bir karşı argümanım var.", null, null),
                LearningExercise("kob2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çıkarım açık.", "Tartışma noktası net.", "Öte yandan faydalı."), listOf("Çıkarım açık."), "Söylenen cümle: 결론이 분명해요.", "결론이 분명해요.", null),
                LearningExercise("kob2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "반박이 있어요.", listOf("Çıkarım açık.", "Bir karşı argümanım var.", "Bir yandan pahalı."), listOf("Bir karşı argümanım var."), "Cümlenin çevirisi: Bir karşı argümanım var.", null, null))),
            LearningLesson("KO-B2-U6-L3", "Tartışma ve İkna — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("kob2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "한편으로는 비싸지만, ___ 유용해요.", "", listOf("반면에", "한편에서", "게다가도"), listOf("반면에"), "Kalıp: 한편으로는...반면에...", null, null),
                LearningExercise("kob2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 한편으로는 비싸요.", "", listOf(), listOf("한편으로는 비싸요."), "Türkçesi: Bir yandan pahalı.", "한편으로는 비싸요.", "한편으로는 비싸요."),
                LearningExercise("kob2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'öte yandan' ifadesinin Korece karşılığı hangisi?", "", listOf("논점", "결론", "반면에"), listOf("반면에"), "Örnek: 반면에 유용해요. — Öte yandan faydalı.", null, null))))),
        LearningUnit("KO-C1-U1", "Akademik Dil", "Akademik metinleri çözümle ve üret.", listOf(
            LearningLesson("KO-C1-U1-L1", "Akademik Dil — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'논문' ne anlama gelir?", "", listOf("çözümleme", "kaynak (alıntı)", "makale/tez"), listOf("makale/tez"), "이 논문은 논란이 돼요. — Bu makale tartışma yaratıyor.", null, null),
                LearningExercise("koc1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'분석' ne anlama gelir?", "", listOf("yöntem bilimi", "çözümleme", "inceleme"), listOf("çözümleme"), "분석은 십 년의 데이터를 다뤄요. — Çözümleme on yıllık veriyi ele alıyor.", null, null),
                LearningExercise("koc1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'검토' ne anlama gelir?", "", listOf("inceleme", "kaynak (alıntı)", "makale/tez"), listOf("inceleme"), "내일 이 문제를 검토해요. — Bu konuyu yarın inceleyeceğiz.", null, null)), listOf(
                TargetVocabulary("koc1u1w1", "논문", "makale/tez", "ifade", "이 논문은 논란이 돼요.", "Bu makale tartışma yaratıyor."),
                TargetVocabulary("koc1u1w2", "분석", "çözümleme", "ifade", "분석은 십 년의 데이터를 다뤄요.", "Çözümleme on yıllık veriyi ele alıyor."),
                TargetVocabulary("koc1u1w3", "검토", "inceleme", "ifade", "내일 이 문제를 검토해요.", "Bu konuyu yarın inceleyeceğiz."),
                TargetVocabulary("koc1u1w4", "출처", "kaynak (alıntı)", "ifade", "출처가 믿을 만해요.", "Kaynak güvenilir."),
                TargetVocabulary("koc1u1w5", "방법론", "yöntem bilimi", "ifade", "이 방법론은 유망해요.", "Bu metodoloji umut verici."))),
            LearningLesson("KO-C1-U1-L2", "Akademik Dil — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "이 ___은 논란이 돼요.", "", listOf("검토", "논문", "분석"), listOf("논문"), "Doğru cümle: 이 논문은 논란이 돼요. — Bu makale tartışma yaratıyor.", null, null),
                LearningExercise("koc1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 믿을 만해요.", "", listOf("출처", "방법론", "논문"), listOf("출처"), "Doğru cümle: 출처가 믿을 만해요. — Kaynak güvenilir.", null, null),
                LearningExercise("koc1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu makale tartışma yaratıyor.", "Bu konuyu yarın inceleyeceğiz.", "Bu metodoloji umut verici."), listOf("Bu metodoloji umut verici."), "Söylenen cümle: 이 방법론은 유망해요.", "이 방법론은 유망해요.", null),
                LearningExercise("koc1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "출처가 믿을 만해요.", listOf("Kaynak güvenilir.", "Çözümleme on yıllık veriyi ele alıyor.", "Bu metodoloji umut verici."), listOf("Kaynak güvenilir."), "Cümlenin çevirisi: Kaynak güvenilir.", null, null))),
            LearningLesson("KO-C1-U1-L3", "Akademik Dil — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "연구에 ___ 숫자가 늘고 있어요.", "", listOf("따르면", "따라서", "따라도"), listOf("따르면"), "Atıf kalıbı: ...에 따르면 (-e göre).", null, null),
                LearningExercise("koc1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 분석은 십 년의 데이터를 다뤄요.", "", listOf(), listOf("분석은 십 년의 데이터를 다뤄요."), "Türkçesi: Çözümleme on yıllık veriyi ele alıyor.", "분석은 십 년의 데이터를 다뤄요.", "분석은 십 년의 데이터를 다뤄요."),
                LearningExercise("koc1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'inceleme' ifadesinin Korece karşılığı hangisi?", "", listOf("방법론", "검토", "논문"), listOf("검토"), "Örnek: 내일 이 문제를 검토해요. — Bu konuyu yarın inceleyeceğiz.", null, null))))),
        LearningUnit("KO-C1-U2", "Soyut Kavramlar", "Soyut düşünceleri akıcı ifade et.", listOf(
            LearningLesson("KO-C1-U2-L1", "Soyut Kavramlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'지각' ne anlama gelir?", "", listOf("düşünce/anlayış", "algı", "bilinç"), listOf("algı"), "지각은 우리를 자주 속여요. — Algı bizi sık yanıltır.", null, null),
                LearningExercise("koc1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'의식' ne anlama gelir?", "", listOf("bilinç", "kavram", "kavrayış"), listOf("bilinç"), "의식은 아직 수수께끼예요. — Bilinç hâlâ bir muamma.", null, null),
                LearningExercise("koc1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'개념' ne anlama gelir?", "", listOf("düşünce/anlayış", "algı", "kavram"), listOf("kavram"), "이 개념은 정의하기 어려워요. — Bu kavramı tanımlamak zor.", null, null)), listOf(
                TargetVocabulary("koc1u2w1", "지각", "algı", "ifade", "지각은 우리를 자주 속여요.", "Algı bizi sık yanıltır."),
                TargetVocabulary("koc1u2w2", "의식", "bilinç", "ifade", "의식은 아직 수수께끼예요.", "Bilinç hâlâ bir muamma."),
                TargetVocabulary("koc1u2w3", "개념", "kavram", "ifade", "이 개념은 정의하기 어려워요.", "Bu kavramı tanımlamak zor."),
                TargetVocabulary("koc1u2w4", "관념", "düşünce/anlayış", "ifade", "이 관념은 널리 퍼져 있어요.", "Bu anlayış yaygın."),
                TargetVocabulary("koc1u2w5", "인식", "kavrayış", "ifade", "인식은 경험에 따라 변해요.", "Kavrayış deneyimle değişir."))),
            LearningLesson("KO-C1-U2-L2", "Soyut Kavramlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___은 우리를 자주 속여요.", "", listOf("지각", "의식", "개념"), listOf("지각"), "Doğru cümle: 지각은 우리를 자주 속여요. — Algı bizi sık yanıltır.", null, null),
                LearningExercise("koc1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "이 ___은 널리 퍼져 있어요.", "", listOf("인식", "지각", "관념"), listOf("관념"), "Doğru cümle: 이 관념은 널리 퍼져 있어요. — Bu anlayış yaygın.", null, null),
                LearningExercise("koc1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu kavramı tanımlamak zor.", "Kavrayış deneyimle değişir.", "Algı bizi sık yanıltır."), listOf("Kavrayış deneyimle değişir."), "Söylenen cümle: 인식은 경험에 따라 변해요.", "인식은 경험에 따라 변해요.", null),
                LearningExercise("koc1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "이 관념은 널리 퍼져 있어요.", listOf("Bilinç hâlâ bir muamma.", "Kavrayış deneyimle değişir.", "Bu anlayış yaygın."), listOf("Bu anlayış yaygın."), "Cümlenin çevirisi: Bu anlayış yaygın.", null, null))),
            LearningLesson("KO-C1-U2-L3", "Soyut Kavramlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "모든 것은 관점에 ___ 달라져요.", "", listOf("따라", "대해", "위해"), listOf("따라"), "Kalıp: ...에 따라 (-e göre/bağlı olarak).", null, null),
                LearningExercise("koc1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 의식은 아직 수수께끼예요.", "", listOf(), listOf("의식은 아직 수수께끼예요."), "Türkçesi: Bilinç hâlâ bir muamma.", "의식은 아직 수수께끼예요.", "의식은 아직 수수께끼예요."),
                LearningExercise("koc1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kavram' ifadesinin Korece karşılığı hangisi?", "", listOf("개념", "지각", "인식"), listOf("개념"), "Örnek: 이 개념은 정의하기 어려워요. — Bu kavramı tanımlamak zor.", null, null))))),
        LearningUnit("KO-C1-U3", "Deyimler ve Mecazlar", "Deyimleri doğal bağlamda kullan.", listOf(
            LearningLesson("KO-C1-U3-L1", "Deyimler ve Mecazlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'일석이조' ne anlama gelir?", "", listOf("bir taşla iki kuş", "güzele güzellik katmak", "boşa nasihat"), listOf("bir taşla iki kuş"), "그렇게 하면 일석이조예요. — Öyle yaparsan bir taşla iki kuş.", null, null),
                LearningExercise("koc1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'금상첨화' ne anlama gelir?", "", listOf("kuyu dibindeki kurbağa", "damlaya damlaya göl olur", "güzele güzellik katmak"), listOf("güzele güzellik katmak"), "날씨까지 좋으니 금상첨화네요. — Hava da güzel olunca üstüne tüy dikti.", null, null),
                LearningExercise("koc1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'우물 안 개구리' ne anlama gelir?", "", listOf("bir taşla iki kuş", "kuyu dibindeki kurbağa", "boşa nasihat"), listOf("kuyu dibindeki kurbağa"), "우물 안 개구리가 되지 마세요. — Kuyudaki kurbağa olmayın.", null, null)), listOf(
                TargetVocabulary("koc1u3w1", "일석이조", "bir taşla iki kuş", "ifade", "그렇게 하면 일석이조예요.", "Öyle yaparsan bir taşla iki kuş."),
                TargetVocabulary("koc1u3w2", "금상첨화", "güzele güzellik katmak", "ifade", "날씨까지 좋으니 금상첨화네요.", "Hava da güzel olunca üstüne tüy dikti."),
                TargetVocabulary("koc1u3w3", "우물 안 개구리", "kuyu dibindeki kurbağa", "ifade", "우물 안 개구리가 되지 마세요.", "Kuyudaki kurbağa olmayın."),
                TargetVocabulary("koc1u3w4", "소 귀에 경 읽기", "boşa nasihat", "ifade", "그에게 말해도 소 귀에 경 읽기예요.", "Ona söylemek öküz kulağına sutra okumak gibi."),
                TargetVocabulary("koc1u3w5", "티끌 모아 태산", "damlaya damlaya göl olur", "ifade", "티끌 모아 태산이에요.", "Damlaya damlaya göl olur."))),
            LearningLesson("KO-C1-U3-L2", "Deyimler ve Mecazlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그렇게 하면 ___예요.", "", listOf("금상첨화", "우물 안 개구리", "일석이조"), listOf("일석이조"), "Doğru cümle: 그렇게 하면 일석이조예요. — Öyle yaparsan bir taşla iki kuş.", null, null),
                LearningExercise("koc1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그에게 말해도 ___예요.", "", listOf("일석이조", "소 귀에 경 읽기", "티끌 모아 태산"), listOf("소 귀에 경 읽기"), "Doğru cümle: 그에게 말해도 소 귀에 경 읽기예요. — Ona söylemek öküz kulağına sutra okumak gibi.", null, null),
                LearningExercise("koc1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Damlaya damlaya göl olur.", "Öyle yaparsan bir taşla iki kuş.", "Kuyudaki kurbağa olmayın."), listOf("Damlaya damlaya göl olur."), "Söylenen cümle: 티끌 모아 태산이에요.", "티끌 모아 태산이에요.", null),
                LearningExercise("koc1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "그에게 말해도 소 귀에 경 읽기예요.", listOf("Damlaya damlaya göl olur.", "Ona söylemek öküz kulağına sutra okumak gibi.", "Hava da güzel olunca üstüne tüy dikti."), listOf("Ona söylemek öküz kulağına sutra okumak gibi."), "Cümlenin çevirisi: Ona söylemek öküz kulağına sutra okumak gibi.", null, null))),
            LearningLesson("KO-C1-U3-L3", "Deyimler ve Mecazlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "일석___조.", "", listOf("이", "삼", "일"), listOf("이"), "Sajaseong-eo: 일석이조 (bir taşla iki kuş).", null, null),
                LearningExercise("koc1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 날씨까지 좋으니 금상첨화네요.", "", listOf(), listOf("날씨까지 좋으니 금상첨화네요."), "Türkçesi: Hava da güzel olunca üstüne tüy dikti.", "날씨까지 좋으니 금상첨화네요.", "날씨까지 좋으니 금상첨화네요."),
                LearningExercise("koc1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kuyu dibindeki kurbağa' ifadesinin Korece karşılığı hangisi?", "", listOf("일석이조", "티끌 모아 태산", "우물 안 개구리"), listOf("우물 안 개구리"), "Örnek: 우물 안 개구리가 되지 마세요. — Kuyudaki kurbağa olmayın.", null, null))))),
        LearningUnit("KO-C1-U4", "Resmî Yazışma", "Resmî mektup ve e-posta dilinde ustalaş.", listOf(
            LearningLesson("KO-C1-U4-L1", "Resmî Yazışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'귀하' ne anlama gelir?", "", listOf("ek (dosya)", "saygılarımla (mektup sonu)", "sayın (resmî)"), listOf("sayın (resmî)"), "김민수 귀하 — Sayın Kim Minsu", null, null),
                LearningExercise("koc1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'첨부' ne anlama gelir?", "", listOf("söz (saygı dili)", "ek (dosya)", "ilişkin"), listOf("ek (dosya)"), "이력서를 첨부합니다. — Özgeçmişi ekliyorum.", null, null),
                LearningExercise("koc1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'관련하여' ne anlama gelir?", "", listOf("ilişkin", "saygılarımla (mektup sonu)", "sayın (resmî)"), listOf("ilişkin"), "요청하신 건과 관련하여 연락드립니다. — Talebinize ilişkin size yazıyoruz.", null, null)), listOf(
                TargetVocabulary("koc1u4w1", "귀하", "sayın (resmî)", "ifade", "김민수 귀하", "Sayın Kim Minsu"),
                TargetVocabulary("koc1u4w2", "첨부", "ek (dosya)", "ifade", "이력서를 첨부합니다.", "Özgeçmişi ekliyorum."),
                TargetVocabulary("koc1u4w3", "관련하여", "ilişkin", "ifade", "요청하신 건과 관련하여 연락드립니다.", "Talebinize ilişkin size yazıyoruz."),
                TargetVocabulary("koc1u4w4", "드림", "saygılarımla (mektup sonu)", "ifade", "알리 카야 드림", "Saygılarımla, Ali Kaya"),
                TargetVocabulary("koc1u4w5", "말씀", "söz (saygı dili)", "ifade", "감사의 말씀을 드립니다.", "Teşekkürlerimi sunarım."))),
            LearningLesson("KO-C1-U4-L2", "Resmî Yazışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "김민수 ___", "", listOf("관련하여", "귀하", "첨부"), listOf("귀하"), "Doğru cümle: 김민수 귀하 — Sayın Kim Minsu", null, null),
                LearningExercise("koc1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "알리 카야 ___", "", listOf("드림", "말씀", "귀하"), listOf("드림"), "Doğru cümle: 알리 카야 드림 — Saygılarımla, Ali Kaya", null, null),
                LearningExercise("koc1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sayın Kim Minsu", "Talebinize ilişkin size yazıyoruz.", "Teşekkürlerimi sunarım."), listOf("Teşekkürlerimi sunarım."), "Söylenen cümle: 감사의 말씀을 드립니다.", "감사의 말씀을 드립니다.", null),
                LearningExercise("koc1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "알리 카야 드림", listOf("Saygılarımla, Ali Kaya", "Özgeçmişi ekliyorum.", "Teşekkürlerimi sunarım."), listOf("Saygılarımla, Ali Kaya"), "Cümlenin çevirisi: Saygılarımla, Ali Kaya", null, null))),
            LearningLesson("KO-C1-U4-L3", "Resmî Yazışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "이력서를 ___합니다.", "", listOf("첨부", "부착", "추가로"), listOf("첨부"), "Resmî dil: 첨부합니다 (ekte sunarım).", null, null),
                LearningExercise("koc1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 이력서를 첨부합니다.", "", listOf(), listOf("이력서를 첨부합니다."), "Türkçesi: Özgeçmişi ekliyorum.", "이력서를 첨부합니다.", "이력서를 첨부합니다."),
                LearningExercise("koc1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ilişkin' ifadesinin Korece karşılığı hangisi?", "", listOf("말씀", "관련하여", "귀하"), listOf("관련하여"), "Örnek: 요청하신 건과 관련하여 연락드립니다. — Talebinize ilişkin size yazıyoruz.", null, null))))),
        LearningUnit("KO-C1-U5", "Müzakere ve Diplomasi", "İncelikli müzakere dili kur.", listOf(
            LearningLesson("KO-C1-U5-L1", "Müzakere ve Diplomasi — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'협상' ne anlama gelir?", "", listOf("anlaşma/mutabakat", "müzakere", "uzlaşma"), listOf("müzakere"), "협상이 몇 시간 동안 계속됐어요. — Müzakere saatlerce sürdü.", null, null),
                LearningExercise("koc1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'타협' ne anlama gelir?", "", listOf("uzlaşma", "taviz", "duruş/pozisyon"), listOf("uzlaşma"), "타협이 공정해요. — Uzlaşma adil.", null, null),
                LearningExercise("koc1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'양보' ne anlama gelir?", "", listOf("anlaşma/mutabakat", "müzakere", "taviz"), listOf("taviz"), "양보가 필요했어요. — Taviz gerekliydi.", null, null)), listOf(
                TargetVocabulary("koc1u5w1", "협상", "müzakere", "ifade", "협상이 몇 시간 동안 계속됐어요.", "Müzakere saatlerce sürdü."),
                TargetVocabulary("koc1u5w2", "타협", "uzlaşma", "ifade", "타협이 공정해요.", "Uzlaşma adil."),
                TargetVocabulary("koc1u5w3", "양보", "taviz", "ifade", "양보가 필요했어요.", "Taviz gerekliydi."),
                TargetVocabulary("koc1u5w4", "합의", "anlaşma/mutabakat", "ifade", "합의가 늦게 이루어졌어요.", "Mutabakat geç sağlandı."),
                TargetVocabulary("koc1u5w5", "입장", "duruş/pozisyon", "ifade", "우리 입장은 변하지 않아요.", "Duruşumuz değişmiyor."))),
            LearningLesson("KO-C1-U5-L2", "Müzakere ve Diplomasi — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___이 몇 시간 동안 계속됐어요.", "", listOf("협상", "타협", "양보"), listOf("협상"), "Doğru cümle: 협상이 몇 시간 동안 계속됐어요. — Müzakere saatlerce sürdü.", null, null),
                LearningExercise("koc1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 늦게 이루어졌어요.", "", listOf("입장", "협상", "합의"), listOf("합의"), "Doğru cümle: 합의가 늦게 이루어졌어요. — Mutabakat geç sağlandı.", null, null),
                LearningExercise("koc1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Taviz gerekliydi.", "Duruşumuz değişmiyor.", "Müzakere saatlerce sürdü."), listOf("Duruşumuz değişmiyor."), "Söylenen cümle: 우리 입장은 변하지 않아요.", "우리 입장은 변하지 않아요.", null),
                LearningExercise("koc1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "합의가 늦게 이루어졌어요.", listOf("Uzlaşma adil.", "Duruşumuz değişmiyor.", "Mutabakat geç sağlandı."), listOf("Mutabakat geç sağlandı."), "Cümlenin çevirisi: Mutabakat geç sağlandı.", null, null))),
            LearningLesson("KO-C1-U5-L3", "Müzakere ve Diplomasi — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "우리는 합의에 ___했어요.", "", listOf("도달", "도착지", "달성해"), listOf("도달"), "Kalıp: 합의에 도달하다 (mutabakata varmak).", null, null),
                LearningExercise("koc1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 타협이 공정해요.", "", listOf(), listOf("타협이 공정해요."), "Türkçesi: Uzlaşma adil.", "타협이 공정해요.", "타협이 공정해요."),
                LearningExercise("koc1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'taviz' ifadesinin Korece karşılığı hangisi?", "", listOf("양보", "협상", "입장"), listOf("양보"), "Örnek: 양보가 필요했어요. — Taviz gerekliydi.", null, null))))),
        LearningUnit("KO-C1-U6", "İnce Anlam Farkları", "Yakın anlamlı ifadeleri ayırt et.", listOf(
            LearningLesson("KO-C1-U6-L1", "İnce Anlam Farkları — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'분명히' ne anlama gelir?", "", listOf("açıkça/besbelli", "sözde", "titizlikle"), listOf("açıkça/besbelli"), "분명히 그가 옳아요. — Besbelli o haklı.", null, null),
                LearningExercise("koc1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'이른바' ne anlama gelir?", "", listOf("etkili", "muhtemelen", "sözde"), listOf("sözde"), "이른바 전문가가 말했어요. — Sözde bir uzman konuştu.", null, null),
                LearningExercise("koc1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'효과적' ne anlama gelir?", "", listOf("açıkça/besbelli", "etkili", "titizlikle"), listOf("etkili"), "이 방법은 효과적이에요. — Bu yöntem etkili.", null, null)), listOf(
                TargetVocabulary("koc1u6w1", "분명히", "açıkça/besbelli", "ifade", "분명히 그가 옳아요.", "Besbelli o haklı."),
                TargetVocabulary("koc1u6w2", "이른바", "sözde", "ifade", "이른바 전문가가 말했어요.", "Sözde bir uzman konuştu."),
                TargetVocabulary("koc1u6w3", "효과적", "etkili", "ifade", "이 방법은 효과적이에요.", "Bu yöntem etkili."),
                TargetVocabulary("koc1u6w4", "면밀히", "titizlikle", "ifade", "면밀히 검토했어요.", "Titizlikle inceledik."),
                TargetVocabulary("koc1u6w5", "아마도", "muhtemelen", "ifade", "아마도 실수일 거예요.", "Muhtemelen bir hata."))),
            LearningLesson("KO-C1-U6-L2", "İnce Anlam Farkları — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 그가 옳아요.", "", listOf("이른바", "효과적", "분명히"), listOf("분명히"), "Doğru cümle: 분명히 그가 옳아요. — Besbelli o haklı.", null, null),
                LearningExercise("koc1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 검토했어요.", "", listOf("분명히", "면밀히", "아마도"), listOf("면밀히"), "Doğru cümle: 면밀히 검토했어요. — Titizlikle inceledik.", null, null),
                LearningExercise("koc1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Muhtemelen bir hata.", "Besbelli o haklı.", "Bu yöntem etkili."), listOf("Muhtemelen bir hata."), "Söylenen cümle: 아마도 실수일 거예요.", "아마도 실수일 거예요.", null),
                LearningExercise("koc1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "면밀히 검토했어요.", listOf("Muhtemelen bir hata.", "Titizlikle inceledik.", "Sözde bir uzman konuştu."), listOf("Titizlikle inceledik."), "Cümlenin çevirisi: Titizlikle inceledik.", null, null))),
            LearningLesson("KO-C1-U6-L3", "İnce Anlam Farkları — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___ 그가 옳아요. 증거가 명확해요.", "", listOf("분명히", "이른바", "아마도요"), listOf("분명히"), "분명히: kanıtların desteklediği kesinlik.", null, null),
                LearningExercise("koc1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 이른바 전문가가 말했어요.", "", listOf(), listOf("이른바 전문가가 말했어요."), "Türkçesi: Sözde bir uzman konuştu.", "이른바 전문가가 말했어요.", "이른바 전문가가 말했어요."),
                LearningExercise("koc1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'etkili' ifadesinin Korece karşılığı hangisi?", "", listOf("분명히", "아마도", "효과적"), listOf("효과적"), "Örnek: 이 방법은 효과적이에요. — Bu yöntem etkili.", null, null))))),
        LearningUnit("KO-C2-U1", "Üslup ve İncelik", "Üslubu bağlama göre ustaca ayarla.", listOf(
            LearningLesson("KO-C2-U1-L1", "Üslup ve İncelik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'미묘함' ne anlama gelir?", "", listOf("konuşma tonu", "özlü", "incelik"), listOf("incelik"), "언어의 미묘함은 늦게 배워요. — Dilin inceliklerini geç öğrenirsin.", null, null),
                LearningExercise("koc2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'어조' ne anlama gelir?", "", listOf("ince/zarif", "konuşma tonu", "ima"), listOf("konuşma tonu"), "그의 어조는 약간 비꼬는 듯했어요. — Tonu hafif alaycıydı.", null, null),
                LearningExercise("koc2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'암시' ne anlama gelir?", "", listOf("ima", "özlü", "incelik"), listOf("ima"), "그녀만 암시를 알아차렸어요. — İmayı yalnızca o fark etti.", null, null)), listOf(
                TargetVocabulary("koc2u1w1", "미묘함", "incelik", "ifade", "언어의 미묘함은 늦게 배워요.", "Dilin inceliklerini geç öğrenirsin."),
                TargetVocabulary("koc2u1w2", "어조", "konuşma tonu", "ifade", "그의 어조는 약간 비꼬는 듯했어요.", "Tonu hafif alaycıydı."),
                TargetVocabulary("koc2u1w3", "암시", "ima", "ifade", "그녀만 암시를 알아차렸어요.", "İmayı yalnızca o fark etti."),
                TargetVocabulary("koc2u1w4", "간결", "özlü", "ifade", "그의 대답은 간결했어요.", "Yanıtı özlüydü."),
                TargetVocabulary("koc2u1w5", "섬세", "ince/zarif", "ifade", "섬세한 표현이 돋보여요.", "İnce ifadeler göze çarpıyor."))),
            LearningLesson("KO-C2-U1-L2", "Üslup ve İncelik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "언어의 ___은 늦게 배워요.", "", listOf("암시", "미묘함", "어조"), listOf("미묘함"), "Doğru cümle: 언어의 미묘함은 늦게 배워요. — Dilin inceliklerini geç öğrenirsin.", null, null),
                LearningExercise("koc2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그의 대답은 ___했어요.", "", listOf("간결", "섬세", "미묘함"), listOf("간결"), "Doğru cümle: 그의 대답은 간결했어요. — Yanıtı özlüydü.", null, null),
                LearningExercise("koc2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dilin inceliklerini geç öğrenirsin.", "İmayı yalnızca o fark etti.", "İnce ifadeler göze çarpıyor."), listOf("İnce ifadeler göze çarpıyor."), "Söylenen cümle: 섬세한 표현이 돋보여요.", "섬세한 표현이 돋보여요.", null),
                LearningExercise("koc2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "그의 대답은 간결했어요.", listOf("Yanıtı özlüydü.", "Tonu hafif alaycıydı.", "İnce ifadeler göze çarpıyor."), listOf("Yanıtı özlüydü."), "Cümlenin çevirisi: Yanıtı özlüydü.", null, null))),
            LearningLesson("KO-C2-U1-L3", "Üslup ve İncelik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "그의 연설은 짧고 ___했어요.", "", listOf("간결", "간단지", "간략도"), listOf("간결"), "Kalıp: 짧고 간결하다 (kısa ve özlü).", null, null),
                LearningExercise("koc2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 그의 어조는 약간 비꼬는 듯했어요.", "", listOf(), listOf("그의 어조는 약간 비꼬는 듯했어요."), "Türkçesi: Tonu hafif alaycıydı.", "그의 어조는 약간 비꼬는 듯했어요.", "그의 어조는 약간 비꼬는 듯했어요."),
                LearningExercise("koc2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ima' ifadesinin Korece karşılığı hangisi?", "", listOf("섬세", "암시", "미묘함"), listOf("암시"), "Örnek: 그녀만 암시를 알아차렸어요. — İmayı yalnızca o fark etti.", null, null))))),
        LearningUnit("KO-C2-U2", "Edebî Dil", "Edebî metinlerin katmanlarını çözümle.", listOf(
            LearningLesson("KO-C2-U2-L1", "Edebî Dil — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'은유' ne anlama gelir?", "", listOf("lirik", "metafor", "simge"), listOf("metafor"), "은유가 글 전체를 관통해요. — Metafor bütün metni kat ediyor.", null, null),
                LearningExercise("koc2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'상징' ne anlama gelir?", "", listOf("simge", "anlatıcı", "hiciv"), listOf("simge"), "바다는 자유의 상징이에요. — Deniz özgürlüğün simgesidir.", null, null),
                LearningExercise("koc2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'서술자' ne anlama gelir?", "", listOf("lirik", "metafor", "anlatıcı"), listOf("anlatıcı"), "서술자가 계속 바뀌어요. — Anlatıcı sürekli değişiyor.", null, null)), listOf(
                TargetVocabulary("koc2u2w1", "은유", "metafor", "ifade", "은유가 글 전체를 관통해요.", "Metafor bütün metni kat ediyor."),
                TargetVocabulary("koc2u2w2", "상징", "simge", "ifade", "바다는 자유의 상징이에요.", "Deniz özgürlüğün simgesidir."),
                TargetVocabulary("koc2u2w3", "서술자", "anlatıcı", "ifade", "서술자가 계속 바뀌어요.", "Anlatıcı sürekli değişiyor."),
                TargetVocabulary("koc2u2w4", "서정적", "lirik", "ifade", "문체가 아주 서정적이에요.", "Üslup çok lirik."),
                TargetVocabulary("koc2u2w5", "풍자", "hiciv", "ifade", "이 글의 풍자는 분명해요.", "Bu metindeki hiciv çok açık."))),
            LearningLesson("KO-C2-U2-L2", "Edebî Dil — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 글 전체를 관통해요.", "", listOf("은유", "상징", "서술자"), listOf("은유"), "Doğru cümle: 은유가 글 전체를 관통해요. — Metafor bütün metni kat ediyor.", null, null),
                LearningExercise("koc2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "문체가 아주 ___이에요.", "", listOf("풍자", "은유", "서정적"), listOf("서정적"), "Doğru cümle: 문체가 아주 서정적이에요. — Üslup çok lirik.", null, null),
                LearningExercise("koc2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Anlatıcı sürekli değişiyor.", "Bu metindeki hiciv çok açık.", "Metafor bütün metni kat ediyor."), listOf("Bu metindeki hiciv çok açık."), "Söylenen cümle: 이 글의 풍자는 분명해요.", "이 글의 풍자는 분명해요.", null),
                LearningExercise("koc2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "문체가 아주 서정적이에요.", listOf("Deniz özgürlüğün simgesidir.", "Bu metindeki hiciv çok açık.", "Üslup çok lirik."), listOf("Üslup çok lirik."), "Cümlenin çevirisi: Üslup çok lirik.", null, null))),
            LearningLesson("KO-C2-U2-L3", "Edebî Dil — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "이 글의 ___는 분명해요.", "", listOf("풍자", "풍경", "풍문"), listOf("풍자"), "İsim: 글의 풍자 (metnin hicvi).", null, null),
                LearningExercise("koc2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 바다는 자유의 상징이에요.", "", listOf(), listOf("바다는 자유의 상징이에요."), "Türkçesi: Deniz özgürlüğün simgesidir.", "바다는 자유의 상징이에요.", "바다는 자유의 상징이에요."),
                LearningExercise("koc2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'anlatıcı' ifadesinin Korece karşılığı hangisi?", "", listOf("서술자", "은유", "풍자"), listOf("서술자"), "Örnek: 서술자가 계속 바뀌어요. — Anlatıcı sürekli değişiyor.", null, null))))),
        LearningUnit("KO-C2-U3", "Uzmanlık Söylemi", "Uzmanlık alanı söylemine hâkim ol.", listOf(
            LearningLesson("KO-C2-U3-L1", "Uzmanlık Söylemi — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'전문 용어' ne anlama gelir?", "", listOf("uzmanlık terimi", "söylem", "ikna gücü"), listOf("uzmanlık terimi"), "전문 용어는 정확해야 해요. — Terimler kesin olmalı.", null, null),
                LearningExercise("koc2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'담론' ne anlama gelir?", "", listOf("inceleme yazısı", "ayırt etme", "söylem"), listOf("söylem"), "학술 담론에는 규범이 있어요. — Akademik söylemin normları vardır.", null, null),
                LearningExercise("koc2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'논고' ne anlama gelir?", "", listOf("uzmanlık terimi", "inceleme yazısı", "ikna gücü"), listOf("inceleme yazısı"), "이 논고는 세 부분이에요. — Bu inceleme üç bölümden oluşuyor.", null, null)), listOf(
                TargetVocabulary("koc2u3w1", "전문 용어", "uzmanlık terimi", "ifade", "전문 용어는 정확해야 해요.", "Terimler kesin olmalı."),
                TargetVocabulary("koc2u3w2", "담론", "söylem", "ifade", "학술 담론에는 규범이 있어요.", "Akademik söylemin normları vardır."),
                TargetVocabulary("koc2u3w3", "논고", "inceleme yazısı", "ifade", "이 논고는 세 부분이에요.", "Bu inceleme üç bölümden oluşuyor."),
                TargetVocabulary("koc2u3w4", "설득력", "ikna gücü", "ifade", "설득력 있는 논증이에요.", "İkna gücü yüksek bir kanıtlama."),
                TargetVocabulary("koc2u3w5", "구별", "ayırt etme", "ifade", "이 두 개념을 구별해야 해요.", "Bu iki kavram ayırt edilmeli."))),
            LearningLesson("KO-C2-U3-L2", "Uzmanlık Söylemi — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___는 정확해야 해요.", "", listOf("담론", "논고", "전문 용어"), listOf("전문 용어"), "Doğru cümle: 전문 용어는 정확해야 해요. — Terimler kesin olmalı.", null, null),
                LearningExercise("koc2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 있는 논증이에요.", "", listOf("전문 용어", "설득력", "구별"), listOf("설득력"), "Doğru cümle: 설득력 있는 논증이에요. — İkna gücü yüksek bir kanıtlama.", null, null),
                LearningExercise("koc2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu iki kavram ayırt edilmeli.", "Terimler kesin olmalı.", "Bu inceleme üç bölümden oluşuyor."), listOf("Bu iki kavram ayırt edilmeli."), "Söylenen cümle: 이 두 개념을 구별해야 해요.", "이 두 개념을 구별해야 해요.", null),
                LearningExercise("koc2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "설득력 있는 논증이에요.", listOf("Bu iki kavram ayırt edilmeli.", "İkna gücü yüksek bir kanıtlama.", "Akademik söylemin normları vardır."), listOf("İkna gücü yüksek bir kanıtlama."), "Cümlenin çevirisi: İkna gücü yüksek bir kanıtlama.", null, null))),
            LearningLesson("KO-C2-U3-L3", "Uzmanlık Söylemi — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___ 있는 논증은 비평가도 설득해요.", "", listOf("설득력", "설명서", "설화력"), listOf("설득력"), "Kalıp: 설득력 있는 (ikna gücü olan).", null, null),
                LearningExercise("koc2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 학술 담론에는 규범이 있어요.", "", listOf(), listOf("학술 담론에는 규범이 있어요."), "Türkçesi: Akademik söylemin normları vardır.", "학술 담론에는 규범이 있어요.", "학술 담론에는 규범이 있어요."),
                LearningExercise("koc2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'inceleme yazısı' ifadesinin Korece karşılığı hangisi?", "", listOf("전문 용어", "구별", "논고"), listOf("논고"), "Örnek: 이 논고는 세 부분이에요. — Bu inceleme üç bölümden oluşuyor.", null, null))))),
        LearningUnit("KO-C2-U4", "Kültürel Derinlik", "Kültürel referansları derinlemesine kavra.", listOf(
            LearningLesson("KO-C2-U4-L1", "Kültürel Derinlik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'세계관' ne anlama gelir?", "", listOf("mizaç", "kökleşmiş", "dünya görüşü"), listOf("dünya görüşü"), "그의 세계관이 흔들렸어요. — Dünya görüşü sarsıldı.", null, null),
                LearningExercise("koc2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'기질' ne anlama gelir?", "", listOf("miras", "mizaç", "zamanın ruhu"), listOf("mizaç"), "지역마다 기질이 달라요. — Mizaç bölgeye göre değişir.", null, null),
                LearningExercise("koc2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'시대정신' ne anlama gelir?", "", listOf("zamanın ruhu", "kökleşmiş", "dünya görüşü"), listOf("zamanın ruhu"), "이 소설은 시대정신을 담아요. — Bu roman zamanın ruhunu taşıyor.", null, null)), listOf(
                TargetVocabulary("koc2u4w1", "세계관", "dünya görüşü", "ifade", "그의 세계관이 흔들렸어요.", "Dünya görüşü sarsıldı."),
                TargetVocabulary("koc2u4w2", "기질", "mizaç", "ifade", "지역마다 기질이 달라요.", "Mizaç bölgeye göre değişir."),
                TargetVocabulary("koc2u4w3", "시대정신", "zamanın ruhu", "ifade", "이 소설은 시대정신을 담아요.", "Bu roman zamanın ruhunu taşıyor."),
                TargetVocabulary("koc2u4w4", "뿌리 깊은", "kökleşmiş", "ifade", "뿌리 깊은 전통이에요.", "Kökleşmiş bir gelenek."),
                TargetVocabulary("koc2u4w5", "유산", "miras", "ifade", "문화유산이 보존돼요.", "Kültürel miras korunuyor."))),
            LearningLesson("KO-C2-U4-L2", "Kültürel Derinlik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그의 ___이 흔들렸어요.", "", listOf("시대정신", "세계관", "기질"), listOf("세계관"), "Doğru cümle: 그의 세계관이 흔들렸어요. — Dünya görüşü sarsıldı.", null, null),
                LearningExercise("koc2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___ 전통이에요.", "", listOf("뿌리 깊은", "유산", "세계관"), listOf("뿌리 깊은"), "Doğru cümle: 뿌리 깊은 전통이에요. — Kökleşmiş bir gelenek.", null, null),
                LearningExercise("koc2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dünya görüşü sarsıldı.", "Bu roman zamanın ruhunu taşıyor.", "Kültürel miras korunuyor."), listOf("Kültürel miras korunuyor."), "Söylenen cümle: 문화유산이 보존돼요.", "문화유산이 보존돼요.", null),
                LearningExercise("koc2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "뿌리 깊은 전통이에요.", listOf("Kökleşmiş bir gelenek.", "Mizaç bölgeye göre değişir.", "Kültürel miras korunuyor."), listOf("Kökleşmiş bir gelenek."), "Cümlenin çevirisi: Kökleşmiş bir gelenek.", null, null))),
            LearningLesson("KO-C2-U4-L3", "Kültürel Derinlik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "이 전통은 문화에 ___ 자리 잡았어요.", "", listOf("깊이", "높이", "빨리"), listOf("깊이"), "Zarf: 깊이 자리 잡다 (derinlemesine yerleşmek).", null, null),
                LearningExercise("koc2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 지역마다 기질이 달라요.", "", listOf(), listOf("지역마다 기질이 달라요."), "Türkçesi: Mizaç bölgeye göre değişir.", "지역마다 기질이 달라요.", "지역마다 기질이 달라요."),
                LearningExercise("koc2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'zamanın ruhu' ifadesinin Korece karşılığı hangisi?", "", listOf("유산", "시대정신", "세계관"), listOf("시대정신"), "Örnek: 이 소설은 시대정신을 담아요. — Bu roman zamanın ruhunu taşıyor.", null, null))))),
        LearningUnit("KO-C2-U5", "Retorik Ustalığı", "Retorik araçları etkili kullan.", listOf(
            LearningLesson("KO-C2-U5-L1", "Retorik Ustalığı — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'수사학' ne anlama gelir?", "", listOf("keskin", "retorik", "söz sanatı"), listOf("retorik"), "그의 수사학은 뛰어나요. — Retoriği üstün.", null, null),
                LearningExercise("koc2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'수사법' ne anlama gelir?", "", listOf("söz sanatı", "belagat", "asalet/zarafet"), listOf("söz sanatı"), "수사법이 은근하게 작동해요. — Söz sanatı incelikle işliyor.", null, null),
                LearningExercise("koc2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'웅변' ne anlama gelir?", "", listOf("keskin", "retorik", "belagat"), listOf("belagat"), "그녀의 웅변은 유명해요. — Belagati meşhur.", null, null)), listOf(
                TargetVocabulary("koc2u5w1", "수사학", "retorik", "ifade", "그의 수사학은 뛰어나요.", "Retoriği üstün."),
                TargetVocabulary("koc2u5w2", "수사법", "söz sanatı", "ifade", "수사법이 은근하게 작동해요.", "Söz sanatı incelikle işliyor."),
                TargetVocabulary("koc2u5w3", "웅변", "belagat", "ifade", "그녀의 웅변은 유명해요.", "Belagati meşhur."),
                TargetVocabulary("koc2u5w4", "날카로운", "keskin", "ifade", "그의 비평은 매우 날카로워요.", "Eleştirisi son derece keskin."),
                TargetVocabulary("koc2u5w5", "기품", "asalet/zarafet", "ifade", "글에 기품이 있어요.", "Yazıda asil bir hava var."))),
            LearningLesson("KO-C2-U5-L2", "Retorik Ustalığı — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그의 ___은 뛰어나요.", "", listOf("수사학", "수사법", "웅변"), listOf("수사학"), "Doğru cümle: 그의 수사학은 뛰어나요. — Retoriği üstün.", null, null),
                LearningExercise("koc2u5e5", Skill.VOCABULARY, "Doğru anlamı seç", "'날카로운' ne anlama gelir?", "", listOf("keskin", "retorik", "belagat"), listOf("keskin"), "그의 비평은 매우 날카로워요. — Eleştirisi son derece keskin.", null, null),
                LearningExercise("koc2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Belagati meşhur.", "Yazıda asil bir hava var.", "Retoriği üstün."), listOf("Yazıda asil bir hava var."), "Söylenen cümle: 글에 기품이 있어요.", "글에 기품이 있어요.", null),
                LearningExercise("koc2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "그의 비평은 매우 날카로워요.", listOf("Söz sanatı incelikle işliyor.", "Yazıda asil bir hava var.", "Eleştirisi son derece keskin."), listOf("Eleştirisi son derece keskin."), "Cümlenin çevirisi: Eleştirisi son derece keskin.", null, null))),
            LearningLesson("KO-C2-U5-L3", "Retorik Ustalığı — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "그의 비평은 매우 ___.", "", listOf("날카로워요", "날카롭다요", "날카롭게요"), listOf("날카로워요"), "İ-eum uyumu: 날카로워요.", null, null),
                LearningExercise("koc2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 수사법이 은근하게 작동해요.", "", listOf(), listOf("수사법이 은근하게 작동해요."), "Türkçesi: Söz sanatı incelikle işliyor.", "수사법이 은근하게 작동해요.", "수사법이 은근하게 작동해요."),
                LearningExercise("koc2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'belagat' ifadesinin Korece karşılığı hangisi?", "", listOf("웅변", "수사학", "기품"), listOf("웅변"), "Örnek: 그녀의 웅변은 유명해요. — Belagati meşhur.", null, null))))),
        LearningUnit("KO-C2-U6", "Ana Dil Düzeyinde Akıcılık", "Ana dil konuşuru düzeyinde incelik kazan.", listOf(
            LearningLesson("KO-C2-U6-L1", "Ana Dil Düzeyinde Akıcılık — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koc2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'구사해요' ne anlama gelir?", "", listOf("ustaca kullanmak", "serbestçe/istediği gibi", "ana dili düzeyi"), listOf("ustaca kullanmak"), "그녀는 한국어를 자유자재로 구사해요. — Koreceyi serbestçe ve ustaca kullanıyor.", null, null),
                LearningExercise("koc2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'자유자재' ne anlama gelir?", "", listOf("rafinelik", "akıcı", "serbestçe/istediği gibi"), listOf("serbestçe/istediği gibi"), "자유자재로 문체를 바꿔요. — Üslubu istediği gibi değiştiriyor.", null, null),
                LearningExercise("koc2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'세련' ne anlama gelir?", "", listOf("ustaca kullanmak", "rafinelik", "ana dili düzeyi"), listOf("rafinelik"), "세련된 표현이에요. — Rafine bir ifade.", null, null)), listOf(
                TargetVocabulary("koc2u6w1", "구사해요", "ustaca kullanmak", "ifade", "그녀는 한국어를 자유자재로 구사해요.", "Koreceyi serbestçe ve ustaca kullanıyor."),
                TargetVocabulary("koc2u6w2", "자유자재", "serbestçe/istediği gibi", "ifade", "자유자재로 문체를 바꿔요.", "Üslubu istediği gibi değiştiriyor."),
                TargetVocabulary("koc2u6w3", "세련", "rafinelik", "ifade", "세련된 표현이에요.", "Rafine bir ifade."),
                TargetVocabulary("koc2u6w4", "원어민 수준", "ana dili düzeyi", "ifade", "원어민 수준으로 말해요.", "Ana dili düzeyinde konuşuyor."),
                TargetVocabulary("koc2u6w5", "유창", "akıcı", "ifade", "그녀는 한국어가 유창해요.", "Korecesi akıcı."))),
            LearningLesson("KO-C2-U6-L2", "Ana Dil Düzeyinde Akıcılık — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koc2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "그녀는 한국어를 자유자재로 ___.", "", listOf("자유자재", "세련", "구사해요"), listOf("구사해요"), "Doğru cümle: 그녀는 한국어를 자유자재로 구사해요. — Koreceyi serbestçe ve ustaca kullanıyor.", null, null),
                LearningExercise("koc2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___으로 말해요.", "", listOf("구사해요", "원어민 수준", "유창"), listOf("원어민 수준"), "Doğru cümle: 원어민 수준으로 말해요. — Ana dili düzeyinde konuşuyor.", null, null),
                LearningExercise("koc2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Korecesi akıcı.", "Koreceyi serbestçe ve ustaca kullanıyor.", "Rafine bir ifade."), listOf("Korecesi akıcı."), "Söylenen cümle: 그녀는 한국어가 유창해요.", "그녀는 한국어가 유창해요.", null),
                LearningExercise("koc2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "원어민 수준으로 말해요.", listOf("Korecesi akıcı.", "Ana dili düzeyinde konuşuyor.", "Üslubu istediği gibi değiştiriyor."), listOf("Ana dili düzeyinde konuşuyor."), "Cümlenin çevirisi: Ana dili düzeyinde konuşuyor.", null, null))),
            LearningLesson("KO-C2-U6-L3", "Ana Dil Düzeyinde Akıcılık — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koc2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "그녀는 한국어를 ___하게 해요.", "", listOf("유창", "유창히", "유연도"), listOf("유창"), "Kalıp: 유창하게 (akıcı biçimde).", null, null),
                LearningExercise("koc2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 자유자재로 문체를 바꿔요.", "", listOf(), listOf("자유자재로 문체를 바꿔요."), "Türkçesi: Üslubu istediği gibi değiştiriyor.", "자유자재로 문체를 바꿔요.", "자유자재로 문체를 바꿔요."),
                LearningExercise("koc2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'rafinelik' ifadesinin Korece karşılığı hangisi?", "", listOf("구사해요", "유창", "세련"), listOf("세련"), "Örnek: 세련된 표현이에요. — Rafine bir ifade.", null, null))))))
}
