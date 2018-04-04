package com.vlada.shoesstore.models

/**
 * Created by Vlados on 28.02.2018.
 */
data class Category(
        val id: String,
        val categoryName: String,
        val categoryTypeId: String,
        val photoUrl: String
) {
    class List : ArrayList<Category>()
}