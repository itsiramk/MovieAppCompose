package com.iram.moviesapp.domain.model

import com.iram.moviesapp.data.remote.dto.MovieCastDto

data class MovieCredits(
    val cast: List<MovieCastDto>,
    val id: String? = null
)

data class Cast(
    val name: String,
    val profile_path: String,
    val id: String
)