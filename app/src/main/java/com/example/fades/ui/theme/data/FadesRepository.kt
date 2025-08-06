package com.example.fades.ui.theme.data

import com.example.libfades.FadesClient
import com.example.libfades.models.Image
import com.example.libfades.models.Tag
import com.example.libfades.params.Section

class FadesRepository {

    val api = FadesClient.api

    suspend fun getHotFeed(): List<Image>? { // TODO return proper error objet if null
        val response = api.getGalleryResponse(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGalleryResponse(Section.TOP)
        return response.body()?.data
    }

    suspend fun getTagsResponse(): List<Tag>? {
        val response = api.getTagsResponse()
        return response.body()?.data?.tags
    }

    suspend fun  getTagsGallery(tagName: String): List<Image>? {
        val response = api.getTagGallery(tagName)
        return response.body()?.data?.items
    }

}