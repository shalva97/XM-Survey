package io.github.shalva97.xm_survey.presentation.survey.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import io.github.shalva97.xm_survey.R

@Composable
fun SurveyTopBar(
    onBackClicked: () -> Unit = {},
    onPreviousClicked: () -> Unit = {},
    onNextClicked: () -> Unit = {},
    currentQuestion: Int = 1,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClicked) {
            Icon(Icons.Rounded.ArrowBack, contentDescription = null)
        }
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.question_20, currentQuestion),
            textAlign = TextAlign.Center
        )
        TextButton(onClick = onPreviousClicked) {
            Text(text = stringResource(R.string.previous))
        }
        TextButton(onClick = onNextClicked) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview
@Composable
fun SurveyTopBarPreview() {
    SurveyTopBar()
}
