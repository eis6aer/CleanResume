package com.developer76.data.di

import com.developer76.data.datasource.ResumeLocalDataSourceImpl
import com.developer76.data.datasource.ResumeRemoteDataSourceImpl
import com.developer76.domain.datasource.ResumeLocalDataSource
import com.developer76.domain.datasource.ResumeRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [MappersModule::class, ServiceModule::class])
abstract class DataSourceModule {
    @Binds
    @Reusable
    abstract fun providesResumeLocalDataSource(resumeLocalDataSource: ResumeLocalDataSourceImpl): ResumeLocalDataSource

    @Binds
    @Reusable
    abstract fun providesRemoteDataSource(resumeLocalDataSource: ResumeRemoteDataSourceImpl): ResumeRemoteDataSource

}