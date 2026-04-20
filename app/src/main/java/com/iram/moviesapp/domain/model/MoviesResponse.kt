package com.iram.moviesapp.domain.model

import com.iram.moviesapp.data.remote.dto.MovieDto

data class MoviesResponse(
    val results: List<MovieDto>
)