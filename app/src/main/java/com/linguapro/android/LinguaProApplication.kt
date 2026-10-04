package com.linguapro.android

import android.app.Application
import android.util.Log
import com.linguapro.android.data.content.CourseSeedInitializer
import com.linguapro.android.data.preferences.UserSettingsRepository
import com.linguapro.android.util.DailyReminderScheduler
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.collect

@HiltAndroidApp
class LinguaProApplication : Application() {
    @Inject lateinit var courseSeedInitializer: CourseSeedInitializer
    @Inject lateinit var userSettingsRepository: UserSettingsRepository
    @Inject lateinit var reminderScheduler: DailyReminderScheduler
    private val appScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        if (com.google.firebase.FirebaseApp.getApps(this).isNotEmpty()) AppCheckSetup.install()
        appScope.launch {
            courseSeedInitializer.installIfNeeded().onFailure { error ->
                Log.e("LinguaPro", "Kurs içeriği yerel veritabanına yüklenemedi.", error)
            }
        }
        appScope.launch {
            userSettingsRepository.settings
                .distinctUntilChangedBy { listOf(it.remindersEnabled, it.reminderHour, it.reminderMinute) }
                .collect(reminderScheduler::schedule)
        }
    }
}
