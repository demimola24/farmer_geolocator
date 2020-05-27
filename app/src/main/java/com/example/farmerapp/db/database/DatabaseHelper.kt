package com.example.farmerapp.db.database

import com.example.farmerapp.db.entity.Farmer

interface DatabaseHelper {

    suspend fun getLatestFarmer(): List<Farmer>

    suspend fun getBiggestFarmer(): List<Farmer>

    suspend fun getFarmerCount(): Int

    suspend fun insert(farmer: Farmer)

}