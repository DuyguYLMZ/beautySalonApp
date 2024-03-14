package com.dyg.benimkuaforum.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.screen.commonscreen.model.AppointmentPage
import com.dyg.benimkuaforum.screen.drawerscreen.CampaignsPage

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Home View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 55.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun ContactScreen() {
    ContactPage()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RandevuScreen(navController: NavController) {
    AppointmentPage(navController)
}


@Composable
fun NotificationsScreen(navController: NavController) {
    NotificationsPage(navController)
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_500))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 55.sp
        )
    }
}


@Composable
fun CampaignsScreen(navController: NavController) {
    CampaignsPage(navController)
}
