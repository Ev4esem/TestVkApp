package com.example.testvkapp.data.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.testvkapp.data.local_layer.NewsDao
import com.example.testvkapp.data.local_layer.NewsDatabase
import com.example.testvkapp.data.local_layer.ProductEntity
import com.example.testvkapp.data.network_layer.NewsApi
import com.example.testvkapp.data.network_layer.models.toProduct
import com.example.testvkapp.data.network_layer.models.toProductEntity
import com.example.testvkapp.domain.models.Product
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator (
    private val newsDb : NewsDatabase,
    private val newsApi : NewsApi
) : RemoteMediator<Int, ProductEntity>() {



    override suspend fun load(
        loadType : LoadType,
        state : PagingState<Int, ProductEntity>
    ) : MediatorResult {

        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val news = newsApi.getProducts(
                skip = loadKey,
                limit = state.config.pageSize
            )

            newsDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    newsDb.newsDao().clearAll()
                }
                val productEntities = news.map { it.toProductEntity() }
                newsDb.newsDao().upsertAll(productEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = news.isEmpty()
            )
        } catch (e : Exception) {
            MediatorResult.Error(e)
        } catch (e : HttpException) {
            MediatorResult.Error(e)
        }

    }


}