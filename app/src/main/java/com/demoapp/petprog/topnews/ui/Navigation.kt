package com.demoapp.petprog.topnews.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demoapp.petprog.topnews.ui.screen.MainScreen
import com.demoapp.petprog.topnews.ui.screen.SplashScreen
import com.demoapp.petprog.topnews.viewmodel.MainViewModel


@Composable
fun Navigation(context: Context, viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "main_screen") {
        // Main Screen
        composable("main_screen") {
            MainScreen(context = context, viewModel = viewModel)
        }
        // Splash Screen
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
    }
}