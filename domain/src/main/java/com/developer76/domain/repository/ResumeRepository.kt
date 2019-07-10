package com.developer76.domain.repository

import com.developer76.domain.model.Resume
import io.reactivex.Completable
import io.reactivex.Single

interface ResumeRepository {
    fun getResume(): Single<Resume>
}