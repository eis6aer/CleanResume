package com.developer76.data.repository

import com.developer76.domain.datasource.ResumeLocalDataSource
import com.developer76.domain.datasource.ResumeRemoteDataSource
import com.developer76.domain.model.Resume
import com.developer76.domain.repository.ResumeRepository
import io.reactivex.Single
import javax.inject.Inject

class ResumeRepositoryImpl @Inject constructor(
    private val resumeLocalDataSource: ResumeLocalDataSource,
    private val resumeRemoteDataSource: ResumeRemoteDataSource
): ResumeRepository {
    override fun getResume(): Single<Resume> {
        return resumeRemoteDataSource.getResume()
            .flatMap { resume -> resumeLocalDataSource.saveResume(resume)
                .andThen(Single.just(resume)) }
    }
}