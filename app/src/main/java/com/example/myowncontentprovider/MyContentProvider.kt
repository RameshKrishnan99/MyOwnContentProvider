package com.example.myowncontentprovider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.myowncontentprovider.data.model.CountryModel
import com.example.myowncontentprovider.data.room.AppDatabase
import com.example.myowncontentprovider.data.room.CountryDao


class MyContentProvider : ContentProvider() {
    private var dao: CountryDao? = null
    private var dbInstance: AppDatabase? = null
    val URI_MATCHER = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI(CountryContract.AUTHORITY, "country", COUNTRY_LIST)
    }
    val COUNTRY_LIST = 1
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
//        if (URI_MATCHER.match(uri) != COUNTRY_LIST)
//            throw IllegalArgumentException()

        values?.let {
            dao?.insertCountry(
                CountryModel(
                    it.getAsInteger("uid"),
                    it.getAsString("country_name"),
                    it.getAsString("country_capital")
                )
            )

        }
        return ContentUris.withAppendedId(uri, 2)
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        /*if (TextUtils.isEmpty(sortOrder)) {
            sortOrder = CountryDetails.SORT_ORDER_DEFAULT
        }*/
        val cursor = dao?.getAllDataCursor()
        cursor?.setNotificationUri(
            context!!.contentResolver,
            uri
        )
        return cursor
    }

    override fun onCreate(): Boolean {
        dbInstance = context?.let { AppDatabase.getDbInstance(it) }
        dao = dbInstance?.countryDao()
        return true
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        when (URI_MATCHER.match(uri)) {
            COUNTRY_LIST -> CountryDetails.CONTENT_TYPE
        }
        return null
    }
}