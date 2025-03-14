package com.example.messaging.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messaging.Models.ScreenState
import com.example.messaging.pagination.PaginationFactory
import kotlinx.coroutines.launch

class MessagingViewModel: ViewModel() {
    val repository = Repository()
    var state by mutableStateOf(ScreenState())
    var id = mutableStateOf(0)

    private val pagination = PaginationFactory(
        initialPage = state.page,
        onLoadUpdate = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = {nextP ->
            repository.getConvsList("n", nextP)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = {items, newPage ->
            state = state.copy(
                convs = state.convs + items.data,
                page = newPage,
                endReached = state.page == 25
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