package com.linguapro.android

/**
 * Günün 5 Kelimesi: her gün deterministik olarak farklı 5 kelime seçer ve
 * ertesi günün sınavına "dünün kelimeleri" olarak ekler (öğren → ertesi gün pekiştir).
 * Dünya dilleri havuzu: 180 müfredat kelimesi + resmî sınav listelerine (Goethe, DELF/DALF,
 * DELE, CAPLE, CILS, TORFL, HSK, JLPT, TOPIK) hizalı ~105 ek kelime (bkz. ExamVocabulary).
 * İngilizce havuzu: 120 temel + 120 Oxford bandı kelime. Seçim tamamen deterministiktir: aynı gün
 * aynı kelimeler, ertesi gün farklı kelimeler; havuz bitince karıştırılıp yeniden başlar.
 */
object DailyWords {

    fun todayEpochDay(clock: java.time.Clock = java.time.Clock.systemDefaultZone()): Long =
        java.time.LocalDate.now(clock).toEpochDay()

    private val poolCache = HashMap<String, List<TargetVocabulary>>()

    fun pool(lang: String, level: String? = null): List<TargetVocabulary> = synchronized(poolCache) {
        if (level != null) require(level in CourseCatalog.levels) { "Unsupported course level: $level" }
        poolCache.getOrPut("$lang:${level ?: "all"}") {
            if (level != null) {
                // Only use authored vocabulary from the selected curriculum level. Exam labels
                // are not a verified CEFR mapping, so the mixed exam bank is excluded here.
                return@getOrPut WorldCatalog.units(lang, level).flatMap { unit ->
                    unit.lessons.flatMap { it.targetVocabulary }
                }.distinctBy { it.termEn.lowercase(java.util.Locale.ROOT) }
            }
            val curriculum = if (lang == "EN") englishBank
            else CourseCatalog.levels.flatMap { level ->
                WorldCatalog.units(lang, level).flatMap { unit -> unit.lessons.flatMap { it.targetVocabulary } }
            }
            // Resmî sınav listelerine hizalı ek banka (Goethe/DELF/DELE/CAPLE/CILS/TORFL/HSK/JLPT/TOPIK/Oxford).
            // distinctBy: aynı kelime döngü içinde iki kez "yeni" diye çıkmasın.
            (curriculum + ExamVocabulary.bank(lang)).distinctBy { it.termEn.lowercase() }
        }
    }

    /** O günün 5 kelimesi. Aynı döngü içinde günler arası tekrar olmaz. */
    fun wordsFor(lang: String, epochDay: Long, level: String? = null): List<TargetVocabulary> {
        val fullPool = pool(lang, level)
        if (fullPool.size < 10) return emptyList()
        val slotsPerCycle = fullPool.size / 5
        val cycle = epochDay / slotsPerCycle
        val slot = ((epochDay % slotsPerCycle + slotsPerCycle) % slotsPerCycle).toInt()
        val seed = if (level == null) lang.hashCode() else "$lang:$level".hashCode()
        val shuffled = fullPool.shuffled(kotlin.random.Random(seed * 31L + cycle))
        return shuffled.subList(slot * 5, slot * 5 + 5)
    }

    /** 10 soruluk günlük kelime dersi: bugünün 5 kelimesi + dünün 5 kelimesinin tekrarı. */
    fun lessonFor(lang: String, epochDay: Long = todayEpochDay(), level: String? = null): LearningLesson {
        val today = wordsFor(lang, epochDay, level)
        val yesterday = wordsFor(lang, epochDay - 1, level)
        val fullPool = pool(lang, level)
        val random = kotlin.random.Random(lang.hashCode() * 1_000_003L + epochDay)
        fun meaningOptions(word: TargetVocabulary): List<String> {
            val wrong = fullPool.map { it.translationTr }.distinct().filter { it != word.translationTr }.shuffled(random).take(2)
            return (listOf(word.translationTr) + wrong).shuffled(random)
        }
        fun termOptions(word: TargetVocabulary): List<String> {
            val wrong = fullPool.map { it.termEn }.distinct().filter { it != word.termEn }.shuffled(random).take(2)
            return (listOf(word.termEn) + wrong).shuffled(random)
        }
        val exercises = buildList {
            today.forEachIndexed { i, word ->
                add(LearningExercise(
                    "wd-$lang-${level ?: "all"}-$epochDay-n$i", Skill.VOCABULARY, "Yeni kelime: doğru anlamı seç",
                    "'${word.termEn}' ne demek?", "", meaningOptions(word), listOf(word.translationTr),
                    "${word.exampleEn} — ${word.exampleTr}", word.termEn
                ))
            }
            yesterday.forEachIndexed { i, word ->
                add(LearningExercise(
                    "wd-$lang-${level ?: "all"}-$epochDay-r$i", Skill.VOCABULARY, "Dünün kelimesi: hatırlıyor musun?",
                    "'${word.translationTr}' karşılığı hangisi?", "", termOptions(word), listOf(word.termEn),
                    "${word.exampleEn} — ${word.exampleTr}", word.termEn
                ))
            }
        }
        return LearningLesson(
            "$lang-WORDS",
            "Günün 5 Kelimesi",
            "Her gün 5 yeni kelime öğren; dünün kelimelerini tekrar ederek kalıcı hale getir.",
            exercises,
            today
        )
    }

    private val englishBank: List<TargetVocabulary> = listOf(
        TargetVocabulary("enw1", "hello", "merhaba", "ifade", "Hello, nice to meet you.", "Merhaba, tanıştığımıza memnun oldum."),
        TargetVocabulary("enw2", "water", "su", "ifade", "Can I have a glass of water?", "Bir bardak su alabilir miyim?"),
        TargetVocabulary("enw3", "family", "aile", "ifade", "My family lives in Izmir.", "Ailem İzmir'de yaşıyor."),
        TargetVocabulary("enw4", "breakfast", "kahvaltı", "ifade", "We have breakfast at eight.", "Kahvaltıyı saat sekizde yaparız."),
        TargetVocabulary("enw5", "house", "ev", "ifade", "Their house has a small garden.", "Evlerinin küçük bir bahçesi var."),
        TargetVocabulary("enw6", "friend", "arkadaş", "ifade", "She is my best friend.", "O benim en iyi arkadaşım."),
        TargetVocabulary("enw7", "book", "kitap", "ifade", "I read a book every month.", "Her ay bir kitap okurum."),
        TargetVocabulary("enw8", "weather", "hava durumu", "ifade", "The weather is sunny today.", "Bugün hava güneşli."),
        TargetVocabulary("enw9", "morning", "sabah", "ifade", "I drink coffee every morning.", "Her sabah kahve içerim."),
        TargetVocabulary("enw10", "work", "iş", "ifade", "He goes to work by bus.", "İşe otobüsle gider."),
        TargetVocabulary("enw11", "money", "para", "ifade", "How much money do you need?", "Ne kadar paraya ihtiyacın var?"),
        TargetVocabulary("enw12", "city", "şehir", "ifade", "Istanbul is a very big city.", "İstanbul çok büyük bir şehir."),
        TargetVocabulary("enw13", "food", "yemek", "ifade", "Turkish food is delicious.", "Türk yemekleri lezzetlidir."),
        TargetVocabulary("enw14", "school", "okul", "ifade", "The school is near our house.", "Okul evimize yakın."),
        TargetVocabulary("enw15", "holiday", "tatil", "ifade", "We are planning a holiday in July.", "Temmuzda bir tatil planlıyoruz."),
        TargetVocabulary("enw16", "ticket", "bilet", "ifade", "I bought two tickets for the concert.", "Konser için iki bilet aldım."),
        TargetVocabulary("enw17", "doctor", "doktor", "ifade", "You should see a doctor.", "Bir doktora görünmelisin."),
        TargetVocabulary("enw18", "market", "pazar", "ifade", "The market is cheaper than the mall.", "Pazar alışveriş merkezinden daha ucuz."),
        TargetVocabulary("enw19", "clothes", "kıyafet", "ifade", "These clothes are on sale.", "Bu kıyafetler indirimde."),
        TargetVocabulary("enw20", "question", "soru", "ifade", "May I ask a question?", "Bir soru sorabilir miyim?"),
        TargetVocabulary("enw21", "always", "her zaman", "ifade", "She always arrives on time.", "Her zaman vaktinde gelir."),
        TargetVocabulary("enw22", "together", "birlikte", "ifade", "We cook dinner together.", "Akşam yemeğini birlikte pişiririz."),
        TargetVocabulary("enw23", "cheap", "ucuz", "ifade", "This hotel is cheap and clean.", "Bu otel ucuz ve temiz."),
        TargetVocabulary("enw24", "expensive", "pahalı", "ifade", "The restaurant was too expensive.", "Restoran fazla pahalıydı."),
        TargetVocabulary("enw25", "early", "erken", "ifade", "I wake up early on weekdays.", "Hafta içi erken uyanırım."),
        TargetVocabulary("enw26", "late", "geç", "ifade", "Sorry, I'm late again.", "Üzgünüm, yine geciktim."),
        TargetVocabulary("enw27", "hungry", "aç", "ifade", "The children are hungry.", "Çocuklar aç."),
        TargetVocabulary("enw28", "tired", "yorgun", "ifade", "I feel tired after work.", "İşten sonra yorgun hissediyorum."),
        TargetVocabulary("enw29", "happy", "mutlu", "ifade", "She looks very happy today.", "Bugün çok mutlu görünüyor."),
        TargetVocabulary("enw30", "important", "önemli", "ifade", "This meeting is very important.", "Bu toplantı çok önemli."),
        TargetVocabulary("enw31", "journey", "yolculuk", "ifade", "The journey took six hours.", "Yolculuk altı saat sürdü."),
        TargetVocabulary("enw32", "luggage", "bagaj", "ifade", "My luggage is too heavy.", "Bagajım çok ağır."),
        TargetVocabulary("enw33", "neighbour", "komşu", "ifade", "Our neighbour is very friendly.", "Komşumuz çok cana yakın."),
        TargetVocabulary("enw34", "appointment", "randevu", "ifade", "I have a dentist appointment tomorrow.", "Yarın diş hekimi randevum var."),
        TargetVocabulary("enw35", "experience", "deneyim", "ifade", "She has five years of experience.", "Beş yıllık deneyimi var."),
        TargetVocabulary("enw36", "decision", "karar", "ifade", "It was a difficult decision.", "Zor bir karardı."),
        TargetVocabulary("enw37", "advice", "tavsiye", "ifade", "Thanks for your advice.", "Tavsiyen için teşekkürler."),
        TargetVocabulary("enw38", "discount", "indirim", "ifade", "Is there a discount for students?", "Öğrencilere indirim var mı?"),
        TargetVocabulary("enw39", "receipt", "fiş", "ifade", "Could I have the receipt, please?", "Fişi alabilir miyim lütfen?"),
        TargetVocabulary("enw40", "timetable", "tarife", "ifade", "Check the train timetable online.", "Tren tarifesine internetten bak."),
        TargetVocabulary("enw41", "suggest", "önermek", "ifade", "Can you suggest a good restaurant?", "İyi bir restoran önerebilir misin?"),
        TargetVocabulary("enw42", "borrow", "ödünç almak", "ifade", "May I borrow your pen?", "Kalemini ödünç alabilir miyim?"),
        TargetVocabulary("enw43", "improve", "geliştirmek", "ifade", "I want to improve my English.", "İngilizcemi geliştirmek istiyorum."),
        TargetVocabulary("enw44", "prefer", "tercih etmek", "ifade", "I prefer tea to coffee.", "Çayı kahveye tercih ederim."),
        TargetVocabulary("enw45", "arrive", "varmak", "ifade", "The train arrives at noon.", "Tren öğlen varıyor."),
        TargetVocabulary("enw46", "forget", "unutmak", "ifade", "Don't forget your keys.", "Anahtarlarını unutma."),
        TargetVocabulary("enw47", "remember", "hatırlamak", "ifade", "I remember our first trip.", "İlk gezimizi hatırlıyorum."),
        TargetVocabulary("enw48", "healthy", "sağlıklı", "ifade", "Walking is a healthy habit.", "Yürüyüş sağlıklı bir alışkanlıktır."),
        TargetVocabulary("enw49", "comfortable", "rahat", "ifade", "This sofa is very comfortable.", "Bu kanepe çok rahat."),
        TargetVocabulary("enw50", "crowded", "kalabalık", "ifade", "The bus was crowded this morning.", "Otobüs bu sabah kalabalıktı."),
        TargetVocabulary("enw51", "opportunity", "fırsat", "ifade", "This job is a great opportunity.", "Bu iş harika bir fırsat."),
        TargetVocabulary("enw52", "environment", "çevre", "ifade", "We must protect the environment.", "Çevreyi korumalıyız."),
        TargetVocabulary("enw53", "knowledge", "bilgi", "ifade", "Knowledge grows when you share it.", "Bilgi paylaştıkça çoğalır."),
        TargetVocabulary("enw54", "confidence", "özgüven", "ifade", "Practice builds confidence.", "Pratik özgüven kazandırır."),
        TargetVocabulary("enw55", "responsibility", "sorumluluk", "ifade", "Managing the budget is my responsibility.", "Bütçeyi yönetmek benim sorumluluğum."),
        TargetVocabulary("enw56", "development", "gelişim", "ifade", "The city's development has been fast.", "Şehrin gelişimi hızlı oldu."),
        TargetVocabulary("enw57", "relationship", "ilişki", "ifade", "They have a strong relationship.", "Güçlü bir ilişkileri var."),
        TargetVocabulary("enw58", "behaviour", "davranış", "ifade", "His behaviour surprised everyone.", "Davranışı herkesi şaşırttı."),
        TargetVocabulary("enw59", "research", "araştırma", "ifade", "The research took two years.", "Araştırma iki yıl sürdü."),
        TargetVocabulary("enw60", "solution", "çözüm", "ifade", "We found a practical solution.", "Pratik bir çözüm bulduk."),
        TargetVocabulary("enw61", "achieve", "başarmak", "ifade", "She achieved her sales target.", "Satış hedefini başardı."),
        TargetVocabulary("enw62", "avoid", "kaçınmak", "ifade", "Avoid sugary drinks before bed.", "Yatmadan önce şekerli içeceklerden kaçın."),
        TargetVocabulary("enw63", "describe", "tanımlamak", "ifade", "Can you describe the problem?", "Sorunu tanımlayabilir misin?"),
        TargetVocabulary("enw64", "encourage", "cesaretlendirmek", "ifade", "Teachers should encourage students.", "Öğretmenler öğrencileri cesaretlendirmeli."),
        TargetVocabulary("enw65", "manage", "yönetmek", "ifade", "She manages a small team.", "Küçük bir ekibi yönetiyor."),
        TargetVocabulary("enw66", "organise", "düzenlemek", "ifade", "We organised a charity event.", "Bir yardım etkinliği düzenledik."),
        TargetVocabulary("enw67", "recommend", "tavsiye etmek", "ifade", "I recommend the fish soup.", "Balık çorbasını tavsiye ederim."),
        TargetVocabulary("enw68", "require", "gerektirmek", "ifade", "This job requires patience.", "Bu iş sabır gerektirir."),
        TargetVocabulary("enw69", "deadline", "son tarih", "ifade", "The deadline is next Friday.", "Son tarih önümüzdeki cuma."),
        TargetVocabulary("enw70", "colleague", "iş arkadaşı", "ifade", "My colleagues are supportive.", "İş arkadaşlarım destekleyici."),
        TargetVocabulary("enw71", "schedule", "program", "ifade", "My schedule is full this week.", "Bu hafta programım dolu."),
        TargetVocabulary("enw72", "efficient", "verimli", "ifade", "The new system is more efficient.", "Yeni sistem daha verimli."),
        TargetVocabulary("enw73", "reliable", "güvenilir", "ifade", "We need a reliable supplier.", "Güvenilir bir tedarikçiye ihtiyacımız var."),
        TargetVocabulary("enw74", "available", "müsait", "ifade", "Are you available on Monday?", "Pazartesi müsait misin?"),
        TargetVocabulary("enw75", "convenient", "kullanışlı", "ifade", "Online banking is very convenient.", "İnternet bankacılığı çok kullanışlı."),
        TargetVocabulary("enw76", "negotiate", "pazarlık etmek", "ifade", "We negotiated a better price.", "Daha iyi bir fiyat için pazarlık ettik."),
        TargetVocabulary("enw77", "postpone", "ertelemek", "ifade", "They postponed the meeting.", "Toplantıyı ertelediler."),
        TargetVocabulary("enw78", "consider", "değerlendirmek", "ifade", "Please consider our offer.", "Lütfen teklifimizi değerlendirin."),
        TargetVocabulary("enw79", "assume", "varsaymak", "ifade", "Let's assume the plan works.", "Planın işe yaradığını varsayalım."),
        TargetVocabulary("enw80", "estimate", "tahmin etmek", "ifade", "Can you estimate the cost?", "Maliyeti tahmin edebilir misin?"),
        TargetVocabulary("enw81", "evidence", "kanıt", "ifade", "There is strong evidence for this theory.", "Bu teori için güçlü kanıt var."),
        TargetVocabulary("enw82", "approach", "yaklaşım", "ifade", "We need a different approach.", "Farklı bir yaklaşıma ihtiyacımız var."),
        TargetVocabulary("enw83", "attitude", "tutum", "ifade", "A positive attitude helps at work.", "Olumlu bir tutum işte yardımcı olur."),
        TargetVocabulary("enw84", "benefit", "fayda", "ifade", "Exercise has many benefits.", "Egzersizin pek çok faydası var."),
        TargetVocabulary("enw85", "challenge", "zorluk", "ifade", "Learning a language is a rewarding challenge.", "Dil öğrenmek ödüllendirici bir zorluktur."),
        TargetVocabulary("enw86", "courage", "cesaret", "ifade", "It takes courage to speak in public.", "Topluluk önünde konuşmak cesaret ister."),
        TargetVocabulary("enw87", "curious", "meraklı", "ifade", "She is curious about other cultures.", "Başka kültürleri merak ediyor."),
        TargetVocabulary("enw88", "essential", "vazgeçilmez", "ifade", "Sleep is essential for health.", "Uyku sağlık için vazgeçilmezdir."),
        TargetVocabulary("enw89", "gradually", "yavaş yavaş", "ifade", "The weather is gradually getting warmer.", "Hava yavaş yavaş ısınıyor."),
        TargetVocabulary("enw90", "particularly", "özellikle", "ifade", "I particularly enjoyed the ending.", "Özellikle sonunu beğendim."),
        TargetVocabulary("enw91", "significant", "kayda değer", "ifade", "We saw a significant improvement.", "Kayda değer bir iyileşme gördük."),
        TargetVocabulary("enw92", "sustainable", "sürdürülebilir", "ifade", "We support sustainable farming.", "Sürdürülebilir tarımı destekliyoruz."),
        TargetVocabulary("enw93", "inevitable", "kaçınılmaz", "ifade", "Change is inevitable in business.", "İş dünyasında değişim kaçınılmazdır."),
        TargetVocabulary("enw94", "ambiguous", "belirsiz", "ifade", "His answer was deliberately ambiguous.", "Cevabı kasıtlı olarak belirsizdi."),
        TargetVocabulary("enw95", "comprehensive", "kapsamlı", "ifade", "The report is thorough and comprehensive.", "Rapor titiz ve kapsamlı."),
        TargetVocabulary("enw96", "controversial", "tartışmalı", "ifade", "The new law is highly controversial.", "Yeni yasa oldukça tartışmalı."),
        TargetVocabulary("enw97", "deteriorate", "kötüleşmek", "ifade", "His health began to deteriorate.", "Sağlığı kötüleşmeye başladı."),
        TargetVocabulary("enw98", "emphasize", "vurgulamak", "ifade", "She emphasized the importance of practice.", "Pratiğin önemini vurguladı."),
        TargetVocabulary("enw99", "facilitate", "kolaylaştırmak", "ifade", "Technology facilitates remote work.", "Teknoloji uzaktan çalışmayı kolaylaştırır."),
        TargetVocabulary("enw100", "implement", "uygulamaya koymak", "ifade", "We will implement the plan in May.", "Planı mayısta uygulamaya koyacağız."),
        TargetVocabulary("enw101", "justify", "gerekçelendirmek", "ifade", "How do you justify this expense?", "Bu harcamayı nasıl gerekçelendiriyorsun?"),
        TargetVocabulary("enw102", "negligible", "göz ardı edilebilir", "ifade", "The risk is negligible.", "Risk göz ardı edilebilir düzeyde."),
        TargetVocabulary("enw103", "notorious", "adı çıkmış", "ifade", "The road is notorious for traffic jams.", "Bu yol trafik sıkışıklığıyla adı çıkmıştır."),
        TargetVocabulary("enw104", "profound", "derin", "ifade", "The book had a profound effect on me.", "Kitap üzerimde derin bir etki bıraktı."),
        TargetVocabulary("enw105", "reluctant", "isteksiz", "ifade", "He was reluctant to accept help.", "Yardımı kabul etmekte isteksizdi."),
        TargetVocabulary("enw106", "scrutiny", "inceleme", "ifade", "The contract is under close scrutiny.", "Sözleşme yakın inceleme altında."),
        TargetVocabulary("enw107", "subtle", "incelikli", "ifade", "There is a subtle difference between the two.", "İkisi arasında incelikli bir fark var."),
        TargetVocabulary("enw108", "tangible", "somut", "ifade", "We need tangible results by June.", "Hazirana kadar somut sonuçlara ihtiyacımız var."),
        TargetVocabulary("enw109", "undermine", "baltalamak", "ifade", "Rumours can undermine trust.", "Söylentiler güveni baltalayabilir."),
        TargetVocabulary("enw110", "versatile", "çok yönlü", "ifade", "She is a versatile musician.", "Çok yönlü bir müzisyen."),
        TargetVocabulary("enw111", "meticulous", "titiz", "ifade", "He keeps meticulous records.", "Titiz kayıtlar tutar."),
        TargetVocabulary("enw112", "resilient", "dirençli", "ifade", "Children are remarkably resilient.", "Çocuklar dikkat çekici ölçüde dirençlidir."),
        TargetVocabulary("enw113", "eloquent", "etkileyici konuşan", "ifade", "Her eloquent speech moved the audience.", "Etkileyici konuşması dinleyicileri duygulandırdı."),
        TargetVocabulary("enw114", "pragmatic", "faydacı", "ifade", "We took a pragmatic approach.", "Faydacı bir yaklaşım benimsedik."),
        TargetVocabulary("enw115", "ubiquitous", "her yerde bulunan", "ifade", "Smartphones are ubiquitous nowadays.", "Akıllı telefonlar bugünlerde her yerde."),
        TargetVocabulary("enw116", "nuance", "ince ayrım", "ifade", "Translation requires attention to nuance.", "Çeviri ince ayrımlara dikkat gerektirir."),
        TargetVocabulary("enw117", "paradox", "çelişki", "ifade", "It's a paradox that doing less achieved more.", "Daha azını yapmanın daha çok kazandırması bir çelişki."),
        TargetVocabulary("enw118", "consensus", "uzlaşı", "ifade", "The board finally reached a consensus.", "Kurul sonunda uzlaşıya vardı."),
        TargetVocabulary("enw119", "legacy", "miras", "ifade", "The festival is his lasting legacy.", "Festival onun kalıcı mirasıdır."),
        TargetVocabulary("enw120", "itinerary", "gezi planı", "ifade", "Our itinerary includes three cities.", "Gezi planımız üç şehri kapsıyor.")
    )
}

