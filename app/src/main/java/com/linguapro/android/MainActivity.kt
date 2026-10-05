package com.linguapro.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.linguapro.android.billing.ProViewModel
import com.linguapro.android.ui.profile.ProfileScreen
import com.linguapro.android.ui.onboarding.PlanScreen
import com.linguapro.android.ui.components.*
import com.linguapro.android.billing.ProScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.linguapro.android.ui.auth.AuthViewModel
import com.linguapro.android.ui.auth.AuthRequest
import com.linguapro.android.data.FirebaseAccountRepository
import androidx.hilt.navigation.compose.hiltViewModel
import com.linguapro.android.ui.home.LearningDashboardViewModel
import com.linguapro.android.ui.settings.SettingsRoute
import com.linguapro.android.ui.review.ReviewScreen

// Tasarım 2 — "premium gece": koyu mor zemin, ışıklı lime ve pembe vurgular
private val termsSummary = """
    LinguaPro, İngilizce öğrenme ve pratik için sunulan bir eğitim aracıdır; resmî CEFR sertifikası veya profesyonel çeviri hizmeti sağlamaz. Alıştırma yanıtları ve otomatik değerlendirmeler öğrenme desteği içindir; her açık uçlu yanıta kesin doğruluk puanı verilmez.

    Uygulamanın bazı özellikleri ve içerikleri geliştirme aşamasındadır. Şu an plan ekranı satın alma başlatmaz ve 7 günlük denemeyi başlatmış sayılmaz. İçerik ve özellikler güncellenebilir. Bu kısa metin üretim öncesi hukuki incelemenin yerini tutmaz.
""".trimIndent()
private val privacySummary = """
    Hesap açıldığında ad, e-posta, tahmini CEFR seviyesi ve ders tamamlama olayları Firebase Authentication/Firestore üzerinden işlenebilir. Şifreyi uygulama kendi veritabanında saklamaz; Firebase Authentication kullanır. Bu sürümde XP ve çalışma serisi özeti cihazdaki uygulama depolamasında tutulur.

    Konuşma etkinliğini sen başlattığında Android'in konuşma tanıma arayüzü açılır. Tanınan ifade ders yanıtı olarak ekranda işlenebilir; ses kaydı LinguaPro tarafından ders olayına eklenmez. İşletim sistemi veya seçili tanıma sağlayıcısının veri işlemesi kendi ayar ve politikalarına bağlıdır.

    Profil ekranından hesabını ve öğrenme verilerini silmeyi isteyebilirsin. Google Play aboneliklerini ayrıca Google Play üzerinden yönetmelisin.
""".trimIndent()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var touchDownX = 0f
    private var touchDownY = 0f

    override fun dispatchTouchEvent(ev: android.view.MotionEvent): Boolean {
        when (ev.actionMasked) {
            android.view.MotionEvent.ACTION_DOWN -> { touchDownX = ev.x; touchDownY = ev.y }
            android.view.MotionEvent.ACTION_UP -> {
                val moved = kotlin.math.hypot((ev.x - touchDownX).toDouble(), (ev.y - touchDownY).toDouble())
                if (moved < 28.0) UiClickSound.play(this) // dokunuş: klik; kaydırma: sessiz
            }
        }
        return super.dispatchTouchEvent(ev)
    }

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
internal fun LinguaTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Gold, onPrimary = Navy, background = BgBottom, surface = Panel,
        onBackground = OnBg, onSurface = OnBg, secondary = PinkAccent,
        surfaceVariant = Panel2, onSurfaceVariant = Muted
    ), content = content)
}

@Serializable
private sealed interface AppRoute {
    @Serializable data object Welcome : AppRoute
    @Serializable data object Register : AppRoute
    @Serializable data object Login : AppRoute
    @Serializable data object Pro : AppRoute
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
    @Serializable data object Social : AppRoute
    @Serializable data object AvatarEditor : AppRoute
    @Serializable data object Stories : AppRoute
    @Serializable data object StoryPlayer : AppRoute
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
    Question("B2", "By the time we arrived, the film ___.", listOf("started", "has started", "had started", "was starting"), 2),
    Question("C1", "Hardly ___ the meeting begun when the fire alarm rang.", listOf("had", "has", "did", "was"), 0),
    Question("C1", "___ the committee approve the proposal, work will begin in May.", listOf("Should", "Would", "Unless", "Provided"), 0),
    Question("C1", "In the review, 'tentative' suggests the plan is...", listOf("final and binding", "provisional and open to change", "rejected outright", "overdue"), 1, Skill.VOCABULARY, "The roadmap remains tentative; dates will firm up after the budget review."),
    Question("C2", "The committee's findings were anything ___ transparent.", listOf("but", "than", "as", "so"), 0),
    Question("C2", "Only after the audit ___ the full scale of the problem.", listOf("we grasped", "did we grasp", "we did grasp", "grasped we"), 1),
    Question("C2", "Her 'perfunctory' apology implies it was...", listOf("heartfelt and sincere", "done hastily, without real feeling", "formally documented", "unexpectedly generous"), 1, Skill.VOCABULARY, "She offered a perfunctory apology before returning to her notes.")
)
private val levels = listOf("A1", "A2", "B1", "B2", "C1", "C2")

/** Geri gidilince, ilk [answeredCount] soru icinde TAMAMEN yanitlanmis seviyelerden 2/3 olcutuyle gecilen en yuksek seviyeyi dondurur. */
private fun placementHighestPassed(answeredCount: Int, correct: Set<Int>): Int {
    var highest = -1
    for ((levelIndex, lv) in levels.withIndex()) {
        val idx = questions.indices.filter { questions[it].level == lv }
        if (idx.isEmpty() || idx.any { it >= answeredCount }) break
        val passed = idx.count { it in correct } * 3 >= idx.size * 2
        if (passed) highest = levelIndex else break
    }
    return highest
}

@Composable
private fun LinguaApp() {
    val context = LocalContext.current
    val accounts = remember(context) { FirebaseAccountRepository(context) }
    val signedInUser = remember { accounts.currentUser() }
    val today by produceState(DailyWords.todayEpochDay()) {
        while (true) { delay(60_000); value = DailyWords.todayEpochDay() }
    }
    val navController = rememberNavController()
    val dashboardViewModel: LearningDashboardViewModel = hiltViewModel()
    val proViewModel: ProViewModel = hiltViewModel()
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, proViewModel) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) proViewModel.onResume()
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }
    val proState by proViewModel.state.collectAsState()
    val dashboardState by dashboardViewModel.uiState.collectAsState()
    val startDestination = remember(signedInUser) {
        if (signedInUser != null) AppRoute.Home else AppRoute.Welcome
    }
    var questionIndex by rememberSaveable { mutableIntStateOf(0) }
    var highestPassed by rememberSaveable { mutableIntStateOf(-1) }
    var placementCorrect by rememberSaveable(stateSaver = listSaver<Set<Int>, Int>(
        save = { it.toList() }, restore = { it.toSet() }
    )) { mutableStateOf(setOf<Int>()) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }
    var plan by rememberSaveable { mutableStateOf("10") }
    var deletionBusy by remember { mutableStateOf(false) }
    var lessonSaveBusy by remember { mutableStateOf(false) }
    val pendingSyncCount by dashboardViewModel.pendingSyncCount.collectAsState()
    val storageError by dashboardViewModel.errorMessage.collectAsState()
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
    // Çok dilli kurs durumu: seçilen eğitim dili ve dil başına seviye/ilerleme yerelde saklanır.
    val coursePrefs = remember(context) { context.getSharedPreferences("lingua_course", android.content.Context.MODE_PRIVATE) }
    var courseLang by rememberSaveable { mutableStateOf(coursePrefs.getString("courseLang", "EN") ?: "EN") }
    // Dil ilerlemesi hesaba (uid) bağlıdır; oturum yoksa "local" altında tutulur. Eski anahtarlardan sorunsuz geçiş yapılır.
    val courseUid = accountUid.ifBlank { "local" }
    var langLevel by remember(courseLang, courseUid) {
        mutableStateOf(
            coursePrefs.getString("level_${courseUid}_$courseLang", null)
                ?: coursePrefs.getString("level_$courseLang", "A1") ?: "A1"
        )
    }
    val effectiveLevel = if (courseLang == "EN") level else langLevel
    var localLangCompleted by remember(courseLang, langLevel, courseUid) {
        mutableIntStateOf(
            coursePrefs.getInt(
                "completed_${courseUid}_${courseLang}_$langLevel",
                coursePrefs.getInt(
                    "completed_${courseLang}_$langLevel",
                    if (langLevel == "A1") coursePrefs.getInt("completed_$courseLang", 0) else 0
                )
            )
        )
    }
    val completedForLevel = if (courseLang == "EN") maxOf(completedByLevel[level] ?: 0, dashboardState.completedLessonCount) else localLangCompleted
    val courseUnits = remember(courseLang, effectiveLevel, dashboardState.supplementalUnits) {
        WorldCatalog.units(courseLang, effectiveLevel) +
            (if (courseLang == "EN") dashboardState.supplementalUnits.filter { it.id.startsWith("$effectiveLevel-") } else emptyList())
    }
    var selectedLessonId by rememberSaveable { mutableStateOf("") }
    var personalLessonJson by rememberSaveable(accountUid) { mutableStateOf("") }
    var selectedExerciseIndex by rememberSaveable { mutableIntStateOf(0) }
    // Sosyal katman: kullanıcı adı, avatar, günlük görevler, lig senkronu
    var username by remember(courseUid) { mutableStateOf(coursePrefs.getString("username_$courseUid", "") ?: "") }
    var avatarCode by remember(courseUid) { mutableStateOf(coursePrefs.getString("avatar_$courseUid", "") ?: "") }
    val social = remember { com.linguapro.android.data.SocialRepository() }
    val questStore = remember(context, courseUid) { QuestProgressStore(context, courseUid) }
    var questVersion by remember { mutableIntStateOf(0) }
    val gemStore = remember(context, courseUid) { GemStore(context, courseUid) }
    var gems by remember(courseUid) { mutableIntStateOf(gemStore.gems()) }
    var claimedChests by remember(courseUid) { mutableStateOf(gemStore.claimedChests()) }
    var showGemShop by remember { mutableStateOf(false) }
    var selectedStoryId by rememberSaveable { mutableStateOf("") }
    var doneStories by remember(courseUid) {
        mutableStateOf(coursePrefs.getStringSet("stories_done_$courseUid", emptySet()).orEmpty().toSet())
    }
    val syncBoard: () -> Unit = syncBoard@{
        if (accountUid.isBlank() || username.isBlank()) return@syncBoard
        social.upsertBoard(accountUid, username, userName, LevelSystem.levelFor(learningProgress.totalXp), learningProgress.totalXp, avatarCode) { }
    }
    var activeLessonCountsTowardCourse by rememberSaveable { mutableStateOf(true) }
    val activeLesson = remember(courseLang, effectiveLevel, completedForLevel, selectedLessonId, personalLessonJson, dashboardState.supplementalUnits) {
        if (selectedLessonId.endsWith("-PRO") && personalLessonJson.isNotBlank()) {
            runCatching { Json.decodeFromString<LearningLesson>(personalLessonJson) }.getOrNull()?.let { return@remember it }
        }
        if (selectedLessonId.endsWith("-WORDS")) return@remember DailyWords.lessonFor(courseLang)
        if (selectedLessonId.endsWith("-REFRESH")) return@remember DailyRefresh.lessonFor(courseLang, effectiveLevel, SkillProgressLogic.weakest(skillStats))
        val staticLessons = WorldCatalog.units(courseLang, effectiveLevel).flatMap { it.lessons }
        val supplementalLessons = if (courseLang == "EN") dashboardState.supplementalUnits.flatMap { it.lessons } else emptyList()
        val selectedFromCatalog = (staticLessons + supplementalLessons).firstOrNull { it.id == selectedLessonId }
            ?: (CourseCatalog.allLessons() + WorldCatalog.allWorldLessons()).firstOrNull { it.id == selectedLessonId }
        val nextIndex = completedForLevel.coerceAtLeast(0)
        selectedFromCatalog ?: staticLessons.getOrNull(nextIndex)
            ?: supplementalLessons.getOrNull((nextIndex - staticLessons.size).coerceAtLeast(0))
            ?: staticLessons.firstOrNull()
            ?: supplementalLessons.firstOrNull()
            ?: CourseCatalog.firstLesson("A1")
    }
    val go: (AppRoute) -> Unit = { destination ->
        navController.navigate(destination) {
            launchSingleTop = true
            if (destination == AppRoute.Home || destination == AppRoute.Welcome) {
                popUpTo(navController.graph.id) { inclusive = false }
            }
        }
    }

    val startProPractice: () -> Unit = {
        if (!proViewModel.canUsePro()) go(AppRoute.Pro)
        else {
            val personal = PersonalizedPractice.build(courseLang, effectiveLevel, courseUnits.flatMap { it.lessons }, mistakeIds, skillStats)
            personalLessonJson = Json.encodeToString(personal)
            selectedLessonId = personal.id
            activeLessonCountsTowardCourse = false
            selectedExerciseIndex = 0
            go(AppRoute.Lesson)
        }
    }

    LaunchedEffect(accountUid) {
        val uid = accountUid
        if (uid.isNotBlank()) social.loadIdentity(uid) { identity ->
            if (accountUid == uid && identity != null) {
                username = identity.username
                if (identity.avatar.isNotBlank()) avatarCode = identity.avatar
                coursePrefs.edit().putString("username_$uid", username).putString("avatar_$uid", avatarCode).apply()
            }
        }
    }

    LaunchedEffect(accountUid, today) { learningProgress = progressStore.read() }

    LaunchedEffect(storageError) {
        storageError?.let {
            android.widget.Toast.makeText(context, it, android.widget.Toast.LENGTH_LONG).show()
            dashboardViewModel.errorMessage.value = null
        }
    }

    LaunchedEffect(accountUid, level) {
        dashboardViewModel.setLearnerContext(accountUid, level)
    }

    LaunchedEffect(accountUid) {
        val profileUid = accountUid
        if (profileUid.isNotBlank()) accounts.loadProfile(profileUid) { profile ->
            if (profile != null && accountUid == profileUid) {
                if (profile.displayName.isNotBlank()) userName = profile.displayName
                if (profile.cefrLevel in levels) level = profile.cefrLevel
                completed = profile.completedLessons
                completedByLevel = profile.completedByLevel
                if (!profile.onboardingComplete) go(AppRoute.Plans)
            }
        }
    }

    Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(BgTop, BgBottom)))) {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            enterTransition = { scaleIn(initialScale = 0.88f, animationSpec = tween(340)) + fadeIn(tween(340)) },
            exitTransition = { fadeOut(tween(200)) },
            popEnterTransition = { fadeIn(tween(220)) },
            popExitTransition = { scaleOut(targetScale = 0.94f, animationSpec = tween(200)) + fadeOut(tween(200)) },
            modifier = Modifier.fillMaxSize().systemBarsPadding()
        ) {
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
            composable<AppRoute.Pro> { ProScreen(proViewModel, onBack = { go(AppRoute.Home) }, onPractice = startProPractice) }
            composable<AppRoute.Plans> {
                PlanScreen(
                    plan = plan,
                    onPlan = { plan = it; dashboardViewModel.setDailyGoal(it.toInt()) },
                    onBack = { go(AppRoute.Register) },
                    onStart = {
                        questionIndex = 0
                        highestPassed = -1
                        placementCorrect = setOf()
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
                            placementCorrect = placementCorrect.filter { it < questionIndex }.toSet()
                            highestPassed = placementHighestPassed(questionIndex, placementCorrect)
                        } else go(AppRoute.Plans)
                    },
                    onNext = {
                        // Tek yanlis testi bitirmez: her seviyeden 3 soru sorulur, 2/3 dogru seviyeyi gecirir.
                        val question = questions[questionIndex]
                        val isCorrect = selected == question.correct
                        val newCorrect = if (isCorrect) placementCorrect + questionIndex else placementCorrect
                        placementCorrect = newCorrect
                        val levelEnded = questionIndex == questions.lastIndex ||
                            questions[questionIndex + 1].level != question.level
                        var finished = questionIndex == questions.lastIndex
                        if (levelEnded) {
                            val levelIdx = questions.indices.filter { questions[it].level == question.level }
                            val levelCorrect = levelIdx.count { it in newCorrect }
                            val passed = levelCorrect * 3 >= levelIdx.size * 2
                            if (passed) highestPassed = levels.indexOf(question.level) else finished = true
                        }
                        if (finished) {
                            val attempted = questions.take(questionIndex + 1).map { PlacementQuestionResult(it.level, it.skill) }
                            val summary = PlacementAssessment.summarize(highestPassed, attempted, newCorrect)
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
                val summary = PlacementAssessment.summarize(highestPassed,
                    questions.take(questionIndex + 1).map { PlacementQuestionResult(it.level, it.skill) }, placementCorrect)
                run {
                    PlacementResultScreen(summary, onChooseLevel = { chosenLevel ->
                        level = chosenLevel
                        if (accountUid.isNotBlank()) accounts.savePlacement(accountUid, chosenLevel, summary.skillMastery) { }
                        go(AppRoute.Home)
                    })
                }
            }
            composable<AppRoute.Home> {
                HomeScreen(
                    name = userName, level = effectiveLevel,
                    pendingSyncCount = pendingSyncCount,
                    onPro = { go(AppRoute.Pro) }, proActive = proState.hasPro && proState.uid == accountUid, dailyGoalMinutes = dashboardState.settings.dailyGoalMinutes,
                    langCode = courseLang,
                    onSelectLanguage = { code ->
                        courseLang = code
                        coursePrefs.edit().putString("courseLang", code).apply()
                        selectedLessonId = ""
                    },
                    onSelectLevel = { lv ->
                        langLevel = lv
                        coursePrefs.edit().putString("level_${courseUid}_$courseLang", lv).apply()
                        selectedLessonId = ""
                    },
                    completed = completedForLevel,
                    progress = learningProgress, skillStats = skillStats,
                    courseUnits = courseUnits,
                    dueReviewCount = dashboardState.dueReviewCards.size,
                    onReview = { go(AppRoute.Review) },
                    onStartLesson = {
                        val extras = if (courseLang == "EN") dashboardState.supplementalUnits.flatMap { it.lessons } else emptyList()
                        val staticCount = WorldCatalog.units(courseLang, effectiveLevel).sumOf { it.lessons.size }
                        val levelFinished = staticCount > 0 && completedForLevel >= staticCount + extras.size
                        if (levelFinished) {
                            // Seviye bitti: başa sarmak yerine Günlük Tekrar başlat.
                            selectedLessonId = "$courseLang-$effectiveLevel-REFRESH"
                            activeLessonCountsTowardCourse = false
                        } else {
                            selectedLessonId = if (completedForLevel >= staticCount && extras.isNotEmpty()) {
                                extras[(completedForLevel - staticCount).coerceAtLeast(0) % extras.size].id
                            } else ""
                            activeLessonCountsTowardCourse = true
                        }
                        selectedExerciseIndex = 0
                        go(AppRoute.Lesson)
                    },
                    onLocked = { go(AppRoute.Locked) },
                    onPractice = { go(AppRoute.Practice) },
                    onProgress = { go(AppRoute.Progress) },
                    onProfile = { go(AppRoute.Profile) },
                    onDailyRefresh = {
                        selectedLessonId = "$courseLang-$effectiveLevel-REFRESH"
                        activeLessonCountsTowardCourse = false
                        selectedExerciseIndex = 0
                        go(AppRoute.Lesson)
                    },
                    dailyQuests = run {
                        questVersion // yeniden hesaplama tetikleyicisi
                        val day = DailyWords.todayEpochDay()
                        DailyQuests.questsFor(day).map { q -> QuestUi(q, questStore.progress(day, q.metric), questStore.claimed(day, q.id)) }
                    },
                    onClaimQuest = { quest ->
                        val day = DailyWords.todayEpochDay()
                        if (!questStore.claimed(day, quest.id) && questStore.progress(day, quest.metric) >= quest.target) {
                            questStore.setClaimed(day, quest.id)
                            learningProgress = progressStore.addBonusXp(quest.rewardXp)
                            questVersion++
                            gems = gemStore.add(5)
                            if (DailyQuests.questsFor(day).all { questStore.claimed(day, it.id) } && accountUid.isNotBlank() && username.isNotBlank()) {
                                social.postActivity(accountUid, username, avatarCode, "Günün tüm görevlerini tamamladı! 🏆") { }
                            }
                            syncBoard()
                        }
                    },
                    onSocial = { go(AppRoute.Social) },
                    gems = gems,
                    onOpenShop = { showGemShop = true },
                    onStories = { go(AppRoute.Stories) },
                    storiesDoneCount = doneStories.count { it.startsWith(courseLang) },
                    chestsClaimed = claimedChests,
                    onClaimChest = { chestUnitId ->
                        if (gemStore.claimChest(chestUnitId)) {
                            claimedChests = claimedChests + chestUnitId
                            gems = gemStore.add(20)
                        }
                    },
                    dailyWords = remember(courseLang, today) { DailyWords.wordsFor(courseLang, today) },
                    onDailyWords = {
                        selectedLessonId = "$courseLang-WORDS"
                        activeLessonCountsTowardCourse = false
                        selectedExerciseIndex = 0
                        go(AppRoute.Lesson)
                    }
                )
                if (showGemShop) {
                    AlertDialog(
                        onDismissRequest = { showGemShop = false },
                        containerColor = Panel,
                        title = { Text("💎 Elmas Dükkânı — $gems", fontWeight = FontWeight.Bold, fontSize = 17.sp) },
                        text = {
                            Column {
                                Text("🧊 Seri Dondurucu", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                Text("Bir gün çalışamazsan serin bozulmaz. Sahip olduğun: ${learningProgress.streakFreezes}", color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 2.dp))
                                Surface(
                                    onClick = {
                                        if (gemStore.spend(200)) {
                                            learningProgress = progressStore.addStreakFreeze()
                                            gems = gemStore.gems()
                                            android.widget.Toast.makeText(context, "🧊 Seri Dondurucu hazır!", android.widget.Toast.LENGTH_SHORT).show()
                                        } else android.widget.Toast.makeText(context, "Yetersiz elmas — 200 💎 gerekli.", android.widget.Toast.LENGTH_SHORT).show()
                                    },
                                    color = Gold, shape = RoundedCornerShape(12.dp), modifier = Modifier.padding(top = 7.dp)
                                ) { Text("200 💎 — Satın al", color = Navy, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)) }
                                Spacer(Modifier.height(15.dp))
                                Text("🎟️ Çifte XP Bileti", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                val doubleActive = coursePrefs.getBoolean("doublexp_$courseUid", false)
                                Text(if (doubleActive) "Aktif! Sıradaki dersin XP'si iki kat yazılacak." else "Sıradaki dersten iki kat XP kazan.", color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 2.dp))
                                if (!doubleActive) {
                                    Surface(
                                        onClick = {
                                            if (gemStore.spend(150)) {
                                                coursePrefs.edit().putBoolean("doublexp_$courseUid", true).apply()
                                                gems = gemStore.gems()
                                                showGemShop = false
                                                android.widget.Toast.makeText(context, "🎟️ Çifte XP hazır — hadi derse!", android.widget.Toast.LENGTH_SHORT).show()
                                            } else android.widget.Toast.makeText(context, "Yetersiz elmas — 150 💎 gerekli.", android.widget.Toast.LENGTH_SHORT).show()
                                        },
                                        color = Gold, shape = RoundedCornerShape(12.dp), modifier = Modifier.padding(top = 7.dp)
                                    ) { Text("150 💎 — Satın al", color = Navy, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)) }
                                }
                                Spacer(Modifier.height(13.dp))
                                Text("Elmas kazan: ders +2 (%90+ → +4) • Checkpoint +10 • görev +5 • sandık +20 • seviye +15", color = Muted, fontSize = 11.sp, lineHeight = 15.sp)
                            }
                        },
                        confirmButton = { TextButton(onClick = { showGemShop = false }) { Text("Kapat", color = OnBg) } }
                    )
                }
            }
            composable<AppRoute.Practice> {
                PracticeScreen(
                    effectiveLevel, mistakeIds, skillStats, courseUnits,
                    onBack = { go(AppRoute.Home) },
                    onSelectLesson = { id -> selectedLessonId = id; activeLessonCountsTowardCourse = false; selectedExerciseIndex = 0; go(AppRoute.Lesson) },
                    onReviewExercise = { lessonId, exerciseIndex -> selectedLessonId = lessonId; activeLessonCountsTowardCourse = false; selectedExerciseIndex = exerciseIndex; go(AppRoute.Lesson) }
                )
            }
            composable<AppRoute.Review> {
                ReviewScreen(dueCards = dashboardState.dueReviewCards, onGrade = dashboardViewModel::gradeReview, onBack = { go(AppRoute.Home) })
            }
            composable<AppRoute.Progress> {
                ProgressScreen(effectiveLevel, completedForLevel, learningProgress, skillStats, courseUnits, onBack = { go(AppRoute.Home) })
            }
            composable<AppRoute.Profile> {
                ProfileScreen(
                    userName, accountEmail, level, completed, learningProgress,
                    username = username,
                    avatarCode = avatarCode,
                    onEditAvatar = { go(AppRoute.AvatarEditor) },
                    onSocial = { go(AppRoute.Social) },
                    onPro = { go(AppRoute.Pro) },
                    onBack = { go(AppRoute.Home) },
                    onSettings = { go(AppRoute.Settings) },
                    deletionBusy = deletionBusy,
                    onDeleteAccount = { password ->
                        deletionBusy = true
                        val uidToDelete = accountUid
                        accounts.deleteAccount(uidToDelete, password) { error ->
                            if (error == null) {
                                dashboardViewModel.clearAccountData(uidToDelete) { localError ->
                                    accounts.signOut()
                                    deletionBusy = false
                                    accountUid = ""
                                    accountEmail = ""
                                    userName = "Öğrenci"
                                    level = "A1"
                                    completed = 0
                                    completedByLevel = emptyMap()
                                    selectedLessonId = ""
                                    android.widget.Toast.makeText(context, localError ?: "Hesabın ve verilerin silindi.", android.widget.Toast.LENGTH_LONG).show()
                                    go(AppRoute.Welcome)
                                }
                            } else {
                                deletionBusy = false
                                android.widget.Toast.makeText(context, error, android.widget.Toast.LENGTH_LONG).show()
                            }
                        }
                    },
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
                if (selectedLessonId.endsWith("-PRO") && (!proState.hasPro || proState.uid != accountUid)) {
                    ProScreen(proViewModel, onBack = { go(AppRoute.Home) }, onPractice = startProPractice)
                } else LearningLessonScreen(
                    lesson = activeLesson,
                    exerciseIndex = selectedExerciseIndex,
                    onBack = { go(AppRoute.Home) },
                    onExerciseResult = { exerciseId, skill, correct ->
                        mistakeIds = mistakeBook.record(exerciseId, correct)
                        skillStats = skillProgressStore.record(skill, correct)
                    },
                    onDone = { score, studySeconds ->
                        val countsTowardCourse = activeLessonCountsTowardCourse
                        // Checkpoint barajı: %80 altı puan üniteyi geçirmez; ders yine günlüğe işlenir ama ilerleme artmaz.
                        val checkpointBlocked = activeLesson.id.endsWith("-CP") && (score ?: 0) < 80
                        if (lessonSaveBusy) return@LearningLessonScreen
                        lessonSaveBusy = true
                        dashboardViewModel.recordLesson(
                            accountUid, effectiveLevel, activeLesson.id, score,
                            activeLesson.targetVocabulary, countsTowardCourse && !checkpointBlocked
                        ) { saved ->
                        lessonSaveBusy = false
                        if (saved) {
                        if (countsTowardCourse && !checkpointBlocked) {
                            completed++
                            if (courseLang == "EN") {
                                completedByLevel = completedByLevel + (level to (completedForLevel + 1))
                            } else {
                                localLangCompleted += 1
                                coursePrefs.edit().putInt("completed_${courseUid}_${courseLang}_$langLevel", localLangCompleted).apply()
                            }
                        }
                        selectedLessonId = ""
                        activeLessonCountsTowardCourse = true
                        selectedExerciseIndex = 0
                        val levelBefore = LevelSystem.levelFor(learningProgress.totalXp)
                        learningProgress = progressStore.recordLesson(score, studiedSeconds = studySeconds)
                        // Günlük görev ilerlemesi
                        val questDay = DailyWords.todayEpochDay()
                        questStore.add(questDay, "lessons", 1)
                        questStore.add(questDay, "xp", LessonScoring.xpForCompletion(score))
                        if (activeLesson.id.endsWith("-REFRESH")) questStore.add(questDay, "refresh", 1)
                        if (activeLesson.id.endsWith("-WORDS")) questStore.add(questDay, "words", 1)
                        if (activeLesson.id.endsWith("-CP") && (score ?: 0) >= 80) questStore.add(questDay, "checkpoint", 1)
                        if (score != null && score >= 90) questStore.add(questDay, "perfect", 1)
                        questVersion++
                        // Seviye atlama kutlaması + bülten paylaşımı
                        val levelAfter = LevelSystem.levelFor(learningProgress.totalXp)
                        if (levelAfter > levelBefore) {
                            android.widget.Toast.makeText(context, "🎉 Seviye $levelAfter oldun!", android.widget.Toast.LENGTH_LONG).show()
                            if (accountUid.isNotBlank() && username.isNotBlank()) social.postActivity(accountUid, username, avatarCode, "Seviye $levelAfter oldu! ✨") { }
                        }
                        if (activeLesson.id.endsWith("-CP") && (score ?: 0) >= 80 && accountUid.isNotBlank() && username.isNotBlank()) {
                            social.postActivity(accountUid, username, avatarCode, "Bir Checkpoint'i %$score ile geçti! 🏁") { }
                        }
                        // Elmas kazanımları: ders +2 (%90+ → +4), geçilen Checkpoint +10, seviye atlama +15
                        var gemGain = if (score != null && score >= 90) 4 else 2
                        if (activeLesson.id.endsWith("-CP") && (score ?: 0) >= 80) gemGain += 10
                        if (levelAfter > levelBefore) gemGain += 15
                        gems = gemStore.add(gemGain)
                        // Çifte XP Bileti: bir sonraki ders iki kat XP verir, kullanınca tükenir
                        if (coursePrefs.getBoolean("doublexp_$courseUid", false)) {
                            coursePrefs.edit().putBoolean("doublexp_$courseUid", false).apply()
                            val doubleBonus = LessonScoring.xpForCompletion(score)
                            learningProgress = progressStore.addBonusXp(doubleBonus)
                            android.widget.Toast.makeText(context, "🎟️ Çifte XP bileti: +$doubleBonus bonus!", android.widget.Toast.LENGTH_SHORT).show()
                        }
                        syncBoard()
                        go(AppRoute.Home)
                        }
                        }
                    },
                    ttsAccent = dashboardState.settings.speechAccent,
                    speechRate = dashboardState.settings.speechRate
                )
            }
            composable<AppRoute.Stories> {
                StoriesListScreen(
                    lang = courseLang,
                    doneIds = doneStories,
                    onOpen = { sid -> selectedStoryId = sid; go(AppRoute.StoryPlayer) },
                    onBack = { go(AppRoute.Home) }
                )
            }
            composable<AppRoute.StoryPlayer> {
                val story = StoryCatalog.byId(selectedStoryId)
                if (story == null) {
                    StoriesListScreen(courseLang, doneStories, { sid -> selectedStoryId = sid; go(AppRoute.StoryPlayer) }, { go(AppRoute.Home) })
                } else {
                    StoryPlayerScreen(
                        story = story,
                        soundOn = true,
                        onFinished = { correct, total ->
                            if (story.id !in doneStories) {
                                doneStories = doneStories + story.id
                                coursePrefs.edit().putStringSet("stories_done_$courseUid", doneStories).apply()
                                learningProgress = progressStore.addBonusXp(10)
                                gems = gemStore.add(5)
                                if (accountUid.isNotBlank() && username.isNotBlank()) {
                                    social.postActivity(accountUid, username, avatarCode, "\"${story.title}\" hikâyesini bitirdi! 📖") { }
                                }
                                syncBoard()
                            }
                            android.widget.Toast.makeText(context, "📖 Hikâye bitti: $correct/$total doğru  •  +10 XP +5 💎", android.widget.Toast.LENGTH_LONG).show()
                            go(AppRoute.Stories)
                        },
                        onBack = { go(AppRoute.Stories) }
                    )
                }
            }
            composable<AppRoute.Social> {
                SocialScreen(
                    uid = accountUid,
                    username = username,
                    totalXp = learningProgress.totalXp,
                    avatarCode = avatarCode,
                    social = social,
                    onSaveUsername = { newName ->
                        username = newName
                        coursePrefs.edit().putString("username_$courseUid", newName).apply()
                        syncBoard()
                    },
                    onEditAvatar = { go(AppRoute.AvatarEditor) },
                    onBack = { go(AppRoute.Home) }
                )
            }
            composable<AppRoute.AvatarEditor> {
                AvatarEditorScreen(
                    initialCode = avatarCode,
                    onSave = { code ->
                        avatarCode = code
                        coursePrefs.edit().putString("avatar_$courseUid", code).apply()
                        syncBoard()
                        go(AppRoute.Profile)
                    },
                    onBack = { go(AppRoute.Profile) }
                )
            }
            composable<AppRoute.Locked> { LockedScreen(onBack = { go(AppRoute.Home) }) }
        }
    }
}


@Composable
private fun WelcomeScreen(onStart: () -> Unit, onLogin: () -> Unit) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(30.dp))
        Text("LINGUA PRO", color = OnBgSoft, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 5.sp)
        Spacer(Modifier.height(52.dp))
        // Çok dilli uygulama fikrini tipografiyle anlat: dev selamlama kelimesi dönüyor
        val greetings = remember { listOf("Hello", "Hallo", "Bonjour", "Hola", "Merhaba", "Ciao", "Olá", "Привет", "你好", "안녕") }
        var greetIndex by remember { mutableIntStateOf(0) }
        LaunchedEffect(Unit) {
            while (true) { delay(1700); greetIndex = (greetIndex + 1) % greetings.size }
        }
        Crossfade(targetState = greetings[greetIndex], animationSpec = tween(420), label = "greeting") { word ->
            Text(
                word,
                fontSize = 56.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                lineHeight = 64.sp,
                style = LocalTextStyle.current.copy(
                    brush = Brush.linearGradient(listOf(Gold, PinkAccent))
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.height(14.dp))
        Text("Hello, My Friend", color = OnBg, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("10 dilde yolculuk, tek uygulamada.", color = OnBgSoft, fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp))
        Spacer(Modifier.height(34.dp))
        Text("Daha iyi bir sen,\ndaha geniş bir dünya.", color = OnBg, fontSize = 29.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, lineHeight = 36.sp)
        Spacer(Modifier.height(12.dp))
        Text("Seviyene göre kişisel plan, kısa dersler ve konuşma pratiğiyle adım adım ilerle.", color = OnBgSoft, textAlign = TextAlign.Center, fontSize = 16.sp, lineHeight = 24.sp, modifier = Modifier.popIn(delayMillis = 260))
        Spacer(Modifier.height(24.dp))
        FeatureLine(Icons.Default.School, "Sana özel öğrenme programı", index = 0)
        FeatureLine(Icons.Default.RecordVoiceOver, "Örnek sesle konuşma ve tekrar çalışması", index = 1)
        FeatureLine(Icons.Default.TrendingUp, "A1’den C2’ye gelişim takibi", index = 2)
        Spacer(Modifier.height(24.dp))
        Box(Modifier.popIn(delayMillis = 480)) { PrimaryButton("Hemen Başla", onStart) }
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
    var password by remember { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf("") }
    val authViewModel: AuthViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = remember(accounts) { AuthViewModel.Factory(accounts) }
    )
    val authState by authViewModel.state.collectAsState()
    val busy = authState.busy
    var info by rememberSaveable { mutableStateOf("") }
    var acceptedLegal by rememberSaveable { mutableStateOf(false) }
    var legalDialog by rememberSaveable { mutableStateOf("") }
    LaunchedEffect(authState.result) {
        val result = authState.result ?: return@LaunchedEffect
        authViewModel.consumeResult()
        if (result.isSuccess) onContinue(result.displayName.ifBlank { name }, result.email.ifBlank { email }, result.uid.orEmpty())
        else error = result.error ?: "İşlem tamamlanamadı."
    }
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
                authViewModel.submit(AuthRequest(isLogin, name, email, password))
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
            color = Gold, fontSize = 13.sp, modifier = Modifier.align(Alignment.CenterHorizontally).clickable(enabled = !busy) { isLogin = !isLogin; error = ""; info = "" }.padding(10.dp)
        )
        if (!isLogin) {
            Spacer(Modifier.height(12.dp))
            if (!accounts.isConfigured) {
                InfoCard("Firebase yapılandırması bulunamadı. Gerçek hesap için Firebase Console kurulumu gerekir; aşağıdaki misafir akışı hesap oluşturmaz.")
                Spacer(Modifier.height(8.dp))
            }
            OutlinedButton(onClick = { onContinue(name.ifBlank { "Misafir Öğrenci" }, email, "") }, enabled = acceptedLegal && !busy, modifier = Modifier.fillMaxWidth()) {
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
                titleContentColor = Color(0xFFF5F1FF),
                textContentColor = Muted
            )
        }
    }
}

@Composable
private fun AppField(label: String, value: String, onValue: (String) -> Unit, icon: androidx.compose.ui.graphics.vector.ImageVector, isPassword: Boolean = false) {
    OutlinedTextField(value = value, onValueChange = onValue, modifier = Modifier.fillMaxWidth(), label = { Text(label) }, leadingIcon = { Icon(icon, null, tint = Muted) }, singleLine = true, visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None, colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Panel, unfocusedContainerColor = Panel, focusedTextColor = OnBg, unfocusedTextColor = OnBg, focusedBorderColor = Gold, unfocusedBorderColor = Panel2, focusedLabelColor = Gold, unfocusedLabelColor = Muted, cursorColor = Gold))
}



@Composable
private fun QuizScreen(index: Int, selected: Int, onSelect: (Int) -> Unit, onBack: () -> Unit, onNext: () -> Unit) {
    val q = questions[index]
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp)) {
        BackRow("Seviye belirleme", onBack)
        Text("İngilizce seviyeni belirlemek için soruları yanıtla.", color = OnBgSoft, modifier = Modifier.padding(top = 4.dp))
        Spacer(Modifier.height(18.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            val quizProgress by animateFloatAsState(targetValue = (index + 1f) / questions.size, animationSpec = tween(420, easing = FastOutSlowInEasing), label = "quizProgress")
            LinearProgressIndicator(progress = { quizProgress }, modifier = Modifier.weight(1f).height(8.dp), color = Color(0xFFFFFFFF), trackColor = Color(0x44FFFFFF))
            Text("  ${index + 1} / ${questions.size}", color = OnBgSoft, fontSize = 13.sp)
        }
        Spacer(Modifier.height(22.dp))
        Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(24.dp), modifier = Modifier.fillMaxWidth().enterOnChange(index)) {
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
                    Surface(onClick = { onSelect(i) }, color = if (isSelected) Color(0xFF3E2B6E) else Panel2, shape = RoundedCornerShape(14.dp), border = BorderStroke(if (isSelected) 2.dp else 1.dp, if (isSelected) Gold else Color(0x26FFFFFF)), modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp).pressScale()) {
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
private fun HomeScreen(name: String, level: String, langCode: String, onSelectLanguage: (String) -> Unit, onSelectLevel: (String) -> Unit, completed: Int, progress: LearningProgress, skillStats: Map<Skill, SkillTally>, courseUnits: List<LearningUnit>, dueReviewCount: Int, onReview: () -> Unit, onStartLesson: () -> Unit, onLocked: () -> Unit, onPractice: () -> Unit, onProgress: () -> Unit, onProfile: () -> Unit, onDailyRefresh: () -> Unit, dailyWords: List<TargetVocabulary> = emptyList(), onDailyWords: () -> Unit = {}, dailyQuests: List<QuestUi> = emptyList(), onClaimQuest: (DailyQuest) -> Unit = {}, onSocial: () -> Unit = {}, gems: Int = 0, onOpenShop: () -> Unit = {}, chestsClaimed: Set<String> = emptySet(), onClaimChest: (String) -> Unit = {}, onStories: () -> Unit = {}, storiesDoneCount: Int = 0, pendingSyncCount: Int = 0, onPro: () -> Unit = {}, proActive: Boolean = false, dailyGoalMinutes: Int = 10) {
    val langName = WorldCatalog.language(langCode).nameTr
    val moduleList = courseUnits
    val courseLessonCount = moduleList.sumOf { it.lessons.size }
    val lessonPointer = completed.coerceAtMost(courseLessonCount)
    val unitStartOffsets = run { var acc = 0; moduleList.map { u -> acc.also { acc += u.lessons.size } } }
    // Ödül anları için ekran-orta kutlama katmanı (sandık, görev)
    var celebration by remember { mutableStateOf<Celebration?>(null) }
    val pathListState = rememberLazyListState()
    // Açılışta patika doğrudan sıradaki üniteye atlar: 500+ derslik yolda yerini kaybetme yok
    LaunchedEffect(moduleList, lessonPointer) {
        var targetUnit = -1
        for (i in moduleList.indices) {
            val start = unitStartOffsets.getOrElse(i) { 0 }
            if (lessonPointer >= start && lessonPointer < start + moduleList[i].lessons.size) { targetUnit = i; break }
        }
        if (targetUnit < 0 && moduleList.isNotEmpty()) targetUnit = moduleList.lastIndex
        if (targetUnit > 0) {
            var itemIndex = 1 // 0: başlık/bento bloğu
            for (i in 0 until targetUnit) itemIndex += 1 + moduleList[i].lessons.size + if (moduleList[i].lessons.size >= 5) 1 else 0
            if (itemIndex >= 3) runCatching { pathListState.scrollToItem(itemIndex) }
        }
    }
    Box(Modifier.fillMaxSize()) {
    // Patika artık LazyColumn: yüzlerce düğüm yalnızca ekrana girerken oluşturulur (düşük cihaz performansı).
    LazyColumn(Modifier.fillMaxSize(), state = pathListState, contentPadding = PaddingValues(horizontal = 18.dp)) {
        item { Column {
        Spacer(Modifier.height(14.dp))
        Row(Modifier.fillMaxWidth().staggerIn(0), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column { Text("Merhaba, $name!", color = OnBg, fontSize = 26.sp, fontWeight = FontWeight.Bold); Text("$langName yolculuğuna devam et", color = OnBgSoft, fontSize = 13.sp) }
            Surface(onClick = onOpenShop, color = Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(end = 6.dp).pressScale()) {
                PopOnChange(gems) { RollingNumber(gems, color = OnBg, fontSize = 13.sp, fontWeight = FontWeight.Bold, prefix = "💎 ") }
            }
            IconButton(onClick = onProfile) { Icon(Icons.Default.AccountCircle, "Profili aç", tint = OnBg, modifier = Modifier.size(30.dp)) }
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth().staggerIn(1).horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            WorldCatalog.languages.forEach { lang ->
                val chosen = lang.code == langCode
                Surface(onClick = { onSelectLanguage(lang.code) }, color = if (chosen) Panel else Color(0x33FFFFFF), shape = RoundedCornerShape(20.dp), modifier = Modifier.pressScale()) {
                    Row(Modifier.padding(horizontal = 12.dp, vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(lang.flag, fontSize = 15.sp)
                        Text(lang.nameTr, color = if (chosen) Gold else OnBg, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
                    }
                }
            }
        }
        if (langCode != "EN") {
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                WorldCatalog.availableLevels(langCode).forEach { lv ->
                    val chosen = lv == level
                    Surface(onClick = { onSelectLevel(lv) }, color = if (chosen) Panel else Color(0x33FFFFFF), shape = RoundedCornerShape(20.dp), modifier = Modifier.pressScale()) {
                        Text(lv, color = if (chosen) Gold else OnBg, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp))
                    }
                }
            }
        }
        val levelLessonTotal = courseUnits.sumOf { it.lessons.size }
        if (levelLessonTotal > 0 && completed >= levelLessonTotal) {
            Spacer(Modifier.height(12.dp))
            Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth().popIn()) {
                Column(Modifier.padding(16.dp)) {
                    Text("🎉 $level seviyesini tamamladın!", color = Color(0xFFF5F1FF), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(
                        if (langCode == "EN") "Bilgini Günlük Tekrar ile taze tut; seviye testiyle üst seviyeye geçebilirsin."
                        else "Bilgini Günlük Tekrar ile taze tut veya bir üst seviyeye geç.",
                        color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 5.dp)
                    )
                    Row(Modifier.padding(top = 10.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        val nextLevel = levels.getOrNull(levels.indexOf(level) + 1)
                        if (langCode != "EN" && nextLevel != null) {
                            Surface(onClick = { onSelectLevel(nextLevel) }, color = Gold, shape = RoundedCornerShape(14.dp)) {
                                Text("$nextLevel seviyesine geç", color = Navy, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp))
                            }
                        }
                        Surface(onClick = onDailyRefresh, color = Panel2, shape = RoundedCornerShape(14.dp)) {
                            Text("Günlük Tekrar", color = Gold, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp))
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(14.dp))
        // Bento panosu: sıradaki ders (lime) + seri (pembe) + XP (cam) karoları
        val nextLessonTitle = remember(courseUnits, completed) {
            val flat = courseUnits.flatMap { it.lessons }
            flat.getOrNull(completed.coerceAtLeast(0))?.title ?: flat.lastOrNull()?.title ?: "Yeni derse başla"
        }
        Row(Modifier.fillMaxWidth().height(168.dp).staggerIn(2), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Surface(onClick = onStartLesson, color = Gold, shape = RoundedCornerShape(26.dp), modifier = Modifier.weight(1.35f).fillMaxHeight().clip(RoundedCornerShape(26.dp)).pressScale().shineSweep()) {
                Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
                    Text("SIRADAKİ DERS", color = Color(0x991A0E2E), fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.5.sp)
                    Text(nextLessonTitle, color = Navy, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 22.sp, maxLines = 3)
                    Text("▶  Başla", color = Navy, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }
            }
            Column(Modifier.weight(1f).fillMaxHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Surface(color = PinkAccent, shape = RoundedCornerShape(26.dp), modifier = Modifier.weight(1f).fillMaxWidth()) {
                    Column(Modifier.fillMaxSize().padding(horizontal = 14.dp), verticalArrangement = Arrangement.Center) {
                        Text(
                            "🔥 ${progress.streakDays}", color = Color(0xFF330C20), fontSize = 19.sp, fontWeight = FontWeight.ExtraBold,
                            modifier = if (progress.streakDays > 0) Modifier.flameFlicker() else Modifier
                        )
                        Text("gün seri", color = Color(0xB3330C20), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Surface(color = Panel, shape = RoundedCornerShape(26.dp), modifier = Modifier.weight(1f).fillMaxWidth()) {
                    Column(Modifier.fillMaxSize().padding(horizontal = 14.dp), verticalArrangement = Arrangement.Center) {
                        Text("${progress.todayStudySeconds / 60}/$dailyGoalMinutes dk", color = Gold, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                        Text(if (progress.studyGoalPercent(dailyGoalMinutes) >= 100) "hedef tamam!" else "günlük hedef", color = Muted, fontSize = 11.sp)
                    }
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        Surface(onClick = onDailyRefresh, color = Panel, border = BorderStroke(1.dp, Color(0x59C6FF4A)), shape = RoundedCornerShape(26.dp), modifier = Modifier.fillMaxWidth().staggerIn(3).pressScale()) {
            Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("🔄", fontSize = 22.sp)
                Column(Modifier.weight(1f).padding(start = 10.dp)) {
                    Text("Günlük Tekrar", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Her gün yenilenen 10 soruluk karışımla öğrendiklerini taze tut", color = Muted, fontSize = 12.sp, lineHeight = 16.sp, modifier = Modifier.padding(top = 3.dp))
                }
                Icon(Icons.Default.ChevronRight, null, tint = Gold)
            }
        }
        run {
            val storyTotal = StoryCatalog.storiesFor(langCode).size
            if (storyTotal > 0) {
                Spacer(Modifier.height(12.dp))
                Surface(onClick = onStories, color = Panel, border = BorderStroke(1.dp, Color(0x59FF5CA8)), shape = RoundedCornerShape(26.dp), modifier = Modifier.fillMaxWidth().staggerIn(4).pressScale()) {
                    Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text("📖", fontSize = 22.sp)
                        Column(Modifier.weight(1f).padding(start = 10.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Hikâyeler", color = PinkAccent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                Surface(color = PinkAccent, shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(start = 8.dp).popIn(delayMillis = 800)) {
                                    Text("YENİ", color = Color(0xFF330C20), fontSize = 9.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                }
                            }
                            Text("Diyalogları oku-dinle, soruları yanıtla • $storiesDoneCount/$storyTotal tamamlandı", color = Muted, fontSize = 12.sp, lineHeight = 16.sp, modifier = Modifier.padding(top = 3.dp))
                        }
                        Icon(Icons.Default.ChevronRight, null, tint = PinkAccent)
                    }
                }
            }
        }
        if (dailyQuests.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().staggerIn(5)) {
                Column(Modifier.padding(14.dp)) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("🗓️ Günlük Görevler", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("her gün yenilenir", color = Muted, fontSize = 10.sp)
                    }
                    dailyQuests.forEach { questUi ->
                        val done = questUi.progress >= questUi.quest.target
                        Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(questUi.quest.emoji, fontSize = 17.sp)
                            Column(Modifier.weight(1f).padding(start = 9.dp, end = 9.dp)) {
                                Text(questUi.quest.title, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                                Box(Modifier.fillMaxWidth().height(6.dp).background(Panel2, RoundedCornerShape(3.dp))) {
                                    val questFill by animateFloatAsState(
                                        targetValue = (questUi.progress.toFloat() / questUi.quest.target).coerceIn(0f, 1f),
                                        animationSpec = spring(stiffness = 220f, dampingRatio = 0.85f),
                                        label = "questFill"
                                    )
                                    Box(
                                        Modifier
                                            .fillMaxWidth(questFill)
                                            .height(6.dp)
                                            .background(Gold, RoundedCornerShape(3.dp))
                                    )
                                }
                            }
                            when {
                                questUi.claimed -> Text("✓", color = Gold, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.popIn())
                                done -> Surface(
                                    onClick = {
                                        celebration = Celebration("⚡", "+${questUi.quest.rewardXp} XP", "+5 💎 görev ödülü alındı!")
                                        onClaimQuest(questUi.quest)
                                    },
                                    color = Gold, shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.breathe()
                                ) {
                                    Text("+${questUi.quest.rewardXp} XP al", color = Navy, fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp))
                                }
                                else -> Text("${questUi.progress}/${questUi.quest.target}", color = Muted, fontSize = 11.sp)
                            }
                        }
                    }
                }
            }
        }
        if (dailyWords.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().staggerIn(6)) {
                Column(Modifier.padding(14.dp)) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("📚 Günün 5 Kelimesi", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("her gün yenilenir", color = Muted, fontSize = 10.sp)
                    }
                    Text("Bugün öğren, yarın tekrarıyla pekiştir — kalıcı ezber.", color = Muted, fontSize = 12.sp, lineHeight = 16.sp, modifier = Modifier.padding(top = 3.dp))
                    dailyWords.forEach { word ->
                        Row(Modifier.fillMaxWidth().padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(word.emoji, fontSize = 15.sp)
                            Text(word.termEn, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 8.dp))
                            Text(" • ${word.translationTr}", color = Muted, fontSize = 13.sp)
                        }
                    }
                    Surface(onClick = onDailyWords, color = Gold, shape = RoundedCornerShape(14.dp), modifier = Modifier.padding(top = 12.dp).pressScale()) {
                        Text("Çalış ve tekrar et", color = Navy, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp))
                    }
                }
            }
        }
        if (dueReviewCount > 0) {
            Spacer(Modifier.height(12.dp))
            Surface(onClick = onReview, color = Color(0xFF342457), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().staggerIn(7).pressScale()) {
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
            Surface(color = Color(0xFF342457), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().staggerIn(8).pressScale().clickable(onClick = onPractice)) {
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
        if (pendingSyncCount > 0) {
            InfoCard("$pendingSyncCount ders kaydı cihazında güvende. İnternet bağlantısında hesabınla eşitlenecek.")
            Spacer(Modifier.height(12.dp))
        }
        Surface(onClick = onPro, color = Panel2, shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, Gold), modifier = Modifier.fillMaxWidth().staggerIn(9).pressScale().padding(bottom = 18.dp)) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.AutoAwesome, null, tint = Gold)
                Column(Modifier.weight(1f).padding(start = 12.dp)) {
                    Text(if (proActive) "Sana özel Pro pratiği" else "Lingua Pro’yu keşfet", color = Gold, fontWeight = FontWeight.Bold)
                    Text("Hatalarına ve becerilerine göre kişisel oturumlar", color = OnBgSoft, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
                }
                Icon(Icons.Default.ChevronRight, "Lingua Pro’yu aç", tint = Gold)
            }
        }
        Text("$level Seviyesindeki Yolculuğun", color = OnBg, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.popIn(delayMillis = 500))
        Text("Hedeflerine adım adım ilerle", color = OnBgSoft, fontSize = 14.sp, modifier = Modifier.padding(top = 3.dp, bottom = 14.dp))
        } }
        // Duolingo tarzı kıvrımlı patika: her düğüm ayrı tembel öğe
        moduleList.forEachIndexed { i, unit ->
            val unitStart = unitStartOffsets[i]
            val unitEnd = unitStart + unit.lessons.size
            val unitDone = lessonPointer >= unitEnd
            val unitCurrent = lessonPointer in unitStart until unitEnd
            item { Column {
            Surface(color = if (unitDone || unitCurrent) Gold else Panel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("${i + 1}. ÜNİTE", color = if (unitDone || unitCurrent) Color(0x991A0E2E) else Muted, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.5.sp)
                        Text(unit.title, color = if (unitDone || unitCurrent) Navy else OnBg, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(top = 2.dp))
                    }
                    if (unitDone) Text("✓", color = Navy, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                }
            }
            Spacer(Modifier.height(4.dp))
            } }
            unit.lessons.forEachIndexed { li, pathLesson -> item {
                val g = unitStart + li
                val nodeDone = g < lessonPointer
                val nodeCurrent = g == lessonPointer
                val isCp = pathLesson.id.endsWith("-CP")
                val xOffset = (kotlin.math.sin(g * 1.05) * 86).dp
                if (li > 0) {
                    val prevOffset = (kotlin.math.sin((g - 1) * 1.05) * 86).dp
                    repeat(2) { d ->
                        val t = (d + 1) / 3f
                        Box(Modifier.fillMaxWidth().padding(vertical = 2.dp), contentAlignment = Alignment.Center) {
                            Box(Modifier.offset(x = prevOffset + (xOffset - prevOffset) * t).size(7.dp).background(if (g <= lessonPointer) Gold else Color(0x33FFFFFF), CircleShape))
                        }
                    }
                }
                Box(Modifier.fillMaxWidth().padding(vertical = 3.dp), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.offset(x = xOffset)) {
                        val pulse = if (nodeCurrent) {
                            val nodeAnim = rememberInfiniteTransition(label = "pathNode")
                            nodeAnim.animateFloat(1f, 1.08f, infiniteRepeatable(tween(650), RepeatMode.Reverse), label = "pulse").value
                        } else 1f
                        Surface(
                            onClick = { if (nodeCurrent) onStartLesson() else if (!nodeDone) onLocked() },
                            color = if (nodeDone || nodeCurrent) Gold else Panel2,
                            shape = CircleShape,
                            shadowElevation = if (nodeCurrent) 8.dp else 2.dp,
                            border = if (nodeCurrent) BorderStroke(3.dp, Color(0xFFF5F1FF)) else null,
                            modifier = Modifier
                                .size(60.dp)
                                .then(if (nodeCurrent) Modifier.nodeGlow() else Modifier)
                                .graphicsLayer { scaleX = pulse; scaleY = pulse }
                                .pressScale()
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                if (isCp) Text("🏆", fontSize = 24.sp)
                                else Icon(
                                    if (nodeDone) Icons.Default.Check else if (nodeCurrent) Icons.Default.Star else Icons.Default.Lock,
                                    pathLesson.title + if (nodeDone) ", tamamlandı" else if (nodeCurrent) ", sıradaki ders" else ", kilitli",
                                    tint = if (nodeDone || nodeCurrent) Navy else Muted,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }
                        if (nodeCurrent) Text(pathLesson.title, color = OnBgSoft, fontSize = 10.sp, maxLines = 1, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 4.dp).width(150.dp))
                    }
                }
            }
                // Ünite ortasında elmas sandığı: ilk 3 ders bitince açılır, bir kez alınır
                if (li == 2 && unit.lessons.size >= 5) item {
                    val chestUnlocked = lessonPointer >= unitStart + 3
                    val chestTaken = unit.id in chestsClaimed
                    val chestOffset = (kotlin.math.sin((unitStart + li + 0.5) * 1.05) * 86).dp
                    Box(Modifier.fillMaxWidth().padding(vertical = 3.dp), contentAlignment = Alignment.Center) {
                        Surface(
                            onClick = {
                                if (chestUnlocked && !chestTaken) {
                                    celebration = Celebration("🎁", "+20 💎", "Elmas sandığı açıldı!")
                                    onClaimChest(unit.id)
                                } else if (!chestUnlocked) onLocked()
                            },
                            color = if (chestTaken) Panel2 else if (chestUnlocked) PinkAccent else Panel2,
                            shape = CircleShape,
                            shadowElevation = if (chestUnlocked && !chestTaken) 8.dp else 2.dp,
                            border = if (chestUnlocked && !chestTaken) BorderStroke(2.dp, Color(0xFFF5F1FF)) else null,
                            modifier = Modifier
                                .offset(x = chestOffset)
                                .size(52.dp)
                                .then(if (chestUnlocked && !chestTaken) Modifier.wiggleForever() else Modifier)
                                .pressScale()
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                if (chestTaken) Text("✓", color = Gold, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                                else Text("🎁", fontSize = 22.sp)
                            }
                        }
                    }
                }
            }
            item { Spacer(Modifier.height(14.dp)) }
        }
        item { Column {
        Spacer(Modifier.height(8.dp))
        PrimaryButton(if (completed >= courseLessonCount) "↻   Dersleri tekrar et" else "▶   Derse başla", onStartLesson)
        Spacer(Modifier.height(14.dp))
        InfoCard("$level seviyesine özel programın hazır. Kısa derslerle her gün biraz daha ilerle.")
        Spacer(Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth().padding(horizontal = 22.dp).background(Color(0xE62A1B4D), RoundedCornerShape(30.dp)).border(1.dp, Color(0x2EFFFFFF), RoundedCornerShape(30.dp)).padding(vertical = 12.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            NavItem(Icons.Default.Home, "Ana Sayfa", true) { }
            NavItem(Icons.Default.Headphones, "Pratik", false, onPractice)
            NavItem(Icons.Default.Groups, "Topluluk", false, onSocial)
            NavItem(Icons.Default.BarChart, "İlerleme", false, onProgress)
            NavItem(Icons.Default.Person, "Profil", false, onProfile)
        }
        Spacer(Modifier.height(16.dp))
        } }
    }
    // Kutlama katmanı: sandık/görev ödülleri parçacık patlamasıyla kutlanır
    CelebrationOverlay(celebration, onDismiss = { celebration = null })
    }
}

@Composable
private fun PracticeScreen(level: String, mistakeIds: Set<String>, skillStats: Map<Skill, SkillTally>, courseUnits: List<LearningUnit>, onBack: () -> Unit, onSelectLesson: (String) -> Unit, onReviewExercise: (String, Int) -> Unit) {
    val recommendedSkill = SkillProgressLogic.weakest(skillStats)
    var selectedSkill by rememberSaveable(level, recommendedSkill?.name) { mutableStateOf(recommendedSkill?.let(::skillLabel) ?: "Tümü") }
    val lessons = courseUnits.flatMap { it.lessons }
    val allLessons = (CourseCatalog.allLessons() + WorldCatalog.allWorldLessons() + lessons).distinctBy { it.id }
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
            Surface(color = Color(0xFF342457), shape = RoundedCornerShape(14.dp), modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                Row(Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text("Önerilen odak: ${skillLabel(focus)} • ${tally.accuracyPercent}% / ${tally.attempts} deneme", color = Muted, fontSize = 11.sp, modifier = Modifier.weight(1f))
                    TextButton(onClick = { selectedSkill = skillLabel(focus) }) { Text("Dersleri gör", color = Gold, fontSize = 11.sp) }
                }
            }
        }
        if (reviewItems.isNotEmpty()) {
            Text("Tekrar etmen gerekenler  •  ${reviewItems.size}", color = OnBg, fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 5.dp))
            reviewItems.forEach { (lesson, exerciseIndex, exercise) ->
                Surface(onClick = { onReviewExercise(lesson.id, exerciseIndex) }, color = Color(0xFFF3E8FF), shape = RoundedCornerShape(15.dp), modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).pressScale()) {
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
            Surface(onClick = { onSelectLesson(lesson.id) }, color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(17.dp), modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp).pressScale()) {
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
private fun ProgressScreen(level: String, completed: Int, progress: LearningProgress, skillStats: Map<Skill, SkillTally>, courseUnits: List<LearningUnit>, onBack: () -> Unit) {
    val units = courseUnits
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
                val percentAnim by animateFloatAsState(targetValue = percent / 100f, animationSpec = tween(750, easing = FastOutSlowInEasing), label = "pathPercent")
                LinearProgressIndicator(progress = { percentAnim }, modifier = Modifier.fillMaxWidth().padding(top = 13.dp).height(8.dp), color = Gold, trackColor = Panel2)
                Text("$done / $total ders tamamlandı", color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp))
            }
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard("🔥", "${progress.streakDays} gün", "Çalışma serisi", Modifier.weight(1f).staggerIn(0))
            StatCard("✦", "${progress.totalXp} XP", "Toplam deneyim", Modifier.weight(1f).staggerIn(1))
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
private fun LockedScreen(onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Icon(Icons.Default.Lock, null, tint = OnBg, modifier = Modifier.size(60.dp).popIn())
        Text("Bu ünite sıradaki adımda açılacak", color = OnBg, fontSize = 23.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 18.dp))
        Text("Önce mevcut üniteni tamamla; öğrenme programın adım adım ilerler.", color = OnBgSoft, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp))
        Spacer(Modifier.height(24.dp)); PrimaryButton("Ana sayfaya dön", onBack)
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
    Column(Modifier.pressScale().clickable(onClick = onClick).padding(horizontal = 7.dp, vertical = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, null, tint = if (active) Gold else Muted)
        Text(text, color = if (active) Gold else Muted, fontSize = 10.sp, modifier = Modifier.padding(top = 3.dp))
    }
}
