// data/api/ApiService.kt
package com.example.tryingtolivethedream.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): PostDto

    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}