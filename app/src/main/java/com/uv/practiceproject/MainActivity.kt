package com.uv.practiceproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uv.practiceproject.practice.CategoryListScreenUsingLazyLayout
import com.uv.practiceproject.practice.DiceRoll


class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeProjectTheme {

                DiceRoll()
//                CategoryListScreenUsingLazyLayout()
//                CategoryListScreenUsingVerticalScroll()
//               TextCompo("Ujjaval")
//                CustomListViewPracticePreview()




//                ProductListScreen(viewModel = viewModel)
//                CountScreen()
//                ToastExample()

            }
        }
    }
}

@Composable
fun ToastExample(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        val text = "Hello toast!"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(context, text, duration) // in Activity
        toast.show()
    }) {
        Text(text = "Toast")
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

@Composable
fun CustomListViewPracticePreview(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        var i = 0
        while (i <= 15) {
            CustomListViewPractice(
                R.drawable.anime,
                "Ujjaval Saini",
                "Android Developer",
                modifier
            )
            i++
        }
    }
}


