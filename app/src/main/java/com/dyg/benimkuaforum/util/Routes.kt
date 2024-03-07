package com.dyg.benimkuaforum.util

sealed class Routes(val route: String) {
    object Splash : Routes("Splash")
    object SignUp : Routes("SignUp")
    object ForgotPassword : Routes("ForgotPassword")
    object Login : Routes("Login")
    object Dashboard : Routes("Dashboard")
    object Home : Routes("Home")
    object Randevu : Routes("Randevu")
    object Notifications : Routes("Notifications")
    object Profile : Routes("Profile")
    object Campaigns : Routes("Campaigns")
    object Contact : Routes("Contact")
}

