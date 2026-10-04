package com.linguapro.android

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.util.Locale

private val LessonNavy = Color(0xFF1A0E2E)
private val LessonPanel = Color(0xFF281A4A)
private val LessonPanel2 = Color(0xFF342457)
private val LessonGold = Color(0xFFC6FF4A)
private val LessonMuted = Color(0xFFA99BC9)
private val LessonMint = Color(0xFFB5F23D)
private val LessonPink = Color(0xFFFF5CA8)
private val LessonText = Color(0xFFF5F1FF)
private val LessonCombo = Color(0xFFFFB020)

/** Derslerde sorulari sunan karakter kadrosu (parametrik avatar motoru). */
private val lessonCast = listOf(
    AvatarConfig(gender = 0, skin = 1, hairStyle = 1, hairColor = 0, eyeColor = 0, glasses = false, shirt = 1),
    AvatarConfig(gender = 1, skin = 2, hairStyle = 0, hairColor = 1, eyeColor = 1, glasses = true, shirt = 2),
    AvatarConfig(gender = 0, skin = 0, hairStyle = 2, hairColor = 4, eyeColor = 2, glasses = false, shirt = 0),
    AvatarConfig(gender = 1, skin = 3, hairStyle = 3, hairColor = 0, eyeColor = 0, glasses = false, shirt = 3),
    AvatarConfig(gender = 0, skin = 2, hairStyle = 3, hairColor = 2, eyeColor = 1, glasses = true, shirt = 4),
    AvatarConfig(gender = 1, skin = 1, hairStyle = 4, hairColor = 3, eyeColor = 0, glasses = false, shirt = 2)
)

@Composable
fun LearningLessonScreen(
    lesson: LearningLesson,
    exerciseIndex: Int,
    onBack: () -> Unit,
    onExerciseResult: (exerciseId: String, skill: Skill, correct: Boolean) -> Unit,
    onDone: (Int?, Int) -> Unit,
    ttsAccent: String = "en-US",
    speechRate: Float = 1.0f
) {
    var attempt by rememberSaveable(lesson.id) { mutableIntStateOf(0) }
    val index = rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableIntStateOf(exerciseIndex) }
    val exercise = lesson.exercises.getOrNull(index.intValue)
    var selected by rememberSaveable(lesson.id, index.intValue, attempt) { mutableIntStateOf(-1) }
    var answer by rememberSaveable(lesson.id, index.intValue, attempt) { mutableStateOf("") }
    var submitted by rememberSaveable(lesson.id, index.intValue, attempt) { mutableStateOf(false) }
    var result by rememberSaveable(lesson.id, index.intValue, attempt) { mutableStateOf<Boolean?>(null) }
    var speechText by rememberSaveable(lesson.id, index.intValue, attempt) { mutableStateOf("") }
    var speechMessage by rememberSaveable(lesson.id, index.intValue, attempt) { mutableStateOf("") }
    var correctCount by rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableIntStateOf(0) }
    var gradedCount by rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableIntStateOf(0) }
    var lessonFinished by rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableStateOf(false) }
    var savedStudyMillis by rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableLongStateOf(0L) }
    val studyClock = remember(lesson.id, exerciseIndex, attempt) { ActiveStudyClock(savedStudyMillis) }
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val isFinished by rememberUpdatedState(lessonFinished)
    LaunchedEffect(studyClock) {
        while (true) { delay(1000); savedStudyMillis = studyClock.elapsedMillis(android.os.SystemClock.elapsedRealtime()) }
    }
    DisposableEffect(lifecycleOwner, studyClock) {
        if (lifecycleOwner.lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) && !isFinished) {
            studyClock.resume(android.os.SystemClock.elapsedRealtime())
        }
        val observer = androidx.lifecycle.LifecycleEventObserver { _, event ->
            val now = android.os.SystemClock.elapsedRealtime()
            if (event == androidx.lifecycle.Lifecycle.Event.ON_START && !isFinished) studyClock.resume(now)
            if (event == androidx.lifecycle.Lifecycle.Event.ON_STOP) { studyClock.pause(now); savedStudyMillis = studyClock.elapsedMillis(now) }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            val now = android.os.SystemClock.elapsedRealtime()
            studyClock.pause(now); savedStudyMillis = studyClock.elapsedMillis(now)
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    LaunchedEffect(lessonFinished) {
        if (lessonFinished) {
            val now = android.os.SystemClock.elapsedRealtime()
            studyClock.pause(now); savedStudyMillis = studyClock.elapsedMillis(now)
        }
    }
    var finalScore by rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableIntStateOf(0) }
    var ttsReady by remember { mutableStateOf(false) }
    val soundPrefs = LocalContext.current.getSharedPreferences("lingua_course", android.content.Context.MODE_PRIVATE)
    var soundOn by remember { mutableStateOf(soundPrefs.getBoolean("sound_on", true)) }
    var comboStreak by rememberSaveable(lesson.id, attempt) { mutableIntStateOf(0) }
    var comboCelebrate by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    val tts = remember { mutableStateOf<TextToSpeech?>(null) }

    val courseSpeechTag = remember(lesson.id, ttsAccent) { WorldCatalog.speechTagForLesson(lesson.id, ttsAccent) }
    val courseLangName = remember(lesson.id) { WorldCatalog.languageNameForLesson(lesson.id) }
    DisposableEffect(context, courseSpeechTag, speechRate) {
        val engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                ttsReady = engineLanguageSetup(tts.value, courseSpeechTag, speechRate)
                if (!ttsReady) speechMessage = "Seçilen aksan için cihazda TTS sesi yok. Ayarlardan diğer aksanı deneyebilirsin."
            } else {
                ttsReady = false
                speechMessage = "Cihazın metni sese dönüştürme motoru kullanılamıyor."
            }
        }
        tts.value = engine
        onDispose {
            engine.stop()
            engine.shutdown()
            tts.value = null
            ttsReady = false
        }
    }

    var isListening by remember { mutableStateOf(false) }
    var micLevel by remember { mutableFloatStateOf(0f) }
    val speechRecognizer = remember {
        if (SpeechRecognizer.isRecognitionAvailable(context)) SpeechRecognizer.createSpeechRecognizer(context) else null
    }
    DisposableEffect(speechRecognizer) {
        onDispose { speechRecognizer?.destroy() }
    }
    val startListening: () -> Unit = startListening@{
        val sr = speechRecognizer
        if (sr == null) {
            speechMessage = "Bu cihazda konuşma tanıma yok. Cümleyi aşağıya yazabilirsin."
            return@startListening
        }
        sr.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) { isListening = true; micLevel = 0f; speechMessage = "" }
            override fun onBeginningOfSpeech() { isListening = true }
            override fun onRmsChanged(rmsdB: Float) { micLevel = ((rmsdB + 2f) / 12f).coerceIn(0f, 1f) }
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() { micLevel = 0f }
            override fun onError(error: Int) {
                isListening = false; micLevel = 0f
                speechMessage = when (error) {
                    SpeechRecognizer.ERROR_NO_MATCH, SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "Ses algılanamadı. Tekrar dene veya cümleyi aşağıya yaz."
                    SpeechRecognizer.ERROR_NETWORK, SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Konuşma tanıma için bağlantı kurulamadı. Cümleyi yazarak devam edebilirsin."
                    SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Mikrofon iznini kontrol et veya cümleyi aşağıya yaz."
                    SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "Konuşma tanıma meşgul. Biraz bekleyip tekrar dene."
                    else -> "Konuşma tanıma tamamlanamadı. Tekrar dene veya cümleyi aşağıya yaz."
                }
            }
            override fun onPartialResults(partialResults: Bundle?) {
                val partial = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)?.firstOrNull().orEmpty()
                if (partial.isNotBlank()) speechText = partial
            }
            override fun onResults(results: Bundle?) {
                isListening = false; micLevel = 0f
                if (submitted) return
                val recognized = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)?.firstOrNull().orEmpty()
                if (recognized.isNotBlank()) {
                    speechText = recognized
                    speechMessage = ""
                    answer = recognized
                    val isCorrect = AnswerChecker.matches(recognized, exercise?.acceptedAnswers.orEmpty())
                    result = isCorrect
                    exercise?.let { onExerciseResult(it.id, it.skill, isCorrect) }
                    gradedCount++
                    if (isCorrect) correctCount++
                    submitted = true
                    playFeedbackTone(soundOn, isCorrect)
                    if (isCorrect) { comboStreak++; if (comboStreak % 5 == 0) comboCelebrate = comboStreak } else comboStreak = 0
                }
            }
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, courseSpeechTag)
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
        }
        runCatching { sr.startListening(intent) }
            .onFailure { isListening = false; speechMessage = "Bu cihazda konuşma tanıma açılamadı. Cümleyi aşağıya yazabilirsin." }
    }
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) {
            startListening()
        } else {
            speechMessage = "Mikrofon izni verilmedi. Cümleyi aşağıya yazarak devam edebilirsin."
        }
    }

    if (lessonFinished) {
        LessonCompletion(lesson = lesson, correct = correctCount, graded = gradedCount, score = finalScore, onContinue = {
            val seconds = (studyClock.elapsedMillis(android.os.SystemClock.elapsedRealtime()) / 1000).coerceIn(0L, 7200L).toInt()
            onDone(finalScore.takeIf { it >= 0 }, seconds)
        }, onRetry = { attempt++ })
        return
    }

    if (exercise == null) {
        LessonColumn { LessonButton("Dersi tamamla") { finalScore = -1; lessonFinished = true } }
        return
    }

    val progress = (index.intValue + 1f) / lesson.exercises.size
    val modelText = exercise.modelAudioText ?: exercise.acceptedAnswers.firstOrNull().orEmpty()

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Geri", tint = LessonText) }
            Column(Modifier.weight(1f)) {
                Text(lesson.title, color = LessonText, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("${lesson.id} • ${skillLabel(exercise.skill)}", color = Color(0xFFCBBDE8), fontSize = 12.sp)
            }
            IconButton(onClick = {
                soundOn = !soundOn
                soundPrefs.edit().putBoolean("sound_on", soundOn).apply()
            }) {
                Icon(if (soundOn) Icons.Default.VolumeUp else Icons.Default.VolumeOff, if (soundOn) "Sesleri kapat" else "Sesleri aç", tint = if (soundOn) LessonGold else LessonMuted)
            }
        }
        Text(lesson.canDo, color = Color(0xFFCBBDE8), fontSize = 13.sp, modifier = Modifier.padding(start = 6.dp, top = 3.dp, bottom = 14.dp))
        if (comboStreak >= 2) {
            Text(
                "KOMBO x$comboStreak",
                color = LessonCombo, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.5.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 4.dp)
            )
        }
        // Parça parça dolan ilerleme çubuğu
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            repeat(lesson.exercises.size) { seg ->
                Box(
                    Modifier
                        .weight(1f)
                        .height(7.dp)
                        .background(if (seg <= index.intValue) LessonGold else Color(0x30FFFFFF), RoundedCornerShape(4.dp))
                )
            }
        }
        if (comboCelebrate > 0) {
            LaunchedEffect(comboCelebrate) { kotlinx.coroutines.delay(1600); comboCelebrate = 0 }
            Surface(color = LessonGold, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth().padding(top = 12.dp)) {
                Text(
                    "🔥 Üst üste $comboCelebrate!",
                    color = LessonNavy, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp)
                )
            }
        }
        Text("Etkinlik ${index.intValue + 1} / ${lesson.exercises.size}", color = Color(0xFFCBBDE8), fontSize = 12.sp, modifier = Modifier.align(Alignment.End).padding(top = 5.dp))
        Spacer(Modifier.height(14.dp))

        if (index.intValue == 0 && lesson.targetVocabulary.isNotEmpty()) {
            Surface(color = LessonPanel, shadowElevation = 2.dp, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                Column(Modifier.padding(15.dp)) {
                    Text("Hedef kelimeler • ${lesson.targetVocabulary.size}", color = LessonGold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    lesson.targetVocabulary.forEach { word ->
                        Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(word.emoji, fontSize = 23.sp)
                            Column(Modifier.weight(1f).padding(start = 10.dp)) {
                                Text("${word.termEn} • ${word.translationTr}", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(word.exampleEn, color = LessonText, fontSize = 12.sp, modifier = Modifier.padding(top = 2.dp))
                                Text(word.exampleTr, color = LessonMuted, fontSize = 11.sp, modifier = Modifier.padding(top = 1.dp))
                            }
                            IconButton(onClick = { speak(tts.value, word.termEn) }, enabled = ttsReady) {
                                Icon(Icons.Default.VolumeUp, contentDescription = "${word.termEn} kelimesini dinle", tint = LessonGold)
                            }
                        }
                    }
                }
            }
        }
        if (exercise.skill == Skill.GRAMMAR && lesson.grammarFocus != null) {
            Surface(color = LessonPanel2, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                Column(Modifier.padding(15.dp)) {
                    Text(lesson.grammarFocus.titleTr, color = LessonGold, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Text(lesson.grammarFocus.explanationTr, color = LessonMuted, fontSize = 13.sp, lineHeight = 19.sp, modifier = Modifier.padding(top = 7.dp))
                    Text(lesson.grammarFocus.form, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, modifier = Modifier.padding(top = 8.dp))
                    Text("${lesson.grammarFocus.englishExample} — ${lesson.grammarFocus.turkishEquivalent}", fontSize = 13.sp, lineHeight = 18.sp, modifier = Modifier.padding(top = 5.dp))
                    Text(lesson.grammarFocus.commonTurkishErrorTr, color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 7.dp))
                }
            }
        }

        val shake = remember(index.intValue) { Animatable(0f) }
        LaunchedEffect(submitted, result) {
            if (submitted && result == false) {
                repeat(3) { shake.animateTo(13f, tween(42)); shake.animateTo(-13f, tween(42)) }
                shake.animateTo(0f, tween(42))
            }
        }
        Surface(color = LessonPanel, shadowElevation = 2.dp, shape = RoundedCornerShape(22.dp), modifier = Modifier.graphicsLayer { translationX = shake.value }) {
            Column(Modifier.fillMaxWidth().padding(18.dp)) {
                Text(skillLabel(exercise.skill).uppercase(Locale.forLanguageTag("tr-TR")), color = LessonGold, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(exercise.instructionTr, color = LessonMuted, fontSize = 13.sp, modifier = Modifier.padding(top = 6.dp, bottom = 14.dp))
                if ((exercise.skill == Skill.READING || exercise.skill == Skill.WRITING || exercise.skill == Skill.VOCABULARY) && exercise.context.isNotBlank()) {
                    Surface(color = LessonPanel2, shape = RoundedCornerShape(14.dp)) {
                        Text(exercise.context, fontSize = 16.sp, lineHeight = 25.sp, modifier = Modifier.fillMaxWidth().padding(14.dp))
                    }
                    Spacer(Modifier.height(14.dp))
                }
                if (exercise.skill == Skill.LISTENING) {
                    Surface(color = LessonPanel2, shape = RoundedCornerShape(14.dp)) {
                        Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.VolumeUp, null, tint = LessonGold)
                            Text(
                                if (ttsReady) "Önce sesi dinle; metin yanıtından sonra gösterilir."
                                else "Cihazda bu dil için ses paketi yok — cümleyi okuyarak yanıtla: $modelText",
                                color = LessonMuted, fontSize = 13.sp, modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    OutlinedButton(onClick = { speak(tts.value, modelText) }, enabled = ttsReady, modifier = Modifier.fillMaxWidth()) {
                        Icon(Icons.Default.VolumeUp, null); Text(if (ttsReady) "$courseLangName sesi dinle" else "Ses hazırlanıyor…", modifier = Modifier.padding(start = 8.dp))
                    }
                    Spacer(Modifier.height(14.dp))
                }
                if (exercise.skill == Skill.SPEAKING) {
                    Surface(color = LessonPanel2, shape = RoundedCornerShape(14.dp)) {
                        Column(Modifier.fillMaxWidth().padding(14.dp)) {
                            Text("Örnek ifade", color = LessonGold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Text(modelText, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 7.dp))
                            OutlinedButton(onClick = { speak(tts.value, modelText) }, enabled = ttsReady, modifier = Modifier.padding(top = 8.dp)) {
                                Icon(Icons.Default.VolumeUp, null); Text("Örneği dinle", modifier = Modifier.padding(start = 7.dp))
                            }
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                }
                val isWordBank = exercise.skill == Skill.GRAMMAR && exercise.options.isNotEmpty() && exercise.prompt.contains("___")
                if (exercise.options.isNotEmpty() && exercise.skill != Skill.LISTENING) {
                    // Duolingo tarzı: soruyu dersin karakteri sunar (dinlemede ses düğmesi esastır, balon gösterilmez)
                    Row(verticalAlignment = Alignment.Bottom) {
                        AvatarView(lessonCast[kotlin.math.abs(exercise.id.hashCode()) % lessonCast.size], 82.dp)
                        Surface(
                            color = LessonPanel2,
                            shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp, bottomEnd = 18.dp, bottomStart = 4.dp),
                            border = BorderStroke(1.dp, Color(0x26FFFFFF)),
                            modifier = Modifier.padding(start = 8.dp, bottom = 12.dp).weight(1f)
                        ) {
                            if (isWordBank) {
                                val filledWord = exercise.options.getOrNull(selected)
                                val promptParts = exercise.prompt.split("___", limit = 2)
                                Text(
                                    androidx.compose.ui.text.buildAnnotatedString {
                                        append(promptParts.getOrElse(0) { "" })
                                        if (filledWord != null) {
                                            pushStyle(androidx.compose.ui.text.SpanStyle(color = LessonGold, fontWeight = FontWeight.ExtraBold))
                                            append(filledWord)
                                            pop()
                                        } else append("____")
                                        append(promptParts.getOrElse(1) { "" })
                                    },
                                    color = LessonText, fontSize = 18.sp, lineHeight = 26.sp, fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
                                )
                            } else {
                                Text(exercise.prompt, color = LessonText, fontSize = 18.sp, lineHeight = 26.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp))
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                } else {
                    Text(exercise.prompt, fontSize = 21.sp, fontWeight = FontWeight.Bold, lineHeight = 28.sp)
                    Spacer(Modifier.height(14.dp))
                }

                if (exercise.skill == Skill.WRITING) {
                    exercise.writingRequirements?.let { requirements ->
                        Text("Yanıtını kontrol ederken", color = LessonGold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        requirements.checklistTr.forEach { criterion ->
                            Text("• $criterion", color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 4.dp))
                        }
                        val minimum = requirements.minimumWords
                        val maximum = requirements.maximumWords
                        if (minimum != null && maximum != null) {
                            val count = answer.trim().split(Regex("\\s+")).count { it.isNotBlank() }
                            Text("Kelime sayısı: $count • Hedef: $minimum–$maximum", color = LessonGold, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp))
                        }
                        Spacer(Modifier.height(12.dp))
                    }
                }

                if (isWordBank) {
                    // Kelime bankası: boşluğu doldurmak için kelimeye dokun; tekrar dokununca geri gelir
                    Text("Boşluğu doldurmak için kelimeye dokun", color = LessonMuted, fontSize = 12.sp, modifier = Modifier.padding(bottom = 8.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        exercise.options.forEachIndexed { optionIndex, option ->
                            val chosen = selected == optionIndex
                            Surface(
                                onClick = { if (!submitted) selected = if (chosen) -1 else optionIndex },
                                color = if (chosen) Color(0x14FFFFFF) else LessonPanel2,
                                shape = RoundedCornerShape(14.dp),
                                border = BorderStroke(1.dp, if (chosen) Color(0x59C6FF4A) else Color(0x26FFFFFF)),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    option,
                                    color = if (chosen) Color(0x33F5F1FF) else LessonText,
                                    fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, maxLines = 2, lineHeight = 17.sp,
                                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp)
                                )
                            }
                        }
                    }
                } else if (exercise.options.isNotEmpty()) {
                    // 2×2 büyük kare seçenekler
                    exercise.options.withIndex().chunked(2).forEach { rowItems ->
                        Row(Modifier.fillMaxWidth().padding(vertical = 5.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            rowItems.forEach { (optionIndex, option) ->
                                val chosen = selected == optionIndex
                                Surface(
                                    onClick = { if (!submitted) selected = optionIndex },
                                    color = if (chosen) Color(0xFF3E2B6E) else LessonPanel2,
                                    shape = RoundedCornerShape(18.dp),
                                    border = BorderStroke(if (chosen) 2.dp else 1.dp, if (chosen) LessonGold else Color(0x26FFFFFF)),
                                    modifier = Modifier.weight(1f).height(96.dp)
                                ) {
                                    Box(Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
                                        Text(option, color = LessonText, fontSize = 15.sp, lineHeight = 20.sp, textAlign = TextAlign.Center, fontWeight = if (chosen) FontWeight.Bold else FontWeight.Medium)
                                    }
                                }
                            }
                            if (rowItems.size == 1) Spacer(Modifier.weight(1f))
                        }
                    }
                } else if (exercise.skill == Skill.SPEAKING) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { permissionLauncher.launch(android.Manifest.permission.RECORD_AUDIO) },
                            enabled = !submitted && !isListening,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = LessonGold, contentColor = LessonNavy)
                        ) {
                            Text(if (isListening) "Dinliyorum…" else "Dokun ve İngilizce konuş", fontWeight = FontWeight.Bold)
                        }
                        ListeningMic(active = isListening, level = micLevel, modifier = Modifier.padding(start = 12.dp))
                    }
                    if (speechText.isNotBlank()) Text("Algılanan ifade: $speechText", color = LessonMuted, fontSize = 13.sp, modifier = Modifier.padding(top = 10.dp))
                    if (speechMessage.isNotBlank()) Text(speechMessage, color = Color(0xFFFFCC80), fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 8.dp))
                    OutlinedTextField(
                        value = answer,
                        onValueChange = { if (!submitted) answer = it },
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                        label = { Text("İstersen cümleyi buraya yaz") },
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LessonGold, unfocusedBorderColor = LessonPanel2, focusedLabelColor = LessonGold, unfocusedLabelColor = LessonMuted, cursorColor = LessonGold)
                    )
                    Text("Konuşma tanıma metni değerlendirir; ses kalitesi veya telaffuz puanı vermez.", color = LessonMuted, fontSize = 11.sp, lineHeight = 16.sp, modifier = Modifier.padding(top = 8.dp))
                } else {
                    OutlinedTextField(
                        value = answer,
                        onValueChange = { if (!submitted) answer = it },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = if (exercise.skill == Skill.WRITING) 3 else 1,
                        label = { Text(if (exercise.skill == Skill.WRITING) "Yanıtını $courseLangName yaz" else "Yanıt") },
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LessonGold, unfocusedBorderColor = LessonPanel2, focusedLabelColor = LessonGold, unfocusedLabelColor = LessonMuted, cursorColor = LessonGold)
                    )
                }
            }
        }

        if (submitted) {
            val isWriting = exercise.skill == Skill.WRITING
            val correct = result == true
            if (!isWriting && correct) ConfettiBurst(Modifier.fillMaxWidth().height(58.dp).padding(top = 6.dp))
            AnimatedVisibility(
                visibleState = remember { androidx.compose.animation.core.MutableTransitionState(false).apply { targetState = true } },
                enter = slideInVertically(initialOffsetY = { it / 2 }, animationSpec = tween(260)) + fadeIn(tween(260))
            ) {
            val onFeedback = if (isWriting) LessonText else Color(0xFF1A0E2E)
            val onFeedbackSoft = if (isWriting) LessonMuted else Color(0xCC1A0E2E)
            Surface(color = if (isWriting) LessonPanel2 else if (correct) LessonGold else LessonPink, shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(top = 14.dp)) {
                Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.Top) {
                    Icon(if (isWriting || correct) Icons.Default.CheckCircle else Icons.Default.Close, null, tint = if (isWriting) LessonGold else Color(0xFF1A0E2E))
                    Column(Modifier.padding(start = 10.dp)) {
                        Text(if (isWriting) "Yanıtın kaydedildi" else if (correct) "Doğru yanıt" else "Bir kez daha düşün", color = onFeedback, fontWeight = FontWeight.Bold)
                        Text(exercise.explanationTr, color = onFeedbackSoft, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 4.dp))
                        if (!isWriting && !correct) Text("Örnek yanıt: ${exercise.acceptedAnswers.firstOrNull().orEmpty()}", color = onFeedback, fontWeight = FontWeight.Bold, fontSize = 12.sp, modifier = Modifier.padding(top = 5.dp))
                        if (isWriting) {
                            Text("Açık uçlu yazı henüz otomatik puanlanmıyor. Yanıtını aşağıdaki örnekle karşılaştır.", color = LessonMuted, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 5.dp))
                            val sample = exercise.sampleAnswer ?: exercise.acceptedAnswers.firstOrNull().orEmpty()
                            if (sample.isNotBlank()) Text("Örnek yanıt: $sample", color = LessonGold, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 6.dp))
                            val coaching = WritingCoach.review(answer, sample, exercise.writingRequirements)
                            coaching.strengths.forEach { Text("✓ $it", color = LessonMint, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 5.dp)) }
                            coaching.suggestions.forEach { Text("• $it", color = LessonGold, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 4.dp)) }
                            Text("Otomatik dilbilgisi puanı verilmez; öneriler temel biçim kontrolüdür.", color = LessonMuted, fontSize = 10.sp, lineHeight = 14.sp, modifier = Modifier.padding(top = 6.dp))
                        }
                    }
                }
            }
            }
        }
        Spacer(Modifier.height(16.dp))
        LessonButton(if (submitted && result == false) "Tekrar dene" else if (submitted && index.intValue == lesson.exercises.lastIndex) "Dersi tamamla" else if (submitted) "Sonraki etkinlik" else "Yanıtı kontrol et") {
            if (submitted) {
                if (result == false) {
                    selected = -1
                    answer = ""
                    speechText = ""
                    result = null
                    submitted = false
                } else if (index.intValue >= lesson.exercises.lastIndex) {
                    finalScore = LessonScoring.accuracyPercent(correctCount, gradedCount) ?: -1
                    lessonFinished = true
                } else index.intValue++
            } else {
                val typedAnswer = if (exercise.options.isNotEmpty()) exercise.options.getOrNull(selected).orEmpty() else answer
                if (typedAnswer.isBlank()) return@LessonButton
                if (exercise.skill == Skill.WRITING) {
                    submitted = true
                    result = null
                } else {
                    val isCorrect = if (exercise.skill == Skill.SPEAKING && exercise.options.isEmpty())
                        AnswerChecker.matches(typedAnswer, exercise.acceptedAnswers)
                    else AnswerChecker.matchesClosed(typedAnswer, exercise.acceptedAnswers)
                    result = isCorrect
                    onExerciseResult(exercise.id, exercise.skill, isCorrect)
                    gradedCount++
                    if (isCorrect) correctCount++
                    submitted = true
                    playFeedbackTone(soundOn, isCorrect)
                    if (isCorrect) { comboStreak++; if (comboStreak % 5 == 0) comboCelebrate = comboStreak } else comboStreak = 0
                }
            }
        }
        Spacer(Modifier.height(22.dp))
    }
}

@Composable
private fun LessonCompletion(lesson: LearningLesson, correct: Int, graded: Int, score: Int, onContinue: () -> Unit, onRetry: (() -> Unit)? = null) {
    val isScored = score >= 0
    val xp = LessonScoring.xpForCompletion(score.takeIf { it >= 0 })
    val isCheckpoint = lesson.id.endsWith("-CP")
    val isRefresh = lesson.id.endsWith("-REFRESH")
    val checkpointPassed = isCheckpoint && score >= 80
    val headline = when {
        isCheckpoint && checkpointPassed -> "Checkpoint geçildi!"
        isCheckpoint -> "Checkpoint geçilemedi"
        isRefresh -> "Günlük tekrar tamamlandı"
        else -> "Ders tamamlandı"
    }
    val soundPrefs = LocalContext.current.getSharedPreferences("lingua_course", android.content.Context.MODE_PRIVATE)
    val ringProgress = remember { Animatable(0f) }
    var shownXp by remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) {
        playCompletionMelody(soundPrefs.getBoolean("sound_on", true))
        ringProgress.animateTo(if (isScored) score / 100f else 1f, tween(1100))
    }
    LaunchedEffect(Unit) {
        val steps = 24
        repeat(steps + 1) { stepIndex -> shownXp = xp * stepIndex / steps; delay(40) }
    }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        if (score >= 80) ConfettiBurst(Modifier.fillMaxWidth().height(64.dp))
        // Çizilerek dolan sonuç halkası + 0'dan sayan XP
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(152.dp)) {
            Canvas(Modifier.fillMaxSize()) {
                val strokeWidth = 13.dp.toPx()
                drawArc(color = Color(0x26FFFFFF), startAngle = -90f, sweepAngle = 360f, useCenter = false, style = Stroke(strokeWidth, cap = StrokeCap.Round))
                drawArc(color = if (isCheckpoint && !checkpointPassed) LessonPink else LessonGold, startAngle = -90f, sweepAngle = 360f * ringProgress.value, useCenter = false, style = Stroke(strokeWidth, cap = StrokeCap.Round))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(if (isScored) "%$score" else "✓", color = LessonText, fontSize = 31.sp, fontWeight = FontWeight.ExtraBold)
                Text("+$shownXp XP", color = LessonGold, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        }
        Text(headline, color = LessonText, fontSize = 27.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 14.dp))
        Text(lesson.title, color = Color(0xFFCBBDE8), fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 5.dp))
        if (isCheckpoint && !checkpointPassed) {
            Text("Bu üniteyi geçmek için en az %80 doğruluk gerekli. Ünite derslerini tekrar edip yeniden dene.", color = Color(0xFFFFD2D2), fontSize = 13.sp, lineHeight = 18.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp))
        }
        Spacer(Modifier.height(20.dp))
        Surface(color = LessonPanel, shadowElevation = 2.dp, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(if (isScored) "$correct doğru yanıt • $graded otomatik değerlendirilen deneme" else "Açık uçlu yazma etkinliğini tamamladın; otomatik puan üretilmedi.", color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 6.dp))
                Text("${lesson.exercises.size} etkinliği tamamladın.", color = LessonText, fontSize = 13.sp, modifier = Modifier.padding(top = 8.dp))
            }
        }
        if (lesson.exercises.any { it.skill == Skill.WRITING }) {
            Text("Yazma yanıtları otomatik puanlanmadı; örnek yanıtları kendi çalışmanla karşılaştır.", color = Color(0xFFCBBDE8), fontSize = 12.sp, lineHeight = 17.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp))
        }
        Spacer(Modifier.height(20.dp))
        val checkpointFailed = isCheckpoint && !checkpointPassed
        if (checkpointFailed && onRetry != null) {
            LessonButton("Yeniden dene", onRetry)
            Spacer(Modifier.height(10.dp))
        }
        LessonButton("Öğrenme yoluma dön", onContinue)
    }
}

private fun engineLanguageSetup(engine: TextToSpeech?, accent: String, speechRate: Float): Boolean {
    if (engine == null) return false
    val locale = Locale.forLanguageTag(accent)
    val availability = engine.setLanguage(locale)
    if (availability == TextToSpeech.LANG_MISSING_DATA || availability == TextToSpeech.LANG_NOT_SUPPORTED) return false
    engine.setSpeechRate(speechRate)
    return true
}

private fun speak(engine: TextToSpeech?, text: String) {
    if (text.isNotBlank()) engine?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "linguapro-lesson-audio")
}

fun skillLabel(skill: Skill): String = when (skill) {
    Skill.LISTENING -> "Dinleme"
    Skill.READING -> "Okuma"
    Skill.SPEAKING -> "Konuşma"
    Skill.WRITING -> "Yazma"
    Skill.GRAMMAR -> "Dil bilgisi"
    Skill.VOCABULARY -> "Kelime"
}

@Composable
private fun ConfettiBurst(modifier: Modifier = Modifier) {
    val burst = remember { Animatable(0f) }
    LaunchedEffect(Unit) { burst.animateTo(1f, tween(950)) }
    val palette = listOf(Color(0xFFC6FF4A), Color(0xFFFF5CA8), Color(0xFF7DD3FC), Color(0xFFFFD166), Color(0xFFB791FF))
    val seeds = remember { List(26) { i -> Triple((i * 37 % 100) / 100f, (i * 53 % 100) / 100f, palette[i % palette.size]) } }
    Canvas(modifier) {
        val p = burst.value
        if (p >= 1f) return@Canvas
        seeds.forEach { (sx, sv, color) ->
            val x = size.width * sx
            val y = size.height * (1f - p * (0.4f + 0.6f * sv))
            drawCircle(color = color.copy(alpha = (1f - p).coerceIn(0f, 1f)), radius = 4.dp.toPx() * (0.5f + sv), center = Offset(x, y))
        }
    }
}

// ---- Pluck ses sentezleyici: AudioTrack ile üretilen kısa, yumuşak tonlar ----
private const val SOUND_SAMPLE_RATE = 44100

/** Doğal sönümlenmeli tek "pluck" notası üretir (telli çalgı hissi). */
private fun pluckNote(frequencyHz: Double, durationMs: Int, amplitude: Double = 0.55): ShortArray {
    val sampleCount = SOUND_SAMPLE_RATE * durationMs / 1000
    return ShortArray(sampleCount) { i ->
        val t = i.toDouble() / SOUND_SAMPLE_RATE
        val envelope = kotlin.math.exp(-5.5 * i / sampleCount)
        val wave = kotlin.math.sin(2.0 * Math.PI * frequencyHz * t) +
            0.35 * kotlin.math.sin(4.0 * Math.PI * frequencyHz * t)
        (wave / 1.35 * envelope * amplitude * Short.MAX_VALUE).toInt()
            .coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
    }
}

/** Notaları araya kısa sessizlik koyarak tek tampon halinde birleştirir. */
private fun joinNotes(vararg notes: ShortArray, gapMs: Int = 28): ShortArray {
    val gap = ShortArray(SOUND_SAMPLE_RATE * gapMs / 1000)
    val total = notes.sumOf { it.size } + gap.size * (notes.size - 1).coerceAtLeast(0)
    val out = ShortArray(total)
    var pos = 0
    notes.forEachIndexed { i, n ->
        n.copyInto(out, pos); pos += n.size
        if (i < notes.lastIndex) { gap.copyInto(out, pos); pos += gap.size }
    }
    return out
}

private fun playPcm(samples: ShortArray) {
    runCatching {
        val track = android.media.AudioTrack(
            android.media.AudioAttributes.Builder()
                .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                .setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC)
                .build(),
            android.media.AudioFormat.Builder()
                .setSampleRate(SOUND_SAMPLE_RATE)
                .setEncoding(android.media.AudioFormat.ENCODING_PCM_16BIT)
                .setChannelMask(android.media.AudioFormat.CHANNEL_OUT_MONO)
                .build(),
            samples.size * 2,
            android.media.AudioTrack.MODE_STATIC,
            android.media.AudioManager.AUDIO_SESSION_ID_GENERATE
        )
        track.write(samples, 0, samples.size)
        track.play()
        val durationMs = samples.size * 1000L / SOUND_SAMPLE_RATE
        android.os.Handler(android.os.Looper.getMainLooper())
            .postDelayed({ runCatching { track.release() } }, durationMs + 250L)
    }
}

/** Kısa "pluck" geri bildirimi: doğruda yükselen iki nota, yanlışta pes tek nota. */
private fun playFeedbackTone(enabled: Boolean, correct: Boolean) {
    if (!enabled) return
    playPcm(
        if (correct) joinNotes(pluckNote(659.25, 130), pluckNote(987.77, 210))
        else pluckNote(196.0, 260, amplitude = 0.5)
    )
}

/** Ders sonunda dört notalık kısa kutlama arpeji. */
private fun playCompletionMelody(enabled: Boolean) {
    if (!enabled) return
    playPcm(
        joinNotes(
            pluckNote(523.25, 150), pluckNote(659.25, 150),
            pluckNote(783.99, 150), pluckNote(1046.50, 320)
        )
    )
}

@Composable
private fun LessonColumn(content: @Composable ColumnScope.() -> Unit) {
    Column(Modifier.fillMaxSize().padding(22.dp), verticalArrangement = Arrangement.Center, content = content)
}

@Composable
private fun LessonButton(label: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth().height(54.dp), shape = RoundedCornerShape(15.dp), colors = ButtonDefaults.buttonColors(containerColor = LessonGold, contentColor = LessonNavy)) {
        Text(label, fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }
}

@Composable
private fun ListeningMic(active: Boolean, level: Float, modifier: Modifier = Modifier) {
    val infinite = rememberInfiniteTransition(label = "mic")
    val pulse by infinite.animateFloat(
        initialValue = 0.94f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(tween(380, easing = LinearEasing), RepeatMode.Reverse),
        label = "pulse"
    )
    val wiggle by infinite.animateFloat(
        initialValue = -7f,
        targetValue = 7f,
        animationSpec = infiniteRepeatable(tween(110, easing = LinearEasing), RepeatMode.Reverse),
        label = "wiggle"
    )
    val ringScale = if (active) 0.78f + 0.45f * level + (pulse - 1f) else 0f
    val iconScale = if (active) pulse + level * 0.25f else 1f
    Box(contentAlignment = Alignment.Center, modifier = modifier.size(46.dp)) {
        if (active) {
            Box(
                Modifier
                    .size(46.dp)
                    .graphicsLayer { scaleX = ringScale; scaleY = ringScale; alpha = 0.3f }
                    .background(LessonGold, CircleShape)
            )
        }
        Box(
            Modifier
                .size(32.dp)
                .graphicsLayer {
                    scaleX = iconScale; scaleY = iconScale
                    rotationZ = if (active) wiggle * (0.35f + 0.65f * level) else 0f
                }
                .background(if (active) LessonGold else LessonPanel2, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Mic,
                contentDescription = if (active) "Dinleniyor" else "Mikrofon",
                tint = if (active) Color(0xFFFFFFFF) else LessonMuted,
                modifier = Modifier.size(17.dp)
            )
        }
    }
}
