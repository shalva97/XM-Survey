package io.github.shalva97.xm_survey.data.models

import io.github.shalva97.xm_survey.domain.models.Answer
import kotlinx.serialization.Serializable

@Serializable
data class AnswerDTO(
    val id: Int,
    val answer: String,
)

fun Answer.toDto() = AnswerDTO(id, answer)
