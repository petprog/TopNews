package com.demoapp.petprog.topnews.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.demoapp.petprog.topnews.R
import com.demoapp.petprog.common.theme.TopNewsTheme

@Composable
fun Topbar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.background,
        title = {
            Box(Modifier.fillMaxWidth()) {
                Text(
                    stringResource(id = R.string.app_name),
                    modifier = Modifier.align(Alignment.CenterStart),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        }
    )
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    TopNewsTheme {
        Topbar()
    }
}

@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    TopNewsTheme(darkTheme = true) {
        Topbar()
    }
}