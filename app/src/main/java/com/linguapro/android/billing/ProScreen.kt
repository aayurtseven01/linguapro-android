package com.linguapro.android.billing

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linguapro.android.*
import com.linguapro.android.ui.components.*
import com.linguapro.android.ui.components.breathe
import com.linguapro.android.ui.components.popIn
import com.linguapro.android.ui.components.pressScale
import com.linguapro.android.ui.components.staggerIn

@Composable
fun ProScreen(viewModel: ProViewModel, onBack: () -> Unit, onPractice: () -> Unit) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) { viewModel.load() }
    ProScreenContent(state, onBack, onPractice, onBuy = { offer -> context.findActivity()?.let { viewModel.buy(it, offer) } }, onRestore = { viewModel.restore() })
}

@Composable
internal fun ProScreenContent(state: ProBillingState, onBack: () -> Unit, onPractice: () -> Unit, onBuy: (ProOffer) -> Unit, onRestore: () -> Unit) {
    val context = LocalContext.current
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(22.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BackRow("Lingua Pro", onBack)
        Text("LINGUA PRO", color = Color(0xFF6DE8C1), fontSize = 12.sp, letterSpacing = 3.sp, fontWeight = FontWeight.Bold)
        Text("Zorlandığın konulara\nodaklan.", color = Color.White, fontSize = 34.sp, lineHeight = 41.sp, fontWeight = FontWeight.ExtraBold)
        Text("Sana özel pratik: hata defterindeki soruları ve güçlendirebileceğin becerileri kısa oturumlarda bir araya getir.", color = Color(0xFFC3CEE0), lineHeight = 22.sp)
        Card(shape = RoundedCornerShape(26.dp), colors = CardDefaults.cardColors(containerColor = Panel), modifier = Modifier.fillMaxWidth().popIn(delayMillis = 250)) {
            Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("✓ Hata geçmişine göre kişisel pratik", color = Color.White)
                Text("✓ Zayıf becerilere öncelik veren oturumlar", color = Color.White)
                Text("✓ Öğrendiğin dil ve seviyeye uygun sorular", color = Color.White)
            }
        }
        if (state.hasPro) {
            Button(onClick = onPractice, modifier = Modifier.fillMaxWidth().pressScale()) { Text("Kişisel pratiğime başla") }
            Text("Pro aboneliğin aktif.", color = Color(0xFF6DE8C1))
        } else {
            if (state.loading) CircularProgressIndicator()
            state.offers.forEachIndexed { offerIndex, offer ->
                OutlinedCard(border = BorderStroke(1.dp, Color(0xFF6DE8C1)), colors = CardDefaults.cardColors(containerColor = Color(0xFF152238)), modifier = Modifier.staggerIn(offerIndex)) {
                    Column(Modifier.fillMaxWidth().padding(18.dp)) {
                        Text(offer.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(offer.terms, color = Color(0xFFC3CEE0), modifier = Modifier.padding(vertical = 10.dp))
                        Button(enabled = !state.purchasing && !state.loading, onClick = { onBuy(offer) }, modifier = Modifier.fillMaxWidth().pressScale().then(if (!state.purchasing && !state.loading) Modifier.breathe(1f, 1.02f) else Modifier)) { Text("Google Play ile abone ol") }
                    }
                }
            }
        }
        state.message?.let { Text(it, color = Color(0xFFC3CEE0), lineHeight = 20.sp) }
        if (state.purchasing) { LinearProgressIndicator(Modifier.fillMaxWidth()); Text("Aboneliğin doğrulanıyor…", color = Color.White) }
        Text("Abonelik, iptal edilmediği sürece yenilenir. Kesin fiyat ve koşulları onaylamadan önce Google Play ekranında görebilirsin.", color = Color(0xFFA3B2C8), fontSize = 12.sp, lineHeight = 18.sp)
        OutlinedButton(onClick = onRestore, enabled = !state.loading && !state.purchasing, modifier = Modifier.fillMaxWidth()) { Text("Satın alımları geri yükle") }
        TextButton(onClick = {
            runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/account/subscriptions?package=com.linguapro.android"))) }
        }) { Text("Aboneliğimi yönet") }
        TextButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) { Text("Ücretsiz öğrenmeye devam et") }
        Spacer(Modifier.height(16.dp))
    }
}

private tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

