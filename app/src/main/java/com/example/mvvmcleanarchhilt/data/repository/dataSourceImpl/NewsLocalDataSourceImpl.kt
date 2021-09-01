package com.example.mvvmcleanarchhilt.data.repository.dataSourceImpl

import com.example.mvvmcleanarchhilt.data.db.ArticleDao
import com.example.mvvmcleanarchhilt.data.model.Article
import com.example.mvvmcleanarchhilt.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao):NewsLocalDataSource{

    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDao.deleteArticle(article)
    }

    override  fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }
}