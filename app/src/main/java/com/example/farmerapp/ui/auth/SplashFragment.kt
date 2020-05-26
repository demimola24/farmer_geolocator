package com.example.farmerapp.ui.auth

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment

import javax.inject.Inject

class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onStart() {
        super.onStart()
        //findNavController().navigate(R.id.action_splashFragment_to_onBoardFragment)
    }
}
