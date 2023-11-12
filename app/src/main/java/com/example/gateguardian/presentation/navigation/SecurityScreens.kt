package com.example.gateguardian.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.NotificationsActive
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.ui.graphics.vector.ImageVector

sealed class SecurityScreens(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Verify: SecurityScreens(
        title = "Verify",
        route = "verify",
        selectedIcon = Icons.Filled.Verified,
        unselectedIcon = Icons.Outlined.Verified
    )

    object Notify: SecurityScreens(
        title = "Notify",
        route = "notify",
        selectedIcon = Icons.Filled.NotificationsActive,
        unselectedIcon = Icons.Outlined.NotificationsActive
    )

    object Logs: SecurityScreens(
        title = "Logs",
        route = "logs",
        selectedIcon = Icons.Filled.MenuBook,
        unselectedIcon = Icons.Outlined.MenuBook
    )
}