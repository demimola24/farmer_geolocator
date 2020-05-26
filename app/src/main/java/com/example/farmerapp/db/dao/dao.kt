package com.example.farmerapp.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.farmerapp.db.entity.Farmer

@Dao
interface FarmerDao {

    @Query("SELECT * FROM farmer")
    suspend fun getAll(): List<Farmer>

    @Insert
    suspend fun insert(users: Farmer)

    @Delete
    suspend fun delete(user: Farmer)

}