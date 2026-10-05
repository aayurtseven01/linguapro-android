package com.linguapro.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal val LinguaTypography = Typography(
    headlineLarge = TextStyle(fontSize = 32.sp, lineHeight = 39.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.8).sp),
    headlineMedium = TextStyle(fontSize = 27.sp, lineHeight = 34.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp),
    titleLarge = TextStyle(fontSize = 22.sp, lineHeight = 29.sp, fontWeight = FontWeight.SemiBold),
    titleMedium = TextStyle(fontSize = 17.sp, lineHeight = 24.sp, fontWeight = FontWeight.SemiBold),
    bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 21.sp),
    bodySmall = TextStyle(fontSize = 12.sp, lineHeight = 18.sp),
    labelLarge = TextStyle(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.SemiBold),
    labelMedium = TextStyle(fontSize = 12.sp, lineHeight = 17.sp, fontWeight = FontWeight.SemiBold)
)

internal val LinguaShapes = Shapes(
    small = RoundedCornerShape(12.dp), medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp), extraLarge = RoundedCornerShape(30.dp)
)

@Composable
internal fun DashboardHero(title: String, level: String, language: String, completed: Int, total: Int, onStart: () -> Unit) {
    Surface(shape = RoundedCornerShape(28.dp), color = Panel, modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.background(Brush.linearGradient(listOf(Panel2, Panel))).padding(22.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(color = Gold.copy(alpha = 0.13f), shape = RoundedCornerShape(10.dp)) {
                    Text("$language · $level", color = Gold, style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp))
                }
                Spacer(Modifier.weight(1f))
                Icon(Icons.Default.AutoAwesome, null, tint = Gold, modifier = Modifier.size(22.dp))
            }
            Text("Bugün bir adım daha.", color = OnBgSoft, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 20.dp))
            Text(title, color = OnBg, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(top = 5.dp))
            Spacer(Modifier.height(20.dp))
            LinearProgressIndicator(progress = { if (total > 0) (completed.toFloat() / total).coerceIn(0f, 1f) else 0f },
                color = Gold, trackColor = Navy, modifier = Modifier.fillMaxWidth().height(6.dp))
            Text("${completed.coerceIn(0, total.coerceAtLeast(0))} / $total ders tamamlandı", color = Muted,
                style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 8.dp))
            Button(onClick = onStart, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().padding(top = 18.dp).heightIn(min = 54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Gold, contentColor = Navy)) {
                Text(if (completed >= total && total > 0) "Dersleri tekrar et" else "Öğrenmeye devam et", fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(10.dp))
                Icon(Icons.AutoMirrored.Filled.ArrowForward, null, modifier = Modifier.size(18.dp))
            }
        }
    }
}

@Composable
internal fun DashboardMetric(icon: androidx.compose.ui.graphics.vector.ImageVector, value: String, label: String, modifier: Modifier = Modifier) {
    Surface(color = Panel, shape = RoundedCornerShape(20.dp), modifier = modifier) {
        Column(Modifier.padding(14.dp)) {
            Icon(icon, null, tint = Gold, modifier = Modifier.size(21.dp))
            Text(value, color = OnBg, fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(top = 10.dp))
            Text(label, color = Muted, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 2.dp))
        }
    }
}

@Composable
internal fun ProfileAction(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, onClick: () -> Unit, enabled: Boolean = true, destructive: Boolean = false) {
    Surface(onClick = onClick, enabled = enabled, color = Panel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.heightIn(min = 62.dp).padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = if (destructive) PinkAccent else Gold, modifier = Modifier.size(22.dp))
            Text(title, color = if (!enabled) Muted else if (destructive) PinkAccent else OnBg,
                style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f).padding(horizontal = 14.dp))
            Icon(Icons.Default.ChevronRight, null, tint = Muted, modifier = Modifier.size(18.dp))
        }
    }
}
