package com.dyg.benimkuaforum.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ContactPage() {
    val singapore = LatLng(39.89319146712189, 32.93340363835787)
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 15f)
    }
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Row (modifier =  Modifier.weight(1f)){
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = MarkerState(position = singapore),
                    title = "Singapore",
                    snippet = "Marker in Singapore"
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier =  Modifier.weight(1f)){
            Text(
                "İletişim:",
                style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Durali Alıç, Sultan Fatih Cd. 43/A, 06480 Mamak/Ankara",
                style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Default)
            )
            Text(
                "05435732988",
                style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Default)
            )
        }
    }


}

