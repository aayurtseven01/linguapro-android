package com.linguapro.android.ui.review

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.linguapro.android.R
import com.linguapro.android.data.local.ReviewCardEntity
import com.linguapro.android.domain.usecase.ReviewGrade

@Composable
fun ReviewScreen(
    dueCards: List<ReviewCardEntity>,
    onGrade: (ReviewCardEntity, ReviewGrade) -> Unit,
    onBack: () -> Unit
) {
    val card = dueCards.firstOrNull()
    var answer by rememberSaveable(card?.id) { mutableStateOf("") }
    var revealed by rememberSaveable(card?.id) { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(top = 14.dp, bottom = 18.dp)) {
            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, contentDescription = stringResource(R.string.review_back), tint = Color(0xFFFFFFFF)) }
            Text(stringResource(R.string.review_title), color = Color(0xFFFFFFFF), style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(start = 8.dp))
        }
        if (card == null) {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(stringResource(R.string.review_empty_title), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text(stringResource(R.string.review_empty_body), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 8.dp))
                    Button(onClick = onBack, modifier = Modifier.fillMaxWidth().padding(top = 18.dp)) { Text(stringResource(R.string.review_return)) }
                }
            }
        } else {
            Text(stringResource(R.string.review_due_count, dueCards.size), color = Color(0xFFFFFFFF), style = MaterialTheme.typography.labelLarge)
            Text(stringResource(R.string.review_instruction), color = Color(0xFFDFF3FF), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 8.dp, bottom = 14.dp))
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(22.dp)) {
                    Text(if (card.direction == "TR_TO_EN") stringResource(R.string.review_tr_to_en) else stringResource(R.string.review_en_to_tr), style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Text(card.frontText, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp, bottom = 18.dp))
                    OutlinedTextField(value = answer, onValueChange = { answer = it }, label = { Text(stringResource(R.string.review_answer_hint)) }, singleLine = true, modifier = Modifier.fillMaxWidth())
                    if (!revealed) {
                        Button(onClick = { revealed = true }, modifier = Modifier.fillMaxWidth().padding(top = 14.dp)) { Text(stringResource(R.string.review_reveal)) }
                    } else {
                        Text(stringResource(R.string.review_answer_label), style = MaterialTheme.typography.labelLarge, modifier = Modifier.padding(top = 16.dp))
                        Text(card.backText, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 5.dp))
                        Text(stringResource(R.string.review_grade_prompt), style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 14.dp, bottom = 8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                            GradeButton(stringResource(R.string.review_again), Modifier.weight(1f)) { onGrade(card, ReviewGrade.AGAIN) }
                            GradeButton(stringResource(R.string.review_hard), Modifier.weight(1f)) { onGrade(card, ReviewGrade.HARD) }
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                            GradeButton(stringResource(R.string.review_good), Modifier.weight(1f)) { onGrade(card, ReviewGrade.GOOD) }
                            GradeButton(stringResource(R.string.review_easy), Modifier.weight(1f)) { onGrade(card, ReviewGrade.EASY) }
                        }
                    }
                }
            }
            Text(stringResource(R.string.review_feedback_note), color = Color(0xFFDFF3FF), style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 14.dp))
        }
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun GradeButton(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    OutlinedButton(onClick = onClick, modifier = modifier) { Text(label) }
}

@Preview(showBackground = true)
@Composable
private fun ReviewEmptyPreview() {
    MaterialTheme { Surface { ReviewScreen(emptyList(), { _, _ -> }, {}) } }
}
