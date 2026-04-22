package com.iram.moviesapp.presentation.moviesDetail.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iram.moviesapp.domain.model.MovieCredits
import com.iram.moviesapp.domain.model.MovieReviews

@Composable
fun MovieReviewSection(data: MovieReviews) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Reviews",
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn {
            items(data.results) { review ->

                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = review.author_details.name,
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = review.author_details.rating,
                        maxLines = 4
                    )
                }
            }
        }
    }
}