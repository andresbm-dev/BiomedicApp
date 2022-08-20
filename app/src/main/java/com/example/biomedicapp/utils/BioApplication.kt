package com.example.biomedicapp.utils

import android.annotation.SuppressLint
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BioApplication : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var preferences :PreferencesClass
    }
    override fun onCreate() {
        super.onCreate()
        preferences = PreferencesClass(applicationContext)
    }
}