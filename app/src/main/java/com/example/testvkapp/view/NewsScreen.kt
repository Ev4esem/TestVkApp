package com.example.testvkapp.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.testvkapp.domain.models.Product
import com.example.testvkapp.ui.common.NewsErrorScreen
import com.example.testvkapp.ui.common.NewsLoadingScreen

@Composable
fun NewsScreen(
    products : LazyPagingItems<Product>
) {

    val context = LocalContext.current
    LaunchedEffect(key1 = products.loadState) {


        if (products.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error : " + (products.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }

    }

    Scaffold(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {

        if (products.loadState.refresh is LoadState.Loading) {
            NewsLoadingScreen()
        } else {

            LazyColumn(
                modifier = Modifier.padding(it),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(products) { product ->

                    NewsItem(
                        title = product.title,
                        thumbnail = product.thumbnail,
                        description = product.description,
                    )

                }
                item {
                    if (products.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }

            }
        }
    }

}

fun <T : Any> LazyListScope.items(
    items : LazyPagingItems<T>,
    key : ((T) -> Any)? = null,
    contentType : ((T) -> Any)? = null,
    itemContent : @Composable LazyItemScope.(T) -> Unit
) {
    items(
        items.itemCount,
        key = items.itemKey(key),
        contentType = items.itemContentType(contentType)
    ) loop@{ i ->
        val item = items[i] ?: return@loop
        itemContent(item)
    }
}