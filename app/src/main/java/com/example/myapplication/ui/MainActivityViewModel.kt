package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ItemHolder
import com.example.myapplication.data.item.Item
import com.example.myapplication.data.sharedPref.data.ShredPref

class MainActivityViewModel(private val sharedPref: ShredPref) : ViewModel() {

    fun getSharedpref(): Int {
        return sharedPref.getData()
    }

    fun getItem(id: Int): Item{
       return ItemHolder.getById(id)
    }
}