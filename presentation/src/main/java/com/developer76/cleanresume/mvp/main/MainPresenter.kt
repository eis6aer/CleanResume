package com.developer76.cleanresume.mvp.main

import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val model: MainContract.Model,
    private val view: MainContract.View
) : MainContract.Presenter {
    override fun init() {
        view.init()
    }

    override fun navigateToPage(pagePosition: Int) {
        view.navigateToPage(pagePosition)
    }

}