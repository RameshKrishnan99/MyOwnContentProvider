package com.example.myowncontentprovider

import android.content.ContentResolver
import android.net.Uri
import android.provider.BaseColumns

class CountryContract {
    companion object {
        const val AUTHORITY = "com.rk.myowncontentprovider"
        val CONTENT_URI = Uri.parse("content://$AUTHORITY")
    }


}

object CountryDetails : BaseColumns {
    val CONTENT_URI = Uri.withAppendedPath(CountryContract.CONTENT_URI, "country")

    val CONTENT_TYPE =
        ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.rk.myowncontentprovider.country_details"

    val PROJECTION_ALL = arrayOf("uid", "country_name", "country_capital")
    val SORT_ORDER_DEFAULT: String = "country_name ASC"
}