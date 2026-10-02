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
fun PlacementResultScreen(summary: PlacementSummary, onChooseLevel: (String) -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(18.dp))
        Box(Modifier.size(76.dp).background(Color(0xFF342457), CircleShape), contentAlignment = Alignment.Center) {
            Icon(Icons.Default.CheckCircle, null, tint = Color(0xFFC6FF4A), modifier = Modifier.size(42.dp))
        }
        Text("Seviye tahminin hazır", color = Color(0xFFFFFFFF), fontSize = 25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 18.dp))
        Text("Başlangıç öğrenme yolunu yanıtlarına göre seçtik.", color = Color(0xFFCBBDE8), textAlign = TextAlign.Center, fontSize = 14.sp, lineHeight = 20.sp, modifier = Modifier.padding(top = 8.dp))
        Spacer(Modifier.height(20.dp))
        Surface(color = Color(0xFF281A4A), shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("TAHMİNİ CEFR SEVİYEN", color = Color(0xFFA99BC9), fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
                Text(summary.level, color = Color(0xFFC6FF4A), fontSize = 48.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(top = 4.dp))
                Text("${summary.correct} / ${summary.answered} doğru • ${summary.accuracyPercent}% yanıt doğruluğu", color = Color(0xFFF5F1FF), fontSize = 13.sp, textAlign = TextAlign.Center)
            }
        }
        Spacer(Modifier.height(20.dp))
        Text("Beceri görünümü", color = Color(0xFFFFFFFF), fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Start))
        Text("Yalnızca testte örneklenen beceriler gösterilir.", color = Color(0xFFCBBDE8), fontSize = 12.sp, modifier = Modifier.align(Alignment.Start).padding(top = 3.dp, bottom = 8.dp))
        Skill.values().forEach { skill ->
            val mastery = summary.skillMastery[skill.name.lowercase(Locale.ROOT)]
            if (mastery != null) {
                Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(skillLabel(skill), color = Color(0xFFFFFFFF), fontSize = 13.sp, modifier = Modifier.width(92.dp))
                    LinearProgressIndicator(progress = { mastery / 100f }, modifier = Modifier.weight(1f).height(7.dp), color = Color(0xFFC6FF4A), trackColor = Color(0x55FFFFFF))
                    Text("  $mastery%", color = Color(0xFFCBBDE8), fontSize = 12.sp)
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        Surface(color = Color(0xFF281A4A), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
            Text("Bu kısa test bir başlangıç tahminidir; resmî yeterlilik belgesi değildir. Derslerdeki ilerlemenle seviyeni daha sonra yeniden değerlendirebilirsin.", color = Color(0xFFA99BC9), fontSize = 12.sp, lineHeight = 18.sp, modifier = Modifier.padding(14.dp))
        }
        Spacer(Modifier.height(18.dp))
        // Kullanıcı seçsin: belirlenen seviyeden devam ya da A1'den temelden başlangıç
        if (summary.level != "A1") {
            Text(
                "Testte seviyen ${summary.level} olarak belirlendi. İstersen eğitimine doğrudan ${summary.level} seviyesinden başla, istersen A1'den tekrar ederek sağlam bir temelle ${summary.level}'e doğru ilerle.",
                color = Color(0xFFCBBDE8), fontSize = 13.sp, lineHeight = 19.sp, textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(14.dp))
        }
        Button(
            onClick = { onChooseLevel(summary.level) },
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC6FF4A), contentColor = Color(0xFF1A0E2E))
        ) {
            Text(if (summary.level == "A1") "Öğrenme yoluma başla" else "${summary.level} seviyesinden başla", fontWeight = FontWeight.Bold)
        }
        if (summary.level != "A1") {
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = { onChooseLevel("A1") },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF342457), contentColor = Color(0xFFF5F1FF))
            ) {
                Text("A1'den temelden başla", fontWeight = FontWeight.Bold)
            }
        }
        Spacer(Modifier.height(22.dp))
    }
}
