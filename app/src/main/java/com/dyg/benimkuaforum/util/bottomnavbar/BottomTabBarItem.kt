package com.dyg.benimkuaforum.util.bottomnavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import com.example.bottomnavbarexample.TabBarItem

// setting up the individual tabs
val homeTab = TabBarItem(
    title = "Home",
    selectedIcon = Icons.Filled.Home,
    unselectedIcon = Icons.Outlined.Home
)
val alertsTab = TabBarItem(
    title = "Alerts",
    selectedIcon = Icons.Filled.Notifications,
    unselectedIcon = Icons.Outlined.Notifications,
    badgeAmount = 7
)

val randevuTab = TabBarItem(
    title = "Randevu",
    selectedIcon = Icons.Filled.Call,
    unselectedIcon = Icons.Outlined.Call
)

// creating a list of all the tabs
val tabBarItems = listOf(homeTab, alertsTab, randevuTab)
