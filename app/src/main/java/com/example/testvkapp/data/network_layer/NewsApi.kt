package com.example.testvkapp.data.network_layer

import com.example.testvkapp.data.network_layer.models.ProductDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewsApi {


    @GET("/products")
    suspend fun getProducts(
        @Query("skip") skip : Int,
        @Query("limit") limit : Int
    ) : List<ProductDto>

}