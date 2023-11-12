package com.example.gateguardian.presentation.security

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gateguardian.presentation.navigation.SecurityNavigation
import com.example.gateguardian.presentation.navigation.SecurityScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityBottomBar() {

    val navController = rememberNavController()

    val screens = listOf(
        SecurityScreens.Verify,
        SecurityScreens.Notify,
        SecurityScreens.Logs
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination


    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any {
                                                                  it.route == screen.route
                        } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                            }
                        },
                        label = { Text(text = screen.title) },
                        icon = {
                            Icon(
                                imageVector = if(currentDestination?.route == screen.route) screen.selectedIcon else screen.unselectedIcon,
                                contentDescription = "${screen.title} icon"
                            )
                        }
                    )
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier.padding(bottom = it.calculateBottomPadding())
        ) {
            SecurityNavigation(navController = navController)
        }
    }
}