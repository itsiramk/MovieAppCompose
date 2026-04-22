package com.iram.moviesapp.presentation.moviesDetail.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.iram.moviesapp.presentation.moviesDetail.MovieDetailsViewModel
import com.iram.moviesapp.presentation.moviesDetail.intents.MovieCreditDetailsUiState
import com.iram.moviesapp.presentation.moviesDetail.intents.MovieDetailsIntent
import com.iram.moviesapp.presentation.moviesDetail.intents.MovieReviewsUiState

@Composable
fun MovieDetailHomeScreen(
    movieId: Int?,
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val creditsState by viewModel.creditState.collectAsStateWithLifecycle()
    val reviewsState by viewModel.reviewState.collectAsStateWithLifecycle()

    LaunchedEffect(movieId) {
        movieId?.let {
            viewModel.onEvent(MovieDetailsIntent.LoadDetails(it))
        }
    }

    LazyColumn {

        item {
            MovieDetailScreen(
                modifier = Modifier.fillMaxWidth(),
                movieId = movieId,
                navController = navController
            )
        }

        item {

            when (creditsState) {
                is MovieCreditDetailsUiState.Success -> {
                    MovieCreditSection((creditsState as MovieCreditDetailsUiState.Success).listOfCast)
                }

                is MovieCreditDetailsUiState.Loading -> {
                    Text("Loading Cast...")
                }

                else -> Unit
            }

        }
        item {

            when (reviewsState) {
                is MovieReviewsUiState.Success -> {
                    MovieReviewSection((reviewsState as MovieReviewsUiState.Success).movieReviews)
                }

                is MovieReviewsUiState.Loading -> {
                    Text("Loading Reviews...")
                }

                else -> Unit
            }
        }
    }
}