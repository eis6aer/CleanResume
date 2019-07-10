package com.developer76.cleanresume.di

import dagger.Module

@Module(includes = [
    ActivityInjectorModule::class,
    ResumeModule::class
])
abstract class ApplicationInjectorsModule