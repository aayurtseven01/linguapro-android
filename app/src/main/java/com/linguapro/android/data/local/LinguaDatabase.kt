package com.linguapro.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LessonEntity::class, VocabularyEntity::class, ReviewCardEntity::class, LessonProgressEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LinguaDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao
    abstract fun vocabularyDao(): VocabularyDao
    abstract fun reviewCardDao(): ReviewCardDao
    abstract fun lessonProgressDao(): LessonProgressDao
}
