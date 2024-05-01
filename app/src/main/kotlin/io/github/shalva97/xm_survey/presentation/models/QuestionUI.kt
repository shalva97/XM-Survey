package io.github.shalva97.xm_survey.presentation.models

import io.github.shalva97.xm_survey.domain.models.Question

data class QuestionUI(
    val id: Int,
    val question: String,
    val onClicked: (answer: String) -> Unit = {},
    val status: SubmitStatus = SubmitStatus.Unanswered,
)

enum class SubmitStatus {
    InProgress, Failed, Retry, Submitted, Unanswered
}

fun Question.toUI(onClicked: (answer: String) -> Unit): QuestionUI {
    return QuestionUI(id, question, onClicked = onClicked)
}
