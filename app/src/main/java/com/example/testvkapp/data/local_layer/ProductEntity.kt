package com.example.testvkapp.data.local_layer

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testvkapp.domain.models.Product

@Entity
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val description: String,
    val thumbnail: String,
    val title: String
)
fun ProductEntity.toProduct() = Product(
    id = id,
    description = description,
    thumbnail = thumbnail,
    title = title
)
