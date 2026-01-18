package com.example.burgerkotlin.ui.role.admin.main.order_management

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burgerkotlin.model.MenuModels
import com.example.burgerkotlin.model.MenuResponse
import com.example.burgerkotlin.repository.MenuRepository
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val repo = MenuRepository()

    fun menuCreate(menu: MenuModels, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = repo.menuCreate(menu)
                if (response.isSuccessful) {
                    onResult(true, "Menu berhasil ditambahkan")
                } else {
                    onResult(false, "Data tidak lengkap")
                }
            } catch (e: Exception) {
                onResult(false, "$e")
            }
        }
    }

    fun getMenu(onResult: (Boolean, List<MenuResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = repo.getMenu()

                if (response.isSuccessful) {
                    val data = response.body() ?: emptyList()
                    Log.d("CEK", "$data")
                    onResult(true, data)
                } else {
                    Log.d("CEK", "data")
                    onResult(false, emptyList())
                }

            } catch (e: Exception) {
                Log.d("CEK", "data")
                onResult(false, emptyList())
            }
        }
    }
}
