package com.developer76.cleanresume.di

import com.developer76.cleanresume.ResumeApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class, // My module
        AndroidInjectionModule::class]) // Para poder hacer la inyeccion de Activity y de Fragments
interface AppComponent : AndroidInjector<ResumeApp> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<ResumeApp>
}