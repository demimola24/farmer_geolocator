package com.example.farmerapp.ui.home

import android.app.Activity
import android.content.Intent
import android.location.Address
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment
import com.google.android.gms.maps.model.LatLng
import com.schibstedspain.leku.*
import com.schibstedspain.leku.locale.SearchZoneRect
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override val showToolBar: Boolean
        get() = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            Log.d("RESULT****", "OK ${data.toString()}")
            if (requestCode == 8) {
                val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                Log.d("LATITUDE****", " $latitude")
                val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                Log.d("LONGITUDE****", ""+longitude.toString())
                val address = data.getStringExtra(LOCATION_ADDRESS)
                Log.d("ADDRESS****", " $address")
                val postalcode = data.getStringExtra(ZIPCODE)
                Log.d("POSTALCODE****", " $postalcode")
                val bundle = data.getBundleExtra(TRANSITION_BUNDLE)
                Log.d("BUNDLE TEXT****", " ${bundle?.getString("test")}")
                val fullAddress = data.getParcelableExtra<Address>(ADDRESS)
                if (fullAddress != null) {
                    Log.d("FULL ADDRESS****", " $fullAddress")
                }
            } else if (requestCode == 2) {
                Log.d("requestCode****", "2")
                val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                Log.d("LATITUDE****", latitude.toString())
                val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                Log.d("LONGITUDE****", longitude.toString())
                val address = data.getStringExtra(LOCATION_ADDRESS)
                Log.d("ADDRESS****", address.toString())
                val lekuPoi = data.getParcelableExtra<LekuPoi>(LEKU_POI)
                Log.d("LekuPoi****", lekuPoi.toString())
            }
        }
        if (resultCode == Activity.RESULT_CANCELED) {
            Log.d("RESULT****", "CANCELLED")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val locationPickerIntent = LocationPicker2Activity.Builder()
            .withLocation(6.5244, 3.3792)
            .withGeolocApiKey("AIzaSyD5sNn8uszUtuMRYqyghpOlEopxMJ5q4H4")
            .withSearchZone("es_NG")
            .withSearchZone(SearchZoneRect(LatLng(6.1256, 1.2254), LatLng(15.4542, 18.7322)))
            .withDefaultLocaleSearchZone()
            .shouldReturnOkOnBackPressed()
            .withStreetHidden()
            .withCityHidden()
            .withZipCodeHidden()
            .withSatelliteViewHidden()
            .withGoogleTimeZoneEnabled()
            .withVoiceSearchHidden()
            .withGooglePlacesApiKey("AIzaSyD5sNn8uszUtuMRYqyghpOlEopxMJ5q4H4")
            .withUnnamedRoadHidden()
            .build(requireContext())

        btn_new_farm.setOnClickListener {
            startActivityForResult(locationPickerIntent, 8)
        }

    }

    private fun gotoAuthSignIn() {
        //  findNavController().navigate(direction)
    }

}