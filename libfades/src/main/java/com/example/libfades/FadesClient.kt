package com.example.libfades

import com.example.libfades.EndPoints.FadesAPIV3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object FadesClient {

    const val API_KEY = "16abb74c6e5c7e8"   // TODO Move this To app

    private val httpclient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                val response = it.request().newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()
                it.proceed(response)
            }
            .build()
    }

    private  val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .client(httpclient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val api: FadesAPIV3 by lazy {
        retrofit.create(FadesAPIV3::class.java)
    }

}