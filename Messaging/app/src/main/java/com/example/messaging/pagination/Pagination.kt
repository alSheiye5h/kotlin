package com.example.messaging.pagination

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}