package com.example.mvvmcleanarchhilt.domain.usecase

import com.example.mvvmcleanarchhilt.data.model.Article
import com.example.mvvmcleanarchhilt.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase (private val newsRepository: NewsRepository) {

    // Here we can apply business logic/filter the data and return the required type of data
    fun execute() : Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}