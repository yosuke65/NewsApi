package com.example.newsapi.base

import android.app.Application
import com.example.newsapi.di.AppComponent
import com.example.newsapi.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerApplication


/**
 * Client of AppComponent
 */

///**
// * old way
// */
//class BaseApplication : Application() {
//
//    private lateinit var appComponent: AppComponent
//    override fun onCreate() {
//        super.onCreate()
//
//        //To generate DaggerAppComponent use kapt instead of annotationProcessor
//        appComponent = DaggerAppComponent.builder().build()
//    }
//
//    fun getAppComponent() = appComponent
//}

/**
 * new way
 */

    class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}