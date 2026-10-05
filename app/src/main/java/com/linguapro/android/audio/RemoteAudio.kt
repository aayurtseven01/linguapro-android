package com.linguapro.android.audio

import kotlinx.serialization.Serializable
import java.io.File
import java.security.MessageDigest

/**
 * Uzak ses altyapısının saf-JVM çekirdeği.
 *
 * Kural (kritik): [AudioKey.normalize] ve [AudioKey.forVoice], tools/tts/generate.mjs
 * içindeki kurallarla BİREBİR aynı sonucu üretmelidir:
 *   normalize: uç boşluk atma + ASCII boşluk dizilerini tekleme (JS: /[ \t\n\r\f\u000B]+/g)
 *   anahtar  : sha256("voiceId|metin") UTF-8 → ilk 40 küçük-hex karakter
 * Dışa aktarma (ExportMain) ve üretim script'i aynı normalizasyonu kullanır;
 * bu üçü birlikte değişmeli (bkz. AvatarConfigTest tarzı sabit değer testi: RemoteAudioTest).
 */
object AudioKey {

    fun normalize(text: String): String = text.trim().replace(Regex("[ \\t\\n\\r\\u000C\\u000B]+"), " ")

    fun forVoice(voiceId: String, text: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
            .digest((voiceId + "|" + normalize(text)).toByteArray(Charsets.UTF_8))
        val sb = StringBuilder(64)
        for (b in digest) {
            val v = b.toInt() and 0xFF
            sb.append("0123456789abcdef"[v ushr 4]).append("0123456789abcdef"[v and 0xF])
        }
        return sb.toString().take(40)
    }
}

/** Bir dil etiketi için seçilmiş stüdyo ses çifti (kadın/erkek). */
@Serializable
data class RemoteVoicePair(val f: String, val m: String)

/**
 * Üretim hattının Storage'a yazdığı ses kataloğu (audio/v1/catalog.json).
 * voices anahtarları uygulamanın kullandığı BCP-47 etiketleridir (ör. "en-US", "pt-PT");
 * etiketin TTS sesi yoksa üretim en yakın varyantın sesini o etiket altına yazar.
 */
@Serializable
data class RemoteVoiceCatalog(
    val version: Int,
    val baseUrl: String,
    val voices: Map<String, RemoteVoicePair>
) {
    /** Etiket önce birebir eşleşir; yoksa aynı temel dilin ilk etiketi üzerinden çözülür (ör. pt-PT → pt-BR). */
    fun resolve(speechTag: String): Pair<String, RemoteVoicePair>? {
        voices[speechTag]?.let { return speechTag to it }
        val base = speechTag.substringBefore('-')
        return voices.entries.firstOrNull { it.key.substringBefore('-') == base }?.let { it.key to it.value }
    }
}

object RemoteVoiceCatalogParser {
    private val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }

    fun parse(raw: String): RemoteVoiceCatalog? =
        runCatching { json.decodeFromString<RemoteVoiceCatalog>(raw) }.getOrNull()
}

/**
 * MP3 dosya önbelleği: filesDir/audio_cache altında LRU (en eski önce atılır).
 * Katalog henüz yoksa/genişlemişse önbellek kural bozulmadan çalışmaya devam eder.
 */
class AudioCache(private val dir: File, private val maxBytes: Long = DEFAULT_MAX_BYTES) {

    init {
        runCatching { dir.mkdirs() }
    }

    fun fileFor(key: String): File = File(dir, "$key.mp3")

    fun get(key: String): File? = fileFor(key).takeIf { it.isFile }

    fun touch(key: String) {
        runCatching { get(key)?.setLastModified(System.currentTimeMillis()) }
    }

    fun put(key: String, bytes: ByteArray): File {
        val f = fileFor(key)
        runCatching {
            f.writeBytes(bytes)
            f.setLastModified(System.currentTimeMillis())
        }
        trim()
        return f
    }

    private fun trim() {
        val files = dir.listFiles()?.filter { it.isFile } ?: return
        var total = files.sumOf { it.length() }
        if (total <= maxBytes) return
        for (f in files.sortedBy { it.lastModified() }) {
            if (total <= maxBytes) break
            total -= f.length()
            runCatching { f.delete() }
        }
    }

    companion object {
        const val DEFAULT_MAX_BYTES: Long = 64L * 1024 * 1024
    }
}
