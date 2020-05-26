package com.example.farmerapp.db

import com.example.farmerapp.db.database.AppDatabase
import com.example.farmerapp.db.database.DatabaseHelper
import com.example.farmerapp.db.entity.Farmer

class Repository(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<Farmer> = appDatabase.farmerDao().getAll()

    override suspend fun insert(user: Farmer) = appDatabase.farmerDao().insert(user)

}