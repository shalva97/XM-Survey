package io.github.shalva97.xm_survey.presentation.survey.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.shalva97.xm_survey.R
import io.github.shalva97.xm_survey.presentation.models.QuestionUI
import io.github.shalva97.xm_survey.presentation.models.SubmitStatus

@Composable
fun QuestionItem(
    question: QuestionUI,
) {
    Column(Modifier.fillMaxWidth()) {
        var text by remember { mutableStateOf("") }
        when (question.status) {
            SubmitStatus.InProgress -> {
                // TODO
            }

            SubmitStatus.Failed -> {
                ErrorState { question.onClicked(text) }
            }

            SubmitStatus.Submitted -> {
                SuccessState()
            }

            SubmitStatus.Unanswered -> {}
        }
        Text(
            modifier = Modifier.padding(8.dp),
            text = question.question,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        TextField(modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
            value = text,
            onValueChange = { if (it.length <= MAX_ANSWER_LENGTH) text = it },
            label = { Text(text = stringResource(R.string.type_here_for_an_answer)) })
        Button(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp), onClick = { question.onClicked(text) },
            enabled = question.status != SubmitStatus.Submitted
        ) {
            if (question.status == SubmitStatus.Submitted) {
                Text(text = stringResource(R.string.already_submitted))
            } else {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}

@Preview
@Composable
private fun QuestionPreview() {
    Surface {
        QuestionItem(QuestionUI(1, "What is the capital of France?"))
    }
}

private const val MAX_ANSWER_LENGTH = 200
