package com.iram.moviesapp.presentation.moviesDetail.intents

sealed class MovieDetailsIntent {
    data class LoadDetails(val movieId: Int) : MovieDetailsIntent()
    data class RetryCredits(val movieId: Int) : MovieDetailsIntent()
    data class RetryReviews(val movieId: Int) : MovieDetailsIntent()
}