package com.example.bookharborexchange.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookharborexchange.R
import com.example.bookharborexchange.model.Book
import java.lang.Integer.parseInt


@Composable
fun BookItem(book: Book, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .height(135.dp)
            .fillMaxWidth(1f)
            .padding(7.dp)
            .clickable { onClick() },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,

        ) {
            BookImage(imgUrl = R.drawable.cover1)
            BookDetails(book.title, book.author, book.user)
        }
    }
}

@Composable
fun BookImage(imgUrl: Int) {
    Image(
        painter = painterResource(id = imgUrl),
        contentDescription = "",
        modifier = Modifier
            .size(120.dp)
            .padding(top = 3.dp, end = 15.dp, bottom = 3.dp)
    )
}

@Composable
fun BookDetails(title: String, author: String, user: String) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(top = 5.dp)
    ) {
        Column {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(end = 5.dp)
            )
            Text(
                text = "by $author",
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }

        Column(modifier = Modifier.padding(bottom = 10.dp)) {
            Text(
                text = "POSTED BY",
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth(1f)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = user,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Borrow",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 15.dp),
                    color = Color.Blue
                )
            }
        }
    }
}


