package com.example.mvvmcleanarchhilt.presentation.di

import com.example.mvvmcleanarchhilt.data.db.ArticleDao
import com.example.mvvmcleanarchhilt.data.repository.dataSource.NewsLocalDataSource
import com.example.mvvmcleanarchhilt.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(articleDao: ArticleDao):NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDao)
    }
}