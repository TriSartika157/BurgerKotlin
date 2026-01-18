package com.example.burgerkotlin.model

data class MenuResponse (
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val image_url: String
)