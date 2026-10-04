package com.linguapro.android.ui.components

import com.linguapro.android.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun FeatureLine(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(38.dp).background(Panel2, CircleShape), contentAlignment = Alignment.Center) { Icon(icon, null, tint = Gold, modifier = Modifier.size(20.dp)) }
        Text(text, color = OnBg, fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp))
    }
}

@Composable
internal fun InfoCard(text: String) {
    Row(Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(16.dp)).padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Lightbulb, null, tint = Gold)
        Text(text, color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
internal fun BackRow(title: String, onBack: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Geri", tint = OnBg) }
        Text(title, color = OnBg, fontSize = 19.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
    }
}

@Composable
internal fun PrimaryButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    // Premium gece CTA: ışıklı lime zemin, koyu metin, yumuşak neon gölge
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .shadow(14.dp, RoundedCornerShape(16.dp), ambientColor = Color(0x59C6FF4A), spotColor = Color(0x66C6FF4A)),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Gold,
            contentColor = Navy,
            disabledContainerColor = Color(0x4DC6FF4A),
            disabledContentColor = Color(0x991A0E2E)
        )
    ) {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.3.sp)
    }
}

