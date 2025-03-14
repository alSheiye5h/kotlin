package com.example.messaging.Models


data class Conversation(
    val id: Int = 0,
    val party: String = "",
    val user: String = "",
    val image: String = "",
    val lastMessage: String = "",
    val date: String = "",
)
