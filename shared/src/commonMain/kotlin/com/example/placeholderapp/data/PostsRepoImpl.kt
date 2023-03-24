package com.example.placeholderapp.data

import com.example.placeholderapp.data.contract.PostsRepo
import com.example.placeholderapp.data.model.PostResponse
import com.example.placeholderapp.network.ApiService

class PostsRepoImpl: PostsRepo {
    private val apiService = ApiService()
    override suspend fun getPosts(): List<PostResponse> {
        return apiService.getPosts()
    }
}