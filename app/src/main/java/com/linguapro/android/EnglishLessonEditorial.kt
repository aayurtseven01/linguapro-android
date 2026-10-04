package com.linguapro.android

/** Extends existing English word lessons with contextual examples and controlled recall. */
object EnglishLessonEditorial {
    private val wordPrompt = Regex("^'(.+)' ne anlama gelir\\?$")
    private fun word(exercise: LearningExercise): TargetVocabulary? {
        if (exercise.skill != Skill.VOCABULARY || exercise.acceptedAnswers.size != 1) return null
        val term = wordPrompt.matchEntire(exercise.prompt)?.groupValues?.get(1) ?: return null
        if (!exercise.explanationTr.contains(" — ")) return null
        val english = exercise.explanationTr.substringBefore(" — ").trim()
        val translation = exercise.explanationTr.substringAfter(" — ").trim()
        return TargetVocabulary("${exercise.id}-word", term, exercise.acceptedAnswers.single(),
            "kelime / ifade", english, translation)
    }
    private fun spellings(term: String): List<String> = when (term) {
        "neighbour" -> listOf(term, "neighbor")
        "favour" -> listOf(term, "favor")
        "enrol" -> listOf(term, "enroll")
        "endeavour" -> listOf(term, "endeavor")
        "give someone the benefit of the doubt" -> listOf(term, "give somebody the benefit of the doubt")
        "burn bridges" -> listOf(term, "burn your bridges", "burn one's bridges")
        else -> listOf(term)
    }
    fun revise(unit: LearningUnit): LearningUnit = unit.copy(lessons = unit.lessons.map { lesson ->
        val words = lesson.exercises.mapNotNull(::word)
        val contextual = lesson.exercises.map { exercise ->
            val target = word(exercise)
            when {
                target != null -> exercise.copy(context = target.exampleEn,
                    instructionTr = "İfadenin bu cümledeki anlamını seç")
                exercise.skill == Skill.GRAMMAR && exercise.prompt.contains("___") &&
                    !exercise.explanationTr.contains("Tam cümle:") -> exercise.copy(
                    explanationTr = "${exercise.explanationTr}\nTam cümle: ${exercise.prompt.replace("___", exercise.acceptedAnswers.first())}")
                else -> exercise
            }
        }
        val isWordLesson = words.size >= 2 && lesson.exercises.all { it.skill == Skill.VOCABULARY }
        val retrieval = if (isWordLesson) words.map { target ->
            LearningExercise("${target.id.removeSuffix("-word")}-recall", Skill.VOCABULARY,
                "Seçeneklere bakmadan, bu derste öğrendiğin İngilizce ifadeyi hatırla",
                "Bu derste hangi İngilizce ifade bu anlamda kullanıldı?\n${target.translationTr}",
                acceptedAnswers = spellings(target.termEn),
                explanationTr = "Bu derste hedef ifade: ${target.termEn}.\n${target.exampleEn}\n${target.exampleTr}")
        } else emptyList()
        lesson.copy(
            canDo = if (isWordLesson) "Bu dersin hedef ifadelerini bağlamda tanıyıp seçeneklere bakmadan hatırlayabilirim." else lesson.canDo,
            exercises = (contextual + retrieval).distinctBy { it.id },
            targetVocabulary = (lesson.targetVocabulary + words).distinctBy { it.termEn.lowercase() }
        )
    })
}
