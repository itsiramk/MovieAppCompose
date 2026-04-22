package com.iram.moviesapp.domain.repo

import com.iram.moviesapp.domain.model.Cast
import com.iram.moviesapp.domain.model.MovieCredits
import com.iram.moviesapp.domain.model.MovieReviews


interface MovieDetailsRepository {
    suspend fun getMovieCast(movieId: Int): List<Cast>
    suspend fun getMovieReviews(movieId: Int): MovieReviews

}
