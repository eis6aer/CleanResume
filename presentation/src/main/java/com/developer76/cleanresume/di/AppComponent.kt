package com.developer76.cleanresume.di

import com.developer76.cleanresume.ResumeApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<ResumeApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ResumeApp>() {
    }
}