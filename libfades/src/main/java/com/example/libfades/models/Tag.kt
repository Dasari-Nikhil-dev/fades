package com.example.libfades.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

    @JsonClass(generateAdapter = true)
    data class Tag(
        @Json(name = "accent")
        val accent: String?,
        @Json(name = "background_hash")
        val backgroundHash: String?,
        @Json(name = "background_is_animated")
        val backgroundIsAnimated: Boolean?,
        @Json(name = "description")
        val description: String?,
        @Json(name = "description_annotations")
        val descriptionAnnotations: DescriptionAnnotations?,
        @Json(name = "display_name")
        val displayName: String?,
        @Json(name = "followers")
        val followers: Int?,
        @Json(name = "following")
        val following: Boolean?,
        @Json(name = "is_promoted")
        val isPromoted: Boolean?,
        @Json(name = "is_whitelisted")
        val isWhitelisted: Boolean?,
        @Json(name = "logo_destination_url")
        val logoDestinationUrl: Any?,
        @Json(name = "logo_hash")
        val logoHash: Any?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "thumbnail_hash")
        val thumbnailHash: String?,
        @Json(name = "thumbnail_is_animated")
        val thumbnailIsAnimated: Boolean?,
        @Json(name = "total_items")
        val totalItems: Int?
    ) {
        @JsonClass(generateAdapter = true)
        class DescriptionAnnotations
    }