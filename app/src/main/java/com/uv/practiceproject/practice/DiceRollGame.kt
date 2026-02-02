package com.uv.practiceproject.practice

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

// By myself
@Composable
fun DiceRoll(modifier: Modifier = Modifier) {

    var dice by rememberSaveable { mutableIntStateOf(0) }
    var turn by rememberSaveable { mutableIntStateOf(1) }
//    var yourScore = rememberSaveable { mutableIntStateOf(0) }  // Iski(=) sath hume yourScore.value ya yourScore.IntValue ka use krna pdega
    var yourScore by rememberSaveable { mutableIntStateOf(0) } // Iski sath kuch nhi use hota, direct yourScore use krte hai
    var computerScore by rememberSaveable { mutableIntStateOf(0) }

    val gameOver = yourScore >= 100 || computerScore >= 100
    val winner = when {
        yourScore >= 100 -> "You Won 🎉"
        computerScore >= 100 -> "You Lost 😢"
        else -> ""
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("🎲 Dice: $dice")
        Spacer(modifier = Modifier.height(10.dp))

        Text("👤 Your Score: ${yourScore}")
        Spacer(modifier = Modifier.height(10.dp))
        Text("👥 Computer Score: $computerScore")
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (turn % 2 == 1) "Your Turn" else "Computer's Turn"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            enabled = !gameOver,
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
            Text("Roll Dice")
        }

        Spacer(modifier = Modifier.height(30.dp))

        if (gameOver) {
            Text(winner)
        }
    }

    // 🔥 SIDE EFFECT (correct place)
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



// Refactor by ai
//@Composable
//fun DiceRoll(modifier: Modifier = Modifier) {
//
//    var dice by remember { mutableIntStateOf(0) }
//    var turn by remember { mutableIntStateOf(1) }
//    var yourScore by remember { mutableIntStateOf(0) }
//    var computerScore by remember { mutableIntStateOf(0) }
//
//    val gameOver = yourScore >= 100 || computerScore >= 100
//    val winnerText = when {
//        yourScore >= 100 -> "🎉 You Won!"
//        computerScore >= 100 -> "😢 You Lost"
//        else -> ""
//    }
//
//    Box(
//        modifier = modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    listOf(
//                        MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
//                        MaterialTheme.colorScheme.background
//                    )
//                )
//            ),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(20.dp),
//            modifier = Modifier.padding(20.dp)
//        ) {
//
//            Text(
//                text = "🎲 Dice Game",
//                style = MaterialTheme.typography.headlineMedium,
//                fontWeight = FontWeight.Bold
//            )
//
//            // 🎲 Dice Card
//            Card(
//                shape = RoundedCornerShape(20.dp),
//                elevation = CardDefaults.cardElevation(8.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surface
//                )
//            ) {
//                Box(
//                    modifier = Modifier.run { size(120.dp) },
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = if (dice == 0) "—" else dice.toString(),
//                        style = MaterialTheme.typography.displayMedium,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//
//            // 🧍 Scores
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//
//                ScoreCard(title = "You", score = yourScore)
//                ScoreCard(title = "Computer", score = computerScore)
//            }
//
//            // 🔄 Turn Indicator
//            AssistChip(
//                onClick = {},
//                label = {
//                    Text(
//                        if (turn % 2 == 1) "Your Turn" else "Computer's Turn"
//                    )
//                }
//            )
//
//            // 🎯 Roll Button
//            Button(
//                enabled = !gameOver,
//                shape = RoundedCornerShape(16.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                onClick = {
//                    dice = (1..6).random()
//                    if (turn % 2 == 1) {
//                        yourScore += dice
//                    } else {
//                        computerScore += dice
//                    }
//                    turn++
//                }
//            ) {
//                Text(
//                    text = "Roll Dice",
//                    style = MaterialTheme.typography.titleMedium
//                )
//            }
//
//            // 🏆 Result
//            if (gameOver) {
//                Text(
//                    text = winnerText,
//                    style = MaterialTheme.typography.headlineSmall,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//    }
//
//    // ⏱ Reset after win
//    LaunchedEffect(gameOver) {
//        if (gameOver) {
//            delay(3000)
//            dice = 0
//            yourScore = 0
//            computerScore = 0
//            turn = 1
//        }
//    }
//}
//
//@Composable
//fun ScoreCard(title: String, score: Int) {
//    Card(
//        modifier = Modifier.width(150.dp),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(6.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(title, style = MaterialTheme.typography.titleMedium)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                score.toString(),
//                style = MaterialTheme.typography.headlineMedium,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
//}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceRollPreview(modifier: Modifier = Modifier) {
    DiceRoll()
}