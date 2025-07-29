package com.example.libfades.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdConfig(
    @Json(name = "highRiskFlags")
    val highRiskFlags: List<Any?>?,
    @Json(name = "high_risk_flags")
    val highRiskFlags1: List<Any?>?,
    @Json(name = "nsfw_score")
    val nsfwScore: Double?,
    @Json(name = "safeFlags")
    val safeFlags: List<String?>?,
    @Json(name = "safe_flags")
    val safeFlags1: List<String?>?,
    @Json(name = "showAdLevel")
    val showAdLevel: Int?,
    @Json(name = "show_ad_level")
    val showAdLevel1: Int?,
    @Json(name = "show_ads")
    val showAds: Boolean?,
    @Json(name = "showsAds")
    val showsAds: Boolean?,
    @Json(name = "unsafeFlags")
    val unsafeFlags: List<String?>?,
    @Json(name = "unsafe_flags")
    val unsafeFlags1: List<String?>?,
    @Json(name = "wallUnsafeFlags")
    val wallUnsafeFlags: List<String?>?,
    @Json(name = "wall_unsafe_flags")
    val wallUnsafeFlags1: List<String?>?
)
