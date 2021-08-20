package com.viettech.baseproject

import android.app.Application
import com.viettech.baseproject.module.viewModelModule
import com.viettech.baseproject.repository.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(listOf(retrofitModule, viewModelModule))
        }
    }
}