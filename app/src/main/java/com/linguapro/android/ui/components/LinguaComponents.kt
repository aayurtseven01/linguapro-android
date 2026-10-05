package com.linguapro.android.ui.components

import com.linguapro.android.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
internal fun FeatureLine(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, index: Int = -1) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp)
            .then(if (index >= 0) Modifier.staggerIn(index) else Modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(44.dp).background(Gold.copy(alpha = 0.12f), RoundedCornerShape(14.dp)), contentAlignment = Alignment.Center) { Icon(icon, null, tint = Gold, modifier = Modifier.size(20.dp)) }
        Text(text, color = OnBg, fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp))
    }
}

@Composable
internal fun InfoCard(text: String) {
    Row(Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(20.dp)).border(1.dp, Muted.copy(alpha = 0.15f), RoundedCornerShape(20.dp)).padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Lightbulb, null, tint = Gold)
        Text(text, color = OnBgSoft, fontSize = 13.sp, lineHeight = 20.sp, modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
internal fun BackRow(title: String, onBack: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBack, modifier = Modifier.background(Panel, RoundedCornerShape(14.dp))) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Geri", tint = OnBg) }
        Text(title, color = OnBg, fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 12.dp))
    }
}

@Composable
internal fun PrimaryButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    // Shared action styling with a comfortable touch target.
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .pressScale()
            .shadow(4.dp, RoundedCornerShape(18.dp)),
        shape = RoundedCornerShape(18.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Gold,
            contentColor = Navy,
            disabledContainerColor = Panel2,
            disabledContentColor = Muted
        )
    ) {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.3.sp)
    }
}


