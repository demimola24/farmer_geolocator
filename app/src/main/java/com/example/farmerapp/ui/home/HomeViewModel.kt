package com.example.farmerapp.ui.home

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmerapp.db.Repository
import com.example.farmerapp.db.entity.Farmer
import com.example.farmerapp.event.UIEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel
@Inject internal constructor(private val repo: Repository) : ViewModel() {

    private val _getLatestFarmer = MutableLiveData<UIEvent<List<Farmer>>>()
    val  latestFarmerEvent: LiveData<UIEvent<List<Farmer>>> = _getLatestFarmer

    private val _getBiggestFarmer = MutableLiveData<UIEvent<List<Farmer>>>()
    val  biggestFarmerEvent: LiveData<UIEvent<List<Farmer>>> = _getBiggestFarmer

    private val _farmerCount = MutableLiveData<UIEvent<Int>>()
    val  farmerCountEvent: LiveData<UIEvent<Int>> = _farmerCount


    fun getAnalyticValues() {
        viewModelScope.launch {
            Log.d("HomeViewModel","getAnalyticValues ....")
            try {
                val latestFarmer = repo.getLatestFarmer()
                _getLatestFarmer.value = UIEvent(latestFarmer)

                val biggestFarmer = repo.getBiggestFarmer()
                Log.d("HomeViewModel","getAnalyticValues ....$biggestFarmer")

                _getBiggestFarmer.value = UIEvent(biggestFarmer)


                val count = repo.getFarmerCount()
                Log.d("HomeViewModel","getAnalyticValues ....$count")

                _farmerCount.value = UIEvent(count)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}
