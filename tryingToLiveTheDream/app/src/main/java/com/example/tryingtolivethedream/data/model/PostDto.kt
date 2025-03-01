// data/model/PostDto.kt
package com.example.tryingtolivethedream.data.model

import com.example.tryingtolivethedream.domain.Post

data class PostDto(
    val id: Int,
    val username: String,
    val userImage: String,
    val title: String,
    val postImage: String,
    val likesCount: Int,
    val commentsCount: Int,
    var userProfile: String? = null,
) {
    // Convert DTO to domain model
    fun toDomain(): Post {
        return Post(
            username = username,
            title = title,
            postImage = postImage,
            likesCount = likesCount,
            commentsCount = commentsCount,
            userImage = userImage,
            userProfile = userProfile,
        )
    }
}

