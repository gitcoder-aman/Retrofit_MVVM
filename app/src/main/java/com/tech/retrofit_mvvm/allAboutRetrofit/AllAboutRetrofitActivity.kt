package com.tech.retrofit_mvvm.allAboutRetrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.retrofit_mvvm.allAboutRetrofit.model.Post
import com.tech.retrofit_mvvm.allAboutRetrofit.repository.Repository
import com.tech.retrofit_mvvm.allAboutRetrofit.viewmodel.MainViewModel
import com.tech.retrofit_mvvm.allAboutRetrofit.viewmodel.MainViewModelFactory
import com.tech.retrofit_mvvm.ui.theme.Retrofit_MVVMTheme

class AllAboutRetrofitActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Retrofit_MVVMTheme {
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
//                viewModel.getCustomPosts(2,"id","desc") //asc
                val options : HashMap<String,String> = HashMap()
                options["_sort"] = "id"
                options["_order"] = "desc"
//                viewModel.getCustomPosts2(2,options) //asc
//                val myPost = Post(2,2,"Aman Kumar","Android Developer")
//                viewModel.pushPost(myPost)
//                viewModel.pushPost2(2,2,"Aman Kumar","Android Developer")
                viewModel.getPost()
                viewModel.myResponse.observe(this, Observer { response ->
                    if (response.isSuccessful) {
//                        Log.d("ResponseGET@@", "onCreate: ${response.body()?.userId}")
//                        Log.d("ResponseGET@@", "onCreate: ${response.body()?.id.toString()}")
//                        Log.d("ResponseGET@@", "onCreate: ${response.body()?.title.toString()}")
//                        Log.d("ResponseGET@@", "onCreate: ${response.body()?.body.toString()}")

                        Log.d("ResponsePOST@@", "onCreate: ${response.body().toString()}")
                        Log.d("ResponsePOST@@", "onCreate: ${response.code()}")
                        Log.d("ResponsePOST@@", "onCreate: ${response.headers()}")

//                        response.body()?.forEach { it ->
//                            Log.d("ResponseGET@@", "onCreate: ${it.userId}")
//                            Log.d("ResponseGET@@", "onCreate: ${it.id}")
//                            Log.d("ResponseGET@@", "onCreate: ${it.title}")
//                            Log.d("ResponseGET@@", "onCreate: ${it.body}")
//                            Log.d("ResponseGET@@", "---------------------------------------")
//                        }
                    } else {
                        Log.d("ResponseGET@@", "onCreate: ${response.code()}")
                    }
                })
            }
        }
    }
}