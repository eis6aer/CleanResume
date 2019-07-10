package com.developer76.domain.datasource

import com.developer76.domain.model.Resume
import io.reactivex.Single

interface ResumeRemoteDataSource {
    fun getResume(): Single<Resume>
}