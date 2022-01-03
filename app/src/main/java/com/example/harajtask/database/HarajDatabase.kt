package com.example.harajtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.harajtask.models.ProductDatabase

@Database(entities = [ProductDatabase::class], version = 4, exportSchema = false)
abstract class HarajDatabase: RoomDatabase()
{
    abstract val productDao: ProductDao

    companion object {

        @Volatile
        private var INSTANCE: HarajDatabase? = null

        fun getInstance(context: Context): HarajDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HarajDatabase::class.java,
                        "haraj_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }//if-statement boundaries
                return instance
            }
        }

    }

}