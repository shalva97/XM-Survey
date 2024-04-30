package io.github.shalva97.xm_survey.data

import io.github.shalva97.xm_survey.data.models.AnswerDTO
import io.github.shalva97.xm_survey.data.models.QuestionDTO

interface SurveyDataSource {
    suspend fun get(): List<QuestionDTO>
    suspend fun submit(questions: AnswerDTO)
}
