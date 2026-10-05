package com.linguapro.android.ui.components

/*
 * Juice — uygulamayı saran dokunma/parlama/canlılık animasyonu katmanı.
 * Tüm ekranlar bu basit ilkellerle "premium gece" hissini alır:
 *  - pressScale / bouncy dokunma: her hedef yumuşak yayla küçülür, bırakınca zıplar
 *  - popIn / staggerIn: kartlar sahneye yaylanarak, sırayla girer
 *  - breathe / nodeGlow / wiggleForever / flameFlicker: sürekli yaşayan vurgular
 *  - shineSweep: altın karoların üzerinden geçen ışık şeridi
 *  - enterOnChange: yeni soru/sekmede içerik yumuşakça yeniden belirir
 *  - RollingNumber / PopOnChange: sayaçlar yuvarlanır, değişimde zıplar
 *  - CelebrationOverlay: ödül anları için ekran-orta parçacık kutlaması
 *  - Haptics: doğru/yanlış/kutlama anlarında kısa dokunsal tik (sistem ayarına saygılı)
 */

import android.os.Build
import android.view.HapticFeedbackConstants
import android.view.View
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linguapro.android.Gold
import com.linguapro.android.OnBg
import com.linguapro.android.PinkAccent
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

/** Dokunulan öğe hafifçe küçülür, bırakınca yayla geri döner. Tıklamayı ve kaydırmayı engellemez. */
fun Modifier.pressScale(scaleDown: Float = 0.94f): Modifier = composed {
    var pressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (pressed) scaleDown else 1f,
        animationSpec = if (pressed) tween(80) else spring(stiffness = 900f, dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "pressScale"
    )
    this
        .graphicsLayer { scaleX = scale; scaleY = scale }
        .pointerInput(Unit) {
            awaitEachGesture {
                awaitFirstDown(requireUnconsumed = false, pass = PointerEventPass.Initial)
                pressed = true
                waitForUpOrCancellation(pass = PointerEventPass.Initial)
                pressed = false
            }
        }
}

/** Sahneye yaylanarak girer (ilk kez oluşturulduğunda). */
fun Modifier.popIn(delayMillis: Long = 0L, fromScale: Float = 0.72f): Modifier = composed {
    var started by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        if (delayMillis > 0) delay(delayMillis)
        started = true
    }
    val scale by animateFloatAsState(
        targetValue = if (started) 1f else fromScale,
        animationSpec = spring(stiffness = 380f, dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "popInScale"
    )
    val alpha by animateFloatAsState(
        targetValue = if (started) 1f else 0f,
        animationSpec = tween(220),
        label = "popInAlpha"
    )
    graphicsLayer { scaleX = scale; scaleY = scale; this.alpha = alpha }
}

/** Listelerde sıralı giriş: her öğe biraz gecikmeli, yukarı kayarak belirir. */
fun Modifier.staggerIn(index: Int, stepMs: Int = 55, fromDp: Float = 22f): Modifier = composed {
    var started by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay((index * stepMs).coerceAtMost(650).toLong())
        started = true
    }
    val p by animateFloatAsState(
        targetValue = if (started) 1f else 0f,
        animationSpec = tween(360, easing = FastOutSlowInEasing),
        label = "stagger"
    )
    val fromY = with(LocalDensity.current) { fromDp.dp.toPx() }
    graphicsLayer {
        translationY = (1f - p) * fromY
        val s = 0.97f + 0.03f * p
        scaleX = s; scaleY = s
        alpha = p
    }
}

/** Yumuşak "nefes alma": hazır ödüller ve davetkar eylemler nazikçe büyüyüp küçülür. */
fun Modifier.breathe(minScale: Float = 1f, maxScale: Float = 1.04f, periodMs: Int = 1400): Modifier = composed {
    val t = rememberInfiniteTransition(label = "breathe")
    val s by t.animateFloat(
        initialValue = minScale,
        targetValue = maxScale,
        animationSpec = infiniteRepeatable(tween(periodMs, easing = FastOutSlowInEasing), RepeatMode.Reverse),
        label = "breatheScale"
    )
    graphicsLayer { scaleX = s; scaleY = s }
}

/** Seri alevi: ölçek nabzı + hafif titreme. */
fun Modifier.flameFlicker(): Modifier = composed {
    val t = rememberInfiniteTransition(label = "flame")
    val s by t.animateFloat(1f, 1.16f, infiniteRepeatable(tween(640, easing = FastOutSlowInEasing), RepeatMode.Reverse), label = "flameScale")
    val r by t.animateFloat(-5f, 5f, infiniteRepeatable(tween(380, easing = LinearEasing), RepeatMode.Reverse), label = "flameRot")
    graphicsLayer { scaleX = s; scaleY = s * 1.05f; rotationZ = r }
}

/** Elmas sandığı: sabırsız sallanma + nabız. */
fun Modifier.wiggleForever(): Modifier = composed {
    val t = rememberInfiniteTransition(label = "wiggle")
    val r by t.animateFloat(-8f, 8f, infiniteRepeatable(tween(420, easing = FastOutSlowInEasing), RepeatMode.Reverse), label = "wiggleRot")
    val s by t.animateFloat(1f, 1.1f, infiniteRepeatable(tween(520, easing = FastOutSlowInEasing), RepeatMode.Reverse), label = "wiggleScale")
    graphicsLayer { rotationZ = r; scaleX = s; scaleY = s }
}

/** Etrafında nefes alan ışık halesi (sıradaki patika düğümü için). */
fun Modifier.nodeGlow(color: Color = Gold): Modifier = composed {
    val t = rememberInfiniteTransition(label = "glow")
    val a by t.animateFloat(0.35f, 1f, infiniteRepeatable(tween(850, easing = FastOutSlowInEasing), RepeatMode.Reverse), label = "glowAlpha")
    drawBehind {
        val r = size.minDimension * 1.08f
        drawCircle(
            brush = Brush.radialGradient(colors = listOf(color.copy(alpha = 0.55f * a), Color.Transparent), radius = r),
            radius = r
        )
    }
}

/** Altın karoların üzerinden düzenli aralıklarla geçen ışık şeridi. */
fun Modifier.shineSweep(intervalMs: Int = 3400, bandAlpha: Float = 0.20f): Modifier = composed {
    val t = rememberInfiniteTransition(label = "shine")
    val p by t.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(850, delayMillis = (intervalMs - 850).coerceAtLeast(0), easing = LinearEasing)),
        label = "shineP"
    )
    drawWithContent {
        drawContent()
        val w = size.width
        val x0 = -w * 0.5f + p * w * 1.9f
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.White.copy(alpha = bandAlpha * 0.45f),
                    Color.White.copy(alpha = bandAlpha),
                    Color.White.copy(alpha = bandAlpha * 0.45f),
                    Color.Transparent
                ),
                start = Offset(x0, 0f),
                end = Offset(x0 + w * 0.45f, size.height)
            )
        )
    }
}

/** Yükleme iskeletleri için süzülen ışık bandı. */
fun Modifier.shimmer(): Modifier = composed {
    val t = rememberInfiniteTransition(label = "shimmer")
    val x by t.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(1100, easing = LinearEasing)),
        label = "shimmerX"
    )
    drawWithContent {
        drawContent()
        val w = size.width
        val off = (x * 2f - 0.5f) * w
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.White.copy(alpha = 0.06f),
                    Color.White.copy(alpha = 0.13f),
                    Color.White.copy(alpha = 0.06f),
                    Color.Transparent
                ),
                start = Offset(off - w * 0.35f, 0f),
                end = Offset(off + w * 0.35f, size.height)
            )
        )
    }
}

/** key değiştiğinde (yeni soru, yeni kart) içerik yumuşakça yeniden belirir. */
fun Modifier.enterOnChange(key: Any?): Modifier = composed {
    val p = remember(key) { Animatable(0f) }
    LaunchedEffect(key) { p.animateTo(1f, tween(280, easing = FastOutSlowInEasing)) }
    val dy = with(LocalDensity.current) { 20.dp.toPx() }
    graphicsLayer { alpha = 0.3f + 0.7f * p.value; translationY = (1f - p.value) * dy }
}

/** Değişen sayıyı yukarı kaydırarak gösteren sayaç (elmas, XP). */
@Composable
fun RollingNumber(
    value: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    prefix: String = "",
    suffix: String = ""
) {
    AnimatedContent(
        targetState = value,
        transitionSpec = {
            (slideInVertically(animationSpec = tween(240)) { it } + fadeIn(tween(240)))
                .togetherWith(slideOutVertically(animationSpec = tween(180)) { -it } + fadeOut(tween(140)))
        },
        label = "rolling",
        modifier = modifier
    ) { v ->
        Text("$prefix$v$suffix", color = color, fontSize = fontSize, fontWeight = fontWeight, softWrap = false)
    }
}

/** key her değiştiğinde içeriği yayla zıplatır (kombo sayacı, elmas sayacı vb.). */
@Composable
fun PopOnChange(key: Any?, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var armed by remember { mutableStateOf(false) }
    val scale = remember { Animatable(1f) }
    LaunchedEffect(key) {
        if (!armed) { armed = true; return@LaunchedEffect }
        scale.snapTo(0.66f)
        scale.animateTo(1f, spring(stiffness = 420f, dampingRatio = Spring.DampingRatioMediumBouncy))
    }
    Box(modifier.graphicsLayer { scaleX = scale.value; scaleY = scale.value }) { content() }
}

/** Dokunsal geri bildirim: doğru/yanlış/kutlama anlarında kısa titreşimler. */
class Haptics(private val view: View) {
    fun tick() = perform(HapticFeedbackConstants.KEYBOARD_TAP)
    fun confirm() = perform(if (Build.VERSION.SDK_INT >= 30) HapticFeedbackConstants.CONFIRM else HapticFeedbackConstants.KEYBOARD_TAP)
    fun reject() = perform(if (Build.VERSION.SDK_INT >= 30) HapticFeedbackConstants.REJECT else HapticFeedbackConstants.VIRTUAL_KEY)
    private fun perform(constant: Int) {
        view.performHapticFeedback(constant)
    }
}

@Composable
fun rememberHaptics(): Haptics {
    val view = LocalView.current
    return remember(view) { Haptics(view) }
}

/** Kutlama verisi: emoji + başlık + alt başlık. */
data class Celebration(val emoji: String, val title: String, val subtitle: String = "")

/**
 * Ekran ortasında patlayan kutlama katmanı: parçacık saçılımı + yayla büyüyen kart.
 * ~1.7 sn sonra ya da dokunulunca kendiliğinden kapanır. Bir Box içinde kullanılır.
 */
@Composable
fun BoxScope.CelebrationOverlay(celebration: Celebration?, onDismiss: () -> Unit) {
    var last by remember { mutableStateOf<Celebration?>(null) }
    SideEffect { if (celebration != null) last = celebration }
    AnimatedVisibility(
        visible = celebration != null,
        enter = fadeIn(tween(150)),
        exit = fadeOut(tween(200)) + scaleOut(targetScale = 0.92f, animationSpec = tween(200)),
        modifier = Modifier.matchParentSize()
    ) {
        val c = last ?: return@AnimatedVisibility
        LaunchedEffect(celebration) {
            if (celebration != null) {
                delay(1750)
                onDismiss()
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(Color(0x96000A1E))
                .clickable { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            CelebrationBurst(Modifier.fillMaxSize())
            val scale = remember { Animatable(0.55f) }
            LaunchedEffect(celebration) {
                if (celebration != null) {
                    scale.snapTo(0.55f)
                    scale.animateTo(1f, spring(stiffness = 320f, dampingRatio = Spring.DampingRatioMediumBouncy))
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.graphicsLayer { scaleX = scale.value; scaleY = scale.value }
            ) {
                Text(c.emoji, fontSize = 60.sp)
                Text(c.title, color = OnBg, fontSize = 23.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                if (c.subtitle.isNotBlank()) {
                    Text(c.subtitle, color = Gold, fontSize = 15.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 5.dp))
                }
            }
        }
    }
}

/** Merkezden saçılan kutlama parçacıkları: genişleyen halka + renkli noktalar. */
@Composable
private fun CelebrationBurst(modifier: Modifier = Modifier) {
    val burst = remember { Animatable(0f) }
    LaunchedEffect(Unit) { burst.animateTo(1f, tween(1200, easing = FastOutSlowInEasing)) }
    val palette = listOf(Gold, PinkAccent, Color(0xFF7DD3FC), Color(0xFFFFD166), Color(0xFFB791FF))
    val seeds = remember {
        List(34) { i ->
            val angle = i * 137.5f * (Math.PI.toFloat() / 180f)
            Triple(cos(angle), sin(angle), palette[i % palette.size])
        }
    }
    Canvas(modifier) {
        val p = burst.value
        if (p >= 1f) return@Canvas
        val c = center
        val base = size.minDimension * 0.06f
        val reach = size.minDimension * 0.55f
        drawCircle(
            color = Gold.copy(alpha = (1f - p) * 0.35f),
            radius = base + reach * p,
            center = c,
            style = Stroke(width = 3.dp.toPx() * (1f - p * 0.5f))
        )
        seeds.forEach { (dx, dy, color) ->
            val dist = base + reach * 0.85f * p
            val gravity = p * p * size.height * 0.16f
            drawCircle(
                color = color.copy(alpha = (1f - p * p).coerceIn(0f, 1f)),
                radius = 3.5.dp.toPx() * (1f - 0.4f * p),
                center = Offset(c.x + dx * dist, c.y + dy * dist + gravity)
            )
        }
    }
}
