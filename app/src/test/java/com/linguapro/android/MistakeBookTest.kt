package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Test

class MistakeBookTest {
    @Test fun `wrong answer adds an exercise once`() {
        assertEquals(setOf("ex-1"), MistakeBookLogic.update(setOf("ex-1"), "ex-1", false))
    }

    @Test fun `correct retry removes an exercise from review`() {
        assertEquals(setOf("ex-2"), MistakeBookLogic.update(setOf("ex-1", "ex-2"), "ex-1", true))
    }
}
