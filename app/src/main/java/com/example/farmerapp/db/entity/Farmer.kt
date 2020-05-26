package com.example.farmerapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Farmer(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "number") val number: String?,
    @ColumnInfo(name = "pictureUrl") val pictureUrl: String?,
    @ColumnInfo(name = "farmName") val farmName: String?,
    @ColumnInfo(name = "farmLocation") val farmLocation: String?,
    @ColumnInfo(name = "farmLat") val farmLat: String?,
    @ColumnInfo(name = "farmLon") val farmLon: String?
)