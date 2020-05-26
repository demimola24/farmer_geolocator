package com.example.farmerapp.ui.farmer

import android.app.Activity
import android.content.Intent
import android.location.Address
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment
import com.google.android.gms.maps.model.LatLng
import com.schibstedspain.leku.*
import com.schibstedspain.leku.locale.SearchZoneRect
import kotlinx.android.synthetic.main.fragment_home.*

class SaveFarmerFragment : BaseFragment() {
    override val showToolBar: Boolean
        get() = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_new_farm.setOnClickListener {
            gotoNewFarm()
        }

    }

    private fun gotoNewFarm() {
          findNavController().navigate(R.id.newFarmFragment)
    }

}