package com.example.ialbumseeker.util

sealed class UIResult<out T> {
    data class Success<out T>(val data: T) : UIResult<T>()
    data class Error(val exception: Exception) : UIResult<Nothing>()
    object Loading : UIResult<Nothing>()
}
