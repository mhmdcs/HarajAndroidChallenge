package com.example.harajtask.network

import com.example.harajtask.models.ProductNetwork
import org.json.JSONObject
import java.text.SimpleDateFormat

fun parseProductJsonResult(jsonObject: JSONObject): ArrayList<ProductNetwork> {

    val productList = ArrayList<ProductNetwork>()
    val postsJsonArray = jsonObject.getJSONArray("posts")

    for (i in 0 until postsJsonArray.length()) {
        val productJson = postsJsonArray.getJSONObject(i)

        val title = productJson.getString("title")
        val username = productJson.getString("username")
        val thumbURL = productJson.getString("thumbURL")
        val commentCount = productJson.getString("commentCount")
        val city = productJson.getString("city")

        val jsonEpochDate = productJson.getLong("date")
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dateInMilliseconds = java.util.Date(jsonEpochDate * 1000)
        val date = simpleDateFormat.format(dateInMilliseconds) as String

        val body = productJson.getString("body")

        val product = ProductNetwork(title, username, thumbURL, commentCount, city, date, body)
        productList.add(product)
    }
    return productList
}