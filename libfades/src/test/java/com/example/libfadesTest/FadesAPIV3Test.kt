package com.example.libfadesTest

import com.example.libfades.FadesClient
import com.example.libfades.params.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class FadesAPIV3Test {

    val api = FadesClient.api

    @Test
    fun isTagResponseWorking() = runBlocking {
        val response = api.getTagResponse()
        assertNotNull(response.body())
    }

    @Test
    fun isGalleriesHotWorking() = runBlocking {
        val response = api.getGalleryResponse(Section.HOT)
        assertNotNull(response.body())
    }

    @Test
    fun isGalleriesTopworking() = runBlocking {
        val response = api.getGalleryResponse(Section.TOP)
        assertNotNull(response.body())
    }

}