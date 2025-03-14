package com.example.chat.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chat.models.ScreenState
import com.example.movie.viewModel.Repository
import kotlinx.coroutines.launch
import com.example.movie.pagination.PaginationFactory

class ChatViewModel: ViewModel() {
    val repository = Repository()
    var state by mutableStateOf(ScreenState())
    var id =" 67d46b69c73a876e25cebb85"

    private val pagination = PaginationFactory(
        initialPage = state.page,
        onLoadUpdate = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = { id: String, page : Int ->
            repository.getConversationList(
                id = id,
                page = page
            )
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, page: Int ->
            val newPage = page as? Int ?: 0  // Ensure `page` is an Int
            state = state.copy(
                convs = state.conversations.data + items,
                page = newPage + 1,
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            pagination.loadNextPage()
        }
    }



}