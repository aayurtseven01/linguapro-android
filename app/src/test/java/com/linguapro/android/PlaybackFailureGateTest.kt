package com.linguapro.android

import com.linguapro.android.audio.PlaybackFailureGate
import org.junit.Assert.*
import org.junit.Test

class PlaybackFailureGateTest {
    @Test fun multiplePlayerErrorsTriggerOnlyOneFallback() {
        val gate = PlaybackFailureGate()
        val request = gate.begin()
        assertTrue(gate.tryFail(request))
        assertFalse(gate.tryFail(request))
    }
    @Test fun stoppingPlaybackRejectsLateErrors() {
        val gate = PlaybackFailureGate()
        val request = gate.begin()
        gate.cancel()
        assertFalse(gate.isCurrent(request))
        assertFalse(gate.tryFail(request))
    }
    @Test fun aNewRequestRejectsThePreviousPlayersError() {
        val gate = PlaybackFailureGate()
        val old = gate.begin()
        val current = gate.begin()
        assertFalse(gate.tryFail(old))
        assertTrue(gate.tryFail(current))
    }
}
