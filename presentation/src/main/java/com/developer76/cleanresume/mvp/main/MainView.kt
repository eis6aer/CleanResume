package com.developer76.cleanresume.mvp.main

import com.developer76.cleanresume.MainActivity
import com.developer76.cleanresume.adapters.HomeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainView @Inject constructor(
    private val mainActivity: MainActivity
): MainContract.View {

    override fun init() {
        mainActivity.viewpager_home.adapter = HomeAdapter(mainActivity)
    }

    override fun navigateToPage(pagePosition: Int) {
        mainActivity.viewpager_home.setCurrentItem(pagePosition, true)
    }
}