package com.uv.practiceproject.practice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uv.practiceproject.R

@Composable
fun BlogCategory(img: Int, title: String, subtitle: String, salary: String, joining: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(0.5.dp, colorResource(R.color.teal_700))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .weight(0.17f)
            )
            Extracted(title, subtitle, salary, joining)
        }
    }
}


@Composable
private fun RowScope.Extracted(
    title: String,
    subtitle: String,
    salary: String,
    joining: String
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .weight(0.83f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(5.dp)
            )
            Text(text = salary,
                modifier = Modifier.padding(5.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )  {
            Text(
                text = subtitle,
                modifier = Modifier.padding(5.dp)
            )
            Text(text = joining)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BlogCategoryPreview() {
    Column {
        categoryList().forEach { item ->
            BlogCategory(
                img = item.img,
                title = item.title,
                subtitle = item.subtitle,
                salary = item.salary,
                joining = item.joining
            )
        }
    }
}

