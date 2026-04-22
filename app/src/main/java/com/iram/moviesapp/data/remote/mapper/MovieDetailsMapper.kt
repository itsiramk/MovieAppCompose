package com.iram.moviesapp.data.remote.mapper

import com.iram.moviesapp.BuildConfig
import com.iram.moviesapp.data.remote.dto.MovieCastDto
import com.iram.moviesapp.domain.model.Cast
import com.iram.moviesapp.domain.model.MovieCredits

fun MovieCastDto.toDomain(): Cast {
    return Cast(
        id = id.orEmpty(),
        name = name.orEmpty(),
        profile_path = profile_path?.let {
            BuildConfig.SMALL_IMAGE_URL + it
        }.orEmpty()
    )
}


fun MovieCredits.toDomainList(): List<Cast> {
    return cast.map { it.toDomain() }
}