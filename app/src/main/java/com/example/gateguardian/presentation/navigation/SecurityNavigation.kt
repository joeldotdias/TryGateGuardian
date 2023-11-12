package com.example.gateguardian.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gateguardian.presentation.security.logs.LogsScreen
import com.example.gateguardian.presentation.security.notify.NotifyScreen
import com.example.gateguardian.presentation.security.verify.VerifyScreen


@Composable
fun SecurityNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SecurityScreens.Verify.route
    ) {
        composable(route = SecurityScreens.Verify.route) {
            VerifyScreen()
        }

        composable(route = SecurityScreens.Notify.route) {
            NotifyScreen()
        }

        composable(route = SecurityScreens.Logs.route) {
            LogsScreen()
        }

    }
}