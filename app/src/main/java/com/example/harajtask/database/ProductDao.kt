package com.example.harajtask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.harajtask.models.ProductDatabase

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg product: ProductDatabase)

    @Query("SELECT * FROM products_table")
     fun getProducts(): LiveData<List<ProductDatabase>>

}