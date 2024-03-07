package com.example.bottomnavbarexample

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.screen.drawerscreen.DrawerScreenComposable
import com.dyg.benimkuaforum.ui.theme.BenimKuaforumTheme
import com.dyg.benimkuaforum.util.Drawer
import com.dyg.benimkuaforum.util.bottomnavbar.TabView
import com.dyg.benimkuaforum.util.bottomnavbar.tabBarItems
import kotlinx.coroutines.launch

data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null
)

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(navController: NavHostController) {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    // creating our navController
    val navController = rememberNavController()
    BenimKuaforumTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerBackgroundColor = colorResource(id = R.color.purple_500),
            drawerContent = {
                Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
            },
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Column {
                            Text(
                                "Hello Süleyman!",
                                style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default)
                            )
                            Row {
                                Text(
                                    "Welcome to ",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Cursive
                                    )
                                )
                                Text(
                                    "Müge Arslan",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Cursive,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }

                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { if (scaffoldState.drawerState.isClosed) scaffoldState.drawerState.open() else scaffoldState.drawerState.close() }
                        }) {
                            Icon(Icons.Default.Menu, "backIcon")
                        }
                    },
                    actions = {
                        Image(
                            painter = painterResource(id = R.drawable.suleyman),
                            contentDescription = stringResource(id = R.string.profile),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                        )
                    }
                )
            },
            bottomBar = { TabView(tabBarItems, navController) }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                DrawerScreenComposable(navController)
            }
        }
    }


}

