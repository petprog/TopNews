package com.demoapp.petprog.topnews.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.QueryBuilder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demoapp.petprog.common.theme.TopNewsTheme
import com.demoapp.petprog.core.model.News
import com.demoapp.petprog.topnews.R
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemNews(
    item: News,
    onSelected: () -> Unit,
) {

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
                modifier = Modifier
                    .clickable(onClick = onSelected)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(4.dp))
                ) {
                    CoilImage(
                        imageModel = item.urlToImage,
                        contentScale = ContentScale.Crop, // Crop, Fit, Inside, FillHeight, FillWidth, None
                        previewPlaceholder = R.drawable.img_placeholder,
                        placeHolder = painterResource(R.drawable.img_placeholder),
                        error = painterResource(R.drawable.img_placeholder)
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
                                overflow = TextOverflow.Ellipsis
                            )

                            Row(modifier = Modifier
                                .padding(3.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                item.author?.let {
                                    Text(
                                        it,
                                        style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline)
                                    )
                                }
                                Row {
                                    Icon(
                                        Icons.TwoTone.QueryBuilder, null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        item.publishedTime,
                                        modifier = Modifier.padding(start = 3.dp),
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

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    TopNewsTheme() {
        ItemNews(
            item = News.mock()
        ) {}
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    TopNewsTheme(darkTheme = true) {
        ItemNews(
            item = News.mock()
        ) {}
    }
}