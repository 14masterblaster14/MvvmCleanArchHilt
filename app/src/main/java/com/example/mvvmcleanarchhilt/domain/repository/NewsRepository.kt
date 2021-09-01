package com.example.mvvmcleanarchhilt.domain.repository

import com.example.mvvmcleanarchhilt.data.model.APIResponse
import com.example.mvvmcleanarchhilt.data.model.Article
import com.example.mvvmcleanarchhilt.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    /** Network queries **/
    suspend fun getNewsHeadlines( country : String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(country : String,searchQuery : String, page: Int): Resource<APIResponse>

    /** Local DB queries **/
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>  // As it returns a data stream so suspending function is not required
}