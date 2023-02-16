package com.example.rsr_library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rsr_library.theme.RSRSDKTheme
import com.example.rsr_sdk.ui.theme.SearchAppBar

class DummyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSRSDKTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    SearchAppBar(
                        value = "",
                        onValueChange = {},
                        onCancel = {},
                        onSearch = {},
                        onSelect = {},
                        placeholderText = "Type here.."
                    )

                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Suggested Venues",
                        fontWeight = Bold
                    )

                    VenueList(venues)

                }
            }
        }
    }
}

data class Venues(val title: String, val subtitle: String)
val venues = listOf(
    Venues("Bayou Music Center", "520 Texas Ave , Houston , TX 77002"),
    Venues("George R. Brown Convention Center", "1001 Avenida De Las Americas, Houston, TX 77010"),
    Venues("The Hobby Center for the Performing Arts", "800 Bagby Street, Houston , TX 77002"),
    Venues("Toyota Center", "1510 Polk St, Houston, TX 77002"),
    Venues("Wortham Theater Center", "501 Texas Ave, Houston, TX 77002"),

    Venues("Bayou Music Center", "520 Texas Ave , Houston , TX 77002"),
    Venues("George R. Brown Convention Center", "1001 Avenida De Las Americas, Houston, TX 77010"),
    Venues("The Hobby Center for the Performing Arts", "800 Bagby Street, Houston , TX 77002"),
    Venues("Toyota Center", "1510 Polk St, Houston, TX 77002"),
    Venues("Wortham Theater Center", "501 Texas Ave, Houston, TX 77002"),

    Venues("Bayou Music Center", "520 Texas Ave , Houston , TX 77002"),
    Venues("George R. Brown Convention Center", "1001 Avenida De Las Americas, Houston, TX 77010"),
    Venues("The Hobby Center for the Performing Arts", "800 Bagby Street, Houston , TX 77002"),
    Venues("Toyota Center", "1510 Polk St, Houston, TX 77002"),
    Venues("Wortham Theater Center", "501 Texas Ave, Houston, TX 77002"),

    Venues("Bayou Music Center", "520 Texas Ave , Houston , TX 77002"),
    Venues("George R. Brown Convention Center", "1001 Avenida De Las Americas, Houston, TX 77010"),
    Venues("The Hobby Center for the Performing Arts", "800 Bagby Street, Houston , TX 77002"),
    Venues("Toyota Center", "1510 Polk St, Houston, TX 77002"),
    Venues("Wortham Theater Center", "501 Texas Ave, Houston, TX 77002"),
)

@Composable
fun VenueList(students: List<Venues>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        students.forEach { student ->
            StudentRow(student)
        }
    }
}

@Composable
fun StudentRow(student: Venues) {
    Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)) {
        Text(student.title, fontSize = 18.sp)
        Text(student.subtitle, color = Color.Gray)
    }
}