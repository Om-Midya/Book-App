package com.example.bookharborexchange.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.bookharborexchange.DataManager
import com.example.bookharborexchange.model.Book
import com.google.gson.Gson
import java.io.File
import java.io.FileWriter
import java.util.UUID

@Composable
fun AddBookScreen(navController: NavController, context: Context) {
    var bookName by remember { mutableStateOf("") }
    var bookAuthor by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var bookDescription by remember { mutableStateOf("") }
    var bookRating by remember { mutableStateOf("") }
    var bookGenresString by remember { mutableStateOf("") }
    var bookImage by remember { mutableStateOf("") }
    var availableFor by remember { mutableStateOf("") }

    var scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Add New Book",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = bookName,
            onValueChange = { bookName = it },
            label = {
                Text("Book Name")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bookAuthor,
            onValueChange = { bookAuthor = it },
            label = {
                Text("Book Author")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = userName,
            onValueChange = { userName = it }, label = {
                Text("User Name")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bookDescription,
            onValueChange = { bookDescription = it },
            label = {
                Text("Short Description of the book")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bookGenresString,
            onValueChange = { bookGenresString = it },
            label = {
                Text("Book Genres (separated by commas)")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bookImage,
            onValueChange = { bookImage = it },
            label = {
                Text("Book Image URL")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bookRating,
            onValueChange = { bookRating = it },
            label = {
                Text("Average Book Ratings")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = availableFor,
            onValueChange = { availableFor = it },
            label = {
                Text("How Many Days do you want to lend?")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Add the book to the list
            val bookGenres = bookGenresString.split(",").map { it.trim() }

            val book = Book(
                id = UUID.randomUUID().toString(),
                title = bookName,
                author = bookAuthor,
                imgUrl = bookImage,
                rating = bookRating.toFloat(),
                user = userName,
                tags = bookGenres,
                description = bookDescription,
                isAvailable = true,
                noOfDays = availableFor.toFloat()
            )

            bookList.add(book)

            // Redirect to the home screen
            navController.popBackStack()
        }) {
            Text("Submit")
        }
    }
}

fun appendBookJsonToFile(context: Context,bookJson: String) {
    Thread{
        val file = File(context.filesDir, "books.json")
        val fileWriter = FileWriter(file, true)

        fileWriter.append(bookJson)
        fileWriter.append("\n")

        fileWriter.close()
    }.start()
}
