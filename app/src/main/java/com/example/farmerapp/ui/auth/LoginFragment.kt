package com.example.farmerapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment

class LoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun sleepForAWhile() = Thread.sleep(800)

    private fun gotoAuthSignIn() {
        //  findNavController().navigate(direction)
    }

    override fun onStart() {
        super.onStart()

        //add full screen flags here
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onStop() {
        super.onStop()
        //clear full screen flags here
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}