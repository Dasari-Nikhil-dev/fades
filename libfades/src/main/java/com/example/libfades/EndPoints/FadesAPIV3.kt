package com.example.libfades.EndPoints

import com.example.libfades.models.GalleryResponse
import com.example.libfades.models.TagResponse
import com.example.libfades.models.TagsResponse
import com.example.libfades.params.Section
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FadesAPIV3 {

    @GET("tags")
    suspend fun getTagsResponse() : Response<TagsResponse>

    @GET("gallery/{section}")   // TODO use Path Params
    suspend fun getGalleryResponse(
        @Path("section") section: Section,
        @Query("album-previews") albumPreviews: Boolean = true
    ) : Response<GalleryResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag: String
    ): Response<TagResponse>
}