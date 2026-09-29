package com.linguapro.android.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/** Versioned, serializable lesson payload allows content packs to evolve independently of screens. */
@Entity(tableName = "lessons", indices = [Index(value = ["cefrLevel"]), Index(value = ["unitId"])])
data class LessonEntity(
    @PrimaryKey val id: String,
    val cefrLevel: String,
    val unitId: String,
    @ColumnInfo(defaultValue = "''") val unitTitle: String,
    @ColumnInfo(defaultValue = "''") val unitSummary: String,
    val title: String,
    val canDo: String,
    val contentJson: String,
    val contentVersion: Int = 1
)

@Entity(tableName = "vocabulary", indices = [Index(value = ["cefrLevel"]), Index(value = ["lessonId"]), Index(value = ["lemma"])])
data class VocabularyEntity(
    @PrimaryKey val id: String,
    val cefrLevel: String,
    val unitId: String,
    val lessonId: String,
    val lemma: String,
    val translationTr: String,
    val exampleEn: String,
    val exampleTr: String,
    val imageEmoji: String = "📘",
    val audioText: String = lemma
)

@Entity(
    tableName = "review_cards",
    indices = [Index(value = ["learnerId", "dueAtEpochMillis"]), Index(value = ["vocabularyId"])],
    foreignKeys = [ForeignKey(
        entity = VocabularyEntity::class,
        parentColumns = ["id"],
        childColumns = ["vocabularyId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ReviewCardEntity(
    @PrimaryKey val id: String,
    val learnerId: String,
    val vocabularyId: String,
    val direction: String,
    val repetitions: Int = 0,
    val intervalDays: Double = 0.0,
    val easeFactor: Double = 2.5,
    val dueAtEpochMillis: Long,
    val lastReviewedAtEpochMillis: Long? = null,
    val lapseCount: Int = 0
)

@Entity(
    tableName = "lesson_progress",
    indices = [Index(value = ["learnerId", "completedAtEpochMillis"])]
)
data class LessonProgressEntity(
    @PrimaryKey val id: String,
    val learnerId: String,
    val cefrLevel: String,
    val lessonId: String,
    val scorePercent: Int?,
    val completedAtEpochMillis: Long,
    val attemptCount: Int = 1
)
