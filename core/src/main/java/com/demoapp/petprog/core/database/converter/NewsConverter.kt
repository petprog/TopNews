package com.demoapp.petprog.core.database.converter

import androidx.room.TypeConverter
import com.demoapp.petprog.core.model.News
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

object NewsConverter {
    var gson = Gson()
    @TypeConverter
    fun stringToTransactionList(data: String?): List<News> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<News>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun TransactionListToString(someObjects: List<News>): String? {
        return gson.toJson(someObjects)
    }
}