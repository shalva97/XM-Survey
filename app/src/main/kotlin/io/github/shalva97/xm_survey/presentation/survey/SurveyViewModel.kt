package io.github.shalva97.xm_survey.presentation.survey

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.shalva97.xm_survey.domain.SurveyRepository
import io.github.shalva97.xm_survey.domain.models.Answer
import io.github.shalva97.xm_survey.presentation.models.QuestionUI
import io.github.shalva97.xm_survey.presentation.models.SubmitStatus
import io.github.shalva97.xm_survey.presentation.models.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject constructor(
    private val surveyRepo: SurveyRepository,
) : ViewModel() {

    val questions = MutableStateFlow(emptyList<QuestionUI>())
    val questionsAnswered = questions.map { questions ->
        questions.count { question -> question.status == SubmitStatus.Submitted }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    init {
        viewModelScope.launch {
            questions.emit(surveyRepo.get().map {
                it.toUI { answer -> submitAnswer(it.id, answer) }
            })
        }
    }

    private fun submitAnswer(id: Int, answer: String) = viewModelScope.launch {
        setItemTo(SubmitStatus.InProgress, id)
        try {
            surveyRepo.submit(Answer(id, answer))
        } catch (e: Exception) {
            setItemTo(SubmitStatus.Failed, id)
            return@launch
        }
        setItemTo(SubmitStatus.SubmittedAndShowingSuccess, id)
    }

    private suspend fun setItemTo(status: SubmitStatus, id: Int) {
        questions.emit(questions.value.map {
            if (it.id == id) {
                it.copy(status = status)
            } else it
        })
    }

    fun clearSuccess() {
        questions.tryEmit(questions.value.map {
            if (it.status == SubmitStatus.SubmittedAndShowingSuccess) {
                it.copy(status = SubmitStatus.Submitted)
            } else it
        })
    }
}
