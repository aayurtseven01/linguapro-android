package com.linguapro.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun PlacementResultScreen(summary: PlacementSummary, onContinue: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(18.dp))
        Box(Modifier.size(76.dp).background(Color(0xFFF0F3F8), CircleShape), contentAlignment = Alignment.Center) {
            Icon(Icons.Default.CheckCircle, null, tint = Color(0xFF0A6ED1), modifier = Modifier.size(42.dp))
        }
        Text("Seviye tahminin hazır", color = Color(0xFFFFFFFF), fontSize = 25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 18.dp))
        Text("Başlangıç öğrenme yolunu yanıtlarına göre seçtik.", color = Color(0xFFDFF3FF), textAlign = TextAlign.Center, fontSize = 14.sp, lineHeight = 20.sp, modifier = Modifier.padding(top = 8.dp))
        Spacer(Modifier.height(20.dp))
        Surface(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("TAHMİNİ CEFR SEVİYEN", color = Color(0xFF5B6475), fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
                Text(summary.level, color = Color(0xFF0A6ED1), fontSize = 48.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(top = 4.dp))
                Text("${summary.correct} / ${summary.answered} doğru • ${summary.accuracyPercent}% yanıt doğruluğu", color = Color(0xFF1A1D29), fontSize = 13.sp, textAlign = TextAlign.Center)
            }
        }
        Spacer(Modifier.height(20.dp))
        Text("Beceri görünümü", color = Color(0xFFFFFFFF), fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Start))
        Text("Yalnızca testte örneklenen beceriler gösterilir.", color = Color(0xFFDFF3FF), fontSize = 12.sp, modifier = Modifier.align(Alignment.Start).padding(top = 3.dp, bottom = 8.dp))
        Skill.values().forEach { skill ->
            val mastery = summary.skillMastery[skill.name.lowercase(Locale.ROOT)]
            if (mastery != null) {
                Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(skillLabel(skill), color = Color(0xFFFFFFFF), fontSize = 13.sp, modifier = Modifier.width(92.dp))
                    LinearProgressIndicator(progress = { mastery / 100f }, modifier = Modifier.weight(1f).height(7.dp), color = Color(0xFF0A6ED1), trackColor = Color(0x55FFFFFF))
                    Text("  $mastery%", color = Color(0xFFDFF3FF), fontSize = 12.sp)
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        Surface(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
            Text("Bu kısa test bir başlangıç tahminidir; resmî yeterlilik belgesi değildir. Derslerdeki ilerlemenle seviyeni daha sonra yeniden değerlendirebilirsin.", color = Color(0xFF5B6475), fontSize = 12.sp, lineHeight = 18.sp, modifier = Modifier.padding(14.dp))
        }
        Spacer(Modifier.height(18.dp))
        Button(onClick = onContinue, modifier = Modifier.fillMaxWidth().height(54.dp), shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A6ED1), contentColor = Color(0xFFFFFFFF))) {
            Text("Öğrenme yoluma başla", fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(22.dp))
    }
}
