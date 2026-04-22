package com.iram.moviesapp.domain.repo

import com.iram.moviesapp.domain.model.MoviesResponse


interface MovieRepository {
    suspend fun getMovies(): MoviesResponse
}
