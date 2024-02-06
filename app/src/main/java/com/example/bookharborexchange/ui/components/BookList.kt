package com.example.bookharborexchange.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bookharborexchange.R
import com.example.bookharborexchange.model.Book
import com.example.bookharborexchange.ui.screens.SearchBar


@Composable
fun BookList(books: List<Book>, navController: NavController){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(books) { book ->
            BookItem(book = book, onClick = {
                navController.navigate("BookDetails/${book.id}")
            })
        }
    }
}