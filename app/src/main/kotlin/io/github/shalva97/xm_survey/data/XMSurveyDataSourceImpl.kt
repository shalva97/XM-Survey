package io.github.shalva97.xm_survey.data

import io.github.shalva97.xm_survey.data.client.XMSurveyAPI
import io.github.shalva97.xm_survey.data.models.AnswerDTO
import io.github.shalva97.xm_survey.data.models.QuestionDTO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class XMSurveyDataSourceImpl @Inject constructor(
    private val xmApi: XMSurveyAPI,
) : SurveyDataSource {
    override suspend fun get(): List<QuestionDTO> {
        return xmApi.get()
    }

    override suspend fun submit(questions: AnswerDTO) {
        xmApi.submit(questions)
    }
}
