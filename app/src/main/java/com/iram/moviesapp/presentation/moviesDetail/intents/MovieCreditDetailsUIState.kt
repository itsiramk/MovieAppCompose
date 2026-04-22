package com.iram.moviesapp.presentation.moviesDetail.intents

import com.iram.moviesapp.data.remote.dto.MovieCastDto
import com.iram.moviesapp.domain.model.Cast

sealed class MovieCreditDetailsUiState {

    data object Loading : MovieCreditDetailsUiState()

    data class Success(val listOfCast: List<Cast>) : MovieCreditDetailsUiState()

    data object Empty : MovieCreditDetailsUiState()

    data class Error(val message: String) : MovieCreditDetailsUiState()
}