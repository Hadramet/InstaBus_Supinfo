@file:Suppress("DEPRECATION")

package com.supinfoa3andm.instabus.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.supinfoa3andm.instabus.R
import kotlinx.android.synthetic.main.main_fragment.*
import java.lang.StringBuilder

@Suppress("DEPRECATION")
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }


    private lateinit var  viewModel: MainViewModel
    val stations = StringBuilder()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.stations.observe(this, Observer{

            for (station in it)
                station.streetName?.let {
                    stations.append(station.streetName + "\n")
                    //Log.i(LOG_INSTABUS, station.streetName)
                }
            message.text = stations
        })
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}