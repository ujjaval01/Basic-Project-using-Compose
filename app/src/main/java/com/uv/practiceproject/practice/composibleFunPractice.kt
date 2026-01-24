package com.uv.practiceproject.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uv.practiceproject.R

@Composable
fun CustomListViewPractice(imgId:Int, name:String, title:String) {
    Row(modifier = Modifier.padding(3.dp)) {
        Image(painter = painterResource(imgId), contentDescription = null,
            modifier = Modifier.size(50.dp)
                .padding(2.dp))

        Spacer(modifier = Modifier.height(4.dp))

        Column {
            Text(text = name, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = title, fontWeight = FontWeight.Light)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomListViewPracticePreview(modifier: Modifier = Modifier) {
    Column {
        CustomListViewPractice(R.drawable.anime, "Ujjaval Saini", "Android Developer")
        CustomListViewPractice(R.drawable.anime, "Harshit Saini", "Android Developer")
        CustomListViewPractice(R.drawable.anime, "Vivek Saini", "Android Developer")
        CustomListViewPractice(R.drawable.anime, "Akshay Saini", "Android Developer")

    }
}

@Composable
fun TextCompo(name: String) {
    Text(text = "Hello $name!",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        fontFamily = FontFamily.Cursive
    )
}

@Composable
fun ImageCompo() {
    Image(
        painter = painterResource(R.drawable.anime),
        contentDescription = null,
//        alpha = 0.5f,
//        colorFilter = ColorFilter.tint(Color.Red)
    )
}

@Composable
fun ButtonCompo() {
    Button(onClick = {

    }) {
        Text(text = "Click Me",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
            )
        Image(
            painter = painterResource(R.drawable.anime),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White)
        )
        
    }
}


@Preview(showBackground = true)
@Composable
fun TextCompoPreview(modifier: Modifier = Modifier) {
    TextCompo(name = "ujjaval")
}

@Preview(showBackground = true)
@Composable
fun ImageCompoPreview(modifier: Modifier = Modifier) {
    ImageCompo()
}

@Preview(showBackground = true)
@Composable
fun ButtonCompoPreview(modifier: Modifier = Modifier) {
    ButtonCompo()
}
