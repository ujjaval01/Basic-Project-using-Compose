package com.uv.practiceproject.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun CustomListViewPractice(imgId:Int, name:String, title:String, modifier: Modifier) {
    Row(modifier.padding(5.dp)
        .fillMaxWidth()) {
        Image(painter = painterResource(imgId), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(50.dp)
                .padding(2.dp)
                .clip(CircleShape))

        Spacer(modifier = Modifier.height(4.dp))

        Column(modifier = Modifier.padding(5.dp)
            .fillMaxWidth()) {
            Text(text = name, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = title, fontWeight = FontWeight.Light)
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
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

@Composable
fun TextCompo(name: String) {
    Text(text = "Hello $name!",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        fontFamily = FontFamily.Cursive,
        modifier = Modifier
            .background(Color.Yellow)
            .size(200.dp)
            .padding(36.dp)
            .clip(CircleShape)
            .background(Color.Green)


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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextCompoPreview(modifier: Modifier = Modifier) {
    TextCompo(name = "ujjaval")
}

//@Preview(showBackground = true)
@Composable
fun ImageCompoPreview(modifier: Modifier = Modifier) {
    ImageCompo()
}

//@Preview(showBackground = true)
@Composable
fun ButtonCompoPreview(modifier: Modifier = Modifier) {
    ButtonCompo()
}
