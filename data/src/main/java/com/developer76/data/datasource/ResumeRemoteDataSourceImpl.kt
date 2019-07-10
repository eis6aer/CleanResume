package com.developer76.data.datasource

import com.developer76.data.mappers.BaseRemoteMapper
import com.developer76.data.model.ResumeRemote
import com.developer76.data.service.GistService
import com.developer76.domain.datasource.ResumeRemoteDataSource
import com.developer76.domain.model.Resume
import io.reactivex.Single
import javax.inject.Inject

class ResumeRemoteDataSourceImpl @Inject constructor(
    private val gistService: GistService,
    private val mapper: BaseRemoteMapper<ResumeRemote, Resume>
): ResumeRemoteDataSource{
    override fun getResume(): Single<Resume> {
        return gistService.getResume()
            .map { input -> mapper.transform(input) }
    }
}