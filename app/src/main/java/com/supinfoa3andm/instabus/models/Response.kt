package com.supinfoa3andm.instabus.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response (
    @Json(name = "code")val code: Long,
    @Json(name = "data")val data: Data
)


