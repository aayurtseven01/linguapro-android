package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertNull
import org.junit.Assert.assertNotNull
import org.junit.Test

class WritingCoachTest {
    @Test fun enforcesDeclaredLengthWithoutClaimingCorrectness() {
        val requirements = WritingRequirements(emptyList(), minimumWords = 4, maximumWords = 6)
        assertNotNull(WritingCoach.submissionError("a", requirements))
        assertNotNull(WritingCoach.submissionError("--- !!!", requirements))
        assertNotNull(WritingCoach.submissionError("I like coffee.", requirements))
        assertNull(WritingCoach.submissionError("I really like coffee.", requirements))
        assertNotNull(WritingCoach.submissionError("I really like drinking coffee every single day.", requirements))
        assertNull(WritingCoach.submissionError("咖啡很好喝。"))
        assertNull(WritingCoach.submissionError("I is very happy.", requirements))
    }

    @Test fun `flags a few common transparent writing patterns`() {
        val feedback = WritingCoach.review("i is happy")
        assertTrue(feedback.suggestions.any { it.contains("büyük harfle") })
        assertTrue(feedback.suggestions.any { it.contains("özne-fiil", ignoreCase = true) })
        assertTrue(feedback.suggestions.any { it.contains("noktalama") })
    }

    @Test fun `does not claim to grade a varied correct answer`() {
        val feedback = WritingCoach.review("I come from Türkiye.", "I am from Türkiye.")
        assertTrue(feedback.strengths.any { it.contains("farklı doğru") })
        assertTrue(feedback.suggestions.isEmpty())
    }

    @Test fun `recognizes modeled response and counts words`() {
        val feedback = WritingCoach.review("Hello, I'm Ece.", "Hello, I'm Ece.")
        assertEquals(3, feedback.wordCount)
        assertTrue(feedback.strengths.any { it.contains("örtüşüyor") })
    }
}

