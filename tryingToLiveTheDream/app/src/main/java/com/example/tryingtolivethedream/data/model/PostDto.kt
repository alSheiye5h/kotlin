// data/model/PostDto.kt
package com.example.tryingtolivethedream.data.model

import com.example.tryingtolivethedream.domain.Post

data class PostDto(
    val id: Int,
    val username: String,
    val title: String,
    val profileImageUrl: String,
    val likesCount: Int,
    val commentsCount: Int
) {
    // Convert DTO to domain model
    fun toDomain(): Post {
        return Post(
            username = username,
            title = title,
            profileImageUrl = profileImageUrl,
            likesCount = likesCount,
            commentsCount = commentsCount
        )
    }
}