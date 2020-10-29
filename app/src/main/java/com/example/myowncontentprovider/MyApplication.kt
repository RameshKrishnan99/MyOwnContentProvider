package com.example.myowncontentprovider

import android.app.Application

class MyApplication : Application() {
    companion object{
        lateinit var instance: MyApplication
    }

    init {
        instance = this
    }
}