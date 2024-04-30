package io.github.shalva97.xm_survey.data.models

import io.github.shalva97.xm_survey.domain.models.Question
import kotlinx.serialization.Serializable

@Serializable
data class QuestionDTO(
    val id: Int,
    val question: String,
)

fun QuestionDTO.toDomainModel(): Question {
    return Question(id, question)
}
