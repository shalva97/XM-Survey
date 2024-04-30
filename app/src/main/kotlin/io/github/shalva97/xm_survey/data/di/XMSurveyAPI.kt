package io.github.shalva97.xm_survey.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.shalva97.xm_survey.data.client.XMSurveyAPI
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class XMSurveyAPI {

    @Provides
    @Singleton
    fun getXMSurveyAPI(client: OkHttpClient): XMSurveyAPI {
        val ktorfit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL).build()
        return ktorfit.create<XMSurveyAPI>()
    }

}

private const val BASE_URL = "https://xm-assignment.web.app"
