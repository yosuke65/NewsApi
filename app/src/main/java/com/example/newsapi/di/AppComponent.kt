package com.example.newsapi.di

import android.app.Application
import com.example.newsapi.base.BaseApplication
import com.example.newsapi.main.MainActivity
import com.example.newsapi.main.MainRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Think of this AppComponent as Service and BaseApplication class is client
 */

///**
// * old way
// */
//@Singleton
//@Component(modules = [ApiModule::class,RepositoryModule::class])
//interface AppComponent {
//    fun inject(mainActivity: MainActivity)
//}


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        ApiModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class
    ])
interface AppComponent :AndroidInjector<BaseApplication>{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }
}