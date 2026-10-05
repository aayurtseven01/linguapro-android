package com.linguapro.android.audio

/** Prevent duplicate error callbacks and stale playback requests from triggering TTS. */
internal class PlaybackFailureGate {
    private var generation = 0L
    private var failed = false
    @Synchronized fun begin(): Long { generation++; failed = false; return generation }
    @Synchronized fun cancel() { generation++; failed = true }
    @Synchronized fun isCurrent(request: Long): Boolean = request == generation
    @Synchronized fun tryFail(request: Long): Boolean {
        if (request != generation || failed) return false
        failed = true
        return true
    }
}
