package com.example.testvkapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.testvkapp.data.repo.NewsDataSource
import com.example.testvkapp.domain.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository : NewsRepository
) : ViewModel() {



    val productPagingFlow = Pager(
        PagingConfig(pageSize = 10)
    ) {
        NewsDataSource(repository)
    }.flow.cachedIn(viewModelScope)

}