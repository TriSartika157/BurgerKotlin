package com.example.burgerkotlin.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burgerkotlin.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repo = AuthRepository()

    fun login(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = repo.login(email, password)
                if (response.isSuccessful) {
                    onResult(true, "Login berhasil")
                } else {
                    onResult(false, "Login gagal")
                }
            } catch (e: Exception) {
                onResult(false, e.message ?: "Error")
            }
        }
    }
}
