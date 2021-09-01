package com.example.mvvmcleanarchhilt.presentation.di

import com.example.mvvmcleanarchhilt.data.api.NewsAPIService
import com.example.mvvmcleanarchhilt.data.repository.dataSource.NewsRemoteDataSource
import com.example.mvvmcleanarchhilt.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}