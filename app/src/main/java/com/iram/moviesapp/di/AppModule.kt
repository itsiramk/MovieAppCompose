package com.iram.moviesapp.di

import com.iram.moviesapp.data.remote.MovieApi
import com.iram.moviesapp.data.repoimpl.MovieDetailsRepositoryImpl
import com.iram.moviesapp.data.repoimpl.MovieRepositoryImpl
import com.iram.moviesapp.domain.repo.MovieDetailsRepository
import com.iram.moviesapp.domain.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(api: MovieApi): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(api)
    }
}