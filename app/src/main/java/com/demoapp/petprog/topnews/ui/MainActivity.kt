package com.demoapp.petprog.topnews.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.demoapp.petprog.topnews.viewmodel.MainViewModel
import com.demoapp.petprog.common.theme.TopNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopNewsTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Navigation(this, viewModel)
                    }
            }
        }
    }
}