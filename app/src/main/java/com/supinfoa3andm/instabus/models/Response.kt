package com.supinfoa3andm.instabus.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    val code: Long,
    val data: Data
)
{
    override fun toString(): String {
        return "Respone[data=$data, code=$code]"
    }
}


