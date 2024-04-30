package io.github.shalva97.xm_survey.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.shalva97.xm_survey.data.SurveyDataSource
import io.github.shalva97.xm_survey.data.XMSurveyDataSourceImpl
import io.github.shalva97.xm_survey.data.XMSurveyRepositoryImpl
import io.github.shalva97.xm_survey.domain.SurveyRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class XMSurvey {
    @Binds
    abstract fun bindXMSurvey(surveyDataSource: XMSurveyDataSourceImpl): SurveyDataSource

    @Binds
    abstract fun bindXMRepo(surveyRepository: XMSurveyRepositoryImpl): SurveyRepository
}
