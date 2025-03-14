package com.example.movie.pagination

import com.example.chat.models.ConversationList
import retrofit2.Response

class PaginationFactory<ConversationList>(
    private val initialPage: Int,
    private inline val onLoadUpdate:(Boolean) -> Unit,
    private inline val onRequest:suspend (nextPage: Int) -> Response<ConversationList>,
    private inline val getNextKey:suspend (ConversationList) -> Int,
    private inline val onError:suspend (Throwable?) -> Unit,
    private inline val onSuccess:suspend (ConversationList, newPage: Int) -> Unit
): Pagination {
    private var currentKey = initialPage
    private var isMakingRequest = false

    override suspend fun loadNextPage() {
        if (isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdate(true)
        try {
            val response = onRequest(currentKey)
            if (response.isSuccessful) {
                isMakingRequest = false
                val items: ConversationList = response.body()!!
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