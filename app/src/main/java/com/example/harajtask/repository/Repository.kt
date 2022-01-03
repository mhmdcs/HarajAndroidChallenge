package com.example.harajtask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.database.HarajDatabase
import com.example.harajtask.models.Product
import com.example.harajtask.network.HarajApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

//class Repository(private val database: HarajDatabase) {
//
//    val getAllProducts = database.productDao.getProducts()
//
//    suspend fun refreshProducts(products: MutableLiveData<List<Product>>): MutableLiveData<List<Product>> {
//        withContext(Dispatchers.IO) {
////            val response = HarajApi.retrofitService.getProducts()
////            val products = response.products
//
//            val listResult = HarajApi.retrofitService.getProducts()
//            if (listResult.isNotEmpty()) {
//                products.postValue(listResult)
//            }
//            Log.i("Repository", "Is the list of products empty? $listResult")
//
//            //   database.productDao.insertAll(*products.toTypedArray())
//        }
//    }
//}