package io.github.shalva97.xm_survey.presentation.survey

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.shalva97.xm_survey.presentation.survey.components.Question
import io.github.shalva97.xm_survey.presentation.survey.components.QuestionsSubmitted
import io.github.shalva97.xm_survey.presentation.survey.components.SurveyTopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SurveyScreen(
    viewModel: SurveyViewModel = hiltViewModel(),
) {
    Column(Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(pageCount = { 10 })
        val coroutineScope = rememberCoroutineScope()
        SurveyTopBar(onPreviousClicked = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
            }
        }, onNextClicked = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
            }
        })
        QuestionsSubmitted()
        HorizontalPager(state = pagerState) { page ->
            Question("asdasd question $page")
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
