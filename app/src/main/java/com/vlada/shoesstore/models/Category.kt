package com.vlada.shoesstore.models

data class Category(
        val id: String,
        val categoryName: String,
        val categoryTypeId: String,
        val photoUrl: String
) {
    class List : ArrayList<Category>()
}