package com.example.messaging.Models

data class Chat (
    val id: String = "",
    val party: String = "",
    val image: String = "",
    val messages: List<Message> = emptyList(),
    )