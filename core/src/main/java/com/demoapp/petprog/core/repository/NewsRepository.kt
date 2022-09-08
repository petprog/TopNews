package com.demoapp.petprog.core.repository

import ErrorResponseMapper
import com.demoapp.petprog.common.base.RepositoryI
import com.demoapp.petprog.common.util.ErrorCode
import com.demoapp.petprog.common.util.ViewStateStatus
import com.demoapp.petprog.core.dao.NewsDao
import com.demoapp.petprog.core.database.NewsDb
import com.demoapp.petprog.core.model.News
import com.demoapp.petprog.core.network.NewsService
import com.skydoves.sandwich.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

    private fun fetchHeadline(): Flow<ViewStateStatus<List<News>>> = flow {
        val result = api.headline()
        result.suspendOnSuccess {
            data.articles!!.let {
                emit(ViewStateStatus.Success(it))
                dao.insert(
                    NewsDb(
                        id = 1,
                        description = "headline",
                        data = it
                    )
                )
            }
        }.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewStateStatus.Error(error))
        }.suspendOnException {
            emit(ViewStateStatus.Error(ErrorCode(1000, message())))
        }
    }.flowOn(Dispatchers.IO)

    fun getHeadline(
        isRefresh: Boolean
    ): Flow<ViewStateStatus<List<News>>> = flow {
        emit(ViewStateStatus.Loading)
        dao.getHeadline().let { dataDb ->
            if (dataDb != null) {
                if (isRefresh) {
                    fetchHeadline().collect { fetch ->
                        emit(fetch)
                    }
                } else {
                    emit(ViewStateStatus.Success(dataDb.data))
                }
            }  else {
                fetchHeadline().collect { fetch ->
                    emit(fetch)
                }
            }
        }
    }.flowOn(Dispatchers.IO)


}