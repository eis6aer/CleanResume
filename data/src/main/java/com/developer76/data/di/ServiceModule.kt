package com.developer76.data.di

import com.developer76.data.service.GistService
import com.developer76.data.service.RetroFitFactory
import dagger.Module
import dagger.Provides

@Module(includes = [MappersModule::class])
class ServiceModule {
    @Provides
    fun providesGistApi(): GistService {
        return RetroFitFactory.getService(GistService::class.java)
    }
}