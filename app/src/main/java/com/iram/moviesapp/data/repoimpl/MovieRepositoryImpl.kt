package com.iram.moviesapp.data.repoimpl

import com.iram.moviesapp.data.remote.MovieApi
import com.iram.moviesapp.domain.repo.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getMovies() = api.getMovies()

}


