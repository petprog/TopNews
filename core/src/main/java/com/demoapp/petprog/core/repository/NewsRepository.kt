package com.demoapp.petprog.core.repository

import com.demoapp.petprog.common.base.RepositoryI
import com.demoapp.petprog.core.dao.NewsDao
import com.demoapp.petprog.core.network.NewsService
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val dao: NewsDao,
    private val api: NewsService,
) : RepositoryI {

    init {
        Timber.d("Injection NewsRepository")
    }

}