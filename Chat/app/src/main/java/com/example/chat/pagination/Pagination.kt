package com.example.movie.pagination

interface Pagination {
    suspend fun loadNextPage()
    fun reset()
}