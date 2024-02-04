package com.example.bookharborexchange.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddBookScreen(navController: NavController) {
    var bookName by remember { mutableStateOf("") }
    var bookAuthor by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var bookDescription by remember { mutableStateOf("") }
    var bookRating by remember { mutableStateOf("") }
    var bookGenre by remember { mutableStateOf(listOf<String>()) }
    var bookImage by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Add New Book", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))
        TextField(value = bookName, onValueChange = { bookName = it }, label = { Text("Book Name") })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = bookAuthor, onValueChange = { bookAuthor = it }, label = { Text("Book Author") })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = userName, onValueChange = { userName = it }, label = { Text("User Name") })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = bookDescription, onValueChange = { bookDescription = it }, label = { Text("Short Description of the book") })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = bookRating, onValueChange = { bookRating = it }, label = { Text("Average Book Ratings") })
        Spacer(modifier = Modifier.height(16.dp))
//        MultiChoiceChip(selectedItems = bookGenre, onSelectedItemsChange = { bookGenre = it }, items = listOf("Genre1", "Genre2", "Genre3", "Genre4", "Genre5"), label = { Text("Genre (Max 4)") })
//        Spacer(modifier = Modifier.height(16.dp))
//        ImagePicker(imageUri = bookImage, onImageUriChange = { bookImage = it })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Handle form submission here */ }) {
            Text("Submit")
        }
    }
}