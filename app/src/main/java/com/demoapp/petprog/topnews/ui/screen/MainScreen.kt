package com.demoapp.petprog.topnews.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.demoapp.petprog.topnews.viewmodel.MainViewModel
import com.demoapp.petprog.common.util.ViewStateStatus
import com.demoapp.petprog.topnews.R
import com.demoapp.petprog.topnews.ui.common.FailedToLoad
import com.demoapp.petprog.topnews.ui.common.ShimmerNews
import com.demoapp.petprog.topnews.ui.components.ListNews
import com.demoapp.petprog.topnews.ui.components.Topbar
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen (context: Context, viewModel: MainViewModel) {
    val headlineState = viewModel.headlineState.collectAsState().value
    Scaffold(
        topBar = {
            Topbar()
        },
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = false),
            onRefresh = {
                viewModel.getHeadline(true)
            },
        ) {
            Column {

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                    Text(
                        stringResource(id = R.string.top_news_text),
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                }

                when (headlineState) {
                    is ViewStateStatus.Loading -> {
                        ShimmerNews()
                    }
                    is ViewStateStatus.Success -> {
                        ListNews(context = context, data = headlineState.data)
                    }
                    is ViewStateStatus.Error -> {
                        FailedToLoad()
                    }

                }
            }
        }
    }


}