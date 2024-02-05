package com.example.bookharborexchange.model

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val imgUrl: String,
    val rating: Float,
    val user: String,
    val tags: List<String>,
    val description: String,
    val isAvailable: Boolean,
    val noOfDays: Float
)
