package com.developer76.data.di

import com.developer76.data.repository.ResumeRepositoryImpl
import com.developer76.domain.repository.ResumeRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [DataSourceModule::class])
abstract class RepositoryModule {
    @Binds
    @Reusable
    abstract fun provideResumeRepository(resumeRepository: ResumeRepositoryImpl): ResumeRepository
}