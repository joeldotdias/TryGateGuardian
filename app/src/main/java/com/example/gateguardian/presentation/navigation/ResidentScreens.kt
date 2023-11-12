package com.example.gateguardian.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.TransferWithinAStation
import androidx.compose.material.icons.filled.WatchLater
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ResidentScreens(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    object Dashboard: ResidentScreens(
        title = "Dashboard",
        route = "dashboard",
        icon = Icons.Filled.Speed
    )

    object Visitors: ResidentScreens(
        title = "Visitors",
        route = "visitors",
        icon = Icons.Filled.TransferWithinAStation
    )

    object Regulars: ResidentScreens(
        title = "Regulars",
        route = "regulars",
        icon = Icons.Filled.WatchLater
    )

    object Events: ResidentScreens(
        title = "Events",
        route = "events",
        icon = Icons.Filled.StarBorder
    )

    object Notices: ResidentScreens(
        title = "Notices",
        route = "notices",
        icon = Icons.Filled.Campaign
    )
}