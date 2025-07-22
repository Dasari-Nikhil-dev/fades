package com.example.libfadesTest

import com.example.libfades.EndPoints.FadesAPIV3
import okhttp3.OkHttpClient
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FadesAPIV3Test {


    private val okkHttpClient =  OkHttpClient.Builder()
        .addInterceptor{
            val request = it.request().newBuilder()
                .addHeader("Authorization", "Client-ID 16abb74c6e5c7e8")
                .build()
            it.proceed(request)
        }
        .build()


    private val retrofit = Retrofit.Builder()
        .client(okkHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()

    val api  = retrofit.create(FadesAPIV3::class.java)

    @Test
    fun isTagResponseWorking() {
        val response = api.getTagResponse().execute()
        assertNotNull(response.body())
    }

    @Test
    fun isGalleryResponseWorking() {
        val response = api.getGalleryResponse().execute()
        assertNotNull(response.body())
    }

}