package com.vlada.shoesstore.models

/**
 * Created by Vlada on 14.03.2018.
 */
// TODO: photo должно быть в String
data class Product (val productId: Int,
               val productName: String,
               val categoryId: String,
               val description: String,
               val photo: Int,
               val price: String,
               val avalibility: String,
               val manufacturer: String
){
    class List : ArrayList<Product>()
}