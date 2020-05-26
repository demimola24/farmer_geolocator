package com.example.farmerapp.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.farmerapp.db.dao.FarmerDao
import com.example.farmerapp.db.entity.Farmer

@Database(entities = [Farmer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun farmerDao(): FarmerDao



    companion object {
        private lateinit var INSTANCE: AppDatabase

        @JvmStatic
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "farmer.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }

}