package com.developer76.data.di

import com.developer76.data.mappers.BaseMapper
import com.developer76.data.mappers.BaseRemoteMapper
import com.developer76.data.mappers.ResumeMapper
import com.developer76.data.mappers.ResumeRemoteMapper
import com.developer76.data.model.ResumeCache
import com.developer76.data.model.ResumeRemote
import com.developer76.domain.model.Resume
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class MappersModule {
    @Binds
    @Reusable
    abstract fun provideResumeRemoteMapper(resumeRemoteMapper: ResumeRemoteMapper): BaseRemoteMapper<ResumeRemote, Resume>

    @Binds
    @Reusable
    abstract fun provideResumeCacheMapper(resumeRemoteMapper: ResumeMapper): BaseMapper<ResumeCache, Resume>
}