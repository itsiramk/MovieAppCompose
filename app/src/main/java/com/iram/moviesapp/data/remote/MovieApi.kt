package com.iram.moviesapp.data.remote

import com.iram.moviesapp.data.remote.dto.MovieDto
import com.iram.moviesapp.domain.model.MovieCredits
import com.iram.moviesapp.domain.model.MovieReviews
import com.iram.moviesapp.domain.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("movie/popular")
    suspend fun getMovies(): MoviesResponse

    @GET("movie/{id}/credits")
    suspend fun getCreditDetails(@Path("id") id: Int): MovieCredits

    @GET("movie/{id}/reviews")
    suspend fun getReviews(@Path("id") id: Int): MovieReviews
}
