package com.example.farmerapp.configs

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.farmerapp.FarmerApp


/**
 * @author Demimola on 28/01/2020
 * for MyFarmerApp
 **/
fun Activity.coreComponent() = FarmerApp.coreComponent(this)

fun Fragment.coreComponent() = FarmerApp.coreComponent(requireContext())