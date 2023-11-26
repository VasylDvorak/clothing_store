package com.geekbrains.clothing_store
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val price:Double  = 0.0,
    val description:String,
    val category: String,
    val image:String
)

@Serializable
data class Products(
    val items:List<Product>
)
