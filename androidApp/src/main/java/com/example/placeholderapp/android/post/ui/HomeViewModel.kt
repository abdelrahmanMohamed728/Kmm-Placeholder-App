package com.example.placeholderapp.android.post.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholderapp.data.contract.PostsRepo
import com.example.placeholderapp.data.model.PostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: PostsRepo
) : ViewModel() {

    private val _postState = MutableStateFlow<List<PostResponse>>(listOf())
    val postState = _postState.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()
    init {
        loadData()
    }

    private fun loadData() {
        _loadingState.value = true
        viewModelScope.launch {
            _postState.value = withContext(Dispatchers.Default) {
                repo.getPosts()
            }
            _loadingState.value = false
        }
    }
}