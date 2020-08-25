package com.example.newsapi.di.main

import com.example.newsapi.main.AdapterNewsList
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideAdapterNewsList():AdapterNewsList = AdapterNewsList()

}