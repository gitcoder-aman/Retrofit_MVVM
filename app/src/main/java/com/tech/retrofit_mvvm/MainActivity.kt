package com.tech.retrofit_mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.retrofit_mvvm.models.Products
import com.tech.retrofit_mvvm.ui.theme.Retrofit_MVVMTheme
import com.tech.retrofit_mvvm.viewmodels.MainViewModel
import com.tech.retrofit_mvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

//8
class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory  //field injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_MVVMTheme {

                var title by remember {
                    mutableStateOf("")
                }
                var dataListProduct = remember {
                    mutableStateListOf<Products>()
                }

                (application as FakerApplication).applicationComponent.inject(this)  //initialize the all inject field
                mainViewModel =
                    ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]


                mainViewModel.productsLiveData.observe(this, Observer { dataList ->
                    title = dataList.joinToString { x -> x.title + "\n\n" }
                    dataListProduct.addAll(dataList)
                    Log.d("@@@@", "datasize= "+dataListProduct.size.toString())
                })
                ResponseDataUI(dataListProduct)

            }
        }
    }

}

@Composable
fun ResponseDataUI(dataListProduct: List<Products>) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(dataListProduct) {
                    CardLayout(
                        title = it.title,
                        id = it.id,
                        category = it.category,
                        desc = it.description,
                        price = it.price.toString(),
                        image = it.image
                    )
                }
            }
        }
    }
}


@Composable
fun CardLayout(
    title: String,
    id: Int,
    category: String,
    desc: String,
    price: String,
    image: String
) {
    Card(
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title)
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = id.toString())
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = category)
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = desc)
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = price)
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = image)
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}
