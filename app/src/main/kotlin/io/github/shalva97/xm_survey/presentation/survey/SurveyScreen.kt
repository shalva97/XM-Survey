package io.github.shalva97.xm_survey.presentation.survey

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.shalva97.xm_survey.presentation.survey.components.QuestionItem
import io.github.shalva97.xm_survey.presentation.survey.components.QuestionsSubmitted
import io.github.shalva97.xm_survey.presentation.survey.components.SurveyTopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SurveyScreen(
    viewModel: SurveyViewModel = hiltViewModel(),
) {
    Column(Modifier.fillMaxSize()) {
        val questions by viewModel.questions.collectAsState()
        val answered by viewModel.questionsAnswered.collectAsState()
        val pagerState = rememberPagerState(pageCount = { questions.size })
        val coroutineScope = rememberCoroutineScope()

        SurveyTopBar(onPreviousClicked = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
            }
        }, onNextClicked = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
            }
        }, currentQuestion = pagerState.currentPage + PAGE_OFFSET)

        LaunchedEffect(true) {
            snapshotFlow { pagerState.currentPage }
                .collect {
                    viewModel.clearSuccess()
                }
        }
        QuestionsSubmitted(answered)
        HorizontalPager(state = pagerState) { page ->
            QuestionItem(questions[page])
        }
    }
}

@Preview
@Composable
fun SurveyScreenPreview() {
    Surface {
        SurveyScreen()
    }
}

private const val PAGE_OFFSET = 1
