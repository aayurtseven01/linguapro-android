package com.linguapro.android

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.Context
import com.linguapro.android.data.LocalAccountDataCleaner
import com.linguapro.android.data.local.LinguaDatabase
import com.linguapro.android.data.local.LessonProgressEntity
import com.linguapro.android.data.local.PendingLessonEvent
import java.time.LocalDate
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OfflineLearningTest {
    @Test fun dateLogicRunsOnTheMinimumSupportedAndroidVersion() {
        assertEquals(2, StreakLogic.nextStreak(1, LocalDate.of(2026, 10, 3), LocalDate.of(2026, 10, 4)))
    }

    @Test fun pendingAttemptSurvivesDatabaseReopeningAndAccountCleanupIsIsolated() = runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val name = "offline-test-${System.nanoTime()}.db"
        var database = Room.databaseBuilder(context, LinguaDatabase::class.java, name).build()
        try {
            val dao = database.pendingLessonEventDao()
            dao.enqueue(PendingLessonEvent("attempt-alice", "test-alice", "A1-U1-L1", 90, true, 1L))
            dao.enqueue(PendingLessonEvent("attempt-alice", "test-alice", "A1-U1-L1", 90, true, 1L))
            dao.enqueue(PendingLessonEvent("attempt-bob", "test-bob", "A1-U1-L1", 70, true, 2L))
            database.lessonProgressDao().upsert(LessonProgressEntity("test-alice:A1-U1-L1", "test-alice", "A1", "A1-U1-L1", 90, 1L))
            database.lessonProgressDao().upsert(LessonProgressEntity("test-bob:A1-U1-L1", "test-bob", "A1", "A1-U1-L1", 70, 2L))
            database.close()
            database = Room.databaseBuilder(context, LinguaDatabase::class.java, name).build()
            assertEquals(1, database.pendingLessonEventDao().observeCount("test-alice").first())
            assertEquals("attempt-alice", database.pendingLessonEventDao().nextBatch("test-alice").single().id)
            context.getSharedPreferences("learner_progress_v1_test-alice", Context.MODE_PRIVATE).edit().putInt("total_xp", 200).commit()
            context.getSharedPreferences("learner_progress_v1_test-bob", Context.MODE_PRIVATE).edit().putInt("total_xp", 300).commit()
            LocalAccountDataCleaner(context, database).clear("test-alice")
            assertTrue(database.pendingLessonEventDao().nextBatch("test-alice").isEmpty())
            assertEquals(0, database.lessonProgressDao().observeCompletedLessonCount("test-alice", "A1").first())
            assertEquals(1, database.pendingLessonEventDao().observeCount("test-bob").first())
            assertEquals(1, database.lessonProgressDao().observeCompletedLessonCount("test-bob", "A1").first())
            assertEquals(300, context.getSharedPreferences("learner_progress_v1_test-bob", Context.MODE_PRIVATE).getInt("total_xp", 0))
        } finally {
            database.close()
            context.deleteDatabase(name)
            listOf("test-alice", "test-bob").forEach { uid ->
                context.getSharedPreferences("learner_progress_v1_$uid", Context.MODE_PRIVATE).edit().clear().commit()
            }
        }
    }
}
