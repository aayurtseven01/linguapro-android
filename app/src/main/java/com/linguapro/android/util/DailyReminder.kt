package com.linguapro.android.util

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.linguapro.android.R
import com.linguapro.android.data.preferences.UserSettings
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyReminderScheduler @Inject constructor(@param:ApplicationContext private val context: Context) {
    fun schedule(settings: UserSettings) {
        val manager = WorkManager.getInstance(context)
        if (!settings.remindersEnabled) {
            manager.cancelUniqueWork(UNIQUE_WORK)
            return
        }
        val now = Calendar.getInstance()
        val next = (now.clone() as Calendar).apply {
            set(Calendar.HOUR_OF_DAY, settings.reminderHour)
            set(Calendar.MINUTE, settings.reminderMinute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            if (!after(now)) add(Calendar.DAY_OF_YEAR, 1)
        }
        val delay = (next.timeInMillis - now.timeInMillis).coerceAtLeast(0L)
        val input = Data.Builder()
            .putInt(KEY_HOUR, settings.reminderHour)
            .putInt(KEY_MINUTE, settings.reminderMinute)
            .build()
        val request = PeriodicWorkRequestBuilder<DailyReviewReminderWorker>(24, TimeUnit.HOURS, 15, TimeUnit.MINUTES)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .setInputData(input)
            .build()
        manager.enqueueUniquePeriodicWork(UNIQUE_WORK, ExistingPeriodicWorkPolicy.UPDATE, request)
    }

    companion object {
        const val UNIQUE_WORK = "linguapro-daily-review-reminder"
        const val KEY_HOUR = "reminder_hour"
        const val KEY_MINUTE = "reminder_minute"
        const val CHANNEL_ID = "daily_learning_reminders"
    }
}

class DailyReviewReminderWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(
                applicationContext, Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) return Result.success()

        createChannel()
        val launchIntent = applicationContext.packageManager.getLaunchIntentForPackage(applicationContext.packageName)
            ?: return Result.success()
        val pendingIntent = PendingIntent.getActivity(
            applicationContext, 0, launchIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(applicationContext, DailyReminderScheduler.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(applicationContext.getString(R.string.reminder_title))
            .setContentText(applicationContext.getString(R.string.reminder_body))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        NotificationManagerCompat.from(applicationContext).notify(NOTIFICATION_ID, notification)
        return Result.success()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                DailyReminderScheduler.CHANNEL_ID,
                applicationContext.getString(R.string.reminder_channel),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            applicationContext.getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }

    private companion object { const val NOTIFICATION_ID = 3101 }
}
