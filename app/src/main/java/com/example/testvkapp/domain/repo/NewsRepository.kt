package com.example.testvkapp.domain.repo

import com.example.testvkapp.domain.models.News
import com.example.testvkapp.domain.models.Product

interface NewsRepository {

    suspend fun getProducts(
        skip : Int,
        limit : Int
    ) : List<Product>

}