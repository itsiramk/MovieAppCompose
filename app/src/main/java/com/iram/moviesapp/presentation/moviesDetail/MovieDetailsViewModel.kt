package com.iram.moviesapp.presentation.moviesDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iram.moviesapp.domain.usecase.GetMovieDetailsUseCase
import com.iram.moviesapp.presentation.moviesDetail.intents.MovieCreditDetailsUiState
import com.iram.moviesapp.presentation.moviesDetail.intents.MovieDetailsIntent
import com.iram.moviesapp.presentation.moviesDetail.intents.MovieReviewsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private var _creditState =
        MutableStateFlow<MovieCreditDetailsUiState>(MovieCreditDetailsUiState.Loading)
    val creditState = _creditState.asStateFlow()

    private val _reviewState = MutableStateFlow<MovieReviewsUiState>(MovieReviewsUiState.Loading)
    val reviewState = _reviewState.asStateFlow()

    fun loadCredits(movieId: Int) {
        viewModelScope.launch {
            _creditState.value = MovieCreditDetailsUiState.Loading
            try {
                val movieCast = getMovieDetailsUseCase.getMovieCast(movieId)
                _creditState.value = if (movieCast.isNotEmpty()) {
                    MovieCreditDetailsUiState.Success(movieCast)
                } else {
                    MovieCreditDetailsUiState.Empty
                }

            } catch (e: Exception) {
                _creditState.value = MovieCreditDetailsUiState.Error(e.message ?: "Error")
            }
        }
    }

    fun loadReviews(movieId: Int) {
        viewModelScope.launch {
            _reviewState.value = MovieReviewsUiState.Loading
            try {
                val reviews = getMovieDetailsUseCase.getMovieReviews(movieId)
                _reviewState.value = if (reviews.results?.isNotEmpty() == true) {
                    MovieReviewsUiState.Success(reviews)
                } else {
                    MovieReviewsUiState.Empty
                }

            } catch (e: Exception) {
                _reviewState.value = MovieReviewsUiState.Error(e.message ?: "Error")
            }
        }
    }

    fun onEvent(intent: MovieDetailsIntent) {
        when (intent) {

            is MovieDetailsIntent.LoadDetails -> {
                loadCredits(intent.movieId)
                loadReviews(intent.movieId)
            }

            is MovieDetailsIntent.RetryCredits -> {
                loadCredits(intent.movieId)
            }

            is MovieDetailsIntent.RetryReviews -> {
                loadReviews(intent.movieId)
            }
        }
    }
}