package com.linguapro.android

import android.content.Context

/** Tek bir günlük görev tanımı. */
data class DailyQuest(
    val id: String,
    val metric: String,
    val title: String,
    val target: Int,
    val rewardXp: Int,
    val emoji: String
)

/** Ana ekran kartı için görev + ilerleme + ödül durumu. */
data class QuestUi(val quest: DailyQuest, val progress: Int, val claimed: Boolean)

/**
 * Günlük görevler: her gün 3 görev — 2'si sabit (ders ve XP), 1'i gün dönüşümlü.
 * Deterministiktir: aynı gün herkese aynı görevler gelir, gece yarısı yenilenir.
 */
object DailyQuests {

    private val rotating = listOf(
        DailyQuest("refresh", "refresh", "Günlük Tekrar'ı bitir", 1, 15, "🔄"),
        DailyQuest("words", "words", "Günün 5 Kelimesi'ni çalış", 1, 15, "📚"),
        DailyQuest("perfect", "perfect", "Bir dersi %90+ puanla bitir", 1, 20, "🎯"),
        DailyQuest("checkpoint", "checkpoint", "Bir Checkpoint geç", 1, 25, "🏁")
    )

    fun questsFor(epochDay: Long): List<DailyQuest> = listOf(
        DailyQuest("lessons", "lessons", "2 ders tamamla", 2, 15, "📖"),
        DailyQuest("xp", "xp", "30 XP kazan", 30, 15, "✦"),
        rotating[((epochDay % rotating.size + rotating.size) % rotating.size).toInt()]
    )
}

/** Görev ilerlemesi ve ödül alma durumu; kullanıcıya (uid) ve güne bağlı tutulur. */
class QuestProgressStore(context: Context, learnerKey: String) {
    private val prefs = context.applicationContext
        .getSharedPreferences("daily_quests_${learnerKey.ifBlank { "local" }}", Context.MODE_PRIVATE)

    fun progress(day: Long, metric: String): Int = prefs.getInt("d${day}_$metric", 0)

    fun add(day: Long, metric: String, amount: Int) {
        prefs.edit().putInt("d${day}_$metric", progress(day, metric) + amount).apply()
    }

    fun claimed(day: Long, questId: String): Boolean = prefs.getBoolean("d${day}_c_$questId", false)

    fun setClaimed(day: Long, questId: String) {
        prefs.edit().putBoolean("d${day}_c_$questId", true).apply()
    }
}
