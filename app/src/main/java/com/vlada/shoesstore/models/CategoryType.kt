package com.vlada.shoesstore.models

/**
 * Created by Vlada on 20.02.2018.
 */
data class CategoryType(val id: Int,  val categoryTypeName: String, val photo: Int) {

    val mId = id
    val mCategoryType = categoryTypeName
    val mPhoto = photo

    class List : ArrayList<CategoryType>()
}