package com.tech.retrofit_mvvm.di

import com.tech.retrofit_mvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

//3
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    //field inject
    fun inject(mainActivity: MainActivity)
}