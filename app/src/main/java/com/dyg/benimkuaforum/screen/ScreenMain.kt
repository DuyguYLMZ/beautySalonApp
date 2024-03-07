package com.dyg.benimkuaforum.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dyg.benimkuaforum.util.Routes
import com.example.bottomnavbarexample.Dashboard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Splash.route) {

        composable(Routes.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Routes.Login.route) {
           LoginPage(navController = navController)
        }

        composable(Routes.SignUp.route) {
            SignUpPage(navController = navController)
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            //ForgotPassword(navController = navController)
        }

        composable(Routes.Dashboard.route) {
            Dashboard(navController = navController)
        }

    }
}