package com.example.movie.domain

import com.example.movie.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movies?/page=1")
    suspend fun getMovies(
        @Query("page")page: Int



    ): Response<MoviesList>
}