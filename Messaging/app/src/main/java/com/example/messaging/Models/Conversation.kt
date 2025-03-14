package com.example.messaging.Models


data class Conversation(
    val id: Int = 0,
    val party: String = "",
    val image: String = "",
    val username: String = "",
    val lastMessage: String = "",
    val date: String = "",
)
