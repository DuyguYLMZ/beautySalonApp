package com.dyg.benimkuaforum.screen.drawerscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dyg.benimkuaforum.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampaignsPage(navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(androidNameList) { item ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.imageResourceId)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(150.dp)
            )
            Spacer(modifier = Modifier.height(7.dp))
        }
    }
}


data class AndroidVersion(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val release: String
)

val androidNameList = listOf(

    AndroidVersion(R.drawable.campaign1, "Marshmallow", "October 5, 2015"),
    AndroidVersion(R.drawable.campaign2, "Nougat", "August 22, 2016"),
    AndroidVersion(R.drawable.campaign3, "Oreo", "August 21, 2017"),
    AndroidVersion(R.drawable.campaign4, "Pie", "August 6, 2018"),
    AndroidVersion(R.drawable.campaign5, "Android 10", "September 3, 2019")
)