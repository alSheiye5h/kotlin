package com.example.movie.viewModel

import com.example.chat.models.ConversationList
import com.example.messaging.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMoviesList(id: String, page: Int) : Response<ConversationList> {
        return RetrofitInstance.api.getConvs(id, page)
    }

    /* suspend fun getDetailsById(id: Int):Response<Details> {
        return RetrofitInstance.api.getDetailsById(id = id)
    } */
}