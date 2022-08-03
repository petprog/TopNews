package com.demoapp.petprog.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demoapp.petprog.core.database.NewsDb

@Dao
interface NewsDao {
    @Query("SELECT * FROM 'news' WHERE id = 1")
    suspend fun getHeadline(): NewsDb?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: NewsDb)

    @Query("DELETE FROM 'news'")
    suspend fun clear()
}