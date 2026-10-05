package com.linguapro.android

import com.linguapro.android.audio.AudioCache
import com.linguapro.android.audio.AudioKey
import com.linguapro.android.audio.RemoteVoiceCatalogParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Uzak ses çekirdeği testleri.
 * anahtarSabitDeger, tools/tts/generate.mjs ile aynı kuralı (sha256("voiceId|metin")
 * → ilk 40 hex) kilitler: iki taraf da değişirse bu test kırmızıya düşer.
 */
class RemoteAudioTest {

    @Test
    fun normalizeUclardakiBosluklariAtarVeDizileriTekler() {
        assertEquals("Hello world", AudioKey.normalize("  Hello   world \n"))
        assertEquals("Merhaba", AudioKey.normalize(" Merhaba\t "))
        assertEquals("", AudioKey.normalize("   "))
        // Idempotent: bir kez normalize edilmiş metin değişmez
        assertEquals("a b c", AudioKey.normalize(AudioKey.normalize(" a  b   c ")))
    }

    @Test
    fun anahtarDeterministikVe40KucukHex() {
        val k1 = AudioKey.forVoice("en-US-Neural2-A", "Hello, I'm Elif.")
        val k2 = AudioKey.forVoice("en-US-Neural2-A", "Hello, I'm Elif.")
        assertEquals(k1, k2)
        assertEquals(40, k1.length)
        assertTrue(k1.matches(Regex("[0-9a-f]{40}")))
    }

    @Test
    fun anahtarSesVeMetneDuyarli() {
        val base = AudioKey.forVoice("ja-JP-Neural2-B", "こんにちは")
        assertNotEquals(base, AudioKey.forVoice("ja-JP-Neural2-C", "こんにちは"))
        assertNotEquals(base, AudioKey.forVoice("ja-JP-Neural2-B", "ありがとう"))
        assertEquals(base, AudioKey.forVoice("ja-JP-Neural2-B", " こんにちは  "))
    }

    @Test
    fun anahtarSabitDeger() {
        // python: hashlib.sha256(b"en-US-Neural2-A|Hello, I'm Elif.").hexdigest()[:40]
        assertEquals(
            "a907e1da01e6d1d53734b6572da6fe586df59ac1",
            AudioKey.forVoice("en-US-Neural2-A", "Hello, I'm Elif.")
        )
        assertEquals(
            "d6ab93b34f797d6a4ec3a59c8926bcde25377900",
            AudioKey.forVoice("ja-JP-Neural2-B", "こんにちは")
        )
    }

    @Test
    fun katalogCozumleme() {
        val raw = """
            {"version":1,"baseUrl":"https://storage.googleapis.com/bucket/audio/v1",
             "voices":{"en-US":{"f":"en-US-Neural2-A","m":"en-US-Neural2-D"},
                       "en-GB":{"f":"en-GB-Neural2-A","m":"en-GB-Neural2-B"},
                       "pt-BR":{"f":"pt-BR-Neural2-A","m":"pt-BR-Neural2-B"}}}
        """.trimIndent()
        val catalog = RemoteVoiceCatalogParser.parse(raw)
        assertNotNull(catalog)
        // Birebir etiket
        val gb = catalog!!.resolve("en-GB")
        assertEquals("en-GB", gb?.first)
        assertEquals("en-GB-Neural2-B", gb?.second?.m)
        // Temel dil yedeği: pt-PT → pt-BR
        val pt = catalog.resolve("pt-PT")
        assertEquals("pt-BR", pt?.first)
        assertEquals("pt-BR-Neural2-A", pt?.second?.f)
        // Bilinmeyen dil → null (cihaz TTS'sine düş)
        assertNull(catalog.resolve("xx-YY"))
    }

    @Test
    fun katalogBozukJsonNullDoner() {
        assertNull(RemoteVoiceCatalogParser.parse("{bu json değil"))
        assertNull(RemoteVoiceCatalogParser.parse(""))
    }

    @Test
    fun onbellekYazOkuVeLruAtar() {
        val dir = createTempDir("audio_cache_test")
        try {
            val cache = AudioCache(dir, maxBytes = 10)
            val f1 = cache.put("key1", "12345".toByteArray())
            assertEquals(5L, f1.length())
            assertNotNull(cache.get("key1"))
            assertTrue(cache.get("key1")!!.length() == 5L)
            // En eski dosya atılır (LRU): key1'i eski, key2/key3'ü yeni yap
            cache.get("key1")!!.setLastModified(1_000L)
            cache.put("key2", "12345".toByteArray())
            cache.get("key2")!!.setLastModified(2_000L)
            cache.put("key3", "12345".toByteArray())
            assertNull(cache.get("key1"))
            assertNotNull(cache.get("key2"))
            assertNotNull(cache.get("key3"))
        } finally {
            dir.deleteRecursively()
        }
    }

    private fun createTempDir(prefix: String): File {
        val f = File.createTempFile(prefix, null)
        f.delete()
        f.mkdirs()
        return f
    }

    private fun assertNotEquals(a: String?, b: String?) {
        assertTrue("beklenen farklı değerler: $a vs $b", a != b)
    }
}
