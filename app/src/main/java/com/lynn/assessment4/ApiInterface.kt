package com.lynn.assessment4

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/item")
    fun getItems(): Call<ItemResponse>
}

//package com.lynn.assessment4
//
//import android.telecom.Call
//import retrofit2.http.GET
//
//interface ApiInterface {
//    @GET("/item")
//    fun getItems():Call<ItemResponse>
//
//}