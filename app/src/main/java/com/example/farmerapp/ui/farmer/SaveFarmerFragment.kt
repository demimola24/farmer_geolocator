package com.example.farmerapp.ui.farmer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.PolygonOptions
import kotlinx.android.synthetic.main.fragment_save_fragment.*
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.LatLng


class SaveFarmerFragment : BaseFragment(), OnMapReadyCallback {
    override val showToolBar: Boolean
        get() = true

    private val viewModel by viewModels<NewFarmerViewModel> { viewModelProviderFactory }

    private val args: SaveFarmerFragmentArgs by navArgs()

    private var googleMap: GoogleMap? = null
    private var polygon: Polygon? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val supportMapFragment = childFragmentManager.findFragmentById(R.id.googleMap) as SupportMapFragment
        supportMapFragment.getMapAsync(this)

        btn_proceed.setOnClickListener {
            viewModel.saveFarmer(args.farmerData)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(viewModel){
            saveFarmerEvent.observe(viewLifecycleOwner, Observer {uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    if(it){
                        findNavController().popBackStack(R.id.homeFragment, false)
                    }else{
                        showErrorDialog("Unable to save farmer")
                    }
                }
            })

        }
    }

    private fun getPolygonCenterPoint(polygonPointsList: List<LatLng?>): LatLng {
        var centerLatLng: LatLng? = null
        val builder = LatLngBounds.Builder()
        for (element in polygonPointsList) {
            builder.include(element)
        }
        val bounds = builder.build()
        centerLatLng = bounds.center
        return centerLatLng
    }


    private fun connectPolygon() {
        polygon?.remove()
        val polygonOptions = PolygonOptions().addAll(args.farmerData.farmLatLong).clickable(false)
        polygon = googleMap?.addPolygon(polygonOptions)
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(getPolygonCenterPoint(args.farmerData.farmLatLong), 16.2f))
    }



    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        connectPolygon()
    }

}