package com.linguapro.android.data.repository

import com.linguapro.android.data.local.LessonDao
import com.linguapro.android.data.local.LessonEntity
import com.linguapro.android.data.local.LessonProgressDao
import com.linguapro.android.data.local.LessonProgressEntity
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

interface LearningRepository {
    fun observeLessons(level: String): Flow<List<LessonEntity>>
    fun observeLessonProgress(learnerId: String, level: String): Flow<List<LessonProgressEntity>>
    fun observeCompletedLessonCount(learnerId: String, level: String): Flow<Int>
    suspend fun recordLesson(learnerId: String, level: String, lessonId: String, scorePercent: Int, nowEpochMillis: Long = System.currentTimeMillis())
}

@Singleton
class RoomLearningRepository @Inject constructor(
    private val lessons: LessonDao,
    private val progress: LessonProgressDao
) : LearningRepository {
    override fun observeLessons(level: String) = lessons.observeByLevel(level)

    override fun observeLessonProgress(learnerId: String, level: String) = progress.observeForLearner(learnerId, level)

    override fun observeCompletedLessonCount(learnerId: String, level: String) = progress.observeCompletedLessonCount(learnerId, level)

    override suspend fun recordLesson(learnerId: String, level: String, lessonId: String, scorePercent: Int, nowEpochMillis: Long) {
        require(learnerId.isNotBlank())
        require(level.matches(Regex("A[12]|B[12]|C[12]")))
        require(scorePercent in 0..100)
        val id = "$learnerId:$lessonId"
        val previous = progress.getById(id)
        progress.upsert(
            LessonProgressEntity(
                id = id,
                learnerId = learnerId,
                cefrLevel = level,
                lessonId = lessonId,
                scorePercent = scorePercent,
                completedAtEpochMillis = nowEpochMillis,
                attemptCount = (previous?.attemptCount ?: 0) + 1
            )
        )
    }
}
