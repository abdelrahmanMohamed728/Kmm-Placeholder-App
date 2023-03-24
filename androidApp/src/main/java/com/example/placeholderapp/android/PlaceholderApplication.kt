package com.example.placeholderapp.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PlaceholderApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}