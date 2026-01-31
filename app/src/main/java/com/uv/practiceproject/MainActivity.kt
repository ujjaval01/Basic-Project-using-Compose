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


class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeProjectTheme {

                Recomposable()
//                CategoryListScreenUsingLazyLayout()
//                CategoryListScreenUsingVerticalScroll()
//               TextCompo("Ujjaval")
//                CustomListViewPracticePreview()




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

@Composable
fun Recomposable(modifier: Modifier = Modifier) {

    var dice by remember { mutableIntStateOf(0) }
    var turn by remember { mutableIntStateOf(1) }
    var yourScore by remember { mutableIntStateOf(0) }
    var computerScore by remember { mutableIntStateOf(0) }

    val gameOver = yourScore >= 100 || computerScore >= 100
    val winnerText = when {
        yourScore >= 100 -> "🎉 You Won!"
        computerScore >= 100 -> "😢 You Lost"
        else -> ""
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                        MaterialTheme.colorScheme.background
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "🎲 Dice Game",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            // 🎲 Dice Card
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Box(
                    modifier = Modifier.run { size(120.dp) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (dice == 0) "—" else dice.toString(),
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // 🧍 Scores
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ScoreCard(title = "You", score = yourScore)
                ScoreCard(title = "Computer", score = computerScore)
            }

            // 🔄 Turn Indicator
            AssistChip(
                onClick = {},
                label = {
                    Text(
                        if (turn % 2 == 1) "Your Turn" else "Computer's Turn"
                    )
                }
            )

            // 🎯 Roll Button
            Button(
                enabled = !gameOver,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                onClick = {
                    dice = (1..6).random()
                    if (turn % 2 == 1) {
                        yourScore += dice
                    } else {
                        computerScore += dice
                    }
                    turn++
                }
            ) {
                Text(
                    text = "Roll Dice",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            // 🏆 Result
            if (gameOver) {
                Text(
                    text = winnerText,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    // ⏱ Reset after win
    LaunchedEffect(gameOver) {
        if (gameOver) {
            delay(3000)
            dice = 0
            yourScore = 0
            computerScore = 0
            turn = 1
        }
    }
}

@Composable
fun ScoreCard(title: String, score: Int) {
    Card(
        modifier = Modifier.width(150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                score.toString(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecomposablePreview(modifier: Modifier = Modifier) {
    Recomposable()
}
