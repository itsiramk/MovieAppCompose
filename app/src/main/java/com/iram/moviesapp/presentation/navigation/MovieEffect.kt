package com.iram.moviesapp.presentation.navigation

sealed class MovieEffect {
    data class NavigateToDetail(val movieId: Int) : MovieEffect()
}