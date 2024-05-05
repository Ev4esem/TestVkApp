package com.example.testvkapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.testvkapp.data.local_layer.NewsDatabase
import com.example.testvkapp.data.local_layer.ProductEntity
import com.example.testvkapp.data.network_layer.NewsApi
import com.example.testvkapp.data.repo.NewsRemoteMediator
import com.example.testvkapp.domain.models.Product
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


const val BASE_URL = "https://dummyjson.com"

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {


    @Provides
    @Singleton
    fun provideNewsDataBase(@ApplicationContext context : Context) : NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "news.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideNewsPager(newsDb : NewsDatabase, newsApi : NewsApi) : Pager<Int, ProductEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = NewsRemoteMediator(
                newsApi = newsApi,
                newsDb = newsDb
            ),
            pagingSourceFactory = {
                newsDb.newsDao().pagingSource()
            }
        )
    }

}