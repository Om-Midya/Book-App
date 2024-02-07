package com.example.bookharborexchange.ui.screens

import android.content.Context
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookharborexchange.DataManager
import com.example.bookharborexchange.model.Book
import com.example.bookharborexchange.ui.components.BookList
import com.example.bookharborexchange.ui.components.SetStatusBarColor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

var bookList: MutableList<Book> = DataManager.data
@Composable
fun MainScreen(navController: NavController, context: Context) {
    val searchQuery = remember { mutableStateOf("") }



    Column {
        Header()
        BookList(books = bookList, navController = navController)
    }
    AddBookButton(navController = navController)
}

@Composable
fun AddBookButton(navController: NavController){
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Card (
            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(2.dp),
        ){
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add",
                tint = Color.Black,
                modifier = Modifier
                    .background(Color(0xFFcbf5dd))
                    .fillMaxSize()
                    .clickable { navController.navigate("AddBook") }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(){
    SetStatusBarColor(color = Color.White)
    TopAppBar(
        title = {
            Text(
                text = "Book Harbor",
                fontSize = 20.sp,
                fontWeight = Bold,
                modifier = Modifier.padding(10.dp)
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menu",
                tint = Color.Black,
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.padding(end = 10.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.Black,
            titleContentColor = Color.Black,
        )
    )

    val searchQuery = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        TextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            placeholder = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Search",
                        fontSize = 15.sp,
                    )
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
                        tint = Color.Black,
                    )
                }
            },
            modifier = Modifier
                .padding(5.dp)
                .width(300.dp)
                .height(44.dp)
                .clip(RoundedCornerShape(15.dp)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )

        )

        val filteredBooks = DataManager.data.filter { book ->
            book.title.contains(searchQuery.value, ignoreCase = true)
        }

        Text(
            text = "Filter",
            modifier = Modifier
                .padding(end = 10.dp)
                .clickable { }
                .clip(RoundedCornerShape(15.dp))
                .background(Color(0xFFcbf5dd))
                .padding(15.dp),
            color = Color.Black
        )
    }
}




