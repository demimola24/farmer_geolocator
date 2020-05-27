package com.example.farmerapp.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.farmerapp.db.entity.Farmer

@Dao
interface FarmerDao {
    @Query("SELECT * FROM farmer ORDER BY farmArea DESC LIMIT 1")
    suspend fun getBiggestFarmer(): List<Farmer>

    @Query("SELECT * FROM farmer ORDER BY id DESC LIMIT 1")
    suspend fun getLatestFarmer(): List<Farmer>

    @Query("SELECT COUNT(*) FROM farmer")
    suspend fun getFarmerCount(): Int

    @Insert
    suspend fun insert(users: Farmer)

    @Delete
    suspend fun delete(user: Farmer)

}