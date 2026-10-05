package com.linguapro.android

import android.content.Context
import android.os.Looper
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.linguapro.android.audio.*
import com.linguapro.android.data.LocalAccountDataCleaner
import com.linguapro.android.data.local.LinguaDatabase
import java.io.File
import java.time.LocalDate
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuditRegressionTest {
    private val context get() = ApplicationProvider.getApplicationContext<Context>()

    @Test fun languageSkillsAreIsolatedAndAccountDeletionClearsEveryCourse() = runBlocking {
        val uid = "audit-skills-${System.nanoTime()}"
        val other = "$uid-other"
        val database = Room.inMemoryDatabaseBuilder(context, LinguaDatabase::class.java).build()
        try {
            SkillProgressStore(context, uid, "EN").record(Skill.LISTENING, true)
            SkillProgressStore(context, uid, "DE").record(Skill.LISTENING, false)
            SkillProgressStore(context, other, "EN").record(Skill.LISTENING, true)
            PracticeHistoryStore(context, uid, "EN", "A1").rememberSession(listOf("a1-item"))
            PracticeHistoryStore(context, other, "EN", "A1").rememberSession(listOf("other-item"))
            assertEquals(1L, PracticeHistoryStore(context, uid, "EN", "A1").seed())
            assertTrue(PracticeHistoryStore(context, uid, "DE", "A1").recentIds().isEmpty())
            assertTrue(PracticeHistoryStore(context, uid, "EN", "A2").recentIds().isEmpty())
            assertEquals(SkillTally(1, 1), SkillProgressStore(context, uid, "EN").read().getValue(Skill.LISTENING))
            assertEquals(SkillTally(1, 0), SkillProgressStore(context, uid, "DE").read().getValue(Skill.LISTENING))
            assertEquals(SkillTally(), SkillProgressStore(context, uid, "JA").read().getValue(Skill.LISTENING))
            LocalAccountDataCleaner(context, database).clear(uid)
            WorldCatalog.languages.forEach { language ->
                assertTrue(SkillProgressStore(context, uid, language.code).read().values.all { it.attempts == 0 })
            }
            assertEquals(SkillTally(1, 1), SkillProgressStore(context, other, "EN").read().getValue(Skill.LISTENING))
            assertTrue(PracticeHistoryStore(context, uid, "EN", "A1").recentIds().isEmpty())
            assertEquals(setOf("other-item"), PracticeHistoryStore(context, other, "EN", "A1").recentIds())
        } finally {
            listOf(uid, other).forEach { learner -> WorldCatalog.languages.forEach { language ->
                context.getSharedPreferences("skill_progress_v2_${learner}_${language.code}", Context.MODE_PRIVATE).edit().clear().commit()
            } }
            listOf(uid, other).forEach { learner -> context.getSharedPreferences("practice_history_v1_$learner", Context.MODE_PRIVATE).edit().clear().commit() }
            database.close()
        }
    }


    @Test fun lessonReturnPreservesStudySecondsAndConsumesExactlyOneFreeze() {
        val uid = "audit-progress-${System.nanoTime()}"
        val prefs = context.getSharedPreferences("learner_progress_v1_$uid", Context.MODE_PRIVATE)
        val store = LearningProgressStore(context, uid)
        val day = LocalDate.of(2026, 10, 5)
        try {
            store.recordLesson(90, day.minusDays(2), 30)
            store.addStreakFreeze(day.minusDays(2))
            val first = store.recordLesson(90, day, 120)
            assertEquals(120, first.todayStudySeconds)
            assertEquals(0, first.streakFreezes)
            assertEquals(2, first.streakDays)
            assertEquals(20, first.studyGoalPercent(10))
            assertEquals(store.read(day), first)
            val second = store.recordLesson(90, day, 60)
            assertEquals(180, second.todayStudySeconds)
            assertEquals(0, second.streakFreezes)
            assertEquals(2, second.streakDays)
            assertEquals(store.read(day), second)
        } finally { prefs.edit().clear().commit() }
    }

    @Test fun accountCleanupRemovesNewRewardsAndStoriesWithoutTouchingAnotherUser() = runBlocking {
        val uid = "audit-delete-${System.nanoTime()}"
        val other = "$uid-other"
        val database = Room.inMemoryDatabaseBuilder(context, LinguaDatabase::class.java).build()
        val course = context.getSharedPreferences("lingua_course", Context.MODE_PRIVATE)
        try {
            listOf(uid, other).forEach { learner ->
                GemStore(context, learner).apply { add(400); claimChest("DE-A1-U1") }
                course.edit().putStringSet("stories_done_$learner", setOf("EN-A1-S1"))
                    .putBoolean("doublexp_$learner", true).commit()
            }
            LocalAccountDataCleaner(context, database).clear(uid)
            assertEquals(0, GemStore(context, uid).gems())
            assertTrue(GemStore(context, uid).claimedChests().isEmpty())
            assertFalse(course.contains("stories_done_$uid"))
            assertFalse(course.contains("doublexp_$uid"))
            assertEquals(400, GemStore(context, other).gems())
            assertEquals(setOf("DE-A1-U1"), GemStore(context, other).claimedChests())
            assertEquals(setOf("EN-A1-S1"), course.getStringSet("stories_done_$other", emptySet()))
            assertTrue(course.getBoolean("doublexp_$other", false))
        } finally {
            listOf(uid, other).forEach { learner ->
                context.getSharedPreferences("gems_v1_$learner", Context.MODE_PRIVATE).edit().clear().commit()
                course.edit().remove("stories_done_$learner").remove("doublexp_$learner").commit()
            }
            database.close()
        }
    }

    @Test fun corruptCachedAudioFallsBackOnMainAndIsRemovedInsteadOfStayingSilent() {
        val voice = "audit-voice-${System.nanoTime()}"
        val text = "Fallback should speak this sentence."
        val key = AudioKey.forVoice(voice, text)
        val cache = AudioCache(File(context.filesDir, "audio_cache"))
        cache.put(key, "not an MP3".toByteArray())
        val catalog = RemoteVoiceCatalog(1, "https://example.invalid/audio/v1", mapOf("en-US" to RemoteVoicePair(voice, voice)))
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
        val player = RemoteSpeechPlayer(context, scope, catalogProvider = { catalog })
        val latch = CountDownLatch(1)
        val calls = AtomicInteger()
        var onMain = false
        try {
            InstrumentationRegistry.getInstrumentation().runOnMainSync {
                player.speak("en-US", text, true) {
                    onMain = Looper.myLooper() == Looper.getMainLooper()
                    calls.incrementAndGet()
                    latch.countDown()
                }
            }
            assertTrue("A corrupt cached MP3 must invoke device TTS fallback", latch.await(10, TimeUnit.SECONDS))
            assertEquals(1, calls.get())
            assertTrue(onMain)
            assertNull(cache.get(key))
        } finally {
            InstrumentationRegistry.getInstrumentation().runOnMainSync { player.release() }
            scope.cancel()
            cache.remove(key)
        }
    }
}

