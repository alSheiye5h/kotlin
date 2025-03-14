package com.example.chat.models

data class ScreenState(
    val conversations: List<Conversation> = emptyList(),
    val page: Int = 1,
    val detailsData: Chat = Chat(id = 1), // bedelha
    val endReached: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false
)