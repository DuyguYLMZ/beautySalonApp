package com.dyg.benimkuaforum.screen

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
import com.dyg.benimkuaforum.screen.drawerscreen.CampaignsPage
import com.dyg.benimkuaforum.ui.theme.Purple700

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
fun MusicScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Music View",
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
fun MusicScreenPreview() {
    MusicScreen()
}

@Composable
fun RandevuScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize().background(color = Purple700)
            .background(colorResource(id = R.color.purple_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Randevu View",
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
fun RandevuScreenPreview() {
    RandevuScreen()
}


@Composable
fun NotificationsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Purple700)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Notifications View",
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
fun NotificationsScreenPreview() {
    NotificationsScreen()
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

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

@Composable
fun CampaignsScreen(navController: NavController) {
    CampaignsPage(navController)
}
