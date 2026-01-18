package com.example.burgerkotlin.repository

import com.example.burgerkotlin.model.MenuModels
import com.example.burgerkotlin.network.RetrofitClient

class MenuRepository {
    suspend fun menuCreate(menu: MenuModels) =
        RetrofitClient.api.menuCreate(menu)

    suspend fun getMenu() = RetrofitClient.api.getMenu()
}
