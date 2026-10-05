package com.linguapro.android.data.sync

import android.content.Context
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.google.firebase.auth.FirebaseAuth
import com.linguapro.android.data.FirebaseAccountRepository
import com.linguapro.android.data.local.LinguaDatabase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.CompletableDeferred

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LessonSyncEntryPoint {
    fun database(): LinguaDatabase
}

/** Network failure leaves every unacknowledged attempt intact for a later retry. */
class LessonSyncWorker(context: Context, parameters: WorkerParameters) : CoroutineWorker(context, parameters) {
    override suspend fun doWork(): Result {
        val accounts = FirebaseAccountRepository(applicationContext)
        val uid = accounts.currentUser()?.uid ?: return Result.success()
        val database = EntryPointAccessors.fromApplication(applicationContext, LessonSyncEntryPoint::class.java).database()
        val outbox = database.pendingLessonEventDao()
        while (!isStopped) {
            if (FirebaseAuth.getInstance().currentUser?.uid != uid) return Result.success()
            val batch = outbox.nextBatch(uid)
            if (batch.isEmpty()) return Result.success()
            for (event in batch) {
                if (FirebaseAuth.getInstance().currentUser?.uid != uid) return Result.success()
                val result = CompletableDeferred<String?>()
                accounts.recordLesson(uid, event.lessonId, event.scorePercent, event.countsTowardCourse, event.id,
                    clientCompletedAtEpochMillis = event.createdAtEpochMillis) {
                    result.complete(it)
                }
                if (result.await() != null) return Result.retry()
                outbox.acknowledge(event.id)
            }
        }
        return Result.retry()
    }

    companion object {
        fun schedule(context: Context) {
            val work = OneTimeWorkRequestBuilder<LessonSyncWorker>()
                .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 30, TimeUnit.SECONDS)
                .build()
            // APPEND_OR_REPLACE prevents a last-moment enqueue from being lost behind a finishing worker.
            WorkManager.getInstance(context).enqueueUniqueWork("lesson-cloud-sync", ExistingWorkPolicy.APPEND_OR_REPLACE, work)
        }
    }
}

