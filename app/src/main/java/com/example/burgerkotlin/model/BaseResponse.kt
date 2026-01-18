package com.example.burgerkotlin.model

data class BaseResponse<T>(
    val message: String? = null,
    val error: String? = null,
    val data: T? = null
)