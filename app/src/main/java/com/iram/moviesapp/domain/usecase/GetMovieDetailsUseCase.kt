package com.iram.moviesapp.domain.usecase

import com.iram.moviesapp.domain.repo.MovieDetailsRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieDetailsRepository
) {

    suspend fun getMovieCast(movieId: Int) = repository.getMovieCast(movieId)

    suspend fun getMovieReviews(movieId: Int) = repository.getMovieReviews(movieId)

}