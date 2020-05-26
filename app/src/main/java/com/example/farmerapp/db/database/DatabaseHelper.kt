package com.example.farmerapp.db.database

import com.example.farmerapp.db.entity.Farmer

interface DatabaseHelper {

    suspend fun getUsers(): List<Farmer>

    suspend fun insert(users: Farmer)

}