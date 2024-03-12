package com.dyg.benimkuaforum.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.screen.commonscreen.model.services
import com.dyg.benimkuaforum.ui.theme.Purple200
import com.dyg.benimkuaforum.ui.theme.White
import com.dyg.benimkuaforum.util.homeslider.AutoSlidingCarousel
import com.dyg.benimkuaforum.util.homeslider.circularIcons

@Composable
fun Team(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Ekibimiz",
            style = MaterialTheme.typography.labelLarge,
        )
        TextButton(onClick = { }) {
            Text(text = "Tümü", style = TextStyle(color = MaterialTheme.colorScheme.primary))
        }
    }
}

@Composable
fun Appointments(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Randevularınız",
            style = MaterialTheme.typography.labelLarge
        )
        TextButton(onClick = { }) {
            Text(text = "Tümü")
        }
    }
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        modifier = Modifier.background(Color.Transparent)
            .fillMaxSize().padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
           Text(
                "Nail Art!",
                style = TextStyle(fontSize = 18.sp, fontFamily = FontFamily.Default)
            )
            androidx.compose.material3.Text(
                "7.02.24 - 14:15",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Cursive
                )
            )

        }
    }
}
@Composable
fun Services() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Hizmetlerimiz",
            style = MaterialTheme.typography.bodyLarge
        )
        TextButton(onClick = { }) {
            Text(text = "Tümü", style = TextStyle(color = MaterialTheme.colorScheme.primary))
        }
    }
    LazyRow(
        contentPadding = PaddingValues(start = 24.dp)
    ) {
        items(count = services.size) { index ->
            Box(modifier = Modifier
                .padding(end = 4.dp)
                .clickable { }) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = services[index].assetImage),
                        contentDescription = "Service Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(width = 200.dp, height = 260.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = services[index].title,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun Categories() {
    val categories = listOf(
        "Duygu",
        "Süleyman",
        "Besra",
        "Seringül",
        "Dilek",
        "Derin",
        "İdil",
        "Nezire",
    )
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier.horizontalScroll(scrollState)
    ) {
        repeat(categories.size) { index ->
            Surface(
                /// order matters
                modifier = Modifier
                    .padding(
                        start = if (index == 0) 24.dp else 0.dp,
                        end = 12.dp,
                    )
                    .border(width = 1.dp, color = Gray, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { }
                    .padding(12.dp)
            ) {
                Column (modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(id = circularIcons[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(6.dp)
                            .size(50.dp)
                            .clip(shape = CircleShape)
                            .border(BorderStroke(2.dp, Purple200), CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = categories[index], style = MaterialTheme.typography.bodyLarge)

                }
            }
        }
    }
}

val images = arrayOf(
    R.drawable.campaign1,
    R.drawable.campaign2,
    R.drawable.campaign3,
    R.drawable.campaign4,
    R.drawable.campaign5
)
@Composable
fun Banners() {
    Column(
        modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.Card(
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