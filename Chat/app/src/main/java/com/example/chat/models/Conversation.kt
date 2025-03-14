package com.example.chat.models

data class Conversation(
    val id: Int = 0,
    val party: String = "",
    val user: String = "",
    val image: String = "", // pdp dial party
    val lastMessage: String = "",
    val date: String = "",
)
