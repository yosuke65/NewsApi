package com.example.newsapi.di

import com.example.newsapi.di.main.MainModule
import com.example.newsapi.di.main.MainViewModelModule
import com.example.newsapi.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    /**
     * ActivityBuilderModule is the module connected with AppComponent and its responsibility is creating an injector for Activities in the application
     * @ContributesAndroidInjector Automatically create sub component behind the scene
     */
    @ContributesAndroidInjector(
            modules = [
            MainViewModelModule::class,
            MainModule::class
        ]
    )

    abstract fun contributeMainActivity(): MainActivity
}