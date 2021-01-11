package com.supinfoa3andm.instabus.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data (
    val nearstations: List<Nearstation>,
    val transport: Transport
)

