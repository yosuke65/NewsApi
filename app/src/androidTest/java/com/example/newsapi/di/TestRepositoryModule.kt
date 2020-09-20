package com.example.newsapi.di

import com.example.newsapi.api.Endpoint
import com.example.newsapi.main.MainRepository
import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

@Module
class TestRepositoryModule {

    @Provides
    @Singleton
    fun provideMockedRepository(endpoint: Endpoint): MainRepository {
//        val fakeEndpoint = Mockito.mock(Endpoint::class.java)

        return MainRepository(endpoint)
    }
}