package com.lynn.assessment4.repository

import com.lynn.assessment4.api.ApiClient
import com.lynn.assessment4.api.ApiInterface
import com.lynn.assessment4.model.Items
import retrofit2.Call
import retrofit2.Response

class ItemRepo {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun getItems(): Call<List<Items>> {
        return apiClient.getItems()
    }
}