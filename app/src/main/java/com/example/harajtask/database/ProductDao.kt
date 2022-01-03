package com.example.harajtask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.harajtask.models.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg product: Product)

    @Query("SELECT * FROM products_table")
    fun getProducts(): LiveData<List<Product>>

    @Query("DELETE FROM products_table")
    fun clearDatabase()


    @Query("SELECT * FROM products_table WHERE title LIKE :searchQuery OR city LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Product>>


}