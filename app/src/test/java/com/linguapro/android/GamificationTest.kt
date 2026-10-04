package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class GamificationTest {

    // --- Seviye sistemi ---

    @Test
    fun levelThresholdsGrowAndAreConsistent() {
        assertEquals(1, LevelSystem.levelFor(0))
        assertEquals(1, LevelSystem.levelFor(99))
        assertEquals(2, LevelSystem.levelFor(100))
        assertEquals(2, LevelSystem.levelFor(224))
        assertEquals(3, LevelSystem.levelFor(225))
        // Eşikler kesin artan olmalı
        var prev = -1
        for (level in 1..30) {
            val need = LevelSystem.requiredTotalXp(level)
            assertTrue("seviye $level eşiği artmalı", need > prev)
            prev = need
        }
    }

    @Test
    fun progressToNextIsBounded() {
        for (xp in listOf(0, 50, 100, 777, 5000)) {
            val (inLevel, needed, percent) = LevelSystem.progressToNext(xp)
            assertTrue(inLevel >= 0)
            assertTrue(needed > 0)
            assertTrue(inLevel <= needed)
            assertTrue(percent in 0..100)
        }
    }

    // --- Günlük görevler ---

    @Test
    fun everyDayHasThreeQuestsWithRewards() {
        for (day in 20_000L..20_010L) {
            val quests = DailyQuests.questsFor(day)
            assertEquals(3, quests.size)
            assertEquals(3, quests.map { it.id }.toSet().size)
            quests.forEach {
                assertTrue(it.rewardXp > 0)
                assertTrue(it.target > 0)
                assertTrue(it.title.isNotBlank())
            }
        }
    }

    @Test
    fun rotatingQuestChangesAcrossDaysAndIsDeterministic() {
        val day1 = DailyQuests.questsFor(20_000L)[2]
        val day2 = DailyQuests.questsFor(20_001L)[2]
        assertTrue(day1.id != day2.id)
        assertEquals(day1, DailyQuests.questsFor(20_000L)[2])
    }

    // --- Avatar kodlaması ---

    @Test
    fun avatarConfigSurvivesEncodeDecodeRoundTrip() {
        val original = AvatarConfig(gender = 1, skin = 3, hairStyle = 2, hairColor = 4, eyeColor = 2, glasses = true, shirt = 3)
        assertEquals(original, AvatarConfig.decode(original.encode()))
    }

    @Test
    fun avatarDecodeIsSafeOnGarbageInput() {
        assertEquals(AvatarConfig(), AvatarConfig.decode(""))
        val fromGarbage = AvatarConfig.decode("x=9;;;g=7;t=-3;banana")
        assertTrue(fromGarbage.gender in 0..1)
        assertTrue(fromGarbage.skin in 0..3)
    }

    // --- Seri Dondurucu ---

    @Test
    fun streakFreezeConsumesOnlyOnExactOneMissedDay() {
        val today = LocalDate.of(2026, 10, 10)
        assertTrue(StreakFreezeLogic.shouldConsume(today.minusDays(2), today, 1))   // dün atlandı + dondurucu var
        assertFalse(StreakFreezeLogic.shouldConsume(today.minusDays(2), today, 0))  // dondurucu yok
        assertFalse(StreakFreezeLogic.shouldConsume(today.minusDays(1), today, 3))  // atlama yok
        assertFalse(StreakFreezeLogic.shouldConsume(today, today, 3))               // aynı gün
        assertFalse(StreakFreezeLogic.shouldConsume(today.minusDays(3), today, 3))  // 2+ gün atlandı: kurtarmaz
        assertFalse(StreakFreezeLogic.shouldConsume(null, today, 3))                // hiç çalışılmamış
    }
}
