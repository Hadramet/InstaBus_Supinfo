package com.supinfoa3andm.instabus.models

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.supinfoa3andm.instabus.utilities.FileHelpers

class NearStationRepository (val app : Application)
{
    val stations = MutableLiveData<List<Nearstation>>()

    init {
        getNearStation()
    }

    fun getNearStation ()
    {
        val text = FileHelpers.getFileFromAssets(app,"bus_data.json");
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter : JsonAdapter<Response> = moshi.adapter(Response::class.java).nonNull()

        stations.value =  adapter.fromJson(text)?.data?.nearstations
    }
}
