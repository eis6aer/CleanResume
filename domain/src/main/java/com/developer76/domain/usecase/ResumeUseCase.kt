package com.developer76.domain.usecase

import com.developer76.domain.model.Resume
import com.developer76.domain.repository.ResumeRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ResumeUseCase @Inject constructor(
    private val resumeRepository: ResumeRepository
) {
    fun getResume(): Single<Resume> {
        return resumeRepository.getResume()
    }
}