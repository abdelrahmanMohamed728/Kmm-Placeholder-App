package com.example.placeholderapp.android.di

import com.example.placeholderapp.data.PostsRepoImpl
import com.example.placeholderapp.data.contract.PostsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {
    @Provides
    fun providePostsRepository(): PostsRepo {
        return PostsRepoImpl()
    }
}