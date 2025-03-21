package com.example.messaging.pagination

import retrofit2.Response

class PaginationFactory<Key, Item> (
    private val id: String,
    private val initialPage: Key,
    private inline val onLoadUpdate:(Boolean) -> Unit,
    private inline val onRequest:suspend (id: String, nextPage: Key) -> Response<Item>,
    private inline val getNextKey:suspend (Item) -> Key,
    private inline val onError:suspend (Throwable?) -> Unit,
    private inline val onSuccess:suspend (items: Item, newPage: Key) -> Unit
) : Pagination<Key, Item> {

    private var currentKey = initialPage
    private var isMakingRequest = false

    override suspend fun loadNextPage() {
        if (isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdate(true)
        try {
            val response = onRequest(id, currentKey)
            if (response.isSuccessful) {
                isMakingRequest = false
                val items = response.body()!!
                currentKey = getNextKey(items)
                onSuccess(items, currentKey)
                onLoadUpdate(false)
            }
        } catch (e: Exception) {
            onError(e)
            onLoadUpdate(false)
        }
    }

    override fun reset() {
        currentKey = initialPage
    }
}