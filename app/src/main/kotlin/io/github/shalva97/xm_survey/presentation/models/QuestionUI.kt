package io.github.shalva97.xm_survey.presentation.models

import io.github.shalva97.xm_survey.domain.models.Question

data class QuestionUI(
    val id: Int,
    val question: String,
    val isSubmitted: Boolean = false,
)

fun Question.toUI(): QuestionUI {
    return QuestionUI(id, question)
}
