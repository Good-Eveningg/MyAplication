package com.example.myapplication.data

import com.example.myapplication.data.item.Item
import java.io.Serializable

object ItemHolder {
    val items = (0 until 20).map {
        createItem(it)
    }

    fun getById(id: Int): Item {
        return Item(id)
    }

    private fun createItem(id: Int): Item {
        return Item(id)
    }
}