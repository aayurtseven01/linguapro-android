package com.linguapro.android

/** Çince (ZH) tam müfredat: A1-C2, 36 ünite, 108 ders. Türkçe yönergeli, elle küratörlü içerik. */
object WorldCourseZH {
    val units: List<LearningUnit> = listOf(
        LearningUnit("ZH-A1-U1", "Selamlaşma ve Tanışma", "Selamlaş, kendini tanıt ve vedalaş.", listOf(
            LearningLesson("ZH-A1-U1-L1", "Selamlaşma ve Tanışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'你好' ne anlama gelir?", "", listOf("teşekkürler", "hoşça kal", "merhaba"), listOf("merhaba"), "你好，我是安娜。 — Merhaba, ben Anna.", null, null),
                LearningExercise("zha1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'谢谢' ne anlama gelir?", "", listOf("benim adım", "teşekkürler", "lütfen"), listOf("teşekkürler"), "谢谢你！ — Teşekkür ederim!", null, null),
                LearningExercise("zha1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'请' ne anlama gelir?", "", listOf("lütfen", "hoşça kal", "merhaba"), listOf("lütfen"), "请坐。 — Lütfen oturun.", null, null)), listOf(
                TargetVocabulary("zha1u1w1", "你好", "merhaba", "ifade", "你好，我是安娜。", "Merhaba, ben Anna."),
                TargetVocabulary("zha1u1w2", "谢谢", "teşekkürler", "ifade", "谢谢你！", "Teşekkür ederim!"),
                TargetVocabulary("zha1u1w3", "请", "lütfen", "ifade", "请坐。", "Lütfen oturun."),
                TargetVocabulary("zha1u1w4", "再见", "hoşça kal", "ifade", "再见，明天见！", "Hoşça kal, yarın görüşürüz!"),
                TargetVocabulary("zha1u1w5", "我叫", "benim adım", "ifade", "我叫王明。", "Benim adım Wang Ming."))),
            LearningLesson("ZH-A1-U1-L2", "Selamlaşma ve Tanışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___，我是安娜。", "", listOf("请", "你好", "谢谢"), listOf("你好"), "Doğru cümle: 你好，我是安娜。 — Merhaba, ben Anna.", null, null),
                LearningExercise("zha1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___，明天见！", "", listOf("再见", "我叫", "你好"), listOf("再见"), "Doğru cümle: 再见，明天见！ — Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("zha1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Merhaba, ben Anna.", "Lütfen oturun.", "Benim adım Wang Ming."), listOf("Benim adım Wang Ming."), "Söylenen cümle: 我叫王明。", "我叫王明。", null),
                LearningExercise("zha1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "再见，明天见！", listOf("Hoşça kal, yarın görüşürüz!", "Teşekkür ederim!", "Benim adım Wang Ming."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("ZH-A1-U1-L3", "Selamlaşma ve Tanışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "你___什么名字？", "", listOf("叫", "是", "去"), listOf("叫"), "İsim sorma kalıbı: 你叫什么名字？(Adın ne?)", null, null),
                LearningExercise("zha1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 谢谢你！", "", listOf(), listOf("谢谢你！"), "Türkçesi: Teşekkür ederim!", "谢谢你！", "谢谢你！"),
                LearningExercise("zha1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lütfen' ifadesinin Çince karşılığı hangisi?", "", listOf("我叫", "请", "你好"), listOf("请"), "Örnek: 请坐。 — Lütfen oturun.", null, null))),
            LearningLesson("ZH-A1-U1-L4", "Selamlaşma ve Tanışma — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha1u1e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Hoşça kal, yarın görüşürüz!", "Merhaba, ben Anna.", "Lütfen oturun."), listOf("Merhaba, ben Anna."), "Söylenen cümle: 你好，我是安娜。", "你好，我是安娜。", null),
                LearningExercise("zha1u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Hoşça kal, yarın görüşürüz!", "Benim adım Wang Ming.", "Teşekkür ederim!"), listOf("Teşekkür ederim!"), "Söylenen cümle: 谢谢你！", "谢谢你！", null),
                LearningExercise("zha1u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'hoşça kal' ifadesinin Çince karşılığı hangisi?", "", listOf("再见", "谢谢", "我叫"), listOf("再见"), "Örnek: 再见，明天见！ — Hoşça kal, yarın görüşürüz!", null, null))),
            LearningLesson("ZH-A1-U1-L5", "Selamlaşma ve Tanışma — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha1u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我叫王明。", listOf("Hoşça kal, yarın görüşürüz!", "Benim adım Wang Ming.", "Teşekkür ederim!"), listOf("Benim adım Wang Ming."), "Cümlenin çevirisi: Benim adım Wang Ming.", null, null),
                LearningExercise("zha1u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "再见，明天见！", listOf("Hoşça kal, yarın görüşürüz!", "Lütfen oturun.", "Benim adım Wang Ming."), listOf("Hoşça kal, yarın görüşürüz!"), "Cümlenin çevirisi: Hoşça kal, yarın görüşürüz!", null, null),
                LearningExercise("zha1u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 你好，我是安娜。", "", listOf(), listOf("你好，我是安娜。"), "Türkçesi: Merhaba, ben Anna.", "你好，我是安娜。", "你好，我是安娜。"))))),
        LearningUnit("ZH-A1-U2", "Sayılar ve Zaman", "Sayıları say, saati ve günleri söyle.", listOf(
            LearningLesson("ZH-A1-U2-L1", "Sayılar ve Zaman — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'二' ne anlama gelir?", "", listOf("yarın", "iki", "on"), listOf("iki"), "二月很冷。 — Şubat çok soğuk.", null, null),
                LearningExercise("zha1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'十' ne anlama gelir?", "", listOf("on", "bugün", "saat (...da)"), listOf("on"), "现在十点。 — Saat şimdi on.", null, null),
                LearningExercise("zha1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'今天' ne anlama gelir?", "", listOf("yarın", "iki", "bugün"), listOf("bugün"), "今天星期一。 — Bugün pazartesi.", null, null)), listOf(
                TargetVocabulary("zha1u2w1", "二", "iki", "ifade", "二月很冷。", "Şubat çok soğuk."),
                TargetVocabulary("zha1u2w2", "十", "on", "ifade", "现在十点。", "Saat şimdi on."),
                TargetVocabulary("zha1u2w3", "今天", "bugün", "ifade", "今天星期一。", "Bugün pazartesi."),
                TargetVocabulary("zha1u2w4", "明天", "yarın", "ifade", "明天见！", "Yarın görüşürüz!"),
                TargetVocabulary("zha1u2w5", "点", "saat (...da)", "ifade", "现在几点？", "Saat kaç?"))),
            LearningLesson("ZH-A1-U2-L2", "Sayılar ve Zaman — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___月很冷。", "", listOf("二", "十", "今天"), listOf("二"), "Doğru cümle: 二月很冷。 — Şubat çok soğuk.", null, null),
                LearningExercise("zha1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___见！", "", listOf("点", "二", "明天"), listOf("明天"), "Doğru cümle: 明天见！ — Yarın görüşürüz!", null, null),
                LearningExercise("zha1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün pazartesi.", "Saat kaç?", "Şubat çok soğuk."), listOf("Saat kaç?"), "Söylenen cümle: 现在几点？", "现在几点？", null),
                LearningExercise("zha1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "明天见！", listOf("Saat şimdi on.", "Saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null))),
            LearningLesson("ZH-A1-U2-L3", "Sayılar ve Zaman — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "现在几___？", "", listOf("点", "时", "分"), listOf("点"), "Saat sorma kalıbı: 现在几点？", null, null),
                LearningExercise("zha1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 现在十点。", "", listOf(), listOf("现在十点。"), "Türkçesi: Saat şimdi on.", "现在十点。", "现在十点。"),
                LearningExercise("zha1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bugün' ifadesinin Çince karşılığı hangisi?", "", listOf("今天", "二", "点"), listOf("今天"), "Örnek: 今天星期一。 — Bugün pazartesi.", null, null))),
            LearningLesson("ZH-A1-U2-L4", "Sayılar ve Zaman — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha1u2e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Şubat çok soğuk.", "Bugün pazartesi.", "Yarın görüşürüz!"), listOf("Şubat çok soğuk."), "Söylenen cümle: 二月很冷。", "二月很冷。", null),
                LearningExercise("zha1u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Saat kaç?", "Saat şimdi on.", "Yarın görüşürüz!"), listOf("Saat şimdi on."), "Söylenen cümle: 现在十点。", "现在十点。", null),
                LearningExercise("zha1u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'yarın' ifadesinin Çince karşılığı hangisi?", "", listOf("十", "点", "明天"), listOf("明天"), "Örnek: 明天见！ — Yarın görüşürüz!", null, null))),
            LearningLesson("ZH-A1-U2-L5", "Sayılar ve Zaman — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha1u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "现在几点？", listOf("Saat kaç?", "Saat şimdi on.", "Yarın görüşürüz!"), listOf("Saat kaç?"), "Cümlenin çevirisi: Saat kaç?", null, null),
                LearningExercise("zha1u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "明天见！", listOf("Bugün pazartesi.", "Saat kaç?", "Yarın görüşürüz!"), listOf("Yarın görüşürüz!"), "Cümlenin çevirisi: Yarın görüşürüz!", null, null),
                LearningExercise("zha1u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 二月很冷。", "", listOf(), listOf("二月很冷。"), "Türkçesi: Şubat çok soğuk.", "二月很冷。", "二月很冷。"))))),
        LearningUnit("ZH-A1-U3", "Yiyecek ve İçecek", "Temel yiyecekleri söyle ve sipariş ver.", listOf(
            LearningLesson("ZH-A1-U3-L1", "Yiyecek ve İçecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'水' ne anlama gelir?", "", listOf("su", "ekmek", "elma"), listOf("su"), "请给我水。 — Lütfen bana su verin.", null, null),
                LearningExercise("zha1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'面包' ne anlama gelir?", "", listOf("kahve", "çay", "ekmek"), listOf("ekmek"), "面包很新鲜。 — Ekmek çok taze.", null, null),
                LearningExercise("zha1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'咖啡' ne anlama gelir?", "", listOf("su", "kahve", "elma"), listOf("kahve"), "我喝咖啡。 — Kahve içiyorum.", null, null)), listOf(
                TargetVocabulary("zha1u3w1", "水", "su", "ifade", "请给我水。", "Lütfen bana su verin."),
                TargetVocabulary("zha1u3w2", "面包", "ekmek", "ifade", "面包很新鲜。", "Ekmek çok taze."),
                TargetVocabulary("zha1u3w3", "咖啡", "kahve", "ifade", "我喝咖啡。", "Kahve içiyorum."),
                TargetVocabulary("zha1u3w4", "苹果", "elma", "ifade", "苹果是红色的。", "Elma kırmızı."),
                TargetVocabulary("zha1u3w5", "茶", "çay", "ifade", "我喜欢茶。", "Çayı severim."))),
            LearningLesson("ZH-A1-U3-L2", "Yiyecek ve İçecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "请给我___。", "", listOf("面包", "咖啡", "水"), listOf("水"), "Doğru cümle: 请给我水。 — Lütfen bana su verin.", null, null),
                LearningExercise("zha1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___是红色的。", "", listOf("水", "苹果", "茶"), listOf("苹果"), "Doğru cümle: 苹果是红色的。 — Elma kırmızı.", null, null),
                LearningExercise("zha1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çayı severim.", "Lütfen bana su verin.", "Kahve içiyorum."), listOf("Çayı severim."), "Söylenen cümle: 我喜欢茶。", "我喜欢茶。", null),
                LearningExercise("zha1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "苹果是红色的。", listOf("Çayı severim.", "Elma kırmızı.", "Ekmek çok taze."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null))),
            LearningLesson("ZH-A1-U3-L3", "Yiyecek ve İçecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我___咖啡。", "", listOf("喝", "吃", "看"), listOf("喝"), "İçmek fiili 喝: 我喝咖啡 (kahve içiyorum).", null, null),
                LearningExercise("zha1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 面包很新鲜。", "", listOf(), listOf("面包很新鲜。"), "Türkçesi: Ekmek çok taze.", "面包很新鲜。", "面包很新鲜。"),
                LearningExercise("zha1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kahve' ifadesinin Çince karşılığı hangisi?", "", listOf("水", "茶", "咖啡"), listOf("咖啡"), "Örnek: 我喝咖啡。 — Kahve içiyorum.", null, null))),
            LearningLesson("ZH-A1-U3-L4", "Yiyecek ve İçecek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha1u3e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kahve içiyorum.", "Elma kırmızı.", "Lütfen bana su verin."), listOf("Lütfen bana su verin."), "Söylenen cümle: 请给我水。", "请给我水。", null),
                LearningExercise("zha1u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekmek çok taze.", "Elma kırmızı.", "Çayı severim."), listOf("Ekmek çok taze."), "Söylenen cümle: 面包很新鲜。", "面包很新鲜。", null),
                LearningExercise("zha1u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'elma' ifadesinin Çince karşılığı hangisi?", "", listOf("茶", "苹果", "面包"), listOf("苹果"), "Örnek: 苹果是红色的。 — Elma kırmızı.", null, null))),
            LearningLesson("ZH-A1-U3-L5", "Yiyecek ve İçecek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha1u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我喜欢茶。", listOf("Ekmek çok taze.", "Elma kırmızı.", "Çayı severim."), listOf("Çayı severim."), "Cümlenin çevirisi: Çayı severim.", null, null),
                LearningExercise("zha1u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "苹果是红色的。", listOf("Çayı severim.", "Elma kırmızı.", "Kahve içiyorum."), listOf("Elma kırmızı."), "Cümlenin çevirisi: Elma kırmızı.", null, null),
                LearningExercise("zha1u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 请给我水。", "", listOf(), listOf("请给我水。"), "Türkçesi: Lütfen bana su verin.", "请给我水。", "请给我水。"))))),
        LearningUnit("ZH-A1-U4", "Aile ve İnsanlar", "Aile üyelerini tanıt.", listOf(
            LearningLesson("ZH-A1-U4-L1", "Aile ve İnsanlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'家' ne anlama gelir?", "", listOf("anne", "ağabey", "ev / aile"), listOf("ev / aile"), "我家很大。 — Ailem kalabalık.", null, null),
                LearningExercise("zha1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'妈妈' ne anlama gelir?", "", listOf("arkadaş", "anne", "baba"), listOf("anne"), "妈妈在家。 — Annem evde.", null, null),
                LearningExercise("zha1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'爸爸' ne anlama gelir?", "", listOf("baba", "ağabey", "ev / aile"), listOf("baba"), "爸爸工作很忙。 — Babam işte çok meşgul.", null, null)), listOf(
                TargetVocabulary("zha1u4w1", "家", "ev / aile", "ifade", "我家很大。", "Ailem kalabalık."),
                TargetVocabulary("zha1u4w2", "妈妈", "anne", "ifade", "妈妈在家。", "Annem evde."),
                TargetVocabulary("zha1u4w3", "爸爸", "baba", "ifade", "爸爸工作很忙。", "Babam işte çok meşgul."),
                TargetVocabulary("zha1u4w4", "哥哥", "ağabey", "ifade", "我哥哥很年轻。", "Ağabeyim genç."),
                TargetVocabulary("zha1u4w5", "朋友", "arkadaş", "ifade", "他是我的朋友。", "O benim arkadaşım."))),
            LearningLesson("ZH-A1-U4-L2", "Aile ve İnsanlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我___很大。", "", listOf("爸爸", "家", "妈妈"), listOf("家"), "Doğru cümle: 我家很大。 — Ailem kalabalık.", null, null),
                LearningExercise("zha1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我___很年轻。", "", listOf("哥哥", "朋友", "家"), listOf("哥哥"), "Doğru cümle: 我哥哥很年轻。 — Ağabeyim genç.", null, null),
                LearningExercise("zha1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ailem kalabalık.", "Babam işte çok meşgul.", "O benim arkadaşım."), listOf("O benim arkadaşım."), "Söylenen cümle: 他是我的朋友。", "他是我的朋友。", null),
                LearningExercise("zha1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我哥哥很年轻。", listOf("Ağabeyim genç.", "Annem evde.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null))),
            LearningLesson("ZH-A1-U4-L3", "Aile ve İnsanlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这是我___姐姐。", "", listOf("的", "了", "吗"), listOf("的"), "Sahiplik eki 的: 我的姐姐 (benim ablam).", null, null),
                LearningExercise("zha1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 妈妈在家。", "", listOf(), listOf("妈妈在家。"), "Türkçesi: Annem evde.", "妈妈在家。", "妈妈在家。"),
                LearningExercise("zha1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baba' ifadesinin Çince karşılığı hangisi?", "", listOf("朋友", "爸爸", "家"), listOf("爸爸"), "Örnek: 爸爸工作很忙。 — Babam işte çok meşgul.", null, null))),
            LearningLesson("ZH-A1-U4-L4", "Aile ve İnsanlar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha1u4e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ağabeyim genç.", "Ailem kalabalık.", "Babam işte çok meşgul."), listOf("Ailem kalabalık."), "Söylenen cümle: 我家很大。", "我家很大。", null),
                LearningExercise("zha1u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ağabeyim genç.", "O benim arkadaşım.", "Annem evde."), listOf("Annem evde."), "Söylenen cümle: 妈妈在家。", "妈妈在家。", null),
                LearningExercise("zha1u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ağabey' ifadesinin Çince karşılığı hangisi?", "", listOf("哥哥", "妈妈", "朋友"), listOf("哥哥"), "Örnek: 我哥哥很年轻。 — Ağabeyim genç.", null, null))),
            LearningLesson("ZH-A1-U4-L5", "Aile ve İnsanlar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha1u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他是我的朋友。", listOf("Ağabeyim genç.", "O benim arkadaşım.", "Annem evde."), listOf("O benim arkadaşım."), "Cümlenin çevirisi: O benim arkadaşım.", null, null),
                LearningExercise("zha1u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我哥哥很年轻。", listOf("Ağabeyim genç.", "Babam işte çok meşgul.", "O benim arkadaşım."), listOf("Ağabeyim genç."), "Cümlenin çevirisi: Ağabeyim genç.", null, null),
                LearningExercise("zha1u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我家很大。", "", listOf(), listOf("我家很大。"), "Türkçesi: Ailem kalabalık.", "我家很大。", "我家很大。"))))),
        LearningUnit("ZH-A1-U5", "Günlük Yaşam ve Şehir", "Ev, iş ve şehir hakkında konuş.", listOf(
            LearningLesson("ZH-A1-U5-L1", "Günlük Yaşam ve Şehir — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'房子' ne anlama gelir?", "", listOf("satın almak", "ev (bina)", "iş"), listOf("ev (bina)"), "房子很旧。 — Ev çok eski.", null, null),
                LearningExercise("zha1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'工作' ne anlama gelir?", "", listOf("iş", "şehir", "oturmak"), listOf("iş"), "我去工作。 — İşe gidiyorum.", null, null),
                LearningExercise("zha1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'城市' ne anlama gelir?", "", listOf("satın almak", "ev (bina)", "şehir"), listOf("şehir"), "这个城市很漂亮。 — Bu şehir çok güzel.", null, null)), listOf(
                TargetVocabulary("zha1u5w1", "房子", "ev (bina)", "ifade", "房子很旧。", "Ev çok eski."),
                TargetVocabulary("zha1u5w2", "工作", "iş", "ifade", "我去工作。", "İşe gidiyorum."),
                TargetVocabulary("zha1u5w3", "城市", "şehir", "ifade", "这个城市很漂亮。", "Bu şehir çok güzel."),
                TargetVocabulary("zha1u5w4", "买", "satın almak", "ifade", "我们买水果。", "Meyve alıyoruz."),
                TargetVocabulary("zha1u5w5", "住", "oturmak", "ifade", "我住在北京。", "Pekin'de oturuyorum."))),
            LearningLesson("ZH-A1-U5-L2", "Günlük Yaşam ve Şehir — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___很旧。", "", listOf("房子", "工作", "城市"), listOf("房子"), "Doğru cümle: 房子很旧。 — Ev çok eski.", null, null),
                LearningExercise("zha1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们___水果。", "", listOf("住", "房子", "买"), listOf("买"), "Doğru cümle: 我们买水果。 — Meyve alıyoruz.", null, null),
                LearningExercise("zha1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu şehir çok güzel.", "Pekin'de oturuyorum.", "Ev çok eski."), listOf("Pekin'de oturuyorum."), "Söylenen cümle: 我住在北京。", "我住在北京。", null),
                LearningExercise("zha1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们买水果。", listOf("İşe gidiyorum.", "Pekin'de oturuyorum.", "Meyve alıyoruz."), listOf("Meyve alıyoruz."), "Cümlenin çevirisi: Meyve alıyoruz.", null, null))),
            LearningLesson("ZH-A1-U5-L3", "Günlük Yaşam ve Şehir — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "你住___哪里？", "", listOf("在", "到", "从"), listOf("在"), "Konum edatı 在: 住在 (–de oturmak).", null, null),
                LearningExercise("zha1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我去工作。", "", listOf(), listOf("我去工作。"), "Türkçesi: İşe gidiyorum.", "我去工作。", "我去工作。"),
                LearningExercise("zha1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'şehir' ifadesinin Çince karşılığı hangisi?", "", listOf("城市", "房子", "住"), listOf("城市"), "Örnek: 这个城市很漂亮。 — Bu şehir çok güzel.", null, null))),
            LearningLesson("ZH-A1-U5-L4", "Günlük Yaşam ve Şehir — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha1u5e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ev çok eski.", "Bu şehir çok güzel.", "Meyve alıyoruz."), listOf("Ev çok eski."), "Söylenen cümle: 房子很旧。", "房子很旧。", null),
                LearningExercise("zha1u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Pekin'de oturuyorum.", "İşe gidiyorum.", "Meyve alıyoruz."), listOf("İşe gidiyorum."), "Söylenen cümle: 我去工作。", "我去工作。", null),
                LearningExercise("zha1u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'satın almak' ifadesinin Çince karşılığı hangisi?", "", listOf("工作", "住", "买"), listOf("买"), "Örnek: 我们买水果。 — Meyve alıyoruz.", null, null))),
            LearningLesson("ZH-A1-U5-L5", "Günlük Yaşam ve Şehir — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha1u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我住在北京。", listOf("Pekin'de oturuyorum.", "İşe gidiyorum.", "Meyve alıyoruz."), listOf("Pekin'de oturuyorum."), "Cümlenin çevirisi: Pekin'de oturuyorum.", null, null),
                LearningExercise("zha1u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们买水果。", listOf("Bu şehir çok güzel.", "Pekin'de oturuyorum.", "Meyve alıyoruz."), listOf("Meyve alıyoruz."), "Cümlenin çevirisi: Meyve alıyoruz.", null, null),
                LearningExercise("zha1u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 房子很旧。", "", listOf(), listOf("房子很旧。"), "Türkçesi: Ev çok eski.", "房子很旧。", "房子很旧。"))))),
        LearningUnit("ZH-A1-U6", "Seyahat Temelleri", "Bilet al, yol sor, otele yerleş.", listOf(
            LearningLesson("ZH-A1-U6-L1", "Seyahat Temelleri — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'火车' ne anlama gelir?", "", listOf("tren", "bilet", "sol"), listOf("tren"), "火车九点到。 — Tren dokuzda varıyor.", null, null),
                LearningExercise("zha1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'票' ne anlama gelir?", "", listOf("otel", "havalimanı", "bilet"), listOf("bilet"), "一张票，谢谢。 — Bir bilet, teşekkürler.", null, null),
                LearningExercise("zha1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'酒店' ne anlama gelir?", "", listOf("tren", "otel", "sol"), listOf("otel"), "酒店在市中心。 — Otel şehir merkezinde.", null, null)), listOf(
                TargetVocabulary("zha1u6w1", "火车", "tren", "ifade", "火车九点到。", "Tren dokuzda varıyor."),
                TargetVocabulary("zha1u6w2", "票", "bilet", "ifade", "一张票，谢谢。", "Bir bilet, teşekkürler."),
                TargetVocabulary("zha1u6w3", "酒店", "otel", "ifade", "酒店在市中心。", "Otel şehir merkezinde."),
                TargetVocabulary("zha1u6w4", "左", "sol", "ifade", "请往左走。", "Lütfen sola gidin."),
                TargetVocabulary("zha1u6w5", "机场", "havalimanı", "ifade", "机场很远。", "Havalimanı çok uzak."))),
            LearningLesson("ZH-A1-U6-L2", "Seyahat Temelleri — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___九点到。", "", listOf("票", "酒店", "火车"), listOf("火车"), "Doğru cümle: 火车九点到。 — Tren dokuzda varıyor.", null, null),
                LearningExercise("zha1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "请往___走。", "", listOf("火车", "左", "机场"), listOf("左"), "Doğru cümle: 请往左走。 — Lütfen sola gidin.", null, null),
                LearningExercise("zha1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Havalimanı çok uzak.", "Tren dokuzda varıyor.", "Otel şehir merkezinde."), listOf("Havalimanı çok uzak."), "Söylenen cümle: 机场很远。", "机场很远。", null),
                LearningExercise("zha1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "请往左走。", listOf("Havalimanı çok uzak.", "Lütfen sola gidin.", "Bir bilet, teşekkürler."), listOf("Lütfen sola gidin."), "Cümlenin çevirisi: Lütfen sola gidin.", null, null))),
            LearningLesson("ZH-A1-U6-L3", "Seyahat Temelleri — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "火车九点___。", "", listOf("到", "去", "来"), listOf("到"), "Varmak fiili 到: 九点到 (dokuzda varır).", null, null),
                LearningExercise("zha1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 一张票，谢谢。", "", listOf(), listOf("一张票，谢谢。"), "Türkçesi: Bir bilet, teşekkürler.", "一张票，谢谢。", "一张票，谢谢。"),
                LearningExercise("zha1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'otel' ifadesinin Çince karşılığı hangisi?", "", listOf("火车", "机场", "酒店"), listOf("酒店"), "Örnek: 酒店在市中心。 — Otel şehir merkezinde.", null, null))),
            LearningLesson("ZH-A1-U6-L4", "Seyahat Temelleri — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha1u6e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Otel şehir merkezinde.", "Lütfen sola gidin.", "Tren dokuzda varıyor."), listOf("Tren dokuzda varıyor."), "Söylenen cümle: 火车九点到。", "火车九点到。", null),
                LearningExercise("zha1u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bir bilet, teşekkürler.", "Lütfen sola gidin.", "Havalimanı çok uzak."), listOf("Bir bilet, teşekkürler."), "Söylenen cümle: 一张票，谢谢。", "一张票，谢谢。", null),
                LearningExercise("zha1u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sol' ifadesinin Çince karşılığı hangisi?", "", listOf("机场", "左", "票"), listOf("左"), "Örnek: 请往左走。 — Lütfen sola gidin.", null, null))),
            LearningLesson("ZH-A1-U6-L5", "Seyahat Temelleri — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha1u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "机场很远。", listOf("Bir bilet, teşekkürler.", "Lütfen sola gidin.", "Havalimanı çok uzak."), listOf("Havalimanı çok uzak."), "Cümlenin çevirisi: Havalimanı çok uzak.", null, null),
                LearningExercise("zha1u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "请往左走。", listOf("Havalimanı çok uzak.", "Lütfen sola gidin.", "Otel şehir merkezinde."), listOf("Lütfen sola gidin."), "Cümlenin çevirisi: Lütfen sola gidin.", null, null),
                LearningExercise("zha1u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 火车九点到。", "", listOf(), listOf("火车九点到。"), "Türkçesi: Tren dokuzda varıyor.", "火车九点到。", "火车九点到。"))))),
        LearningUnit("ZH-A2-U1", "Geçmişten Bahsetmek", "Geçmişte olanları anlat.", listOf(
            LearningLesson("ZH-A2-U1-L1", "Geçmişten Bahsetmek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'昨天' ne anlama gelir?", "", listOf("geçen hafta", "gördü/izledi", "dün"), listOf("dün"), "昨天我工作了。 — Dün çalıştım.", null, null),
                LearningExercise("zha2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'上个星期' ne anlama gelir?", "", listOf("yolculuk", "geçen hafta", "satın aldı"), listOf("geçen hafta"), "上个星期我生病了。 — Geçen hafta hastalandım.", null, null),
                LearningExercise("zha2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'买了' ne anlama gelir?", "", listOf("satın aldı", "gördü/izledi", "dün"), listOf("satın aldı"), "我买了面包。 — Ekmek aldım.", null, null)), listOf(
                TargetVocabulary("zha2u1w1", "昨天", "dün", "ifade", "昨天我工作了。", "Dün çalıştım."),
                TargetVocabulary("zha2u1w2", "上个星期", "geçen hafta", "ifade", "上个星期我生病了。", "Geçen hafta hastalandım."),
                TargetVocabulary("zha2u1w3", "买了", "satın aldı", "ifade", "我买了面包。", "Ekmek aldım."),
                TargetVocabulary("zha2u1w4", "看了", "gördü/izledi", "ifade", "我看了那部电影。", "O filmi izledim."),
                TargetVocabulary("zha2u1w5", "旅行", "yolculuk", "ifade", "那次旅行很棒。", "O yolculuk harikaydı."))),
            LearningLesson("ZH-A2-U1-L2", "Geçmişten Bahsetmek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___我工作了。", "", listOf("买了", "昨天", "上个星期"), listOf("昨天"), "Doğru cümle: 昨天我工作了。 — Dün çalıştım.", null, null),
                LearningExercise("zha2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我___那部电影。", "", listOf("看了", "旅行", "昨天"), listOf("看了"), "Doğru cümle: 我看了那部电影。 — O filmi izledim.", null, null),
                LearningExercise("zha2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dün çalıştım.", "Ekmek aldım.", "O yolculuk harikaydı."), listOf("O yolculuk harikaydı."), "Söylenen cümle: 那次旅行很棒。", "那次旅行很棒。", null),
                LearningExercise("zha2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我看了那部电影。", listOf("O filmi izledim.", "Geçen hafta hastalandım.", "O yolculuk harikaydı."), listOf("O filmi izledim."), "Cümlenin çevirisi: O filmi izledim.", null, null))),
            LearningLesson("ZH-A2-U1-L3", "Geçmişten Bahsetmek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "昨天我去___电影院。", "", listOf("了", "过", "着"), listOf("了"), "Tamamlanma eki: 去了 (gitti).", null, null),
                LearningExercise("zha2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 上个星期我生病了。", "", listOf(), listOf("上个星期我生病了。"), "Türkçesi: Geçen hafta hastalandım.", "上个星期我生病了。", "上个星期我生病了。"),
                LearningExercise("zha2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'satın aldı' ifadesinin Çince karşılığı hangisi?", "", listOf("旅行", "买了", "昨天"), listOf("买了"), "Örnek: 我买了面包。 — Ekmek aldım.", null, null))),
            LearningLesson("ZH-A2-U1-L4", "Geçmişten Bahsetmek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha2u1e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O filmi izledim.", "Dün çalıştım.", "Ekmek aldım."), listOf("Dün çalıştım."), "Söylenen cümle: 昨天我工作了。", "昨天我工作了。", null),
                LearningExercise("zha2u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O filmi izledim.", "O yolculuk harikaydı.", "Geçen hafta hastalandım."), listOf("Geçen hafta hastalandım."), "Söylenen cümle: 上个星期我生病了。", "上个星期我生病了。", null),
                LearningExercise("zha2u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gördü/izledi' ifadesinin Çince karşılığı hangisi?", "", listOf("看了", "上个星期", "旅行"), listOf("看了"), "Örnek: 我看了那部电影。 — O filmi izledim.", null, null))),
            LearningLesson("ZH-A2-U1-L5", "Geçmişten Bahsetmek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha2u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "那次旅行很棒。", listOf("O filmi izledim.", "O yolculuk harikaydı.", "Geçen hafta hastalandım."), listOf("O yolculuk harikaydı."), "Cümlenin çevirisi: O yolculuk harikaydı.", null, null),
                LearningExercise("zha2u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我看了那部电影。", listOf("O filmi izledim.", "Ekmek aldım.", "O yolculuk harikaydı."), listOf("O filmi izledim."), "Cümlenin çevirisi: O filmi izledim.", null, null),
                LearningExercise("zha2u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 昨天我工作了。", "", listOf(), listOf("昨天我工作了。"), "Türkçesi: Dün çalıştım.", "昨天我工作了。", "昨天我工作了。"))))),
        LearningUnit("ZH-A2-U2", "Alışveriş ve Para", "Fiyat sor, ödeme yap.", listOf(
            LearningLesson("ZH-A2-U2-L1", "Alışveriş ve Para — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'钱' ne anlama gelir?", "", listOf("kaç para", "para", "pahalı"), listOf("para"), "我没有很多钱。 — Çok param yok.", null, null),
                LearningExercise("zha2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'贵' ne anlama gelir?", "", listOf("pahalı", "ucuz", "ödemek"), listOf("pahalı"), "这个手机很贵。 — Bu telefon çok pahalı.", null, null),
                LearningExercise("zha2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'便宜' ne anlama gelir?", "", listOf("kaç para", "para", "ucuz"), listOf("ucuz"), "面包很便宜。 — Ekmek çok ucuz.", null, null)), listOf(
                TargetVocabulary("zha2u2w1", "钱", "para", "ifade", "我没有很多钱。", "Çok param yok."),
                TargetVocabulary("zha2u2w2", "贵", "pahalı", "ifade", "这个手机很贵。", "Bu telefon çok pahalı."),
                TargetVocabulary("zha2u2w3", "便宜", "ucuz", "ifade", "面包很便宜。", "Ekmek çok ucuz."),
                TargetVocabulary("zha2u2w4", "多少钱", "kaç para", "ifade", "这个多少钱？", "Bu kaç para?"),
                TargetVocabulary("zha2u2w5", "付钱", "ödemek", "ifade", "我来付钱。", "Ben ödeyeyim."))),
            LearningLesson("ZH-A2-U2-L2", "Alışveriş ve Para — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我没有很多___。", "", listOf("钱", "贵", "便宜"), listOf("钱"), "Doğru cümle: 我没有很多钱。 — Çok param yok.", null, null),
                LearningExercise("zha2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这个___？", "", listOf("付钱", "钱", "多少钱"), listOf("多少钱"), "Doğru cümle: 这个多少钱？ — Bu kaç para?", null, null),
                LearningExercise("zha2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekmek çok ucuz.", "Ben ödeyeyim.", "Çok param yok."), listOf("Ben ödeyeyim."), "Söylenen cümle: 我来付钱。", "我来付钱。", null),
                LearningExercise("zha2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个多少钱？", listOf("Bu telefon çok pahalı.", "Ben ödeyeyim.", "Bu kaç para?"), listOf("Bu kaç para?"), "Cümlenin çevirisi: Bu kaç para?", null, null))),
            LearningLesson("ZH-A2-U2-L3", "Alışveriş ve Para — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这个___钱？", "", listOf("多少", "几个", "什么"), listOf("多少"), "Fiyat sorma: 多少钱？", null, null),
                LearningExercise("zha2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这个手机很贵。", "", listOf(), listOf("这个手机很贵。"), "Türkçesi: Bu telefon çok pahalı.", "这个手机很贵。", "这个手机很贵。"),
                LearningExercise("zha2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ucuz' ifadesinin Çince karşılığı hangisi?", "", listOf("便宜", "钱", "付钱"), listOf("便宜"), "Örnek: 面包很便宜。 — Ekmek çok ucuz.", null, null))),
            LearningLesson("ZH-A2-U2-L4", "Alışveriş ve Para — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha2u2e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çok param yok.", "Ekmek çok ucuz.", "Bu kaç para?"), listOf("Çok param yok."), "Söylenen cümle: 我没有很多钱。", "我没有很多钱。", null),
                LearningExercise("zha2u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ben ödeyeyim.", "Bu telefon çok pahalı.", "Bu kaç para?"), listOf("Bu telefon çok pahalı."), "Söylenen cümle: 这个手机很贵。", "这个手机很贵。", null),
                LearningExercise("zha2u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kaç para' ifadesinin Çince karşılığı hangisi?", "", listOf("贵", "付钱", "多少钱"), listOf("多少钱"), "Örnek: 这个多少钱？ — Bu kaç para?", null, null))),
            LearningLesson("ZH-A2-U2-L5", "Alışveriş ve Para — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha2u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我来付钱。", listOf("Ben ödeyeyim.", "Bu telefon çok pahalı.", "Bu kaç para?"), listOf("Ben ödeyeyim."), "Cümlenin çevirisi: Ben ödeyeyim.", null, null),
                LearningExercise("zha2u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个多少钱？", listOf("Ekmek çok ucuz.", "Ben ödeyeyim.", "Bu kaç para?"), listOf("Bu kaç para?"), "Cümlenin çevirisi: Bu kaç para?", null, null),
                LearningExercise("zha2u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我没有很多钱。", "", listOf(), listOf("我没有很多钱。"), "Türkçesi: Çok param yok.", "我没有很多钱。", "我没有很多钱。"))))),
        LearningUnit("ZH-A2-U3", "Sağlık ve Vücut", "Rahatsızlığını anlat, randevu al.", listOf(
            LearningLesson("ZH-A2-U3-L1", "Sağlık ve Vücut — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'生病' ne anlama gelir?", "", listOf("hastalanmak", "doktor", "eczane"), listOf("hastalanmak"), "我生病了。 — Hastalandım.", null, null),
                LearningExercise("zha2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'医生' ne anlama gelir?", "", listOf("baş", "ağrımak", "doktor"), listOf("doktor"), "医生十点来。 — Doktor onda geliyor.", null, null),
                LearningExercise("zha2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'头' ne anlama gelir?", "", listOf("hastalanmak", "baş", "eczane"), listOf("baş"), "我头疼。 — Başım ağrıyor.", null, null)), listOf(
                TargetVocabulary("zha2u3w1", "生病", "hastalanmak", "ifade", "我生病了。", "Hastalandım."),
                TargetVocabulary("zha2u3w2", "医生", "doktor", "ifade", "医生十点来。", "Doktor onda geliyor."),
                TargetVocabulary("zha2u3w3", "头", "baş", "ifade", "我头疼。", "Başım ağrıyor."),
                TargetVocabulary("zha2u3w4", "药店", "eczane", "ifade", "药店关门了。", "Eczane kapandı."),
                TargetVocabulary("zha2u3w5", "疼", "ağrımak", "ifade", "我的腿很疼。", "Bacağım çok ağrıyor."))),
            LearningLesson("ZH-A2-U3-L2", "Sağlık ve Vücut — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我___了。", "", listOf("医生", "头", "生病"), listOf("生病"), "Doğru cümle: 我生病了。 — Hastalandım.", null, null),
                LearningExercise("zha2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___关门了。", "", listOf("生病", "药店", "疼"), listOf("药店"), "Doğru cümle: 药店关门了。 — Eczane kapandı.", null, null),
                LearningExercise("zha2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bacağım çok ağrıyor.", "Hastalandım.", "Başım ağrıyor."), listOf("Bacağım çok ağrıyor."), "Söylenen cümle: 我的腿很疼。", "我的腿很疼。", null),
                LearningExercise("zha2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "药店关门了。", listOf("Bacağım çok ağrıyor.", "Eczane kapandı.", "Doktor onda geliyor."), listOf("Eczane kapandı."), "Cümlenin çevirisi: Eczane kapandı.", null, null))),
            LearningLesson("ZH-A2-U3-L3", "Sağlık ve Vücut — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我头___。", "", listOf("疼", "病", "累"), listOf("疼"), "Ağrı kalıbı: 头疼 (baş ağrısı).", null, null),
                LearningExercise("zha2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 医生十点来。", "", listOf(), listOf("医生十点来。"), "Türkçesi: Doktor onda geliyor.", "医生十点来。", "医生十点来。"),
                LearningExercise("zha2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'baş' ifadesinin Çince karşılığı hangisi?", "", listOf("生病", "疼", "头"), listOf("头"), "Örnek: 我头疼。 — Başım ağrıyor.", null, null))),
            LearningLesson("ZH-A2-U3-L4", "Sağlık ve Vücut — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha2u3e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Başım ağrıyor.", "Eczane kapandı.", "Hastalandım."), listOf("Hastalandım."), "Söylenen cümle: 我生病了。", "我生病了。", null),
                LearningExercise("zha2u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Doktor onda geliyor.", "Eczane kapandı.", "Bacağım çok ağrıyor."), listOf("Doktor onda geliyor."), "Söylenen cümle: 医生十点来。", "医生十点来。", null),
                LearningExercise("zha2u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'eczane' ifadesinin Çince karşılığı hangisi?", "", listOf("疼", "药店", "医生"), listOf("药店"), "Örnek: 药店关门了。 — Eczane kapandı.", null, null))),
            LearningLesson("ZH-A2-U3-L5", "Sağlık ve Vücut — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha2u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我的腿很疼。", listOf("Doktor onda geliyor.", "Eczane kapandı.", "Bacağım çok ağrıyor."), listOf("Bacağım çok ağrıyor."), "Cümlenin çevirisi: Bacağım çok ağrıyor.", null, null),
                LearningExercise("zha2u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "药店关门了。", listOf("Bacağım çok ağrıyor.", "Eczane kapandı.", "Başım ağrıyor."), listOf("Eczane kapandı."), "Cümlenin çevirisi: Eczane kapandı.", null, null),
                LearningExercise("zha2u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我生病了。", "", listOf(), listOf("我生病了。"), "Türkçesi: Hastalandım.", "我生病了。", "我生病了。"))))),
        LearningUnit("ZH-A2-U4", "Hava Durumu ve Doğa", "Havayı ve mevsimleri anlat.", listOf(
            LearningLesson("ZH-A2-U4-L1", "Hava Durumu ve Doğa — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'天气' ne anlama gelir?", "", listOf("yağmur yağmak", "soğuk", "hava durumu"), listOf("hava durumu"), "今天天气很好。 — Bugün hava çok güzel.", null, null),
                LearningExercise("zha2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'下雨' ne anlama gelir?", "", listOf("sıcak", "yağmur yağmak", "güneş"), listOf("yağmur yağmak"), "明天会下雨。 — Yarın yağmur yağacak.", null, null),
                LearningExercise("zha2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'太阳' ne anlama gelir?", "", listOf("güneş", "soğuk", "hava durumu"), listOf("güneş"), "太阳出来了。 — Güneş çıktı.", null, null)), listOf(
                TargetVocabulary("zha2u4w1", "天气", "hava durumu", "ifade", "今天天气很好。", "Bugün hava çok güzel."),
                TargetVocabulary("zha2u4w2", "下雨", "yağmur yağmak", "ifade", "明天会下雨。", "Yarın yağmur yağacak."),
                TargetVocabulary("zha2u4w3", "太阳", "güneş", "ifade", "太阳出来了。", "Güneş çıktı."),
                TargetVocabulary("zha2u4w4", "冷", "soğuk", "ifade", "冬天很冷。", "Kışın hava çok soğuk."),
                TargetVocabulary("zha2u4w5", "热", "sıcak", "ifade", "夏天很热。", "Yazın hava çok sıcak."))),
            LearningLesson("ZH-A2-U4-L2", "Hava Durumu ve Doğa — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "今天___很好。", "", listOf("太阳", "天气", "下雨"), listOf("天气"), "Doğru cümle: 今天天气很好。 — Bugün hava çok güzel.", null, null),
                LearningExercise("zha2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "冬天很___。", "", listOf("冷", "热", "天气"), listOf("冷"), "Doğru cümle: 冬天很冷。 — Kışın hava çok soğuk.", null, null),
                LearningExercise("zha2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bugün hava çok güzel.", "Güneş çıktı.", "Yazın hava çok sıcak."), listOf("Yazın hava çok sıcak."), "Söylenen cümle: 夏天很热。", "夏天很热。", null),
                LearningExercise("zha2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "冬天很冷。", listOf("Kışın hava çok soğuk.", "Yarın yağmur yağacak.", "Yazın hava çok sıcak."), listOf("Kışın hava çok soğuk."), "Cümlenin çevirisi: Kışın hava çok soğuk.", null, null))),
            LearningLesson("ZH-A2-U4-L3", "Hava Durumu ve Doğa — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "明天___下雨。", "", listOf("会", "要是", "是"), listOf("会"), "Gelecek tahmini: 会下雨.", null, null),
                LearningExercise("zha2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 明天会下雨。", "", listOf(), listOf("明天会下雨。"), "Türkçesi: Yarın yağmur yağacak.", "明天会下雨。", "明天会下雨。"),
                LearningExercise("zha2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'güneş' ifadesinin Çince karşılığı hangisi?", "", listOf("热", "太阳", "天气"), listOf("太阳"), "Örnek: 太阳出来了。 — Güneş çıktı.", null, null))),
            LearningLesson("ZH-A2-U4-L4", "Hava Durumu ve Doğa — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha2u4e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kışın hava çok soğuk.", "Bugün hava çok güzel.", "Güneş çıktı."), listOf("Bugün hava çok güzel."), "Söylenen cümle: 今天天气很好。", "今天天气很好。", null),
                LearningExercise("zha2u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kışın hava çok soğuk.", "Yazın hava çok sıcak.", "Yarın yağmur yağacak."), listOf("Yarın yağmur yağacak."), "Söylenen cümle: 明天会下雨。", "明天会下雨。", null),
                LearningExercise("zha2u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'soğuk' ifadesinin Çince karşılığı hangisi?", "", listOf("冷", "下雨", "热"), listOf("冷"), "Örnek: 冬天很冷。 — Kışın hava çok soğuk.", null, null))),
            LearningLesson("ZH-A2-U4-L5", "Hava Durumu ve Doğa — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha2u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "夏天很热。", listOf("Kışın hava çok soğuk.", "Yazın hava çok sıcak.", "Yarın yağmur yağacak."), listOf("Yazın hava çok sıcak."), "Cümlenin çevirisi: Yazın hava çok sıcak.", null, null),
                LearningExercise("zha2u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "冬天很冷。", listOf("Kışın hava çok soğuk.", "Güneş çıktı.", "Yazın hava çok sıcak."), listOf("Kışın hava çok soğuk."), "Cümlenin çevirisi: Kışın hava çok soğuk.", null, null),
                LearningExercise("zha2u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 今天天气很好。", "", listOf(), listOf("今天天气很好。"), "Türkçesi: Bugün hava çok güzel.", "今天天气很好。", "今天天气很好。"))))),
        LearningUnit("ZH-A2-U5", "İş ve Okul", "İş ve eğitim hayatından bahset.", listOf(
            LearningLesson("ZH-A2-U5-L1", "İş ve Okul — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'办公室' ne anlama gelir?", "", listOf("öğretmen", "ofis", "öğrenmek/çalışmak"), listOf("ofis"), "办公室在市中心。 — Ofis şehir merkezinde.", null, null),
                LearningExercise("zha2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'学习' ne anlama gelir?", "", listOf("öğrenmek/çalışmak", "sınav", "toplantı yapmak"), listOf("öğrenmek/çalışmak"), "我在学习汉语。 — Çince çalışıyorum.", null, null),
                LearningExercise("zha2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'考试' ne anlama gelir?", "", listOf("öğretmen", "ofis", "sınav"), listOf("sınav"), "考试在星期五。 — Sınav cuma günü.", null, null)), listOf(
                TargetVocabulary("zha2u5w1", "办公室", "ofis", "ifade", "办公室在市中心。", "Ofis şehir merkezinde."),
                TargetVocabulary("zha2u5w2", "学习", "öğrenmek/çalışmak", "ifade", "我在学习汉语。", "Çince çalışıyorum."),
                TargetVocabulary("zha2u5w3", "考试", "sınav", "ifade", "考试在星期五。", "Sınav cuma günü."),
                TargetVocabulary("zha2u5w4", "老师", "öğretmen", "ifade", "老师解释得很清楚。", "Öğretmen çok net açıklıyor."),
                TargetVocabulary("zha2u5w5", "开会", "toplantı yapmak", "ifade", "我们九点开会。", "Dokuzda toplantı yapıyoruz."))),
            LearningLesson("ZH-A2-U5-L2", "İş ve Okul — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___在市中心。", "", listOf("办公室", "学习", "考试"), listOf("办公室"), "Doğru cümle: 办公室在市中心。 — Ofis şehir merkezinde.", null, null),
                LearningExercise("zha2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___解释得很清楚。", "", listOf("开会", "办公室", "老师"), listOf("老师"), "Doğru cümle: 老师解释得很清楚。 — Öğretmen çok net açıklıyor.", null, null),
                LearningExercise("zha2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sınav cuma günü.", "Dokuzda toplantı yapıyoruz.", "Ofis şehir merkezinde."), listOf("Dokuzda toplantı yapıyoruz."), "Söylenen cümle: 我们九点开会。", "我们九点开会。", null),
                LearningExercise("zha2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "老师解释得很清楚。", listOf("Çince çalışıyorum.", "Dokuzda toplantı yapıyoruz.", "Öğretmen çok net açıklıyor."), listOf("Öğretmen çok net açıklıyor."), "Cümlenin çevirisi: Öğretmen çok net açıklıyor.", null, null))),
            LearningLesson("ZH-A2-U5-L3", "İş ve Okul — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我在___汉语。", "", listOf("学习", "开会", "考试"), listOf("学习"), "Şimdiki zaman: 在 + eylem.", null, null),
                LearningExercise("zha2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我在学习汉语。", "", listOf(), listOf("我在学习汉语。"), "Türkçesi: Çince çalışıyorum.", "我在学习汉语。", "我在学习汉语。"),
                LearningExercise("zha2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sınav' ifadesinin Çince karşılığı hangisi?", "", listOf("考试", "办公室", "开会"), listOf("考试"), "Örnek: 考试在星期五。 — Sınav cuma günü.", null, null))),
            LearningLesson("ZH-A2-U5-L4", "İş ve Okul — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha2u5e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ofis şehir merkezinde.", "Sınav cuma günü.", "Öğretmen çok net açıklıyor."), listOf("Ofis şehir merkezinde."), "Söylenen cümle: 办公室在市中心。", "办公室在市中心。", null),
                LearningExercise("zha2u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dokuzda toplantı yapıyoruz.", "Çince çalışıyorum.", "Öğretmen çok net açıklıyor."), listOf("Çince çalışıyorum."), "Söylenen cümle: 我在学习汉语。", "我在学习汉语。", null),
                LearningExercise("zha2u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'öğretmen' ifadesinin Çince karşılığı hangisi?", "", listOf("学习", "开会", "老师"), listOf("老师"), "Örnek: 老师解释得很清楚。 — Öğretmen çok net açıklıyor.", null, null))),
            LearningLesson("ZH-A2-U5-L5", "İş ve Okul — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha2u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们九点开会。", listOf("Dokuzda toplantı yapıyoruz.", "Çince çalışıyorum.", "Öğretmen çok net açıklıyor."), listOf("Dokuzda toplantı yapıyoruz."), "Cümlenin çevirisi: Dokuzda toplantı yapıyoruz.", null, null),
                LearningExercise("zha2u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "老师解释得很清楚。", listOf("Sınav cuma günü.", "Dokuzda toplantı yapıyoruz.", "Öğretmen çok net açıklıyor."), listOf("Öğretmen çok net açıklıyor."), "Cümlenin çevirisi: Öğretmen çok net açıklıyor.", null, null),
                LearningExercise("zha2u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 办公室在市中心。", "", listOf(), listOf("办公室在市中心。"), "Türkçesi: Ofis şehir merkezinde.", "办公室在市中心。", "办公室在市中心。"))))),
        LearningUnit("ZH-A2-U6", "Planlar ve Gelecek", "Gelecek planlarını anlat.", listOf(
            LearningLesson("ZH-A2-U6-L1", "Planlar ve Gelecek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zha2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'周末' ne anlama gelir?", "", listOf("hafta sonu", "plan", "tatil"), listOf("hafta sonu"), "周末我休息。 — Hafta sonu dinlenirim.", null, null),
                LearningExercise("zha2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'计划' ne anlama gelir?", "", listOf("gezmek/turizm", "gelecek", "plan"), listOf("plan"), "我有一个夏天的计划。 — Yaz için bir planım var.", null, null),
                LearningExercise("zha2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'旅游' ne anlama gelir?", "", listOf("hafta sonu", "gezmek/turizm", "tatil"), listOf("gezmek/turizm"), "我喜欢去旅游。 — Geziye çıkmayı severim.", null, null)), listOf(
                TargetVocabulary("zha2u6w1", "周末", "hafta sonu", "ifade", "周末我休息。", "Hafta sonu dinlenirim."),
                TargetVocabulary("zha2u6w2", "计划", "plan", "ifade", "我有一个夏天的计划。", "Yaz için bir planım var."),
                TargetVocabulary("zha2u6w3", "旅游", "gezmek/turizm", "ifade", "我喜欢去旅游。", "Geziye çıkmayı severim."),
                TargetVocabulary("zha2u6w4", "假期", "tatil", "ifade", "假期快开始了。", "Tatil yakında başlıyor."),
                TargetVocabulary("zha2u6w5", "将来", "gelecek", "ifade", "将来我想住在国外。", "Gelecekte yurt dışında yaşamak istiyorum."))),
            LearningLesson("ZH-A2-U6-L2", "Planlar ve Gelecek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zha2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___我休息。", "", listOf("计划", "旅游", "周末"), listOf("周末"), "Doğru cümle: 周末我休息。 — Hafta sonu dinlenirim.", null, null),
                LearningExercise("zha2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___快开始了。", "", listOf("周末", "假期", "将来"), listOf("假期"), "Doğru cümle: 假期快开始了。 — Tatil yakında başlıyor.", null, null),
                LearningExercise("zha2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Gelecekte yurt dışında yaşamak istiyorum.", "Hafta sonu dinlenirim.", "Geziye çıkmayı severim."), listOf("Gelecekte yurt dışında yaşamak istiyorum."), "Söylenen cümle: 将来我想住在国外。", "将来我想住在国外。", null),
                LearningExercise("zha2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "假期快开始了。", listOf("Gelecekte yurt dışında yaşamak istiyorum.", "Tatil yakında başlıyor.", "Yaz için bir planım var."), listOf("Tatil yakında başlıyor."), "Cümlenin çevirisi: Tatil yakında başlıyor.", null, null))),
            LearningLesson("ZH-A2-U6-L3", "Planlar ve Gelecek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zha2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我打算明年___中国。", "", listOf("去", "来", "到"), listOf("去"), "Plan kalıbı: 打算去 (gitmeyi planlamak).", null, null),
                LearningExercise("zha2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我有一个夏天的计划。", "", listOf(), listOf("我有一个夏天的计划。"), "Türkçesi: Yaz için bir planım var.", "我有一个夏天的计划。", "我有一个夏天的计划。"),
                LearningExercise("zha2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gezmek/turizm' ifadesinin Çince karşılığı hangisi?", "", listOf("周末", "将来", "旅游"), listOf("旅游"), "Örnek: 我喜欢去旅游。 — Geziye çıkmayı severim.", null, null))),
            LearningLesson("ZH-A2-U6-L4", "Planlar ve Gelecek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zha2u6e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Geziye çıkmayı severim.", "Tatil yakında başlıyor.", "Hafta sonu dinlenirim."), listOf("Hafta sonu dinlenirim."), "Söylenen cümle: 周末我休息。", "周末我休息。", null),
                LearningExercise("zha2u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yaz için bir planım var.", "Tatil yakında başlıyor.", "Gelecekte yurt dışında yaşamak istiyorum."), listOf("Yaz için bir planım var."), "Söylenen cümle: 我有一个夏天的计划。", "我有一个夏天的计划。", null),
                LearningExercise("zha2u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'tatil' ifadesinin Çince karşılığı hangisi?", "", listOf("将来", "假期", "计划"), listOf("假期"), "Örnek: 假期快开始了。 — Tatil yakında başlıyor.", null, null))),
            LearningLesson("ZH-A2-U6-L5", "Planlar ve Gelecek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zha2u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "将来我想住在国外。", listOf("Yaz için bir planım var.", "Tatil yakında başlıyor.", "Gelecekte yurt dışında yaşamak istiyorum."), listOf("Gelecekte yurt dışında yaşamak istiyorum."), "Cümlenin çevirisi: Gelecekte yurt dışında yaşamak istiyorum.", null, null),
                LearningExercise("zha2u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "假期快开始了。", listOf("Gelecekte yurt dışında yaşamak istiyorum.", "Tatil yakında başlıyor.", "Geziye çıkmayı severim."), listOf("Tatil yakında başlıyor."), "Cümlenin çevirisi: Tatil yakında başlıyor.", null, null),
                LearningExercise("zha2u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 周末我休息。", "", listOf(), listOf("周末我休息。"), "Türkçesi: Hafta sonu dinlenirim.", "周末我休息。", "周末我休息。"))))),
        LearningUnit("ZH-B1-U1", "Deneyimler ve Anılar", "Anılarını ayrıntılarıyla paylaş.", listOf(
            LearningLesson("ZH-B1-U1-L1", "Deneyimler ve Anılar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'经验' ne anlama gelir?", "", listOf("hatırlamak", "o zamanlar", "deneyim"), listOf("deneyim"), "这次经验改变了我。 — Bu deneyim beni değiştirdi.", null, null),
                LearningExercise("zhb1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'记得' ne anlama gelir?", "", listOf("anı", "hatırlamak", "çocukluk"), listOf("hatırlamak"), "我记得我的童年。 — Çocukluğumu hatırlıyorum.", null, null),
                LearningExercise("zhb1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'童年' ne anlama gelir?", "", listOf("çocukluk", "o zamanlar", "deneyim"), listOf("çocukluk"), "我的童年很快乐。 — Çocukluğum çok mutluydu.", null, null)), listOf(
                TargetVocabulary("zhb1u1w1", "经验", "deneyim", "ifade", "这次经验改变了我。", "Bu deneyim beni değiştirdi."),
                TargetVocabulary("zhb1u1w2", "记得", "hatırlamak", "ifade", "我记得我的童年。", "Çocukluğumu hatırlıyorum."),
                TargetVocabulary("zhb1u1w3", "童年", "çocukluk", "ifade", "我的童年很快乐。", "Çocukluğum çok mutluydu."),
                TargetVocabulary("zhb1u1w4", "那时候", "o zamanlar", "ifade", "那时候我们住在农村。", "O zamanlar kırsalda yaşıyorduk."),
                TargetVocabulary("zhb1u1w5", "回忆", "anı", "ifade", "这个回忆很珍贵。", "Bu anı çok değerli."))),
            LearningLesson("ZH-B1-U1-L2", "Deneyimler ve Anılar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这次___改变了我。", "", listOf("童年", "经验", "记得"), listOf("经验"), "Doğru cümle: 这次经验改变了我。 — Bu deneyim beni değiştirdi.", null, null),
                LearningExercise("zhb1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___我们住在农村。", "", listOf("那时候", "回忆", "经验"), listOf("那时候"), "Doğru cümle: 那时候我们住在农村。 — O zamanlar kırsalda yaşıyorduk.", null, null),
                LearningExercise("zhb1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu deneyim beni değiştirdi.", "Çocukluğum çok mutluydu.", "Bu anı çok değerli."), listOf("Bu anı çok değerli."), "Söylenen cümle: 这个回忆很珍贵。", "这个回忆很珍贵。", null),
                LearningExercise("zhb1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "那时候我们住在农村。", listOf("O zamanlar kırsalda yaşıyorduk.", "Çocukluğumu hatırlıyorum.", "Bu anı çok değerli."), listOf("O zamanlar kırsalda yaşıyorduk."), "Cümlenin çevirisi: O zamanlar kırsalda yaşıyorduk.", null, null))),
            LearningLesson("ZH-B1-U1-L3", "Deneyimler ve Anılar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我小时候___在农村。", "", listOf("住", "站", "坐"), listOf("住"), "Yaşamak: 住在 + yer.", null, null),
                LearningExercise("zhb1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我记得我的童年。", "", listOf(), listOf("我记得我的童年。"), "Türkçesi: Çocukluğumu hatırlıyorum.", "我记得我的童年。", "我记得我的童年。"),
                LearningExercise("zhb1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'çocukluk' ifadesinin Çince karşılığı hangisi?", "", listOf("回忆", "童年", "经验"), listOf("童年"), "Örnek: 我的童年很快乐。 — Çocukluğum çok mutluydu.", null, null))),
            LearningLesson("ZH-B1-U1-L4", "Deneyimler ve Anılar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb1u1e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O zamanlar kırsalda yaşıyorduk.", "Bu deneyim beni değiştirdi.", "Çocukluğum çok mutluydu."), listOf("Bu deneyim beni değiştirdi."), "Söylenen cümle: 这次经验改变了我。", "这次经验改变了我。", null),
                LearningExercise("zhb1u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("O zamanlar kırsalda yaşıyorduk.", "Bu anı çok değerli.", "Çocukluğumu hatırlıyorum."), listOf("Çocukluğumu hatırlıyorum."), "Söylenen cümle: 我记得我的童年。", "我记得我的童年。", null),
                LearningExercise("zhb1u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'o zamanlar' ifadesinin Çince karşılığı hangisi?", "", listOf("那时候", "记得", "回忆"), listOf("那时候"), "Örnek: 那时候我们住在农村。 — O zamanlar kırsalda yaşıyorduk.", null, null))),
            LearningLesson("ZH-B1-U1-L5", "Deneyimler ve Anılar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb1u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个回忆很珍贵。", listOf("O zamanlar kırsalda yaşıyorduk.", "Bu anı çok değerli.", "Çocukluğumu hatırlıyorum."), listOf("Bu anı çok değerli."), "Cümlenin çevirisi: Bu anı çok değerli.", null, null),
                LearningExercise("zhb1u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "那时候我们住在农村。", listOf("O zamanlar kırsalda yaşıyorduk.", "Çocukluğum çok mutluydu.", "Bu anı çok değerli."), listOf("O zamanlar kırsalda yaşıyorduk."), "Cümlenin çevirisi: O zamanlar kırsalda yaşıyorduk.", null, null),
                LearningExercise("zhb1u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这次经验改变了我。", "", listOf(), listOf("这次经验改变了我。"), "Türkçesi: Bu deneyim beni değiştirdi.", "这次经验改变了我。", "这次经验改变了我。"))))),
        LearningUnit("ZH-B1-U2", "Medya ve Teknoloji", "Teknoloji ve haberler hakkında konuş.", listOf(
            LearningLesson("ZH-B1-U2-L1", "Medya ve Teknoloji — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'新闻' ne anlama gelir?", "", listOf("ağ/internet", "haberler", "cihaz"), listOf("haberler"), "我晚上看新闻。 — Akşamları haber izlerim.", null, null),
                LearningExercise("zhb1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'设备' ne anlama gelir?", "", listOf("cihaz", "indirmek", "ekran"), listOf("cihaz"), "这个设备是新的。 — Bu cihaz yeni.", null, null),
                LearningExercise("zhb1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'下载' ne anlama gelir?", "", listOf("ağ/internet", "haberler", "indirmek"), listOf("indirmek"), "我想下载这个应用。 — Bu uygulamayı indirmek istiyorum.", null, null)), listOf(
                TargetVocabulary("zhb1u2w1", "新闻", "haberler", "ifade", "我晚上看新闻。", "Akşamları haber izlerim."),
                TargetVocabulary("zhb1u2w2", "设备", "cihaz", "ifade", "这个设备是新的。", "Bu cihaz yeni."),
                TargetVocabulary("zhb1u2w3", "下载", "indirmek", "ifade", "我想下载这个应用。", "Bu uygulamayı indirmek istiyorum."),
                TargetVocabulary("zhb1u2w4", "网络", "ağ/internet", "ifade", "网络很慢。", "İnternet çok yavaş."),
                TargetVocabulary("zhb1u2w5", "屏幕", "ekran", "ifade", "屏幕太亮了。", "Ekran fazla parlak."))),
            LearningLesson("ZH-B1-U2-L2", "Medya ve Teknoloji — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我晚上看___。", "", listOf("新闻", "设备", "下载"), listOf("新闻"), "Doğru cümle: 我晚上看新闻。 — Akşamları haber izlerim.", null, null),
                LearningExercise("zhb1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___很慢。", "", listOf("屏幕", "新闻", "网络"), listOf("网络"), "Doğru cümle: 网络很慢。 — İnternet çok yavaş.", null, null),
                LearningExercise("zhb1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu uygulamayı indirmek istiyorum.", "Ekran fazla parlak.", "Akşamları haber izlerim."), listOf("Ekran fazla parlak."), "Söylenen cümle: 屏幕太亮了。", "屏幕太亮了。", null),
                LearningExercise("zhb1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "网络很慢。", listOf("Bu cihaz yeni.", "Ekran fazla parlak.", "İnternet çok yavaş."), listOf("İnternet çok yavaş."), "Cümlenin çevirisi: İnternet çok yavaş.", null, null))),
            LearningLesson("ZH-B1-U2-L3", "Medya ve Teknoloji — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我已经下载___这个应用。", "", listOf("了", "过着", "的"), listOf("了"), "Tamamlanma: 下载了.", null, null),
                LearningExercise("zhb1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这个设备是新的。", "", listOf(), listOf("这个设备是新的。"), "Türkçesi: Bu cihaz yeni.", "这个设备是新的。", "这个设备是新的。"),
                LearningExercise("zhb1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'indirmek' ifadesinin Çince karşılığı hangisi?", "", listOf("下载", "新闻", "屏幕"), listOf("下载"), "Örnek: 我想下载这个应用。 — Bu uygulamayı indirmek istiyorum.", null, null))),
            LearningLesson("ZH-B1-U2-L4", "Medya ve Teknoloji — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb1u2e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Akşamları haber izlerim.", "Bu uygulamayı indirmek istiyorum.", "İnternet çok yavaş."), listOf("Akşamları haber izlerim."), "Söylenen cümle: 我晚上看新闻。", "我晚上看新闻。", null),
                LearningExercise("zhb1u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Ekran fazla parlak.", "Bu cihaz yeni.", "İnternet çok yavaş."), listOf("Bu cihaz yeni."), "Söylenen cümle: 这个设备是新的。", "这个设备是新的。", null),
                LearningExercise("zhb1u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ağ/internet' ifadesinin Çince karşılığı hangisi?", "", listOf("设备", "屏幕", "网络"), listOf("网络"), "Örnek: 网络很慢。 — İnternet çok yavaş.", null, null))),
            LearningLesson("ZH-B1-U2-L5", "Medya ve Teknoloji — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb1u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "屏幕太亮了。", listOf("Ekran fazla parlak.", "Bu cihaz yeni.", "İnternet çok yavaş."), listOf("Ekran fazla parlak."), "Cümlenin çevirisi: Ekran fazla parlak.", null, null),
                LearningExercise("zhb1u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "网络很慢。", listOf("Bu uygulamayı indirmek istiyorum.", "Ekran fazla parlak.", "İnternet çok yavaş."), listOf("İnternet çok yavaş."), "Cümlenin çevirisi: İnternet çok yavaş.", null, null),
                LearningExercise("zhb1u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我晚上看新闻。", "", listOf(), listOf("我晚上看新闻。"), "Türkçesi: Akşamları haber izlerim.", "我晚上看新闻。", "我晚上看新闻。"))))),
        LearningUnit("ZH-B1-U3", "Duygular ve İlişkiler", "Duygularını ve ilişkilerini anlat.", listOf(
            LearningLesson("ZH-B1-U3-L1", "Duygular ve İlişkiler — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'友谊' ne anlama gelir?", "", listOf("arkadaşlık", "güven", "kavga etmek"), listOf("arkadaşlık"), "我们的友谊很深。 — Arkadaşlığımız çok derin.", null, null),
                LearningExercise("zhb1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'信任' ne anlama gelir?", "", listOf("hayal kırıklığı", "duygu", "güven"), listOf("güven"), "信任需要时间。 — Güven zaman ister.", null, null),
                LearningExercise("zhb1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'失望' ne anlama gelir?", "", listOf("arkadaşlık", "hayal kırıklığı", "kavga etmek"), listOf("hayal kırıklığı"), "我对结果很失望。 — Sonuçtan çok hayal kırıklığına uğradım.", null, null)), listOf(
                TargetVocabulary("zhb1u3w1", "友谊", "arkadaşlık", "ifade", "我们的友谊很深。", "Arkadaşlığımız çok derin."),
                TargetVocabulary("zhb1u3w2", "信任", "güven", "ifade", "信任需要时间。", "Güven zaman ister."),
                TargetVocabulary("zhb1u3w3", "失望", "hayal kırıklığı", "ifade", "我对结果很失望。", "Sonuçtan çok hayal kırıklığına uğradım."),
                TargetVocabulary("zhb1u3w4", "吵架", "kavga etmek", "ifade", "我们很少吵架。", "Çok nadir kavga ederiz."),
                TargetVocabulary("zhb1u3w5", "感情", "duygu", "ifade", "这是一种奇怪的感情。", "Bu tuhaf bir duygu."))),
            LearningLesson("ZH-B1-U3-L2", "Duygular ve İlişkiler — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们的___很深。", "", listOf("信任", "失望", "友谊"), listOf("友谊"), "Doğru cümle: 我们的友谊很深。 — Arkadaşlığımız çok derin.", null, null),
                LearningExercise("zhb1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们很少___。", "", listOf("友谊", "吵架", "感情"), listOf("吵架"), "Doğru cümle: 我们很少吵架。 — Çok nadir kavga ederiz.", null, null),
                LearningExercise("zhb1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu tuhaf bir duygu.", "Arkadaşlığımız çok derin.", "Sonuçtan çok hayal kırıklığına uğradım."), listOf("Bu tuhaf bir duygu."), "Söylenen cümle: 这是一种奇怪的感情。", "这是一种奇怪的感情。", null),
                LearningExercise("zhb1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们很少吵架。", listOf("Bu tuhaf bir duygu.", "Çok nadir kavga ederiz.", "Güven zaman ister."), listOf("Çok nadir kavga ederiz."), "Cümlenin çevirisi: Çok nadir kavga ederiz.", null, null))),
            LearningLesson("ZH-B1-U3-L3", "Duygular ve İlişkiler — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我___结果很失望。", "", listOf("对", "给", "向"), listOf("对"), "Edat: 对...失望 (bir şeyden hayal kırıklığına uğramak).", null, null),
                LearningExercise("zhb1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 信任需要时间。", "", listOf(), listOf("信任需要时间。"), "Türkçesi: Güven zaman ister.", "信任需要时间。", "信任需要时间。"),
                LearningExercise("zhb1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'hayal kırıklığı' ifadesinin Çince karşılığı hangisi?", "", listOf("友谊", "感情", "失望"), listOf("失望"), "Örnek: 我对结果很失望。 — Sonuçtan çok hayal kırıklığına uğradım.", null, null))),
            LearningLesson("ZH-B1-U3-L4", "Duygular ve İlişkiler — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb1u3e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sonuçtan çok hayal kırıklığına uğradım.", "Çok nadir kavga ederiz.", "Arkadaşlığımız çok derin."), listOf("Arkadaşlığımız çok derin."), "Söylenen cümle: 我们的友谊很深。", "我们的友谊很深。", null),
                LearningExercise("zhb1u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Güven zaman ister.", "Çok nadir kavga ederiz.", "Bu tuhaf bir duygu."), listOf("Güven zaman ister."), "Söylenen cümle: 信任需要时间。", "信任需要时间。", null),
                LearningExercise("zhb1u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kavga etmek' ifadesinin Çince karşılığı hangisi?", "", listOf("感情", "吵架", "信任"), listOf("吵架"), "Örnek: 我们很少吵架。 — Çok nadir kavga ederiz.", null, null))),
            LearningLesson("ZH-B1-U3-L5", "Duygular ve İlişkiler — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb1u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这是一种奇怪的感情。", listOf("Güven zaman ister.", "Çok nadir kavga ederiz.", "Bu tuhaf bir duygu."), listOf("Bu tuhaf bir duygu."), "Cümlenin çevirisi: Bu tuhaf bir duygu.", null, null),
                LearningExercise("zhb1u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们很少吵架。", listOf("Bu tuhaf bir duygu.", "Çok nadir kavga ederiz.", "Sonuçtan çok hayal kırıklığına uğradım."), listOf("Çok nadir kavga ederiz."), "Cümlenin çevirisi: Çok nadir kavga ederiz.", null, null),
                LearningExercise("zhb1u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我们的友谊很深。", "", listOf(), listOf("我们的友谊很深。"), "Türkçesi: Arkadaşlığımız çok derin.", "我们的友谊很深。", "我们的友谊很深。"))))),
        LearningUnit("ZH-B1-U4", "Kültür ve Gelenekler", "Gelenekleri ve kültürü tanıt.", listOf(
            LearningLesson("ZH-B1-U4-L1", "Kültür ve Gelenekler — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'风俗' ne anlama gelir?", "", listOf("bayram", "gelenek", "âdet"), listOf("âdet"), "这个风俗很古老。 — Bu âdet çok eski.", null, null),
                LearningExercise("zhb1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'节日' ne anlama gelir?", "", listOf("toplum", "bayram", "kutlamak"), listOf("bayram"), "节日有三天。 — Bayram üç gün sürüyor.", null, null),
                LearningExercise("zhb1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'庆祝' ne anlama gelir?", "", listOf("kutlamak", "gelenek", "âdet"), listOf("kutlamak"), "我们一起庆祝。 — Birlikte kutluyoruz.", null, null)), listOf(
                TargetVocabulary("zhb1u4w1", "风俗", "âdet", "ifade", "这个风俗很古老。", "Bu âdet çok eski."),
                TargetVocabulary("zhb1u4w2", "节日", "bayram", "ifade", "节日有三天。", "Bayram üç gün sürüyor."),
                TargetVocabulary("zhb1u4w3", "庆祝", "kutlamak", "ifade", "我们一起庆祝。", "Birlikte kutluyoruz."),
                TargetVocabulary("zhb1u4w4", "传统", "gelenek", "ifade", "传统继续存在。", "Gelenek varlığını sürdürüyor."),
                TargetVocabulary("zhb1u4w5", "社会", "toplum", "ifade", "社会变化很快。", "Toplum hızla değişiyor."))),
            LearningLesson("ZH-B1-U4-L2", "Kültür ve Gelenekler — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这个___很古老。", "", listOf("庆祝", "风俗", "节日"), listOf("风俗"), "Doğru cümle: 这个风俗很古老。 — Bu âdet çok eski.", null, null),
                LearningExercise("zhb1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___继续存在。", "", listOf("传统", "社会", "风俗"), listOf("传统"), "Doğru cümle: 传统继续存在。 — Gelenek varlığını sürdürüyor.", null, null),
                LearningExercise("zhb1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu âdet çok eski.", "Birlikte kutluyoruz.", "Toplum hızla değişiyor."), listOf("Toplum hızla değişiyor."), "Söylenen cümle: 社会变化很快。", "社会变化很快。", null),
                LearningExercise("zhb1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "传统继续存在。", listOf("Gelenek varlığını sürdürüyor.", "Bayram üç gün sürüyor.", "Toplum hızla değişiyor."), listOf("Gelenek varlığını sürdürüyor."), "Cümlenin çevirisi: Gelenek varlığını sürdürüyor.", null, null))),
            LearningLesson("ZH-B1-U4-L3", "Kültür ve Gelenekler — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这个节日___五月庆祝。", "", listOf("在", "从", "到"), listOf("在"), "Zaman edatı: 在五月 (mayısta).", null, null),
                LearningExercise("zhb1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 节日有三天。", "", listOf(), listOf("节日有三天。"), "Türkçesi: Bayram üç gün sürüyor.", "节日有三天。", "节日有三天。"),
                LearningExercise("zhb1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kutlamak' ifadesinin Çince karşılığı hangisi?", "", listOf("社会", "庆祝", "风俗"), listOf("庆祝"), "Örnek: 我们一起庆祝。 — Birlikte kutluyoruz.", null, null))),
            LearningLesson("ZH-B1-U4-L4", "Kültür ve Gelenekler — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb1u4e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Gelenek varlığını sürdürüyor.", "Bu âdet çok eski.", "Birlikte kutluyoruz."), listOf("Bu âdet çok eski."), "Söylenen cümle: 这个风俗很古老。", "这个风俗很古老。", null),
                LearningExercise("zhb1u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Gelenek varlığını sürdürüyor.", "Toplum hızla değişiyor.", "Bayram üç gün sürüyor."), listOf("Bayram üç gün sürüyor."), "Söylenen cümle: 节日有三天。", "节日有三天。", null),
                LearningExercise("zhb1u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'gelenek' ifadesinin Çince karşılığı hangisi?", "", listOf("传统", "节日", "社会"), listOf("传统"), "Örnek: 传统继续存在。 — Gelenek varlığını sürdürüyor.", null, null))),
            LearningLesson("ZH-B1-U4-L5", "Kültür ve Gelenekler — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb1u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "社会变化很快。", listOf("Gelenek varlığını sürdürüyor.", "Toplum hızla değişiyor.", "Bayram üç gün sürüyor."), listOf("Toplum hızla değişiyor."), "Cümlenin çevirisi: Toplum hızla değişiyor.", null, null),
                LearningExercise("zhb1u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "传统继续存在。", listOf("Gelenek varlığını sürdürüyor.", "Birlikte kutluyoruz.", "Toplum hızla değişiyor."), listOf("Gelenek varlığını sürdürüyor."), "Cümlenin çevirisi: Gelenek varlığını sürdürüyor.", null, null),
                LearningExercise("zhb1u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这个风俗很古老。", "", listOf(), listOf("这个风俗很古老。"), "Türkçesi: Bu âdet çok eski.", "这个风俗很古老。", "这个风俗很古老。"))))),
        LearningUnit("ZH-B1-U5", "Spor ve Sağlıklı Yaşam", "Sağlıklı yaşam alışkanlıklarını anlat.", listOf(
            LearningLesson("ZH-B1-U5-L1", "Spor ve Sağlıklı Yaşam — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'健康' ne anlama gelir?", "", listOf("egzersiz yapmak", "sağlık", "spor/hareket"), listOf("sağlık"), "健康最重要。 — Sağlık en önemlisi.", null, null),
                LearningExercise("zhb1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'运动' ne anlama gelir?", "", listOf("spor/hareket", "beslenme", "kaçınmak"), listOf("spor/hareket"), "每天运动很重要。 — Her gün spor yapmak önemli.", null, null),
                LearningExercise("zhb1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'饮食' ne anlama gelir?", "", listOf("egzersiz yapmak", "sağlık", "beslenme"), listOf("beslenme"), "健康的饮食很关键。 — Sağlıklı beslenme kilittir.", null, null)), listOf(
                TargetVocabulary("zhb1u5w1", "健康", "sağlık", "ifade", "健康最重要。", "Sağlık en önemlisi."),
                TargetVocabulary("zhb1u5w2", "运动", "spor/hareket", "ifade", "每天运动很重要。", "Her gün spor yapmak önemli."),
                TargetVocabulary("zhb1u5w3", "饮食", "beslenme", "ifade", "健康的饮食很关键。", "Sağlıklı beslenme kilittir."),
                TargetVocabulary("zhb1u5w4", "锻炼", "egzersiz yapmak", "ifade", "我每周锻炼三次。", "Haftada üç kez egzersiz yaparım."),
                TargetVocabulary("zhb1u5w5", "避免", "kaçınmak", "ifade", "我们应该避免吃太多糖。", "Fazla şekerden kaçınmalıyız."))),
            LearningLesson("ZH-B1-U5-L2", "Spor ve Sağlıklı Yaşam — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___最重要。", "", listOf("健康", "运动", "饮食"), listOf("健康"), "Doğru cümle: 健康最重要。 — Sağlık en önemlisi.", null, null),
                LearningExercise("zhb1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我每周___三次。", "", listOf("避免", "健康", "锻炼"), listOf("锻炼"), "Doğru cümle: 我每周锻炼三次。 — Haftada üç kez egzersiz yaparım.", null, null),
                LearningExercise("zhb1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sağlıklı beslenme kilittir.", "Fazla şekerden kaçınmalıyız.", "Sağlık en önemlisi."), listOf("Fazla şekerden kaçınmalıyız."), "Söylenen cümle: 我们应该避免吃太多糖。", "我们应该避免吃太多糖。", null),
                LearningExercise("zhb1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我每周锻炼三次。", listOf("Her gün spor yapmak önemli.", "Fazla şekerden kaçınmalıyız.", "Haftada üç kez egzersiz yaparım."), listOf("Haftada üç kez egzersiz yaparım."), "Cümlenin çevirisi: Haftada üç kez egzersiz yaparım.", null, null))),
            LearningLesson("ZH-B1-U5-L3", "Spor ve Sağlıklı Yaşam — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我们应该___吃太多糖。", "", listOf("避免", "锻炼", "运动"), listOf("避免"), "避免 + eylem: -den kaçınmak.", null, null),
                LearningExercise("zhb1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 每天运动很重要。", "", listOf(), listOf("每天运动很重要。"), "Türkçesi: Her gün spor yapmak önemli.", "每天运动很重要。", "每天运动很重要。"),
                LearningExercise("zhb1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'beslenme' ifadesinin Çince karşılığı hangisi?", "", listOf("饮食", "健康", "避免"), listOf("饮食"), "Örnek: 健康的饮食很关键。 — Sağlıklı beslenme kilittir.", null, null))),
            LearningLesson("ZH-B1-U5-L4", "Spor ve Sağlıklı Yaşam — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb1u5e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sağlık en önemlisi.", "Sağlıklı beslenme kilittir.", "Haftada üç kez egzersiz yaparım."), listOf("Sağlık en önemlisi."), "Söylenen cümle: 健康最重要。", "健康最重要。", null),
                LearningExercise("zhb1u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Fazla şekerden kaçınmalıyız.", "Her gün spor yapmak önemli.", "Haftada üç kez egzersiz yaparım."), listOf("Her gün spor yapmak önemli."), "Söylenen cümle: 每天运动很重要。", "每天运动很重要。", null),
                LearningExercise("zhb1u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'egzersiz yapmak' ifadesinin Çince karşılığı hangisi?", "", listOf("运动", "避免", "锻炼"), listOf("锻炼"), "Örnek: 我每周锻炼三次。 — Haftada üç kez egzersiz yaparım.", null, null))),
            LearningLesson("ZH-B1-U5-L5", "Spor ve Sağlıklı Yaşam — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb1u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们应该避免吃太多糖。", listOf("Fazla şekerden kaçınmalıyız.", "Her gün spor yapmak önemli.", "Haftada üç kez egzersiz yaparım."), listOf("Fazla şekerden kaçınmalıyız."), "Cümlenin çevirisi: Fazla şekerden kaçınmalıyız.", null, null),
                LearningExercise("zhb1u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我每周锻炼三次。", listOf("Sağlıklı beslenme kilittir.", "Fazla şekerden kaçınmalıyız.", "Haftada üç kez egzersiz yaparım."), listOf("Haftada üç kez egzersiz yaparım."), "Cümlenin çevirisi: Haftada üç kez egzersiz yaparım.", null, null),
                LearningExercise("zhb1u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 健康最重要。", "", listOf(), listOf("健康最重要。"), "Türkçesi: Sağlık en önemlisi.", "健康最重要。", "健康最重要。"))))),
        LearningUnit("ZH-B1-U6", "Görüş Bildirmek", "Fikrini gerekçeleriyle savun.", listOf(
            LearningLesson("ZH-B1-U6-L1", "Görüş Bildirmek — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'意见' ne anlama gelir?", "", listOf("görüş", "katılmak (fikre)", "sebep"), listOf("görüş"), "这是我的意见。 — Bu benim görüşüm.", null, null),
                LearningExercise("zhb1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'同意' ne anlama gelir?", "", listOf("karşı çıkmak", "ikna etmek", "katılmak (fikre)"), listOf("katılmak (fikre)"), "我同意他的看法。 — Onun görüşüne katılıyorum.", null, null),
                LearningExercise("zhb1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'反对' ne anlama gelir?", "", listOf("görüş", "karşı çıkmak", "sebep"), listOf("karşı çıkmak"), "我反对这个想法。 — Bu fikre karşıyım.", null, null)), listOf(
                TargetVocabulary("zhb1u6w1", "意见", "görüş", "ifade", "这是我的意见。", "Bu benim görüşüm."),
                TargetVocabulary("zhb1u6w2", "同意", "katılmak (fikre)", "ifade", "我同意他的看法。", "Onun görüşüne katılıyorum."),
                TargetVocabulary("zhb1u6w3", "反对", "karşı çıkmak", "ifade", "我反对这个想法。", "Bu fikre karşıyım."),
                TargetVocabulary("zhb1u6w4", "原因", "sebep", "ifade", "有一个好原因。", "İyi bir sebep var."),
                TargetVocabulary("zhb1u6w5", "说服", "ikna etmek", "ifade", "你说服不了我。", "Beni ikna edemezsin."))),
            LearningLesson("ZH-B1-U6-L2", "Görüş Bildirmek — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这是我的___。", "", listOf("同意", "反对", "意见"), listOf("意见"), "Doğru cümle: 这是我的意见。 — Bu benim görüşüm.", null, null),
                LearningExercise("zhb1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "有一个好___。", "", listOf("意见", "原因", "说服"), listOf("原因"), "Doğru cümle: 有一个好原因。 — İyi bir sebep var.", null, null),
                LearningExercise("zhb1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Beni ikna edemezsin.", "Bu benim görüşüm.", "Bu fikre karşıyım."), listOf("Beni ikna edemezsin."), "Söylenen cümle: 你说服不了我。", "你说服不了我。", null),
                LearningExercise("zhb1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "有一个好原因。", listOf("Beni ikna edemezsin.", "İyi bir sebep var.", "Onun görüşüne katılıyorum."), listOf("İyi bir sebep var."), "Cümlenin çevirisi: İyi bir sebep var.", null, null))),
            LearningLesson("ZH-B1-U6-L3", "Görüş Bildirmek — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我___他的看法。", "", listOf("同意", "反对", "原因"), listOf("同意"), "Fikre katılma: 同意...的看法.", null, null),
                LearningExercise("zhb1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我同意他的看法。", "", listOf(), listOf("我同意他的看法。"), "Türkçesi: Onun görüşüne katılıyorum.", "我同意他的看法。", "我同意他的看法。"),
                LearningExercise("zhb1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'karşı çıkmak' ifadesinin Çince karşılığı hangisi?", "", listOf("意见", "说服", "反对"), listOf("反对"), "Örnek: 我反对这个想法。 — Bu fikre karşıyım.", null, null))),
            LearningLesson("ZH-B1-U6-L4", "Görüş Bildirmek — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb1u6e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu fikre karşıyım.", "İyi bir sebep var.", "Bu benim görüşüm."), listOf("Bu benim görüşüm."), "Söylenen cümle: 这是我的意见。", "这是我的意见。", null),
                LearningExercise("zhb1u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Onun görüşüne katılıyorum.", "İyi bir sebep var.", "Beni ikna edemezsin."), listOf("Onun görüşüne katılıyorum."), "Söylenen cümle: 我同意他的看法。", "我同意他的看法。", null),
                LearningExercise("zhb1u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sebep' ifadesinin Çince karşılığı hangisi?", "", listOf("说服", "原因", "同意"), listOf("原因"), "Örnek: 有一个好原因。 — İyi bir sebep var.", null, null))),
            LearningLesson("ZH-B1-U6-L5", "Görüş Bildirmek — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb1u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "你说服不了我。", listOf("Onun görüşüne katılıyorum.", "İyi bir sebep var.", "Beni ikna edemezsin."), listOf("Beni ikna edemezsin."), "Cümlenin çevirisi: Beni ikna edemezsin.", null, null),
                LearningExercise("zhb1u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "有一个好原因。", listOf("Beni ikna edemezsin.", "İyi bir sebep var.", "Bu fikre karşıyım."), listOf("İyi bir sebep var."), "Cümlenin çevirisi: İyi bir sebep var.", null, null),
                LearningExercise("zhb1u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这是我的意见。", "", listOf(), listOf("这是我的意见。"), "Türkçesi: Bu benim görüşüm.", "这是我的意见。", "这是我的意见。"))))),
        LearningUnit("ZH-B2-U1", "Kariyer ve İş Dünyası", "İş görüşmesi ve kariyer dilinde ustalaş.", listOf(
            LearningLesson("ZH-B2-U1-L1", "Kariyer ve İş Dünyası — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'简历' ne anlama gelir?", "", listOf("mülakat", "sorumluluk", "özgeçmiş"), listOf("özgeçmiş"), "简历要简短。 — Özgeçmiş kısa olmalı.", null, null),
                LearningExercise("zhb2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'面试' ne anlama gelir?", "", listOf("meslek/kariyer", "mülakat", "işe alım"), listOf("mülakat"), "面试很顺利。 — Mülakat çok iyi geçti.", null, null),
                LearningExercise("zhb2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'招聘' ne anlama gelir?", "", listOf("işe alım", "sorumluluk", "özgeçmiş"), listOf("işe alım"), "公司在招聘新人。 — Şirket yeni eleman alıyor.", null, null)), listOf(
                TargetVocabulary("zhb2u1w1", "简历", "özgeçmiş", "ifade", "简历要简短。", "Özgeçmiş kısa olmalı."),
                TargetVocabulary("zhb2u1w2", "面试", "mülakat", "ifade", "面试很顺利。", "Mülakat çok iyi geçti."),
                TargetVocabulary("zhb2u1w3", "招聘", "işe alım", "ifade", "公司在招聘新人。", "Şirket yeni eleman alıyor."),
                TargetVocabulary("zhb2u1w4", "责任", "sorumluluk", "ifade", "我承担责任。", "Sorumluluğu üstleniyorum."),
                TargetVocabulary("zhb2u1w5", "职业", "meslek/kariyer", "ifade", "她的职业发展很快。", "Kariyeri hızla gelişiyor."))),
            LearningLesson("ZH-B2-U1-L2", "Kariyer ve İş Dünyası — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___要简短。", "", listOf("招聘", "简历", "面试"), listOf("简历"), "Doğru cümle: 简历要简短。 — Özgeçmiş kısa olmalı.", null, null),
                LearningExercise("zhb2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我承担___。", "", listOf("责任", "职业", "简历"), listOf("责任"), "Doğru cümle: 我承担责任。 — Sorumluluğu üstleniyorum.", null, null),
                LearningExercise("zhb2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Özgeçmiş kısa olmalı.", "Şirket yeni eleman alıyor.", "Kariyeri hızla gelişiyor."), listOf("Kariyeri hızla gelişiyor."), "Söylenen cümle: 她的职业发展很快。", "她的职业发展很快。", null),
                LearningExercise("zhb2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我承担责任。", listOf("Sorumluluğu üstleniyorum.", "Mülakat çok iyi geçti.", "Kariyeri hızla gelişiyor."), listOf("Sorumluluğu üstleniyorum."), "Cümlenin çevirisi: Sorumluluğu üstleniyorum.", null, null))),
            LearningLesson("ZH-B2-U1-L3", "Kariyer ve İş Dünyası — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "她___公司录用了。", "", listOf("被", "把", "给"), listOf("被"), "Edilgen çatı: 被...录用 (işe alındı).", null, null),
                LearningExercise("zhb2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 面试很顺利。", "", listOf(), listOf("面试很顺利。"), "Türkçesi: Mülakat çok iyi geçti.", "面试很顺利。", "面试很顺利。"),
                LearningExercise("zhb2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'işe alım' ifadesinin Çince karşılığı hangisi?", "", listOf("职业", "招聘", "简历"), listOf("招聘"), "Örnek: 公司在招聘新人。 — Şirket yeni eleman alıyor.", null, null))),
            LearningLesson("ZH-B2-U1-L4", "Kariyer ve İş Dünyası — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb2u1e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sorumluluğu üstleniyorum.", "Özgeçmiş kısa olmalı.", "Şirket yeni eleman alıyor."), listOf("Özgeçmiş kısa olmalı."), "Söylenen cümle: 简历要简短。", "简历要简短。", null),
                LearningExercise("zhb2u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sorumluluğu üstleniyorum.", "Kariyeri hızla gelişiyor.", "Mülakat çok iyi geçti."), listOf("Mülakat çok iyi geçti."), "Söylenen cümle: 面试很顺利。", "面试很顺利。", null),
                LearningExercise("zhb2u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sorumluluk' ifadesinin Çince karşılığı hangisi?", "", listOf("责任", "面试", "职业"), listOf("责任"), "Örnek: 我承担责任。 — Sorumluluğu üstleniyorum.", null, null))),
            LearningLesson("ZH-B2-U1-L5", "Kariyer ve İş Dünyası — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb2u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "她的职业发展很快。", listOf("Sorumluluğu üstleniyorum.", "Kariyeri hızla gelişiyor.", "Mülakat çok iyi geçti."), listOf("Kariyeri hızla gelişiyor."), "Cümlenin çevirisi: Kariyeri hızla gelişiyor.", null, null),
                LearningExercise("zhb2u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我承担责任。", listOf("Sorumluluğu üstleniyorum.", "Şirket yeni eleman alıyor.", "Kariyeri hızla gelişiyor."), listOf("Sorumluluğu üstleniyorum."), "Cümlenin çevirisi: Sorumluluğu üstleniyorum.", null, null),
                LearningExercise("zhb2u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 简历要简短。", "", listOf(), listOf("简历要简短。"), "Türkçesi: Özgeçmiş kısa olmalı.", "简历要简短。", "简历要简短。"))))),
        LearningUnit("ZH-B2-U2", "Çevre ve Sürdürülebilirlik", "Çevre sorunlarını tartış.", listOf(
            LearningLesson("ZH-B2-U2-L1", "Çevre ve Sürdürülebilirlik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'环境' ne anlama gelir?", "", listOf("çöp", "çevre", "iklim değişikliği"), listOf("çevre"), "我们必须保护环境。 — Çevreyi korumalıyız.", null, null),
                LearningExercise("zhb2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'气候变化' ne anlama gelir?", "", listOf("iklim değişikliği", "sürdürülebilir", "yenilenebilir"), listOf("iklim değişikliği"), "气候变化影响所有人。 — İklim değişikliği herkesi etkiliyor.", null, null),
                LearningExercise("zhb2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'可持续' ne anlama gelir?", "", listOf("çöp", "çevre", "sürdürülebilir"), listOf("sürdürülebilir"), "我们需要可持续的方案。 — Sürdürülebilir çözümlere ihtiyacımız var.", null, null)), listOf(
                TargetVocabulary("zhb2u2w1", "环境", "çevre", "ifade", "我们必须保护环境。", "Çevreyi korumalıyız."),
                TargetVocabulary("zhb2u2w2", "气候变化", "iklim değişikliği", "ifade", "气候变化影响所有人。", "İklim değişikliği herkesi etkiliyor."),
                TargetVocabulary("zhb2u2w3", "可持续", "sürdürülebilir", "ifade", "我们需要可持续的方案。", "Sürdürülebilir çözümlere ihtiyacımız var."),
                TargetVocabulary("zhb2u2w4", "垃圾", "çöp", "ifade", "垃圾要分类。", "Çöp ayrıştırılmalı."),
                TargetVocabulary("zhb2u2w5", "可再生", "yenilenebilir", "ifade", "可再生能源是未来。", "Yenilenebilir enerji gelecektir."))),
            LearningLesson("ZH-B2-U2-L2", "Çevre ve Sürdürülebilirlik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们必须保护___。", "", listOf("环境", "气候变化", "可持续"), listOf("环境"), "Doğru cümle: 我们必须保护环境。 — Çevreyi korumalıyız.", null, null),
                LearningExercise("zhb2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___要分类。", "", listOf("可再生", "环境", "垃圾"), listOf("垃圾"), "Doğru cümle: 垃圾要分类。 — Çöp ayrıştırılmalı.", null, null),
                LearningExercise("zhb2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sürdürülebilir çözümlere ihtiyacımız var.", "Yenilenebilir enerji gelecektir.", "Çevreyi korumalıyız."), listOf("Yenilenebilir enerji gelecektir."), "Söylenen cümle: 可再生能源是未来。", "可再生能源是未来。", null),
                LearningExercise("zhb2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "垃圾要分类。", listOf("İklim değişikliği herkesi etkiliyor.", "Yenilenebilir enerji gelecektir.", "Çöp ayrıştırılmalı."), listOf("Çöp ayrıştırılmalı."), "Cümlenin çevirisi: Çöp ayrıştırılmalı.", null, null))),
            LearningLesson("ZH-B2-U2-L3", "Çevre ve Sürdürülebilirlik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "垃圾越少，环境___好。", "", listOf("越", "更太", "最很"), listOf("越"), "Karşılaştırma: 越...越... (ne kadar...o kadar).", null, null),
                LearningExercise("zhb2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 气候变化影响所有人。", "", listOf(), listOf("气候变化影响所有人。"), "Türkçesi: İklim değişikliği herkesi etkiliyor.", "气候变化影响所有人。", "气候变化影响所有人。"),
                LearningExercise("zhb2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sürdürülebilir' ifadesinin Çince karşılığı hangisi?", "", listOf("可持续", "环境", "可再生"), listOf("可持续"), "Örnek: 我们需要可持续的方案。 — Sürdürülebilir çözümlere ihtiyacımız var.", null, null))),
            LearningLesson("ZH-B2-U2-L4", "Çevre ve Sürdürülebilirlik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb2u2e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çevreyi korumalıyız.", "Sürdürülebilir çözümlere ihtiyacımız var.", "Çöp ayrıştırılmalı."), listOf("Çevreyi korumalıyız."), "Söylenen cümle: 我们必须保护环境。", "我们必须保护环境。", null),
                LearningExercise("zhb2u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yenilenebilir enerji gelecektir.", "İklim değişikliği herkesi etkiliyor.", "Çöp ayrıştırılmalı."), listOf("İklim değişikliği herkesi etkiliyor."), "Söylenen cümle: 气候变化影响所有人。", "气候变化影响所有人。", null),
                LearningExercise("zhb2u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'çöp' ifadesinin Çince karşılığı hangisi?", "", listOf("气候变化", "可再生", "垃圾"), listOf("垃圾"), "Örnek: 垃圾要分类。 — Çöp ayrıştırılmalı.", null, null))),
            LearningLesson("ZH-B2-U2-L5", "Çevre ve Sürdürülebilirlik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb2u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "可再生能源是未来。", listOf("Yenilenebilir enerji gelecektir.", "İklim değişikliği herkesi etkiliyor.", "Çöp ayrıştırılmalı."), listOf("Yenilenebilir enerji gelecektir."), "Cümlenin çevirisi: Yenilenebilir enerji gelecektir.", null, null),
                LearningExercise("zhb2u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "垃圾要分类。", listOf("Sürdürülebilir çözümlere ihtiyacımız var.", "Yenilenebilir enerji gelecektir.", "Çöp ayrıştırılmalı."), listOf("Çöp ayrıştırılmalı."), "Cümlenin çevirisi: Çöp ayrıştırılmalı.", null, null),
                LearningExercise("zhb2u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我们必须保护环境。", "", listOf(), listOf("我们必须保护环境。"), "Türkçesi: Çevreyi korumalıyız.", "我们必须保护环境。", "我们必须保护环境。"))))),
        LearningUnit("ZH-B2-U3", "Bilim ve Yenilik", "Bilimsel gelişmeleri aktar.", listOf(
            LearningLesson("ZH-B2-U3-L1", "Bilim ve Yenilik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'研究' ne anlama gelir?", "", listOf("araştırma", "keşif", "kanıtlamak"), listOf("araştırma"), "研究在继续。 — Araştırma devam ediyor.", null, null),
                LearningExercise("zhb2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'发现' ne anlama gelir?", "", listOf("ilerleme", "sonuç", "keşif"), listOf("keşif"), "这是一个重要的发现。 — Bu önemli bir keşif.", null, null),
                LearningExercise("zhb2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'进步' ne anlama gelir?", "", listOf("araştırma", "ilerleme", "kanıtlamak"), listOf("ilerleme"), "进步很明显。 — İlerleme çok belirgin.", null, null)), listOf(
                TargetVocabulary("zhb2u3w1", "研究", "araştırma", "ifade", "研究在继续。", "Araştırma devam ediyor."),
                TargetVocabulary("zhb2u3w2", "发现", "keşif", "ifade", "这是一个重要的发现。", "Bu önemli bir keşif."),
                TargetVocabulary("zhb2u3w3", "进步", "ilerleme", "ifade", "进步很明显。", "İlerleme çok belirgin."),
                TargetVocabulary("zhb2u3w4", "证明", "kanıtlamak", "ifade", "数据可以证明这一点。", "Veriler bunu kanıtlayabilir."),
                TargetVocabulary("zhb2u3w5", "结果", "sonuç", "ifade", "结果让我们吃惊。", "Sonuç bizi şaşırtıyor."))),
            LearningLesson("ZH-B2-U3-L2", "Bilim ve Yenilik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___在继续。", "", listOf("发现", "进步", "研究"), listOf("研究"), "Doğru cümle: 研究在继续。 — Araştırma devam ediyor.", null, null),
                LearningExercise("zhb2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "数据可以___这一点。", "", listOf("研究", "证明", "结果"), listOf("证明"), "Doğru cümle: 数据可以证明这一点。 — Veriler bunu kanıtlayabilir.", null, null),
                LearningExercise("zhb2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sonuç bizi şaşırtıyor.", "Araştırma devam ediyor.", "İlerleme çok belirgin."), listOf("Sonuç bizi şaşırtıyor."), "Söylenen cümle: 结果让我们吃惊。", "结果让我们吃惊。", null),
                LearningExercise("zhb2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "数据可以证明这一点。", listOf("Sonuç bizi şaşırtıyor.", "Veriler bunu kanıtlayabilir.", "Bu önemli bir keşif."), listOf("Veriler bunu kanıtlayabilir."), "Cümlenin çevirisi: Veriler bunu kanıtlayabilir.", null, null))),
            LearningLesson("ZH-B2-U3-L3", "Bilim ve Yenilik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这个理论___证明了。", "", listOf("被", "把", "让"), listOf("被"), "Edilgen çatı: 被证明 (kanıtlandı).", null, null),
                LearningExercise("zhb2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这是一个重要的发现。", "", listOf(), listOf("这是一个重要的发现。"), "Türkçesi: Bu önemli bir keşif.", "这是一个重要的发现。", "这是一个重要的发现。"),
                LearningExercise("zhb2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ilerleme' ifadesinin Çince karşılığı hangisi?", "", listOf("研究", "结果", "进步"), listOf("进步"), "Örnek: 进步很明显。 — İlerleme çok belirgin.", null, null))),
            LearningLesson("ZH-B2-U3-L4", "Bilim ve Yenilik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb2u3e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("İlerleme çok belirgin.", "Veriler bunu kanıtlayabilir.", "Araştırma devam ediyor."), listOf("Araştırma devam ediyor."), "Söylenen cümle: 研究在继续。", "研究在继续。", null),
                LearningExercise("zhb2u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu önemli bir keşif.", "Veriler bunu kanıtlayabilir.", "Sonuç bizi şaşırtıyor."), listOf("Bu önemli bir keşif."), "Söylenen cümle: 这是一个重要的发现。", "这是一个重要的发现。", null),
                LearningExercise("zhb2u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kanıtlamak' ifadesinin Çince karşılığı hangisi?", "", listOf("结果", "证明", "发现"), listOf("证明"), "Örnek: 数据可以证明这一点。 — Veriler bunu kanıtlayabilir.", null, null))),
            LearningLesson("ZH-B2-U3-L5", "Bilim ve Yenilik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb2u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "结果让我们吃惊。", listOf("Bu önemli bir keşif.", "Veriler bunu kanıtlayabilir.", "Sonuç bizi şaşırtıyor."), listOf("Sonuç bizi şaşırtıyor."), "Cümlenin çevirisi: Sonuç bizi şaşırtıyor.", null, null),
                LearningExercise("zhb2u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "数据可以证明这一点。", listOf("Sonuç bizi şaşırtıyor.", "Veriler bunu kanıtlayabilir.", "İlerleme çok belirgin."), listOf("Veriler bunu kanıtlayabilir."), "Cümlenin çevirisi: Veriler bunu kanıtlayabilir.", null, null),
                LearningExercise("zhb2u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 研究在继续。", "", listOf(), listOf("研究在继续。"), "Türkçesi: Araştırma devam ediyor.", "研究在继续。", "研究在继续。"))))),
        LearningUnit("ZH-B2-U4", "Toplum ve Güncel Konular", "Toplumsal konularda görüş geliştir.", listOf(
            LearningLesson("ZH-B2-U4-L1", "Toplum ve Güncel Konular — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'公正' ne anlama gelir?", "", listOf("eşitlik", "yoksulluk", "adalet/hakkaniyet"), listOf("adalet/hakkaniyet"), "公正是基本价值。 — Hakkaniyet temel bir değerdir.", null, null),
                LearningExercise("zhb2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'平等' ne anlama gelir?", "", listOf("tartışma", "eşitlik", "vatandaş"), listOf("eşitlik"), "法律面前人人平等。 — Yasa önünde herkes eşittir.", null, null),
                LearningExercise("zhb2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'公民' ne anlama gelir?", "", listOf("vatandaş", "yoksulluk", "adalet/hakkaniyet"), listOf("vatandaş"), "每个公民都有权利。 — Her vatandaşın hakları vardır.", null, null)), listOf(
                TargetVocabulary("zhb2u4w1", "公正", "adalet/hakkaniyet", "ifade", "公正是基本价值。", "Hakkaniyet temel bir değerdir."),
                TargetVocabulary("zhb2u4w2", "平等", "eşitlik", "ifade", "法律面前人人平等。", "Yasa önünde herkes eşittir."),
                TargetVocabulary("zhb2u4w3", "公民", "vatandaş", "ifade", "每个公民都有权利。", "Her vatandaşın hakları vardır."),
                TargetVocabulary("zhb2u4w4", "贫困", "yoksulluk", "ifade", "我们要消除贫困。", "Yoksulluğu ortadan kaldırmalıyız."),
                TargetVocabulary("zhb2u4w5", "讨论", "tartışma", "ifade", "讨论还在继续。", "Tartışma hâlâ sürüyor."))),
            LearningLesson("ZH-B2-U4-L2", "Toplum ve Güncel Konular — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___是基本价值。", "", listOf("公民", "公正", "平等"), listOf("公正"), "Doğru cümle: 公正是基本价值。 — Hakkaniyet temel bir değerdir.", null, null),
                LearningExercise("zhb2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们要消除___。", "", listOf("贫困", "讨论", "公正"), listOf("贫困"), "Doğru cümle: 我们要消除贫困。 — Yoksulluğu ortadan kaldırmalıyız.", null, null),
                LearningExercise("zhb2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Hakkaniyet temel bir değerdir.", "Her vatandaşın hakları vardır.", "Tartışma hâlâ sürüyor."), listOf("Tartışma hâlâ sürüyor."), "Söylenen cümle: 讨论还在继续。", "讨论还在继续。", null),
                LearningExercise("zhb2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们要消除贫困。", listOf("Yoksulluğu ortadan kaldırmalıyız.", "Yasa önünde herkes eşittir.", "Tartışma hâlâ sürüyor."), listOf("Yoksulluğu ortadan kaldırmalıyız."), "Cümlenin çevirisi: Yoksulluğu ortadan kaldırmalıyız.", null, null))),
            LearningLesson("ZH-B2-U4-L3", "Toplum ve Güncel Konular — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___很难，我们还是继续。", "", listOf("虽然", "因为", "所以"), listOf("虽然"), "Zıtlık: 虽然...还是... (-e rağmen).", null, null),
                LearningExercise("zhb2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 法律面前人人平等。", "", listOf(), listOf("法律面前人人平等。"), "Türkçesi: Yasa önünde herkes eşittir.", "法律面前人人平等。", "法律面前人人平等。"),
                LearningExercise("zhb2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'vatandaş' ifadesinin Çince karşılığı hangisi?", "", listOf("讨论", "公民", "公正"), listOf("公民"), "Örnek: 每个公民都有权利。 — Her vatandaşın hakları vardır.", null, null))),
            LearningLesson("ZH-B2-U4-L4", "Toplum ve Güncel Konular — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb2u4e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yoksulluğu ortadan kaldırmalıyız.", "Hakkaniyet temel bir değerdir.", "Her vatandaşın hakları vardır."), listOf("Hakkaniyet temel bir değerdir."), "Söylenen cümle: 公正是基本价值。", "公正是基本价值。", null),
                LearningExercise("zhb2u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yoksulluğu ortadan kaldırmalıyız.", "Tartışma hâlâ sürüyor.", "Yasa önünde herkes eşittir."), listOf("Yasa önünde herkes eşittir."), "Söylenen cümle: 法律面前人人平等。", "法律面前人人平等。", null),
                LearningExercise("zhb2u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'yoksulluk' ifadesinin Çince karşılığı hangisi?", "", listOf("贫困", "平等", "讨论"), listOf("贫困"), "Örnek: 我们要消除贫困。 — Yoksulluğu ortadan kaldırmalıyız.", null, null))),
            LearningLesson("ZH-B2-U4-L5", "Toplum ve Güncel Konular — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb2u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "讨论还在继续。", listOf("Yoksulluğu ortadan kaldırmalıyız.", "Tartışma hâlâ sürüyor.", "Yasa önünde herkes eşittir."), listOf("Tartışma hâlâ sürüyor."), "Cümlenin çevirisi: Tartışma hâlâ sürüyor.", null, null),
                LearningExercise("zhb2u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们要消除贫困。", listOf("Yoksulluğu ortadan kaldırmalıyız.", "Her vatandaşın hakları vardır.", "Tartışma hâlâ sürüyor."), listOf("Yoksulluğu ortadan kaldırmalıyız."), "Cümlenin çevirisi: Yoksulluğu ortadan kaldırmalıyız.", null, null),
                LearningExercise("zhb2u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 公正是基本价值。", "", listOf(), listOf("公正是基本价值。"), "Türkçesi: Hakkaniyet temel bir değerdir.", "公正是基本价值。", "公正是基本价值。"))))),
        LearningUnit("ZH-B2-U5", "Sanat ve Edebiyat", "Sanat eserlerini yorumla.", listOf(
            LearningLesson("ZH-B2-U5-L1", "Sanat ve Edebiyat — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'画' ne anlama gelir?", "", listOf("derin etki bırakan", "tablo/resim", "roman"), listOf("tablo/resim"), "这幅画在博物馆里。 — Bu tablo müzede.", null, null),
                LearningExercise("zhb2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'小说' ne anlama gelir?", "", listOf("roman", "sergi", "yazar"), listOf("roman"), "这本小说有四百页。 — Bu roman dört yüz sayfa.", null, null),
                LearningExercise("zhb2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'展览' ne anlama gelir?", "", listOf("derin etki bırakan", "tablo/resim", "sergi"), listOf("sergi"), "展览明天开幕。 — Sergi yarın açılıyor.", null, null)), listOf(
                TargetVocabulary("zhb2u5w1", "画", "tablo/resim", "ifade", "这幅画在博物馆里。", "Bu tablo müzede."),
                TargetVocabulary("zhb2u5w2", "小说", "roman", "ifade", "这本小说有四百页。", "Bu roman dört yüz sayfa."),
                TargetVocabulary("zhb2u5w3", "展览", "sergi", "ifade", "展览明天开幕。", "Sergi yarın açılıyor."),
                TargetVocabulary("zhb2u5w4", "印象深刻", "derin etki bırakan", "ifade", "这部作品让人印象深刻。", "Bu eser insanda derin etki bırakıyor."),
                TargetVocabulary("zhb2u5w5", "作家", "yazar", "ifade", "作家今晚朗读。", "Yazar bu akşam okuma yapıyor."))),
            LearningLesson("ZH-B2-U5-L2", "Sanat ve Edebiyat — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这幅___在博物馆里。", "", listOf("画", "小说", "展览"), listOf("画"), "Doğru cümle: 这幅画在博物馆里。 — Bu tablo müzede.", null, null),
                LearningExercise("zhb2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这部作品让人___。", "", listOf("作家", "画", "印象深刻"), listOf("印象深刻"), "Doğru cümle: 这部作品让人印象深刻。 — Bu eser insanda derin etki bırakıyor.", null, null),
                LearningExercise("zhb2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sergi yarın açılıyor.", "Yazar bu akşam okuma yapıyor.", "Bu tablo müzede."), listOf("Yazar bu akşam okuma yapıyor."), "Söylenen cümle: 作家今晚朗读。", "作家今晚朗读。", null),
                LearningExercise("zhb2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这部作品让人印象深刻。", listOf("Bu roman dört yüz sayfa.", "Yazar bu akşam okuma yapıyor.", "Bu eser insanda derin etki bırakıyor."), listOf("Bu eser insanda derin etki bırakıyor."), "Cümlenin çevirisi: Bu eser insanda derin etki bırakıyor.", null, null))),
            LearningLesson("ZH-B2-U5-L3", "Sanat ve Edebiyat — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我正在看___那本小说很有意思。", "", listOf("的", "得", "地"), listOf("的"), "İlgi yapısı: 正在看的那本小说.", null, null),
                LearningExercise("zhb2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这本小说有四百页。", "", listOf(), listOf("这本小说有四百页。"), "Türkçesi: Bu roman dört yüz sayfa.", "这本小说有四百页。", "这本小说有四百页。"),
                LearningExercise("zhb2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'sergi' ifadesinin Çince karşılığı hangisi?", "", listOf("展览", "画", "作家"), listOf("展览"), "Örnek: 展览明天开幕。 — Sergi yarın açılıyor.", null, null))),
            LearningLesson("ZH-B2-U5-L4", "Sanat ve Edebiyat — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb2u5e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu tablo müzede.", "Sergi yarın açılıyor.", "Bu eser insanda derin etki bırakıyor."), listOf("Bu tablo müzede."), "Söylenen cümle: 这幅画在博物馆里。", "这幅画在博物馆里。", null),
                LearningExercise("zhb2u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yazar bu akşam okuma yapıyor.", "Bu roman dört yüz sayfa.", "Bu eser insanda derin etki bırakıyor."), listOf("Bu roman dört yüz sayfa."), "Söylenen cümle: 这本小说有四百页。", "这本小说有四百页。", null),
                LearningExercise("zhb2u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'derin etki bırakan' ifadesinin Çince karşılığı hangisi?", "", listOf("小说", "作家", "印象深刻"), listOf("印象深刻"), "Örnek: 这部作品让人印象深刻。 — Bu eser insanda derin etki bırakıyor.", null, null))),
            LearningLesson("ZH-B2-U5-L5", "Sanat ve Edebiyat — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb2u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "作家今晚朗读。", listOf("Yazar bu akşam okuma yapıyor.", "Bu roman dört yüz sayfa.", "Bu eser insanda derin etki bırakıyor."), listOf("Yazar bu akşam okuma yapıyor."), "Cümlenin çevirisi: Yazar bu akşam okuma yapıyor.", null, null),
                LearningExercise("zhb2u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这部作品让人印象深刻。", listOf("Sergi yarın açılıyor.", "Yazar bu akşam okuma yapıyor.", "Bu eser insanda derin etki bırakıyor."), listOf("Bu eser insanda derin etki bırakıyor."), "Cümlenin çevirisi: Bu eser insanda derin etki bırakıyor.", null, null),
                LearningExercise("zhb2u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这幅画在博物馆里。", "", listOf(), listOf("这幅画在博物馆里。"), "Türkçesi: Bu tablo müzede.", "这幅画在博物馆里。", "这幅画在博物馆里。"))))),
        LearningUnit("ZH-B2-U6", "Tartışma ve İkna", "Karşıt görüşleri dengeli biçimde tart.", listOf(
            LearningLesson("ZH-B2-U6-L1", "Tartışma ve İkna — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhb2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'论点' ne anlama gelir?", "", listOf("argüman", "bir yandan", "karşı çıkmak/çürütmek"), listOf("argüman"), "这个论点很有力。 — Bu argüman çok güçlü.", null, null),
                LearningExercise("zhb2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'一方面' ne anlama gelir?", "", listOf("öte yandan", "çıkarım/sonuç", "bir yandan"), listOf("bir yandan"), "一方面很贵。 — Bir yandan çok pahalı.", null, null),
                LearningExercise("zhb2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'另一方面' ne anlama gelir?", "", listOf("argüman", "öte yandan", "karşı çıkmak/çürütmek"), listOf("öte yandan"), "另一方面很有用。 — Öte yandan çok faydalı.", null, null)), listOf(
                TargetVocabulary("zhb2u6w1", "论点", "argüman", "ifade", "这个论点很有力。", "Bu argüman çok güçlü."),
                TargetVocabulary("zhb2u6w2", "一方面", "bir yandan", "ifade", "一方面很贵。", "Bir yandan çok pahalı."),
                TargetVocabulary("zhb2u6w3", "另一方面", "öte yandan", "ifade", "另一方面很有用。", "Öte yandan çok faydalı."),
                TargetVocabulary("zhb2u6w4", "反驳", "karşı çıkmak/çürütmek", "ifade", "我必须反驳这个说法。", "Bu iddiaya karşı çıkmak zorundayım."),
                TargetVocabulary("zhb2u6w5", "结论", "çıkarım/sonuç", "ifade", "结论很清楚。", "Çıkarım çok açık."))),
            LearningLesson("ZH-B2-U6-L2", "Tartışma ve İkna — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhb2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这个___很有力。", "", listOf("一方面", "另一方面", "论点"), listOf("论点"), "Doğru cümle: 这个论点很有力。 — Bu argüman çok güçlü.", null, null),
                LearningExercise("zhb2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我必须___这个说法。", "", listOf("论点", "反驳", "结论"), listOf("反驳"), "Doğru cümle: 我必须反驳这个说法。 — Bu iddiaya karşı çıkmak zorundayım.", null, null),
                LearningExercise("zhb2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çıkarım çok açık.", "Bu argüman çok güçlü.", "Öte yandan çok faydalı."), listOf("Çıkarım çok açık."), "Söylenen cümle: 结论很清楚。", "结论很清楚。", null),
                LearningExercise("zhb2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我必须反驳这个说法。", listOf("Çıkarım çok açık.", "Bu iddiaya karşı çıkmak zorundayım.", "Bir yandan çok pahalı."), listOf("Bu iddiaya karşı çıkmak zorundayım."), "Cümlenin çevirisi: Bu iddiaya karşı çıkmak zorundayım.", null, null))),
            LearningLesson("ZH-B2-U6-L3", "Tartışma ve İkna — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhb2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "一方面很贵，___很有用。", "", listOf("另一方面", "一方面", "另外面"), listOf("另一方面"), "Kalıp: 一方面...另一方面...", null, null),
                LearningExercise("zhb2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 一方面很贵。", "", listOf(), listOf("一方面很贵。"), "Türkçesi: Bir yandan çok pahalı.", "一方面很贵。", "一方面很贵。"),
                LearningExercise("zhb2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'öte yandan' ifadesinin Çince karşılığı hangisi?", "", listOf("论点", "结论", "另一方面"), listOf("另一方面"), "Örnek: 另一方面很有用。 — Öte yandan çok faydalı.", null, null))),
            LearningLesson("ZH-B2-U6-L4", "Tartışma ve İkna — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhb2u6e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Öte yandan çok faydalı.", "Bu iddiaya karşı çıkmak zorundayım.", "Bu argüman çok güçlü."), listOf("Bu argüman çok güçlü."), "Söylenen cümle: 这个论点很有力。", "这个论点很有力。", null),
                LearningExercise("zhb2u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bir yandan çok pahalı.", "Bu iddiaya karşı çıkmak zorundayım.", "Çıkarım çok açık."), listOf("Bir yandan çok pahalı."), "Söylenen cümle: 一方面很贵。", "一方面很贵。", null),
                LearningExercise("zhb2u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'karşı çıkmak/çürütmek' ifadesinin Çince karşılığı hangisi?", "", listOf("结论", "反驳", "一方面"), listOf("反驳"), "Örnek: 我必须反驳这个说法。 — Bu iddiaya karşı çıkmak zorundayım.", null, null))),
            LearningLesson("ZH-B2-U6-L5", "Tartışma ve İkna — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhb2u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "结论很清楚。", listOf("Bir yandan çok pahalı.", "Bu iddiaya karşı çıkmak zorundayım.", "Çıkarım çok açık."), listOf("Çıkarım çok açık."), "Cümlenin çevirisi: Çıkarım çok açık.", null, null),
                LearningExercise("zhb2u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我必须反驳这个说法。", listOf("Çıkarım çok açık.", "Bu iddiaya karşı çıkmak zorundayım.", "Öte yandan çok faydalı."), listOf("Bu iddiaya karşı çıkmak zorundayım."), "Cümlenin çevirisi: Bu iddiaya karşı çıkmak zorundayım.", null, null),
                LearningExercise("zhb2u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这个论点很有力。", "", listOf(), listOf("这个论点很有力。"), "Türkçesi: Bu argüman çok güçlü.", "这个论点很有力。", "这个论点很有力。"))))),
        LearningUnit("ZH-C1-U1", "Akademik Dil", "Akademik metinleri çözümle ve üret.", listOf(
            LearningLesson("ZH-C1-U1-L1", "Akademik Dil — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc1u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'论文' ne anlama gelir?", "", listOf("çözümleme", "kaynak", "makale/tez"), listOf("makale/tez"), "这篇论文有争议。 — Bu makale tartışmalı.", null, null),
                LearningExercise("zhc1u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'分析' ne anlama gelir?", "", listOf("yöntem", "çözümleme", "irdelemek"), listOf("çözümleme"), "分析覆盖十年的数据。 — Çözümleme on yıllık veriyi kapsıyor.", null, null),
                LearningExercise("zhc1u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'探讨' ne anlama gelir?", "", listOf("irdelemek", "kaynak", "makale/tez"), listOf("irdelemek"), "我们明天探讨这个问题。 — Bu soruyu yarın irdeleyeceğiz.", null, null)), listOf(
                TargetVocabulary("zhc1u1w1", "论文", "makale/tez", "ifade", "这篇论文有争议。", "Bu makale tartışmalı."),
                TargetVocabulary("zhc1u1w2", "分析", "çözümleme", "ifade", "分析覆盖十年的数据。", "Çözümleme on yıllık veriyi kapsıyor."),
                TargetVocabulary("zhc1u1w3", "探讨", "irdelemek", "ifade", "我们明天探讨这个问题。", "Bu soruyu yarın irdeleyeceğiz."),
                TargetVocabulary("zhc1u1w4", "来源", "kaynak", "ifade", "来源很可靠。", "Kaynak çok güvenilir."),
                TargetVocabulary("zhc1u1w5", "方法", "yöntem", "ifade", "这个方法很有前途。", "Bu yöntem umut verici."))),
            LearningLesson("ZH-C1-U1-L2", "Akademik Dil — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc1u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这篇___有争议。", "", listOf("探讨", "论文", "分析"), listOf("论文"), "Doğru cümle: 这篇论文有争议。 — Bu makale tartışmalı.", null, null),
                LearningExercise("zhc1u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___很可靠。", "", listOf("来源", "方法", "论文"), listOf("来源"), "Doğru cümle: 来源很可靠。 — Kaynak çok güvenilir.", null, null),
                LearningExercise("zhc1u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu makale tartışmalı.", "Bu soruyu yarın irdeleyeceğiz.", "Bu yöntem umut verici."), listOf("Bu yöntem umut verici."), "Söylenen cümle: 这个方法很有前途。", "这个方法很有前途。", null),
                LearningExercise("zhc1u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "来源很可靠。", listOf("Kaynak çok güvenilir.", "Çözümleme on yıllık veriyi kapsıyor.", "Bu yöntem umut verici."), listOf("Kaynak çok güvenilir."), "Cümlenin çevirisi: Kaynak çok güvenilir.", null, null))),
            LearningLesson("ZH-C1-U1-L3", "Akademik Dil — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc1u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___研究显示，数字在增长。", "", listOf("据", "靠", "凭着"), listOf("据"), "Akademik atıf: 据研究显示 (araştırmaya göre).", null, null),
                LearningExercise("zhc1u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 分析覆盖十年的数据。", "", listOf(), listOf("分析覆盖十年的数据。"), "Türkçesi: Çözümleme on yıllık veriyi kapsıyor.", "分析覆盖十年的数据。", "分析覆盖十年的数据。"),
                LearningExercise("zhc1u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'irdelemek' ifadesinin Çince karşılığı hangisi?", "", listOf("方法", "探讨", "论文"), listOf("探讨"), "Örnek: 我们明天探讨这个问题。 — Bu soruyu yarın irdeleyeceğiz.", null, null))),
            LearningLesson("ZH-C1-U1-L4", "Akademik Dil — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc1u1e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kaynak çok güvenilir.", "Bu makale tartışmalı.", "Bu soruyu yarın irdeleyeceğiz."), listOf("Bu makale tartışmalı."), "Söylenen cümle: 这篇论文有争议。", "这篇论文有争议。", null),
                LearningExercise("zhc1u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kaynak çok güvenilir.", "Bu yöntem umut verici.", "Çözümleme on yıllık veriyi kapsıyor."), listOf("Çözümleme on yıllık veriyi kapsıyor."), "Söylenen cümle: 分析覆盖十年的数据。", "分析覆盖十年的数据。", null),
                LearningExercise("zhc1u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kaynak' ifadesinin Çince karşılığı hangisi?", "", listOf("来源", "分析", "方法"), listOf("来源"), "Örnek: 来源很可靠。 — Kaynak çok güvenilir.", null, null))),
            LearningLesson("ZH-C1-U1-L5", "Akademik Dil — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc1u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个方法很有前途。", listOf("Kaynak çok güvenilir.", "Bu yöntem umut verici.", "Çözümleme on yıllık veriyi kapsıyor."), listOf("Bu yöntem umut verici."), "Cümlenin çevirisi: Bu yöntem umut verici.", null, null),
                LearningExercise("zhc1u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "来源很可靠。", listOf("Kaynak çok güvenilir.", "Bu soruyu yarın irdeleyeceğiz.", "Bu yöntem umut verici."), listOf("Kaynak çok güvenilir."), "Cümlenin çevirisi: Kaynak çok güvenilir.", null, null),
                LearningExercise("zhc1u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这篇论文有争议。", "", listOf(), listOf("这篇论文有争议。"), "Türkçesi: Bu makale tartışmalı.", "这篇论文有争议。", "这篇论文有争议。"))))),
        LearningUnit("ZH-C1-U2", "Soyut Kavramlar", "Soyut düşünceleri akıcı ifade et.", listOf(
            LearningLesson("ZH-C1-U2-L1", "Soyut Kavramlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc1u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'感知' ne anlama gelir?", "", listOf("düşünce/anlayış", "algı", "bilinç"), listOf("algı"), "我们的感知常常骗我们。 — Algımız bizi sık kandırır.", null, null),
                LearningExercise("zhc1u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'意识' ne anlama gelir?", "", listOf("bilinç", "kavram", "kavrayış/biliş"), listOf("bilinç"), "意识仍然是个谜。 — Bilinç hâlâ bir muamma.", null, null),
                LearningExercise("zhc1u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'概念' ne anlama gelir?", "", listOf("düşünce/anlayış", "algı", "kavram"), listOf("kavram"), "这个概念很难定义。 — Bu kavramı tanımlamak zor.", null, null)), listOf(
                TargetVocabulary("zhc1u2w1", "感知", "algı", "ifade", "我们的感知常常骗我们。", "Algımız bizi sık kandırır."),
                TargetVocabulary("zhc1u2w2", "意识", "bilinç", "ifade", "意识仍然是个谜。", "Bilinç hâlâ bir muamma."),
                TargetVocabulary("zhc1u2w3", "概念", "kavram", "ifade", "这个概念很难定义。", "Bu kavramı tanımlamak zor."),
                TargetVocabulary("zhc1u2w4", "观念", "düşünce/anlayış", "ifade", "这种观念很普遍。", "Bu anlayış çok yaygın."),
                TargetVocabulary("zhc1u2w5", "认知", "kavrayış/biliş", "ifade", "认知随经验而变化。", "Biliş deneyimle değişir."))),
            LearningLesson("ZH-C1-U2-L2", "Soyut Kavramlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc1u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "我们的___常常骗我们。", "", listOf("感知", "意识", "概念"), listOf("感知"), "Doğru cümle: 我们的感知常常骗我们。 — Algımız bizi sık kandırır.", null, null),
                LearningExercise("zhc1u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这种___很普遍。", "", listOf("认知", "感知", "观念"), listOf("观念"), "Doğru cümle: 这种观念很普遍。 — Bu anlayış çok yaygın.", null, null),
                LearningExercise("zhc1u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu kavramı tanımlamak zor.", "Biliş deneyimle değişir.", "Algımız bizi sık kandırır."), listOf("Biliş deneyimle değişir."), "Söylenen cümle: 认知随经验而变化。", "认知随经验而变化。", null),
                LearningExercise("zhc1u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这种观念很普遍。", listOf("Bilinç hâlâ bir muamma.", "Biliş deneyimle değişir.", "Bu anlayış çok yaygın."), listOf("Bu anlayış çok yaygın."), "Cümlenin çevirisi: Bu anlayış çok yaygın.", null, null))),
            LearningLesson("ZH-C1-U2-L3", "Soyut Kavramlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc1u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "一切都取决___你怎么看。", "", listOf("于", "在", "从"), listOf("于"), "Kalıp: 取决于 (-e bağlı olmak).", null, null),
                LearningExercise("zhc1u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 意识仍然是个谜。", "", listOf(), listOf("意识仍然是个谜。"), "Türkçesi: Bilinç hâlâ bir muamma.", "意识仍然是个谜。", "意识仍然是个谜。"),
                LearningExercise("zhc1u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kavram' ifadesinin Çince karşılığı hangisi?", "", listOf("概念", "感知", "认知"), listOf("概念"), "Örnek: 这个概念很难定义。 — Bu kavramı tanımlamak zor.", null, null))),
            LearningLesson("ZH-C1-U2-L4", "Soyut Kavramlar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc1u2e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Algımız bizi sık kandırır.", "Bu kavramı tanımlamak zor.", "Bu anlayış çok yaygın."), listOf("Algımız bizi sık kandırır."), "Söylenen cümle: 我们的感知常常骗我们。", "我们的感知常常骗我们。", null),
                LearningExercise("zhc1u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Biliş deneyimle değişir.", "Bilinç hâlâ bir muamma.", "Bu anlayış çok yaygın."), listOf("Bilinç hâlâ bir muamma."), "Söylenen cümle: 意识仍然是个谜。", "意识仍然是个谜。", null),
                LearningExercise("zhc1u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'düşünce/anlayış' ifadesinin Çince karşılığı hangisi?", "", listOf("意识", "认知", "观念"), listOf("观念"), "Örnek: 这种观念很普遍。 — Bu anlayış çok yaygın.", null, null))),
            LearningLesson("ZH-C1-U2-L5", "Soyut Kavramlar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc1u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "认知随经验而变化。", listOf("Biliş deneyimle değişir.", "Bilinç hâlâ bir muamma.", "Bu anlayış çok yaygın."), listOf("Biliş deneyimle değişir."), "Cümlenin çevirisi: Biliş deneyimle değişir.", null, null),
                LearningExercise("zhc1u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这种观念很普遍。", listOf("Bu kavramı tanımlamak zor.", "Biliş deneyimle değişir.", "Bu anlayış çok yaygın."), listOf("Bu anlayış çok yaygın."), "Cümlenin çevirisi: Bu anlayış çok yaygın.", null, null),
                LearningExercise("zhc1u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 我们的感知常常骗我们。", "", listOf(), listOf("我们的感知常常骗我们。"), "Türkçesi: Algımız bizi sık kandırır.", "我们的感知常常骗我们。", "我们的感知常常骗我们。"))))),
        LearningUnit("ZH-C1-U3", "Deyimler ve Mecazlar", "Deyimleri doğal bağlamda kullan.", listOf(
            LearningLesson("ZH-C1-U3-L1", "Deyimler ve Mecazlar — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc1u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'一石二鸟' ne anlama gelir?", "", listOf("bir taşla iki kuş", "gereksiz ekleme yapmak", "boşa anlatmak"), listOf("bir taşla iki kuş"), "这样做一石二鸟。 — Böyle yapmak bir taşla iki kuş.", null, null),
                LearningExercise("zhc1u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'画蛇添足' ne anlama gelir?", "", listOf("kuyu dibindeki kurbağa", "iş işten geçmeden önlem almak", "gereksiz ekleme yapmak"), listOf("gereksiz ekleme yapmak"), "这段话是画蛇添足。 — Bu paragraf yılana ayak çizmek gibi.", null, null),
                LearningExercise("zhc1u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'井底之蛙' ne anlama gelir?", "", listOf("bir taşla iki kuş", "kuyu dibindeki kurbağa", "boşa anlatmak"), listOf("kuyu dibindeki kurbağa"), "别做井底之蛙。 — Kuyu dibindeki kurbağa olma.", null, null)), listOf(
                TargetVocabulary("zhc1u3w1", "一石二鸟", "bir taşla iki kuş", "ifade", "这样做一石二鸟。", "Böyle yapmak bir taşla iki kuş."),
                TargetVocabulary("zhc1u3w2", "画蛇添足", "gereksiz ekleme yapmak", "ifade", "这段话是画蛇添足。", "Bu paragraf yılana ayak çizmek gibi."),
                TargetVocabulary("zhc1u3w3", "井底之蛙", "kuyu dibindeki kurbağa", "ifade", "别做井底之蛙。", "Kuyu dibindeki kurbağa olma."),
                TargetVocabulary("zhc1u3w4", "对牛弹琴", "boşa anlatmak", "ifade", "跟他解释就是对牛弹琴。", "Ona anlatmak öküz önünde ut çalmak gibi."),
                TargetVocabulary("zhc1u3w5", "亡羊补牢", "iş işten geçmeden önlem almak", "ifade", "亡羊补牢，为时不晚。", "Koyun kaçtıktan sonra ağılı onarmak için geç değildir."))),
            LearningLesson("ZH-C1-U3-L2", "Deyimler ve Mecazlar — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc1u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这样做___。", "", listOf("画蛇添足", "井底之蛙", "一石二鸟"), listOf("一石二鸟"), "Doğru cümle: 这样做一石二鸟。 — Böyle yapmak bir taşla iki kuş.", null, null),
                LearningExercise("zhc1u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "跟他解释就是___。", "", listOf("一石二鸟", "对牛弹琴", "亡羊补牢"), listOf("对牛弹琴"), "Doğru cümle: 跟他解释就是对牛弹琴。 — Ona anlatmak öküz önünde ut çalmak gibi.", null, null),
                LearningExercise("zhc1u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Koyun kaçtıktan sonra ağılı onarmak için geç değildir.", "Böyle yapmak bir taşla iki kuş.", "Kuyu dibindeki kurbağa olma."), listOf("Koyun kaçtıktan sonra ağılı onarmak için geç değildir."), "Söylenen cümle: 亡羊补牢，为时不晚。", "亡羊补牢，为时不晚。", null),
                LearningExercise("zhc1u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "跟他解释就是对牛弹琴。", listOf("Koyun kaçtıktan sonra ağılı onarmak için geç değildir.", "Ona anlatmak öküz önünde ut çalmak gibi.", "Bu paragraf yılana ayak çizmek gibi."), listOf("Ona anlatmak öküz önünde ut çalmak gibi."), "Cümlenin çevirisi: Ona anlatmak öküz önünde ut çalmak gibi.", null, null))),
            LearningLesson("ZH-C1-U3-L3", "Deyimler ve Mecazlar — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc1u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "一___二鸟。", "", listOf("石", "块", "只"), listOf("石"), "Chengyu: 一石二鸟 (bir taşla iki kuş).", null, null),
                LearningExercise("zhc1u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这段话是画蛇添足。", "", listOf(), listOf("这段话是画蛇添足。"), "Türkçesi: Bu paragraf yılana ayak çizmek gibi.", "这段话是画蛇添足。", "这段话是画蛇添足。"),
                LearningExercise("zhc1u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kuyu dibindeki kurbağa' ifadesinin Çince karşılığı hangisi?", "", listOf("一石二鸟", "亡羊补牢", "井底之蛙"), listOf("井底之蛙"), "Örnek: 别做井底之蛙。 — Kuyu dibindeki kurbağa olma.", null, null))),
            LearningLesson("ZH-C1-U3-L4", "Deyimler ve Mecazlar — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc1u3e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Kuyu dibindeki kurbağa olma.", "Ona anlatmak öküz önünde ut çalmak gibi.", "Böyle yapmak bir taşla iki kuş."), listOf("Böyle yapmak bir taşla iki kuş."), "Söylenen cümle: 这样做一石二鸟。", "这样做一石二鸟。", null),
                LearningExercise("zhc1u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu paragraf yılana ayak çizmek gibi.", "Ona anlatmak öküz önünde ut çalmak gibi.", "Koyun kaçtıktan sonra ağılı onarmak için geç değildir."), listOf("Bu paragraf yılana ayak çizmek gibi."), "Söylenen cümle: 这段话是画蛇添足。", "这段话是画蛇添足。", null),
                LearningExercise("zhc1u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'boşa anlatmak' ifadesinin Çince karşılığı hangisi?", "", listOf("亡羊补牢", "对牛弹琴", "画蛇添足"), listOf("对牛弹琴"), "Örnek: 跟他解释就是对牛弹琴。 — Ona anlatmak öküz önünde ut çalmak gibi.", null, null))),
            LearningLesson("ZH-C1-U3-L5", "Deyimler ve Mecazlar — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc1u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "亡羊补牢，为时不晚。", listOf("Bu paragraf yılana ayak çizmek gibi.", "Ona anlatmak öküz önünde ut çalmak gibi.", "Koyun kaçtıktan sonra ağılı onarmak için geç değildir."), listOf("Koyun kaçtıktan sonra ağılı onarmak için geç değildir."), "Cümlenin çevirisi: Koyun kaçtıktan sonra ağılı onarmak için geç değildir.", null, null),
                LearningExercise("zhc1u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "跟他解释就是对牛弹琴。", listOf("Koyun kaçtıktan sonra ağılı onarmak için geç değildir.", "Ona anlatmak öküz önünde ut çalmak gibi.", "Kuyu dibindeki kurbağa olma."), listOf("Ona anlatmak öküz önünde ut çalmak gibi."), "Cümlenin çevirisi: Ona anlatmak öküz önünde ut çalmak gibi.", null, null),
                LearningExercise("zhc1u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这样做一石二鸟。", "", listOf(), listOf("这样做一石二鸟。"), "Türkçesi: Böyle yapmak bir taşla iki kuş.", "这样做一石二鸟。", "这样做一石二鸟。"))))),
        LearningUnit("ZH-C1-U4", "Resmî Yazışma", "Resmî mektup ve e-posta dilinde ustalaş.", listOf(
            LearningLesson("ZH-C1-U4-L1", "Resmî Yazışma — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc1u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'尊敬的' ne anlama gelir?", "", listOf("ek (dosya)", "saygılarımla", "sayın"), listOf("sayın"), "尊敬的王先生： — Sayın Bay Wang:", null, null),
                LearningExercise("zhc1u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'附件' ne anlama gelir?", "", listOf("işbu yazıyla", "ek (dosya)", "ilişkin"), listOf("ek (dosya)"), "简历请见附件。 — Özgeçmiş için eke bakınız.", null, null),
                LearningExercise("zhc1u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'关于' ne anlama gelir?", "", listOf("ilişkin", "saygılarımla", "sayın"), listOf("ilişkin"), "关于您的请求，我们稍后回复。 — Talebinize ilişkin daha sonra yanıt vereceğiz.", null, null)), listOf(
                TargetVocabulary("zhc1u4w1", "尊敬的", "sayın", "ifade", "尊敬的王先生：", "Sayın Bay Wang:"),
                TargetVocabulary("zhc1u4w2", "附件", "ek (dosya)", "ifade", "简历请见附件。", "Özgeçmiş için eke bakınız."),
                TargetVocabulary("zhc1u4w3", "关于", "ilişkin", "ifade", "关于您的请求，我们稍后回复。", "Talebinize ilişkin daha sonra yanıt vereceğiz."),
                TargetVocabulary("zhc1u4w4", "此致敬礼", "saygılarımla", "ifade", "此致敬礼！", "Saygılarımla!"),
                TargetVocabulary("zhc1u4w5", "特此", "işbu yazıyla", "ifade", "特此通知。", "İşbu yazıyla bildirilir."))),
            LearningLesson("ZH-C1-U4-L2", "Resmî Yazışma — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc1u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___王先生：", "", listOf("关于", "尊敬的", "附件"), listOf("尊敬的"), "Doğru cümle: 尊敬的王先生： — Sayın Bay Wang:", null, null),
                LearningExercise("zhc1u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___！", "", listOf("此致敬礼", "特此", "尊敬的"), listOf("此致敬礼"), "Doğru cümle: 此致敬礼！ — Saygılarımla!", null, null),
                LearningExercise("zhc1u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sayın Bay Wang:", "Talebinize ilişkin daha sonra yanıt vereceğiz.", "İşbu yazıyla bildirilir."), listOf("İşbu yazıyla bildirilir."), "Söylenen cümle: 特此通知。", "特此通知。", null),
                LearningExercise("zhc1u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "此致敬礼！", listOf("Saygılarımla!", "Özgeçmiş için eke bakınız.", "İşbu yazıyla bildirilir."), listOf("Saygılarımla!"), "Cümlenin çevirisi: Saygılarımla!", null, null))),
            LearningLesson("ZH-C1-U4-L3", "Resmî Yazışma — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc1u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "简历请见___。", "", listOf("附件", "关于", "特此"), listOf("附件"), "Resmî dil: 请见附件 (eke bakınız).", null, null),
                LearningExercise("zhc1u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 简历请见附件。", "", listOf(), listOf("简历请见附件。"), "Türkçesi: Özgeçmiş için eke bakınız.", "简历请见附件。", "简历请见附件。"),
                LearningExercise("zhc1u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ilişkin' ifadesinin Çince karşılığı hangisi?", "", listOf("特此", "关于", "尊敬的"), listOf("关于"), "Örnek: 关于您的请求，我们稍后回复。 — Talebinize ilişkin daha sonra yanıt vereceğiz.", null, null))),
            LearningLesson("ZH-C1-U4-L4", "Resmî Yazışma — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc1u4e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Saygılarımla!", "Sayın Bay Wang:", "Talebinize ilişkin daha sonra yanıt vereceğiz."), listOf("Sayın Bay Wang:"), "Söylenen cümle: 尊敬的王先生：", "尊敬的王先生：", null),
                LearningExercise("zhc1u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Saygılarımla!", "İşbu yazıyla bildirilir.", "Özgeçmiş için eke bakınız."), listOf("Özgeçmiş için eke bakınız."), "Söylenen cümle: 简历请见附件。", "简历请见附件。", null),
                LearningExercise("zhc1u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'saygılarımla' ifadesinin Çince karşılığı hangisi?", "", listOf("此致敬礼", "附件", "特此"), listOf("此致敬礼"), "Örnek: 此致敬礼！ — Saygılarımla!", null, null))),
            LearningLesson("ZH-C1-U4-L5", "Resmî Yazışma — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc1u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "特此通知。", listOf("Saygılarımla!", "İşbu yazıyla bildirilir.", "Özgeçmiş için eke bakınız."), listOf("İşbu yazıyla bildirilir."), "Cümlenin çevirisi: İşbu yazıyla bildirilir.", null, null),
                LearningExercise("zhc1u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "此致敬礼！", listOf("Saygılarımla!", "Talebinize ilişkin daha sonra yanıt vereceğiz.", "İşbu yazıyla bildirilir."), listOf("Saygılarımla!"), "Cümlenin çevirisi: Saygılarımla!", null, null),
                LearningExercise("zhc1u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 尊敬的王先生：", "", listOf(), listOf("尊敬的王先生："), "Türkçesi: Sayın Bay Wang:", "尊敬的王先生：", "尊敬的王先生："))))),
        LearningUnit("ZH-C1-U5", "Müzakere ve Diplomasi", "İncelikli müzakere dili kur.", listOf(
            LearningLesson("ZH-C1-U5-L1", "Müzakere ve Diplomasi — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc1u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'谈判' ne anlama gelir?", "", listOf("anlaşma", "müzakere", "uzlaşma"), listOf("müzakere"), "谈判进行了几个小时。 — Müzakere saatlerce sürdü.", null, null),
                LearningExercise("zhc1u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'妥协' ne anlama gelir?", "", listOf("uzlaşma", "taviz", "duruş/pozisyon"), listOf("uzlaşma"), "妥协是公平的。 — Uzlaşma adil.", null, null),
                LearningExercise("zhc1u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'让步' ne anlama gelir?", "", listOf("anlaşma", "müzakere", "taviz"), listOf("taviz"), "让步是必要的。 — Taviz gerekliydi.", null, null)), listOf(
                TargetVocabulary("zhc1u5w1", "谈判", "müzakere", "ifade", "谈判进行了几个小时。", "Müzakere saatlerce sürdü."),
                TargetVocabulary("zhc1u5w2", "妥协", "uzlaşma", "ifade", "妥协是公平的。", "Uzlaşma adil."),
                TargetVocabulary("zhc1u5w3", "让步", "taviz", "ifade", "让步是必要的。", "Taviz gerekliydi."),
                TargetVocabulary("zhc1u5w4", "协议", "anlaşma", "ifade", "协议签得很晚。", "Anlaşma geç imzalandı."),
                TargetVocabulary("zhc1u5w5", "立场", "duruş/pozisyon", "ifade", "我们的立场不变。", "Duruşumuz değişmiyor."))),
            LearningLesson("ZH-C1-U5-L2", "Müzakere ve Diplomasi — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc1u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___进行了几个小时。", "", listOf("谈判", "妥协", "让步"), listOf("谈判"), "Doğru cümle: 谈判进行了几个小时。 — Müzakere saatlerce sürdü.", null, null),
                LearningExercise("zhc1u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___签得很晚。", "", listOf("立场", "谈判", "协议"), listOf("协议"), "Doğru cümle: 协议签得很晚。 — Anlaşma geç imzalandı.", null, null),
                LearningExercise("zhc1u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Taviz gerekliydi.", "Duruşumuz değişmiyor.", "Müzakere saatlerce sürdü."), listOf("Duruşumuz değişmiyor."), "Söylenen cümle: 我们的立场不变。", "我们的立场不变。", null),
                LearningExercise("zhc1u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "协议签得很晚。", listOf("Uzlaşma adil.", "Duruşumuz değişmiyor.", "Anlaşma geç imzalandı."), listOf("Anlaşma geç imzalandı."), "Cümlenin çevirisi: Anlaşma geç imzalandı.", null, null))),
            LearningLesson("ZH-C1-U5-L3", "Müzakere ve Diplomasi — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc1u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "我们达成___协议。", "", listOf("了", "着", "过了"), listOf("了"), "Tamamlanma: 达成了协议 (anlaşmaya varıldı).", null, null),
                LearningExercise("zhc1u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 妥协是公平的。", "", listOf(), listOf("妥协是公平的。"), "Türkçesi: Uzlaşma adil.", "妥协是公平的。", "妥协是公平的。"),
                LearningExercise("zhc1u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'taviz' ifadesinin Çince karşılığı hangisi?", "", listOf("让步", "谈判", "立场"), listOf("让步"), "Örnek: 让步是必要的。 — Taviz gerekliydi.", null, null))),
            LearningLesson("ZH-C1-U5-L4", "Müzakere ve Diplomasi — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc1u5e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Müzakere saatlerce sürdü.", "Taviz gerekliydi.", "Anlaşma geç imzalandı."), listOf("Müzakere saatlerce sürdü."), "Söylenen cümle: 谈判进行了几个小时。", "谈判进行了几个小时。", null),
                LearningExercise("zhc1u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Duruşumuz değişmiyor.", "Uzlaşma adil.", "Anlaşma geç imzalandı."), listOf("Uzlaşma adil."), "Söylenen cümle: 妥协是公平的。", "妥协是公平的。", null),
                LearningExercise("zhc1u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'anlaşma' ifadesinin Çince karşılığı hangisi?", "", listOf("妥协", "立场", "协议"), listOf("协议"), "Örnek: 协议签得很晚。 — Anlaşma geç imzalandı.", null, null))),
            LearningLesson("ZH-C1-U5-L5", "Müzakere ve Diplomasi — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc1u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "我们的立场不变。", listOf("Duruşumuz değişmiyor.", "Uzlaşma adil.", "Anlaşma geç imzalandı."), listOf("Duruşumuz değişmiyor."), "Cümlenin çevirisi: Duruşumuz değişmiyor.", null, null),
                LearningExercise("zhc1u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "协议签得很晚。", listOf("Taviz gerekliydi.", "Duruşumuz değişmiyor.", "Anlaşma geç imzalandı."), listOf("Anlaşma geç imzalandı."), "Cümlenin çevirisi: Anlaşma geç imzalandı.", null, null),
                LearningExercise("zhc1u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 谈判进行了几个小时。", "", listOf(), listOf("谈判进行了几个小时。"), "Türkçesi: Müzakere saatlerce sürdü.", "谈判进行了几个小时。", "谈判进行了几个小时。"))))),
        LearningUnit("ZH-C1-U6", "İnce Anlam Farkları", "Yakın anlamlı ifadeleri ayırt et.", listOf(
            LearningLesson("ZH-C1-U6-L1", "İnce Anlam Farkları — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc1u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'显然' ne anlama gelir?", "", listOf("açıkça/besbelli", "söylenene göre", "titiz/ince"), listOf("açıkça/besbelli"), "显然他是对的。 — Besbelli o haklı.", null, null),
                LearningExercise("zhc1u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'据说' ne anlama gelir?", "", listOf("etkili", "sözde", "söylenene göre"), listOf("söylenene göre"), "据说他病了。 — Söylenene göre hastaymış.", null, null),
                LearningExercise("zhc1u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'有效' ne anlama gelir?", "", listOf("açıkça/besbelli", "etkili", "titiz/ince"), listOf("etkili"), "这个方法很有效。 — Bu yöntem çok etkili.", null, null)), listOf(
                TargetVocabulary("zhc1u6w1", "显然", "açıkça/besbelli", "ifade", "显然他是对的。", "Besbelli o haklı."),
                TargetVocabulary("zhc1u6w2", "据说", "söylenene göre", "ifade", "据说他病了。", "Söylenene göre hastaymış."),
                TargetVocabulary("zhc1u6w3", "有效", "etkili", "ifade", "这个方法很有效。", "Bu yöntem çok etkili."),
                TargetVocabulary("zhc1u6w4", "细致", "titiz/ince", "ifade", "他的工作很细致。", "İşi çok titiz."),
                TargetVocabulary("zhc1u6w5", "所谓", "sözde", "ifade", "一位所谓的专家发言了。", "Sözde bir uzman konuştu."))),
            LearningLesson("ZH-C1-U6-L2", "İnce Anlam Farkları — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc1u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___他是对的。", "", listOf("据说", "有效", "显然"), listOf("显然"), "Doğru cümle: 显然他是对的。 — Besbelli o haklı.", null, null),
                LearningExercise("zhc1u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "他的工作很___。", "", listOf("显然", "细致", "所谓"), listOf("细致"), "Doğru cümle: 他的工作很细致。 — İşi çok titiz.", null, null),
                LearningExercise("zhc1u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Sözde bir uzman konuştu.", "Besbelli o haklı.", "Bu yöntem çok etkili."), listOf("Sözde bir uzman konuştu."), "Söylenen cümle: 一位所谓的专家发言了。", "一位所谓的专家发言了。", null),
                LearningExercise("zhc1u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的工作很细致。", listOf("Sözde bir uzman konuştu.", "İşi çok titiz.", "Söylenene göre hastaymış."), listOf("İşi çok titiz."), "Cümlenin çevirisi: İşi çok titiz.", null, null))),
            LearningLesson("ZH-C1-U6-L3", "İnce Anlam Farkları — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc1u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___他是对的——证据很清楚。", "", listOf("显然", "据说", "所谓"), listOf("显然"), "显然: kanıtların desteklediği kesinlik.", null, null),
                LearningExercise("zhc1u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 据说他病了。", "", listOf(), listOf("据说他病了。"), "Türkçesi: Söylenene göre hastaymış.", "据说他病了。", "据说他病了。"),
                LearningExercise("zhc1u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'etkili' ifadesinin Çince karşılığı hangisi?", "", listOf("显然", "所谓", "有效"), listOf("有效"), "Örnek: 这个方法很有效。 — Bu yöntem çok etkili.", null, null))),
            LearningLesson("ZH-C1-U6-L4", "İnce Anlam Farkları — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc1u6e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu yöntem çok etkili.", "İşi çok titiz.", "Besbelli o haklı."), listOf("Besbelli o haklı."), "Söylenen cümle: 显然他是对的。", "显然他是对的。", null),
                LearningExercise("zhc1u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Söylenene göre hastaymış.", "İşi çok titiz.", "Sözde bir uzman konuştu."), listOf("Söylenene göre hastaymış."), "Söylenen cümle: 据说他病了。", "据说他病了。", null),
                LearningExercise("zhc1u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'titiz/ince' ifadesinin Çince karşılığı hangisi?", "", listOf("所谓", "细致", "据说"), listOf("细致"), "Örnek: 他的工作很细致。 — İşi çok titiz.", null, null))),
            LearningLesson("ZH-C1-U6-L5", "İnce Anlam Farkları — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc1u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "一位所谓的专家发言了。", listOf("Söylenene göre hastaymış.", "İşi çok titiz.", "Sözde bir uzman konuştu."), listOf("Sözde bir uzman konuştu."), "Cümlenin çevirisi: Sözde bir uzman konuştu.", null, null),
                LearningExercise("zhc1u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的工作很细致。", listOf("Sözde bir uzman konuştu.", "İşi çok titiz.", "Bu yöntem çok etkili."), listOf("İşi çok titiz."), "Cümlenin çevirisi: İşi çok titiz.", null, null),
                LearningExercise("zhc1u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 显然他是对的。", "", listOf(), listOf("显然他是对的。"), "Türkçesi: Besbelli o haklı.", "显然他是对的。", "显然他是对的。"))))),
        LearningUnit("ZH-C2-U1", "Üslup ve İncelik", "Üslubu bağlama göre ustaca ayarla.", listOf(
            LearningLesson("ZH-C2-U1-L1", "Üslup ve İncelik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc2u1e1", Skill.VOCABULARY, "Doğru anlamı seç", "'微妙' ne anlama gelir?", "", listOf("ses tonu/eda", "özlü", "incelikli/nazik"), listOf("incelikli/nazik"), "语言的微妙之处很难掌握。 — Dilin incelikli yanlarını kavramak zor.", null, null),
                LearningExercise("zhc2u1e2", Skill.VOCABULARY, "Doğru anlamı seç", "'语气' ne anlama gelir?", "", listOf("ince işlenmiş", "ses tonu/eda", "ima"), listOf("ses tonu/eda"), "他的语气有点讽刺。 — Edası biraz alaycıydı.", null, null),
                LearningExercise("zhc2u1e3", Skill.VOCABULARY, "Doğru anlamı seç", "'暗示' ne anlama gelir?", "", listOf("ima", "özlü", "incelikli/nazik"), listOf("ima"), "只有她听懂了那个暗示。 — İmayı yalnızca o anladı.", null, null)), listOf(
                TargetVocabulary("zhc2u1w1", "微妙", "incelikli/nazik", "ifade", "语言的微妙之处很难掌握。", "Dilin incelikli yanlarını kavramak zor."),
                TargetVocabulary("zhc2u1w2", "语气", "ses tonu/eda", "ifade", "他的语气有点讽刺。", "Edası biraz alaycıydı."),
                TargetVocabulary("zhc2u1w3", "暗示", "ima", "ifade", "只有她听懂了那个暗示。", "İmayı yalnızca o anladı."),
                TargetVocabulary("zhc2u1w4", "简洁", "özlü", "ifade", "他的回答很简洁。", "Yanıtı çok özlüydü."),
                TargetVocabulary("zhc2u1w5", "细腻", "ince işlenmiş", "ifade", "他的描写非常细腻。", "Betimlemesi son derece ince."))),
            LearningLesson("ZH-C2-U1-L2", "Üslup ve İncelik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc2u1e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "语言的___之处很难掌握。", "", listOf("暗示", "微妙", "语气"), listOf("微妙"), "Doğru cümle: 语言的微妙之处很难掌握。 — Dilin incelikli yanlarını kavramak zor.", null, null),
                LearningExercise("zhc2u1e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "他的回答很___。", "", listOf("简洁", "细腻", "微妙"), listOf("简洁"), "Doğru cümle: 他的回答很简洁。 — Yanıtı çok özlüydü.", null, null),
                LearningExercise("zhc2u1e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dilin incelikli yanlarını kavramak zor.", "İmayı yalnızca o anladı.", "Betimlemesi son derece ince."), listOf("Betimlemesi son derece ince."), "Söylenen cümle: 他的描写非常细腻。", "他的描写非常细腻。", null),
                LearningExercise("zhc2u1e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的回答很简洁。", listOf("Yanıtı çok özlüydü.", "Edası biraz alaycıydı.", "Betimlemesi son derece ince."), listOf("Yanıtı çok özlüydü."), "Cümlenin çevirisi: Yanıtı çok özlüydü.", null, null))),
            LearningLesson("ZH-C2-U1-L3", "Üslup ve İncelik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc2u1e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "他的演讲简短而___。", "", listOf("简洁", "简单了", "简直"), listOf("简洁"), "Kalıp: 简短而简洁 (kısa ve özlü).", null, null),
                LearningExercise("zhc2u1e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 他的语气有点讽刺。", "", listOf(), listOf("他的语气有点讽刺。"), "Türkçesi: Edası biraz alaycıydı.", "他的语气有点讽刺。", "他的语气有点讽刺。"),
                LearningExercise("zhc2u1e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ima' ifadesinin Çince karşılığı hangisi?", "", listOf("细腻", "暗示", "微妙"), listOf("暗示"), "Örnek: 只有她听懂了那个暗示。 — İmayı yalnızca o anladı.", null, null))),
            LearningLesson("ZH-C2-U1-L4", "Üslup ve İncelik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc2u1e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yanıtı çok özlüydü.", "Dilin incelikli yanlarını kavramak zor.", "İmayı yalnızca o anladı."), listOf("Dilin incelikli yanlarını kavramak zor."), "Söylenen cümle: 语言的微妙之处很难掌握。", "语言的微妙之处很难掌握。", null),
                LearningExercise("zhc2u1e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yanıtı çok özlüydü.", "Betimlemesi son derece ince.", "Edası biraz alaycıydı."), listOf("Edası biraz alaycıydı."), "Söylenen cümle: 他的语气有点讽刺。", "他的语气有点讽刺。", null),
                LearningExercise("zhc2u1e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'özlü' ifadesinin Çince karşılığı hangisi?", "", listOf("简洁", "语气", "细腻"), listOf("简洁"), "Örnek: 他的回答很简洁。 — Yanıtı çok özlüydü.", null, null))),
            LearningLesson("ZH-C2-U1-L5", "Üslup ve İncelik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc2u1e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的描写非常细腻。", listOf("Yanıtı çok özlüydü.", "Betimlemesi son derece ince.", "Edası biraz alaycıydı."), listOf("Betimlemesi son derece ince."), "Cümlenin çevirisi: Betimlemesi son derece ince.", null, null),
                LearningExercise("zhc2u1e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的回答很简洁。", listOf("Yanıtı çok özlüydü.", "İmayı yalnızca o anladı.", "Betimlemesi son derece ince."), listOf("Yanıtı çok özlüydü."), "Cümlenin çevirisi: Yanıtı çok özlüydü.", null, null),
                LearningExercise("zhc2u1e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 语言的微妙之处很难掌握。", "", listOf(), listOf("语言的微妙之处很难掌握。"), "Türkçesi: Dilin incelikli yanlarını kavramak zor.", "语言的微妙之处很难掌握。", "语言的微妙之处很难掌握。"))))),
        LearningUnit("ZH-C2-U2", "Edebî Dil", "Edebî metinlerin katmanlarını çözümle.", listOf(
            LearningLesson("ZH-C2-U2-L1", "Edebî Dil — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc2u2e1", Skill.VOCABULARY, "Doğru anlamı seç", "'隐喻' ne anlama gelir?", "", listOf("lirik", "metafor", "simge"), listOf("metafor"), "隐喻贯穿全文。 — Metafor bütün metni kat ediyor.", null, null),
                LearningExercise("zhc2u2e2", Skill.VOCABULARY, "Doğru anlamı seç", "'象征' ne anlama gelir?", "", listOf("simge", "anlatı", "hiciv/ironi"), listOf("simge"), "大海是自由的象征。 — Deniz özgürlüğün simgesidir.", null, null),
                LearningExercise("zhc2u2e3", Skill.VOCABULARY, "Doğru anlamı seç", "'叙事' ne anlama gelir?", "", listOf("lirik", "metafor", "anlatı"), listOf("anlatı"), "叙事视角不断变化。 — Anlatı perspektifi durmadan değişiyor.", null, null)), listOf(
                TargetVocabulary("zhc2u2w1", "隐喻", "metafor", "ifade", "隐喻贯穿全文。", "Metafor bütün metni kat ediyor."),
                TargetVocabulary("zhc2u2w2", "象征", "simge", "ifade", "大海是自由的象征。", "Deniz özgürlüğün simgesidir."),
                TargetVocabulary("zhc2u2w3", "叙事", "anlatı", "ifade", "叙事视角不断变化。", "Anlatı perspektifi durmadan değişiyor."),
                TargetVocabulary("zhc2u2w4", "抒情", "lirik", "ifade", "文风非常抒情。", "Üslup son derece lirik."),
                TargetVocabulary("zhc2u2w5", "讽刺", "hiciv/ironi", "ifade", "文中的讽刺很明显。", "Metindeki ironi çok belirgin."))),
            LearningLesson("ZH-C2-U2-L2", "Edebî Dil — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc2u2e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___贯穿全文。", "", listOf("隐喻", "象征", "叙事"), listOf("隐喻"), "Doğru cümle: 隐喻贯穿全文。 — Metafor bütün metni kat ediyor.", null, null),
                LearningExercise("zhc2u2e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "文风非常___。", "", listOf("讽刺", "隐喻", "抒情"), listOf("抒情"), "Doğru cümle: 文风非常抒情。 — Üslup son derece lirik.", null, null),
                LearningExercise("zhc2u2e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Anlatı perspektifi durmadan değişiyor.", "Metindeki ironi çok belirgin.", "Metafor bütün metni kat ediyor."), listOf("Metindeki ironi çok belirgin."), "Söylenen cümle: 文中的讽刺很明显。", "文中的讽刺很明显。", null),
                LearningExercise("zhc2u2e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文风非常抒情。", listOf("Deniz özgürlüğün simgesidir.", "Metindeki ironi çok belirgin.", "Üslup son derece lirik."), listOf("Üslup son derece lirik."), "Cümlenin çevirisi: Üslup son derece lirik.", null, null))),
            LearningLesson("ZH-C2-U2-L3", "Edebî Dil — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc2u2e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这段文字的___很明显。", "", listOf("讽刺", "象征着", "叙事了"), listOf("讽刺"), "İsim kullanımı: 文字的讽刺 (metnin ironisi).", null, null),
                LearningExercise("zhc2u2e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 大海是自由的象征。", "", listOf(), listOf("大海是自由的象征。"), "Türkçesi: Deniz özgürlüğün simgesidir.", "大海是自由的象征。", "大海是自由的象征。"),
                LearningExercise("zhc2u2e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'anlatı' ifadesinin Çince karşılığı hangisi?", "", listOf("叙事", "隐喻", "讽刺"), listOf("叙事"), "Örnek: 叙事视角不断变化。 — Anlatı perspektifi durmadan değişiyor.", null, null))),
            LearningLesson("ZH-C2-U2-L4", "Edebî Dil — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc2u2e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Metafor bütün metni kat ediyor.", "Anlatı perspektifi durmadan değişiyor.", "Üslup son derece lirik."), listOf("Metafor bütün metni kat ediyor."), "Söylenen cümle: 隐喻贯穿全文。", "隐喻贯穿全文。", null),
                LearningExercise("zhc2u2e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Metindeki ironi çok belirgin.", "Deniz özgürlüğün simgesidir.", "Üslup son derece lirik."), listOf("Deniz özgürlüğün simgesidir."), "Söylenen cümle: 大海是自由的象征。", "大海是自由的象征。", null),
                LearningExercise("zhc2u2e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'lirik' ifadesinin Çince karşılığı hangisi?", "", listOf("象征", "讽刺", "抒情"), listOf("抒情"), "Örnek: 文风非常抒情。 — Üslup son derece lirik.", null, null))),
            LearningLesson("ZH-C2-U2-L5", "Edebî Dil — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc2u2e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文中的讽刺很明显。", listOf("Metindeki ironi çok belirgin.", "Deniz özgürlüğün simgesidir.", "Üslup son derece lirik."), listOf("Metindeki ironi çok belirgin."), "Cümlenin çevirisi: Metindeki ironi çok belirgin.", null, null),
                LearningExercise("zhc2u2e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文风非常抒情。", listOf("Anlatı perspektifi durmadan değişiyor.", "Metindeki ironi çok belirgin.", "Üslup son derece lirik."), listOf("Üslup son derece lirik."), "Cümlenin çevirisi: Üslup son derece lirik.", null, null),
                LearningExercise("zhc2u2e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 隐喻贯穿全文。", "", listOf(), listOf("隐喻贯穿全文。"), "Türkçesi: Metafor bütün metni kat ediyor.", "隐喻贯穿全文。", "隐喻贯穿全文。"))))),
        LearningUnit("ZH-C2-U3", "Uzmanlık Söylemi", "Uzmanlık alanı söylemine hâkim ol.", listOf(
            LearningLesson("ZH-C2-U3-L1", "Uzmanlık Söylemi — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc2u3e1", Skill.VOCABULARY, "Doğru anlamı seç", "'术语' ne anlama gelir?", "", listOf("terim", "söylem/metin", "güçlü/sağlam"), listOf("terim"), "术语必须准确。 — Terimler kesin olmalı.", null, null),
                LearningExercise("zhc2u3e2", Skill.VOCABULARY, "Doğru anlamı seç", "'语篇' ne anlama gelir?", "", listOf("bilimsel eser", "ayırt etmek", "söylem/metin"), listOf("söylem/metin"), "学术语篇有自己的规范。 — Akademik söylemin kendi normları vardır.", null, null),
                LearningExercise("zhc2u3e3", Skill.VOCABULARY, "Doğru anlamı seç", "'论著' ne anlama gelir?", "", listOf("terim", "bilimsel eser", "güçlü/sağlam"), listOf("bilimsel eser"), "这部论著分三卷。 — Bu eser üç ciltten oluşuyor.", null, null)), listOf(
                TargetVocabulary("zhc2u3w1", "术语", "terim", "ifade", "术语必须准确。", "Terimler kesin olmalı."),
                TargetVocabulary("zhc2u3w2", "语篇", "söylem/metin", "ifade", "学术语篇有自己的规范。", "Akademik söylemin kendi normları vardır."),
                TargetVocabulary("zhc2u3w3", "论著", "bilimsel eser", "ifade", "这部论著分三卷。", "Bu eser üç ciltten oluşuyor."),
                TargetVocabulary("zhc2u3w4", "有力", "güçlü/sağlam", "ifade", "这个论证很有力。", "Bu kanıtlama çok güçlü."),
                TargetVocabulary("zhc2u3w5", "区分", "ayırt etmek", "ifade", "必须区分这两个概念。", "Bu iki kavramı ayırt etmek şart."))),
            LearningLesson("ZH-C2-U3-L2", "Uzmanlık Söylemi — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc2u3e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "___必须准确。", "", listOf("语篇", "论著", "术语"), listOf("术语"), "Doğru cümle: 术语必须准确。 — Terimler kesin olmalı.", null, null),
                LearningExercise("zhc2u3e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这个论证很___。", "", listOf("术语", "有力", "区分"), listOf("有力"), "Doğru cümle: 这个论证很有力。 — Bu kanıtlama çok güçlü.", null, null),
                LearningExercise("zhc2u3e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu iki kavramı ayırt etmek şart.", "Terimler kesin olmalı.", "Bu eser üç ciltten oluşuyor."), listOf("Bu iki kavramı ayırt etmek şart."), "Söylenen cümle: 必须区分这两个概念。", "必须区分这两个概念。", null),
                LearningExercise("zhc2u3e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个论证很有力。", listOf("Bu iki kavramı ayırt etmek şart.", "Bu kanıtlama çok güçlü.", "Akademik söylemin kendi normları vardır."), listOf("Bu kanıtlama çok güçlü."), "Cümlenin çevirisi: Bu kanıtlama çok güçlü.", null, null))),
            LearningLesson("ZH-C2-U3-L3", "Uzmanlık Söylemi — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc2u3e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "___的论证连批评者也能说服。", "", listOf("有力", "有力量的了", "用力"), listOf("有力"), "Sıfat: 有力的论证 (güçlü kanıtlama).", null, null),
                LearningExercise("zhc2u3e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 学术语篇有自己的规范。", "", listOf(), listOf("学术语篇有自己的规范。"), "Türkçesi: Akademik söylemin kendi normları vardır.", "学术语篇有自己的规范。", "学术语篇有自己的规范。"),
                LearningExercise("zhc2u3e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'bilimsel eser' ifadesinin Çince karşılığı hangisi?", "", listOf("术语", "区分", "论著"), listOf("论著"), "Örnek: 这部论著分三卷。 — Bu eser üç ciltten oluşuyor.", null, null))),
            LearningLesson("ZH-C2-U3-L4", "Uzmanlık Söylemi — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc2u3e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu eser üç ciltten oluşuyor.", "Bu kanıtlama çok güçlü.", "Terimler kesin olmalı."), listOf("Terimler kesin olmalı."), "Söylenen cümle: 术语必须准确。", "术语必须准确。", null),
                LearningExercise("zhc2u3e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Akademik söylemin kendi normları vardır.", "Bu kanıtlama çok güçlü.", "Bu iki kavramı ayırt etmek şart."), listOf("Akademik söylemin kendi normları vardır."), "Söylenen cümle: 学术语篇有自己的规范。", "学术语篇有自己的规范。", null),
                LearningExercise("zhc2u3e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'güçlü/sağlam' ifadesinin Çince karşılığı hangisi?", "", listOf("区分", "有力", "语篇"), listOf("有力"), "Örnek: 这个论证很有力。 — Bu kanıtlama çok güçlü.", null, null))),
            LearningLesson("ZH-C2-U3-L5", "Uzmanlık Söylemi — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc2u3e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "必须区分这两个概念。", listOf("Akademik söylemin kendi normları vardır.", "Bu kanıtlama çok güçlü.", "Bu iki kavramı ayırt etmek şart."), listOf("Bu iki kavramı ayırt etmek şart."), "Cümlenin çevirisi: Bu iki kavramı ayırt etmek şart.", null, null),
                LearningExercise("zhc2u3e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个论证很有力。", listOf("Bu iki kavramı ayırt etmek şart.", "Bu kanıtlama çok güçlü.", "Bu eser üç ciltten oluşuyor."), listOf("Bu kanıtlama çok güçlü."), "Cümlenin çevirisi: Bu kanıtlama çok güçlü.", null, null),
                LearningExercise("zhc2u3e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 术语必须准确。", "", listOf(), listOf("术语必须准确。"), "Türkçesi: Terimler kesin olmalı.", "术语必须准确。", "术语必须准确。"))))),
        LearningUnit("ZH-C2-U4", "Kültürel Derinlik", "Kültürel referansları derinlemesine kavra.", listOf(
            LearningLesson("ZH-C2-U4-L1", "Kültürel Derinlik — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc2u4e1", Skill.VOCABULARY, "Doğru anlamı seç", "'世界观' ne anlama gelir?", "", listOf("zihniyet/ruh hali", "kökleşmiş", "dünya görüşü"), listOf("dünya görüşü"), "他的世界观被动摇了。 — Dünya görüşü sarsıldı.", null, null),
                LearningExercise("zhc2u4e2", Skill.VOCABULARY, "Doğru anlamı seç", "'心态' ne anlama gelir?", "", listOf("miras", "zihniyet/ruh hali", "zamanın ruhu"), listOf("zihniyet/ruh hali"), "各地心态不同。 — Zihniyet yerden yere değişir.", null, null),
                LearningExercise("zhc2u4e3", Skill.VOCABULARY, "Doğru anlamı seç", "'时代精神' ne anlama gelir?", "", listOf("zamanın ruhu", "kökleşmiş", "dünya görüşü"), listOf("zamanın ruhu"), "这部小说抓住了时代精神。 — Bu roman zamanın ruhunu yakalıyor.", null, null)), listOf(
                TargetVocabulary("zhc2u4w1", "世界观", "dünya görüşü", "ifade", "他的世界观被动摇了。", "Dünya görüşü sarsıldı."),
                TargetVocabulary("zhc2u4w2", "心态", "zihniyet/ruh hali", "ifade", "各地心态不同。", "Zihniyet yerden yere değişir."),
                TargetVocabulary("zhc2u4w3", "时代精神", "zamanın ruhu", "ifade", "这部小说抓住了时代精神。", "Bu roman zamanın ruhunu yakalıyor."),
                TargetVocabulary("zhc2u4w4", "根深蒂固", "kökleşmiş", "ifade", "这个传统根深蒂固。", "Bu gelenek kökleşmiş durumda."),
                TargetVocabulary("zhc2u4w5", "遗产", "miras", "ifade", "文化遗产受到保护。", "Kültürel miras korunuyor."))),
            LearningLesson("ZH-C2-U4-L2", "Kültürel Derinlik — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc2u4e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "他的___被动摇了。", "", listOf("时代精神", "世界观", "心态"), listOf("世界观"), "Doğru cümle: 他的世界观被动摇了。 — Dünya görüşü sarsıldı.", null, null),
                LearningExercise("zhc2u4e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "这个传统___。", "", listOf("根深蒂固", "遗产", "世界观"), listOf("根深蒂固"), "Doğru cümle: 这个传统根深蒂固。 — Bu gelenek kökleşmiş durumda.", null, null),
                LearningExercise("zhc2u4e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dünya görüşü sarsıldı.", "Bu roman zamanın ruhunu yakalıyor.", "Kültürel miras korunuyor."), listOf("Kültürel miras korunuyor."), "Söylenen cümle: 文化遗产受到保护。", "文化遗产受到保护。", null),
                LearningExercise("zhc2u4e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个传统根深蒂固。", listOf("Bu gelenek kökleşmiş durumda.", "Zihniyet yerden yere değişir.", "Kültürel miras korunuyor."), listOf("Bu gelenek kökleşmiş durumda."), "Cümlenin çevirisi: Bu gelenek kökleşmiş durumda.", null, null))),
            LearningLesson("ZH-C2-U4-L3", "Kültürel Derinlik — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc2u4e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "这种传统在文化中___。", "", listOf("根深蒂固", "根本不深", "深根固蒂了"), listOf("根深蒂固"), "Chengyu: 根深蒂固 (derin kökleşmiş).", null, null),
                LearningExercise("zhc2u4e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 各地心态不同。", "", listOf(), listOf("各地心态不同。"), "Türkçesi: Zihniyet yerden yere değişir.", "各地心态不同。", "各地心态不同。"),
                LearningExercise("zhc2u4e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'zamanın ruhu' ifadesinin Çince karşılığı hangisi?", "", listOf("遗产", "时代精神", "世界观"), listOf("时代精神"), "Örnek: 这部小说抓住了时代精神。 — Bu roman zamanın ruhunu yakalıyor.", null, null))),
            LearningLesson("ZH-C2-U4-L4", "Kültürel Derinlik — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc2u4e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu gelenek kökleşmiş durumda.", "Dünya görüşü sarsıldı.", "Bu roman zamanın ruhunu yakalıyor."), listOf("Dünya görüşü sarsıldı."), "Söylenen cümle: 他的世界观被动摇了。", "他的世界观被动摇了。", null),
                LearningExercise("zhc2u4e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Bu gelenek kökleşmiş durumda.", "Kültürel miras korunuyor.", "Zihniyet yerden yere değişir."), listOf("Zihniyet yerden yere değişir."), "Söylenen cümle: 各地心态不同。", "各地心态不同。", null),
                LearningExercise("zhc2u4e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'kökleşmiş' ifadesinin Çince karşılığı hangisi?", "", listOf("根深蒂固", "心态", "遗产"), listOf("根深蒂固"), "Örnek: 这个传统根深蒂固。 — Bu gelenek kökleşmiş durumda.", null, null))),
            LearningLesson("ZH-C2-U4-L5", "Kültürel Derinlik — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc2u4e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文化遗产受到保护。", listOf("Bu gelenek kökleşmiş durumda.", "Kültürel miras korunuyor.", "Zihniyet yerden yere değişir."), listOf("Kültürel miras korunuyor."), "Cümlenin çevirisi: Kültürel miras korunuyor.", null, null),
                LearningExercise("zhc2u4e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "这个传统根深蒂固。", listOf("Bu gelenek kökleşmiş durumda.", "Bu roman zamanın ruhunu yakalıyor.", "Kültürel miras korunuyor."), listOf("Bu gelenek kökleşmiş durumda."), "Cümlenin çevirisi: Bu gelenek kökleşmiş durumda.", null, null),
                LearningExercise("zhc2u4e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 他的世界观被动摇了。", "", listOf(), listOf("他的世界观被动摇了。"), "Türkçesi: Dünya görüşü sarsıldı.", "他的世界观被动摇了。", "他的世界观被动摇了。"))))),
        LearningUnit("ZH-C2-U5", "Retorik Ustalığı", "Retorik araçları etkili kullan.", listOf(
            LearningLesson("ZH-C2-U5-L1", "Retorik Ustalığı — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc2u5e1", Skill.VOCABULARY, "Doğru anlamı seç", "'修辞' ne anlama gelir?", "", listOf("keskin", "retorik", "söz sanatı"), listOf("retorik"), "他的修辞很出色。 — Retoriği çok başarılı.", null, null),
                LearningExercise("zhc2u5e2", Skill.VOCABULARY, "Doğru anlamı seç", "'修辞手法' ne anlama gelir?", "", listOf("söz sanatı", "etkileme gücü", "heybet/enerji"), listOf("söz sanatı"), "这种修辞手法效果微妙。 — Bu söz sanatının etkisi incelikli.", null, null),
                LearningExercise("zhc2u5e3", Skill.VOCABULARY, "Doğru anlamı seç", "'感染力' ne anlama gelir?", "", listOf("keskin", "retorik", "etkileme gücü"), listOf("etkileme gücü"), "他的演讲很有感染力。 — Konuşması çok etkileyici.", null, null)), listOf(
                TargetVocabulary("zhc2u5w1", "修辞", "retorik", "ifade", "他的修辞很出色。", "Retoriği çok başarılı."),
                TargetVocabulary("zhc2u5w2", "修辞手法", "söz sanatı", "ifade", "这种修辞手法效果微妙。", "Bu söz sanatının etkisi incelikli."),
                TargetVocabulary("zhc2u5w3", "感染力", "etkileme gücü", "ifade", "他的演讲很有感染力。", "Konuşması çok etkileyici."),
                TargetVocabulary("zhc2u5w4", "犀利", "keskin", "ifade", "他的批评非常犀利。", "Eleştirisi son derece keskin."),
                TargetVocabulary("zhc2u5w5", "气势", "heybet/enerji", "ifade", "文章气势磅礴。", "Yazının anlatım gücü görkemli."))),
            LearningLesson("ZH-C2-U5-L2", "Retorik Ustalığı — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc2u5e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "他的___很出色。", "", listOf("修辞", "修辞手法", "感染力"), listOf("修辞"), "Doğru cümle: 他的修辞很出色。 — Retoriği çok başarılı.", null, null),
                LearningExercise("zhc2u5e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "他的批评非常___。", "", listOf("气势", "修辞", "犀利"), listOf("犀利"), "Doğru cümle: 他的批评非常犀利。 — Eleştirisi son derece keskin.", null, null),
                LearningExercise("zhc2u5e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Konuşması çok etkileyici.", "Yazının anlatım gücü görkemli.", "Retoriği çok başarılı."), listOf("Yazının anlatım gücü görkemli."), "Söylenen cümle: 文章气势磅礴。", "文章气势磅礴。", null),
                LearningExercise("zhc2u5e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的批评非常犀利。", listOf("Bu söz sanatının etkisi incelikli.", "Yazının anlatım gücü görkemli.", "Eleştirisi son derece keskin."), listOf("Eleştirisi son derece keskin."), "Cümlenin çevirisi: Eleştirisi son derece keskin.", null, null))),
            LearningLesson("ZH-C2-U5-L3", "Retorik Ustalığı — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc2u5e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "他的批评非常___。", "", listOf("犀利", "锋利了", "利害的"), listOf("犀利"), "Sıfat: 犀利的批评 (keskin eleştiri).", null, null),
                LearningExercise("zhc2u5e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 这种修辞手法效果微妙。", "", listOf(), listOf("这种修辞手法效果微妙。"), "Türkçesi: Bu söz sanatının etkisi incelikli.", "这种修辞手法效果微妙。", "这种修辞手法效果微妙。"),
                LearningExercise("zhc2u5e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'etkileme gücü' ifadesinin Çince karşılığı hangisi?", "", listOf("感染力", "修辞", "气势"), listOf("感染力"), "Örnek: 他的演讲很有感染力。 — Konuşması çok etkileyici.", null, null))),
            LearningLesson("ZH-C2-U5-L4", "Retorik Ustalığı — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc2u5e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Retoriği çok başarılı.", "Konuşması çok etkileyici.", "Eleştirisi son derece keskin."), listOf("Retoriği çok başarılı."), "Söylenen cümle: 他的修辞很出色。", "他的修辞很出色。", null),
                LearningExercise("zhc2u5e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Yazının anlatım gücü görkemli.", "Bu söz sanatının etkisi incelikli.", "Eleştirisi son derece keskin."), listOf("Bu söz sanatının etkisi incelikli."), "Söylenen cümle: 这种修辞手法效果微妙。", "这种修辞手法效果微妙。", null),
                LearningExercise("zhc2u5e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'keskin' ifadesinin Çince karşılığı hangisi?", "", listOf("修辞手法", "气势", "犀利"), listOf("犀利"), "Örnek: 他的批评非常犀利。 — Eleştirisi son derece keskin.", null, null))),
            LearningLesson("ZH-C2-U5-L5", "Retorik Ustalığı — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc2u5e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "文章气势磅礴。", listOf("Yazının anlatım gücü görkemli.", "Bu söz sanatının etkisi incelikli.", "Eleştirisi son derece keskin."), listOf("Yazının anlatım gücü görkemli."), "Cümlenin çevirisi: Yazının anlatım gücü görkemli.", null, null),
                LearningExercise("zhc2u5e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他的批评非常犀利。", listOf("Konuşması çok etkileyici.", "Yazının anlatım gücü görkemli.", "Eleştirisi son derece keskin."), listOf("Eleştirisi son derece keskin."), "Cümlenin çevirisi: Eleştirisi son derece keskin.", null, null),
                LearningExercise("zhc2u5e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 他的修辞很出色。", "", listOf(), listOf("他的修辞很出色。"), "Türkçesi: Retoriği çok başarılı.", "他的修辞很出色。", "他的修辞很出色。"))))),
        LearningUnit("ZH-C2-U6", "Ana Dil Düzeyinde Akıcılık", "Ana dil konuşuru düzeyinde incelik kazan.", listOf(
            LearningLesson("ZH-C2-U6-L1", "Ana Dil Düzeyinde Akıcılık — Kelimeler", "Bu konunun temel kelimelerini tanı.", listOf(
                LearningExercise("zhc2u6e1", Skill.VOCABULARY, "Doğru anlamı seç", "'精通' ne anlama gelir?", "", listOf("ustaca hâkim olmak", "hiç zorlanmadan", "halis/yerli gibi"), listOf("ustaca hâkim olmak"), "她精通五种语言。 — Beş dile ustalıkla hâkim.", null, null),
                LearningExercise("zhc2u6e2", Skill.VOCABULARY, "Doğru anlamı seç", "'毫不费力' ne anlama gelir?", "", listOf("ustalığın zirvesi", "akıcı", "hiç zorlanmadan"), listOf("hiç zorlanmadan"), "她毫不费力地转换语体。 — Dil düzeyini hiç zorlanmadan değiştiriyor.", null, null),
                LearningExercise("zhc2u6e3", Skill.VOCABULARY, "Doğru anlamı seç", "'炉火纯青' ne anlama gelir?", "", listOf("ustaca hâkim olmak", "ustalığın zirvesi", "halis/yerli gibi"), listOf("ustalığın zirvesi"), "他的中文已经炉火纯青。 — Çincesi ustalığın zirvesinde.", null, null)), listOf(
                TargetVocabulary("zhc2u6w1", "精通", "ustaca hâkim olmak", "ifade", "她精通五种语言。", "Beş dile ustalıkla hâkim."),
                TargetVocabulary("zhc2u6w2", "毫不费力", "hiç zorlanmadan", "ifade", "她毫不费力地转换语体。", "Dil düzeyini hiç zorlanmadan değiştiriyor."),
                TargetVocabulary("zhc2u6w3", "炉火纯青", "ustalığın zirvesi", "ifade", "他的中文已经炉火纯青。", "Çincesi ustalığın zirvesinde."),
                TargetVocabulary("zhc2u6w4", "地道", "halis/yerli gibi", "ifade", "他说一口地道的中文。", "Yerli gibi halis bir Çince konuşuyor."),
                TargetVocabulary("zhc2u6w5", "流利", "akıcı", "ifade", "她说得很流利。", "Çok akıcı konuşuyor."))),
            LearningLesson("ZH-C2-U6-L2", "Ana Dil Düzeyinde Akıcılık — Kullanım", "Kelimeleri gerçek cümlelerde, dinleyerek ve okuyarak kullan.", listOf(
                LearningExercise("zhc2u6e4", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "她___五种语言。", "", listOf("毫不费力", "炉火纯青", "精通"), listOf("精通"), "Doğru cümle: 她精通五种语言。 — Beş dile ustalıkla hâkim.", null, null),
                LearningExercise("zhc2u6e5", Skill.VOCABULARY, "Boşluğu doğru ifadeyle tamamla", "他说一口___的中文。", "", listOf("精通", "地道", "流利"), listOf("地道"), "Doğru cümle: 他说一口地道的中文。 — Yerli gibi halis bir Çince konuşuyor.", null, null),
                LearningExercise("zhc2u6e6", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çok akıcı konuşuyor.", "Beş dile ustalıkla hâkim.", "Çincesi ustalığın zirvesinde."), listOf("Çok akıcı konuşuyor."), "Söylenen cümle: 她说得很流利。", "她说得很流利。", null),
                LearningExercise("zhc2u6e10", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他说一口地道的中文。", listOf("Çok akıcı konuşuyor.", "Yerli gibi halis bir Çince konuşuyor.", "Dil düzeyini hiç zorlanmadan değiştiriyor."), listOf("Yerli gibi halis bir Çince konuşuyor."), "Cümlenin çevirisi: Yerli gibi halis bir Çince konuşuyor.", null, null))),
            LearningLesson("ZH-C2-U6-L3", "Ana Dil Düzeyinde Akıcılık — Pekiştirme", "Dil bilgisi odağını uygula, konuş ve üret.", listOf(
                LearningExercise("zhc2u6e7", Skill.GRAMMAR, "Doğru seçeneği işaretle", "她的中文说得很___。", "", listOf("地道", "道地上", "地方"), listOf("地道"), "Övgü: 说得很地道 (ana dili gibi konuşmak).", null, null),
                LearningExercise("zhc2u6e8", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 她毫不费力地转换语体。", "", listOf(), listOf("她毫不费力地转换语体。"), "Türkçesi: Dil düzeyini hiç zorlanmadan değiştiriyor.", "她毫不费力地转换语体。", "她毫不费力地转换语体。"),
                LearningExercise("zhc2u6e9", Skill.VOCABULARY, "Doğru çeviriyi seç", "'ustalığın zirvesi' ifadesinin Çince karşılığı hangisi?", "", listOf("精通", "流利", "炉火纯青"), listOf("炉火纯青"), "Örnek: 他的中文已经炉火纯青。 — Çincesi ustalığın zirvesinde.", null, null))),
            LearningLesson("ZH-C2-U6-L4", "Ana Dil Düzeyinde Akıcılık — Dinleme Atölyesi", "Dikte ve dinleme-anlama ile kulağını keskinleştir.", listOf(
                LearningExercise("zhc2u6e11", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Çincesi ustalığın zirvesinde.", "Yerli gibi halis bir Çince konuşuyor.", "Beş dile ustalıkla hâkim."), listOf("Beş dile ustalıkla hâkim."), "Söylenen cümle: 她精通五种语言。", "她精通五种语言。", null),
                LearningExercise("zhc2u6e12", Skill.LISTENING, "Dinle ve anlamı seç", "Cümle ne anlatıyor?", "", listOf("Dil düzeyini hiç zorlanmadan değiştiriyor.", "Yerli gibi halis bir Çince konuşuyor.", "Çok akıcı konuşuyor."), listOf("Dil düzeyini hiç zorlanmadan değiştiriyor."), "Söylenen cümle: 她毫不费力地转换语体。", "她毫不费力地转换语体。", null),
                LearningExercise("zhc2u6e13", Skill.VOCABULARY, "Doğru çeviriyi seç", "'halis/yerli gibi' ifadesinin Çince karşılığı hangisi?", "", listOf("流利", "地道", "毫不费力"), listOf("地道"), "Örnek: 他说一口地道的中文。 — Yerli gibi halis bir Çince konuşuyor.", null, null))),
            LearningLesson("ZH-C2-U6-L5", "Ana Dil Düzeyinde Akıcılık — Cümle Atölyesi", "Cümleleri kendin kurarak kalıpları pekiştir.", listOf(
                LearningExercise("zhc2u6e14", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "她说得很流利。", listOf("Dil düzeyini hiç zorlanmadan değiştiriyor.", "Yerli gibi halis bir Çince konuşuyor.", "Çok akıcı konuşuyor."), listOf("Çok akıcı konuşuyor."), "Cümlenin çevirisi: Çok akıcı konuşuyor.", null, null),
                LearningExercise("zhc2u6e15", Skill.READING, "Cümleyi oku ve doğru anlamı seç", "Okuduğun cümle ne anlatıyor?", "他说一口地道的中文。", listOf("Çok akıcı konuşuyor.", "Yerli gibi halis bir Çince konuşuyor.", "Çincesi ustalığın zirvesinde."), listOf("Yerli gibi halis bir Çince konuşuyor."), "Cümlenin çevirisi: Yerli gibi halis bir Çince konuşuyor.", null, null),
                LearningExercise("zhc2u6e16", Skill.SPEAKING, "İfadeyi sesli söyle", "Söyle: 她精通五种语言。", "", listOf(), listOf("她精通五种语言。"), "Türkçesi: Beş dile ustalıkla hâkim.", "她精通五种语言。", "她精通五种语言。"))))))
}
