package com.linguapro.android.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

/** Lig tablosu satırı / genel kullanıcı kartı. */
data class BoardEntry(
    val uid: String = "",
    val username: String = "",
    val displayName: String = "",
    val level: Int = 1,
    val totalXp: Int = 0,
    val avatar: String = "",
    val weeklyXp: Int = 0,
    val weekKey: String = ""
)

/** Bülten (akış) öğesi. */
data class FeedItem(
    val id: String = "",
    val uid: String = "",
    val username: String = "",
    val avatar: String = "",
    val text: String = "",
    val createdAt: Long = 0L
)

/**
 * Sosyal katman: lig tablosu, kullanıcı arama, arkadaşlar ve bülten akışı.
 * Tüm çağrılar geri çağırımlıdır; Firebase yoksa Türkçe hata mesajı döner.
 */
class SocialRepository {

    private fun db(): FirebaseFirestore? = runCatching { FirebaseFirestore.getInstance() }.getOrNull()

    /** Lig tablosundaki kendi kaydını oluşturur/günceller (profil, seviye, XP, avatar). */
    fun upsertBoard(uid: String, username: String, displayName: String, level: Int, totalXp: Int, avatar: String, done: (String?) -> Unit) {
        val d = db() ?: return done("Çevrimiçi özellikler için Firebase gerekli.")
        val data = mapOf(
            "uid" to uid,
            "username" to username.lowercase().trim(),
            "displayName" to displayName.take(40),
            "avatar" to avatar.take(120)
        )
        d.collection("leaderboard").document(uid).set(data, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { done(null) }
            .addOnFailureListener { done(it.localizedMessage ?: "Lig kaydı güncellenemedi.") }
    }

    fun loadIdentity(uid: String, done: (BoardEntry?) -> Unit) {
        val d = db() ?: return done(null)
        d.collection("leaderboard").document(uid).get()
            .addOnSuccessListener { doc ->
                val entry = doc.toBoard()
                if (entry != null) done(entry)
                else d.collection("usernames").whereEqualTo("uid", uid).limit(1).get()
                    .addOnSuccessListener { names -> done(names.documents.firstOrNull()?.let { BoardEntry(uid = uid, username = it.id) }) }
                    .addOnFailureListener { done(null) }
            }.addOnFailureListener { done(null) }
    }

    /** En yüksek doğrulanmış XP'li 50 kullanıcı. */
    fun fetchTop(done: (List<BoardEntry>, String?) -> Unit) {
        val d = db() ?: return done(emptyList(), "Çevrimiçi özellikler için Firebase gerekli.")
        d.collection("leaderboard").whereEqualTo("weekKey", com.linguapro.android.WeeklyLeague.weekKey()).orderBy("verifiedWeekXp", Query.Direction.DESCENDING).limit(50).get()
            .addOnSuccessListener { snap -> done(snap.documents.mapNotNull { it.toBoard() }, null) }
            .addOnFailureListener { done(emptyList(), it.localizedMessage ?: "Lig tablosu yüklenemedi.") }
    }

    /** Kullanıcı adına göre arama (tam eşleşme). */
    fun search(username: String, done: (List<BoardEntry>, String?) -> Unit) {
        val d = db() ?: return done(emptyList(), "Çevrimiçi özellikler için Firebase gerekli.")
        d.collection("leaderboard").whereEqualTo("username", username.lowercase().trim()).limit(10).get()
            .addOnSuccessListener { snap -> done(snap.documents.mapNotNull { it.toBoard() }, null) }
            .addOnFailureListener { done(emptyList(), it.localizedMessage ?: "Arama yapılamadı.") }
    }

    /**
     * Kullanıcı adı rezervasyonu: usernames/{ad} belgesi "ilk alan kazanır" kuralıyla yazılır.
     * Ad alınmışsa kurallar güncellemeyi reddeder ve Türkçe mesaj döner.
     */
    fun claimUsername(uid: String, username: String, done: (String?) -> Unit) {
        val d = db() ?: return done("Çevrimiçi özellikler için Firebase gerekli.")
        val key = username.lowercase().trim()
        if (!key.matches(Regex("[a-z0-9_.]{3,20}"))) return done("3–20 karakter kullan: a-z, rakam, nokta ve alt çizgi.")
        val ref = d.collection("usernames").document(key)
        d.runTransaction { tx ->
            val existing = tx.get(ref)
            if (existing.exists() && existing.getString("uid") != uid) throw IllegalStateException("USERNAME_TAKEN")
            if (!existing.exists()) tx.set(ref, mapOf("uid" to uid))
            null
        }
            .addOnSuccessListener { done(null) }
            .addOnFailureListener {
                android.util.Log.e("LinguaSocial", "claimUsername basarisiz", it)
                done(if (it.message?.contains("USERNAME_TAKEN") == true) "Bu kullanıcı adı alınmış." else "Ad kaydedilemedi: ${it.message ?: "bilinmeyen hata"}")
            }
    }

    fun addFriend(uid: String, friend: BoardEntry, done: (String?) -> Unit) {
        val d = db() ?: return done("Çevrimiçi özellikler için Firebase gerekli.")
        val data = mapOf(
            "uid" to friend.uid,
            "username" to friend.username,
            "avatar" to friend.avatar,
            "addedAt" to System.currentTimeMillis()
        )
        d.collection("users").document(uid).collection("friends").document(friend.uid).set(data)
            .addOnSuccessListener { done(null) }
            .addOnFailureListener { done(it.localizedMessage ?: "Arkadaş eklenemedi.") }
    }

    fun removeFriend(uid: String, friendUid: String, done: (String?) -> Unit) {
        val d = db() ?: return done("Çevrimiçi özellikler için Firebase gerekli.")
        d.collection("users").document(uid).collection("friends").document(friendUid).delete()
            .addOnSuccessListener { done(null) }
            .addOnFailureListener { done(it.localizedMessage ?: "Arkadaş çıkarılamadı.") }
    }

    fun loadFriends(uid: String, done: (List<BoardEntry>, String?) -> Unit) {
        val d = db() ?: return done(emptyList(), "Çevrimiçi özellikler için Firebase gerekli.")
        d.collection("users").document(uid).collection("friends").get()
            .addOnSuccessListener { snap ->
                done(snap.documents.map {
                    BoardEntry(
                        uid = it.getString("uid") ?: it.id,
                        username = it.getString("username") ?: "",
                        avatar = it.getString("avatar") ?: ""
                    )
                }, null)
            }
            .addOnFailureListener { done(emptyList(), it.localizedMessage ?: "Arkadaş listesi yüklenemedi.") }
    }

    /** Bültene bir başarı gönderir (kendi adına). */
    fun postActivity(uid: String, username: String, avatar: String, text: String, done: (String?) -> Unit) {
        val d = db() ?: return done("Çevrimiçi özellikler için Firebase gerekli.")
        val data = mapOf(
            "uid" to uid,
            "username" to username.lowercase().trim(),
            "avatar" to avatar.take(120),
            "text" to text.take(140),
            "createdAt" to System.currentTimeMillis()
        )
        // Ters-zaman kimlik: varsayılan belge sıralaması "en yeni önce" olur; dizin gerekmeden
        // limit(20) her zaman kullanıcının EN YENİ paylaşımlarını döndürür.
        val reverseTimeId = "%019d-%s".format(Long.MAX_VALUE - System.currentTimeMillis(), uid.take(8))
        d.collection("activity").document(reverseTimeId).set(data)
            .addOnSuccessListener { done(null) }
            .addOnFailureListener { done(it.localizedMessage ?: "Paylaşım gönderilemedi.") }
    }

    /**
     * Bülten: kendi + arkadaş kimliklerinin son paylaşımları.
     * Bileşik dizin gerektirmemek için kişi başına ayrı sorgu atılır ve istemcide birleştirilir.
     */
    fun loadFeed(memberUids: List<String>, done: (List<FeedItem>, String?) -> Unit) {
        val d = db() ?: return done(emptyList(), "Çevrimiçi özellikler için Firebase gerekli.")
        val targets = memberUids.filter { it.isNotBlank() }.distinct().take(20)
        if (targets.isEmpty()) return done(emptyList(), null)
        val collected = mutableListOf<FeedItem>()
        var remaining = targets.size
        var firstError: String? = null
        targets.forEach { member ->
            d.collection("activity").whereEqualTo("uid", member).limit(20).get()
                .addOnSuccessListener { snap ->
                    synchronized(collected) {
                        snap.documents.forEach { doc ->
                            collected += FeedItem(
                                id = doc.id,
                                uid = doc.getString("uid") ?: "",
                                username = doc.getString("username") ?: "",
                                avatar = doc.getString("avatar") ?: "",
                                text = doc.getString("text") ?: "",
                                createdAt = doc.getLong("createdAt") ?: 0L
                            )
                        }
                    }
                    if (--remaining == 0) done(collected.sortedByDescending { it.createdAt }.take(50), firstError)
                }
                .addOnFailureListener {
                    if (firstError == null) firstError = it.localizedMessage
                    if (--remaining == 0) done(collected.sortedByDescending { it.createdAt }.take(50), firstError)
                }
        }
    }

    private fun com.google.firebase.firestore.DocumentSnapshot.toBoard(): BoardEntry? {
        val u = getString("uid") ?: id
        return BoardEntry(
            uid = u,
            username = getString("username") ?: return null,
            displayName = getString("displayName") ?: "",
            level = com.linguapro.android.LevelSystem.levelFor((getLong("verifiedXp") ?: 0L).toInt()),
            totalXp = (getLong("verifiedXp") ?: 0L).toInt(),
            avatar = getString("avatar") ?: "",
            weeklyXp = (getLong("verifiedWeekXp") ?: 0L).toInt(),
            weekKey = getString("weekKey") ?: ""
        )
    }
}
