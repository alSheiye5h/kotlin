package com.example.movie.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.models.Data
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    private val repository = Repository()
    var state by mutableStateOf(ScreenState())
    init {
        viewModelScope.launch {
            val response = repository.getMoviesList(state.page)
            state = state.copy(
                movies = response.body()!!.data
            )
        }
    }
}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1
)