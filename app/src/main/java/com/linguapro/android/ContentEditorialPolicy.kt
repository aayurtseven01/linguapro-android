package com.linguapro.android

/** Repairs legacy task contracts without pretending to grade unrestricted language production. */
object ContentEditorialPolicy {
    fun revise(unit: LearningUnit): LearningUnit = unit.copy(lessons = unit.lessons.map { lesson ->
        lesson.copy(exercises = lesson.exercises.map(::revise))
    })

    fun revise(exercise: LearningExercise): LearningExercise {
        if (exercise.skill == Skill.VOCABULARY && exercise.prompt.contains("___") && !exercise.prompt.startsWith("Anlam:") &&
            exercise.context.isBlank() && exercise.explanationTr.startsWith("Doğru cümle:") &&
            exercise.explanationTr.contains(" — ")) {
            val meaning = exercise.explanationTr.substringAfter(" — ").trim()
            return exercise.copy(prompt = "Anlam: $meaning\n${exercise.prompt}",
                instructionTr = "Türkçe anlamı koruyarak boşluğu tamamla")
        }
        val sample = exercise.sampleAnswer
        if (exercise.skill == Skill.WRITING && exercise.options.isEmpty() && !sample.isNullOrBlank() &&
            exercise.acceptedAnswers.none { it == sample }) {
            return exercise.copy(acceptedAnswers = listOf(sample),
                explanationTr = "${exercise.explanationTr}\nModel yanıt: $sample. Açık uçlu yanıtlarda başka doğru ifadeler de mümkündür; bu görev otomatik puanlanmaz.")
        }
        if (exercise.skill == Skill.SPEAKING && !exercise.modelAudioText.isNullOrBlank() &&
            !exercise.prompt.startsWith("Say:") && !exercise.prompt.startsWith("Söyle:") &&
            !exercise.prompt.startsWith("Modeli sesli söyle:")) {
            return exercise.copy(instructionTr = "Modeli dinle ve sesli tekrar et",
                prompt = "Modeli sesli söyle: ${exercise.modelAudioText}",
                acceptedAnswers = listOf(exercise.modelAudioText), sampleAnswer = exercise.modelAudioText)
        }
        return exercise
    }
}
