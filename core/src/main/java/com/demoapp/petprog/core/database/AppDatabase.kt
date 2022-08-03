package com.demoapp.petprog.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demoapp.petprog.core.BuildConfig
import com.demoapp.petprog.core.dao.NewsDao
import com.demoapp.petprog.core.database.converter.NewsConverter

@Database(
    entities = [NewsDb::class],
    version = BuildConfig.DATABASE_VERSION,
    exportSchema = BuildConfig.DATABASE_EXPORT_SCHEMA
)
@TypeConverters(NewsConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}