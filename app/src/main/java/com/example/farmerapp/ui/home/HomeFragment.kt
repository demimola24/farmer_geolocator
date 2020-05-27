package com.example.farmerapp.ui.home

import android.app.Activity
import android.content.Intent
import android.location.Address
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment
import com.google.android.gms.maps.model.LatLng
import com.schibstedspain.leku.*
import com.schibstedspain.leku.locale.SearchZoneRect
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override val showToolBar: Boolean
        get() = true

    private val viewModel by viewModels<HomeViewModel> { viewModelProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAnalyticValues()


        fab_new_farm.setOnClickListener {
            gotoNewFarm()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(viewModel){
            latestFarmerEvent.observe(viewLifecycleOwner, Observer {uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                  if(it.isNotEmpty()){
                      tv_most_recent_text.text = it.first().name
                  }
                }
            })
            biggestFarmerEvent.observe(viewLifecycleOwner, Observer {uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    if(it.isNotEmpty()){
                        tv_biggest_farm_value.text = it.first().farmName
                        tv_biggest_farm_area.text = "${it.first().farmArea.toInt()} sqm"
                    }
                }
            })
            farmerCountEvent.observe(viewLifecycleOwner, Observer {uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    tv_farm_count_value.text = it.toString()
                }
            })

        }
    }

    private fun gotoNewFarm() {
          findNavController().navigate(R.id.newFarmFragment)
    }

}