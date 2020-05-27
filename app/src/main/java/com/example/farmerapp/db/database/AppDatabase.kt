package com.example.farmerapp.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.farmerapp.db.dao.FarmerDao
import com.example.farmerapp.db.entity.Farmer
import com.example.farmerapp.db.entity.LatLongTypeConverters

@Database(entities = [Farmer::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun farmerDao(): FarmerDao



    companion object {

        @Volatile
        private lateinit var INSTANCE: AppDatabase

        @JvmStatic
        fun getInstance(context: Context): AppDatabase {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "farmer.db"
                    ).build()
                }

            return INSTANCE
        }
    }

}