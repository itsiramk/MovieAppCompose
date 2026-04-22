package com.iram.moviesapp.data.repoimpl

import com.iram.moviesapp.data.remote.MovieApi
import com.iram.moviesapp.data.remote.mapper.toDomainList
import com.iram.moviesapp.domain.repo.MovieDetailsRepository

class MovieDetailsRepositoryImpl(
    private val api: MovieApi
) : MovieDetailsRepository {

    override suspend fun getMovieCast(movieId: Int) = api.getCreditDetails(movieId).toDomainList()
    override suspend fun getMovieReviews(movieId: Int) = api.getReviews(movieId)
}


