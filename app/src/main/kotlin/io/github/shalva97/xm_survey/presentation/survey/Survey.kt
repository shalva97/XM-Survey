package io.github.shalva97.xm_survey.presentation.survey

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.shalva97.xm_survey.presentation.SURVEY

@Composable
fun SurveyScreen(
    viewModel: SurveyViewModel = hiltViewModel(),
) {
    Text(text = SURVEY)
}
