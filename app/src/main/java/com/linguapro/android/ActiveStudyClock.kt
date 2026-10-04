package com.linguapro.android

/** Monotonic elapsed time; background time and the completion screen do not count. */
class ActiveStudyClock(initialElapsedMillis: Long = 0L) {
    private var accumulated = initialElapsedMillis.coerceAtLeast(0L)
    private var resumedAt: Long? = null
    fun resume(now: Long) { if (resumedAt == null) resumedAt = now }
    fun pause(now: Long) { resumedAt?.let { accumulated += (now - it).coerceAtLeast(0L) }; resumedAt = null }
    fun elapsedMillis(now: Long): Long = accumulated + (resumedAt?.let { (now - it).coerceAtLeast(0L) } ?: 0L)
}
