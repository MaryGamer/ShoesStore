package com.vlada.shoesstore.models

data class Product(
        val productId: String,
        val productName: String,
        val categoryId: String,
        val description: String,
        val photoUrl: String,
        val price: String,
        val avalibility: String,
        val manufacturer: String
) {
    class List : ArrayList<Product>()
}