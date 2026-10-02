package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WorldCatalogTest {

    private val worldLangs = listOf("DE", "FR", "ES", "PT", "IT", "RU", "ZH", "JA", "KO")

    @Test
    fun everyWorldLanguageCoversAllSixLevels() {
        worldLangs.forEach { lang ->
            CourseCatalog.levels.forEach { level ->
                val units = WorldCatalog.units(lang, level)
                assertEquals("$lang $level ünite sayısı", 6, units.size)
                units.forEach { unit ->
                    assertEquals("$lang ${unit.id} ders sayısı (3 ders + Checkpoint)", 4, unit.lessons.size)
                    assertTrue("$lang ${unit.id} son ders Checkpoint olmalı", unit.lessons.last().id.endsWith("-CP"))
                }
            }
        }
    }

    @Test
    fun allWorldExerciseIdsAreUniqueAndOptionsContainTheAnswer() {
        val ids = mutableListOf<String>()
        worldLangs.forEach { lang ->
            CourseCatalog.levels.forEach { level ->
                WorldCatalog.units(lang, level).flatMap { it.lessons }.flatMap { it.exercises }.forEach { exercise ->
                    ids.add(exercise.id)
                    if (exercise.options.isNotEmpty()) {
                        assertTrue(
                            "${exercise.id}: kabul edilen yanıt seçeneklerde olmalı",
                            exercise.options.contains(exercise.acceptedAnswers.first())
                        )
                        assertEquals("${exercise.id}: seçenekler benzersiz olmalı", exercise.options.size, exercise.options.toSet().size)
                    }
                }
            }
        }
        assertEquals("Egzersiz kimlikleri çakışmamalı", ids.size, ids.toSet().size)
    }

    @Test
    fun englishDelegatesToTheFullCourseCatalog() {
        CourseCatalog.levels.forEach { level ->
            assertEquals(CourseCatalog.units(level), WorldCatalog.units("EN", level))
        }
    }

    @Test
    fun speechTagAndLanguageNameFollowTheLessonLanguage() {
        assertEquals("de-DE", WorldCatalog.speechTagForLesson("DE-A1-U1-L1", "en-US"))
        assertEquals("ja-JP", WorldCatalog.speechTagForLesson("JA-C2-U6-L3", "en-US"))
        assertEquals("en-GB", WorldCatalog.speechTagForLesson("A1-U1-L1", "en-GB"))
        assertEquals("en-US", WorldCatalog.speechTagForLesson("EN-A1-REFRESH", "en-US"))
        assertEquals("Almanca", WorldCatalog.languageNameForLesson("DE-A1-U1-L1"))
        assertEquals("İngilizce", WorldCatalog.languageNameForLesson("A1-U1-L1"))
    }

    @Test
    fun dailyRefreshProducesTenQuestionsForEveryLanguageAndLevel() {
        (worldLangs + "EN").forEach { lang ->
            CourseCatalog.levels.forEach { level ->
                val refresh = DailyRefresh.lessonFor(lang, level)
                assertEquals("$lang-$level-REFRESH", refresh.id)
                assertEquals("$lang $level günlük tekrar 10 soru olmalı", 10, refresh.exercises.size)
            }
        }
    }

    @Test
    fun firstLessonOfEachWorldUnitCarriesTargetVocabulary() {
        worldLangs.forEach { lang ->
            CourseCatalog.levels.forEach { level ->
                WorldCatalog.units(lang, level).forEach { unit ->
                    assertEquals("${unit.id} L1 hedef kelime kartları", 5, unit.lessons.first().targetVocabulary.size)
                }
            }
        }
    }
}
