package com.linguapro.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.linguapro.android.data.AccountResult
import com.linguapro.android.data.FirebaseAccountRepository

private val Navy = Color(0xFF071D32)
private val Panel = Color(0xFF112B46)
private val Panel2 = Color(0xFF183653)
private val Gold = Color(0xFFF2BE45)
private val Muted = Color(0xFFA9BED2)
private val Mint = Color(0xFF63D2B0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = android.graphics.Color.rgb(7, 29, 50)
        window.navigationBarColor = android.graphics.Color.rgb(7, 29, 50)
        setContent { LinguaTheme { LinguaApp() } }
    }
}

@Composable
private fun LinguaTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Gold, onPrimary = Navy, background = Navy, surface = Panel,
        onBackground = Color.White, onSurface = Color.White, secondary = Mint
    ), content = content)
}

private enum class Screen { Welcome, Register, Login, Plans, Quiz, Home, Lesson, Locked }
private data class Question(val level: String, val prompt: String, val answers: List<String>, val correct: Int)
private val questions = listOf(
    Question("A1", "Hello! How ___ you?", listOf("is", "are", "am", "be"), 1),
    Question("A1", "I ___ from Türkiye.", listOf("are", "is", "am", "be"), 2),
    Question("A1", "Choose the plural: one book, two ___.", listOf("book", "books", "bookes", "booking"), 1),
    Question("A2", "She ___ to work every day.", listOf("go", "goes", "going", "gone"), 1),
    Question("A2", "We ___ dinner when you called.", listOf("have", "had", "were having", "are having"), 2),
    Question("A2", "There isn't ___ milk in the fridge.", listOf("some", "many", "any", "few"), 2),
    Question("B1", "If I ___ more time, I'd learn another language.", listOf("have", "had", "will have", "would have"), 1),
    Question("B1", "The report ___ by the team yesterday.", listOf("completed", "was completed", "has complete", "is completing"), 1),
    Question("B1", "I've lived here ___ 2021.", listOf("for", "since", "during", "from"), 1),
    Question("B2", "Despite ___ tired, she finished the presentation.", listOf("be", "being", "was", "to be"), 1),
    Question("B2", "The manager asked me ___ the figures again.", listOf("check", "checking", "to check", "checked"), 2),
    Question("C1", "Hardly ___ the meeting begun when the fire alarm rang.", listOf("had", "has", "did", "was"), 0)
)
private val levels = listOf("A1", "A2", "B1", "B2", "C1")

@Composable
private fun LinguaApp() {
    val context = LocalContext.current
    val accounts = remember(context) { FirebaseAccountRepository(context) }
    val signedInUser = remember { accounts.currentUser() }
    var screenName by rememberSaveable { mutableStateOf(if (signedInUser != null) Screen.Home.name else Screen.Welcome.name) }
    var questionIndex by rememberSaveable { mutableIntStateOf(0) }
    var highestPassed by rememberSaveable { mutableIntStateOf(-1) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    var plan by rememberSaveable { mutableStateOf("Yıllık") }
    var userName by rememberSaveable { mutableStateOf(signedInUser?.displayName.orEmpty()) }
    var accountEmail by rememberSaveable { mutableStateOf(signedInUser?.email.orEmpty()) }
    var accountUid by rememberSaveable { mutableStateOf(signedInUser?.uid.orEmpty()) }
    var level by rememberSaveable { mutableStateOf("A1") }
    var completed by rememberSaveable { mutableIntStateOf(0) }
    val screen = Screen.valueOf(screenName)
    val go: (Screen) -> Unit = { screenName = it.name }
    LaunchedEffect(accountUid) {
        if (accountUid.isNotBlank()) accounts.loadProfile(accountUid) { profile ->
            if (profile != null) {
                if (profile.displayName.isNotBlank()) userName = profile.displayName
                if (profile.cefrLevel in levels) level = profile.cefrLevel
                completed = profile.completedLessons
            }
        }
    }
    Surface(color = Navy) {
        when (screen) {
            Screen.Welcome -> WelcomeScreen(onStart = { go(Screen.Register) }, onLogin = { go(Screen.Login) })
            Screen.Register -> RegisterScreen(
                startInLogin = false, accounts = accounts, onBack = { go(Screen.Welcome) },
                onContinue = { name, email, uid -> userName = name.ifBlank { email.substringBefore('@') }; accountEmail = email; accountUid = uid; go(Screen.Plans) }
            )
            Screen.Login -> RegisterScreen(
                startInLogin = true, accounts = accounts, onBack = { go(Screen.Welcome) },
                onContinue = { name, email, uid -> userName = name.ifBlank { email.substringBefore('@') }; accountEmail = email; accountUid = uid; go(Screen.Home) }
            )
            Screen.Plans -> PlanScreen(plan = plan, onPlan = { plan = it }, onBack = { go(Screen.Register) }, onStart = { questionIndex = 0; highestPassed = -1; selected = -1; go(Screen.Quiz) })
            Screen.Quiz -> QuizScreen(index = questionIndex, selected = selected, onSelect = { selected = it }, onBack = { if (questionIndex > 0) questionIndex-- else go(Screen.Plans) }, onNext = {
                val q = questions[questionIndex]
                if (selected == q.correct) highestPassed = levels.indexOf(q.level)
                val wrong = selected != q.correct
                if (wrong || questionIndex == questions.lastIndex) {
                    level = levels[(highestPassed.coerceAtLeast(0)).coerceAtMost(levels.lastIndex)]
                    if (accountUid.isNotBlank()) accounts.savePlacement(accountUid, level, emptyMap()) { }
                    go(Screen.Home)
                } else { questionIndex++; selected = -1 }
            })
            Screen.Home -> HomeScreen(name = userName, level = level, completed = completed, onStartLesson = { go(Screen.Lesson) }, onLocked = { go(Screen.Locked) })
            Screen.Lesson -> LearningLessonScreen(
                lesson = CourseCatalog.lessonAt(level, completed),
                exerciseIndex = 0,
                onBack = { go(Screen.Home) },
                onDone = { score ->
                    if (accountUid.isNotBlank()) accounts.recordLesson(accountUid, CourseCatalog.lessonAt(level, completed).id, score) { }
                    completed++
                    go(Screen.Home)
                }
            )
            Screen.Locked -> LockedScreen(onBack = { go(Screen.Home) })
        }
    }
}

@Composable
private fun WelcomeScreen(onStart: () -> Unit, onLogin: () -> Unit) {
    Column(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Color(0xFF0A2943), Navy, Color(0xFF061729)))).verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(42.dp))
        Text("Lingua", fontSize = 34.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text("PRO", fontSize = 13.sp, color = Gold, fontWeight = FontWeight.Bold, letterSpacing = 4.sp)
        Spacer(Modifier.height(36.dp))
        Box(Modifier.fillMaxWidth().height(250.dp).background(Panel, RoundedCornerShape(28.dp)), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("🌍", fontSize = 72.sp)
                Spacer(Modifier.height(12.dp))
                Text("Hello, dünya!", color = Gold, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Text("İngilizceni gerçek hayata taşı.", color = Muted, fontSize = 15.sp)
            }
        }
        Spacer(Modifier.height(30.dp))
        Text("Daha iyi bir sen,\ndaha geniş bir dünya.", fontSize = 29.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, lineHeight = 36.sp)
        Spacer(Modifier.height(12.dp))
        Text("Seviyene göre kişisel plan, kısa dersler ve konuşma pratiğiyle adım adım ilerle.", color = Muted, textAlign = TextAlign.Center, fontSize = 16.sp, lineHeight = 24.sp)
        Spacer(Modifier.height(24.dp))
        FeatureLine(Icons.Default.School, "Sana özel öğrenme programı")
        FeatureLine(Icons.Default.RecordVoiceOver, "Konuşma ve telaffuz pratiği")
        FeatureLine(Icons.Default.TrendingUp, "A1’den C1’e gelişim takibi")
        Spacer(Modifier.height(24.dp))
        PrimaryButton("Hemen Başla", onStart)
        Spacer(Modifier.height(12.dp))
        Text("Zaten hesabın var mı? Giriş yap", color = Gold, fontSize = 13.sp, textAlign = TextAlign.Center, modifier = Modifier.clickable(onClick = onLogin).padding(10.dp))
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun RegisterScreen(
    startInLogin: Boolean,
    accounts: FirebaseAccountRepository,
    onBack: () -> Unit,
    onContinue: (String, String, String) -> Unit
) {
    var isLogin by rememberSaveable(startInLogin) { mutableStateOf(startInLogin) }
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf("") }
    var busy by rememberSaveable { mutableStateOf(false) }
    var info by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp)) {
        BackRow(if (isLogin) "Hesabına giriş yap" else "Hesap oluştur", onBack)
        Spacer(Modifier.height(22.dp))
        Text(if (isLogin) "Tekrar hoş geldin." else "Öğrenme yolculuğun\nburada başlıyor.", fontSize = 28.sp, fontWeight = FontWeight.Bold, lineHeight = 34.sp)
        Text(if (isLogin) "Kaldığın yerden devam et." else "Hesabını oluştur, seviyeni belirleyelim.", color = Muted, modifier = Modifier.padding(top = 8.dp, bottom = 22.dp))
        if (!isLogin) {
            AppField("Adın", name, { name = it }, Icons.Default.Person)
            Spacer(Modifier.height(12.dp))
        }
        AppField("E-posta", email, { email = it }, Icons.Default.Email)
        Spacer(Modifier.height(12.dp))
        AppField("Şifre", password, { password = it }, Icons.Default.Lock, isPassword = true)
        if (error.isNotBlank()) Text(error, color = Color(0xFFFF9A9A), fontSize = 13.sp, lineHeight = 18.sp, modifier = Modifier.padding(top = 10.dp))
        if (info.isNotBlank()) Text(info, color = Mint, fontSize = 13.sp, modifier = Modifier.padding(top = 10.dp))
        Spacer(Modifier.height(20.dp))
        PrimaryButton(if (busy) "Bağlanıyor…" else if (isLogin) "Giriş yap" else "Güvenli hesap oluştur", {
            error = ""; info = ""
            if (!email.contains('@') || email.substringAfter('@', "").length < 3) {
                error = "Geçerli bir e-posta adresi gir."
            } else if (password.length < 6) {
                error = "Şifre en az 6 karakter olmalı."
            } else if (!isLogin && name.isBlank()) {
                error = "Adını gir."
            } else {
                busy = true
                val done: (AccountResult) -> Unit = { result ->
                    busy = false
                    if (result.isSuccess) onContinue(result.displayName.ifBlank { name }, result.email.ifBlank { email }, result.uid.orEmpty())
                    else error = result.error ?: "İşlem tamamlanamadı."
                }
                if (isLogin) accounts.signIn(email, password, done) else accounts.register(name, email, password, done)
            }
        }, enabled = !busy)
        if (isLogin) {
            Text("Şifreni mi unuttun? Sıfırlama bağlantısı gönder", color = Gold, fontSize = 12.sp, modifier = Modifier.align(Alignment.CenterHorizontally).clickable {
                if (!email.contains('@')) error = "Önce e-posta adresini gir."
                else { accounts.sendPasswordReset(email) { message -> info = message ?: "Şifre sıfırlama e-postası gönderildi." } }
            }.padding(12.dp))
        }
        Text(
            if (isLogin) "Hesabın yok mu? Kayıt ol" else "Zaten hesabın var mı? Giriş yap",
            color = Gold, fontSize = 13.sp, modifier = Modifier.align(Alignment.CenterHorizontally).clickable { isLogin = !isLogin; error = ""; info = "" }.padding(10.dp)
        )
        if (!accounts.isConfigured && !isLogin) {
            Spacer(Modifier.height(12.dp))
            InfoCard("Firebase henüz bu uygulamaya bağlanmadı. Gerçek kayıt için Firebase Console yapılandırması gerekir.")
            Spacer(Modifier.height(10.dp))
            OutlinedButton(onClick = { onContinue(name.ifBlank { "Demo Öğrencisi" }, email, "") }, modifier = Modifier.fillMaxWidth()) {
                Text("Demo akışını aç (hesap oluşturmaz)")
            }
        }
        Spacer(Modifier.height(18.dp))
        Text("Devam ederek Kullanım Koşulları ve Gizlilik Politikası'nı kabul etmiş olursun.", color = Muted, fontSize = 11.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun AppField(label: String, value: String, onValue: (String) -> Unit, icon: androidx.compose.ui.graphics.vector.ImageVector, isPassword: Boolean = false) {
    OutlinedTextField(value = value, onValueChange = onValue, modifier = Modifier.fillMaxWidth(), label = { Text(label) }, leadingIcon = { Icon(icon, null, tint = Muted) }, singleLine = true, visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Gold, unfocusedBorderColor = Panel2, focusedLabelColor = Gold, unfocusedLabelColor = Muted, cursorColor = Gold))
}

@Composable
private fun PlanScreen(plan: String, onPlan: (String) -> Unit, onBack: () -> Unit, onStart: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
        BackRow("Üyelik planını seç", onBack)
        Spacer(Modifier.height(18.dp))
        Text("Seviyene özel programını seç.", fontSize = 27.sp, fontWeight = FontWeight.Bold, lineHeight = 33.sp)
        Text("Plan taslağı • demo modunda ödeme alınmaz", color = Muted, modifier = Modifier.padding(top = 8.dp, bottom = 20.dp))
        PlanCard("Yıllık", "Fiyat Google Play'den yüklenecek", "Deneme süresi ve yenileme koşulları Play Console'da yapılandırılır", "", plan == "Yıllık") { onPlan("Yıllık") }
        Spacer(Modifier.height(12.dp))
        PlanCard("Aylık", "Fiyat Google Play'den yüklenecek", "Satın alma şu an etkin değil", "", plan == "Aylık") { onPlan("Aylık") }
        Spacer(Modifier.height(18.dp))
        FeatureLine(Icons.Default.MenuBook, "A1’den C1’e seviyene özel içerik")
        FeatureLine(Icons.Default.BusinessCenter, "İş, seyahat ve günlük yaşam İngilizcesi")
        FeatureLine(Icons.Default.Mic, "Konuşma pratiği ve telaffuz geri bildirimi")
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Demo programına devam et", onStart)
        Spacer(Modifier.height(10.dp))
        Text("Bu adım satın alma başlatmaz ve deneme süresi başlatılmış sayılmaz.", color = Muted, fontSize = 11.sp, lineHeight = 16.sp, textAlign = TextAlign.Center)
        Spacer(Modifier.height(16.dp))
        InfoCard("Gerçek abonelik için Play Console ürünleri, Billing akışı ve sunucu tarafı satın alma doğrulaması gerekir. Fiyat/deneme şartları Play'den gösterilmelidir.")
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun PlanCard(title: String, price: String, detail: String, badge: String, chosen: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, shape = RoundedCornerShape(18.dp), color = if (chosen) Color(0xFF1A354A) else Panel, border = BorderStroke(if (chosen) 2.dp else 1.dp, if (chosen) Gold else Panel2)) {
        Row(Modifier.fillMaxWidth().padding(17.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(if (chosen) Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked, null, tint = if (chosen) Gold else Muted)
            Column(Modifier.weight(1f).padding(start = 14.dp)) { Row(verticalAlignment = Alignment.CenterVertically) { Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp); if (badge.isNotEmpty()) Text(badge, color = Gold, fontSize = 10.sp, modifier = Modifier.padding(start = 8.dp)) }; Text(price, fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(top = 5.dp)); Text(detail, color = Muted, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 4.dp)) }
        }
    }
}

@Composable
private fun QuizScreen(index: Int, selected: Int, onSelect: (Int) -> Unit, onBack: () -> Unit, onNext: () -> Unit) {
    val q = questions[index]
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp)) {
        BackRow("Seviye belirleme", onBack)
        Text("İngilizce seviyeni belirlemek için soruları yanıtla.", color = Muted, modifier = Modifier.padding(top = 4.dp))
        Spacer(Modifier.height(18.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            LinearProgressIndicator(progress = { (index + 1f) / questions.size }, modifier = Modifier.weight(1f).height(8.dp), color = Gold, trackColor = Panel2)
            Text("  ${index + 1} / ${questions.size}", color = Muted, fontSize = 13.sp)
        }
        Spacer(Modifier.height(22.dp))
        Surface(color = Panel, shape = RoundedCornerShape(24.dp)) {
            Column(Modifier.fillMaxWidth().padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Default.School, null, tint = Gold); Text("  ${q.level} • GRAMER", color = Gold, fontSize = 13.sp, fontWeight = FontWeight.Bold) }
                Text("Doğru seçeneği işaretle.", color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 5.dp, bottom = 20.dp))
                Text(q.prompt, fontSize = 25.sp, fontWeight = FontWeight.Bold, lineHeight = 32.sp)
                Spacer(Modifier.height(20.dp))
                q.answers.forEachIndexed { i, answer ->
                    val isSelected = selected == i
                    Surface(onClick = { onSelect(i) }, color = if (isSelected) Color(0xFF233D4C) else Panel2, shape = RoundedCornerShape(14.dp), border = BorderStroke(if (isSelected) 2.dp else 1.dp, if (isSelected) Gold else Color(0xFF28425B)), modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
                        Row(Modifier.padding(horizontal = 15.dp, vertical = 15.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(if (isSelected) Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked, null, tint = if (isSelected) Gold else Muted)
                            Text(answer, fontSize = 16.sp, modifier = Modifier.padding(start = 14.dp))
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        InfoCard("Seviye testi kolay sorulardan başlar. Doğru yanıtladıkça daha ileri seviyeye geçersin.")
        Spacer(Modifier.height(20.dp))
        PrimaryButton(if (index == questions.lastIndex) "Sonucu Gör" else "Cevabı Onayla", onNext, enabled = selected >= 0)
        Spacer(Modifier.height(22.dp))
    }
}

@Composable
private fun HomeScreen(name: String, level: String, completed: Int, onStartLesson: () -> Unit, onLocked: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 18.dp)) {
        Spacer(Modifier.height(14.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column { Text("Merhaba, $name!", fontSize = 26.sp, fontWeight = FontWeight.Bold); Text("İngilizce yolculuğuna devam et", color = Muted, fontSize = 13.sp) }
            Icon(Icons.Default.NotificationsNone, null, tint = Gold, modifier = Modifier.size(26.dp))
        }
        Spacer(Modifier.height(18.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard("🔥", "${completed + 1} gün serisi", "Harika gidiyorsun!", Modifier.weight(1f))
            StatCard("◉", "Günlük hedef: %70", "Bugünün hedefi", Modifier.weight(1f))
        }
        Spacer(Modifier.height(23.dp))
        Text("$level Seviyesindeki Yolculuğun", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Hedeflerine adım adım ilerle", color = Muted, fontSize = 14.sp, modifier = Modifier.padding(top = 3.dp, bottom = 14.dp))
        val moduleList = CourseCatalog.units(level)
        val lessonPointer = completed % CourseCatalog.lessonCount(level)
        var previousLessonCount = 0
        moduleList.forEachIndexed { i, unit ->
            val unitStart = previousLessonCount
            val unitEnd = unitStart + unit.lessons.size
            val isDone = lessonPointer >= unitEnd
            val isCurrent = lessonPointer in unitStart until unitEnd
            ModuleCard(
                i + 1,
                unit.title,
                "${unit.lessons.size} ders • ${unit.summary}",
                if (isDone) "Tamamlandı" else if (isCurrent) "Şu anda" else "Sırada",
                isDone,
                isCurrent
            ) { if (isCurrent) onStartLesson() else if (!isDone) onLocked() }
            previousLessonCount = unitEnd
            Spacer(Modifier.height(10.dp))
        }
        Spacer(Modifier.height(8.dp))
        PrimaryButton("▶   Derse Başla", onStartLesson)
        Spacer(Modifier.height(14.dp))
        InfoCard("$level seviyesine özel programın hazır. Kısa derslerle her gün biraz daha ilerle.")
        Spacer(Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(20.dp)).padding(vertical = 14.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            NavItem(Icons.Default.Home, "Ana Sayfa", true)
            NavItem(Icons.Default.Headphones, "Pratik", false)
            NavItem(Icons.Default.BarChart, "İlerleme", false)
            NavItem(Icons.Default.Person, "Profil", false)
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun ModuleCard(number: Int, title: String, subtitle: String, status: String, done: Boolean, current: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, color = Panel, shape = RoundedCornerShape(18.dp), border = if (current) BorderStroke(1.5.dp, Gold) else null) {
        Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(38.dp).background(if (done) Mint else if (current) Gold else Panel2, CircleShape), contentAlignment = Alignment.Center) {
                if (done) Icon(Icons.Default.Check, null, tint = Navy) else Text("$number", color = if (current) Navy else Muted, fontWeight = FontWeight.Bold)
            }
            Column(Modifier.weight(1f).padding(start = 12.dp, end = 4.dp)) {
                Text("$number. Ünite: $title", fontSize = 14.sp, fontWeight = FontWeight.Bold, lineHeight = 19.sp)
                Text(subtitle, fontSize = 12.sp, color = Muted, lineHeight = 17.sp, modifier = Modifier.padding(top = 4.dp))
                Text(if (done) "✓  $status" else if (current) "●  $status" else "🔒  $status", fontSize = 11.sp, color = if (done) Mint else if (current) Gold else Muted, modifier = Modifier.padding(top = 7.dp))
            }
            Icon(Icons.Default.ChevronRight, null, tint = Muted)
        }
    }
}

@Composable
private fun LockedScreen(onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Icon(Icons.Default.Lock, null, tint = Gold, modifier = Modifier.size(60.dp))
        Text("Bu ünite sıradaki adımda açılacak", fontSize = 23.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 18.dp))
        Text("Önce mevcut üniteni tamamla; öğrenme programın adım adım ilerler.", color = Muted, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp))
        Spacer(Modifier.height(24.dp)); PrimaryButton("Ana sayfaya dön", onBack)
    }
}

@Composable
private fun FeatureLine(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(38.dp).background(Panel2, CircleShape), contentAlignment = Alignment.Center) { Icon(icon, null, tint = Gold, modifier = Modifier.size(20.dp)) }
        Text(text, color = Color(0xFFE3EDF5), fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp))
    }
}

@Composable
private fun StatCard(emoji: String, title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(modifier.background(Panel, RoundedCornerShape(18.dp)).padding(13.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) { Text(emoji, fontSize = 23.sp); Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp)) }
        Text(subtitle, color = Muted, fontSize = 11.sp, modifier = Modifier.padding(top = 7.dp))
    }
}

@Composable
private fun NavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, active: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, null, tint = if (active) Gold else Muted)
        Text(text, color = if (active) Gold else Muted, fontSize = 10.sp, modifier = Modifier.padding(top = 3.dp))
    }
}

@Composable
private fun InfoCard(text: String) {
    Row(Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(16.dp)).padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Lightbulb, null, tint = Gold)
        Text(text, color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
private fun BackRow(title: String, onBack: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Geri", tint = Color.White) }
        Text(title, fontSize = 19.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
    }
}

@Composable
private fun PrimaryButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Button(onClick = onClick, enabled = enabled, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(17.dp), colors = ButtonDefaults.buttonColors(containerColor = Gold, contentColor = Navy, disabledContainerColor = Panel2, disabledContentColor = Muted)) {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}
