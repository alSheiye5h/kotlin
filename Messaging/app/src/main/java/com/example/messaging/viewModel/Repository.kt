package com.example.messaging.viewModel

import com.example.messaging.Models.ConvList
import com.example.messaging.Models.Conversation
import com.example.messaging.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getConvsList(id: String): Response<ConvList> {
        return RetrofitInstance.api.getConvs(id = id)
    }
}