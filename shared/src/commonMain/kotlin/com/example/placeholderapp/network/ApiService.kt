package com.example.placeholderapp.network

import com.example.placeholderapp.data.model.PostResponse

expect class ApiService() {
    suspend fun getPosts(): List<PostResponse>
}