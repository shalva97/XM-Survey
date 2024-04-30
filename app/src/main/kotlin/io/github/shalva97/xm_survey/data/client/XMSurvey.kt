package io.github.shalva97.xm_survey.data.client

import io.github.shalva97.xm_survey.data.models.AnswerDTO
import io.github.shalva97.xm_survey.data.models.QuestionDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface XMSurveyAPI {
    @GET("questions")
    suspend fun get(): List<QuestionDTO>

    @POST("question/submit")
    suspend fun submit(
        @Body answer: AnswerDTO,
    )
}
