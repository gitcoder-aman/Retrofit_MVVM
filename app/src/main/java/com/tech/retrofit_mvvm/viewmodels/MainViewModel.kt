package com.tech.retrofit_mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.retrofit_mvvm.models.Products
import com.tech.retrofit_mvvm.repository.ProductRepository
import kotlinx.coroutines.launch

//6
class MainViewModel(val repository: ProductRepository) : ViewModel() {

   val productsLiveData : LiveData<List<Products>>
       get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }
}