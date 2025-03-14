package com.example.messaging.pagination

import retrofit2.Response

class PaginationFactory<Key, Item> (
    private val initialPage: Key,
    private inline val onLoadUpdate:(Boolean) -> Unit,
    private inline val onRequest:suspend (nextPage: Key) -> Response<Item>,
    private inline val getNextKey:suspend (Item) -> Key,
    private inline val onError:suspend (Throwable?) -> Unit,
    private inline val onSuccess:suspend (items: Item, newPage: Key) -> Unit
) : Pagination<Key, Item> {
}