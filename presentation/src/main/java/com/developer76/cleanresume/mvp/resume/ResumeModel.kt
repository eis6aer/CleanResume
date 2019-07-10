package com.developer76.cleanresume.mvp.resume

import com.developer76.domain.model.Resume
import com.developer76.domain.usecase.ResumeUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ResumeModel @Inject constructor(
    private val resumeUseCase: ResumeUseCase
) : ResumeContract.Model {
    override fun getResume(): Single<Resume> {
        return resumeUseCase.getResume()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}