package com.demoapp.petprog.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demoapp.petprog.core.model.News

@Entity(tableName = "news")
class NewsDb(
    @PrimaryKey val id: Long,
    val description: String,
    val data: List<News>,
)

