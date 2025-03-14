package com.example.messaging.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.messaging.Models.ScreenState

class MessagingViewModel {
    val repository = Repository()
    var state by mutableStateOf(ScreenState())
    var id = mutableStateOf(0)



}