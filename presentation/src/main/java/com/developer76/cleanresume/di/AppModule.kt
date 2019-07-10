package com.developer76.cleanresume.di

import android.content.Context
import com.developer76.cleanresume.ResumeApp
import com.developer76.data.di.RepositoryModule
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule

@Module(includes = [
    ApplicationInjectorsModule::class
])
abstract class AppModule {

    @Binds
    internal abstract fun provideContext(application: ResumeApp): Context
}