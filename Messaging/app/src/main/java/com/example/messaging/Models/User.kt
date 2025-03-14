package com.example.messaging.Models

data class User(
    val id: String,
    val username: String,
    val firstTime: Boolean,
    val role: String = "user"
)
