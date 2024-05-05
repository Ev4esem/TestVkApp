package com.example.testvkapp.domain.models

data class Product(
    val description: String,
    val id: Int,
    val thumbnail: String,
    val title: String,
    val rating : Double,
    val brand : String
)