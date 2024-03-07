package com.dyg.benimkuaforum.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dyg.benimkuaforum.ComposableItems.CategoryField
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.ui.theme.Purple200
import com.dyg.benimkuaforum.util.homeslider.AutoSlidingCarousel
import com.dyg.benimkuaforum.util.homeslider.CircularList
import com.dyg.benimkuaforum.util.homeslider.RowItem
import com.dyg.benimkuaforum.util.homeslider.circularIcons

@Composable
fun Home() {
    val images = arrayOf(
        R.drawable.campaign1,
        R.drawable.campaign2,
        R.drawable.campaign3,
        R.drawable.campaign4,
        R.drawable.campaign5
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        CircularList(
            itemWidthDp = 85.dp,
            visibleItems = 5,
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(Color.Transparent),
        ) {

            var x = 20;
            while (x < circularIcons.size) {
                RowItem(iconPath = circularIcons[x])
                x++;
            }

        }
        Divider(
            color = Purple200,
            modifier = Modifier
                .fillMaxWidth()  //fill the max height
                .width(21.dp)
        )
        CategoryField()
        Divider(
            color = Purple200,
            modifier = Modifier
                .fillMaxWidth()
                .width(21.dp)
        )
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
            ) {
                AutoSlidingCarousel(
                    itemsCount = images.size,
                    itemContent = { index ->
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(images[index])
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(150.dp)
                        )
                    }
                )
            }
        }

    }

}
