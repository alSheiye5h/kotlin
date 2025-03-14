package com.example.messaging.domain

import com.example.messaging.Models.Conversation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("convs?")
    suspend fun getConvs(
        @Query("count")count: Int
    ): Response<List<Conversation>>
}