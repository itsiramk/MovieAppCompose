package com.iram.moviesapp.presentation.moviesDetail.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iram.moviesapp.domain.model.MovieReviews

@Composable
fun MovieReviewSection(reviews: MovieReviews) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Reviews",
            style = MaterialTheme.typography.titleLarge
        )

        reviews.results?.forEach { review ->

            Column(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = review.author ?: "Unknown",
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = "⭐ ${review.author_details?.rating?.toString() ?: "N/A"}",
                        style = MaterialTheme.typography.labelSmall
                    )
                }

                Text(
                    text = review.content ?: "NA",
                    style = MaterialTheme.typography.labelSmall
                )

            }
        }
    }
}