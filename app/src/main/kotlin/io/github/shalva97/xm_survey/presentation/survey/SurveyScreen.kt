package io.github.shalva97.xm_survey.presentation.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.shalva97.xm_survey.presentation.survey.components.QuestionsSubmitted
import io.github.shalva97.xm_survey.presentation.survey.components.SurveyTopBar

@Composable
fun SurveyScreen(
    viewModel: SurveyViewModel = hiltViewModel(),
) {
    Column(Modifier.fillMaxSize()) {
        SurveyTopBar()
        QuestionsSubmitted()
    }
}

@Preview
@Composable
fun SurveyScreenPreview() {
    SurveyScreen()
}
