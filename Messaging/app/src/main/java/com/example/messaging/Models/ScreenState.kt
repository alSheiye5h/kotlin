package com.example.messaging.Models

data class ScreenState(
    val convs: List<Conversation> = emptyList(),
    val page: Int = 1,
    val detailsConv: Chat = Chat(),
    val endReached: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false
)
