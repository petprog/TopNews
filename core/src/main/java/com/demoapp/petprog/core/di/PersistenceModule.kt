package com.demoapp.petprog.core.di

import android.content.Context
import androidx.room.Room
import com.demoapp.petprog.core.BuildConfig
import com.demoapp.petprog.core.dao.NewsDao
import com.demoapp.petprog.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(db: AppDatabase): NewsDao {
        return db.newsDao()
    }
}
