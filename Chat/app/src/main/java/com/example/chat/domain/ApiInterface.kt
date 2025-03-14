package com.example.messaging.domain

import com.example.chat.models.ConversationList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("convs?")
    suspend fun getConvs(
        @Query("id") id: String,
        @Query("page") page: Int,
    ): Response<ConversationList>
}