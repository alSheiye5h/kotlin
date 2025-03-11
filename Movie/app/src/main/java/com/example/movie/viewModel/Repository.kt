package com.example.movie.viewModel

import com.example.movie.models.MoviesList
import com.example.movie.utils.RetrofitInstance
import retrofit2.Response
import retrofit2.Retrofit

class Repository {
    suspend fun getMoviesList(page: Int) : Response<MoviesList> {
        return RetrofitInstance.api.getMovies(page)
    }
}