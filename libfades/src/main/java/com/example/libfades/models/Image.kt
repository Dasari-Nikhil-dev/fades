package com.example.libfades.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

    @JsonClass(generateAdapter = true)
    data class Image(
        @Json(name = "account_id")
        val accountId: Any?,
        @Json(name = "account_url")
        val accountUrl: Any?,
        @Json(name = "ad_type")
        val adType: Int?,
        @Json(name = "ad_url")
        val adUrl: String?,
        @Json(name = "animated")
        val animated: Boolean?,
        @Json(name = "bandwidth")
        val bandwidth: Long?,
        @Json(name = "comment_count")
        val commentCount: Any?,
        @Json(name = "datetime")
        val datetime: Int?,
        @Json(name = "description")
        val description: String?,
        @Json(name = "downs")
        val downs: Any?,
        @Json(name = "edited")
        val edited: String?,
        @Json(name = "favorite")
        val favorite: Boolean?,
        @Json(name = "favorite_count")
        val favoriteCount: Any?,
        @Json(name = "gifv")
        val gifv: String?,
        @Json(name = "has_sound")
        val hasSound: Boolean?,
        @Json(name = "height")
        val height: Int?,
        @Json(name = "hls")
        val hls: String?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "in_gallery")
        val inGallery: Boolean?,
        @Json(name = "in_most_viral")
        val inMostViral: Boolean?,
        @Json(name = "is_ad")
        val isAd: Boolean?,
        @Json(name = "link")
        val link: String?,
        @Json(name = "mp4")
        val mp4: String?,
        @Json(name = "mp4_size")
        val mp4Size: Int?,
        @Json(name = "nsfw")
        val nsfw: Any?,
        @Json(name = "points")
        val points: Any?,
        @Json(name = "processing")
        val processing: Processing?,
        @Json(name = "score")
        val score: Any?,
        @Json(name = "section")
        val section: Any?,
        @Json(name = "size")
        val size: Int?,
        @Json(name = "tags")
        val tags: List<Any?>?,
        @Json(name = "title")
        val title: Any?,
        @Json(name = "type")
        val type: String?,
        @Json(name = "ups")
        val ups: Any?,
        @Json(name = "views")
        val views: Int?,
        @Json(name = "vote")
        val vote: Any?,
        @Json(name = "width")
        val width: Int?
    ) {
        @JsonClass(generateAdapter = true)
        data class Processing(
            @Json(name = "status")
            val status: String?
        )
    }