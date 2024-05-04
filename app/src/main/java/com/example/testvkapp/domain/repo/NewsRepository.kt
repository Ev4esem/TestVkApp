package com.example.testvkapp.domain.repo

import com.example.testvkapp.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getProducts() : Flow<List<Product>>

}