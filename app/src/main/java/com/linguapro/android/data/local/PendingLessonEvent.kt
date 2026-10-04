package com.linguapro.android.data.local

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/** Durable outbox: an attempt keeps the same id through every network retry. */
@Entity(tableName = "pending_lesson_events", indices = [Index(value = ["learnerId"])])
data class PendingLessonEvent(
    @PrimaryKey val id: String,
    val learnerId: String,
    val lessonId: String,
    val scorePercent: Int?,
    val countsTowardCourse: Boolean,
    val createdAtEpochMillis: Long
)

@Dao
interface PendingLessonEventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun enqueue(event: PendingLessonEvent)

    @Query("SELECT * FROM pending_lesson_events WHERE learnerId = :learnerId ORDER BY createdAtEpochMillis LIMIT 100")
    suspend fun nextBatch(learnerId: String): List<PendingLessonEvent>

    @Query("SELECT COUNT(*) FROM pending_lesson_events WHERE learnerId = :learnerId")
    fun observeCount(learnerId: String): Flow<Int>

    @Query("DELETE FROM pending_lesson_events WHERE id = :id")
    suspend fun acknowledge(id: String)

    @Query("DELETE FROM pending_lesson_events WHERE learnerId = :learnerId")
    suspend fun deleteForLearner(learnerId: String)
}
