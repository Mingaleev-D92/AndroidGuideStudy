package com.example.androidguidestudy.data

/**
 * @author : Mingaleev D
 * @data : 30/10/2022
 */

sealed class DataResponse<T> {
   data class Success<T>(val data: T) : DataResponse<T>()
   data class Error<T>(val error: Throwable) : DataResponse<T>()
}