package com.example.messaging.Models

data class Chat(
    val id: Int = 0,
    val image: String = "",
    val username: String = "",
    val bio: String = "",
    val Msgs: Map<String, String> = emptyMap<String, String>(),
    val selfMsgs: List<String> = emptyList(),
    )
