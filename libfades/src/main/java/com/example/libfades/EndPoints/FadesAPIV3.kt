package com.example.libfades.EndPoints

import com.example.libfades.models.GalleryResponse
import com.example.libfades.models.TagsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FadesAPIV3 {

    @GET("tags")
    fun getTagResponse() : Call<TagsResponse>

    @GET("gallery/hot?album_previews=true")   // TODO use Path Params
    fun getGalleryResponse() : Call<GalleryResponse>
}