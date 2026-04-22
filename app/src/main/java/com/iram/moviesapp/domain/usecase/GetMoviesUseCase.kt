package com.iram.moviesapp.domain.usecase

import com.iram.moviesapp.data.remote.mapper.toDomainList
import com.iram.moviesapp.domain.model.Movie
import com.iram.moviesapp.domain.repo.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun getMoviesData(): List<Movie> {
        val response = repository.getMovies()
        return response.toDomainList()
    }
}