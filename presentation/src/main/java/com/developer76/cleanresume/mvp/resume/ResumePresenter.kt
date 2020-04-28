package com.developer76.cleanresume.mvp.resume

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
                // Do nothing
            })
    }

    override fun init() {
        view.initView()
    }

}