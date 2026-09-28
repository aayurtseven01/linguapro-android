package com.linguapro.android

/** Open-ended writing is completed and reviewed, but deliberately has no fabricated automatic score. */
object LessonScoring {
    fun accuracyPercent(correctAttempts: Int, gradedAttempts: Int): Int? {
        if (gradedAttempts <= 0) return null
        return (correctAttempts.coerceIn(0, gradedAttempts) * 100 / gradedAttempts).coerceIn(0, 100)
    }

    fun xpForCompletion(score: Int?): Int = if (score == null) 10 else 10 + score.coerceIn(0, 100) / 10
}
