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
import java.text.Normalizer
import java.util.Locale

private val LessonNavy = Color(0xFF071D32)
private val LessonPanel = Color(0xFF112B46)
private val LessonPanel2 = Color(0xFF183653)
private val LessonGold = Color(0xFFF2BE45)
private val LessonMuted = Color(0xFFA9BED2)
private val LessonMint = Color(0xFF63D2B0)

@Composable
fun LearningLessonScreen(
    lesson: LearningLesson,
    exerciseIndex: Int,
    onBack: () -> Unit,
    onDone: (Int) -> Unit
) {
    val index = rememberSaveable(lesson.id) { mutableIntStateOf(exerciseIndex) }
    val exercise = lesson.exercises.getOrNull(index.intValue)
    var selected by rememberSaveable(lesson.id, index.intValue) { mutableIntStateOf(-1) }
    var answer by rememberSaveable(lesson.id, index.intValue) { mutableStateOf("") }
    var submitted by rememberSaveable(lesson.id, index.intValue) { mutableStateOf(false) }
    var result by rememberSaveable(lesson.id, index.intValue) { mutableStateOf<Boolean?>(null) }
    var speechText by rememberSaveable(lesson.id, index.intValue) { mutableStateOf("") }
    var correctCount by rememberSaveable(lesson.id) { mutableIntStateOf(0) }
    var ttsReady by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val tts = remember { mutableStateOf<TextToSpeech?>(null) }

    DisposableEffect(context) {
        val engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                engineLanguageSetup(tts.value)
                ttsReady = true
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
                answer = recognized
                result = matchesTarget(recognized, exercise?.acceptedAnswers.orEmpty())
                if (result == true) correctCount++
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
        }
    }

    if (exercise == null) {
        LessonColumn { LessonButton("Dersi tamamla") { onDone(0) } }
        return
    }

    val progress = (index.intValue + 1f) / lesson.exercises.size
    val modelText = exercise.modelAudioText ?: exercise.acceptedAnswers.firstOrNull().orEmpty()

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Geri", tint = Color.White) }
            Column(Modifier.weight(1f)) {
                Text(lesson.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("${lesson.id} • ${skillLabel(exercise.skill)}", color = LessonMuted, fontSize = 12.sp)
            }
        }
        Text(lesson.canDo, color = LessonMuted, fontSize = 13.sp, modifier = Modifier.padding(start = 6.dp, top = 3.dp, bottom = 14.dp))
        LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth().height(8.dp), color = LessonGold, trackColor = LessonPanel2)
        Text("Etkinlik ${index.intValue + 1} / ${lesson.exercises.size}", color = LessonMuted, fontSize = 12.sp, modifier = Modifier.align(Alignment.End).padding(top = 5.dp))
        Spacer(Modifier.height(14.dp))

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
                            color = if (chosen) Color(0xFF233D4C) else LessonPanel2,
                            shape = RoundedCornerShape(13.dp),
                            border = BorderStroke(if (chosen) 2.dp else 1.dp, if (chosen) LessonGold else Color(0xFF28425B)),
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
                    Text("Not: Bu cihazın konuşma tanıma sonucu; telaffuz puanı değildir.", color = LessonMuted, fontSize = 11.sp, lineHeight = 16.sp, modifier = Modifier.padding(top = 8.dp))
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
            Surface(color = if (isWriting) LessonPanel2 else if (correct) Color(0xFF103B3B) else Color(0xFF422A32), shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(top = 14.dp)) {
                Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.Top) {
                    Icon(if (isWriting || correct) Icons.Default.CheckCircle else Icons.Default.Close, null, tint = if (isWriting || correct) LessonMint else Color(0xFFFF8A8A))
                    Column(Modifier.padding(start = 10.dp)) {
                        Text(if (isWriting) "Yanıtın kaydedildi" else if (correct) "Doğru yanıt" else "Bir kez daha düşün", fontWeight = FontWeight.Bold)
                        Text(exercise.explanationTr, color = LessonMuted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 4.dp))
                        if (!isWriting && !correct) Text("Örnek yanıt: ${exercise.acceptedAnswers.firstOrNull().orEmpty()}", color = LessonGold, fontSize = 12.sp, modifier = Modifier.padding(top = 5.dp))
                        if (isWriting) Text("Bu sürüm açık uçlu metin için henüz otomatik dilbilgisi puanı üretmiyor.", color = LessonMuted, fontSize = 11.sp, modifier = Modifier.padding(top = 5.dp))
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        LessonButton(if (submitted && index.intValue == lesson.exercises.lastIndex) "Dersi tamamla" else if (submitted) "Sonraki etkinlik" else "Yanıtı kontrol et") {
            if (submitted) {
                if (index.intValue >= lesson.exercises.lastIndex) {
                    onDone((correctCount * 100 / lesson.exercises.size.coerceAtLeast(1)).coerceIn(0, 100))
                } else index.intValue++
            } else {
                val typedAnswer = if (exercise.options.isNotEmpty()) exercise.options.getOrNull(selected).orEmpty() else answer
                if (typedAnswer.isBlank()) return@LessonButton
                if (exercise.skill == Skill.WRITING) {
                    submitted = true
                    result = null
                } else {
                    result = matchesTarget(typedAnswer, exercise.acceptedAnswers)
                    if (result == true) correctCount++
                    submitted = true
                }
            }
        }
        Spacer(Modifier.height(22.dp))
    }
}

private fun engineLanguageSetup(engine: TextToSpeech?) {
    engine?.language = Locale.US
}

private fun speak(engine: TextToSpeech?, text: String) {
    if (text.isNotBlank()) engine?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "linguapro-lesson-audio")
}

private fun normalize(value: String): String = Normalizer.normalize(value.lowercase(Locale.ROOT), Normalizer.Form.NFD)
    .replace(Regex("\\p{Mn}+"), "")
    .replace(Regex("[^a-z0-9']+"), " ")
    .trim()

private fun matchesTarget(response: String, accepted: List<String>): Boolean {
    val normalizedResponse = normalize(response)
    if (normalizedResponse.isBlank()) return false
    return accepted.any { target ->
        val normalizedTarget = normalize(target)
        if (normalizedResponse == normalizedTarget) true
        else {
            val responseWords = normalizedResponse.split(Regex("\\s+")).toSet()
            val targetWords = normalizedTarget.split(Regex("\\s+")).toSet()
            val overlap = responseWords.intersect(targetWords).size.toFloat()
            val recall = overlap / targetWords.size.coerceAtLeast(1)
            val precision = overlap / responseWords.size.coerceAtLeast(1)
            precision >= 0.72f && recall >= 0.72f
        }
    }
}

private fun skillLabel(skill: Skill): String = when (skill) {
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
