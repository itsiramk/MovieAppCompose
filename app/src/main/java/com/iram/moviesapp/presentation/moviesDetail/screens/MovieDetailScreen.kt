package com.iram.moviesapp.presentation.moviesDetail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iram.moviesapp.presentation.movies.MovieUiState
import com.iram.moviesapp.presentation.movies.MovieViewModel

@Composable
fun MovieDetailScreen(
    modifier: Modifier,
    movieId: Int?,
    navController: NavController,
    viewModel: MovieViewModel = hiltViewModel()

) {
    val state by viewModel.state.collectAsState()
    val movie = (state as? MovieUiState.Success)
        ?.movies
        ?.find {
            it.id == movieId
        }
    Column(modifier = modifier) {

        Box(
            modifier = Modifier.fillMaxWidth().height(300.dp)
        ) {

            AsyncImage(
                model = movie?.poster,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            )
                        )
                    )
            )

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .statusBarsPadding()
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                text = movie?.title.orEmpty(),
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }

        MovieOverviewScreen(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            movie = movie
        )
    }
}