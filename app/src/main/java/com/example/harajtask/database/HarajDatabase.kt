package com.example.harajtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.harajtask.models.Product

@Database(entities = [Product::class], version = 7)
abstract class HarajDatabase : RoomDatabase() {
    abstract val productDao: ProductDao

    companion object {

        @Volatile
        private var INSTANCE: HarajDatabase? = null

        fun getInstance(context: Context): HarajDatabase {
            return synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HarajDatabase::class.java,
                        "haraj_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }//if-statement boundaries
                instance
            }
        }

    }

}