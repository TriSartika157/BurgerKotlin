package com.example.burgerkotlin.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone: String? = null,
    val address: String? = null
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String?,
    val address: String?,
    val role: String
)

data class LoginResponse(
    val message: String,
    val user: User
)
