package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AvatarConfigTest {
    @Test fun legacyCodeWithoutNewFieldsDecodesWithDefaults() {
        val old = AvatarConfig.decode("g=1;t=2;ss=3;sr=4;gz=2;gl=1;k=3")
        assertEquals(1, old.gender)
        assertEquals(2, old.skin)
        assertEquals(3, old.hairStyle)
        assertEquals(4, old.hairColor)
        assertEquals(2, old.eyeColor)
        assertTrue(old.glasses)
        assertEquals(3, old.shirt)
        assertEquals(0, old.hat)
        assertEquals(0, old.facialHair)
    }

    @Test fun encodeDecodeRoundTripPreservesEveryField() {
        val cfg = AvatarConfig(
            gender = 1, skin = 3, hairStyle = 2, hairColor = 4, eyeColor = 1,
            glasses = true, shirt = 4, hat = 3, facialHair = 2
        )
        assertEquals(cfg, AvatarConfig.decode(cfg.encode()))
    }

    @Test fun outOfRangeValuesAreClampedSafely() {
        val cfg = AvatarConfig.decode("g=9;t=99;ss=99;sr=99;gz=99;gl=5;k=99;sp=99;sb=99")
        assertEquals(1, cfg.gender)
        assertEquals(3, cfg.skin)
        assertEquals(4, cfg.hairStyle)
        assertEquals(4, cfg.hairColor)
        assertEquals(2, cfg.eyeColor)
        assertFalse(cfg.glasses) // yalnızca gl=1 gözlük açar; 5 == 1 değildir
        assertEquals(4, cfg.shirt)
        assertEquals(3, cfg.hat)
        assertEquals(2, cfg.facialHair)
    }

    @Test fun blankAndGarbageCodesFallBackToDefaultAvatar() {
        val blank = AvatarConfig.decode("")
        assertFalse(blank.glasses)
        assertEquals(0, blank.hat)
        assertEquals(0, blank.facialHair)
        val garbage = AvatarConfig.decode("???;=;x=1")
        assertEquals(AvatarConfig(), garbage)
    }
}
