package com.dyg.benimkuaforum.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.DrawerValue
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.ui.theme.BackgroundColor
import com.dyg.benimkuaforum.ui.theme.Purple200
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("DrawerHome", R.drawable.beuaty05, "Anasyafa")
    object Randevu : NavDrawerItem("Randevu", R.drawable.beuaty01, "Randevu Al")
    object Notifications : NavDrawerItem("Notifications", R.drawable.beuaty01, "Bildirimler")
    object Profile : NavDrawerItem("Profile", R.drawable.beuaty01, "Profile")
    object Campaigns : NavDrawerItem("Campaigns", R.drawable.beuaty01, "Kampanyalar")
    object Contact : NavDrawerItem("Contact", R.drawable.beuaty01, "İletişim")
}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {
    val items = listOf(
        NavDrawerItem.Home,
        NavDrawerItem.Randevu,
        NavDrawerItem.Notifications,
        NavDrawerItem.Profile,
        NavDrawerItem.Campaigns,
        NavDrawerItem.Contact
    )
    Column(
        modifier = Modifier.background(color  = BackgroundColor)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.suleyman),
                    contentDescription = stringResource(id = R.string.profile),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Text(text = "Süleyman Şimşek", fontSize = 20.sp, fontFamily = FontFamily.Cursive)
            }
        }

        Divider(
            color = Purple200,
            modifier = Modifier.padding(bottom = 15.dp)
                .fillMaxWidth()  //fill the max height
                .width(21.dp)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
        Spacer(modifier = Modifier.weight(1f))
        Box {
            ClickableText(
                text = AnnotatedString("Log Out"),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = {
                    /*coroutineScope.launch {
                        vm.signOut()
                    }*/
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.None,
                    color = Color.Red
                )
            )
        }
        Text(
            text = "Developed by Duygu & Süleyman",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navController = rememberNavController()
    Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
}