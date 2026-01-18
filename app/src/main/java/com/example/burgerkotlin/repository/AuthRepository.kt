package com.example.burgerkotlin.repository

import com.example.burgerkotlin.model.LoginRequest
import com.example.burgerkotlin.model.RegisterRequest
import com.example.burgerkotlin.network.RetrofitClient

class AuthRepository {

    suspend fun login(email: String, password: String) =
        RetrofitClient.api.login(
            LoginRequest(email, password)
        )

    suspend fun register(
        name: String,
        email: String,
        password: String,
        phone: String?,
        address: String?
    ) =
        RetrofitClient.api.register(
            RegisterRequest(name, email, password, phone, address)
        )
}
