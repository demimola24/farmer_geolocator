package com.example.farmerapp.ui.farmer

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmerapp.R
import com.example.farmerapp.db.entity.Farmer
import com.example.farmerapp.ui.base.BaseFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.SphericalUtil
import com.schibstedspain.leku.locale.SearchZoneRect
import kotlinx.android.synthetic.main.fragment_new_farm.*

class NewFarmerFragment : BaseFragment() {
    override val showToolBar: Boolean
        get() = true

    var cordOne : LatLng? = null
    var cordTwo : LatLng? = null
    var cordThree : LatLng? = null
    var cordFour : LatLng? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_farm, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            Log.d("RESULT****", "OK ${data.toString()}")
            when (requestCode){
                3 -> {
                    val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                    val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                    til_cord_one.editText?.setText("$latitude,$longitude")
                    cordOne = LatLng(latitude,longitude)
                }
                4 -> {
                    val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                    val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                    til_cord_two.editText?.setText("$latitude,$longitude")
                    cordTwo = LatLng(latitude,longitude)
                }
                5 -> {
                    val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                    val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                    til_cord_three.editText?.setText("$latitude,$longitude")
                    cordThree = LatLng(latitude,longitude)
                }
                6 -> {
                    val latitude = data.getDoubleExtra(LATITUDE, 0.0)
                    val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
                    til_cord_four.editText?.setText("$latitude,$longitude")
                    cordFour = LatLng(latitude,longitude)
                }

            }
//             if (requestCode == 2) {
//                Log.d("requestCode****", "2")
//                val latitude = data.getDoubleExtra(com.example.farmerapp.ui.farmer.LATITUDE, 0.0)
//                Log.d("LATITUDE****", latitude.toString())
//                val longitude = data.getDoubleExtra(com.example.farmerapp.ui.farmer.LONGITUDE, 0.0)
//                Log.d("LONGITUDE****", longitude.toString())
//                val address = data.getStringExtra(com.example.farmerapp.ui.farmer.LOCATION_ADDRESS)
//                Log.d("ADDRESS****", address.toString())
//                val lekuPoi = data.getParcelableExtra<LekuPoi>(com.example.farmerapp.ui.farmer.LEKU_POI)
//                Log.d("LekuPoi****", lekuPoi.toString())
//            }
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

        btn_cord_one.setOnClickListener {
            startActivityForResult(locationPickerIntent, 3)
        }
        btn_cord_two.setOnClickListener {
            startActivityForResult(locationPickerIntent, 4)
        }
        btn_cord_three.setOnClickListener {
            startActivityForResult(locationPickerIntent, 5)
        }
        btn_cord_four.setOnClickListener {
            startActivityForResult(locationPickerIntent, 6)
        }
        btn_proceed.setOnClickListener {
            gotoSaveFragment()
        }

    }

    private fun gotoSaveFragment() {
        val name = til_name.editText?.text.toString()
        val number = til_number.editText?.text.toString()
        val farmName = til_farm_name.editText?.text.toString()
        val farmLocation = til_location.editText?.text.toString()

        if(name.isEmpty()){
            showErrorDialog("Invalid Name")
            return
        }
        if(number.isEmpty()){
            showErrorDialog("Invalid Number")
            return
        }
        if(farmName.isEmpty()){
            showErrorDialog("Invalid Farm Name")
            return
        }
        if(farmLocation.isEmpty()){
            showErrorDialog("Invalid Location")
            return
        }
        if(cordOne==null||cordTwo==null||cordThree==null||cordFour==null){
            showErrorDialog("All coordinates of your farm are required")
            return
        }
        val listLagLong: List<LatLng?> = listOf(cordOne,cordTwo,cordThree,cordFour)
        val area = SphericalUtil.computeArea(listLagLong)
        val farmerDetails = Farmer(id = 0,name =name,number = number,pictureUrl = "",farmName = farmName,farmLocation = farmLocation,farmArea = area,farmLatLong = listLagLong)

         val action = NewFarmerFragmentDirections.actionNewFarmFragmentToSaveFarmFragment(farmerDetails)
          findNavController().navigate(action)
    }


}