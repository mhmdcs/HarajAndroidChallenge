package com.example.harajtask.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity (tableName = "products_table")
@Parcelize
data class Product(
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: String,
    val city: String,
    @PrimaryKey val date: String,
    val body: String,
): Parcelable

@JsonClass(generateAdapter = true)
data class ProductResponse(
    val products: List<Product>
)