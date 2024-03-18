package com.dyg.benimkuaforum.screen.drawerscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dyg.benimkuaforum.screen.CampaignsPage1
import com.dyg.benimkuaforum.screen.CampaignsScreen
import com.dyg.benimkuaforum.screen.ContactScreen
import com.dyg.benimkuaforum.screen.Home
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
            RandevuScreen(navController)
        }
        composable(alertsTab.title) {
            NotificationsScreen(navController)
        }
        composable(NavDrawerItem.Home.route) {
            Home()
        }
        composable(NavDrawerItem.Notifications.route) {
            NotificationsScreen(navController)
        }
        composable(NavDrawerItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavDrawerItem.Campaigns.route) {
            CampaignsScreen(navController)
        }
        composable(NavDrawerItem.Contact.route) {
            ContactScreen()
        }
        composable(NavDrawerItem.CampaignsPage1.route) {
            CampaignsPage1()
        }
    }
}