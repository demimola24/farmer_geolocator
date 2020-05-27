package com.example.farmerapp.db

import com.example.farmerapp.db.database.AppDatabase
import com.example.farmerapp.db.database.DatabaseHelper
import com.example.farmerapp.db.entity.Farmer

class Repository(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getLatestFarmer(): List<Farmer> = appDatabase.farmerDao().getLatestFarmer()

    override suspend fun getBiggestFarmer(): List<Farmer> = appDatabase.farmerDao().getBiggestFarmer()

    override suspend fun getFarmerCount(): Int = appDatabase.farmerDao().getFarmerCount()

    override suspend fun insert(farmer: Farmer) = appDatabase.farmerDao().insert(farmer)

}