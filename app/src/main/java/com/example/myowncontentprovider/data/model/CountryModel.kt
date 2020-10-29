package com.example.myowncontentprovider.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Country_table")
data class CountryModel(@PrimaryKey val uid: Int=0, @ColumnInfo(name = "country_name") val name: String,
                        @ColumnInfo(name = "country_capital") val capital: String)