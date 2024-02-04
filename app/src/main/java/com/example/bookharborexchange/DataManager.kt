package com.example.bookharborexchange

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.bookharborexchange.model.Book
import com.google.gson.Gson

object DataManager {
    var data = mutableListOf<Book>()
    var isDataLoaded = mutableStateOf(false)

    fun LoadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("books.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Book>::class.java).toMutableList()
        isDataLoaded.value = true
    }

    fun getBookById(bookId: String?): Book? {
        return data.firstOrNull { it.id == bookId }

    }
}