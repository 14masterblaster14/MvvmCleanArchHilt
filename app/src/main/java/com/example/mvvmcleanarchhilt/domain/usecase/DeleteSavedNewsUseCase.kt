package com.example.mvvmcleanarchhilt.domain.usecase

import com.example.mvvmcleanarchhilt.data.model.Article
import com.example.mvvmcleanarchhilt.domain.repository.NewsRepository

class DeleteSavedNewsUseCase (private val newsRepository: NewsRepository) {

    // Here we can apply business logic/filter the data and return the required type of data
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}