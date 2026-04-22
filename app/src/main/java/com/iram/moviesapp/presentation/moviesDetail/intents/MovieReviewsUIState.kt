package com.iram.moviesapp.presentation.moviesDetail.intents

import com.iram.moviesapp.domain.model.MovieReviews

sealed class MovieReviewsUiState {

    data object Loading : MovieReviewsUiState()

    data class Success(val movieReviews: MovieReviews) : MovieReviewsUiState()

    data object Empty : MovieReviewsUiState()

    data class Error(val message: String) : MovieReviewsUiState()
}