package com.example.cft_vladimir.roompak

import android.app.Application


// представляет собой Context
// регистрируется в манифесте
class HistApplication : Application() {
    companion object {
        // можно ссылаться как BookApplication.instance
        lateinit var instance: HistApplication
    }

    // запускается при старте приложения
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}