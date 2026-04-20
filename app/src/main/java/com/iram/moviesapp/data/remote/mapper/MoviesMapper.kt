package com.iram.moviesapp.data.remote.mapper

import com.iram.moviesapp.BuildConfig
import com.iram.moviesapp.data.remote.dto.MovieDto
import com.iram.moviesapp.domain.model.Movie
import com.iram.moviesapp.domain.model.MoviesResponse

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id ?: 0,
        title = title.orEmpty(),
        releaseDate = release_date.orEmpty(),
        poster = BuildConfig.LARGE_IMAGE_URL + poster_path.orEmpty(),
        overview = overview.orEmpty()
    )
}

fun MoviesResponse.toDomainList(): List<Movie> {
    return results.map { it.toDomain() }
}