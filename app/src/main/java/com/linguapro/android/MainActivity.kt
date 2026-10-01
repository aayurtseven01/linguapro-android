package com.linguapro.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.linguapro.android.data.AccountResult
import com.linguapro.android.data.FirebaseAccountRepository
import androidx.hilt.navigation.compose.hiltViewModel
import com.linguapro.android.ui.home.LearningDashboardViewModel
import com.linguapro.android.ui.settings.SettingsRoute
import com.linguapro.android.ui.review.ReviewScreen

private val Navy = Color(0xFFFFFFFF)
private val Panel = Color(0xFFFFFFFF)
private val Panel2 = Color(0xFFF0F3F8)
private val Gold = Color(0xFF0A6ED1)
private val Muted = Color(0xFF5B6475)
private val Mint = Color(0xFF12B76A)
private val BgTop = Color(0xFF0148C4)
private val BgBottom = Color(0xFF4AD9DC)
private val OnBg = Color(0xFFFFFFFF)
private val OnBgSoft = Color(0xFFDFF3FF)
private val termsSummary = """
    LinguaPro, İngilizce öğrenme ve pratik için sunulan bir eğitim aracıdır; resmî CEFR sertifikası veya profesyonel çeviri hizmeti sağlamaz. Alıştırma yanıtları ve otomatik değerlendirmeler öğrenme desteği içindir; her açık uçlu yanıta kesin doğruluk puanı verilmez.

    Uygulamanın bazı özellikleri ve içerikleri geliştirme aşamasındadır. Şu an plan ekranı satın alma başlatmaz ve 7 günlük denemeyi başlatmış sayılmaz. İçerik ve özellikler güncellenebilir. Bu kısa metin üretim öncesi hukuki incelemenin yerini tutmaz.
""".trimIndent()
private val privacySummary = """
    Hesap açıldığında ad, e-posta, tahmini CEFR seviyesi ve ders tamamlama olayları Firebase Authentication/Firestore üzerinden işlenebilir. Şifreyi uygulama kendi veritabanında saklamaz; Firebase Authentication kullanır. Bu sürümde XP ve çalışma serisi özeti cihazdaki uygulama depolamasında tutulur.

    Konuşma etkinliğini sen başlattığında Android'in konuşma tanıma arayüzü açılır. Tanınan ifade ders yanıtı olarak ekranda işlenebilir; ses kaydı LinguaPro tarafından ders olayına eklenmez. İşletim sistemi veya seçili tanıma sağlayıcısının veri işlemesi kendi ayar ve politikalarına bağlıdır.

    Bu özet üretim öncesi hukuki ve veri koruma incelemesinden geçmelidir. Hesap silme/dışa aktarma ve tüm veriler için cihazlar arası senkronizasyon henüz tamamlanmamıştır.
""".trimIndent()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Tam ekran: içerik sistem çubuklarının arkasına uzanır, çubuklar şeffaftır.
        androidx.core.view.WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            window.isNavigationBarContrastEnforced = false
        }
        val insetsController = androidx.core.view.WindowCompat.getInsetsController(window, window.decorView)
        insetsController.isAppearanceLightStatusBars = false
        insetsController.isAppearanceLightNavigationBars = false
        setContent {
            LinguaTheme {
                var showSplash by rememberSaveable { mutableStateOf(true) }
                if (showSplash) {
                    SplashVideoScreen(onFinished = { showSplash = false })
                } else {
                    LinguaApp()
                }
            }
        }
    }
}

@Composable
private fun SplashVideoScreen(onFinished: () -> Unit) {
    var done by remember { mutableStateOf(false) }
    val complete = {
        if (!done) {
            done = true
            onFinished()
        }
    }
    var videoAspect by remember { mutableStateOf<Float?>(null) }
    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
            .clickable { complete() }
    ) {
        val screenAspect = constraints.maxWidth.toFloat() / constraints.maxHeight.toFloat()
        // Center-crop: video ekranı tamamen kaplayana kadar büyütülür, boşluk kalmaz
        val coverScale = videoAspect?.let { va ->
            kotlin.math.max(va / screenAspect, screenAspect / va)
        } ?: 1f
        AndroidView(
            factory = { ctx ->
                android.widget.VideoView(ctx).apply {
                    setVideoURI(android.net.Uri.parse("android.resource://" + ctx.packageName + "/" + R.raw.splash_logo))
                    setOnPreparedListener { mp ->
                        if (mp.videoHeight > 0) {
                            videoAspect = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                        }
                    }
                    setOnCompletionListener { complete() }
                    setOnErrorListener { _, _, _ -> complete(); true }
                    start()
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = coverScale
                    scaleY = coverScale
                }
        )
        Text(
            "Atlamak için dokun",
            color = Color(0x99FFFFFF),
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 28.dp)
        )
    }
    // Güvenlik ağı: video oynatılamazsa veya takılırsa en geç 8 saniyede geç
    LaunchedEffect(Unit) {
        delay(8000)
        complete()
    }
}

@Composable
private fun LinguaTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = lightColorScheme(
        primary = Gold, onPrimary = Navy, background = BgTop, surface = Panel,
        onBackground = OnBg, onSurface = Color(0xFF1A1D29), secondary = Mint
    ), content = content)
}

@Serializable
private sealed interface AppRoute {
    @Serializable data object Welcome : AppRoute
    @Serializable data object Register : AppRoute
    @Serializable data object Login : AppRoute
    @Serializable data object Plans : AppRoute
    @Serializable data object Quiz : AppRoute
    @Serializable data object PlacementResult : AppRoute
    @Serializable data object Home : AppRoute
    @Serializable data object Practice : AppRoute
    @Serializable data object Review : AppRoute
    @Serializable data object Progress : AppRoute
    @Serializable data object Profile : AppRoute
    @Serializable data object Settings : AppRoute
    @Serializable data object Lesson : AppRoute
    @Serializable data object Locked : AppRoute
}
private data class Question(
    val level: String,
    val prompt: String,
    val answers: List<String>,
    val correct: Int,
    val skill: Skill = Skill.GRAMMAR,
    val context: String = ""
)
private val questions = listOf(
    Question("A1", "Hello! How ___ you?", listOf("is", "are", "am", "be"), 1),
    Question("A1", "I ___ from Türkiye.", listOf("are", "is", "am", "be"), 2),
    Question("A1", "Where is Maya from?", listOf("Italy", "Spain", "Canada", "Greece"), 1, Skill.READING, "Hi! I'm Maya. I'm from Spain. Nice to meet you."),
    Question("A2", "She ___ to work every day.", listOf("go", "goes", "going", "gone"), 1),
    Question("A2", "We ___ dinner when you called.", listOf("have", "had", "were having", "are having"), 2),
    Question("A2", "What does Lena need to buy?", listOf("milk", "bread", "apples", "tea"), 1, Skill.READING, "The fridge is nearly empty. We have milk and apples, but no bread. Let's buy some after work."),
    Question("B1", "If I ___ more time, I'd learn another language.", listOf("have", "had", "will have", "would have"), 1),
    Question("B1", "The report ___ by the team yesterday.", listOf("completed", "was completed", "has complete", "is completing"), 1),
    Question("B1", "Why did the team change the schedule?", listOf("A client meeting moved.", "A colleague was ill.", "The venue closed.", "The report was unfinished."), 0, Skill.READING, "The client moved our review meeting from Thursday to Wednesday, so we brought the project check-in forward by one day."),
    Question("B2", "Despite ___ tired, she finished the presentation.", listOf("be", "being", "was", "to be"), 1),
    Question("B2", "In the report, 'inconclusive' means the results…", listOf("prove the claim", "do not provide a clear answer", "are irrelevant", "were fabricated"), 1, Skill.VOCABULARY, "The pilot showed a possible improvement, but the sample was too small for a firm conclusion."),
    Question("C1", "Hardly ___ the meeting begun when the fire alarm rang.", listOf("had", "has", "did", "was"), 0)
)
private val levels = listOf("A1", "A2", "B1", "B2", "C1", "C2")

@Composable
private fun LinguaApp() {
    val context = LocalContext.current
    val accounts = remember(context) { FirebaseAccountRepository(context) }
    val signedInUser = remember { accounts.currentUser() }
    val navController = rememberNavController()
    val dashboardViewModel: LearningDashboardViewModel = hiltViewModel()
    val dashboardState by dashboardViewModel.uiState.collectAsState()
    val startDestination = remember(signedInUser) {
        if (signedInUser != null) AppRoute.Home else AppRoute.Welcome
    }
    var questionIndex by rememberSaveable { mutableIntStateOf(0) }
    var highestPassed by rememberSaveable { mutableIntStateOf(-1) }
    var placementSummary by remember { mutableStateOf<PlacementSummary?>(null) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    var plan by rememberSaveable { mutableStateOf("Yıllık") }
    var userName by rememberSaveable { mutableStateOf(signedInUser?.displayName.orEmpty()) }
    var accountEmail by rememberSaveable { mutableStateOf(signedInUser?.email.orEmpty()) }
    var accountUid by rememberSaveable { mutableStateOf(signedInUser?.uid.orEmpty()) }
    val progressStore = remember(context, accountUid) { LearningProgressStore(context, accountUid) }
    var learningProgress by remember(accountUid) { mutableStateOf(progressStore.read()) }
    val mistakeBook = remember(context, accountUid) { MistakeBookStore(context, accountUid) }
    var mistakeIds by remember(accountUid) { mutableStateOf(mistakeBook.read()) }
    val skillProgressStore = remember(context, accountUid) { SkillProgressStore(context, accountUid) }
    var skillStats by remember(accountUid) { mutableStateOf(skillProgressStore.read()) }
    var level by rememberSaveable { mutableStateOf("A1") }
    var completed by rememberSaveable { mutableIntStateOf(0) }
    var completedByLevel by remember { mutableStateOf(emptyMap<String, Int>()) }
    val completedForLevel = maxOf(completedByLevel[level] ?: 0, dashboardState.completedLessonCount)
    var selectedLessonId by rememberSaveable { mutableStateOf("") }
    var selectedExerciseIndex by rememberSaveable { mutableIntStateOf(0) }
    var activeLessonCountsTowardCourse by rememberSaveable { mutableStateOf(true) }
    val activeLesson = remember(level, completedForLevel, selectedLessonId, dashboardState.supplementalUnits) {
        if (selectedLessonId.endsWith("-REFRESH")) return@remember DailyRefresh.lessonFor(level)
        val staticLessons = CourseCatalog.units(level).flatMap { it.lessons }
        val supplementalLessons = dashboardState.supplementalUnits.flatMap { it.lessons }
        val selectedFromCatalog = (staticLessons + supplementalLessons).firstOrNull { it.id == selectedLessonId }
        val nextIndex = completedForLevel.coerceAtLeast(0)
        selectedFromCatalog ?: staticLessons.getOrNull(nextIndex)
            ?: supplementalLessons.getOrNull((nextIndex - staticLessons.size).coerceAtLeast(0))
            ?: staticLessons.firstOrNull()
            ?: supplementalLessons.firstOrNull()
            ?: CourseCatalog.firstLesson("A1")
    }
    val go: (AppRoute) -> Unit = { destination ->
        navController.navigate(destination) { launchSingleTop = true }
    }

    LaunchedEffect(accountUid, level) {
        dashboardViewModel.setLearnerContext(accountUid, level)
    }

    LaunchedEffect(accountUid) {
        if (accountUid.isNotBlank()) accounts.loadProfile(accountUid) { profile ->
            if (profile != null) {
                if (profile.displayName.isNotBlank()) userName = profile.displayName
                if (profile.cefrLevel in levels) level = profile.cefrLevel
                completed = profile.completedLessons
                completedByLevel = profile.completedByLevel
                if (!profile.onboardingComplete) go(AppRoute.Plans)
            }
        }
    }

    Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(BgTop, BgBottom)))) {
        NavHost(navController = navController, startDestination = startDestination, modifier = Modifier.fillMaxSize().systemBarsPadding()) {
            composable<AppRoute.Welcome> {
                WelcomeScreen(onStart = { go(AppRoute.Register) }, onLogin = { go(AppRoute.Login) })
            }
            composable<AppRoute.Register> {
                RegisterScreen(
                    startInLogin = false, accounts = accounts, onBack = { go(AppRoute.Welcome) },
                    onContinue = { name, email, uid ->
                        userName = name.ifBlank { email.substringBefore('@') }
                        accountEmail = email
                        accountUid = uid
                        go(AppRoute.Plans)
                    }
                )
            }
            composable<AppRoute.Login> {
                RegisterScreen(
                    startInLogin = true, accounts = accounts, onBack = { go(AppRoute.Welcome) },
                    onContinue = { name, email, uid ->
                        userName = name.ifBlank { email.substringBefore('@') }
                        accountEmail = email
                        accountUid = uid
                        go(AppRoute.Home)
                    }
                )
            }
            composable<AppRoute.Plans> {
                PlanScreen(
                    plan = plan,
                    onPlan = { plan = it },
                    onBack = { go(AppRoute.Register) },
                    onStart = {
                        questionIndex = 0
                        highestPassed = -1
                        placementSummary = null
                        selected = -1
                        go(AppRoute.Quiz)
                    }
                )
            }
            composable<AppRoute.Quiz> {
                QuizScreen(
                    index = questionIndex,
                    selected = selected,
                    onSelect = { selected = it },
                    onBack = {
                        if (questionIndex > 0) {
                            questionIndex--
                            selected = -1
                            highestPassed = if (questionIndex == 0) -1 else levels.indexOf(questions[questionIndex - 1].level)
                        } else go(AppRoute.Plans)
                    },
                    onNext = {
                        val question = questions[questionIndex]
                        val isCorrect = selected == question.correct
                        val nextHighestPassed = if (isCorrect) levels.indexOf(question.level) else highestPassed
                        if (isCorrect) highestPassed = nextHighestPassed
                        if (!isCorrect || questionIndex == questions.lastIndex) {
                            val attempted = questions.take(questionIndex + 1).map { PlacementQuestionResult(it.level, it.skill) }
                            val correctIndexes = (0 until questionIndex).toMutableSet().apply { if (isCorrect) add(questionIndex) }
                            val summary = PlacementAssessment.summarize(nextHighestPassed, attempted, correctIndexes)
                            placementSummary = summary
                            level = summary.level
                            if (accountUid.isNotBlank()) accounts.savePlacement(accountUid, summary.level, summary.skillMastery) { }
                            go(AppRoute.PlacementResult)
                        } else {
                            questionIndex++
                            selected = -1
                        }
                    }
                )
            }
            composable<AppRoute.PlacementResult> {
                placementSummary?.let { summary ->
                    PlacementResultScreen(summary, onContinue = { go(AppRoute.Home) })
                } ?: WelcomeScreen(onStart = { go(AppRoute.Register) }, onLogin = { go(AppRoute.Login) })
            }
            composable<AppRoute.Home> {
                HomeScreen(
                    name = userName, level = level,
                    completed = completedForLevel,
                    progress = learningProgress, skillStats = skillStats,
                    supplementalUnits = dashboardState.supplementalUnits,
                    dueReviewCount = dashboardState.dueReviewCards.size,
                    onReview = { go(AppRoute.Review) },
                    onStartLesson = {
                        val extras = dashboardState.supplementalUnits.flatMap { it.lessons }
                        val staticCount = CourseCatalog.lessonCount(level)
                        selectedLessonId = if (completedForLevel >= staticCount && extras.isNotEmpty()) {
                            extras[(completedForLevel - staticCount).coerceAtLeast(0) % extras.size].id
                        } else ""
                        activeLessonCountsTowardCourse = true
                        selectedExerciseIndex = 0
                        go(AppRoute.Lesson)
                    },
                    onLocked = { go(AppRoute.Locked) },
                    onPractice = { go(AppRoute.Practice) },
                    onProgress = { go(AppRoute.Progress) },
                    onProfile = { go(AppRoute.Profile) },
                    onDailyRefresh = {
                        selectedLessonId = "$level-REFRESH"
                        activeLessonCountsTowardCourse = false
                        selectedExerciseIndex = 0
                        go(AppRoute.Lesson)
                    }
                )
            }
            composable<AppRoute.Practice> {
                PracticeScreen(
                    level, mistakeIds, skillStats, dashboardState.supplementalUnits,
                    onBack = { go(AppRoute.Home) },
                    onSelectLesson = { id -> selectedLessonId = id; activeLessonCountsTowardCourse = false; selectedExerciseIndex = 0; go(AppRoute.Lesson) },
                    onReviewExercise = { lessonId, exerciseIndex -> selectedLessonId = lessonId; activeLessonCountsTowardCourse = false; selectedExerciseIndex = exerciseIndex; go(AppRoute.Lesson) }
                )
            }
            composable<AppRoute.Review> {
                ReviewScreen(dueCards = dashboardState.dueReviewCards, onGrade = dashboardViewModel::gradeReview, onBack = { go(AppRoute.Home) })
            }
            composable<AppRoute.Progress> {
                ProgressScreen(level, completedForLevel, learningProgress, skillStats, dashboardState.supplementalUnits, onBack = { go(AppRoute.Home) })
            }
            composable<AppRoute.Profile> {
                ProfileScreen(
                    userName, accountEmail, level, completed, learningProgress,
                    onBack = { go(AppRoute.Home) },
                    onSettings = { go(AppRoute.Settings) },
                    onSignOut = {
                        accounts.signOut()
                        accountUid = ""
                        accountEmail = ""
                        userName = "Öğrenci"
                        level = "A1"
                        completed = 0
                        completedByLevel = emptyMap()
                        selectedLessonId = ""
                        go(AppRoute.Welcome)
                    }
                )
            }
            composable<AppRoute.Settings> { SettingsRoute(onBack = { go(AppRoute.Profile) }) }
            composable<AppRoute.Lesson> {
                LearningLessonScreen(
                    lesson = activeLesson,
                    exerciseIndex = selectedExerciseIndex,
                    onBack = { go(AppRoute.Home) },
                    onExerciseResult = { exerciseId, skill, correct ->
                        mistakeIds = mistakeBook.record(exerciseId, correct)
                        skillStats = skillProgressStore.record(skill, correct)
                    },
                    onDone = { score ->
                        val countsTowardCourse = activeLessonCountsTowardCourse
                        if (accountUid.isNotBlank()) accounts.recordLesson(accountUid, activeLesson.id, score, countsTowardCourse) { }
                        if (countsTowardCourse) {
                            completed++
                            completedByLevel = completedByLevel + (level to (completedForLevel + 1))
                            dashboardViewModel.recordLesson(
                                accountUid,
                                activeLesson.id.substringBefore('-'),
                                activeLesson.id,
                                score,
                                activeLesson.targetVocabulary.map { it.id }
                            )
                        }
                        selectedLessonId = ""
                        activeLessonCountsTowardCourse = true
                        selectedExerciseIndex = 0
                        learningProgress = progressStore.recordLesson(score)
                        go(AppRoute.Home)
                    },
                    ttsAccent = dashboardState.settings.speechAccent,
                    speechRate = dashboardState.settings.speechRate
                )
            }
            composable<AppRoute.Locked> { LockedScreen(onBack = { go(AppRoute.Home) }) }
        }
    }
}

@Composable
private fun WavingOwl(modifier: Modifier = Modifier) {
    // Akıcı el sallama: kareler arası sürekli crossfade + süzülme + eğilme + ışık halkası + parıltılar
    val waveFrames = listOf(
        R.drawable.owl_wave_down, R.drawable.owl_wave_mid, R.drawable.owl_wave_up,
        R.drawable.owl_wave_mid, R.drawable.owl_wave_up, R.drawable.owl_wave_mid,
        R.drawable.owl_wave_down
    )
    val twoPi = 2f * Math.PI.toFloat()
    // Tek seferlik oynatma: giriş + bir selamlama döngüsü, sonra nötr pozda durur
    val phaseAnim = remember { Animatable(0f) }
    val entrance = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        launch {
            entrance.animateTo(1f, spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow))
        }
        phaseAnim.animateTo(1f, tween(3400, easing = LinearEasing))
    }
    val phase = phaseAnim.value

    val segments = waveFrames.size - 1
    val pos = (phase * segments).coerceIn(0f, segments - 0.001f)
    val frameIdx = pos.toInt()
    val blend = (1f - kotlin.math.cos((pos - frameIdx) * Math.PI.toFloat())) / 2f
    val bob = kotlin.math.sin(phase * twoPi * 2f) * 7f
    val tilt = kotlin.math.sin(phase * twoPi * 2f) * 2.5f
    val glowPulse = 0.88f + 0.12f * kotlin.math.sin(phase * twoPi * 2f)
    // Animasyon sonuna yaklaşırken parıltılar yumuşakça söner
    val sparkleFade = ((1f - phase) * 4f).coerceIn(0f, 1f)

    Box(contentAlignment = Alignment.Center, modifier = modifier.size(176.dp)) {
        Canvas(Modifier.matchParentSize()) {
            // Nabız gibi atan altın ışık halkası
            val glowRadius = size.minDimension * 0.5f * glowPulse
            drawCircle(
                brush = Brush.radialGradient(
                    listOf(Color(0x80FFFFFF), Color(0x00FFFFFF)),
                    center = center,
                    radius = glowRadius
                ),
                radius = glowRadius,
                center = center
            )
            // Farklı fazlarda yanıp sönen parıltılar
            val sparkles = listOf(
                Offset(0.10f, 0.16f) to 0.0f,
                Offset(0.90f, 0.20f) to 2.1f,
                Offset(0.13f, 0.82f) to 4.2f,
                Offset(0.88f, 0.78f) to 1.1f
            )
            sparkles.forEach { (p, offsetPhase) ->
                val twinkle = kotlin.math.sin(phase * twoPi * 3f + offsetPhase).coerceAtLeast(0f) * sparkleFade
                if (twinkle > 0.05f) {
                    val c = Offset(size.width * p.x, size.height * p.y)
                    val r = (3f + 8f * twinkle).dp.toPx()
                    val col = Color(0xFFFFC800).copy(alpha = twinkle)
                    drawLine(col, Offset(c.x - r, c.y), Offset(c.x + r, c.y), strokeWidth = 2.5f)
                    drawLine(col, Offset(c.x, c.y - r), Offset(c.x, c.y + r), strokeWidth = 2.5f)
                    drawCircle(col, radius = 2.8f, center = c)
                }
            }
        }
        Box(
            Modifier
                .graphicsLayer {
                    translationY = bob.dp.toPx()
                    rotationZ = tilt
                    scaleX = entrance.value
                    scaleY = entrance.value
                    alpha = entrance.value.coerceIn(0f, 1f)
                }
                .size(132.dp)
                .clip(CircleShape)
                .border(3.dp, Color(0xE6FFFFFF), CircleShape)
        ) {
            Image(
                painter = painterResource(waveFrames[frameIdx]),
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )
            Image(
                painter = painterResource(waveFrames[frameIdx + 1]),
                contentDescription = "El sallayan LinguaPro baykuşu",
                modifier = Modifier.matchParentSize().graphicsLayer { alpha = blend }
            )
        }
    }
}

@Composable
private fun WelcomeScreen(onStart: () -> Unit, onLogin: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(28.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.owl_badge),
                contentDescription = null,
                modifier = Modifier.size(78.dp)
            )
            Text(
                "Lingua Pro",
                color = OnBg,
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.5.sp,
                style = LocalTextStyle.current.copy(
                    shadow = androidx.compose.ui.graphics.Shadow(
                        color = Color(0x590A2C66),
                        offset = Offset(0f, 5f),
                        blurRadius = 10f
                    )
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(Modifier.height(36.dp))
        Column(Modifier.fillMaxWidth().padding(vertical = 6.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            WavingOwl()
            Spacer(Modifier.height(14.dp))
            Text(
                "Hello, My Friend",
                color = OnBg,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                style = LocalTextStyle.current.copy(shadow = androidx.compose.ui.graphics.Shadow(Color(0x4D0A2C66), Offset(0f, 3f), 8f))
            )
            Text("İngilizceni gerçek hayata taşı.", color = OnBgSoft, fontSize = 15.sp, modifier = Modifier.padding(top = 4.dp))
        }
        Spacer(Modifier.height(30.dp))
        Text("Daha iyi bir sen,\ndaha geniş bir dünya.", color = OnBg, fontSize = 29.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, lineHeight = 36.sp)
        Spacer(Modifier.height(12.dp))
        Text("Seviyene göre kişisel plan, kısa dersler ve konuşma pratiğiyle adım adım ilerle.", color = OnBgSoft, textAlign = TextAlign.Center, fontSize = 16.sp, lineHeight = 24.sp)
        Spacer(Modifier.height(24.dp))
        FeatureLine(Icons.Default.School, "Sana özel öğrenme programı")
        FeatureLine(Icons.Default.RecordVoiceOver, "Örnek sesle konuşma ve tekrar çalışması")
        FeatureLine(Icons.Default.TrendingUp, "A1’den C2’ye gelişim takibi")
        Spacer(Modifier.height(24.dp))
        PrimaryButton("Hemen Başla", onStart)
        Spacer(Modifier.height(12.dp))
        Text("Zaten hesabın var mı? Giriş yap", color = OnBg, fontSize = 13.sp, textAlign = TextAlign.Center, modifier = Modifier.clickable(onClick = onLogin).padding(10.dp))
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
    var acceptedLegal by rememberSaveable { mutableStateOf(false) }
    var legalDialog by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp)) {
        BackRow(if (isLogin) "Hesabına giriş yap" else "Hesap oluştur", onBack)
        Spacer(Modifier.height(22.dp))
        Text(if (isLogin) "Tekrar hoş geldin." else "Öğrenme yolculuğun\nburada başlıyor.", color = OnBg, fontSize = 28.sp, fontWeight = FontWeight.Bold, lineHeight = 34.sp)
        Text(if (isLogin) "Kaldığın yerden devam et." else "Hesabını oluştur, seviyeni belirleyelim.", color = OnBgSoft, modifier = Modifier.padding(top = 8.dp, bottom = 22.dp))
        if (!isLogin) {
            AppField("Adın", name, { name = it }, Icons.Default.Person)
            Spacer(Modifier.height(12.dp))
        }
        AppField("E-posta", email, { email = it }, Icons.Default.Email)
        Spacer(Modifier.height(12.dp))
        AppField("Şifre", password, { password = it }, Icons.Default.Lock, isPassword = true)
        if (error.isNotBlank()) Text(error, color = Color(0xFFFFD2D2), fontSize = 13.sp, lineHeight = 18.sp, modifier = Modifier.padding(top = 10.dp))
        if (info.isNotBlank()) Text(info, color = Color(0xFFB9F6CA), fontSize = 13.sp, modifier = Modifier.padding(top = 10.dp))
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
        }, enabled = !busy && acceptedLegal)
        if (isLogin) {
            Text("Şifreni mi unuttun? Sıfırlama bağlantısı gönder", color = OnBg, fontSize = 12.sp, modifier = Modifier.align(Alignment.CenterHorizontally).clickable {
                if (!email.contains('@')) error = "Önce e-posta adresini gir."
                else { accounts.sendPasswordReset(email) { message -> info = message ?: "Şifre sıfırlama e-postası gönderildi." } }
            }.padding(12.dp))
        }
        Text(
            if (isLogin) "Hesabın yok mu? Kayıt ol" else "Zaten hesabın var mı? Giriş yap",
            color = Gold, fontSize = 13.sp, modifier = Modifier.align(Alignment.CenterHorizontally).clickable { isLogin = !isLogin; error = ""; info = "" }.padding(10.dp)
        )
        if (!isLogin) {
            Spacer(Modifier.height(12.dp))
            if (!accounts.isConfigured) {
                InfoCard("Firebase yapılandırması bulunamadı. Gerçek hesap için Firebase Console kurulumu gerekir; aşağıdaki misafir akışı hesap oluşturmaz.")
                Spacer(Modifier.height(8.dp))
            }
            OutlinedButton(onClick = { onContinue(name.ifBlank { "Misafir Öğrenci" }, email, "") }, enabled = acceptedLegal, modifier = Modifier.fillMaxWidth()) {
                Text("Misafir olarak keşfet (hesap açmaz)", color = OnBg)
            }
        }
        Spacer(Modifier.height(18.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Checkbox(checked = acceptedLegal, onCheckedChange = { acceptedLegal = it }, colors = CheckboxDefaults.colors(checkedColor = Gold, checkmarkColor = Navy))
            Text("Aşağıdaki metinleri okudum ve kabul ediyorum.", color = OnBgSoft, fontSize = 11.sp, lineHeight = 15.sp)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Kullanım Koşulları", color = OnBg, fontSize = 11.sp, modifier = Modifier.clickable { legalDialog = "terms" }.padding(6.dp))
            Text("•", color = OnBgSoft, modifier = Modifier.padding(6.dp))
            Text("Gizlilik Politikası", color = OnBg, fontSize = 11.sp, modifier = Modifier.clickable { legalDialog = "privacy" }.padding(6.dp))
        }
        if (legalDialog.isNotBlank()) {
            val isTerms = legalDialog == "terms"
            AlertDialog(
                onDismissRequest = { legalDialog = "" },
                title = { Text(if (isTerms) "Kullanım Koşulları" else "Gizlilik Politikası") },
                text = {
                    Column(Modifier.heightIn(max = 340.dp).verticalScroll(rememberScrollState())) {
                        Text(if (isTerms) termsSummary else privacySummary, fontSize = 13.sp, lineHeight = 19.sp)
                    }
                },
                confirmButton = { TextButton(onClick = { legalDialog = "" }) { Text("Kapat", color = Gold) } },
                containerColor = Panel,
                titleContentColor = Color(0xFF1A1D29),
                textContentColor = Muted
            )
        }
    }
}

@Composable
private fun AppField(label: String, value: String, onValue: (String) -> Unit, icon: androidx.compose.ui.graphics.vector.ImageVector, isPassword: Boolean = false) {
    OutlinedTextField(value = value, onValueChange = onValue, modifier = Modifier.fillMaxWidth(), label = { Text(label) }, leadingIcon = { Icon(icon, null, tint = Muted) }, singleLine = true, visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None, colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color(0xFFFFFFFF), unfocusedContainerColor = Color(0xFFFFFFFF), focusedBorderColor = Gold, unfocusedBorderColor = Panel2, focusedLabelColor = Gold, unfocusedLabelColor = Muted, cursorColor = Gold))
}

@Composable
private fun PlanScreen(plan: String, onPlan: (String) -> Unit, onBack: () -> Unit, onStart: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
        BackRow("Üyelik planını seç", onBack)
        Spacer(Modifier.height(18.dp))
        Text("Seviyene özel programını seç.", color = OnBg, fontSize = 27.sp, fontWeight = FontWeight.Bold, lineHeight = 33.sp)
        Text("Plan taslağı • demo modunda ödeme alınmaz", color = OnBgSoft, modifier = Modifier.padding(top = 8.dp, bottom = 20.dp))
        PlanCard("Yıllık", "Fiyat Google Play'den yüklenecek", "Deneme süresi ve yenileme koşulları Play Console'da yapılandırılır", "", plan == "Yıllık") { onPlan("Yıllık") }
        Spacer(Modifier.height(12.dp))
        PlanCard("Aylık", "Fiyat Google Play'den yüklenecek", "Satın alma şu an etkin değil", "", plan == "Aylık") { onPlan("Aylık") }
        Spacer(Modifier.height(18.dp))
        FeatureLine(Icons.Default.MenuBook, "A1’den C2’ye seviyene özel içerik")
        FeatureLine(Icons.Default.BusinessCenter, "İş, seyahat ve günlük yaşam İngilizcesi")
        FeatureLine(Icons.Default.Mic, "Konuşma üretimi ve tekrar etkinlikleri")
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Demo programına devam et", onStart)
        Spacer(Modifier.height(10.dp))
        Text("Bu adım satın alma başlatmaz ve deneme süresi başlatılmış sayılmaz.", color = OnBgSoft, fontSize = 11.sp, lineHeight = 16.sp, textAlign = TextAlign.Center)
        Spacer(Modifier.height(16.dp))
        InfoCard("Gerçek abonelik için Play Console ürünleri, Billing akışı ve sunucu tarafı satın alma doğrulaması gerekir. Fiyat/deneme şartları Play'den gösterilmelidir.")
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun PlanCard(title: String, price: String, detail: String, badge: String, chosen: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, shadowElevation = 2.dp, shape = RoundedCornerShape(18.dp), color = if (chosen) Color(0xFFE8F1FF) else Panel, border = BorderStroke(if (chosen) 2.dp else 1.dp, if (chosen) Gold else Panel2)) {
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
        Text("İngilizce seviyeni belirlemek için soruları yanıtla.", color = OnBgSoft, modifier = Modifier.padding(top = 4.dp))
        Spacer(Modifier.height(18.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            LinearProgressIndicator(progress = { (index + 1f) / questions.size }, modifier = Modifier.weight(1f).height(8.dp), color = Color(0xFFFFFFFF), trackColor = Color(0x44FFFFFF))
            Text("  ${index + 1} / ${questions.size}", color = OnBgSoft, fontSize = 13.sp)
        }
        Spacer(Modifier.height(22.dp))
        Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(24.dp)) {
            Column(Modifier.fillMaxWidth().padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Default.School, null, tint = Gold); Text("  ${q.level} • ${skillLabel(q.skill).uppercase()}", color = Gold, fontSize = 13.sp, fontWeight = FontWeight.Bold) }
                Text("Doğru seçeneği işaretle.", color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 5.dp, bottom = 16.dp))
                if (q.context.isNotBlank()) {
                    Surface(color = Panel2, shape = RoundedCornerShape(14.dp), modifier = Modifier.padding(bottom = 15.dp)) {
                        Text(q.context, fontSize = 15.sp, lineHeight = 22.sp, modifier = Modifier.fillMaxWidth().padding(14.dp))
                    }
                }
                Text(q.prompt, fontSize = 23.sp, fontWeight = FontWeight.Bold, lineHeight = 30.sp)
                Spacer(Modifier.height(20.dp))
                q.answers.forEachIndexed { i, answer ->
                    val isSelected = selected == i
                    Surface(onClick = { onSelect(i) }, color = if (isSelected) Color(0xFFDDF4FF) else Panel2, shape = RoundedCornerShape(14.dp), border = BorderStroke(if (isSelected) 2.dp else 1.dp, if (isSelected) Gold else Color(0xFFE5E5E5)), modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
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
private fun HomeScreen(name: String, level: String, completed: Int, progress: LearningProgress, skillStats: Map<Skill, SkillTally>, supplementalUnits: List<LearningUnit>, dueReviewCount: Int, onReview: () -> Unit, onStartLesson: () -> Unit, onLocked: () -> Unit, onPractice: () -> Unit, onProgress: () -> Unit, onProfile: () -> Unit, onDailyRefresh: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 18.dp)) {
        Spacer(Modifier.height(14.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column { Text("Merhaba, $name!", color = OnBg, fontSize = 26.sp, fontWeight = FontWeight.Bold); Text("İngilizce yolculuğuna devam et", color = OnBgSoft, fontSize = 13.sp) }
            IconButton(onClick = onProfile) { Icon(Icons.Default.AccountCircle, "Profili aç", tint = OnBg, modifier = Modifier.size(30.dp)) }
        }
        Spacer(Modifier.height(18.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard("🔥", "${progress.streakDays} gün seri", if (progress.streakDays == 0) "Bugün bir dersle başlat" else "Düzenli çalışmaya devam et", Modifier.weight(1f))
            StatCard("✦", "${progress.todayXp}/${LearningProgress.DAILY_XP_GOAL} XP", if (progress.dailyGoalReached) "Günlük hedef tamamlandı" else "Günlük hedef • ${progress.dailyGoalPercent}%", Modifier.weight(1f))
        }
        Spacer(Modifier.height(12.dp))
        Surface(onClick = onDailyRefresh, color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
            Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("🔄", fontSize = 22.sp)
                Column(Modifier.weight(1f).padding(start = 10.dp)) {
                    Text("Günlük Tekrar", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Her gün yenilenen 10 soruluk karışımla öğrendiklerini taze tut", color = Muted, fontSize = 12.sp, lineHeight = 16.sp, modifier = Modifier.padding(top = 3.dp))
                }
                Icon(Icons.Default.ChevronRight, null, tint = Muted)
            }
        }
        if (dueReviewCount > 0) {
            Spacer(Modifier.height(12.dp))
            Surface(onClick = onReview, color = Color(0xFFDDF4FF), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Style, contentDescription = null, tint = Gold)
                    Column(Modifier.weight(1f).padding(start = 10.dp)) {
                        Text(stringResource(R.string.review_due_title, dueReviewCount), color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(stringResource(R.string.review_due_subtitle), color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 3.dp))
                    }
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Muted)
                }
            }
        }
        val focusSkill = SkillProgressLogic.weakest(skillStats)
        if (focusSkill != null) {
            Spacer(Modifier.height(14.dp))
            Surface(color = Color(0xFFF0F3F8), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().clickable(onClick = onPractice)) {
                Row(Modifier.padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AutoAwesome, null, tint = Gold)
                    Column(Modifier.weight(1f).padding(start = 10.dp)) {
                        Text("Sana özel tekrar önerisi", color = Gold, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text("${skillLabel(focusSkill)} becerisini güçlendir", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, modifier = Modifier.padding(top = 3.dp))
                    }
                    Icon(Icons.Default.ChevronRight, null, tint = Muted)
                }
            }
        }
        Spacer(Modifier.height(23.dp))
        Text("$level Seviyesindeki Yolculuğun", color = OnBg, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Hedeflerine adım adım ilerle", color = OnBgSoft, fontSize = 14.sp, modifier = Modifier.padding(top = 3.dp, bottom = 14.dp))
        val moduleList = CourseCatalog.units(level) + supplementalUnits.filter { it.id.startsWith("$level-") }
        val courseLessonCount = moduleList.sumOf { it.lessons.size }
        val lessonPointer = completed.coerceAtMost(courseLessonCount)
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
        PrimaryButton(if (completed >= courseLessonCount) "↻   Dersleri tekrar et" else "▶   Derse başla", onStartLesson)
        Spacer(Modifier.height(14.dp))
        InfoCard("$level seviyesine özel programın hazır. Kısa derslerle her gün biraz daha ilerle.")
        Spacer(Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(20.dp)).padding(vertical = 14.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            NavItem(Icons.Default.Home, "Ana Sayfa", true) { }
            NavItem(Icons.Default.Headphones, "Pratik", false, onPractice)
            NavItem(Icons.Default.BarChart, "İlerleme", false, onProgress)
            NavItem(Icons.Default.Person, "Profil", false, onProfile)
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun PracticeScreen(level: String, mistakeIds: Set<String>, skillStats: Map<Skill, SkillTally>, supplementalUnits: List<LearningUnit>, onBack: () -> Unit, onSelectLesson: (String) -> Unit, onReviewExercise: (String, Int) -> Unit) {
    val recommendedSkill = SkillProgressLogic.weakest(skillStats)
    var selectedSkill by rememberSaveable(level, recommendedSkill?.name) { mutableStateOf(recommendedSkill?.let(::skillLabel) ?: "Tümü") }
    val lessons = (CourseCatalog.units(level) + supplementalUnits.filter { it.id.startsWith("$level-") }).flatMap { it.lessons }
    val allLessons = CourseCatalog.allLessons() + supplementalUnits.flatMap { it.lessons }
    val skills = listOf("Tümü") + Skill.values().map(::skillLabel)
    val visibleLessons = lessons.filter { lesson -> selectedSkill == "Tümü" || lesson.exercises.any { skillLabel(it.skill) == selectedSkill } }
    val reviewItems = remember(mistakeIds, allLessons) {
        allLessons.flatMap { lesson -> lesson.exercises.mapIndexed { index, exercise -> Triple(lesson, index, exercise) } }
            .filter { (_, _, exercise) -> exercise.id in mistakeIds }
    }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 18.dp)) {
        BackRow("Pratik merkezi", onBack)
        Text("$level seviyesinde kısa bir çalışma seç.", color = OnBgSoft, modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 14.dp))
        Row(Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            skills.forEach { skill ->
                FilterChip(selected = selectedSkill == skill, onClick = { selectedSkill = skill }, label = { Text(skill) }, colors = FilterChipDefaults.filterChipColors(containerColor = Color(0x33FFFFFF), labelColor = OnBg, selectedContainerColor = Gold, selectedLabelColor = Navy))
            }
        }
        recommendedSkill?.let { focus ->
            val tally = skillStats.getValue(focus)
            Surface(color = Color(0xFFF0F3F8), shape = RoundedCornerShape(14.dp), modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                Row(Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text("Önerilen odak: ${skillLabel(focus)} • ${tally.accuracyPercent}% / ${tally.attempts} deneme", color = Muted, fontSize = 11.sp, modifier = Modifier.weight(1f))
                    TextButton(onClick = { selectedSkill = skillLabel(focus) }) { Text("Dersleri gör", color = Gold, fontSize = 11.sp) }
                }
            }
        }
        if (reviewItems.isNotEmpty()) {
            Text("Tekrar etmen gerekenler  •  ${reviewItems.size}", color = OnBg, fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 5.dp))
            reviewItems.forEach { (lesson, exerciseIndex, exercise) ->
                Surface(onClick = { onReviewExercise(lesson.id, exerciseIndex) }, color = Color(0xFFF3E8FF), shape = RoundedCornerShape(15.dp), modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Row(Modifier.padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Replay, null, tint = Gold)
                        Column(Modifier.weight(1f).padding(start = 10.dp)) {
                            Text(exercise.prompt, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, lineHeight = 18.sp)
                            Text("${lesson.id.substringBefore('-')} • ${lesson.title} • ${skillLabel(exercise.skill)}", color = Muted, fontSize = 10.sp, modifier = Modifier.padding(top = 4.dp))
                        }
                        Icon(Icons.Default.ChevronRight, null, tint = Muted)
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
        }
        Spacer(Modifier.height(12.dp))
        visibleLessons.forEachIndexed { index, lesson ->
            Surface(onClick = { onSelectLesson(lesson.id) }, color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(17.dp), modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
                Row(Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(38.dp).background(Panel2, CircleShape), contentAlignment = Alignment.Center) { Text("${index + 1}", color = Gold, fontWeight = FontWeight.Bold) }
                    Column(Modifier.weight(1f).padding(horizontal = 12.dp)) {
                        Text(lesson.title, fontWeight = FontWeight.Bold)
                        Text(lesson.canDo, color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 3.dp))
                        Text(lesson.exercises.map { skillLabel(it.skill) }.distinct().joinToString(" • "), color = Gold, fontSize = 10.sp, modifier = Modifier.padding(top = 5.dp))
                    }
                    Icon(Icons.Default.ChevronRight, null, tint = Muted)
                }
            }
        }
        if (visibleLessons.isEmpty()) InfoCard("Bu beceri için bu seviyede henüz ders bulunmuyor.")
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun ProgressScreen(level: String, completed: Int, progress: LearningProgress, skillStats: Map<Skill, SkillTally>, supplementalUnits: List<LearningUnit>, onBack: () -> Unit) {
    val units = CourseCatalog.units(level) + supplementalUnits.filter { it.id.startsWith("$level-") }
    val total = units.sumOf { it.lessons.size }
    val done = completed.coerceAtMost(total)
    val percent = if (total == 0) 0 else done * 100 / total
    val skills = units.flatMap { it.lessons }.flatMap { it.exercises }.groupingBy { it.skill }.eachCount()
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 18.dp)) {
        BackRow("Öğrenme ilerlemen", onBack)
        Text("İstikrarlı küçük adımlar birikir.", color = OnBgSoft, modifier = Modifier.padding(start = 8.dp, top = 3.dp, bottom = 16.dp))
        Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("$level öğrenme yolu", fontWeight = FontWeight.Bold)
                    Text("$percent%", color = Gold, fontWeight = FontWeight.Bold)
                }
                LinearProgressIndicator(progress = { percent / 100f }, modifier = Modifier.fillMaxWidth().padding(top = 13.dp).height(8.dp), color = Gold, trackColor = Panel2)
                Text("$done / $total ders tamamlandı", color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp))
            }
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard("🔥", "${progress.streakDays} gün", "Çalışma serisi", Modifier.weight(1f))
            StatCard("✦", "${progress.totalXp} XP", "Toplam deneyim", Modifier.weight(1f))
        }
        Spacer(Modifier.height(18.dp))
        Text("Beceriler bu kursta", color = OnBg, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text("Doğruluk yalnızca otomatik değerlendirilen yanıtları kapsar; açık uçlu yazı puanlanmaz. Bu beceri özeti bu cihazda saklanır.", color = OnBgSoft, fontSize = 11.sp, lineHeight = 15.sp, modifier = Modifier.padding(top = 4.dp, bottom = 8.dp))
        Skill.values().forEach { skill ->
            val count = skills[skill] ?: 0
            val tally = skillStats[skill] ?: SkillTally()
            Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(skillLabel(skill), color = OnBg, fontSize = 14.sp)
                    Text(if (tally.accuracyPercent == null) "Henüz ölçülmedi" else "${tally.accuracyPercent}% • ${tally.attempts} deneme", color = OnBgSoft, fontSize = 10.sp, modifier = Modifier.padding(top = 2.dp))
                }
                Text("$count etkinlik", color = Gold, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun ProfileScreen(name: String, email: String, level: String, completed: Int, progress: LearningProgress, onBack: () -> Unit, onSettings: () -> Unit, onSignOut: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 18.dp)) {
        BackRow("Profil", onBack)
        Spacer(Modifier.height(12.dp))
        Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(22.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.size(76.dp).background(Panel2, CircleShape), contentAlignment = Alignment.Center) { Icon(Icons.Default.Person, null, tint = Gold, modifier = Modifier.size(42.dp)) }
                Text(name.ifBlank { "Öğrenci" }, fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp))
                Text(email.ifBlank { "Demo hesap • bu cihazda" }, color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 4.dp))
            }
        }
        Spacer(Modifier.height(14.dp))
        InfoCard("Seviye: $level  •  Tamamlanan ders: $completed  •  Toplam XP: ${progress.totalXp}")
        Spacer(Modifier.height(18.dp))
        Text("Hesap ve gizlilik", color = OnBg, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text("Ders tamamlama hesabınla Firestore'a kaydedilir. XP, çalışma serisi ve otomatik yanıtların beceri özeti bu cihazda tutulur; cihazlar arası eşitleme henüz yoktur.", color = OnBgSoft, fontSize = 12.sp, lineHeight = 18.sp, modifier = Modifier.padding(top = 7.dp, bottom = 15.dp))
        OutlinedButton(onClick = onSettings, border = BorderStroke(1.dp, Color(0x99FFFFFF)), modifier = Modifier.fillMaxWidth()) { Text("Öğrenme ayarları", color = OnBg) }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onSignOut, border = BorderStroke(1.dp, Color(0x99FFFFFF)), modifier = Modifier.fillMaxWidth()) { Text("Oturumu kapat", color = OnBg) }
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun ModuleCard(number: Int, title: String, subtitle: String, status: String, done: Boolean, current: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(18.dp), border = if (current) BorderStroke(1.5.dp, Gold) else null) {
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
        Icon(Icons.Default.Lock, null, tint = OnBg, modifier = Modifier.size(60.dp))
        Text("Bu ünite sıradaki adımda açılacak", color = OnBg, fontSize = 23.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 18.dp))
        Text("Önce mevcut üniteni tamamla; öğrenme programın adım adım ilerler.", color = OnBgSoft, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp))
        Spacer(Modifier.height(24.dp)); PrimaryButton("Ana sayfaya dön", onBack)
    }
}

@Composable
private fun FeatureLine(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(38.dp).background(Panel2, CircleShape), contentAlignment = Alignment.Center) { Icon(icon, null, tint = Gold, modifier = Modifier.size(20.dp)) }
        Text(text, color = OnBg, fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp))
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
private fun NavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, active: Boolean, onClick: () -> Unit) {
    Column(Modifier.clickable(onClick = onClick).padding(horizontal = 7.dp, vertical = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
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
        IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Geri", tint = OnBg) }
        Text(title, color = OnBg, fontSize = 19.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
    }
}

@Composable
private fun PrimaryButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    // Kurumsal premium CTA: beyaz zemin, marka mavisi, yumuşak gölge
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .shadow(12.dp, RoundedCornerShape(16.dp), ambientColor = Color(0x330A2C66), spotColor = Color(0x4D0A2C66)),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFFFFF),
            contentColor = Color(0xFF0A4FC4),
            disabledContainerColor = Color(0x59FFFFFF),
            disabledContentColor = Color(0xB3FFFFFF)
        )
    ) {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.3.sp)
    }
}
