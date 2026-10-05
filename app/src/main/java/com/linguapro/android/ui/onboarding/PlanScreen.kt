package com.linguapro.android.ui.onboarding

import com.linguapro.android.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import com.linguapro.android.ui.components.*
import androidx.compose.runtime.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun PlanScreen(plan: String, onPlan: (String) -> Unit, onBack: () -> Unit, onStart: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
        BackRow("Çalışma planın", onBack)
        Spacer(Modifier.height(18.dp))
        Text("Her gün küçük bir adım.", color = OnBg, fontSize = 29.sp, fontWeight = FontWeight.ExtraBold)
        Text("Kendine uygun bir hedef seç. Daha sonra ayarlardan değiştirebilirsin.", color = OnBgSoft, lineHeight = 21.sp, modifier = Modifier.padding(top = 10.dp, bottom = 22.dp))
        listOf(Triple("5", "Rahat başlangıç", "Günde 5 dakika • alışkanlık kazan"),
            Triple("10", "Dengeli ilerleme", "Günde 10 dakika • öğren ve pekiştir"),
            Triple("20", "Yoğun çalışma", "Günde 20 dakika • daha fazla pratik")).forEach { (minutes, title, detail) ->
            Surface(onClick = { onPlan(minutes) }, color = if (plan == minutes) Gold.copy(alpha = 0.10f) else Panel,
                border = BorderStroke(if (plan == minutes) 2.dp else 1.dp, if (plan == minutes) Gold else Panel2),
                shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp).pressScale()) {
                Row(Modifier.padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(if (plan == minutes) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked, null, tint = if (plan == minutes) Gold else Muted)
                    Column(Modifier.weight(1f).padding(start = 14.dp)) {
                        Text(title, color = OnBg, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(detail, color = Muted, fontSize = 13.sp, lineHeight = 19.sp, modifier = Modifier.padding(top = 5.dp))
                    }
                    Surface(color = Panel2, shape = RoundedCornerShape(14.dp), modifier = Modifier.padding(start = 10.dp)) {
                        Column(Modifier.padding(horizontal = 12.dp, vertical = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(minutes, color = Gold, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Text("dk", color = Muted, fontSize = 11.sp)
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        FeatureLine(Icons.AutoMirrored.Filled.MenuBook, "Seviyene uygun bir öğrenme yolu")
        FeatureLine(Icons.Default.Style, "Aralıklı tekrar ile kelime pratiği")
        FeatureLine(Icons.Default.Mic, "Dinleme, konuşma ve yazma etkinlikleri")
        Spacer(Modifier.height(20.dp))
        PrimaryButton("Seviyemi belirle", onStart)
        Text("Kısa test başlangıç seviyeni tahmin eder. Bu bir resmî dil sertifikası değildir.", color = OnBgSoft, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 12.dp))
        Spacer(Modifier.height(24.dp))
    }
}


