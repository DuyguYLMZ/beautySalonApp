package com.dyg.benimkuaforum.screen.commonscreen.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dyg.benimkuaforum.ui.theme.Purple200
import com.dyg.benimkuaforum.ui.theme.Purple40
import com.dyg.benimkuaforum.util.route.Routes
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*


@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppointmentPage(
    navController: NavController,
) {

    val dateScrollState = rememberScrollState()
    val timeScrollState = rememberScrollState()


    val selectedDate = remember {
        mutableStateOf<LocalDate?>(null)
    }

    val selectedTime = remember {
        mutableStateOf<String?>(null)
    }

    var categoryName: String
    var crewName: String
    var appTime: MutableState<String?>
    var appDay: MutableState<LocalDate?>
    var appointmentInfo: Boolean

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            categoryName = Category()
            Spacer(modifier = Modifier.height(8.dp))
            crewName = Teams()
            Spacer(modifier = Modifier.height(8.dp))
            appDay = AppoinmentDay(dateScrollState, selectedDate)
            Spacer(modifier = Modifier.height(8.dp))
            appTime = AppoinmentTime(timeScrollState, selectedTime)
            Spacer(modifier = Modifier.height(20.dp))
            appointmentInfo = AppointmentInfo(categoryName, crewName, appDay, appTime)
            Spacer(modifier = Modifier.height(20.dp))
            if (appointmentInfo)
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Oluştur",
                            style = androidx.compose.ui.text.TextStyle(
                                color = Color.White
                            )
                        )
                    }
                }
        }
    }
}


@Composable
fun AppointmentInfo(
    categoryName: String,
    crewName: String,
    appDay: MutableState<LocalDate?>,
    appTime: MutableState<String?>
): Boolean {
    Column {
        Text(text = "Randevu Bilgileriniz :")
        Text(text = categoryName)
        Text(text = crewName)
        if (appDay.value != null)
            Text(text = "Randevu Günü: " + appDay.value.toString())
        if (appTime.value != null)
            Text(text = "Randevu Saati: " + appTime.value.toString())
    }
    if (categoryName != null && crewName != null && appDay.value != null && appTime.value != null) {
        return true
    }
    return false
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Category(): String {
    val options = listOf(
        "Nail Art",
        "Saç Tasarım",
        "Protez Tırnak",
        "Lazer",
        "Makyaj",
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    var categoryName: String = selectedOptionText
    ExposedDropdownMenuBox(
        expanded = expanded,
        modifier = Modifier
            .background(Color.Transparent)
            .border(width = 1.dp, color = Gray, shape = RoundedCornerShape(8.dp)),
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text("Uzman") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    categoryName = selectionOption
                    Text(text = selectionOption)
                }
            }
        }
    }
    return categoryName
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Teams(): String {
    val options = listOf(
        "Duygu",
        "Süleyman",
        "Besra",
        "Seringül",
        "Dilek",
        "Derin",
        "İdil",
        "Nezire",
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    var crewName: String = selectedOptionText

    ExposedDropdownMenuBox(
        expanded = expanded,
        modifier = Modifier
            .background(Color.Transparent)
            .border(width = 1.dp, color = Gray, shape = RoundedCornerShape(8.dp)),
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text("Uzman") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    crewName = selectionOption
                    Text(text = selectionOption)
                }
            }
        }
    }
    return crewName
}

@Composable
fun AppoinmentDay(
    dateScrollState: ScrollState,
    selectedDate: MutableState<LocalDate?>
): MutableState<LocalDate?> {
    val today = LocalDate.now()
    Text(
        text = "Randevu Günü",
        style = MaterialTheme.typography.subtitle1,
    )
    Row(
        modifier = Modifier.horizontalScroll(dateScrollState),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in 0..365) {
            val date = today.plusDays(i.toLong())
            DateComp(
                date = date, isSelected = today == date
            ) {
                selectedDate.value = it
            }
        }
    }
    return selectedDate
}

@Composable
fun AppoinmentTime(
    timeScrollState: ScrollState,
    selectedTime: MutableState<String?>
): MutableState<String?> {
    Text(
        text = "Randevu Saati",
        style = MaterialTheme.typography.subtitle1,
    )
    Row(
        modifier = Modifier.horizontalScroll(timeScrollState),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in 10..22 step 2) {
            val time = "$i:00"
            TimeComp(
                time = time, isSelected = selectedTime.value == time
            ) {
                selectedTime.value = it
            }
        }
    }
    return selectedTime
}

@Composable
fun TimeComp(
    time: String,
    isSelected: Boolean = false,
    onClick: (String) -> Unit = {},
) {
    val color = when {
        isSelected -> Purple200
        else -> Purple40.copy(alpha = 0.15f)
    }
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onClick(time)
            }, shape = RoundedCornerShape(16.dp), color = color
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(12.dp),
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateComp(
    date: LocalDate,
    isSelected: Boolean = false,
    onClick: (LocalDate) -> Unit = {},
) {
    val color = when {
        isSelected -> Purple200
        else -> Purple40.copy(alpha = 0.15f)
    }
    val textBg = when {
        isSelected -> Color.White
        else -> Color.Transparent
    }
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onClick(date)
            }, shape = RoundedCornerShape(16.dp), color = color
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = date.month.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                style = MaterialTheme.typography.caption
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(textBg)

                    .padding(4.dp),
            ) {
                Text(
                    text = date.dayOfMonth.toString(),
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}
