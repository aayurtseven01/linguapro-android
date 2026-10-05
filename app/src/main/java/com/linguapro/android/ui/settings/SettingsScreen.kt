package com.linguapro.android.ui.settings

import android.Manifest
import android.app.TimePickerDialog
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.linguapro.android.R
import com.linguapro.android.data.preferences.UserSettings
import androidx.compose.runtime.collectAsState

@Composable
fun SettingsRoute(onBack: () -> Unit, viewModel: SettingsViewModel = hiltViewModel()) {
    val settings by viewModel.settings.collectAsState()
    val context = LocalContext.current
    var permissionMessage by remember { mutableStateOf("") }
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) {
            permissionMessage = ""
            viewModel.setReminderEnabled(true)
        } else {
            permissionMessage = context.getString(R.string.settings_notification_denied)
        }
    }
    SettingsScreen(
        settings = settings,
        permissionMessage = permissionMessage,
        onBack = onBack,
        onGoalSelected = { viewModel.setDailyGoal(it) },
        onReminderToggle = { enabled ->
            if (!enabled) viewModel.setReminderEnabled(false)
            else if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            } else viewModel.setReminderEnabled(true)
        },
        onReminderTime = { hour, minute -> viewModel.setReminderTime(hour, minute) },
        onAccentSelected = { viewModel.setAccent(it) },
        onSpeechRate = { viewModel.setSpeechRate(it) }
    )
}

@Composable
private fun SettingsScreen(
    settings: UserSettings,
    permissionMessage: String,
    onBack: () -> Unit,
    onGoalSelected: (Int) -> Unit,
    onReminderToggle: (Boolean) -> Unit,
    onReminderTime: (Int, Int) -> Unit,
    onAccentSelected: (String) -> Unit,
    onSpeechRate: (Float) -> Unit
) {
    val context = LocalContext.current
    Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.fillMaxSize()) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(top = 14.dp, bottom = 18.dp)) {
            IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.settings_back)) }
            Text(stringResource(R.string.settings_title), style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(start = 8.dp))
        }
        Text(stringResource(R.string.settings_daily_goal), style = MaterialTheme.typography.titleMedium)
        Text(stringResource(R.string.settings_daily_goal_hint), style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 4.dp, bottom = 10.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(5, 10, 20).forEach { minutes ->
                FilterChip(
                    selected = settings.dailyGoalMinutes == minutes,
                    onClick = { onGoalSelected(minutes) },
                    label = { Text(stringResource(R.string.settings_minutes, minutes)) }
                )
            }
        }
        Spacer(Modifier.height(24.dp))
        Text(stringResource(R.string.settings_reminders), style = MaterialTheme.typography.titleMedium)
        Row(Modifier.fillMaxWidth().padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(stringResource(R.string.settings_daily_reminder), style = MaterialTheme.typography.bodyLarge)
                Text(stringResource(R.string.settings_reminder_hint), style = MaterialTheme.typography.bodySmall)
            }
            Switch(
                checked = settings.remindersEnabled,
                onCheckedChange = onReminderToggle,
                modifier = Modifier.semantics { contentDescription = context.getString(R.string.settings_reminder_toggle_description) }
            )
        }
        if (permissionMessage.isNotBlank()) Text(permissionMessage, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 4.dp))
        OutlinedButton(
            onClick = {
                TimePickerDialog(context, { _, hour, minute -> onReminderTime(hour, minute) }, settings.reminderHour, settings.reminderMinute, true).show()
            },
            enabled = settings.remindersEnabled,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Icon(Icons.Default.AccessTime, contentDescription = null, modifier = Modifier.padding(end = 8.dp))
            Text(stringResource(R.string.settings_reminder_time, settings.reminderHour, settings.reminderMinute))
        }
        Spacer(Modifier.height(24.dp))
        Text(stringResource(R.string.settings_accent), style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 6.dp)) {
            FilterChip(selected = settings.speechAccent == "en-US", onClick = { onAccentSelected("en-US") }, label = { Text(stringResource(R.string.settings_accent_us)) })
            FilterChip(selected = settings.speechAccent == "en-GB", onClick = { onAccentSelected("en-GB") }, label = { Text(stringResource(R.string.settings_accent_uk)) })
        }
        Spacer(Modifier.height(18.dp))
        Text(stringResource(R.string.settings_speech_rate, settings.speechRate), style = MaterialTheme.typography.titleMedium)
        Slider(value = settings.speechRate, onValueChange = onSpeechRate, valueRange = 0.5f..1.5f, steps = 3)
        Text(stringResource(R.string.settings_speech_rate_hint), style = MaterialTheme.typography.bodySmall)
        Spacer(Modifier.height(20.dp))
    }
}
}

@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
private fun SettingsScreenPreview() {
    MaterialTheme {
        Surface {
            SettingsScreen(UserSettings(), "", {}, {}, {}, { _, _ -> }, {}, {})
        }
    }
}
