package com.example.mvvmcleanarchhilt.presentation.di

import com.example.mvvmcleanarchhilt.domain.repository.NewsRepository
import com.example.mvvmcleanarchhilt.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetNewsHeadLinesUseCase( newsRepository: NewsRepository) : GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesGetSearchedNewsUseCase( newsRepository: NewsRepository) : GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesSaveNewsUseCase( newsRepository: NewsRepository) : SaveNewsUseCase{
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesGetSavedNewsUseCase( newsRepository: NewsRepository) : GetSavedNewsUseCase{
        return GetSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteSavedNewsUseCase( newsRepository: NewsRepository) : DeleteSavedNewsUseCase{
        return DeleteSavedNewsUseCase(newsRepository)
    }
}