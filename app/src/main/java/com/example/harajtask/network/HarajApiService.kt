package com.example.harajtask.network

import com.example.harajtask.models.ProductNetwork
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

//the github shortened file link that points to the forked repo's json file will act as a mock API https://git.io/JStXV
private const val BASE_URL = "https://git.io/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HarajApiService {

    @GET("JStXV")
    suspend fun getProducts(): String

}

object HarajApi {
    val retrofitService: HarajApiService by lazy {
        retrofit.create(HarajApiService::class.java)
    }
}