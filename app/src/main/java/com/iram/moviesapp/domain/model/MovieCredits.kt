package com.iram.moviesapp.domain.model

data class MovieCredits(
    val cast: List<Cast>,
    val id: String)

data class Cast(
    val name: String,
    val profile_path: String,
    val id: String
)