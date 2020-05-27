package com.example.farmerapp.db.entity

import android.os.Parcelable
import androidx.room.*
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
@TypeConverters(LatLongTypeConverters::class)
data class Farmer(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "number") val number: String?,
    @ColumnInfo(name = "pictureUrl") val pictureUrl: String?,
    @ColumnInfo(name = "farmName") val farmName: String?,
    @ColumnInfo(name = "farmLocation") val farmLocation: String?,
    @ColumnInfo(name = "farmArea") val farmArea: Double,
    @ColumnInfo(name = "farmLatLong") val farmLatLong: List<LatLng?>
)  : Parcelable

class LatLongTypeConverters {
    @TypeConverter
    fun stringToLatLngs(json: String): List<LatLng> {
        val gson = Gson()
        val type = object : TypeToken<List<LatLng>>() {

        }.getType()
        return gson.fromJson<List<LatLng>>(json, type)
    }

    @TypeConverter
    fun LatLngsToString(list: List<LatLng>): String {
        val gson = Gson()
        val type = object : TypeToken<List<LatLng>>() {

        }.getType()
        return gson.toJson(list, type)
    }
}