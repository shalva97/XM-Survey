package io.github.shalva97.xm_survey.presentation.models

data class QuestionUI(
    val id: Int,
    val question: String,
    val isSubmitted: Boolean = false,
)
