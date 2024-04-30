package io.github.shalva97.xm_survey.domain

import io.github.shalva97.xm_survey.domain.models.Answer
import io.github.shalva97.xm_survey.domain.models.Question

interface SurveyRepository {
    suspend fun get(): List<Question>
    suspend fun submit(questions: Answer)
}
