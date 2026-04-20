package com.iram.moviesapp.domain.model

data class MovieReviews(
    val id: String,
    val results: List<MovieReviewResult>
)

data class AuthorDetails(
    val name: String,
    val rating: String
)

data class MovieReviewResult(
    val author_details: AuthorDetails,
    val id: String
)
