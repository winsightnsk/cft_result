package com.example.cft_vladimir

import android.app.Application

class HistApp : Application() {
    companion object {
        lateinit var instance: HistApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}