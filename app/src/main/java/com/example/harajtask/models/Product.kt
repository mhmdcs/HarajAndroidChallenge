package com.example.harajtask.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity (tableName = "products_table")
@Parcelize
data class Product(
    @PrimaryKey val id: Int,
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: Int,
    val city: String,
    val date: Int,
    val body: String
    ): Parcelable
