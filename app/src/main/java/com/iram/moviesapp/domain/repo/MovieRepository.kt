package com.iram.moviesapp.domain.repo

import com.iram.moviesapp.domain.model.MovieCredits
import com.iram.moviesapp.domain.model.MovieReviews
import com.iram.moviesapp.domain.model.MoviesResponse


interface MovieRepository {
    suspend fun getMovies(): MoviesResponse
    suspend fun getMovieCredits(): MovieCredits
    suspend fun getMovieReviews(): MovieReviews

}
