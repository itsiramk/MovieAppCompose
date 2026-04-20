package com.iram.moviesapp.presentation.uidatamodel

import com.iram.moviesapp.presentation.uimodel.MoviesUiModel

class MoviesUiDataModel(
    private val movieID: String?,
    private val movieName: String?,
    private val moviePoster: String?
) : MoviesUiModel {
    override fun getMovieId() = movieID.orEmpty()

    override fun getMovieName() = movieName.orEmpty()

    override fun getMoviePoster() = moviePoster.orEmpty()
}