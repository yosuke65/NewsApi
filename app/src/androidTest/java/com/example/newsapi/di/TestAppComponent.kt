package com.example.newsapi.di

import com.example.newsapi.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        TestApiModule::class,
        RepositoryModule::class,
        ViewModelFactoryModule::class,
        ActivityBuildersModule::class
    ]
)
interface TestAppComponent : AndroidInjector<TestApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun testApplication(application: TestApplication): Builder

        fun build(): TestAppComponent
    }

}