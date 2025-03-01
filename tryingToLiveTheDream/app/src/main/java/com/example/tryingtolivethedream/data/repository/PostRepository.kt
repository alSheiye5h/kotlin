// data/repository/PostRepository.kt
package com.example.tryingtolivethedream.data.repository

import com.example.tryingtolivethedream.data.api.ApiService
import com.example.tryingtolivethedream.domain.Post
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPost(id: Int): Post {
        return apiService.getPost(id).toDomain()
    }

    suspend fun getPosts(): List<Post> {
        return apiService.getPosts().map { it.toDomain() }
    }
}