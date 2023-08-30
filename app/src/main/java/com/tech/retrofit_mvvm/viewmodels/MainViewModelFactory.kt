package com.tech.retrofit_mvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tech.retrofit_mvvm.repository.ProductRepository
import javax.inject.Inject

//7
class MainViewModelFactory @Inject constructor(
    private val productRepository: ProductRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productRepository) as T
    }
}