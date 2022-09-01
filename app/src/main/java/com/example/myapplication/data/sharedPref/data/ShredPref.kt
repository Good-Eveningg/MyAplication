package com.example.myapplication.data.sharedPref.data

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.data.SHARED_KEY
import com.example.myapplication.data.SHARED_PREF_NAME

class ShredPref(private val context: Context) {

    fun saveDataToSharedPref(id: Int): SharedPreferences {
        val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putInt(SHARED_KEY, id)
        editor.apply()
        return sharedPref
    }

    fun getData(): Int {
        val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPref.getInt(SHARED_KEY, -1)
    }

}