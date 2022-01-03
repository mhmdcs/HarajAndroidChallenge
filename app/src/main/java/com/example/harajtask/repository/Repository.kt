package com.example.harajtask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.harajtask.database.HarajDatabase
import com.example.harajtask.models.ProductNetwork
import com.example.harajtask.models.asDatabaseModel
import com.example.harajtask.models.asNetworkModel
import com.example.harajtask.network.HarajApi
import com.example.harajtask.network.parseProductJsonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.lang.Exception

class Repository(private val database: HarajDatabase) {

    val getCachedProducts: LiveData<List<ProductNetwork>> = Transformations.map(database.productDao.getProducts()){
        it.asNetworkModel()
    }

    suspend fun refreshProducts() = withContext(Dispatchers.IO) {
        try {
        val productResult = HarajApi.retrofitService.getProducts()
        val parsedProductResult = parseProductJsonResult(JSONObject(productResult))
        database.productDao.insertAll(*parsedProductResult.asDatabaseModel())
        }
        catch (error: Exception){
            error.printStackTrace()
            Log.i("Repository", "Fetch data Error $error")
        }
        }
}