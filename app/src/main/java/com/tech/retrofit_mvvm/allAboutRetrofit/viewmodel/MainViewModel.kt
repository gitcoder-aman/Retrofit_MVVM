package com.tech.retrofit_mvvm.allAboutRetrofit.viewmodel

import android.database.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.retrofit_mvvm.allAboutRetrofit.model.Post
import com.tech.retrofit_mvvm.allAboutRetrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse : LiveData<Response<Post>>
        get() = _myResponse

    private val _myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : LiveData<Response<Post>>
        get() = _myResponse2

 private val _myCustomPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts : LiveData<Response<List<Post>>>
        get() = _myCustomPosts

    private val _myCustomPosts2 : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts2 : LiveData<Response<List<Post>>>
        get() = _myCustomPosts2

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            _myResponse.value = response
        }
    }
    fun getPost2(number : Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            _myResponse2.value = response
        }
    }
    fun getCustomPosts(userId : Int,sort : String,order : String){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId,sort,order)
            _myCustomPosts.value = response
        }
    }
    fun getCustomPosts2(userId : Int,options : Map<String,String> ){
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId,options)
            _myCustomPosts2.value = response
        }
    }
    fun pushPost(post : Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            _myResponse.value = response
        }
    }
    fun pushPost2(userId : Int,id : Int,title:String ,body:String){
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            _myResponse.value = response
        }
    }

}