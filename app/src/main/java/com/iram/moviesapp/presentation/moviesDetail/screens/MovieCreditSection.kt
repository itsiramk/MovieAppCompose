package com.iram.moviesapp.presentation.moviesDetail.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.iram.moviesapp.domain.model.Cast

@Composable
fun MovieCreditSection(data: List<Cast>) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Cast",
            style = MaterialTheme.typography.titleLarge
        )

        LazyRow(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            items(data) { cast ->

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .padding(end = 8.dp)
                ) {
                    Card {
                        AsyncImage(
                            model = cast.profile_path,
                            contentDescription = null,
                            modifier = Modifier
                                .height(140.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        text = cast.name,
                        maxLines = 1
                    )
                }
            }
        }
    }
}