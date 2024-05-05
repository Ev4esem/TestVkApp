package com.example.testvkapp.di

import com.example.testvkapp.data.network_layer.NewsApi
import com.example.testvkapp.data.repo.NewsRepositoryImpl
import com.example.testvkapp.domain.repo.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideNewsApi() : NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    fun provideNewsRepositoryImpl_to_newsRepository(
        newsRepository : NewsRepositoryImpl
    ) : NewsRepository {
        return newsRepository
    }

}