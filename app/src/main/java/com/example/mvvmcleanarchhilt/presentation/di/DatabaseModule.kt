package com.example.mvvmcleanarchhilt.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmcleanarchhilt.data.db.ArticleDao
import com.example.mvvmcleanarchhilt.data.db.ArticleDatabase
import com.example.mvvmcleanarchhilt.data.model.Article
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesNewsDatabase(app:Application):ArticleDatabase{
        return Room.databaseBuilder(app,ArticleDatabase::class.java,"news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesNewsDao(articleDatabase: ArticleDatabase):ArticleDao{
        return articleDatabase.getArticleDAO()
    }
}