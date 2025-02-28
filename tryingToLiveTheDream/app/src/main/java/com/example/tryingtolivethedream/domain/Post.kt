package com.example.tryingtolivethedream.domain

class Post(
    val image: String,
    val username: String,
    val title: String,
    val postImage: String,
    val likesCount: Int,
    val dislikeCount: Int,
    val commentsCount: Int,
    var userProfile: String? = null,
) {
    fun getUserProfile(): String? {
        return null
    }
    fun gotoProfile() {

    }
    fun likePost() {

    }
    fun dislikePost() {

    }
    fun gotoComments() {

    }
    fun savePost() {

    }
}