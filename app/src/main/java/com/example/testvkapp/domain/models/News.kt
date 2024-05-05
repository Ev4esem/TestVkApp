package com.example.testvkapp.domain.models

data class News(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int,

)