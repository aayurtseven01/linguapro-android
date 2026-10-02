package com.linguapro.android

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Handler
import android.os.Looper

/**
 * Uygulama genelindeki dokunma kliki: her gerçek dokunuşta (kaydırma değil)
 * AudioTrack ile sentezlenen çok kısa, yumuşak bir tık sesi çalar.
 * Ders ekranındaki 🔊 düğmesiyle aynı "sound_on" tercihine bağlıdır.
 */
object UiClickSound {

    private const val SAMPLE_RATE = 44100
    private var lastPlayAt = 0L

    /** 38 ms'lik, hızlı sönümlenen ince tık (1.3 kHz). */
    private val clickPcm: ShortArray by lazy {
        val sampleCount = SAMPLE_RATE * 38 / 1000
        ShortArray(sampleCount) { i ->
            val t = i.toDouble() / SAMPLE_RATE
            val envelope = kotlin.math.exp(-11.0 * i / sampleCount)
            (kotlin.math.sin(2.0 * Math.PI * 1300.0 * t) * envelope * 0.22 * Short.MAX_VALUE).toInt()
                .coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
        }
    }

    fun play(context: Context) {
        val now = System.currentTimeMillis()
        if (now - lastPlayAt < 70) return // hızlı art arda dokunuşlarda ses yığılmasın
        val prefs = context.getSharedPreferences("lingua_course", Context.MODE_PRIVATE)
        if (!prefs.getBoolean("sound_on", true)) return
        lastPlayAt = now
        runCatching {
            val track = AudioTrack(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build(),
                AudioFormat.Builder()
                    .setSampleRate(SAMPLE_RATE)
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .build(),
                clickPcm.size * 2,
                AudioTrack.MODE_STATIC,
                AudioManager.AUDIO_SESSION_ID_GENERATE
            )
            track.write(clickPcm, 0, clickPcm.size)
            track.play()
            Handler(Looper.getMainLooper()).postDelayed({ runCatching { track.release() } }, 300L)
        }
    }
}
