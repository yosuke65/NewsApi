package com.example.newsapi.base

import android.app.Activity
import android.app.Application
import com.example.newsapi.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TestApplication: Application(),HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any?>

    override fun androidInjector() = activityInjector


}