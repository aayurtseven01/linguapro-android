package com.linguapro.android.billing

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.*
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.functions.FirebaseFunctions
import dagger.hilt.android.qualifiers.ApplicationContext
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.tasks.await

data class ProOffer(
    val id: String, val title: String, val price: String, val terms: String,
    val details: ProductDetails, val offerToken: String
)

data class VerifiedSubscription(val uid: String, val active: Boolean, val expiresAt: Long, val verifiedAt: Long) {
    fun allowsAccess(uid: String?, now: Long): Boolean = uid == this.uid && active &&
        now < expiresAt && now >= verifiedAt && now - verifiedAt <= 24 * 60 * 60 * 1000L
}

data class ProBillingState(
    val offers: List<ProOffer> = emptyList(), val loading: Boolean = false,
    val purchasing: Boolean = false, val message: String? = null,
    val subscription: VerifiedSubscription? = null, val now: Long = System.currentTimeMillis(), val uid: String? = null
) {
    val hasPro: Boolean get() = subscription?.allowsAccess(uid, now) == true
}

/** Play handles prices/payments; only the authenticated server entitlement grants access. */
@Singleton
class ProBillingRepository @Inject constructor(@ApplicationContext private val context: Context) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private val mutableState = MutableStateFlow(ProBillingState())
    val state: StateFlow<ProBillingState> = mutableState
    private val connection = Mutex()
    private val verification = Mutex()
    private val restoration = Mutex()
    private var entitlementListener: ListenerRegistration? = null
    private val client = BillingClient.newBuilder(context)
        .enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build())
        .enableAutoServiceReconnection()
        .setListener { result, purchases ->
            mutableState.update { it.copy(purchasing = false) }
            if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                purchases.orEmpty().forEach(::verifyPurchase)
            } else if (result.responseCode != BillingClient.BillingResponseCode.USER_CANCELED) {
                mutableState.update { it.copy(message = "Satın alma tamamlanamadı. Daha sonra tekrar dene.") }
            }
        }.build()

    init {
        if (FirebaseApp.getApps(context).isNotEmpty()) FirebaseAuth.getInstance().addAuthStateListener { auth ->
            entitlementListener?.remove()
            val uid = auth.currentUser?.uid
            mutableState.update { it.copy(uid = uid, subscription = null, purchasing = false, message = null) }
            if (uid != null) {
                scope.launch { restore(silent = true) }
                entitlementListener = FirebaseFirestore.getInstance().collection("users").document(uid)
                    .collection("private").document("entitlement").addSnapshotListener { snapshot, error ->
                        if (mutableState.value.uid != uid) return@addSnapshotListener
                        val subscription = if (error == null && snapshot?.exists() == true) VerifiedSubscription(
                            uid, snapshot.getBoolean("active") == true,
                            snapshot.getTimestamp("expiresAt")?.toDate()?.time ?: 0L,
                            snapshot.getTimestamp("verifiedAt")?.toDate()?.time ?: 0L
                        ) else null
                        mutableState.update { it.copy(subscription = subscription, now = System.currentTimeMillis()) }
                    }
            }
        }
        scope.launch {
            while (isActive) { delay(60_000); mutableState.update { it.copy(now = System.currentTimeMillis()) } }
        }
    }

    fun canUsePro(): Boolean {
        val uid = if (FirebaseApp.getApps(context).isNotEmpty()) FirebaseAuth.getInstance().currentUser?.uid else null
        return mutableState.value.subscription?.allowsAccess(uid, System.currentTimeMillis()) == true
    }

    private suspend fun connect() = connection.withLock {
        if (client.isReady) return@withLock
        suspendCancellableCoroutine<Unit> { continuation ->
            client.startConnection(object : BillingClientStateListener {
                override fun onBillingSetupFinished(result: BillingResult) {
                    if (!continuation.isActive) return
                    if (result.responseCode == BillingClient.BillingResponseCode.OK) continuation.resume(Unit)
                    else continuation.resumeWithException(IllegalStateException("STORE_UNAVAILABLE"))
                }
                override fun onBillingServiceDisconnected() = Unit
            })
        }
    }

    suspend fun loadOffers() {
        if (mutableState.value.loading) return
        mutableState.update { it.copy(loading = true, message = null) }
        try {
            if (mutableState.value.uid == null) throw IllegalStateException("SIGN_IN_REQUIRED")
            val readiness = FirebaseFunctions.getInstance().getHttpsCallable("getCommerceStatus").call().await().data as? Map<*, *>
            if (readiness?.get("ready") != true) {
                mutableState.update { it.copy(offers = emptyList(), message = "Pro yakında. Şimdilik ücretsiz derslerine devam edebilirsin.") }
                return
            }
            val products = (readiness["products"] as? List<*>)?.filterIsInstance<String>().orEmpty()
            if (products.isEmpty()) throw IllegalStateException("PRODUCTS_UNAVAILABLE")
            connect()
            val params = QueryProductDetailsParams.newBuilder().setProductList(products.map {
                QueryProductDetailsParams.Product.newBuilder().setProductId(it).setProductType(BillingClient.ProductType.SUBS).build()
            }).build()
            val details = suspendCancellableCoroutine<List<ProductDetails>> { continuation ->
                client.queryProductDetailsAsync(params) { result, queried ->
                    if (!continuation.isActive) return@queryProductDetailsAsync
                    if (result.responseCode == BillingClient.BillingResponseCode.OK) continuation.resume(queried.productDetailsList)
                    else continuation.resumeWithException(IllegalStateException("PRODUCTS_UNAVAILABLE"))
                }
            }
            val offers = details.flatMap { product ->
                // Show ordinary base plans; do not advertise an offer/trial the user is not eligible for.
                product.subscriptionOfferDetails.orEmpty().filter { it.offerId == null }.mapNotNull { offer ->
                    val phases = offer.pricingPhases.pricingPhaseList
                    val last = phases.lastOrNull() ?: return@mapNotNull null
                    ProOffer("${product.productId}:${offer.basePlanId}", product.name, last.formattedPrice,
                        phases.joinToString(" → ") { phase -> "${phase.formattedPrice} / ${periodLabel(phase.billingPeriod)}" }, product, offer.offerToken)
                }
            }
            mutableState.update { it.copy(offers = offers, message = if (offers.isEmpty()) "Şu anda uygun bir Pro planı bulunamadı." else null) }
        } catch (error: Exception) {
            if (error is CancellationException) throw error
            mutableState.update { it.copy(offers = emptyList(), message = "Pro şu anda kullanılamıyor. Ücretsiz derslerine devam edebilir veya daha sonra tekrar deneyebilirsin.") }
        } finally {
            mutableState.update { it.copy(loading = false) }
        }
    }

    fun purchase(activity: Activity, offer: ProOffer) {
        val uid = mutableState.value.uid ?: return
        if (FirebaseAuth.getInstance().currentUser?.uid != uid) return
        if (!client.isReady || mutableState.value.purchasing) return
        val product = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(offer.details).setOfferToken(offer.offerToken).build()
        val params = BillingFlowParams.newBuilder().setProductDetailsParamsList(listOf(product)).setObfuscatedAccountId(accountHash(uid)).build()
        mutableState.update { it.copy(purchasing = true, message = null) }
        val result = client.launchBillingFlow(activity, params)
        if (result.responseCode != BillingClient.BillingResponseCode.OK) mutableState.update {
            it.copy(purchasing = false, message = "Google Play satın alma ekranı açılamadı.")
        }
    }

    suspend fun restore(silent: Boolean = false) = restoration.withLock {
        if (mutableState.value.uid == null) return@withLock
        if (!silent) mutableState.update { it.copy(loading = true, message = null) }
        try {
            connect()
            val purchases = suspendCancellableCoroutine<List<Purchase>> { continuation ->
                client.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.SUBS).build()) { result, list ->
                    if (!continuation.isActive) return@queryPurchasesAsync
                    if (result.responseCode == BillingClient.BillingResponseCode.OK) continuation.resume(list)
                    else continuation.resumeWithException(IllegalStateException("RESTORE_FAILED"))
                }
            }
            if (purchases.isEmpty() && !silent) mutableState.update { it.copy(message = "Bu Google Play hesabında geri yüklenecek abonelik bulunamadı.") }
            purchases.forEach(::verifyPurchase)
        } catch (error: Exception) {
            if (error is CancellationException) throw error
            if (!silent) mutableState.update { it.copy(message = "Satın alımlar geri yüklenemedi. İnternet bağlantını kontrol edip tekrar dene.") }
        } finally { if (!silent) mutableState.update { it.copy(loading = false) } }
    }

    private fun verifyPurchase(purchase: Purchase) {
        val uid = mutableState.value.uid ?: return
        if (purchase.purchaseState == Purchase.PurchaseState.PENDING) {
            mutableState.update { it.copy(message = "Ödeme beklemede. Google Play onayladıktan sonra Pro açılacak.") }; return
        }
        if (purchase.purchaseState != Purchase.PurchaseState.PURCHASED) return
        scope.launch { verification.withLock {
            if (mutableState.value.uid != uid) return@withLock
            mutableState.update { it.copy(purchasing = true) }
            try {
                FirebaseFunctions.getInstance().getHttpsCallable("verifyPlaySubscription")
                    .call(mapOf("purchaseToken" to purchase.purchaseToken)).await()
                if (mutableState.value.uid == uid) mutableState.update { it.copy(message = "Abonelik durumu doğrulandı.") }
            } catch (error: Exception) {
                if (error is CancellationException) throw error
                if (mutableState.value.uid == uid) mutableState.update {
                    it.copy(message = "Abonelik henüz doğrulanamadı. Tekrar ödeme yapmadan satın alımları geri yüklemeyi dene.")
                }
            } finally { if (mutableState.value.uid == uid) mutableState.update { it.copy(purchasing = false) } }
        } }
    }

    companion object {
        fun accountHash(uid: String): String = MessageDigest.getInstance("SHA-256").digest(uid.toByteArray(Charsets.UTF_8)).joinToString("") { "%02x".format(it) }
        fun periodLabel(period: String): String = when (period) { "P1M" -> "ay"; "P1Y" -> "yıl"; "P1W" -> "hafta"; "P3M" -> "3 ay"; "P6M" -> "6 ay"; else -> period }
    }
}
