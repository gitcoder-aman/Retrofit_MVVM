package com.tech.retrofit_mvvm.retrofit

import com.tech.retrofit_mvvm.models.Products
import retrofit2.Response
import retrofit2.http.GET

//1
interface FakerApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}