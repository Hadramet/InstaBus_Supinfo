package com.supinfoa3andm.instabus.models

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.supinfoa3andm.instabus.utilities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("DEPRECATION")
class NearStationRepository (private val app : Application)
{
    val stations = MutableLiveData<List<Nearstation>>()

    // Constructor
    init {
        CoroutineScope(Dispatchers.IO).launch {
            getBusNearStationFromWeb()
        }
    }

    // Get near station from assets
    fun getNearStation ()
    {
        val text = FileHelpers.getFileFromAssets(app,BUS_JSON);
        val mosh = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter : JsonAdapter<Response> = mosh.adapter(Response::class.java)
        stations.value =  adapter.fromJson(text)?.data?.nearstations
    }

    // Call a web service to get the data
    @WorkerThread
    private suspend fun getBusNearStationFromWeb() {
        if (networkAvailable())
        {
            val retrofit = Retrofit.Builder()
                .baseUrl(BUS_WEB_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(BusNearStationService::class.java)
            val serviceData = service.getNearStationsData()
                                        .body()?.data?.nearstations?: emptyList()
            stations.postValue(serviceData)
        }
    }

    // Check if network available
    private fun networkAvailable():Boolean{
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo?.isConnectedOrConnecting ?: false
    }
}

