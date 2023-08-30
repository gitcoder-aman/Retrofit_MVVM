package com.tech.retrofit_mvvm

import android.app.Application
import com.tech.retrofit_mvvm.di.ApplicationComponent
import com.tech.retrofit_mvvm.di.DaggerApplicationComponent

//4
class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}