package com.example.newsapi.di

import com.example.newsapi.api.Endpoint
import com.example.newsapi.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideRetrofitClient():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideEndpoint(retrofit: Retrofit): Endpoint {
        return retrofit.create(Endpoint::class.java)
    }

}