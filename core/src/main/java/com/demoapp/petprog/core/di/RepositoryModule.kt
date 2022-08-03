package com.demoapp.petprog.core.di

import NewsRepository
import com.demoapp.petprog.core.dao.NewsDao
import com.demoapp.petprog.core.network.NewsService
import com.demoapp.petprog.common.base.RepositoryI
import com.demoapp.petprog.core.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideNewsRepository(newsDao: NewsDao, newsService: NewsService): RepositoryI {
        return NewsRepository(newsDao, newsService)
    }
}