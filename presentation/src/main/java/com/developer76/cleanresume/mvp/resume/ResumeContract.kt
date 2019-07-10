package com.developer76.cleanresume.mvp.resume

import com.developer76.domain.model.Resume
import io.reactivex.Single

interface ResumeContract {
    interface Presenter {
        fun init()
        fun requestResume()
    }

    interface Model {
        fun getResume(): Single<Resume>
    }

    interface View {
        fun initView()
        fun updateResume(resume: Resume)
    }
}