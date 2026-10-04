package com.linguapro.android.data.content

import android.content.Context
import androidx.room.withTransaction
import com.linguapro.android.ContentEditorialPolicy
import com.linguapro.android.EditorialCurriculum
import com.linguapro.android.CourseCatalog
import com.linguapro.android.WorldCatalog
import com.linguapro.android.CourseContentPack
import com.linguapro.android.LearningLesson
import com.linguapro.android.data.local.ContentPackEntity
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

    suspend fun installIfNeeded(): Result<Int> = runCatching {
        installCatalogVocabulary()
        val rawPack = context.assets.open(ASSET_FILE).bufferedReader(Charsets.UTF_8).use { reader ->
            json.decodeFromString<CourseContentPack>(reader.readText())
        }
        val pack = rawPack.copy(contentVersion = rawPack.contentVersion + "-editorial-v2",
            units = rawPack.units.map { ContentEditorialPolicy.revise(EditorialCurriculum.revise(it)) })
        if (database.contentPackDao().installedVersion(PACK_ID) == pack.contentVersion) return@runCatching 0
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
                    unitTitle = unit.title,
                    unitSummary = unit.summary,
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
            database.contentPackDao().recordInstalledPack(
                ContentPackEntity(
                    id = PACK_ID,
                    schemaVersion = pack.schemaVersion,
                    contentVersion = pack.contentVersion,
                    installedAtEpochMillis = System.currentTimeMillis()
                )
            )
        }
        lessons.size
    }

    private suspend fun installCatalogVocabulary() {
        val packId = "catalog-vocabulary"
        val version = "2026-10-04-scenarios-v4"
        if (database.contentPackDao().installedVersion(packId) == version) return
        val vocabulary = (CourseCatalog.allLessons() + WorldCatalog.allWorldLessons()).flatMap { lesson ->
            val languagePrefix = lesson.id.substringBefore('-')
            val level = if (languagePrefix in CourseCatalog.levels) languagePrefix else lesson.id.split('-').getOrNull(1) ?: "A1"
            lesson.targetVocabulary.map { word ->
                VocabularyEntity(word.id, level, lesson.id.substringBeforeLast('-'), lesson.id,
                    word.termEn, word.translationTr, word.exampleEn, word.exampleTr, word.emoji, word.termEn)
            }
        }.distinctBy { it.id }
        database.withTransaction {
            database.vocabularyDao().upsertAll(vocabulary)
            database.contentPackDao().recordInstalledPack(ContentPackEntity(packId, 1, version, System.currentTimeMillis()))
        }
    }

    private companion object {
        const val ASSET_FILE = "course_content_v1.json"
        const val PACK_ID = "core-course"
    }
}
