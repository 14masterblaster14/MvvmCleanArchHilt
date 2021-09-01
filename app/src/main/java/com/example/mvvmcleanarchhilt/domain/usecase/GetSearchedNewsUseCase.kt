package com.example.mvvmcleanarchhilt.domain.usecase

import com.example.mvvmcleanarchhilt.data.model.APIResponse
import com.example.mvvmcleanarchhilt.data.util.Resource
import com.example.mvvmcleanarchhilt.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    // Here we can apply business logic/filter the data and return the required type of data
    suspend fun execute(country:String, searchQuery:String, page:Int):Resource<APIResponse>{
        return newsRepository.getSearchedNews(country,searchQuery,page)
    }
}