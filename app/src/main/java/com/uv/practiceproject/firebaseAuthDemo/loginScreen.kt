package com.uv.practiceproject.firebaseAuthDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uv.practiceproject.R

@Composable
fun LoginScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = colorResource(R.color.lightGray)),

        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.size(300.dp, 200.dp),
            shape = RoundedCornerShape(20.dp),
            tonalElevation = 8.dp,
            shadowElevation = 10.dp
        ) {
            Text(text = "Hii, Ujjaval Saini",
                fontWeight = FontWeight.SemiBold,
                fontSize = 38.sp,
                modifier = Modifier.padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
