package com.developer76.cleanresume.mvp.main

interface MainContract {
    interface Presenter {
        fun init()
        fun navigateToPage(pagePosition: Int)
    }

    interface Model {

    }

    interface View {
        fun init()
        fun navigateToPage(pagePosition: Int)
    }
}