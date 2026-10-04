package com.linguapro.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [LessonEntity::class, VocabularyEntity::class, ReviewCardEntity::class, LessonProgressEntity::class, ContentPackEntity::class, PendingLessonEvent::class],
    version = 5,
    exportSchema = false
)
abstract class LinguaDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao
    abstract fun vocabularyDao(): VocabularyDao
    abstract fun reviewCardDao(): ReviewCardDao
    abstract fun lessonProgressDao(): LessonProgressDao
    abstract fun contentPackDao(): ContentPackDao
    abstract fun pendingLessonEventDao(): PendingLessonEventDao

    companion object {
        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("""CREATE TABLE IF NOT EXISTS pending_lesson_events (
                    id TEXT NOT NULL, learnerId TEXT NOT NULL, lessonId TEXT NOT NULL,
                    scorePercent INTEGER, countsTowardCourse INTEGER NOT NULL,
                    createdAtEpochMillis INTEGER NOT NULL, PRIMARY KEY(id))""".trimIndent())
                db.execSQL("CREATE INDEX IF NOT EXISTS index_pending_lesson_events_learnerId ON pending_lesson_events(learnerId)")
            }
        }
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

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE lessons ADD COLUMN unitTitle TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE lessons ADD COLUMN unitSummary TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE review_cards ADD COLUMN frontText TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE review_cards ADD COLUMN backText TEXT NOT NULL DEFAULT ''")
            }
        }
    }
}
