package com.example.newsapi.di

import com.example.newsapi.api.Endpoint
import com.example.newsapi.main.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(endpoint: Endpoint):MainRepository{
        return MainRepository(endpoint)
    }
}