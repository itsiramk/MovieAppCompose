package com.iram.moviesapp.presentation.movies.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iram.moviesapp.domain.model.Movie

@Composable
fun MoviesListScreen(
    modifier: Modifier,
    movieData: List<Movie>,
    onMovieClick: (Int) -> Unit
) {

    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().statusBarsPadding().padding(8.dp)
    ) {
        SearchBar(onSearch = { query ->
            searchQuery = query
        })
        MovieCard(
            modifier = Modifier.weight(1f).padding(vertical = 16.dp),
            movieData = movieData.filter {
                it.title.contains(searchQuery, ignoreCase = true) || it.releaseDate.contains(
                    searchQuery,
                    ignoreCase = true
                )
            },
            onMovieClick = onMovieClick
        )
    }
}

@Composable
fun SearchBar(onSearch: (String) -> Unit) {

    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(it)
        },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(color = Color.Black),

        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp),

        decorationBox = { innerTextField ->

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {

                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    if (text.isEmpty()) {
                        Text("Search movies...", color = Color.Gray)
                    }
                    innerTextField()
                }

                if (text.isNotEmpty()) {
                    IconButton(onClick = {
                        text = ""
                        onSearch("")
                    }) {
                        Icon(Icons.Default.Close, contentDescription = null)
                    }
                }
            }
        }
    )
}