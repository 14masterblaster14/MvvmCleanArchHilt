package com.example.mvvmcleanarchhilt.presentation.di

import com.example.mvvmcleanarchhilt.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun providesNewsAdapter():NewsAdapter{
        return NewsAdapter()
    }

}