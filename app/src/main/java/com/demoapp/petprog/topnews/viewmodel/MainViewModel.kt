package com.demoapp.petprog.topnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demoapp.petprog.common.util.ViewStateStatus
import com.demoapp.petprog.core.model.News
import com.demoapp.petprog.core.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject
constructor(private val repo: NewsRepository) : ViewModel() {

    private val _headlineState = MutableStateFlow<ViewStateStatus<List<News>>>(ViewStateStatus.Idle)
    val headlineState: StateFlow<ViewStateStatus<List<News>>>
        get() = _headlineState

    init {
        getHeadline()
    }

    fun getHeadline(isRefresh: Boolean = false) {
        viewModelScope.launch {
            repo.getHeadline(isRefresh).collectLatest {
                _headlineState.tryEmit(it)
            }
        }
    }


}