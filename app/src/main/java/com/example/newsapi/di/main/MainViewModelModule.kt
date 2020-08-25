package com.example.newsapi.di.main

import androidx.lifecycle.ViewModel
import com.example.newsapi.di.ViewModelKey
import com.example.newsapi.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(mainViewModel: MainViewModel):ViewModel
}