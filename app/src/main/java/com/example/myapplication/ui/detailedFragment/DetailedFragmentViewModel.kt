package com.example.myapplication.ui.detailedFragment

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.item.Item
import com.example.myapplication.data.sharedPref.data.ShredPref

class DetailedFragmentViewModel(private val sharedPref: ShredPref) : ViewModel() {

    private lateinit var currentItem: Item


    fun saveId(id: Int) {
        sharedPref.saveDataToSharedPref(id)
    }

    fun getCurrentItem(item: Item){
        currentItem = item
    }

    fun getId(): Int{
        return currentItem.id
    }

    fun getName(): String{
        return currentItem.name
    }

    fun getDescription() : String{
        return currentItem.description
    }
}