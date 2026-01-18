package com.example.burgerkotlin.model

data class CreateOrderRequest(
    val user_id: Int,
    val delivery_address: String,
    val notes: String? = null,
    val total_price: Double
)

data class Order(
    val id: Int,
    val total_price: Double,
    val status: String,
    val delivery_address: String,
    val created_at: String
)

data class OrderListResponse(
    val total: Int,
    val orders: List<Order>
)

data class UpdateStatusRequest(
    val order_id: Int,
    val status: String
)
