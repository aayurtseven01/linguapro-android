package com.linguapro.android

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.linguapro.android.audio.RemoteSpeechPlayer
import com.linguapro.android.ui.components.Celebration
import com.linguapro.android.ui.components.CelebrationOverlay
import com.linguapro.android.ui.components.enterOnChange
import com.linguapro.android.ui.components.popIn
import com.linguapro.android.ui.components.pressScale
import com.linguapro.android.ui.components.staggerIn
import kotlinx.coroutines.delay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

private val StPanel = Color(0xFF152238)
private val StPanel2 = Color(0xFF20314B)
private val StGold = Color(0xFF6DE8C1)
private val StPink = ErrorCoral
private val StMuted = Color(0xFFA3B2C8)
private val StText = Color(0xFFF3F7FD)
private val StNavy = Color(0xFF0B1423)

/** Hikâye karakterleri: ders kadrosundan iki tanıdık yüz. */
private val storyCast = listOf(
    AvatarConfig(gender = 1, skin = 1, hairStyle = 0, hairColor = 1, eyeColor = 0, glasses = false, shirt = 2),
    AvatarConfig(gender = 0, skin = 2, hairStyle = 1, hairColor = 0, eyeColor = 1, glasses = false, shirt = 1)
)

@Composable
fun StoriesListScreen(lang: String, doneIds: Set<String>, onOpen: (String) -> Unit, onBack: () -> Unit, initialLevel: String? = null) {
    var selectedLevel by rememberSaveable(lang, initialLevel) { mutableStateOf(initialLevel ?: "Tümü") }
    val stories = StoryCatalog.storiesFor(lang).filter { selectedLevel == "Tümü" || it.level == selectedLevel }
    Column(
        Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF14263D), Color(0xFF0B1423))))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp)
    ) {
        Spacer(Modifier.height(14.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(onClick = onBack, color = StPanel, shape = RoundedCornerShape(12.dp), modifier = Modifier.pressScale()) {
                Text("←", color = StText, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
            }
            Text("📖 Hikâyeler", color = StText, fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 12.dp))
        }
        Text("Kısa diyaloglar: oku, dinle, soruları yanıtla. Her hikâye +10 XP ve +5 💎 kazandırır.", color = StMuted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 6.dp, bottom = 14.dp))
        Row(Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()).padding(bottom = 14.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            (listOf("Tümü") + CourseCatalog.levels).forEach { level ->
                Surface(onClick = { selectedLevel = level }, color = if (selectedLevel == level) StGold else StPanel,
                    shape = RoundedCornerShape(14.dp), modifier = Modifier.heightIn(min = 48.dp)) {
                    Text(level, color = if (selectedLevel == level) StNavy else StText,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 14.dp))
                }
            }
        }
        if (stories.isEmpty()) {
            Surface(color = StPanel, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
                Text("Bu dil için hikâyeler çok yakında!", color = StMuted, fontSize = 13.sp, modifier = Modifier.padding(16.dp))
            }
        }
        stories.forEachIndexed { i, story ->
            val done = story.id in doneIds
            Surface(onClick = { onOpen(story.id) }, color = StPanel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).staggerIn(i).pressScale()) {
                Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text("📖", fontSize = 26.sp)
                    Column(Modifier.weight(1f).padding(start = 12.dp)) {
                        Text(story.title, color = StText, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                        Text("${story.level} • ${story.lines.size} replik • ${story.questions.size} soru", color = StMuted, fontSize = 11.sp, modifier = Modifier.padding(top = 2.dp))
                    }
                    if (done) Text("✓", color = StGold, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                    else Surface(color = StGold, shape = RoundedCornerShape(12.dp)) {
                        Text("Başla", color = StNavy, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
                    }
                }
            }
        }
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
fun StoryPlayerScreen(story: Story, soundOn: Boolean, onFinished: (correct: Int, total: Int) -> Unit, onBack: () -> Unit) {
    val context = LocalContext.current
    val speechTag = remember(story.id) { WorldCatalog.speechTagForLesson("${story.lang}-A1-X", "en-US") }
    var ttsReady by remember(story.id) { mutableStateOf(false) }
    val tts = remember(story.id) { mutableStateOf<TextToSpeech?>(null) }
    DisposableEffect(story.id) {
        val engine = TextToSpeech(context) { status ->
            ttsReady = status == TextToSpeech.SUCCESS &&
                (tts.value?.setLanguage(Locale.forLanguageTag(speechTag)) ?: TextToSpeech.LANG_NOT_SUPPORTED) >= TextToSpeech.LANG_AVAILABLE
        }
        tts.value = engine
        onDispose { runCatching { engine.stop(); engine.shutdown() } }
    }

    // Stüdyo sesi (Faz S2): önbellek → CDN → cihaz TTS; ses kapalıysa hiçbir şey çalınmaz.
    val speechScope = rememberCoroutineScope()
    val remoteSpeech = remember { RemoteSpeechPlayer(context, speechScope) }
    DisposableEffect(Unit) { onDispose { remoteSpeech.release() } }
    var remoteReady by remember(story.id) { mutableStateOf(false) }
    LaunchedEffect(story.id) {
        remoteSpeech.warmCatalog()
        remoteReady = remoteSpeech.isRemoteAvailable(speechTag)
    }
    var audioMessage by remember(story.id) { mutableStateOf("") }
    val playLine: (StoryLine) -> Unit = { line ->
        if (soundOn) {
            remoteSpeech.speak(speechTag, line.text, line.speaker == 1) {
                if (ttsReady) runCatching { tts.value?.speak(line.text, TextToSpeech.QUEUE_FLUSH, null, "story-line") }
                else audioMessage = "Cihazda bu dil için ses kullanılamıyor. Metni okuyarak çalışabilirsin."
            }
        } else {
            runCatching { tts.value?.stop() }
            remoteSpeech.stop()
        }
    }

    var showTranslation by rememberSaveable(story.id) { mutableStateOf(false) }
    var revealed by rememberSaveable(story.id) { mutableIntStateOf(1) }
    var questionIndex by rememberSaveable(story.id) { mutableIntStateOf(-1) } // -1: diyalog aşaması
    var picked by rememberSaveable(story.id, questionIndex) { mutableIntStateOf(-1) }
    var correctCount by rememberSaveable(story.id) { mutableIntStateOf(0) }

    // Yeni açılan repliği otomatik seslendir (stüdyo sesi önce, cihaz TTS yedek)
    var lastAutoPlayed by remember(story.id) { mutableIntStateOf(-1) }
    LaunchedEffect(story.id, revealed, questionIndex, soundOn, ttsReady, remoteReady) {
        if (!soundOn || questionIndex >= 0) {
            runCatching { tts.value?.stop() }
            remoteSpeech.stop()
        } else if ((ttsReady || remoteReady) && lastAutoPlayed != revealed) {
            story.lines.getOrNull(revealed - 1)?.let {
                lastAutoPlayed = revealed
                playLine(it)
            }
        }
    }

    // Hikâye bitişinde: önce kutlamayı göster, sonra listeye dön.
    // finishRequested ayrıdır: kutlama erken kapatılsa da akış iptal olmaz.
    var celebration by remember { mutableStateOf<Celebration?>(null) }
    var finishRequested by remember { mutableStateOf(false) }
    LaunchedEffect(finishRequested) {
        if (finishRequested) {
            delay(1500)
            onFinished(correctCount, story.questions.size)
        }
    }
    Box(Modifier.fillMaxSize()) {
    Column(
        Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF14263D), Color(0xFF0B1423))))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp)
    ) {
        Spacer(Modifier.height(14.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(onClick = onBack, color = StPanel, shape = RoundedCornerShape(12.dp), modifier = Modifier.pressScale()) {
                Text("←", color = StText, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
            }
            Column(Modifier.padding(start = 12.dp)) {
                Text(story.title, color = StText, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(if (questionIndex < 0) "replik ${revealed}/${story.lines.size}" else "soru ${questionIndex + 1}/${story.questions.size}", color = StMuted, fontSize = 11.sp)
            }
        }
        Spacer(Modifier.height(14.dp))

        if (questionIndex < 0) {
            // --- Diyalog aşaması: balonlar sırayla açılır ---
            story.lines.take(revealed).forEachIndexed { i, line ->
                val fromLeft = line.speaker == 0
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 5.dp).popIn(),
                    horizontalArrangement = if (fromLeft) Arrangement.Start else Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {
                    if (fromLeft) AvatarView(storyCast[0], 46.dp)
                    Surface(
                        onClick = { if (soundOn && (ttsReady || remoteReady)) playLine(line) },
                        color = if (fromLeft) StPanel else StPanel2,
                        shape = RoundedCornerShape(
                            topStart = 16.dp, topEnd = 16.dp,
                            bottomStart = if (fromLeft) 4.dp else 16.dp,
                            bottomEnd = if (fromLeft) 16.dp else 4.dp
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp).weight(1f, fill = false)
                    ) {
                        Column(Modifier.padding(horizontal = 13.dp, vertical = 9.dp)) {
                            Text(line.text, color = StText, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, lineHeight = 21.sp)
                            if (showTranslation) Text(line.tr, color = StMuted, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 3.dp))
                        }
                    }
                    if (!fromLeft) AvatarView(storyCast[1], 46.dp)
                }
            }
            Spacer(Modifier.height(16.dp))
            Surface(
                onClick = {
                    if (revealed < story.lines.size) revealed++ else questionIndex = 0
                },
                color = StGold, shape = RoundedCornerShape(15.dp), modifier = Modifier.fillMaxWidth().pressScale()
            ) {
                Text(
                    if (revealed < story.lines.size) "Devam  ▸" else "Sorulara geç  ▸",
                    color = StNavy, fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp)
                )
            }
            TextButton(onClick = { showTranslation = !showTranslation }) {
                Text(if (showTranslation) "Türkçe çevirileri gizle" else "Türkçe çevirileri göster", color = StGold)
            }
            if (audioMessage.isNotBlank()) Text(audioMessage, color = StMuted, fontSize = 12.sp)
            Text("Balona dokunursan repliği tekrar duyarsın.", color = StMuted, fontSize = 11.sp, modifier = Modifier.padding(top = 8.dp))
        } else {
            // --- Soru aşaması ---
            val question = story.questions[questionIndex]
            Surface(color = StPanel, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth().enterOnChange(questionIndex)) {
                Column(Modifier.padding(16.dp)) {
                    Text("ANLAMA SORUSU", color = StGold, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.2.sp)
                    Text(question.prompt, color = StText, fontSize = 18.sp, fontWeight = FontWeight.Bold, lineHeight = 25.sp, modifier = Modifier.padding(top = 8.dp, bottom = 12.dp))
                    question.options.forEachIndexed { oi, option ->
                        val answered = picked >= 0
                        val isCorrect = oi == question.correct
                        val bg = when {
                            answered && isCorrect -> StGold
                            answered && oi == picked -> StPink
                            else -> StPanel2
                        }
                        val fg = if (answered && (isCorrect || oi == picked)) StNavy else StText
                        Surface(
                            onClick = { if (!answered) { picked = oi; if (isCorrect) correctCount++ } },
                            color = bg, shape = RoundedCornerShape(13.dp),
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).pressScale()
                        ) {
                            Text(option, color = fg, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp))
                        }
                    }
                }
            }
            if (picked >= 0) {
                if (question.explanationTr.isNotBlank()) {
                    Text(question.explanationTr, color = StText, fontSize = 13.sp, lineHeight = 19.sp,
                        modifier = Modifier.padding(top = 12.dp))
                }
                Spacer(Modifier.height(14.dp))
                Surface(
                    onClick = {
                        if (questionIndex < story.questions.lastIndex) {
                            questionIndex++
                        } else if (!finishRequested) {
                            finishRequested = true
                            celebration = Celebration("📖", "Hikâye tamam!", "$correctCount/${story.questions.size} doğru • +10 XP +5 💎")
                        }
                    },
                    color = StGold, shape = RoundedCornerShape(15.dp), modifier = Modifier.fillMaxWidth().pressScale()
                ) {
                    Text(
                        if (questionIndex < story.questions.lastIndex) "Sonraki soru  ▸" else "Hikâyeyi bitir  🏁",
                        color = StNavy, fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp)
                    )
                }
            }
        }
        Spacer(Modifier.height(24.dp))
    }
    CelebrationOverlay(celebration, onDismiss = { celebration = null })
    }
}
// STORYSCREENS-SON

