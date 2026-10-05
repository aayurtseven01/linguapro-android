package com.linguapro.android.data

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.EmailAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

/** Firebase-backed account/profile boundary. UI never talks to Firebase SDKs directly. */
class FirebaseAccountRepository(context: Context) {
    private val actionScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private val appContext = context.applicationContext
    val isConfigured: Boolean get() = FirebaseApp.getApps(appContext).isNotEmpty()

    private fun auth(): FirebaseAuth = FirebaseAuth.getInstance()
    private fun store(): FirebaseFirestore = FirebaseFirestore.getInstance()

    fun currentUser(): FirebaseUser? = if (isConfigured) auth().currentUser else null

    fun register(name: String, email: String, password: String, callback: (AccountResult) -> Unit) {
        if (!isConfigured) {
            callback(AccountResult.Error("Firebase yapılandırması henüz eklenmedi. Firebase projesi bağlandığında gerçek kayıt açılacak."))
            return
        }
        auth().createUserWithEmailAndPassword(email.trim(), password)
            .addOnSuccessListener { result ->
                val user = result.user
                if (user == null) {
                    callback(AccountResult.Error("Hesap oluşturuldu ancak kullanıcı oturumu alınamadı. Tekrar giriş yapmayı dene."))
                    return@addOnSuccessListener
                }
                val profileUpdate = UserProfileChangeRequest.Builder().setDisplayName(name.trim()).build()
                user.updateProfile(profileUpdate).addOnCompleteListener {
                    val profile = mapOf(
                        "uid" to user.uid,
                        "displayName" to name.trim(),
                        "email" to email.trim().lowercase(),
                        "cefrLevel" to "A1",
                        "completedLessons" to 0,
                        "completedByLevelA1" to 0,
                        "completedByLevelA2" to 0,
                        "completedByLevelB1" to 0,
                        "completedByLevelB2" to 0,
                        "completedByLevelC1" to 0,
                        "completedByLevelC2" to 0,
                        "skillMastery" to mapOf("listening" to 0, "reading" to 0, "speaking" to 0, "writing" to 0, "grammar" to 0, "vocabulary" to 0),
                        "onboardingComplete" to false,
                        "createdAt" to FieldValue.serverTimestamp(),
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                    store().collection("users").document(user.uid).set(profile)
                        .addOnSuccessListener { callback(AccountResult.Success(user.uid, name.trim(), email.trim())) }
                        .addOnFailureListener { error -> callback(AccountResult.Error("Hesap açıldı fakat profil kaydedilemedi: ${safeMessage(error)}", user.uid, name.trim(), email.trim())) }
                }
            }
            .addOnFailureListener { error -> callback(AccountResult.Error(authMessage(error))) }
    }

    fun signIn(email: String, password: String, callback: (AccountResult) -> Unit) {
        if (!isConfigured) {
            callback(AccountResult.Error("Firebase bağlantısı yapılandırılmamış."))
            return
        }
        auth().signInWithEmailAndPassword(email.trim(), password)
            .addOnSuccessListener { result ->
                val user = result.user
                if (user == null) callback(AccountResult.Error("Oturum başlatılamadı."))
                else callback(AccountResult.Success(user.uid, user.displayName.orEmpty(), user.email.orEmpty()))
            }
            .addOnFailureListener { error -> callback(AccountResult.Error(authMessage(error))) }
    }

    fun sendPasswordReset(email: String, callback: (String?) -> Unit) {
        if (!isConfigured) {
            callback("Firebase bağlantısı yapılandırılmamış.")
            return
        }
        auth().sendPasswordResetEmail(email.trim())
            .addOnSuccessListener { callback(null) }
            .addOnFailureListener { callback(authMessage(it)) }
    }

    fun signOut() { if (isConfigured) auth().signOut() }

    /** Authenticate again BEFORE deleting any data. Every failed deletion stops the chain. */
    fun deleteAccount(uid: String, password: String, callback: (String?) -> Unit) {
        if (!isConfigured) { callback("Firebase yapılandırılmamış."); return }
        val user = auth().currentUser
        if (user == null || user.uid != uid || user.email.isNullOrBlank()) {
            callback("Oturum doğrulanamadı. Yeniden giriş yapıp tekrar dene.")
            return
        }
        if (password.isBlank()) { callback("Silmek için mevcut şifreni gir."); return }
        actionScope.launch {
            try {
                user.reauthenticate(EmailAuthProvider.getCredential(user.email!!, password)).await()
            } catch (error: Exception) {
                callback(authMessage(error))
                return@launch
            }
            try {
                user.getIdToken(true).await()
                val response = FirebaseFunctions.getInstance().getHttpsCallable("deleteAccount").call().await()
                check((response.data as? Map<*, *>)?.get("deleted") == true)
                callback(null)
            } catch (error: Exception) {
                callback("Silme tamamlanamadı. Bazı veriler silinmiş olabilir; aynı işlemi yeniden deneyebilirsin. " + safeMessage(error))
            }
        }
    }

    fun loadProfile(uid: String, callback: (AccountProfile?) -> Unit) {
        if (!isConfigured) { callback(null); return }
        store().collection("users").document(uid).get()
            .addOnSuccessListener { snapshot ->
                if (!snapshot.exists()) callback(null)
                else callback(AccountProfile(
                    displayName = snapshot.getString("displayName").orEmpty(),
                    email = snapshot.getString("email").orEmpty(),
                    cefrLevel = snapshot.getString("cefrLevel") ?: "A1",
                    completedLessons = (snapshot.getLong("completedLessons") ?: 0L).toInt().coerceAtLeast(0),
                    completedByLevel = CEFR_LEVELS.associateWith { level ->
                        (snapshot.getLong("completedByLevel$level") ?: 0L).toInt().coerceAtLeast(0)
                    },
                    onboardingComplete = snapshot.getBoolean("onboardingComplete") ?: false
                ))
            }
            .addOnFailureListener { callback(null) }
    }

    fun savePlacement(uid: String, level: String, skillMastery: Map<String, Int>, callback: (String?) -> Unit) {
        store().collection("users").document(uid).update(
            mapOf("cefrLevel" to level, "skillMastery" to skillMastery, "onboardingComplete" to true, "updatedAt" to FieldValue.serverTimestamp())
        ).addOnSuccessListener { callback(null) }.addOnFailureListener { callback(safeMessage(it)) }
    }

    /** Atomic, retry-safe upload. Attempts and unique course completions have separate ids. */
    fun recordLesson(
        uid: String,
        lessonId: String,
        score: Int?,
        countsTowardCourse: Boolean = true,
        eventId: String = UUID.randomUUID().toString(),
        clientCompletedAtEpochMillis: Long? = null,
        callback: (String?) -> Unit
    ) {
        if (!isConfigured || currentUser()?.uid != uid) {
            callback("İlerlemeyi eşitlemek için hesabınla giriş yap."); return
        }
        if (lessonId.isBlank() || '/' in lessonId || eventId.isBlank() || '/' in eventId) {
            callback("Ders kaydı geçersiz."); return
        }
        val profile = store().collection("users").document(uid)
        val attempt = profile.collection("lessonEvents").document(eventId)
        val completion = profile.collection("lessonCompletions").document(lessonId)
        store().runTransaction { transaction ->
            val existingAttempt = transaction.get(attempt)
            if (existingAttempt.exists()) return@runTransaction null
            val firstCompletion = countsTowardCourse && !transaction.get(completion).exists()
            val event = mutableMapOf<String, Any>("lessonId" to lessonId, "completedAt" to FieldValue.serverTimestamp())
            score?.let { event["score"] = it.coerceIn(0, 100) }
            // Client study time is history metadata, never the trusted reward timestamp.
            clientCompletedAtEpochMillis?.takeIf { it in 0L..253402300799999L }?.let {
                event["clientCompletedAtEpochMillis"] = it
            }
            transaction.set(attempt, event)
            val updates = mutableMapOf<String, Any>(
                "lastStudiedAt" to FieldValue.serverTimestamp(),
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (firstCompletion) {
                transaction.set(completion, event)
                updates["completedLessons"] = FieldValue.increment(1)
                lessonId.substringBefore('-').takeIf { it in CEFR_LEVELS }?.let {
                    updates["completedByLevel$it"] = FieldValue.increment(1)
                }
            }
            transaction.update(profile, updates)
            null
        }.addOnSuccessListener { callback(null) }
            .addOnFailureListener { callback(safeMessage(it)) }
    }

    private companion object {
        val CEFR_LEVELS = listOf("A1", "A2", "B1", "B2", "C1", "C2")
    }

    private fun authMessage(error: Throwable): String = when ((error as? FirebaseAuthException)?.errorCode) {
        "ERROR_EMAIL_ALREADY_IN_USE" -> "Bu e-posta ile bir hesap zaten var. Giriş yapmayı dene."
        "ERROR_INVALID_EMAIL" -> "E-posta adresini kontrol et."
        "ERROR_WEAK_PASSWORD" -> "Şifre en az 6 karakter olmalı."
        "ERROR_INVALID_CREDENTIAL", "ERROR_WRONG_PASSWORD", "ERROR_USER_NOT_FOUND" -> "E-posta veya şifre doğru değil."
        "ERROR_NETWORK_REQUEST_FAILED" -> "Bağlantı kurulamadı. İnternetini kontrol edip tekrar dene."
        else -> safeMessage(error)
    }

    private fun safeMessage(error: Throwable): String = error.localizedMessage?.take(240) ?: "Beklenmeyen bir hata oluştu."
}

data class AccountProfile(
    val displayName: String,
    val email: String,
    val cefrLevel: String,
    val completedLessons: Int,
    val completedByLevel: Map<String, Int>,
    val onboardingComplete: Boolean
)

data class AccountResult(
    val uid: String? = null,
    val displayName: String = "",
    val email: String = "",
    val error: String? = null
) {
    val isSuccess: Boolean get() = error == null && uid != null

    companion object {
        fun Success(uid: String, name: String, email: String) = AccountResult(uid, name, email)
        fun Error(message: String, uid: String? = null, name: String = "", email: String = "") = AccountResult(uid, name, email, message)
    }
}


