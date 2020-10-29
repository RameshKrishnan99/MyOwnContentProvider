package com.example.myowncontentprovider.data.room

import android.database.Cursor
import androidx.room.*
import com.example.myowncontentprovider.data.model.CountryModel

@Dao
interface CountryDao {
    @Query("select * from Country_table")
    fun getAllData(): List<CountryModel>

    @Query("select * from Country_table")
    fun getAllDataCursor(): Cursor

    @Query("select * from country_table where country_name = :country_name")
    fun getCountryCapital(country_name: String): CountryModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCountry(model: CountryModel)

    @Delete
    fun deleteCountry(model: CountryModel)
}