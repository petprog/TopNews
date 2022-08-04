package com.demoapp.petprog.topnews.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.QueryBuilder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demoapp.petprog.common.theme.TopNewsTheme
import com.demoapp.petprog.common.theme.md_theme_light_outline
import com.demoapp.petprog.core.model.News
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
@Preview(name = "LoadingListLight")
fun ShimmerNews() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(top = 10.dp)
    ) {
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
        item { NewsItem() }
    }
}

@Composable
@Preview(name = "LoadingListDark")
fun ShimmerNewsDark() {

    TopNewsTheme(darkTheme = true) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(top = 10.dp)
        ) {
            item { NewsItem() }
            item { NewsItem() }
            item { NewsItem() }
            item { NewsItem() }
            item { NewsItem() }
            item { NewsItem() }
            item { NewsItem() }
            item { NewsItem() }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NewsItem() {
    val item = News.mock()
    Box(
        Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(4.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .placeholder(
                                visible = true,
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                highlight = PlaceholderHighlight.shimmer(
                                    highlightColor = Color.White
                                ),
                            ),
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Column(Modifier.padding(5.dp)) {
                            Text(
                                item.title!!,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.placeholder(
                                    visible = true,
                                    color = md_theme_light_outline,
                                    highlight = PlaceholderHighlight.shimmer(
                                        highlightColor = Color.White
                                    ),
                                ),
                            )
                            Row(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    item.author!!,
                                    modifier = Modifier
                                        .padding(top = 3.dp)
                                        .placeholder(
                                            visible = true,
                                            color = md_theme_light_outline,
                                            highlight = PlaceholderHighlight.shimmer(
                                                highlightColor = Color.White
                                            ),
                                        ),
                                    style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline)
                                )
                                Row {

                                    Icon(
                                        Icons.TwoTone.QueryBuilder, null,
                                        tint = md_theme_light_outline,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        item.publishedTime,
                                        modifier = Modifier
                                            .padding(start = 3.dp, top = 3.dp)
                                            .placeholder(
                                                visible = true,
                                                color = md_theme_light_outline,
                                                highlight = PlaceholderHighlight.shimmer(
                                                    highlightColor = Color.White
                                                ),
                                            ),
                                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline)
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
