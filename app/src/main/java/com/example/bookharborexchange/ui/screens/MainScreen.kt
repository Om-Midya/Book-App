package com.example.bookharborexchange.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookharborexchange.DataManager
import com.example.bookharborexchange.ui.components.BookList

@Composable
fun MainScreen(navController: NavController) {
    BookList(books = DataManager.data, navController = navController)
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

