package com.linguapro.android

import android.app.Application
import android.util.Log
import com.linguapro.android.data.content.CourseSeedInitializer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@HiltAndroidApp
class LinguaProApplication : Application() {
    @Inject lateinit var courseSeedInitializer: CourseSeedInitializer

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
            courseSeedInitializer.installIfNeeded().onFailure { error ->
                Log.e("LinguaPro", "Kurs içeriği yerel veritabanına yüklenemedi.", error)
            }
        }
    }
}
