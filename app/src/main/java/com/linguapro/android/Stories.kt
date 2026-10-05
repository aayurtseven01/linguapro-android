package com.linguapro.android

/** Hikâye satırı: konuşan karakter (kadro indeksi), hedef dil metni ve Türkçe çevirisi. */
data class StoryLine(val speaker: Int, val text: String, val tr: String)

/** Hikâye sonu anlama sorusu (Türkçe sorulur). */
data class StoryQuestion(val prompt: String, val options: List<String>, val correct: Int, val explanationTr: String = "")

/** Etkileşimli diyalog hikâyesi: oku → dinle → soruları yanıtla. */
data class Story(
    val id: String,
    val lang: String,
    val level: String,
    val title: String,
    val lines: List<StoryLine>,
    val questions: List<StoryQuestion>
)

/**
 * Hikâye kataloğu v1: her dil için A1 "Kafede Tanışma" diyaloğu.
 * Satırlar hedef dilde ve doğal; çeviriler altyazı olarak gösterilir.
 */
object StoryCatalog {

    fun storiesFor(lang: String): List<Story> = all.filter { it.lang == lang }

    fun byId(id: String): Story? = all.firstOrNull { it.id == id }

    val all: List<Story> = listOf(
        Story("EN-A1-S1", "EN", "A1", "At the Café", listOf(
            StoryLine(0, "Hello!", "Merhaba!"),
            StoryLine(1, "Hi! I'm Maya. What's your name?", "Selam! Ben Maya. Senin adın ne?"),
            StoryLine(0, "I'm Deniz. Nice to meet you!", "Ben Deniz. Tanıştığımıza memnun oldum!"),
            StoryLine(1, "Nice to meet you too! Where are you from?", "Ben de memnun oldum! Nerelisin?"),
            StoryLine(0, "I'm from Türkiye. And you?", "Türkiyeliyim. Ya sen?"),
            StoryLine(1, "I'm from Spain.", "İspanyalıyım."),
            StoryLine(0, "What would you like to drink?", "Ne içmek istersin?"),
            StoryLine(1, "A tea, please. Thank you!", "Bir çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Maya nereli?", listOf("İspanya", "Türkiye", "İtalya"), 0),
            StoryQuestion("Maya ne sipariş etti?", listOf("kahve", "çay", "su"), 1),
            StoryQuestion("Kim Türkiyeli?", listOf("Maya", "garson", "Deniz"), 2)
        )),
        Story("DE-A1-S1", "DE", "A1", "Im Café", listOf(
            StoryLine(0, "Hallo!", "Merhaba!"),
            StoryLine(1, "Hallo! Ich bin Lena. Wie heißt du?", "Merhaba! Ben Lena. Adın ne?"),
            StoryLine(0, "Ich heiße Emre. Freut mich!", "Adım Emre. Memnun oldum!"),
            StoryLine(1, "Freut mich auch! Woher kommst du?", "Ben de memnun oldum! Nereden geliyorsun?"),
            StoryLine(0, "Ich komme aus der Türkei. Und du?", "Türkiye'den geliyorum. Ya sen?"),
            StoryLine(1, "Ich komme aus Österreich.", "Avusturya'dan geliyorum."),
            StoryLine(0, "Was möchtest du trinken?", "Ne içmek istersin?"),
            StoryLine(1, "Einen Tee, bitte. Danke!", "Bir çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Lena nereli?", listOf("Avusturya", "Almanya", "Türkiye"), 0),
            StoryQuestion("Lena ne içmek istiyor?", listOf("kahve", "su", "çay"), 2),
            StoryQuestion("Kim Türkiye'den geliyor?", listOf("Emre", "Lena", "ikisi de"), 0)
        )),
        Story("FR-A1-S1", "FR", "A1", "Au café", listOf(
            StoryLine(0, "Bonjour !", "Merhaba!"),
            StoryLine(1, "Bonjour ! Je suis Chloé. Comment tu t'appelles ?", "Merhaba! Ben Chloé. Adın ne?"),
            StoryLine(0, "Je m'appelle Kerem. Enchanté !", "Adım Kerem. Memnun oldum!"),
            StoryLine(1, "Enchantée ! Tu viens d'où ?", "Ben de! Nereden geliyorsun?"),
            StoryLine(0, "Je viens de Turquie. Et toi ?", "Türkiye'den geliyorum. Ya sen?"),
            StoryLine(1, "Je viens de Belgique.", "Belçika'dan geliyorum."),
            StoryLine(0, "Qu'est-ce que tu veux boire ?", "Ne içmek istersin?"),
            StoryLine(1, "Un thé, s'il te plaît. Merci !", "Bir çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Chloé nereli?", listOf("Fransa", "Belçika", "İsviçre"), 1),
            StoryQuestion("Chloé ne sipariş etti?", listOf("çay", "kahve", "portakal suyu"), 0),
            StoryQuestion("Kerem nereden geliyor?", listOf("Belçika", "Fransa", "Türkiye"), 2)
        )),
        Story("ES-A1-S1", "ES", "A1", "En el café", listOf(
            StoryLine(0, "¡Hola!", "Merhaba!"),
            StoryLine(1, "¡Hola! Soy Lucía. ¿Cómo te llamas?", "Merhaba! Ben Lucía. Adın ne?"),
            StoryLine(0, "Me llamo Deniz. ¡Mucho gusto!", "Adım Deniz. Memnun oldum!"),
            StoryLine(1, "¡Mucho gusto! ¿De dónde eres?", "Ben de! Nerelisin?"),
            StoryLine(0, "Soy de Turquía. ¿Y tú?", "Türkiyeliyim. Ya sen?"),
            StoryLine(1, "Soy de México.", "Meksikalıyım."),
            StoryLine(0, "¿Qué quieres tomar?", "Ne içmek istersin?"),
            StoryLine(1, "Un té, por favor. ¡Gracias!", "Bir çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Lucía nereli?", listOf("İspanya", "Arjantin", "Meksika"), 2),
            StoryQuestion("Lucía ne sipariş etti?", listOf("çay", "kahve", "limonata"), 0),
            StoryQuestion("Deniz nereli?", listOf("Türkiye", "Meksika", "İspanya"), 0)
        )),
        Story("PT-A1-S1", "PT", "A1", "No café", listOf(
            StoryLine(0, "Olá!", "Merhaba!"),
            StoryLine(1, "Olá! Eu sou a Inês. Como te chamas?", "Merhaba! Ben Inês. Adın ne?"),
            StoryLine(0, "Chamo-me Emre. Muito prazer!", "Adım Emre. Memnun oldum!"),
            StoryLine(1, "Muito prazer! De onde és?", "Ben de! Nerelisin?"),
            StoryLine(0, "Sou da Turquia. E tu?", "Türkiyeliyim. Ya sen?"),
            StoryLine(1, "Sou do Brasil.", "Brezilyalıyım."),
            StoryLine(0, "O que queres beber?", "Ne içmek istersin?"),
            StoryLine(1, "Um chá, por favor. Obrigada!", "Bir çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Inês nereli?", listOf("Portekiz", "Brezilya", "Angola"), 1),
            StoryQuestion("Inês ne sipariş etti?", listOf("kahve", "çay", "su"), 1),
            StoryQuestion("Emre nereli?", listOf("Brezilya", "Portekiz", "Türkiye"), 2)
        )),
        Story("IT-A1-S1", "IT", "A1", "Al bar", listOf(
            StoryLine(0, "Ciao!", "Merhaba!"),
            StoryLine(1, "Ciao! Sono Giulia. Come ti chiami?", "Merhaba! Ben Giulia. Adın ne?"),
            StoryLine(0, "Mi chiamo Kerem. Piacere!", "Adım Kerem. Memnun oldum!"),
            StoryLine(1, "Piacere mio! Di dove sei?", "Ben de! Nerelisin?"),
            StoryLine(0, "Vengo dalla Turchia. E tu?", "Türkiye'den geliyorum. Ya sen?"),
            StoryLine(1, "Sono di Napoli.", "Napolilyim."),
            StoryLine(0, "Cosa vuoi bere?", "Ne içmek istersin?"),
            StoryLine(1, "Un tè, per favore. Grazie!", "Bir çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Giulia nereli?", listOf("Roma", "Napoli", "Milano"), 1),
            StoryQuestion("Giulia ne sipariş etti?", listOf("çay", "espresso", "su"), 0),
            StoryQuestion("Kerem nereden geliyor?", listOf("İtalya", "Türkiye", "Napoli"), 1)
        )),
        Story("RU-A1-S1", "RU", "A1", "В кафе", listOf(
            StoryLine(0, "Привет!", "Merhaba!"),
            StoryLine(1, "Привет! Я Ольга. Как тебя зовут?", "Merhaba! Ben Olga. Adın ne?"),
            StoryLine(0, "Меня зовут Дениз. Очень приятно!", "Adım Deniz. Çok memnun oldum!"),
            StoryLine(1, "Очень приятно! Откуда ты?", "Ben de! Nerelisin?"),
            StoryLine(0, "Я из Турции. А ты?", "Türkiye'denim. Ya sen?"),
            StoryLine(1, "Я из Казани.", "Kazan'danım."),
            StoryLine(0, "Что ты будешь пить?", "Ne içeceksin?"),
            StoryLine(1, "Чай, пожалуйста. Спасибо!", "Çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Olga nereli?", listOf("Moskova", "Kazan", "Petersburg"), 1),
            StoryQuestion("Olga ne içecek?", listOf("çay", "kahve", "süt"), 0),
            StoryQuestion("Deniz nereden?", listOf("Kazan", "Türkiye", "Rusya"), 1)
        )),
        Story("ZH-A1-S1", "ZH", "A1", "在咖啡店", listOf(
            StoryLine(0, "你好！", "Merhaba!"),
            StoryLine(1, "你好！我叫小美。你叫什么名字？", "Merhaba! Benim adım Xiaomei. Senin adın ne?"),
            StoryLine(0, "我叫德尼兹。很高兴认识你！", "Benim adım Deniz. Tanıştığımıza çok sevindim!"),
            StoryLine(1, "我也很高兴！你是哪国人？", "Ben de sevindim! Hangi ülkedensin?"),
            StoryLine(0, "我是土耳其人。你呢？", "Türk'üm. Ya sen?"),
            StoryLine(1, "我是中国人。", "Çinliyim."),
            StoryLine(0, "你想喝什么？", "Ne içmek istersin?"),
            StoryLine(1, "一杯茶，谢谢！", "Bir fincan çay, teşekkürler!")
        ), listOf(
            StoryQuestion("Xiaomei hangi ülkeden?", listOf("Japonya", "Çin", "Kore"), 1),
            StoryQuestion("Xiaomei ne istiyor?", listOf("çay", "kahve", "kola"), 0),
            StoryQuestion("Deniz hangi ülkeden?", listOf("Çin", "Türkiye", "Almanya"), 1)
        )),
        Story("JA-A1-S1", "JA", "A1", "カフェで", listOf(
            StoryLine(0, "こんにちは！", "Merhaba!"),
            StoryLine(1, "こんにちは！私はさくらです。お名前は？", "Merhaba! Ben Sakura. Adınız ne?"),
            StoryLine(0, "デニズです。よろしくお願いします！", "Deniz'im. Memnun oldum!"),
            StoryLine(1, "こちらこそ！どこから来ましたか。", "Ben de! Nereden geldiniz?"),
            StoryLine(0, "トルコから来ました。あなたは？", "Türkiye'den geldim. Ya siz?"),
            StoryLine(1, "大阪から来ました。", "Osaka'dan geldim."),
            StoryLine(0, "何を飲みますか。", "Ne içersiniz?"),
            StoryLine(1, "お茶をお願いします。ありがとう！", "Çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Sakura nereden geldi?", listOf("Tokyo", "Osaka", "Kyoto"), 1),
            StoryQuestion("Sakura ne içecek?", listOf("çay", "kahve", "su"), 0),
            StoryQuestion("Deniz nereden geldi?", listOf("Osaka", "Japonya", "Türkiye"), 2)
        )),
        Story("KO-A1-S1", "KO", "A1", "카페에서", listOf(
            StoryLine(0, "안녕하세요!", "Merhaba!"),
            StoryLine(1, "안녕하세요! 저는 지민이에요. 이름이 뭐예요?", "Merhaba! Ben Jimin. Adınız ne?"),
            StoryLine(0, "저는 데니즈예요. 반가워요!", "Ben Deniz. Memnun oldum!"),
            StoryLine(1, "저도 반가워요! 어느 나라 사람이에요?", "Ben de! Hangi ülkedensiniz?"),
            StoryLine(0, "터키 사람이에요. 당신은요?", "Türk'üm. Ya siz?"),
            StoryLine(1, "한국 사람이에요.", "Koreliyim."),
            StoryLine(0, "뭐 마실래요?", "Ne içersiniz?"),
            StoryLine(1, "차 주세요. 감사합니다!", "Çay lütfen. Teşekkürler!")
        ), listOf(
            StoryQuestion("Jimin hangi ülkeden?", listOf("Kore", "Japonya", "Çin"), 0),
            StoryQuestion("Jimin ne istiyor?", listOf("kahve", "çay", "su"), 1),
            StoryQuestion("Deniz hangi ülkeden?", listOf("Kore", "Türkiye", "Amerika"), 1)
        ))
    ) + StoryExpansion.stories
}
// STORIES-SON

