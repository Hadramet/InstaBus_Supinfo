package com.supinfoa3andm.instabus.ui.main
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.supinfoa3andm.instabus.R
import com.supinfoa3andm.instabus.utilities.FileHelpers
import com.supinfoa3andm.instabus.utilities.LOG_INSTABUS

class MainViewModel (application: Application) : AndroidViewModel(application) {
    // TODO: Implement ViewModel instead of AndroidViewModel
    init {
        val text = FileHelpers.getFileFromResources(application, R.raw.bus_data)
        Log.i(LOG_INSTABUS, text.toString())
    }
}

