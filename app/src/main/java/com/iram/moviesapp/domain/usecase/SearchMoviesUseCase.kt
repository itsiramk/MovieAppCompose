package com.iram.moviesapp.domain.usecase

import com.iram.moviesapp.domain.repo.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String) = repository.searchMovies(query)
}