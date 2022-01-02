package com.example.harajtask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.database.HarajDatabase
import com.example.harajtask.models.Product
import com.example.harajtask.network.HarajApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class Repository(private val database: HarajDatabase) {

    suspend fun refreshProducts(products: MutableLiveData<List<Product>>) = withContext(Dispatchers.IO){
        try {
            val response = HarajApi.retrofitService.getProducts()
            val products = response.products
            database.productDao.insertAll(*products.toTypedArray())
        }
        catch (error: Exception){
            error.printStackTrace()
        }
    }

    suspend fun getCachedProducts(): LiveData<List<Product>> = withContext(Dispatchers.IO){
        database.productDao.getProducts()
    }

}