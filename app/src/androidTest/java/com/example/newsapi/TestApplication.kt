package com.example.newsapi

import com.example.newsapi.di.DaggerTestAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class TestApplication:DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerTestAppComponent.builder().testApplication(this).build()
    }
}