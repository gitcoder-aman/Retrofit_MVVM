package com.tech.retrofit_mvvm.di

import com.tech.retrofit_mvvm.retrofit.FakerApi
import com.tech.retrofit_mvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//2
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofit: Retrofit) : FakerApi{
        return retrofit.create(FakerApi::class.java)
    }
}