package com.linguapro.android.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonDao {
    @Query("SELECT * FROM lessons ORDER BY cefrLevel, unitId, id")
    fun observeAll(): Flow<List<LessonEntity>>

    @Query("SELECT * FROM lessons WHERE cefrLevel = :level ORDER BY unitId, id")
    fun observeByLevel(level: String): Flow<List<LessonEntity>>

    @Query("SELECT * FROM lessons WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): LessonEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<LessonEntity>)

    @Query("SELECT COUNT(*) FROM lessons")
    suspend fun count(): Int
}

@Dao
interface VocabularyDao {
    @Query("SELECT * FROM vocabulary WHERE cefrLevel = :level ORDER BY lemma")
    fun observeByLevel(level: String): Flow<List<VocabularyEntity>>

    @Query("SELECT * FROM vocabulary WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): VocabularyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<VocabularyEntity>)
}

@Dao
interface ReviewCardDao {
    @Query("SELECT * FROM review_cards WHERE learnerId = :learnerId AND dueAtEpochMillis <= :now ORDER BY dueAtEpochMillis")
    fun observeDue(learnerId: String, now: Long): Flow<List<ReviewCardEntity>>

    @Query("SELECT COUNT(*) FROM review_cards WHERE learnerId = :learnerId AND dueAtEpochMillis <= :now")
    fun observeDueCount(learnerId: String, now: Long): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(card: ReviewCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(cards: List<ReviewCardEntity>)
}

@Dao
interface LessonProgressDao {
    @Query("SELECT * FROM lesson_progress WHERE learnerId = :learnerId AND cefrLevel = :level ORDER BY completedAtEpochMillis DESC")
    fun observeForLearner(learnerId: String, level: String): Flow<List<LessonProgressEntity>>

    @Query("SELECT COUNT(DISTINCT lessonId) FROM lesson_progress WHERE learnerId = :learnerId AND cefrLevel = :level")
    fun observeCompletedLessonCount(learnerId: String, level: String): Flow<Int>

    @Query("SELECT * FROM lesson_progress WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): LessonProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(progress: LessonProgressEntity)
}
