package com.example.newsapi.di

import com.example.newsapi.api.Endpoint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class TestApiModule {

    @Singleton
    @Provides
    open fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideEndpoint(retrofit: Retrofit): Endpoint {
        return retrofit.create(Endpoint::class.java)
    }
}