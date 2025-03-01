package com.example.tryingtolivethedream.domain

data class Post(
    val userImage: String,
    val username: String,
    val title: String,
    val postImage: String,
    val likesCount: Int,
    var userProfile: String? = null,
    val commentsCount: Int ,
){
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