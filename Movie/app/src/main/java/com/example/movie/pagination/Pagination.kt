package com.example.movie.pagination

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}