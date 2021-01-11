package com.supinfoa3andm.instabus.models

import com.supinfoa3andm.instabus.utilities.DEFAULT_DIST
import com.supinfoa3andm.instabus.utilities.DEFAULT_LAT
import com.supinfoa3andm.instabus.utilities.DEFAULT_LON
import retrofit2.http.GET
import retrofit2.http.Path

// lon = 41.3985182
// lat = 2.1917991
// dist = 1
interface BusNearStationService {
    @GET("latlon/{lon}/{lat}/{dist}.json")
    suspend fun getNearStationsData(
        @Path("lon") lon: Double = DEFAULT_LON,
        @Path("lat") lat: Double = DEFAULT_LAT,
        @Path("dist") dist: Int  = DEFAULT_DIST ) : retrofit2.Response<Response>
}