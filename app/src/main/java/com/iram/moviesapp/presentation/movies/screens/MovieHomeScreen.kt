package com.iram.moviesapp.presentation.movies.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.iram.moviesapp.presentation.movies.MovieUiState
import com.iram.moviesapp.presentation.movies.MovieViewModel

@Composable
fun MovieHomeScreen(
    navController: NavController,
    viewModel: MovieViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (state) {

            is MovieUiState.Loading -> {
                CircularProgressIndicator()
            }

            is MovieUiState.Success -> {
                MoviesListScreen(
                    modifier = Modifier.fillMaxWidth(),
                    movieData = (state as MovieUiState.Success).movies,
                    onMovieClick = { movieId ->
                        navController.navigate("details/$movieId")
                    }
                )
            }

            is MovieUiState.Empty -> {
                Column {
                    Text("No movies found")

                    Button(onClick = { viewModel.retry() }) {
                        Text("Retry")
                    }
                }
            }

            is MovieUiState.Error -> {
                Column {
                    Text("Error occurred")

                    Button(onClick = { viewModel.retry() }) {
                        Text("Retry")
                    }
                }
            }
        }

    }
}
