package com.linguapro.android

import android.content.Context
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Elmas cüzdanı + patika sandık talepleri. Kullanıcıya (uid) bağlı yerel depodur;
 * kazanım kaynakları: ders (+2, %90+ puanda +4), Checkpoint geçişi (+10),
 * günlük görev (+5), patika sandığı (+20), seviye atlama (+15).
 */
class GemStore(context: Context, learnerKey: String) {
    private val prefs = context.applicationContext
        .getSharedPreferences("gems_v1_${learnerKey.ifBlank { "local" }}", Context.MODE_PRIVATE)

    fun gems(): Int = prefs.getInt("gems", 0)

    fun add(amount: Int): Int {
        val value = (gems() + amount).coerceAtLeast(0)
        prefs.edit().putInt("gems", value).apply()
        return value
    }

    /** Yeterli bakiye varsa düşer ve true döner; yetmiyorsa hiçbir şey değişmez. */
    fun spend(amount: Int): Boolean {
        if (gems() < amount) return false
        prefs.edit().putInt("gems", gems() - amount).apply()
        return true
    }

    fun claimChest(unitId: String): Boolean {
        if (prefs.getBoolean("chest_$unitId", false)) return false
        prefs.edit().putBoolean("chest_$unitId", true).apply()
        return true
    }

    fun claimedChests(): Set<String> =
        prefs.all.keys.filter { it.startsWith("chest_") }.map { it.removePrefix("chest_") }.toSet()
}

/** Seri Dondurucu karar mantığı — saf ve ayrı test edilebilir. */
object StreakFreezeLogic {
    /**
     * Tam BİR gün atlandıysa (son çalışma = dünden önceki gün) ve dondurucu varsa:
     * seri korunur, bir dondurucu harcanır. Aynı gün/dün çalışıldıysa ya da
     * 2+ gün atlandıysa dondurucu devreye girmez.
     */
    fun shouldConsume(prior: LocalDate?, today: LocalDate, freezes: Int): Boolean =
        prior != null && ChronoUnit.DAYS.between(prior, today) == 2L && freezes > 0
}
