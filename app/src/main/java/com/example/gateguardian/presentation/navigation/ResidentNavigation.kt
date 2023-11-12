package com.example.gateguardian.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gateguardian.presentation.resident.dashboard.DashboardScreen
import com.example.gateguardian.presentation.resident.events.EventsScreen
import com.example.gateguardian.presentation.resident.notices.NoticesScreen
import com.example.gateguardian.presentation.resident.regulars.RegularsScreen
import com.example.gateguardian.presentation.resident.visitors.VisitorsScreen


@Composable
fun ResidentNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ResidentScreens.Dashboard.route
    ) {
        composable(route = ResidentScreens.Dashboard.route) {
            DashboardScreen()
        }

        composable(route = ResidentScreens.Visitors.route) {
            VisitorsScreen()
        }

        composable(route = ResidentScreens.Regulars.route) {
            RegularsScreen()
        }

        composable(route = ResidentScreens.Events.route) {
            EventsScreen()
        }

        composable(route = ResidentScreens.Notices.route) {
            NoticesScreen()
        }
    }
}