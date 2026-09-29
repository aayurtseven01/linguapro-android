package com.linguapro.android.data.content

import android.content.Context
import androidx.room.withTransaction
import com.linguapro.android.CourseContentPack
import com.linguapro.android.LearningLesson
import com.linguapro.android.data.local.LessonEntity
import com.linguapro.android.data.local.LinguaDatabase
import com.linguapro.android.data.local.VocabularyEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Singleton
class CourseSeedInitializer @Inject constructor(
    @ApplicationContext private val context: Context,
    private val database: LinguaDatabase
) {
    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    suspend fun seedIfEmpty(): Result<Int> = runCatching {
        if (database.lessonDao().count() > 0) return@runCatching 0
        val pack = context.assets.open(ASSET_FILE).bufferedReader(Charsets.UTF_8).use { reader ->
            json.decodeFromString<CourseContentPack>(reader.readText())
        }
        val problems = CoursePackValidator.errors(pack)
        require(problems.isEmpty()) { problems.joinToString("\n") }

        val lessons = mutableListOf<LessonEntity>()
        val vocabulary = mutableListOf<VocabularyEntity>()
        pack.units.forEach { unit ->
            val level = unit.id.substringBefore('-')
            unit.lessons.forEach { lesson ->
                lessons += LessonEntity(
                    id = lesson.id,
                    cefrLevel = level,
                    unitId = unit.id,
                    title = lesson.title,
                    canDo = lesson.canDo,
                    contentJson = json.encodeToString<LearningLesson>(lesson),
                    contentVersion = pack.schemaVersion
                )
                lesson.targetVocabulary.forEach { word ->
                    vocabulary += VocabularyEntity(
                        id = word.id,
                        cefrLevel = level,
                        unitId = unit.id,
                        lessonId = lesson.id,
                        lemma = word.termEn,
                        translationTr = word.translationTr,
                        exampleEn = word.exampleEn,
                        exampleTr = word.exampleTr,
                        imageEmoji = word.emoji,
                        audioText = word.termEn
                    )
                }
            }
        }
        database.withTransaction {
            database.lessonDao().upsertAll(lessons)
            database.vocabularyDao().upsertAll(vocabulary)
        }
        lessons.size
    }

    private companion object {
        const val ASSET_FILE = "course_content_v1.json"
    }
}
