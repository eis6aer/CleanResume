package com.developer76.cleanresume

import com.developer76.cleanresume.di.DaggerAppComponent
import com.developer76.data.DataApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ResumeApp : DataApp(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }
}