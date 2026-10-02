package com.linguapro.android

/**
 * XP → seviye sistemi: her seviye bir öncekinden 25 XP daha fazla ister.
 * Seviye 2 için 100 XP, seviye 3 için +125, seviye 4 için +150...
 * Saf ve deterministik; lig tablosu ve profil aynı hesabı kullanır.
 */
object LevelSystem {

    private const val MAX_LEVEL = 200

    /** [level] seviyesine ulaşmak için gereken toplam XP (seviye 1 = 0). */
    fun requiredTotalXp(level: Int): Int {
        var need = 0
        var step = 100
        repeat((level - 1).coerceIn(0, MAX_LEVEL)) {
            need += step
            step += 25
        }
        return need
    }

    /** Toplam XP'nin karşılık geldiği seviye. */
    fun levelFor(totalXp: Int): Int {
        var level = 1
        while (level < MAX_LEVEL && totalXp >= requiredTotalXp(level + 1)) level++
        return level
    }

    /** Mevcut seviye içindeki ilerleme: (seviye içi XP, sonraki seviye için gereken, yüzde). */
    fun progressToNext(totalXp: Int): Triple<Int, Int, Int> {
        val level = levelFor(totalXp)
        val base = requiredTotalXp(level)
        val next = requiredTotalXp(level + 1)
        val inLevel = totalXp - base
        val needed = (next - base).coerceAtLeast(1)
        return Triple(inLevel, needed, (inLevel * 100 / needed).coerceIn(0, 100))
    }
}
