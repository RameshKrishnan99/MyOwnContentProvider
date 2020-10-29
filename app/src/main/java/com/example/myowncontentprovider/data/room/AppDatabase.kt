package com.example.myowncontentprovider.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myowncontentprovider.data.model.CountryModel

@Database(entities = [CountryModel::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

    companion object {
        private var dbInstance: AppDatabase? = null

        @Synchronized
        fun getDbInstance(context: Context): AppDatabase {
            if (dbInstance == null)
                dbInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Content_Test"
                ).allowMainThreadQueries().build()

            return dbInstance!!
        }
    }


}