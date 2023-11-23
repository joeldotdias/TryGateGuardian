package com.example.gateguardian.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gateguardian.presentation.auth.RegisterAdminScreen
import com.example.gateguardian.presentation.auth.ResidentLoginScreen
import com.example.gateguardian.presentation.auth.SecurityLoginScreen
import com.example.gateguardian.presentation.auth.StartScreen
import com.example.gateguardian.presentation.resident.ResidentDrawer
import com.example.gateguardian.presentation.security.SecurityBottomBar

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.StartScreen.name
    ) {
        composable(route = AppScreens.StartScreen.name) {
            StartScreen(navController = navController)
        }

        composable(route = AppScreens.ResidentLoginScreen.name) {
            ResidentLoginScreen(navController = navController)
        }

        composable(route = AppScreens.SecurityLoginScreen.name) {
            SecurityLoginScreen(navController = navController)
        }

        composable(route = AppScreens.RegisterAdminScreen.name) {
            RegisterAdminScreen(navController = navController)
        }

        composable(route = AppScreens.ResidentScreen.name) {
            ResidentDrawer()
        }

        composable(route = AppScreens.SecurityScreen.name) {
            SecurityBottomBar()
        }
    }
}