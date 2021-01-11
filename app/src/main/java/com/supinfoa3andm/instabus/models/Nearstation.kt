package com.supinfoa3andm.instabus.models
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Nearstation (
    val id: String,
    val lat: String,
    val lon: String,
    val distance: String,
    @Json(name = "street_name")val streetName: String? = null,
    val city: String? = null,
    @Json(name = "utm_x")val utmX: String? = null,
    @Json(name = "utm_y")val utmY: String? = null,
    val furniture: String? = null,
    val buses: String? = null
)