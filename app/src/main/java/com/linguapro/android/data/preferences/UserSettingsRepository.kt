package com.linguapro.android.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.userSettingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "user_settings")

data class UserSettings(
    val dailyGoalMinutes: Int = 10,
    val remindersEnabled: Boolean = false,
    val reminderHour: Int = 20,
    val reminderMinute: Int = 0,
    val speechAccent: String = "en-US",
    val speechRate: Float = 1.0f,
    val theme: String = "system"
)

@Singleton
class UserSettingsRepository @Inject constructor(@ApplicationContext context: Context) {
    private val dataStore = context.userSettingsDataStore

    val settings: Flow<UserSettings> = dataStore.data.map { values ->
        UserSettings(
            dailyGoalMinutes = values[Keys.dailyGoalMinutes] ?: 10,
            remindersEnabled = values[Keys.remindersEnabled] ?: false,
            reminderHour = (values[Keys.reminderHour] ?: 20).coerceIn(0, 23),
            reminderMinute = (values[Keys.reminderMinute] ?: 0).coerceIn(0, 59),
            speechAccent = values[Keys.speechAccent]?.takeIf { it in setOf("en-US", "en-GB") } ?: "en-US",
            speechRate = (values[Keys.speechRate] ?: 1.0f).coerceIn(0.5f, 1.5f),
            theme = values[Keys.theme]?.takeIf { it in setOf("system", "light", "dark") } ?: "system"
        )
    }

    suspend fun setDailyGoal(minutes: Int) {
        require(minutes in setOf(5, 10, 20))
        dataStore.edit { it[Keys.dailyGoalMinutes] = minutes }
    }

    suspend fun setRemindersEnabled(enabled: Boolean) {
        dataStore.edit { it[Keys.remindersEnabled] = enabled }
    }

    suspend fun setReminderTime(hour: Int, minute: Int) {
        require(hour in 0..23 && minute in 0..59)
        dataStore.edit {
            it[Keys.reminderHour] = hour
            it[Keys.reminderMinute] = minute
        }
    }

    suspend fun setSpeechAccent(accent: String) {
        require(accent in setOf("en-US", "en-GB"))
        dataStore.edit { it[Keys.speechAccent] = accent }
    }

    suspend fun setSpeechRate(rate: Float) {
        require(rate in 0.5f..1.5f)
        dataStore.edit { it[Keys.speechRate] = rate }
    }

    suspend fun setTheme(theme: String) {
        require(theme in setOf("system", "light", "dark"))
        dataStore.edit { it[Keys.theme] = theme }
    }

    private object Keys {
        val dailyGoalMinutes = intPreferencesKey("daily_goal_minutes")
        val remindersEnabled = booleanPreferencesKey("reminders_enabled")
        val reminderHour = intPreferencesKey("reminder_hour")
        val reminderMinute = intPreferencesKey("reminder_minute")
        val speechAccent = stringPreferencesKey("speech_accent")
        val speechRate = floatPreferencesKey("speech_rate")
        val theme = stringPreferencesKey("theme")
    }
}
