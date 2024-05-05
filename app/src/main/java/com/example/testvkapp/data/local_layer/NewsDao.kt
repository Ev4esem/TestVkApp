package com.example.testvkapp.data.local_layer

import androidx.paging.PagingSource
import androidx.room.Query
import androidx.room.Upsert

interface NewsDao {

    @Upsert
    suspend fun upsertAll(products : List<ProductEntity>)

    @Query("SELECT * FROM productentity")
    fun pagingSource() : PagingSource<Int, ProductEntity>

    @Query("DELETE FROM productentity")
    suspend fun clearAll()

}