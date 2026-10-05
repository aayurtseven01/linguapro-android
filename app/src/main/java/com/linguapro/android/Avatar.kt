package com.linguapro.android

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linguapro.android.ui.components.PopOnChange
import com.linguapro.android.ui.components.pressScale

/** Avatar yapılandırması: cinsiyet, ten, saç stili/rengi, göz rengi, gözlük, kıyafet. */
data class AvatarConfig(
    val gender: Int = 0,      // 0 kadın, 1 erkek
    val skin: Int = 1,        // 0-3 ten tonu
    val hairStyle: Int = 0,   // 0 kısa, 1 uzun, 2 topuz, 3 kıvırcık, 4 yok
    val hairColor: Int = 0,   // 0-4
    val eyeColor: Int = 0,    // 0-2
    val glasses: Boolean = false,
    val shirt: Int = 0        // 0-4
) {
    fun encode(): String =
        "g=$gender;t=$skin;ss=$hairStyle;sr=$hairColor;gz=$eyeColor;gl=${if (glasses) 1 else 0};k=$shirt"

    companion object {
        fun decode(code: String): AvatarConfig {
            if (code.isBlank()) return AvatarConfig()
            val map = code.split(';').mapNotNull {
                val p = it.split('=')
                if (p.size == 2) p[0] to (p[1].toIntOrNull() ?: 0) else null
            }.toMap()
            return AvatarConfig(
                gender = (map["g"] ?: 0).coerceIn(0, 1),
                skin = (map["t"] ?: 1).coerceIn(0, 3),
                hairStyle = (map["ss"] ?: 0).coerceIn(0, 4),
                hairColor = (map["sr"] ?: 0).coerceIn(0, 4),
                eyeColor = (map["gz"] ?: 0).coerceIn(0, 2),
                glasses = (map["gl"] ?: 0) == 1,
                shirt = (map["k"] ?: 0).coerceIn(0, 4)
            )
        }
    }
}

internal val AvatarSkinTones = listOf(Color(0xFFFFE0C2), Color(0xFFF2C49B), Color(0xFFC98D5E), Color(0xFF8D5A3A))
internal val AvatarHairColors = listOf(Color(0xFF2B2119), Color(0xFF5C4027), Color(0xFFB4863C), Color(0xFF8C8C94), Color(0xFFB3466E))
internal val AvatarEyeColors = listOf(Color(0xFF4A3426), Color(0xFF2E6E4E), Color(0xFF2C5E9E))
internal val AvatarShirtColors = listOf(Color(0xFFC6FF4A), Color(0xFFFF5CA8), Color(0xFF7DD3FC), Color(0xFFB791FF), Color(0xFFFFD166))

/** Parametrik çizilen avatar: hiç görsel varlık kullanmaz, her boyutta keskindir. */
@Composable
fun AvatarView(config: AvatarConfig, size: Dp, modifier: Modifier = Modifier) {
    Canvas(modifier.size(size)) {
        val w = this.size.width
        val skin = AvatarSkinTones[config.skin]
        val hair = AvatarHairColors[config.hairColor]
        val dark = Color(0xFF241A14)

        // Gövde (kıyafet) — omuz yayı
        drawArc(
            color = AvatarShirtColors[config.shirt],
            startAngle = 180f, sweepAngle = 180f, useCenter = true,
            topLeft = Offset(w * 0.14f, w * 0.72f), size = Size(w * 0.72f, w * 0.56f)
        )
        // Boyun
        drawRect(color = skin, topLeft = Offset(w * 0.44f, w * 0.58f), size = Size(w * 0.12f, w * 0.2f))
        // Kulaklar
        drawCircle(color = skin, radius = w * 0.045f, center = Offset(w * 0.235f, w * 0.42f))
        drawCircle(color = skin, radius = w * 0.045f, center = Offset(w * 0.765f, w * 0.42f))
        // Yüz
        drawCircle(color = skin, radius = w * 0.26f, center = Offset(w * 0.5f, w * 0.42f))

        // Saç stilleri
        when (config.hairStyle) {
            0 -> drawArc(hair, 180f, 180f, true, Offset(w * 0.22f, w * 0.14f), Size(w * 0.56f, w * 0.54f))
            1 -> {
                drawArc(hair, 180f, 180f, true, Offset(w * 0.21f, w * 0.13f), Size(w * 0.58f, w * 0.56f))
                drawRoundRect(hair, Offset(w * 0.20f, w * 0.40f), Size(w * 0.1f, w * 0.34f), androidx.compose.ui.geometry.CornerRadius(w * 0.05f))
                drawRoundRect(hair, Offset(w * 0.70f, w * 0.40f), Size(w * 0.1f, w * 0.34f), androidx.compose.ui.geometry.CornerRadius(w * 0.05f))
            }
            2 -> {
                drawArc(hair, 180f, 180f, true, Offset(w * 0.22f, w * 0.14f), Size(w * 0.56f, w * 0.54f))
                drawCircle(hair, radius = w * 0.09f, center = Offset(w * 0.5f, w * 0.12f))
            }
            3 -> {
                listOf(0.28f, 0.38f, 0.5f, 0.62f, 0.72f).forEach { x ->
                    drawCircle(hair, radius = w * 0.085f, center = Offset(w * x, w * 0.2f))
                }
                drawCircle(hair, radius = w * 0.085f, center = Offset(w * 0.24f, w * 0.3f))
                drawCircle(hair, radius = w * 0.085f, center = Offset(w * 0.76f, w * 0.3f))
            }
            else -> Unit // saçsız
        }

        // Kaşlar
        drawRoundRect(hair, Offset(w * 0.355f, w * 0.345f), Size(w * 0.1f, w * 0.025f), androidx.compose.ui.geometry.CornerRadius(w * 0.01f))
        drawRoundRect(hair, Offset(w * 0.545f, w * 0.345f), Size(w * 0.1f, w * 0.025f), androidx.compose.ui.geometry.CornerRadius(w * 0.01f))
        // Gözler
        listOf(0.41f, 0.59f).forEach { x ->
            drawCircle(Color.White, radius = w * 0.048f, center = Offset(w * x, w * 0.425f))
            drawCircle(AvatarEyeColors[config.eyeColor], radius = w * 0.028f, center = Offset(w * x, w * 0.43f))
            drawCircle(dark, radius = w * 0.013f, center = Offset(w * x, w * 0.43f))
        }
        // Gülümseme
        drawArc(
            color = dark, startAngle = 25f, sweepAngle = 130f, useCenter = false,
            topLeft = Offset(w * 0.415f, w * 0.44f), size = Size(w * 0.17f, w * 0.12f),
            style = Stroke(width = w * 0.018f)
        )
        // Kadın avatarında hafif allık
        if (config.gender == 0) {
            drawCircle(Color(0x33FF5CA8), radius = w * 0.035f, center = Offset(w * 0.36f, w * 0.49f))
            drawCircle(Color(0x33FF5CA8), radius = w * 0.035f, center = Offset(w * 0.64f, w * 0.49f))
        }
        // Gözlük
        if (config.glasses) {
            listOf(0.41f, 0.59f).forEach { x ->
                drawCircle(dark, radius = w * 0.07f, center = Offset(w * x, w * 0.425f), style = Stroke(width = w * 0.014f))
            }
            drawRect(dark, Offset(w * 0.465f, w * 0.418f), Size(w * 0.07f, w * 0.012f))
        }
    }
}

// --- Düzenleyici ---

private val EdPanel = Color(0xFF281A4A)
private val EdPanel2 = Color(0xFF342457)
private val EdGold = Color(0xFFC6FF4A)
private val EdMuted = Color(0xFFA99BC9)
private val EdText = Color(0xFFF5F1FF)
private val EdNavy = Color(0xFF1A0E2E)

@Composable
private fun OptionRow(label: String, options: List<String>, selected: Int, onSelect: (Int) -> Unit) {
    Text(label, color = EdMuted, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp, bottom = 6.dp))
    Row(Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        options.forEachIndexed { i, opt ->
            val chosen = i == selected
            Surface(
                onClick = { onSelect(i) },
                color = if (chosen) EdGold else EdPanel2,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.pressScale()
            ) {
                Text(opt, color = if (chosen) EdNavy else EdText, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp))
            }
        }
    }
}

@Composable
private fun ColorRow(label: String, colors: List<Color>, selected: Int, onSelect: (Int) -> Unit) {
    Text(label, color = EdMuted, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp, bottom = 6.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        colors.forEachIndexed { i, c ->
            Surface(
                onClick = { onSelect(i) },
                color = c,
                shape = RoundedCornerShape(50),
                border = androidx.compose.foundation.BorderStroke(if (i == selected) 3.dp else 1.dp, if (i == selected) EdGold else Color(0x33FFFFFF)),
                modifier = Modifier.size(34.dp).pressScale()
            ) {}
        }
    }
}

/** Avatar oluşturma ekranı: cinsiyet, ten, saç, göz, gözlük ve kıyafet seçimi + canlı önizleme. */
@Composable
fun AvatarEditorScreen(initialCode: String, onSave: (String) -> Unit, onBack: () -> Unit) {
    var cfg by remember { mutableStateOf(AvatarConfig.decode(initialCode)) }
    Column(
        Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF2E1660), Color(0xFF150A30))))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(onClick = onBack, color = EdPanel, shape = RoundedCornerShape(12.dp), modifier = Modifier.pressScale()) {
                Text("←", color = EdText, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
            }
            Text("Avatarını Oluştur", color = EdText, fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 12.dp))
        }
        Spacer(Modifier.height(14.dp))
        Surface(color = EdPanel, shape = RoundedCornerShape(22.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                PopOnChange(cfg) { AvatarView(cfg, 160.dp) }
            }
        }
        Surface(color = EdPanel, shape = RoundedCornerShape(22.dp), modifier = Modifier.fillMaxWidth().padding(top = 12.dp)) {
            Column(Modifier.padding(16.dp)) {
                OptionRow("Cinsiyet", listOf("Kadın", "Erkek"), cfg.gender) {
                    // Cinsiyete göre varsayılan saç stili önerisi; sonrasında serbestçe değiştirilebilir
                    cfg = cfg.copy(gender = it, hairStyle = if (it == 0) 1 else 0)
                }
                ColorRow("Ten rengi", AvatarSkinTones, cfg.skin) { cfg = cfg.copy(skin = it) }
                OptionRow("Saç stili", listOf("Kısa", "Uzun", "Topuz", "Kıvırcık", "Yok"), cfg.hairStyle) { cfg = cfg.copy(hairStyle = it) }
                ColorRow("Saç rengi", AvatarHairColors, cfg.hairColor) { cfg = cfg.copy(hairColor = it) }
                ColorRow("Göz rengi", AvatarEyeColors, cfg.eyeColor) { cfg = cfg.copy(eyeColor = it) }
                OptionRow("Gözlük", listOf("Yok", "Var"), if (cfg.glasses) 1 else 0) { cfg = cfg.copy(glasses = it == 1) }
                ColorRow("Kıyafet", AvatarShirtColors, cfg.shirt) { cfg = cfg.copy(shirt = it) }
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { onSave(cfg.encode()) },
            modifier = Modifier.fillMaxWidth().height(52.dp).pressScale(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = EdGold, contentColor = EdNavy)
        ) { Text("Kaydet", fontWeight = FontWeight.Bold, fontSize = 15.sp) }
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth().height(48.dp).pressScale(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = EdPanel2, contentColor = EdText)
        ) { Text("Vazgeç", fontWeight = FontWeight.Bold, fontSize = 14.sp) }
        Spacer(Modifier.height(24.dp))
    }
}
