package com.dyg.benimkuaforum.screen.drawerscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dyg.benimkuaforum.screen.CampaignsScreen
import com.dyg.benimkuaforum.screen.Home
import com.dyg.benimkuaforum.screen.MusicScreen
import com.dyg.benimkuaforum.screen.NotificationsScreen
import com.dyg.benimkuaforum.screen.ProfileScreen
import com.dyg.benimkuaforum.screen.RandevuScreen
import com.dyg.benimkuaforum.util.NavDrawerItem
import com.dyg.benimkuaforum.util.bottomnavbar.alertsTab
import com.dyg.benimkuaforum.util.bottomnavbar.homeTab
import com.dyg.benimkuaforum.util.bottomnavbar.randevuTab

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawerScreenComposable(navController: NavHostController) {
    NavHost(navController, startDestination = homeTab.title) {
        composable(homeTab.title) {
            Home()
        }

        composable(randevuTab.title) {
            RandevuScreen()
        }
        composable(alertsTab.title) {
            NotificationsScreen()
        }
        composable(NavDrawerItem.Home.route) {
            Home()
        }
        composable(NavDrawerItem.Notifications.route) {
            NotificationsScreen()
        }
        composable(NavDrawerItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavDrawerItem.Campaigns.route) {
            CampaignsScreen(navController)
        }
        composable(NavDrawerItem.Contact.route) {
            MusicScreen()
        }
    }
}