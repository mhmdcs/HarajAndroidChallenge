package com.example.harajtask.models

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ProductNetwork(
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: String,
    val city: String,
    val date: String,
    val body: String,
): Parcelable

@Entity (tableName = "products_table")
@Parcelize
data class ProductDatabase(
    @PrimaryKey(autoGenerate = true) val id: Long=0L,
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: String,
    val city: String,
    val date: String,
    val body: String,
): Parcelable



fun ArrayList<ProductNetwork>.asDatabaseModel():Array<ProductDatabase> {
    return map { productNetwork ->
        ProductDatabase(
            title =  productNetwork.title,
            username = productNetwork.username,
            thumbURL = productNetwork.thumbURL,
            commentCount = productNetwork.commentCount,
            city = productNetwork.city,
            date = productNetwork.date,
            body = productNetwork.body,
        )
    }.toTypedArray()
}

fun List<ProductDatabase>.asNetworkModel(): List<ProductNetwork>{
    return map {  productDatabase ->
        ProductNetwork(
            title =  productDatabase.title,
            username = productDatabase.username,
            thumbURL = productDatabase.thumbURL,
            commentCount = productDatabase.commentCount,
            city = productDatabase.city,
            date = productDatabase.date,
            body = productDatabase.body,
        )
    }
}