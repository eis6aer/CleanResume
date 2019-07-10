package com.developer76.data

import android.app.Application
import io.realm.Realm

open class DataApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}