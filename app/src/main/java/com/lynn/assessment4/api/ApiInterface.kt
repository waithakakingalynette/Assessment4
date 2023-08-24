package com.lynn.assessment4.api

import com.lynn.assessment4.model.Items
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    fun getItems(): Call<List<Items>>
}
