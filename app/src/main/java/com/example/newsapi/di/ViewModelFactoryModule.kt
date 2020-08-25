package com.example.newsapi.di

import androidx.lifecycle.ViewModelProvider
import com.example.newsapi.main.MainViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    //Same as using @Provides
    //@Binds essentially creates instance
    //It's more efficient
    @Binds
    abstract fun bindMainViewModelFactory(mainViewModelFactory: MainViewModelFactory):ViewModelProvider.Factory
}