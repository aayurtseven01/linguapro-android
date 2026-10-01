package com.linguapro.android

/** Çince (ZH) A1 başlangıç kursu: 6 ünite, 18 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseZH {
    val units: List<LearningUnit> = listOf(
        LearningUnit("ZH-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("ZH-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'你好' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "你好，我是安娜。 — Merhaba, ben Anna.", null, null),
                LearningExercise("zha1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'谢谢' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen"), listOf("teşekkürler"), "谢谢你！ — Teşekkür ederim!", null, null),
                LearningExercise("zha1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'请' ne anlama gelir?", "", listOf("lütfen", "hoşça kal", "merhaba"), listOf("lütfen"), "请坐。 — Lütfen oturun.", null, null))),
            LearningLesson("ZH-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___，我是安娜。", "", listOf("请", "你好", "谢谢"), listOf("你好"), "Doğru cümle: 你好，我是安娜。 — Merhaba, ben Anna.", null, null),
                LearningExercise("zha1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___，明天见！", "", listOf("再见", "我叫", "你好"), listOf("再见"), "Doğru cümle: 再见，明天见！ — Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("zha1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Lütfen oturun.", "Benim adım Wang Ming."), listOf("Benim adım Wang Ming."), "Söylenen cümle: 我叫王明。", "我叫王明。", null),
                LearningExercise("zha1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "再见，明天见！", listOf("Hoşça kal, yarın görüşürüz!", "Teşekkür ederim!", "Benim adım Wang Ming."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("ZH-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "你___什么名字？", "", listOf("叫", "是", "去"), listOf("叫"), "İsim sorma kalıbı: 你叫什么名字？(Adın ne?)", null, null),
                LearningExercise("zha1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 谢谢你！", "", listOf(), listOf("谢谢你！"), "Türkçesi: Teşekkür ederim!", "谢谢你！", "谢谢你！"),
                LearningExercise("zha1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lütfen' ifadesinin Çince karşılığı hangisi?", "", listOf("我叫", "请", "你好"), listOf("请"), "Örnek: 请坐。 — Lütfen oturun.", null, null))))),
        LearningUnit("ZH-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("ZH-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'二' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "二月很冷。 — Şubat çok soğuk.", null, null),
                LearningExercise("zha1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'十' ne anlama gelir?", "", listOf("on", "bugün", "saat (...da)"), listOf("on"), "现在十点。 — Saat şimdi on.", null, null),
                LearningExercise("zha1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'今天' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "今天星期一。 — Bugün pazartesi.", null, null))),
            LearningLesson("ZH-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___月很冷。", "", listOf("二", "十", "今天"), listOf("二"), "Doğru cümle: 二月很冷。 — Şubat çok soğuk.", null, null),
                LearningExercise("zha1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___见！", "", listOf("点", "二", "明天"), listOf("明天"), "Doğru cümle: 明天见！ — Yarın görüşürüz!", null, null),
                LearningExercise("zha1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaç?", "Şubat çok soğuk."), listOf("Saat kaç?"), "Söylenen cümle: 现在几点？", "现在几点？", null),
                LearningExercise("zha1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "明天见！", listOf("Saat şimdi on.", "Saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("ZH-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "现在几___？", "", listOf("点", "时", "分"), listOf("点"), "Saat sorma kalıbı: 现在几点？", null, null),
                LearningExercise("zha1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 现在十点。", "", listOf(), listOf("现在十点。"), "Türkçesi: Saat şimdi on.", "现在十点。", "现在十点。"),
                LearningExercise("zha1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bugün' ifadesinin Çince karşılığı hangisi?", "", listOf("今天", "二", "点"), listOf("今天"), "Örnek: 今天星期一。 — Bugün pazartesi.", null, null))))),
        LearningUnit("ZH-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("ZH-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'水' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "请给我水。 — Lütfen bana su verin.", null, null),
                LearningExercise("zha1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'面包' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "面包很新鲜。 — Ekmek çok taze.", null, null),
                LearningExercise("zha1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'咖啡' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "我喝咖啡。 — Kahve içiyorum.", null, null))),
            LearningLesson("ZH-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "请给我___。", "", listOf("面包", "咖啡", "水"), listOf("水"), "Doğru cümle: 请给我水。 — Lütfen bana su verin.", null, null),
                LearningExercise("zha1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___是红色的。", "", listOf("水", "苹果", "茶"), listOf("苹果"), "Doğru cümle: 苹果是红色的。 — Elma kırmızı.", null, null),
                LearningExercise("zha1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çayı severim.", "Lütfen bana su verin.", "Kahve içiyorum."), listOf("Çayı severim."), "Söylenen cümle: 我喜欢茶。", "我喜欢茶。", null),
                LearningExercise("zha1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "苹果是红色的。", listOf("Çayı severim.", "Elma kırmızı.", "Ekmek çok taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("ZH-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我___咖啡。", "", listOf("喝", "吃", "看"), listOf("喝"), "İçmek fiili 喝: 我喝咖啡 (kahve içiyorum).", null, null),
                LearningExercise("zha1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 面包很新鲜。", "", listOf(), listOf("面包很新鲜。"), "Türkçesi: Ekmek çok taze.", "面包很新鲜。", "面包很新鲜。"),
                LearningExercise("zha1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kahve' ifadesinin Çince karşılığı hangisi?", "", listOf("水", "茶", "咖啡"), listOf("咖啡"), "Örnek: 我喝咖啡。 — Kahve içiyorum.", null, null))))),
        LearningUnit("ZH-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("ZH-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'家' ne anlama gelir?", "", listOf("anne", "ağabey", "ev / aile"), listOf("ev / aile"), "我家很大。 — Ailem kalabalık.", null, null),
                LearningExercise("zha1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'妈妈' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "妈妈在家。 — Annem evde.", null, null),
                LearningExercise("zha1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'爸爸' ne anlama gelir?", "", listOf("baba", "ağabey", "ev / aile"), listOf("baba"), "爸爸工作很忙。 — Babam işte çok meşgul.", null, null))),
            LearningLesson("ZH-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我___很大。", "", listOf("爸爸", "家", "妈妈"), listOf("家"), "Doğru cümle: 我家很大。 — Ailem kalabalık.", null, null),
                LearningExercise("zha1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我___很年轻。", "", listOf("哥哥", "朋友", "家"), listOf("哥哥"), "Doğru cümle: 我哥哥很年轻。 — Ağabeyim genç.", null, null),
                LearningExercise("zha1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam işte çok meşgul.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: 他是我的朋友。", "他是我的朋友。", null),
                LearningExercise("zha1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我哥哥很年轻。", listOf("Ağabeyim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null))),
            LearningLesson("ZH-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这是我___姐姐。", "", listOf("的", "了", "吗"), listOf("的"), "Sahiplik eki 的: 我的姐姐 (benim ablam).", null, null),
                LearningExercise("zha1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 妈妈在家。", "", listOf(), listOf("妈妈在家。"), "Türkçesi: Annem evde.", "妈妈在家。", "妈妈在家。"),
                LearningExercise("zha1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baba' ifadesinin Çince karşılığı hangisi?", "", listOf("朋友", "爸爸", "家"), listOf("爸爸"), "Örnek: 爸爸工作很忙。 — Babam işte çok meşgul.", null, null))))),
        LearningUnit("ZH-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("ZH-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'房子' ne anlama gelir?", "", listOf("satın almak", "ev (bina)", "iş"), listOf("ev (bina)"), "房子很旧。 — Ev çok eski.", null, null),
                LearningExercise("zha1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'工作' ne anlama gelir?", "", listOf("iş", "şehir", "oturmak"), listOf("iş"), "我去工作。 — İşe gidiyorum.", null, null),
                LearningExercise("zha1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'城市' ne anlama gelir?", "", listOf("satın almak", "ev (bina)", "şehir"), listOf("şehir"), "这个城市很漂亮。 — Bu şehir çok güzel.", null, null))),
            LearningLesson("ZH-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___很旧。", "", listOf("房子", "工作", "城市"), listOf("房子"), "Doğru cümle: 房子很旧。 — Ev çok eski.", null, null),
                LearningExercise("zha1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们___水果。", "", listOf("住", "房子", "买"), listOf("买"), "Doğru cümle: 我们买水果。 — Meyve alıyoruz.", null, null),
                LearningExercise("zha1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu şehir çok güzel.", "Pekin'de oturuyorum.", "Ev çok eski."), listOf("Pekin'de oturuyorum."), "Söylenen cümle: 我住在北京。", "我住在北京。", null),
                LearningExercise("zha1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们买水果。", listOf("İşe gidiyorum.", "Pekin'de oturuyorum.", "Meyve alıyoruz."), listOf("Meyve alıyoruz."), "Cümlenin çevirisi: Meyve alıyoruz.", null, null))),
            LearningLesson("ZH-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "你住___哪里？", "", listOf("在", "到", "从"), listOf("在"), "Konum edatı 在: 住在 (–de oturmak).", null, null),
                LearningExercise("zha1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我去工作。", "", listOf(), listOf("我去工作。"), "Türkçesi: İşe gidiyorum.", "我去工作。", "我去工作。"),
                LearningExercise("zha1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'şehir' ifadesinin Çince karşılığı hangisi?", "", listOf("城市", "房子", "住"), listOf("城市"), "Örnek: 这个城市很漂亮。 — Bu şehir çok güzel.", null, null))))),
        LearningUnit("ZH-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("ZH-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'火车' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "火车九点到。 — Tren dokuzda varıyor.", null, null),
                LearningExercise("zha1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'票' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "一张票，谢谢。 — Bir bilet, teşekkürler.", null, null),
                LearningExercise("zha1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'酒店' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "酒店在市中心。 — Otel şehir merkezinde.", null, null))),
            LearningLesson("ZH-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___九点到。", "", listOf("票", "酒店", "火车"), listOf("火车"), "Doğru cümle: 火车九点到。 — Tren dokuzda varıyor.", null, null),
                LearningExercise("zha1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "请往___走。", "", listOf("火车", "左", "机场"), listOf("左"), "Doğru cümle: 请往左走。 — Lütfen sola gidin.", null, null),
                LearningExercise("zha1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı çok uzak.", "Tren dokuzda varıyor.", "Otel şehir merkezinde."), listOf("Havalimanı çok uzak."), "Söylenen cümle: 机场很远。", "机场很远。", null),
                LearningExercise("zha1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "请往左走。", listOf("Havalimanı çok uzak.", "Lütfen sola gidin.", "Bir bilet, teşekkürler."), listOf("Lütfen sola gidin."), "Cümlenin çevirisi: Lütfen sola gidin.", null, null))),
            LearningLesson("ZH-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "火车九点___。", "", listOf("到", "去", "来"), listOf("到"), "Varmak fiili 到: 九点到 (dokuzda varır).", null, null),
                LearningExercise("zha1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 一张票，谢谢。", "", listOf(), listOf("一张票，谢谢。"), "Türkçesi: Bir bilet, teşekkürler.", "一张票，谢谢。", "一张票，谢谢。"),
                LearningExercise("zha1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Çince karşılığı hangisi?", "", listOf("火车", "机场", "酒店"), listOf("酒店"), "Örnek: 酒店在市中心。 — Otel şehir merkezinde.", null, null))))))
}
