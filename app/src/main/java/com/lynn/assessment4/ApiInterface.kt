package com.lynn.assessment4

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    fun getItems(): Call<List<Items>>
}
