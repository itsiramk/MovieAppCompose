package com.iram.moviesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iram.moviesapp.presentation.movies.screens.MovieHomeScreen
import com.iram.moviesapp.presentation.moviesDetail.screens.MovieDetailHomeScreen
import com.iram.moviesapp.presentation.moviesDetail.screens.MovieDetailScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "movies") {
        composable("movies") { MovieHomeScreen(navController) }
        composable(
            "details/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) {
            val movieId = it.arguments?.getInt("movieId")
            MovieDetailHomeScreen(movieId = movieId, navController = navController)
        }
    }
}