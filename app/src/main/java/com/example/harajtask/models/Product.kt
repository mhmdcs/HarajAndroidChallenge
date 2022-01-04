package com.example.harajtask.models

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "products_table", indices = [Index(value = ["thumbURL"], unique = true)])
@Parcelize
data class Product(
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: String,
    val city: String,
    val date: String,
    val body: String,
    @PrimaryKey (autoGenerate = true) val id: Long = 0
) : Parcelable
