package io.github.shalva97.xm_survey.data

import io.github.shalva97.xm_survey.data.models.toDomainModel
import io.github.shalva97.xm_survey.data.models.toDto
import io.github.shalva97.xm_survey.di.Dispatcher
import io.github.shalva97.xm_survey.di.Dispatchers
import io.github.shalva97.xm_survey.domain.SurveyRepository
import io.github.shalva97.xm_survey.domain.models.Answer
import io.github.shalva97.xm_survey.domain.models.Question
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class XMSurveyRepositoryImpl @Inject constructor(
    @Dispatcher(Dispatchers.IO) val ioDispatcher: CoroutineDispatcher,
    private val surveyDataSource: SurveyDataSource,
) : SurveyRepository {
    override suspend fun get(): List<Question> = withContext(ioDispatcher) {
        return@withContext surveyDataSource.get().map { it.toDomainModel() }
    }

    override suspend fun submit(questions: Answer) = withContext(ioDispatcher) {
        surveyDataSource.submit(questions.toDto())
    }
}
