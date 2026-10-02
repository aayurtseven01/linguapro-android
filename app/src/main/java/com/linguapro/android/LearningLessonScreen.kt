package com.linguapro.android

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

private val LessonNavy = Color(0xFFFFFFFF)
private val LessonPanel = Color(0xFFFFFFFF)
private val LessonPanel2 = Color(0xFFF0F3F8)
private val LessonGold = Color(0xFF0A6ED1)
private val LessonMuted = Color(0xFF5B6475)
private val LessonMint = Color(0xFF12B76A)

@Composable
fun LearningLessonScreen(
    lesson: LearningLesson,
    exerciseIndex: Int,
    onBack: () -> Unit,
    onExerciseResult: (exerciseId: String, skill: Skill, correct: Boolean) -> Unit,
    onDone: (Int?) -> Unit,
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
    var finalScore by rememberSaveable(lesson.id, exerciseIndex, attempt) { mutableIntStateOf(0) }
    var ttsReady by remember { mutableStateOf(false) }
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
                if (error == SpeechRecognizer.ERROR_NO_MATCH || error == SpeechRecognizer.ERROR_SPEECH_TIMEOUT) {
                    speechMessage = "Ses algılanamadı. Tekrar dene veya cümleyi aşağıya yaz."
                }
            }
            override fun onPartialResults(partialResults: Bundle?) {
                val partial = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)?.firstOrNull().orEmpty()
                if (partial.isNotBlank()) speechText = partial
            }
            override fun onResults(results: Bundle?) {
                isListening = false; micLevel = 0f
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
        LessonCompletion(lesson = lesson, correct = correctCount, graded = gradedCount, score = finalScore, onContinue = { onDone(finalScore.takeIf { it >= 0 }) }, onRetry = { attempt++ })
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
            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Geri", tint = Color(0xFFFFFFFF)) }
            Column(Modifier.weight(1f)) {
                Text(lesson.title, color = Color(0xFFFFFFFF), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("${lesson.id} • ${skillLabel(exercise.skill)}", color = Color(0xFFDFF3FF), fontSize = 12.sp)
            }
        }
        Text(lesson.canDo, color = Color(0xFFDFF3FF), fontSize = 13.sp, modifier = Modifier.padding(start = 6.dp, top = 3.dp, bottom = 14.dp))
        LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth().height(8.dp), color = Color(0xFFFFFFFF), trackColor = Color(0x44FFFFFF))
        Text("Etkinlik ${index.intValue + 1} / ${lesson.exercises.size}", color = Color(0xFFDFF3FF), fontSize = 12.sp, modifier = Modifier.align(Alignment.End).padding(top = 5.dp))
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
                                Text(word.exampleEn, color = Color(0xFF1A1D29), fontSize = 12.sp, modifier = Modifier.padding(top = 2.dp))
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

        Surface(color = LessonPanel, shadowElevation = 2.dp, shape = RoundedCornerShape(22.dp)) {
            Column(Modifier.fillMaxWidth().padding(18.dp)) {
                Text(skillLabel(exercise.skill).uppercase(Locale.forLanguageTag("tr-TR")), color = LessonGold, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(exercise.instructionTr, color = LessonMuted, fontSize = 13.sp, modifier = Modifier.padding(top = 6.dp, bottom = 14.dp))
                if (exercise.skill == Skill.READING && exercise.context.isNotBlank()) {
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
                Text(exercise.prompt, fontSize = 21.sp, fontWeight = FontWeight.Bold, lineHeight = 28.sp)
                Spacer(Modifier.height(14.dp))

                if (exercise.options.isNotEmpty()) {
                    exercise.options.forEachIndexed { optionIndex, option ->
                        val chosen = selected == optionIndex
                        Surface(
                            onClick = { if (!submitted) selected = optionIndex },
                            color = if (chosen) Color(0xFFDDF4FF) else LessonPanel2,
                            shape = RoundedCornerShape(13.dp),
                            border = BorderStroke(if (chosen) 2.dp else 1.dp, if (chosen) LessonGold else Color(0xFFE5E5E5)),
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                        ) {
                            Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(selected = chosen, onClick = { if (!submitted) selected = optionIndex }, colors = RadioButtonDefaults.colors(selectedColor = LessonGold, unselectedColor = LessonMuted))
                                Text(option, fontSize = 15.sp, modifier = Modifier.padding(start = 8.dp))
                            }
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
            Surface(color = if (isWriting) LessonPanel2 else if (correct) Color(0xFFE6F6E0) else Color(0xFFFDE8E8), shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(top = 14.dp)) {
                Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.Top) {
                    Icon(if (isWriting || correct) Icons.Default.CheckCircle else Icons.Default.Close, null, tint = if (isWriting || correct) Color(0xFF58A700) else Color(0xFFEA2B2B))
                    Column(Modifier.padding(start = 10.dp)) {
                        Text(if (isWriting) "Yanıtın kaydedildi" else if (correct) "Doğru yanıt" else "Bir kez daha düşün", fontWeight = FontWeight.Bold)
                        Text(exercise.explanationTr, color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 4.dp))
                        if (!isWriting && !correct) Text("Örnek yanıt: ${exercise.acceptedAnswers.firstOrNull().orEmpty()}", color = LessonGold, fontSize = 12.sp, modifier = Modifier.padding(top = 5.dp))
                        if (isWriting) {
                            Text("Açık uçlu yazı henüz otomatik puanlanmıyor. Yanıtını aşağıdaki örnekle karşılaştır.", color = LessonMuted, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 5.dp))
                            val sample = exercise.sampleAnswer ?: exercise.acceptedAnswers.firstOrNull().orEmpty()
                            if (sample.isNotBlank()) Text("Örnek yanıt: $sample", color = LessonGold, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 6.dp))
                            val coaching = WritingCoach.review(answer, sample)
                            coaching.strengths.forEach { Text("✓ $it", color = LessonMint, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 5.dp)) }
                            coaching.suggestions.forEach { Text("• $it", color = LessonGold, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 4.dp)) }
                            Text("Otomatik dilbilgisi puanı verilmez; öneriler temel biçim kontrolüdür.", color = LessonMuted, fontSize = 10.sp, lineHeight = 14.sp, modifier = Modifier.padding(top = 6.dp))
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
                    val isCorrect = AnswerChecker.matches(typedAnswer, exercise.acceptedAnswers)
                    result = isCorrect
                    onExerciseResult(exercise.id, exercise.skill, isCorrect)
                    gradedCount++
                    if (isCorrect) correctCount++
                    submitted = true
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
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(if (score >= 80) "🎉" else if (isCheckpoint) "🔁" else "✨", fontSize = 62.sp)
        Text(headline, color = Color(0xFFFFFFFF), fontSize = 27.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 14.dp))
        Text(lesson.title, color = Color(0xFFDFF3FF), fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 5.dp))
        if (isCheckpoint && !checkpointPassed) {
            Text("Bu üniteyi geçmek için en az %80 doğruluk gerekli. Ünite derslerini tekrar edip yeniden dene.", color = Color(0xFFFFD2D2), fontSize = 13.sp, lineHeight = 18.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp))
        }
        Spacer(Modifier.height(20.dp))
        Surface(color = LessonPanel, shadowElevation = 2.dp, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("+$xp XP", color = LessonGold, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                Text(if (isScored) "$correct doğru yanıt • $graded otomatik değerlendirilen deneme" else "Açık uçlu yazma etkinliğini tamamladın; otomatik puan üretilmedi.", color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 6.dp))
                Text("${lesson.exercises.size} etkinliği tamamladın.", color = Color(0xFF1A1D29), fontSize = 13.sp, modifier = Modifier.padding(top = 8.dp))
            }
        }
        if (lesson.exercises.any { it.skill == Skill.WRITING }) {
            Text("Yazma yanıtları otomatik puanlanmadı; örnek yanıtları kendi çalışmanla karşılaştır.", color = Color(0xFFDFF3FF), fontSize = 12.sp, lineHeight = 17.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp))
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
