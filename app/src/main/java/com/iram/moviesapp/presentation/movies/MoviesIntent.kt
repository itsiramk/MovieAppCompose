package com.iram.moviesapp.presentation.movies

import com.iram.moviesapp.domain.model.Movie

sealed class MovieIntent {
    object LoadMovies : MovieIntent()
    data class Search(val query: String) : MovieIntent()
    data class ClickMovie(val id: Int) : MovieIntent()
}

sealed class MovieUiState {

    data object Loading : MovieUiState()

    data class Success(
        val movies: List<Movie>
    ) : MovieUiState()

    data object Empty : MovieUiState()

    data class Error(
        val message: String
    ) : MovieUiState()
}