package com.tech.retrofit_mvvm.allAboutRetrofit.repository

import android.database.Observable
import com.tech.retrofit_mvvm.allAboutRetrofit.api.RetrofitInstance
import com.tech.retrofit_mvvm.allAboutRetrofit.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost() : Response<Post> {
        return RetrofitInstance.api.getPost()
    }
    suspend fun getPost2(number : Int) : Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }
    suspend fun getCustomPosts(userId : Int,sort:String,order : String) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
    suspend fun getCustomPosts2(userId:Int,options:Map<String,String>):Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts2(userId,options)
    }
    suspend fun pushPost(post : Post) : Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }
    suspend fun pushPost2(userId : Int,id : Int,title:String ,body:String) : Response<Post>{
        return RetrofitInstance.api.pushPost2(userId,id, title, body)
    }
}