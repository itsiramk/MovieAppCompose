package com.iram.moviesapp.presentation.movies.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.iram.moviesapp.domain.model.Movie

@Composable
fun MoviesCardWithTitle(modifier: Modifier, movie: Movie) {
    Column {
        Text(
            modifier = modifier.padding(8.dp),
            text = movie.title,
            textAlign = TextAlign.Center,
            minLines = 2,
            maxLines = 2,
            style = TextStyle(color = Color.Black)
        )

        Text(
            modifier = modifier.padding(4.dp),
            text = movie.releaseDate,
            textAlign = TextAlign.Center,
            maxLines = 1,
            style = TextStyle(color = Color.Black)
        )
    }
}