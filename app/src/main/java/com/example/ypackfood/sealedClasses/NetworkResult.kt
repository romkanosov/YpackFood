package com.example.ypackfood.sealedClasses

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class HandledError<T>(message: String?, data: T? = null) : NetworkResult<T>(message = message, data = data)
    class Error<T>(message: String? = null, data: T? = null) : NetworkResult<T>(message = message, data = data)
    class Loading<T>(data: T? = null) : NetworkResult<T>(data)
    class Empty<T> : NetworkResult<T>()
}
