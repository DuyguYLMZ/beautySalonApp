package com.dyg.benimkuaforum.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dyg.benimkuaforum.ui.theme.Purple700
import com.dyg.benimkuaforum.util.route.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpPage(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start

    ) {
        Column(
            modifier = Modifier.padding(25.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {

            val inputNameValue = remember { mutableStateOf(TextFieldValue()) }
            val inputSurnameValue = remember { mutableStateOf(TextFieldValue()) }
            val inputEmailValue = remember { mutableStateOf(TextFieldValue()) }
            val inputPhoneValue = remember { mutableStateOf(TextFieldValue()) }
            val inputPasswordValue = remember { mutableStateOf(TextFieldValue()) }
            val inputPasswordVerificationValue = remember { mutableStateOf(TextFieldValue()) }


            Box(contentAlignment = Alignment.CenterStart) {
                Row {
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = inputNameValue.value,
                        onValueChange = { inputNameValue.value = it },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedLabelColor = Color.Black
                        ),
                        label = { Text(text = "Name") },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default
                        )
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = inputSurnameValue.value,
                        onValueChange = { inputSurnameValue.value = it },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedLabelColor = Color.Black
                        ),
                        label = { Text(text = "Surname") },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = inputEmailValue.value,
                onValueChange = { inputEmailValue.value = it },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedLabelColor = Color.Black
                ),
                label = { Text(text = "Email") },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                ),
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = inputPhoneValue.value,
                onValueChange = { inputPhoneValue.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedLabelColor = Color.Black
                ),
                label = { Text(text = "Phone") },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = inputPasswordValue.value,
                onValueChange = { inputPasswordValue.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedLabelColor = Color.Black
                ),
                label = { Text(text = "Password") },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = inputPasswordVerificationValue.value,
                onValueChange = { inputPasswordVerificationValue.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedLabelColor = Color.Black
                ),
                label = { Text("Password") },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )

        }
        Column(
            modifier = Modifier.padding(25.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(
                onClick = { navController.navigate(Routes.Home.route) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Register",style = TextStyle(
                    color = Color.White
                ))
            }
            Box {
                ClickableText(
                    text = AnnotatedString("Login in"),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(20.dp),
                    onClick = { navController.navigate(Routes.Login.route) },
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default,
                        textDecoration = TextDecoration.Underline,
                        color = Purple700
                    )
                )
            }

        }
    }
}
