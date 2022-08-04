package com.demoapp.petprog.topnews.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.demoapp.petprog.core.model.News

@Composable
fun ListNews(
    context: Context,
    data: List<News>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(top = 5.dp)
    ) {
        items(
            items = data
        ) {
            ItemNews(item = it) {
                openCustomChromeTab(context, it.url!!)
            }
        }
    }
}