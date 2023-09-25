package com.example.portifolio.di


import com.example.portifolio.network.ApiService
import com.example.portifolio.network.NetworkingConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {
    @Singleton
    @Provides
    fun providerRetrofit(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providerService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NetworkingConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}