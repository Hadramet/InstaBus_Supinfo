package com.supinfoa3andm.instabus.ui.main
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.supinfoa3andm.instabus.R
import com.supinfoa3andm.instabus.models.NearStationRepository
import com.supinfoa3andm.instabus.models.Response
import com.supinfoa3andm.instabus.utilities.FileHelpers
import com.supinfoa3andm.instabus.utilities.LOG_INSTABUS

class MainViewModel (application: Application) : AndroidViewModel(application) {
    // TODO: Implement ViewModel instead of AndroidViewModel

    private val repo  = NearStationRepository(application)
    val stations = repo.stations
}


