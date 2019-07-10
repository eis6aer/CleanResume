package com.developer76.domain.datasource

import com.developer76.domain.model.Resume
import io.reactivex.Completable

interface ResumeLocalDataSource {
    fun saveResume(resume: Resume): Completable
}