package com.supinfoa3andm.instabus.models

data class Nearstation (
    val id: String,
    val name: String? = null,
    val lat: String,
    val lon: String,
    val nearbyStations: String? = null,
    val distance: String,
    val streetName: String? = null,
    val city: String? = null,
    val utmX: String? = null,
    val utmY: String? = null,
    val furniture: String? = null,
    val buses: String? = null
)