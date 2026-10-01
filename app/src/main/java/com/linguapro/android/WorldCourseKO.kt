package com.linguapro.android

/** Korece (KO) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseKO {
    val units: List<LearningUnit> = listOf(
        LearningUnit("KO-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("KO-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("koa1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'안녕하세요' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kalın", "merhaba"), listOf("merhaba"), "안녕하세요, 안나예요. — Merhaba, ben Anna.", null, null),
                LearningExercise("koa1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'감사합니다' ne anlama gelir?", "", listOf("ben (konu)", "teşekkürler", "lütfen (verin)"), listOf("teşekkürler"), "정말 감사합니다. — Gerçekten teşekkür ederim.", null, null),
                LearningExercise("koa1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'주세요' ne anlama gelir?", "", listOf("lütfen (verin)", "hoşça kalın", "merhaba"), listOf("lütfen (verin)"), "커피 주세요. — Kahve lütfen.", null, null))),
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
                LearningExercise("koa1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'오늘' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "오늘은 월요일이에요. — Bugün pazartesi.", null, null))),
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
                LearningExercise("koa1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'커피' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "커피를 마셔요. — Kahve içiyorum.", null, null))),
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
                LearningExercise("koa1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'아버지' ne anlama gelir?", "", listOf("baba", "ağabey", "aile"), listOf("baba"), "아버지는 일을 많이 하세요. — Babam çok çalışır.", null, null))),
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
                LearningExercise("koa1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'도시' ne anlama gelir?", "", listOf("satın almak", "ev", "şehir"), listOf("şehir"), "도시가 아름다워요. — Şehir güzel.", null, null))),
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
                LearningExercise("koa1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'호텔' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "호텔은 시내에 있어요. — Otel şehir merkezinde.", null, null))),
            LearningLesson("KO-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("koa1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___가 아홉 시에 와요.", "", listOf("표", "호텔", "기차"), listOf("기차"), "Doğru cümle: 기차가 아홉 시에 와요. — Tren dokuzda geliyor.", null, null),
                LearningExercise("koa1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___으로 가세요.", "", listOf("기차", "왼쪽", "공항"), listOf("왼쪽"), "Doğru cümle: 왼쪽으로 가세요. — Sola gidin.", null, null),
                LearningExercise("koa1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı uzak.", "Tren dokuzda geliyor.", "Otel şehir merkezinde."), listOf("Havalimanı uzak."), "Söylenen cümle: 공항이 멀어요.", "공항이 멀어요.", null),
                LearningExercise("koa1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "왼쪽으로 가세요.", listOf("Havalimanı uzak.", "Sola gidin.", "Bir bilet lütfen."), listOf("Sola gidin."), "Cümlenin çevirisi: Sola gidin.", null, null))),
            LearningLesson("KO-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("koa1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "표 한 장 ___.", "", listOf("주세요", "있어요", "가요"), listOf("주세요"), "Rica kalıbı: 주세요.", null, null),
                LearningExercise("koa1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 표 한 장 주세요.", "", listOf(), listOf("표 한 장 주세요."), "Türkçesi: Bir bilet lütfen.", "표 한 장 주세요.", "표 한 장 주세요."),
                LearningExercise("koa1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Korece karşılığı hangisi?", "", listOf("기차", "공항", "호텔"), listOf("호텔"), "Örnek: 호텔은 시내에 있어요. — Otel şehir merkezinde.", null, null))))))
}
