package com.example.testvkapp.data.repo

import com.example.testvkapp.data.network_layer.NewsApi
import com.example.testvkapp.domain.models.Product
import com.example.testvkapp.domain.repo.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor (
    private val newsApi : NewsApi
) : NewsRepository {


    override suspend fun getProducts() : Flow<List<Product>> {
    }


}