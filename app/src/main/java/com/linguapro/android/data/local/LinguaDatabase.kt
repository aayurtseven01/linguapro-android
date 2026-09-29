package com.linguapro.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [LessonEntity::class, VocabularyEntity::class, ReviewCardEntity::class, LessonProgressEntity::class, ContentPackEntity::class],
    version = 2,
    exportSchema = false
)
abstract class LinguaDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao
    abstract fun vocabularyDao(): VocabularyDao
    abstract fun reviewCardDao(): ReviewCardDao
    abstract fun lessonProgressDao(): LessonProgressDao
    abstract fun contentPackDao(): ContentPackDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """CREATE TABLE IF NOT EXISTS content_packs (
                        id TEXT NOT NULL,
                        schemaVersion INTEGER NOT NULL,
                        contentVersion TEXT NOT NULL,
                        installedAtEpochMillis INTEGER NOT NULL,
                        PRIMARY KEY(id)
                    )""".trimIndent()
                )
                db.execSQL(
                    """CREATE TABLE IF NOT EXISTS lesson_progress_v2 (
                        id TEXT NOT NULL,
                        learnerId TEXT NOT NULL,
                        cefrLevel TEXT NOT NULL,
                        lessonId TEXT NOT NULL,
                        scorePercent INTEGER,
                        completedAtEpochMillis INTEGER NOT NULL,
                        attemptCount INTEGER NOT NULL,
                        PRIMARY KEY(id)
                    )""".trimIndent()
                )
                db.execSQL(
                    """INSERT INTO lesson_progress_v2 (id, learnerId, cefrLevel, lessonId, scorePercent, completedAtEpochMillis, attemptCount)
                        SELECT id, learnerId,
                            CASE WHEN instr(lessonId, '-') > 0 THEN substr(lessonId, 1, instr(lessonId, '-') - 1) ELSE 'A1' END,
                            lessonId, scorePercent, completedAtEpochMillis, attemptCount
                        FROM lesson_progress""".trimIndent()
                )
                db.execSQL("DROP TABLE lesson_progress")
                db.execSQL("ALTER TABLE lesson_progress_v2 RENAME TO lesson_progress")
                db.execSQL("CREATE INDEX IF NOT EXISTS index_lesson_progress_learnerId_completedAtEpochMillis ON lesson_progress(learnerId, completedAtEpochMillis)")
            }
        }
    }
}
