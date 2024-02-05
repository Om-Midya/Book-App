package com.example.bookharborexchange.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.bookharborexchange.R
import com.example.bookharborexchange.model.Book
import java.lang.Integer.parseInt

@Composable
fun BookInfo(book: Book) {
    Column {
        Box(
            modifier = Modifier
        ) {
            Surface(
                modifier = Modifier
                    .height(250.dp),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cover1),
                        contentDescription = "Null",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(175.dp)
                            .blur(
                                radiusX = 10.dp,
                                radiusY = 10.dp,
                                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(3.dp))
                            )
                            .padding(3.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(275.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cover1),
                    contentDescription = "Null",
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(150.dp)
                        .padding(start = 20.dp, bottom = 10.dp),
                    alignment = Alignment.BottomStart
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 125.dp, top = 170.dp, bottom = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = book.title,
                            fontSize = 20.sp,
                        )
                        Text(
                            text = book.author,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Ratings: ${book.rating}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
        Text(
            text = book.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Blue)
                .fillMaxWidth(.8f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            contentAlignment = Alignment.CenterStart
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                book.tags.forEach { tag ->
                    Surface(
                        color = Color.LightGray, // Change this to your preferred color
                        shape = RoundedCornerShape(4.dp), // Change this to your preferred corner radius
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(
                            text = tag,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Blue)
                .fillMaxWidth(.8f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = "POSTED BY"
                )
                Text(
                    text = book.user,
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Blue)
                .fillMaxWidth(.8f)
        )
//        Box(
//            modifier = Modifier
//                .fillMaxHeight(),
//            contentAlignment = Alignment.BottomCenter
//        ) {
//            Button(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                onClick = {
//                    /*TODO*/
//                }
//            ) {
//                Text(
//                    text = "Borrow This Book",
//                    fontSize = 18.sp
//                )
//            }
//        }
    }
}

@Composable
fun BookDetailsScreen(navController: NavController, currBook: Book) {
    var showDialog by remember { mutableStateOf(false) }
    var borrowDays by remember { mutableStateOf(1f) }

    // Create a mutable state that recomposes the Slider when currBook.noOfDays changes
    val sliderRange by remember { mutableStateOf(1f..currBook.noOfDays.coerceAtLeast(1f)) }




    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Blue,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray
                ), // Change this to your preferred color
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),// Change this to your preferred elevation
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Select the number of days to borrow the book")
                    Slider(
                        value = borrowDays,
                        onValueChange = { borrowDays = it },
                        valueRange = sliderRange, // Use the mutable state here
                        steps = currBook.noOfDays.toInt(), // Set the steps to currBook.NoOfDays
                        enabled = true, // Ensure the Slider is enabled
                        // Ensure the Slider is interactive
                        interactionSource = remember { MutableInteractionSource() },
                        modifier = Modifier
                            .fillMaxWidth() // Ensure the Slider is visible and receiving touch events
                            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { }
                    )
                    Text(text = "Days: ${borrowDays.toInt()}")
                    Button(onClick = {
                        /* Handle borrow book here */
                        showDialog = false
                    }) {
                        Text("Borrow Book")
                    }
                }
            }
        }
    }
    BookInfo(book = currBook)

    Box(
        modifier = Modifier
            .fillMaxHeight(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = { showDialog = true }
        ) {
            Text(
                text = "Borrow This Book",
                fontSize = 18.sp
            )
        }
    }
}