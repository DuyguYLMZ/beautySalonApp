package com.dyg.benimkuaforum.ComposableItems

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.ui.theme.PurpleGrey40
import com.dyg.benimkuaforum.ui.theme.PurpleGrey80
import com.dyg.benimkuaforum.ui.theme.White


@Composable
fun CategoryField() {
    Column(verticalArrangement = Arrangement.Center) {
        CategoryFirstRow()
        CategorySecondRow()
    }
}

@Composable
fun CategoryFirstRow() {
    Row(
        modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            CategoryButton(R.drawable.beuaty24, "Nail Art")
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            CategoryButton(R.drawable.beuaty31, "Saç Tasarım")
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            CategoryButton(R.drawable.beuaty32, "Manikür Pedikür")
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            CategoryButton(R.drawable.beuaty35, "Cilt Bakım")
        }
    }
}


@Composable
fun CategorySecondRow() {
    Row(
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Max).background(Color.Transparent),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Box(
            modifier = Modifier
                .clickable { println("Button Clicked!") }
                .weight(1f)) {
            CategoryButton(R.drawable.beuaty27, "Makyaj")
        }
        Box(modifier = Modifier
            .clickable { println("Button Clicked!") }
            .weight(1f)) {
            CategoryButton(R.drawable.beuaty28, "Protez Tırnak")
        }
        Box(modifier = Modifier
            .clickable { println("Button Clicked!") }
            .weight(1f)) {
            CategoryButton(R.drawable.beuaty38, "Lazer")
        }
        Box(modifier = Modifier.background(Color.Transparent)
            .clickable { println("Button Clicked!") }
            .weight(1f)) {
            CategoryButton(R.drawable.beuaty40, "Lifting")
        }
    }
}

@Composable
fun CategoryButton(btnIcon: Int, text: String) {
    Card(
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        modifier = Modifier.background(Color.Transparent)
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(btnIcon),
                contentDescription = "Description for accessibility",
                contentScale = ContentScale.Fit,
            )
            Text(
                text,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 18.sp, fontFamily = FontFamily.Cursive)
            )

        }
    }

}


