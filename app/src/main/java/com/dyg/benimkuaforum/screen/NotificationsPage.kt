package com.dyg.benimkuaforum.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.ui.theme.White
import com.dyg.benimkuaforum.util.route.Routes

@Composable
fun NotificationsPage(navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(androidNameList) { item ->
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = White
                ),
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
                    .padding(4.dp)
                    .clickable {
                        if(item.imageResourceId == R.drawable.campaign1){
                            navController.navigate(Routes.Home.route)
                        } else if(item.imageResourceId == R.drawable.campaign2){
                            navController.navigate(Routes.Campaigns.route)
                        } else if(item.imageResourceId == R.drawable.campaign3){
                            navController.navigate(Routes.Randevu.route)
                        } else {
                            navController.navigate(Routes.Home.route)
                        }
                    }
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(Icons.Default.Notifications, stringResource(id = R.string.notification))
                    Text(
                        text = item.name,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default
                    )
                }
            }
        }
    }
}


data class AndroidVersion(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val release: String
)

val androidNameList = listOf(

    AndroidVersion(R.drawable.campaign1, "Anasayfayı açar", ""),
    AndroidVersion(R.drawable.campaign2, "Kampanyalar acılır", "August 22, 2016"),
    AndroidVersion(R.drawable.campaign3, "Randevu", "August 21, 2017"),
    AndroidVersion(R.drawable.campaign4, "Anasayfa", "August 6, 2018"),
    AndroidVersion(R.drawable.campaign5, "anasayfa ", "September 3, 2019")
)