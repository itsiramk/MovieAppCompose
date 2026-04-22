package com.iram.moviesapp.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iram.moviesapp.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private val _state = MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val state = _state.asStateFlow()

    init {
        loadMovies()
    }
    /** Using suspend instead of Flow because this is a one-shot API call.
     * Flow would be more suitable for streaming, pagination, or DB observation.
     */

    fun loadMovies() {
        viewModelScope.launch {
            _state.value = MovieUiState.Loading
            try {
                val movies = getMoviesUseCase.getMoviesData()
                _state.value =
                    if (movies.isEmpty()) {
                        MovieUiState.Empty
                    } else {
                        MovieUiState.Success(movies)
                    }

            } catch (e: Exception) {
                _state.value = MovieUiState.Error(
                    e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun retry() {
        loadMovies()
    }

}