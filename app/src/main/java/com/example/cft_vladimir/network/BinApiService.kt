package com.example.cft_vladimir.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://lookup.binlist.net"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BinApiService {
    @GET("55369138")
    suspend fun getBinAnswer() : String
}

object BinApi {
    val retrofitService : BinApiService by lazy {
        retrofit.create(BinApiService::class.java) }

}