package com.example.farmerapp.ui.farmer

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

class NewFarmerViewModel
@Inject internal constructor(private val repo: Repository) : ViewModel() {

    private val _saveFarmer = MutableLiveData<UIEvent<Boolean>>()
    val  saveFarmerEvent: LiveData<UIEvent<Boolean>> = _saveFarmer

    fun saveFarmer(farmer: Farmer) {
        viewModelScope.launch {
            Log.d("NewFarmerViewModel","saveFarmer ....")
            try {
                val response = repo.insert(farmer)
                _saveFarmer.value = UIEvent(true)
            } catch (e: Exception) {
                _saveFarmer.value = UIEvent(false)
                e.printStackTrace()
            }

        }
    }
}
