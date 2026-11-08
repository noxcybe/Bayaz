package com.bayaz.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Timeline : Screen("timeline", "Timeline", Icons.Filled.DateRange)
    object People : Screen("people", "People", Icons.Filled.Person)
    object Memories : Screen("memories", "Memories", Icons.AutoMirrored.Filled.List)
    object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}