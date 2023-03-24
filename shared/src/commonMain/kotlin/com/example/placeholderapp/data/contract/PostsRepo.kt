package com.example.placeholderapp.data.contract

import com.example.placeholderapp.data.model.PostResponse

interface PostsRepo {
    suspend fun getPosts():List<PostResponse>
}