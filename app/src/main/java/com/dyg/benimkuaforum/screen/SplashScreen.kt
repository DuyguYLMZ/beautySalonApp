package com.dyg.benimkuaforum.screen


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dyg.benimkuaforum.util.Routes
import androidx.compose.foundation.layout.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) = Box(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(800, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
        delay(1000)
        navController.navigate(Routes.Login.route) {
            popUpTo(Routes.Splash.route) {
                inclusive = true
            }
        }
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Müge\n\t\t\t Arslan",
            style = TextStyle(fontSize = 80.sp, fontFamily = FontFamily.Cursive)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
   // SplashScreen(navController = rememberNavController())
ScreenMain()
}