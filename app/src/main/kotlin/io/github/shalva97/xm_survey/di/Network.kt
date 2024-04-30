package io.github.shalva97.xm_survey.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Network {
    @Provides
    @Singleton
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
}
