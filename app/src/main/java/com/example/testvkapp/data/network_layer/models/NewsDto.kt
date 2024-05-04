package com.example.testvkapp.data.network_layer.models

import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("products")
    val products: List<ProductDto>,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
)


