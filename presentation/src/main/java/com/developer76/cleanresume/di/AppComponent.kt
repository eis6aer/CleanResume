package com.developer76.cleanresume.di

import com.developer76.cleanresume.ResumeApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<ResumeApp> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<ResumeApp>
}