package com.linguapro.android.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linguapro.android.data.preferences.UserSettings
import com.linguapro.android.data.preferences.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: UserSettingsRepository
) : ViewModel() {
    val settings: StateFlow<UserSettings> = repository.settings.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        UserSettings()
    )

    fun setDailyGoal(minutes: Int) = viewModelScope.launch { repository.setDailyGoal(minutes) }
    fun setReminderEnabled(enabled: Boolean) = viewModelScope.launch { repository.setRemindersEnabled(enabled) }
    fun setReminderTime(hour: Int, minute: Int) = viewModelScope.launch { repository.setReminderTime(hour, minute) }
    fun setAccent(accent: String) = viewModelScope.launch { repository.setSpeechAccent(accent) }
    fun setSpeechRate(rate: Float) = viewModelScope.launch { repository.setSpeechRate(rate) }
}
