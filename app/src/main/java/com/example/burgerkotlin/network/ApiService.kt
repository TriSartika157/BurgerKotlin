package com.example.burgerkotlin.network

import com.example.burgerkotlin.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // ================= AUTH =================
    @POST("auth/login.php")
    suspend fun login(
        @Body body: LoginRequest
    ): Response<LoginResponse>

    @POST("auth/register.php")
    suspend fun register(
        @Body body: RegisterRequest
    ): Response<BaseResponse<Unit>>

    // ================= USER =================
    @POST("user/profile.php")
    suspend fun getProfile(
        @Body body: Map<String, Int>
    ): Response<User>

    // ================= ORDER =================
    @POST("order/create.php")
    suspend fun createOrder(
        @Body body: CreateOrderRequest
    ): Response<BaseResponse<Unit>>

    @GET("order/list.php")
    suspend fun getOrders(
        @Query("user_id") userId: Int
    ): Response<OrderListResponse>

    @POST("order/update_status.php")
    suspend fun updateOrderStatus(
        @Body body: UpdateStatusRequest
    ): Response<BaseResponse<Unit>>

    @GET("order/delete.php")
    suspend fun deleteOrder(
        @Query("id") orderId: Int
    ): Response<BaseResponse<Unit>>

    @POST("menu/create.php")
    suspend fun menuCreate(
        @Body body: MenuModels
    ): Response<BaseResponse<Unit>>

    @GET("menu/list.php")
    suspend fun getMenu(): Response<List<MenuResponse>>
}
