package com.dyg.benimkuaforum.screen

import android.content.pm.LauncherApps
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.dyg.benimkuaforum.R
import com.dyg.benimkuaforum.screen.drawerscreen.CampaignsPage
import com.dyg.benimkuaforum.ui.theme.Purple

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    val notification = rememberSaveable{ mutableStateOf("") }
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    var name by rememberSaveable {
        mutableStateOf("Default Name")
    }
    var username by rememberSaveable {
        mutableStateOf("Username")
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(10.dp),
    ) {

        Row (

            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Cancel",
                modifier = Modifier.clickable { notification.value = "Canceled" }
            )
            Text(text = "Save",
                modifier = Modifier.clickable { notification.value = "Profile Updated" }
            )
        }


        ProfileImage()
        
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 2.dp),
            verticalAlignment = Alignment.CenterVertically
            
        ){
            Text(text = "Ad", modifier =Modifier.width(100.dp))
            TextField( modifier = Modifier
                .background(Color.Transparent),
                value = name,
                onValueChange = { name = it },
                colors = TextFieldDefaults.colors(
                )
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 2.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Text(text = "Soyad", modifier =Modifier
                .width(100.dp))
            TextField( modifier = Modifier

                .background(Color.Transparent),
                value = username,
                onValueChange = { username = it },
                colors = TextFieldDefaults.colors(
                )
            )
        }
    }


    }
@Composable
fun ProfileImage(){
    val imageUri = rememberSaveable{ mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
        R.drawable.ic_user

        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri : Uri? ->
        uri?.let{ imageUri.value = it.toString()}

    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card (shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
        ){
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
        Text(text = "Change Profile Picture")
    }
    }






@Composable
fun CampaignsScreen(navController: NavController) {
    CampaignsPage(navController)
}
