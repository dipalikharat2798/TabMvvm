package com.geico.tabmvvmapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TabMvvmApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}