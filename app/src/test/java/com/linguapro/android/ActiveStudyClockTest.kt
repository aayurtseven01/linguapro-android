package com.linguapro.android

import org.junit.Assert.assertEquals
import org.junit.Test

class ActiveStudyClockTest {
    @Test fun backgroundAndRepeatedLifecycleEventsDoNotInflateStudyTime() {
        val clock = ActiveStudyClock()
        clock.resume(1000); clock.resume(2000); clock.pause(6000); clock.pause(9000)
        assertEquals(5000L, clock.elapsedMillis(100_000))
        clock.resume(100_000); clock.pause(110_000)
        assertEquals(15_000L, clock.elapsedMillis(120_000))
    }
    @Test fun recreatedClockKeepsRecordedTimeWithoutCountingTheGap() {
        val clock = ActiveStudyClock(15_000)
        assertEquals(15_000L, clock.elapsedMillis(1_000_000))
        clock.resume(1_000_000)
        assertEquals(20_000L, clock.elapsedMillis(1_005_000))
    }
    @Test fun goalUsesTheChosenMinutesAndIsBounded() {
        assertEquals(50, LearningProgress(todayStudySeconds = 300).studyGoalPercent(10))
        assertEquals(100, LearningProgress(todayStudySeconds = 600).studyGoalPercent(5))
        assertEquals(0, LearningProgress().studyGoalPercent(20))
    }
}
