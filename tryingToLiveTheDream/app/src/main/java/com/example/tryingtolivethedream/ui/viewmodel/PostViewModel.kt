// ui/viewmodel/PostViewModel.kt
package com.example.tryingtolivethedream.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tryingtolivethedream.data.repository.PostRepository
import com.example.tryingtolivethedream.domain.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> get() = _posts

    fun loadPosts() {
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }
}