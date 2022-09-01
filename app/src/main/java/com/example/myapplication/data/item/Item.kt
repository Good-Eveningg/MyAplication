package com.example.myapplication.data.item

import java.io.Serializable

data class Item(
    val id: Int,
    val name: String = "name $id",
    val description: String = "description $id"
) : Serializable
