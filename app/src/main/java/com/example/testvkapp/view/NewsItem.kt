package com.example.testvkapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.testvkapp.ui.common.ShimmerBrush

@Composable
fun NewsItem(
    title : String,
    thumbnail : String,
    description : String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        SubcomposeAsyncImage(
            modifier = Modifier
                .size(70.dp)
                .padding()
                .clip(CircleShape),
            model = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerBrush()
            }
        )

        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {

            Text(
                text = title,
                color = Color.Black,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = description,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

    }

}

@Preview
@Composable
private fun PrevItem() {



    NewsItem(
        title = "ТРЕДШОТ",
        description = "Цирк, 161 734 подписчиков",
        thumbnail = ""
    )

}
