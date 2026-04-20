package com.iram.moviesapp.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val poster: String,
    val overview: String
)