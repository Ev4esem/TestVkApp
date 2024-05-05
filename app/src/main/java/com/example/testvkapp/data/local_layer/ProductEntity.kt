package com.example.testvkapp.data.local_layer

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testvkapp.domain.models.Product

@Entity
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)
fun ProductEntity.toProduct() = Product(
    id = id,
    brand = brand,
    category = category,
    description = description,
    discountPercentage = discountPercentage,
    images = images,
    price = price,
    rating = rating,
    stock = stock,
    thumbnail = thumbnail,
    title = title
)
