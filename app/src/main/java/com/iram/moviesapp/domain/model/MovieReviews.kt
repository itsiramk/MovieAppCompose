package com.iram.moviesapp.domain.model

data class MovieReviews(
    val id: String?,
    val results: List<MovieReviewResult>? = null
)

data class AuthorDetails(
    val name: String? = null,
    val rating: String? = null
)

data class MovieReviewResult(
    val author_details: AuthorDetails? = null,
    val author: String?,
    val content: String?,
    val id: String? = null
)
