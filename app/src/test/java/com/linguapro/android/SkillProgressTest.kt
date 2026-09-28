package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test

class SkillProgressTest {
    @Test fun `records correct and incorrect attempts without exceeding bounds`() {
        val first = SkillProgressLogic.record(SkillTally(), true)
        val second = SkillProgressLogic.record(first, false)
        assertEquals(SkillTally(2, 1), second)
        assertEquals(50, second.accuracyPercent)
    }

    @Test fun `does not recommend a weak skill before enough evidence`() {
        assertNull(SkillProgressLogic.weakest(mapOf(Skill.GRAMMAR to SkillTally(2, 0))))
    }

    @Test fun `recommends the lowest-scoring skill after three attempts`() {
        val stats = mapOf(
            Skill.GRAMMAR to SkillTally(4, 3),
            Skill.READING to SkillTally(3, 1)
        )
        assertSame(Skill.READING, SkillProgressLogic.weakest(stats))
    }
}
