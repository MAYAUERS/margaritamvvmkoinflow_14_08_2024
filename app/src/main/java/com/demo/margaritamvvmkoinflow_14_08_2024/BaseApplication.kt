package com.demo.margaritamvvmkoinflow_14_08_2024

import android.app.Application
import com.demo.margaritamvvmkoinflow_14_08_2024.di.LoadAllModules
import org.koin.core.context.startKoin

class BaseApplication():Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            this@BaseApplication.applicationContext
            LoadAllModules.init()
        }
    }
}