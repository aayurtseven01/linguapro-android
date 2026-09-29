package com.linguapro.android.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linguapro.android.data.preferences.UserSettings
import com.linguapro.android.data.preferences.UserSettingsRepository
import com.linguapro.android.data.repository.LearningRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class LearningDashboardViewModel @Inject constructor(
    private val learningRepository: LearningRepository,
    private val settingsRepository: UserSettingsRepository
) : ViewModel() {
    private val learnerId = MutableStateFlow("guest")

    private val progress = learnerId.flatMapLatest(learningRepository::observeLessonProgress)
    private val completedCount = learnerId.flatMapLatest(learningRepository::observeCompletedLessonCount)

    val uiState: StateFlow<LearningDashboardState> = combine(
        progress,
        completedCount,
        settingsRepository.settings
    ) { recentProgress, completed, settings ->
        LearningDashboardState(
            completedLessonCount = completed,
            recentScores = recentProgress.take(5).map { it.scorePercent },
            settings = settings
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), LearningDashboardState())

    fun setLearner(learnerKey: String) {
        learnerId.value = learnerKey.ifBlank { "guest" }
    }
}

data class LearningDashboardState(
    val completedLessonCount: Int = 0,
    val recentScores: List<Int> = emptyList(),
    val settings: UserSettings = UserSettings()
)
