package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StoryCatalogTest {

    @Test
    fun everyLanguageHasAtLeastOneStoryWithValidStructure() {
        val langs = listOf("EN", "DE", "FR", "ES", "PT", "IT", "RU", "ZH", "JA", "KO")
        langs.forEach { lang ->
            val stories = StoryCatalog.storiesFor(lang)
            assertTrue("$lang hikâyesi olmalı", stories.isNotEmpty())
            stories.forEach { story ->
                assertTrue("${story.id}: en az 6 replik", story.lines.size >= 6)
                assertTrue("${story.id}: en az 3 soru", story.questions.size >= 3)
                story.lines.forEach { line ->
                    assertTrue(line.text.isNotBlank() && line.tr.isNotBlank())
                    assertTrue("konuşmacı kadro içinde", line.speaker in 0..5)
                }
                story.questions.forEach { q ->
                    assertEquals("${story.id}: 3 benzersiz seçenek", 3, q.options.toSet().size)
                    assertTrue("${story.id}: doğru indeks geçerli", q.correct in q.options.indices)
                }
            }
        }
    }

    @Test
    fun storyIdsAreUniqueAndPrefixedWithTheirLanguage() {
        val ids = StoryCatalog.all.map { it.id }
        assertEquals(ids.size, ids.toSet().size)
        StoryCatalog.all.forEach { assertTrue(it.id.startsWith(it.lang + "-")) }
    }

    @Test
    fun byIdFindsStoriesAndRejectsUnknown() {
        assertEquals("Im Café", StoryCatalog.byId("DE-A1-S1")?.title)
        assertEquals(null, StoryCatalog.byId("XX-YOK"))
    }
}
