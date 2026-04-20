package com.iram.moviesapp.data.remote

import com.iram.moviesapp.domain.model.MovieCredits
import com.iram.moviesapp.domain.model.MovieReviews
import com.iram.moviesapp.domain.model.MoviesResponse
import retrofit2.http.GET

    interface MovieApi {

        @GET("movie/popular")
        suspend fun getMovies(): MoviesResponse

        @GET("movie/{id}/credits")
        suspend fun getCreditDetails(): MovieCredits

        @GET("movie/{id}/reviews")
        suspend fun getReviews(): MovieReviews
    }