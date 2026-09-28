package com.linguapro.android

import android.content.Context

object MistakeBookLogic {
    fun update(current: Set<String>, exerciseId: String, correct: Boolean): Set<String> =
        if (correct) current - exerciseId else current + exerciseId
}

/** Private, account-scoped local queue of activities the learner should revisit. */
class MistakeBookStore(context: Context, learnerKey: String) {
    private val prefs = context.applicationContext.getSharedPreferences(
        "mistake_book_${learnerKey.ifBlank { "guest" }}", Context.MODE_PRIVATE
    )

    fun read(): Set<String> = prefs.getString(KEY_IDS, "").orEmpty()
        .split('\n').filter { it.isNotBlank() }.toSet()

    fun record(exerciseId: String, correct: Boolean): Set<String> {
        val updated = MistakeBookLogic.update(read(), exerciseId, correct)
        prefs.edit().putString(KEY_IDS, updated.sorted().joinToString("\n")).apply()
        return updated
    }

    private companion object { const val KEY_IDS = "exercise_ids" }
}
