package com.example.testvkapp.data.network_layer.models

import com.example.testvkapp.domain.models.Product
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("brand")
    val brand : String,
    @SerializedName("category")
    val category : String,
    @SerializedName("description")
    val description : String,
    @SerializedName("discountPercentage")
    val discountPercentage : Double,
    @SerializedName("id")
    val id : Int,
    @SerializedName("images")
    val images : List<String>,
    @SerializedName("price")
    val price : Int,
    @SerializedName("rating")
    val rating : Double,
    @SerializedName("stock")
    val stock : Int,
    @SerializedName("thumbnail")
    val thumbnail : String,
    @SerializedName("title")
    val title : String
)

fun ProductDto.toProduct() = Product(
    brand = brand,
    category =  category,
    description = description ,
    discountPercentage = discountPercentage,
    id = id,
    images = images,
    price =  price,
    rating = rating,
    stock = stock,
    thumbnail = thumbnail,
    title = title
)

