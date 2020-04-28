package com.developer76.cleanresume.di

import android.content.Context
import com.developer76.cleanresume.ResumeApp
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityInjectorModule::class])
abstract class AppModule {

    @Binds
    internal abstract fun provideContext(application: ResumeApp): Context
}