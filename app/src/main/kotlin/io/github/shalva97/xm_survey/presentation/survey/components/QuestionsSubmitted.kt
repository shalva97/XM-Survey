package io.github.shalva97.xm_survey.presentation.survey.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.shalva97.xm_survey.R

@Composable
fun QuestionsSubmitted(
    amount: Int = 2,
) {
    Text(
        modifier = Modifier
            .background(Color.White)
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        text = stringResource(R.string.questions_submitted, amount),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun QuestionsSubmittedPreview() {
    QuestionsSubmitted()
}
