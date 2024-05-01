@file:OptIn(ExperimentalCoroutinesApi::class)

package io.github.shalva97.xm_survey.presentation.survey

import io.github.shalva97.xm_survey.MainDispatcherRule
import io.github.shalva97.xm_survey.domain.SurveyRepositoryFake
import io.github.shalva97.xm_survey.presentation.models.QuestionUI
import io.github.shalva97.xm_survey.presentation.models.SubmitStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class SurveyViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private val repo = SurveyRepositoryFake()

    @Test
    fun `when viewmodel is created then it emits data`() = runTest {
        val surveyViewModel = SurveyViewModel(repo)
        val questions = mutableListOf<List<QuestionUI>>()
        val collectJob = launch {
            surveyViewModel.questions.toList(questions)
        }
        advanceUntilIdle()
        assert(questions.isNotEmpty())
        collectJob.cancel()
    }

    @Test
    fun `when submitting a response and there is an error then change status to Error`() = runTest {
        val surveyViewModel = SurveyViewModel(repo)
        val questions = mutableListOf<List<QuestionUI>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            surveyViewModel.questions.toList(questions)
        }
        advanceUntilIdle()

        questions.first().first().onClicked.invoke("Paris")
        advanceUntilIdle()
        assertEquals(
            SubmitStatus.Failed,
            questions.last().first().status
        )

        collectJob.cancel()
    }
}
