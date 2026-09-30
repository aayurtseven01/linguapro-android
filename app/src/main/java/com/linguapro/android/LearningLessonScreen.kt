package com.linguapro.android

import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

private val LessonNavy = Color(0xFFFFFFFF)
private val LessonPanel = Color(0xFFF7F7F7)
private val LessonPanel2 = Color(0xFFEFEFEF)
private val LessonGold = Color(0xFF58CC02)
private val LessonMuted = Color(0xFF777777)
private val LessonMint = Color(0xFF1CB0F6)

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
    val index = rememberSaveable(lesson.id, exerciseIndex) { mutableIntStateOf(exerciseIndex) }
    val exercise = lesson.exercises.getOrNull(index.intValue)
    var selected by rememberSaveable(lesson.id, index.intValue) { mutableIntStateOf(-1) }
    var answer by rememberSaveable(lesson.id, index.intValue) { mutableStateOf("") }
    var submitted by rememberSaveable(lesson.id, index.intValue) { mutableStateOf(false) }
    var result by rememberSaveable(lesson.id, index.intValue) { mutableStateOf<Boolean?>(null) }
    var speechText by rememberSaveable(lesson.id, index.intValue) { mutableStateOf("") }
    var speechMessage by rememberSaveable(lesson.id, index.intValue) { mutableStateOf("") }
    var correctCount by rememberSaveable(lesson.id, exerciseIndex) { mutableIntStateOf(0) }
    var gradedCount by rememberSaveable(lesson.id, exerciseIndex) { mutableIntStateOf(0) }
    var lessonFinished by rememberSaveable(lesson.id, exerciseIndex) { mutableStateOf(false) }
    var finalScore by rememberSaveable(lesson.id, exerciseIndex) { mutableIntStateOf(0) }
    var ttsReady by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val tts = remember { mutableStateOf<TextToSpeech?>(null) }

    DisposableEffect(context, ttsAccent, speechRate) {
        val engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                ttsReady = engineLanguageSetup(tts.value, ttsAccent, speechRate)
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

    val speechLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        if (activityResult.resultCode == android.app.Activity.RESULT_OK) {
            val recognized = activityResult.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.firstOrNull().orEmpty()
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
    }
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
                putExtra(RecognizerIntent.EXTRA_PROMPT, "İngilizce cümleyi söyle")
            }
            runCatching { speechLauncher.launch(intent) }
                .onFailure { speechMessage = "Bu cihazda konuşma tanıma açılamadı. Cümleyi aşağıya yazabilirsin." }
        } else {
            speechMessage = "Mikrofon izni verilmedi. Cümleyi aşağıya yazarak devam edebilirsin."
        }
    }

    if (lessonFinished) {
        LessonCompletion(lesson = lesson, correct = correctCount, graded = gradedCount, score = finalScore, onContinue = { onDone(finalScore.takeIf { it >= 0 }) })
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
        LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth().height(8.dp), color = LessonGold, trackColor = Color(0x55FFFFFF))
        Text("Etkinlik ${index.intValue + 1} / ${lesson.exercises.size}", color = Color(0xFFDFF3FF), fontSize = 12.sp, modifier = Modifier.align(Alignment.End).padding(top = 5.dp))
        Spacer(Modifier.height(14.dp))

        if (index.intValue == 0 && lesson.targetVocabulary.isNotEmpty()) {
            Surface(color = LessonPanel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                Column(Modifier.padding(15.dp)) {
                    Text("Hedef kelimeler • ${lesson.targetVocabulary.size}", color = LessonGold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    lesson.targetVocabulary.forEach { word ->
                        Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(word.emoji, fontSize = 23.sp)
                            Column(Modifier.weight(1f).padding(start = 10.dp)) {
                                Text("${word.termEn} • ${word.translationTr}", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(word.exampleEn, color = Color(0xFF4B4B4B), fontSize = 12.sp, modifier = Modifier.padding(top = 2.dp))
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

        Surface(color = LessonPanel, shape = RoundedCornerShape(22.dp)) {
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
                            Text("Önce sesi dinle; metin yanıtından sonra gösterilir.", color = LessonMuted, fontSize = 13.sp, modifier = Modifier.padding(start = 10.dp))
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    OutlinedButton(onClick = { speak(tts.value, modelText) }, enabled = ttsReady, modifier = Modifier.fillMaxWidth()) {
                        Icon(Icons.Default.VolumeUp, null); Text(if (ttsReady) "İngilizce sesi dinle" else "Ses hazırlanıyor…", modifier = Modifier.padding(start = 8.dp))
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
                    Button(
                        onClick = { permissionLauncher.launch(android.Manifest.permission.RECORD_AUDIO) },
                        enabled = !submitted,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = LessonGold, contentColor = LessonNavy)
                    ) {
                        Icon(Icons.Default.Mic, null); Text("  Dokun ve İngilizce konuş", fontWeight = FontWeight.Bold)
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
                        label = { Text(if (exercise.skill == Skill.WRITING) "Yanıtını İngilizce yaz" else "Yanıt") },
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LessonGold, unfocusedBorderColor = LessonPanel2, focusedLabelColor = LessonGold, unfocusedLabelColor = LessonMuted, cursorColor = LessonGold)
                    )
                }
            }
        }

        if (submitted) {
            val isWriting = exercise.skill == Skill.WRITING
            val correct = result == true
            Surface(color = if (isWriting) LessonPanel2 else if (correct) Color(0xFFD7FFB8) else Color(0xFFFFDFE0), shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(top = 14.dp)) {
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
private fun LessonCompletion(lesson: LearningLesson, correct: Int, graded: Int, score: Int, onContinue: () -> Unit) {
    val isScored = score >= 0
    val xp = LessonScoring.xpForCompletion(score.takeIf { it >= 0 })
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(if (score >= 80) "🎉" else "✨", fontSize = 62.sp)
        Text("Ders tamamlandı", color = Color(0xFFFFFFFF), fontSize = 27.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 14.dp))
        Text(lesson.title, color = Color(0xFFDFF3FF), fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 5.dp))
        Spacer(Modifier.height(20.dp))
        Surface(color = LessonPanel, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("+$xp XP", color = LessonGold, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                Text(if (isScored) "$correct doğru yanıt • $graded otomatik değerlendirilen deneme" else "Açık uçlu yazma etkinliğini tamamladın; otomatik puan üretilmedi.", color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 6.dp))
                Text("${lesson.exercises.size} etkinliği tamamladın.", color = Color(0xFF4B4B4B), fontSize = 13.sp, modifier = Modifier.padding(top = 8.dp))
            }
        }
        if (lesson.exercises.any { it.skill == Skill.WRITING }) {
            Text("Yazma yanıtları otomatik puanlanmadı; örnek yanıtları kendi çalışmanla karşılaştır.", color = Color(0xFFDFF3FF), fontSize = 12.sp, lineHeight = 17.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp))
        }
        Spacer(Modifier.height(20.dp))
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
