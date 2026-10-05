package com.linguapro.android.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

/** Basit HTTP GET sonucu: 200 → baytlar; durum kodu null ise ağ hatasıdır. */
internal sealed class HttpResult {
    class Ok(val bytes: ByteArray, val status: Int) : HttpResult()
    class Fail(val status: Int?, val error: Throwable?) : HttpResult()
}

internal fun httpGet(url: String, timeoutMs: Int = 5000): HttpResult = try {
    val conn = URL(url).openConnection() as HttpURLConnection
    conn.connectTimeout = timeoutMs
    conn.readTimeout = timeoutMs
    conn.instanceFollowRedirects = true
    try {
        val status = conn.responseCode
        if (status == 200) HttpResult.Ok(conn.inputStream.readBytes(), status) else HttpResult.Fail(status, null)
    } finally {
        conn.disconnect()
    }
} catch (t: Throwable) {
    HttpResult.Fail(null, t)
}

/**
 * Ses kataloğu deposu (uygulama genelinde tekil):
 * catalog.json bellek + SharedPreferences önbelleğinde tutulur, 24 saatte bir tazelenir.
 * Katalog yüklenene/dağıtılana kadar peek() null döner → uygulama cihaz TTS'sine düşer.
 */
object RemoteVoiceCatalogStore {
    private const val PREFS = "remote_voice_catalog"
    private const val KEY_JSON = "catalog_json"
    private const val KEY_FETCHED_AT = "catalog_fetched_at"
    private const val STALE_MS = 24L * 60 * 60 * 1000
    private const val RETRY_GAP_MS = 60L * 1000

    // Firebase'in varsayılan kova adı sürüme göre değişir (appspot.com / firebasestorage.app) — ikisi de denenir.
    private val CATALOG_URLS = listOf(
        "https://storage.googleapis.com/linguapro-ad8c7.appspot.com/audio/v1/catalog.json",
        "https://storage.googleapis.com/linguapro-ad8c7.firebasestorage.app/audio/v1/catalog.json"
    )

    @Volatile
    private var cached: RemoteVoiceCatalog? = null

    @Volatile
    private var lastAttempt = 0L

    fun peek(context: Context): RemoteVoiceCatalog? {
        cached?.let { return it }
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val parsed = prefs.getString(KEY_JSON, null)?.let(RemoteVoiceCatalogParser::parse)
        if (parsed != null) cached = parsed
        return parsed
    }

    /** Yerleşik sıra: bellek → disk → ağ (yalnız durgunsa). Ana iş parçacığını bloklamaz. */
    suspend fun fetchIfStale(context: Context) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val fetchedAt = prefs.getLong(KEY_FETCHED_AT, 0L)
        if (cached != null && System.currentTimeMillis() - fetchedAt < STALE_MS) return
        if (System.currentTimeMillis() - lastAttempt < RETRY_GAP_MS) return
        lastAttempt = System.currentTimeMillis()
        val raw = withContext(Dispatchers.IO) {
            CATALOG_URLS.firstNotNullOfOrNull { url ->
                (httpGet(url, 5000) as? HttpResult.Ok)?.let { String(it.bytes, Charsets.UTF_8) }
            }
        }
        if (raw != null) {
            RemoteVoiceCatalogParser.parse(raw)?.let { catalog ->
                prefs.edit()
                    .putString(KEY_JSON, raw)
                    .putLong(KEY_FETCHED_AT, System.currentTimeMillis())
                    .apply()
                cached = catalog
            }
        }
    }
}

/**
 * Uzak ses çalar — Duolingo tarzı yürüme sırası:
 * yerel önbellek → CDN (Firebase Storage) → cihaz TTS (fallback).
 * Her ekranda kendi örneği oluşturulur; katalog ve dosya önbelleği uygulama genelinde paylaşılır.
 * 404 dönen metinler oturum boyunca negatif önbelleğe alınır (tekrar ağ bekletmez).
 */
class RemoteSpeechPlayer(
    private val context: Context,
    private val scope: CoroutineScope,
    private val catalogProvider: (Context) -> RemoteVoiceCatalog? = RemoteVoiceCatalogStore::peek
) {
    private val cache = AudioCache(File(context.filesDir, "audio_cache"))
    private val missing = java.util.Collections.synchronizedSet(HashSet<String>())
    private val inFlight = java.util.Collections.synchronizedSet(HashSet<String>())
    private var job: Job? = null
    private val failures = PlaybackFailureGate()

    @Volatile
    private var player: MediaPlayer? = null

    /** Ekran açılırken çağrılır: katalogu arka planda indirir/kurar. */
    fun prefetchCatalog() {
        scope.launch { RemoteVoiceCatalogStore.fetchIfStale(context) }
    }

    /** Katalogu bekleyip indirir (LaunchedEffect içinden çağrılır); ardından [isRemoteAvailable] güncel döner. */
    suspend fun warmCatalog() {
        RemoteVoiceCatalogStore.fetchIfStale(context)
    }

    /** Bu konuşma etiketi için stüdyo sesi kullanılabilir mi (cihaz TTS'si olmadan da ses düğmesi açılır). */
    fun isRemoteAvailable(speechTag: String): Boolean =
        catalogProvider(context)?.resolve(speechTag) != null

    /** Dokunma anında anında çalması için metinleri arka planda indirir (yalnız önbellekte yoksa). */
    fun prefetch(speechTag: String, items: List<Pair<String, Boolean>>) {
        val catalog = catalogProvider(context) ?: return
        scope.launch(Dispatchers.IO) {
            items.forEach { (text, female) ->
                val resolved = catalog.resolve(speechTag) ?: return@forEach
                val voiceId = if (female) resolved.second.f else resolved.second.m
                val key = AudioKey.forVoice(voiceId, text)
                if (missing.contains(key) || cache.get(key) != null) return@forEach
                if (!inFlight.add(key)) return@forEach
                try {
                    when (val r = httpGet(urlFor(catalog, resolved.first, key))) {
                        is HttpResult.Ok -> cache.put(key, r.bytes)
                        is HttpResult.Fail -> if (r.status == 404) missing.add(key)
                    }
                } finally {
                    inFlight.remove(key)
                }
            }
        }
    }

    /**
     * Metni en iyi kalitede seslendirir. Uzak ses yoksa (katalog yok / ağ yok / 404)
     * [fallback] cihaz TTS'siyle çağrılır — mevcut davranışın aynısı korunur.
     */
    fun speak(
        speechTag: String,
        text: String,
        female: Boolean,
        rate: Float = 1f,
        fallback: () -> Unit
    ) {
        stop()
        val catalog = catalogProvider(context)
        val resolved = catalog?.resolve(speechTag)
        if (catalog == null || resolved == null) {
            fallback(); return
        }
        val voiceId = if (female) resolved.second.f else resolved.second.m
        val key = AudioKey.forVoice(voiceId, text)
        if (missing.contains(key)) {
            fallback(); return
        }
        val request = failures.begin()
        val playbackFailed: () -> Unit = {
            if (failures.tryFail(request)) {
                cache.remove(key)
                scope.launch(Dispatchers.Main.immediate) {
                    if (failures.isCurrent(request)) fallback()
                }
            }
        }
        val cachedFile = cache.get(key)
        if (cachedFile != null) cache.touch(key)
        job = scope.launch(Dispatchers.IO) {
            // Önbellekte varsa çal; yoksa CDN'den indir (indirme sırasında iptal edilirse yalnız önbelleğe yazılır).
            val file = cachedFile ?: if (inFlight.add(key)) {
                try {
                    when (val r = httpGet(urlFor(catalog, resolved.first, key))) {
                        is HttpResult.Ok -> cache.put(key, r.bytes)
                        is HttpResult.Fail -> if (r.status == 404) missing.add(key)
                    }
                } finally {
                    inFlight.remove(key)
                }
                cache.get(key)
            } else {
                cache.get(key)
            }
            when {
                file != null && isActive -> playFile(file, rate, request, playbackFailed)
                isActive -> withContext(Dispatchers.Main) { fallback() }
            }
        }
    }

    fun stop() {
        failures.cancel()
        job?.cancel()
        job = null
        stopPlayback()
    }

    fun release() {
        stop()
    }

    private fun urlFor(catalog: RemoteVoiceCatalog, tag: String, key: String): String =
        "${catalog.baseUrl}/$tag/$key.mp3"

    @Synchronized
    private fun playFile(file: File, rate: Float, request: Long, onFailure: () -> Unit) {
        if (!failures.isCurrent(request)) return
        stopPlayback()
        runCatching {
            val media = MediaPlayer()
            player = media // Own it before prepare: a corrupt file must not leak the player.
            media.apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .build()
                )
                setDataSource(file.absolutePath)
                prepare()
                setOnCompletionListener { mp ->
                    runCatching { mp.release() }
                    if (player === mp) player = null
                }
                setOnErrorListener { mp, _, _ ->
                    runCatching { mp.release() }
                    if (player === mp) player = null
                    onFailure()
                    true
                }
                player = this
                start()
                if (rate != 1f) {
                    runCatching {
                        playbackParams = playbackParams.setSpeed(rate)
                        if (!isPlaying) start()
                    }
                }
            }
        }.onFailure { stopPlayback(); onFailure() }
    }

    @Synchronized
    private fun stopPlayback() {
        player?.let { p ->
            runCatching { p.stop() }
            runCatching { p.release() }
        }
        player = null
    }
}
