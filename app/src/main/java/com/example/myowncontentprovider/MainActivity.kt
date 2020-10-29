package com.example.myowncontentprovider

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myowncontentprovider.data.model.CountryModel
import com.example.myowncontentprovider.data.room.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var dao = AppDatabase.getDbInstance(this).countryDao()
//        dao.insertCountry(CountryModel(name = "India", capital = "Delhi"))

//        val students: Uri = Uri.parse(mycon)
        /*val c = contentResolver.query(CountryContract.CONTENT_URI, null, null, null, null)!!
        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                    c.getString(c.getColumnIndex("uid")) +
                            ", " +  c.getString(c.getColumnIndex("country_name")) +
                            ", " + c.getString(c.getColumnIndex( "country_capital")),
                    Toast.LENGTH_SHORT).show()
            } while (c.moveToNext())
        }*/
        /*val URL = "content://com.rk.myowncontentprovider"

        val students: Uri = Uri.parse(URL)

        contentResolver.insert(students, ContentValues().apply {
            put("uid",2)
            put("country_name","America")
            put("country_capital","washington")
        })*/
    }
}