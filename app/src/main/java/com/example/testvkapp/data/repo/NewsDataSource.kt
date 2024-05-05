package com.example.testvkapp.data.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testvkapp.domain.models.Product
import com.example.testvkapp.domain.repo.NewsRepository
import kotlinx.coroutines.delay

class NewsDataSource (
    private val repo : NewsRepository
) : PagingSource<Int, Product>() {

    override fun getRefreshKey(state : PagingState<Int, Product>) : Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params : LoadParams<Int>) : LoadResult<Int, Product> {
        return try {
            val page = params.key ?: 1
            val response = repo.getProducts(page, 10)
            delay(2000)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isNotEmpty()) response.last().id + 1 else null
            )
        } catch (e : Exception) {
            LoadResult.Error(e)
        }
    }


}