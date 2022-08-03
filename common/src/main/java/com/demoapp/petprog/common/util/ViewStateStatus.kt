package com.demoapp.petprog.common.util

sealed class ViewStateStatus<out R> {
    object Idle : ViewStateStatus<Nothing>()
    object Loading : ViewStateStatus<Nothing>()
    data class Success<out T>(val data: T) : ViewStateStatus<T>()
    data class Error(val errorCode: ErrorCode?) : ViewStateStatus<Nothing>()
}