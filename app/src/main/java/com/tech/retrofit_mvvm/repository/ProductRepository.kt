package com.tech.retrofit_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech.retrofit_mvvm.models.Products
import com.tech.retrofit_mvvm.retrofit.FakerApi
import javax.inject.Inject

//5
class ProductRepository @Inject constructor(
    private val fakerApi: FakerApi
) {
    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
        get() = _products

    suspend fun getProduct() {
        val result = fakerApi.getProducts()

        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }
    }
}