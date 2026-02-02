package com.uv.practiceproject.practice

/* Agar hume specific imports krne h to, inko
expend karne k liye hum ctrl+alt+o krte h */

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter(count, {count++})
        Spacer(modifier = Modifier.height(16.dp))
        MessageBar(count)
    }

}

@Composable
fun MessageBar(count: Int) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Message sent so far - $count")
        }
    }
}

@Composable
fun NotificationCounter(
    count:Int,
    increment: () -> Unit
) {
//            var count = 0
//    var scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Text(text = "You have sent $count notifications",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .wrapContentSize(),
            onClick = {
//            scope.async {
//                delay(2000)
                increment()
//            }
        }) {
            Text("Send Notification",
                fontSize = 22.sp
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NotificationScreenPreview(modifier: Modifier = Modifier) {
    NotificationScreen()
}

