package com.uv.practiceproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.uv.practiceproject.apiCallingPager.ProductViewModel
import com.uv.practiceproject.practice.BlogCategory
import com.uv.practiceproject.practice.Category
import com.uv.practiceproject.practice.CustomListViewPractice
import com.uv.practiceproject.practice.categoryList
import com.uv.practiceproject.ui.theme.PracticeProjectTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

import androidx.compose.foundation.lazy.items
import com.uv.practiceproject.practice.CategoryListScreenUsingLazyLayout


class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeProjectTheme {

                CategoryListScreenUsingLazyLayout()
//                CategoryListScreenUsingVerticalScroll()
//               TextCompo("Ujjaval")
//                CustomListViewPracticePreview()



                @Composable
                fun CustomListViewPracticePreview(modifier: Modifier = Modifier) {
                    Column (modifier = modifier
                        .padding(10.dp)
                        .fillMaxSize()){
                        var i = 0
                        while (i<= 15){
                            CustomListViewPractice(R.drawable.anime, "Ujjaval Saini", "Android Developer", modifier)
                            i++
                        }
                    }
                }

//                ProductListScreen(viewModel = viewModel)
//                CountScreen()
//                ToastDemo()

//                Button(onClick = {
//                    val text = "Hello toast!"
//                    val duration = Toast.LENGTH_SHORT
//
//                    val toast = Toast.makeText(this, text, duration) // in Activity
//                    toast.show()
//                }) {
//                    Text(text = "Toast")
//                }
            }
        }
    }

@Composable
fun ToastDemo(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Button(onClick = {
        scope.async {
            delay(3000)
            Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT).show()
        }

    }) {
        Text(text = "Toast")
    }
}



}
