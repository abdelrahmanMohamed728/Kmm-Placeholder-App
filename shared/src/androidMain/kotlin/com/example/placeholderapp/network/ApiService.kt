package com.example.placeholderapp.network

import com.example.placeholderapp.data.model.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

import io.ktor.client.request.*


actual class ApiService {
    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    actual suspend fun getPosts(): List<PostResponse> {
        return client.get(NetworkConstants.POSTS)
    }
}