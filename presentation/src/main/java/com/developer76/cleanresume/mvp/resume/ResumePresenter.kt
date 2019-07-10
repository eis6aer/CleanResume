package com.developer76.cleanresume.mvp.resume

import android.util.Log
import javax.inject.Inject

class ResumePresenter @Inject constructor(
    private val model: ResumeContract.Model,
    private val view: ResumeContract.View
) : ResumeContract.Presenter {
    override fun requestResume() {
        var disposable = model.getResume()
            .subscribe({
                view.updateResume(it)
            }, {
                Log.e("ResumePresenter", it.localizedMessage)
            })
    }

    override fun init() {
        view.initView()
    }

}