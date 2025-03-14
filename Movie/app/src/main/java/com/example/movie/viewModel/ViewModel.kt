package com.example.movie.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.models.Data
import com.example.movie.models.Details
import com.example.movie.models.ScreenState
import com.example.movie.pagination.PaginationFactory
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())
    var id by mutableStateOf(0)

    private val pagination = PaginationFactory(
        initialPage = state.page,
        onLoadUpdate = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = {nextPage ->
            repository.getMoviesList(nextPage)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = {items, newPage ->
            state = state.copy(
                movies = state.movies + items.data,
                page = newPage,
                endReached = state.page == 25
            )
        },
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            pagination.loadNextPage()
        }
    }

    fun getDetailsById() {
        viewModelScope.launch {
            try {
                val response = repository.getDetailsById(id = id)
                if (response.isSuccessful) {
                    state = state.copy(
                        detailsData = response.body()!!
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    error = e.message
                )
            }
        }
    }
}

