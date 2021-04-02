package com.example.kotlinfirst.ui

import android.app.Application
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.AppReducer

class MyApp: Application() {

    companion object{
        lateinit var instance: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val modo = Modo(AppReducer(this))
}