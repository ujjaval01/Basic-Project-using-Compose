package com.uv.practiceproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.uv.practiceproject.ui.theme.PracticeProjectTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            PracticeProjectTheme {
//                ProductListScreen(viewModel = viewModel)
                // A surface container using the 'background' color from the theme
//                ToastDemo()

                Button(onClick = {
                    val text = "Hello toast!"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                }) {
                    Text(text = "Toast")
                }



            }
        }
    }
}

@Composable
fun ToastDemo(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Toast")
    }

}
