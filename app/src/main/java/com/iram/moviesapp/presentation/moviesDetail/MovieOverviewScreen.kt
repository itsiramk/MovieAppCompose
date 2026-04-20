package com.iram.moviesapp.presentation.moviesDetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iram.moviesapp.domain.model.Movie

@Composable
fun MovieOverviewScreen(
    modifier: Modifier,
    movie: Movie?
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp)
    ) {

        item {
            Text(
                text = "Overview",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = movie?.overview.orEmpty()
            )

            item {
                LazyRow {

                }
            }
        }

    }
}