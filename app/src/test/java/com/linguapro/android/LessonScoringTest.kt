package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LessonScoringTest {
    @Test fun `retry attempts contribute to assessed accuracy`() {
        assertEquals(50, LessonScoring.accuracyPercent(correctAttempts = 1, gradedAttempts = 2))
    }

    @Test fun `writing-only work remains ungraded`() {
        assertNull(LessonScoring.accuracyPercent(correctAttempts = 0, gradedAttempts = 0))
        assertEquals(10, LessonScoring.xpForCompletion(null))
    }

    @Test fun `scored lesson rewards increase with accuracy`() {
        assertEquals(10, LessonScoring.xpForCompletion(0))
        assertEquals(18, LessonScoring.xpForCompletion(80))
        assertEquals(20, LessonScoring.xpForCompletion(100))
    }
}
