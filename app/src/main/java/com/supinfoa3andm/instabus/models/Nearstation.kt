package com.supinfoa3andm.instabus.models
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Nearstation (
    val id: String,
    val lat: String,
    val lon: String,
    val distance: String,
    val street_name: String? = null,
    val city: String? = null,
    val utm_x: String? = null,
    val utm_y: String? = null,
    val furniture: String? = null,
    val buses: String? = null
)