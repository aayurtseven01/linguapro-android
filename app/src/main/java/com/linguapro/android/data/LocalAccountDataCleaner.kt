package com.linguapro.android.data

import android.content.Context
import androidx.room.withTransaction
import com.linguapro.android.data.local.LinguaDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalAccountDataCleaner @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val database: LinguaDatabase
) {
    suspend fun clear(uid: String) = withContext(Dispatchers.IO) {
        require(uid.isNotBlank()) { "A guest's data must never be cleared by account deletion." }
        database.withTransaction {
            database.lessonProgressDao().deleteForLearner(uid)
            database.reviewCardDao().deleteForLearner(uid)
            database.pendingLessonEventDao().deleteForLearner(uid)
        }
        listOf("learner_progress_v1_", "mistake_book_", "skill_progress_", "daily_quests_", "gems_v1_")
            .forEach { prefix ->
                check(context.getSharedPreferences(prefix + uid, Context.MODE_PRIVATE).edit().clear().commit())
            }
        com.linguapro.android.WorldCatalog.languages.forEach { language ->
            check(context.getSharedPreferences("skill_progress_v2_${uid}_${language.code}", Context.MODE_PRIVATE).edit().clear().commit())
        }
        val prefs = context.getSharedPreferences("lingua_course", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        prefs.all.keys.filter {
            it.startsWith("level_${uid}_") || it.startsWith("completed_${uid}_") ||
                it == "username_$uid" || it == "avatar_$uid" ||
                it == "stories_done_$uid" || it == "doublexp_$uid"
        }.forEach(editor::remove)
        check(editor.commit())
    }
}

