package com.vlada.shoesstore

import com.google.gson.Gson
import com.vlada.shoesstore.models.Category
import com.vlada.shoesstore.models.Product
import io.paperdb.Paper
import okhttp3.*

fun loadProductsById(id: String): Product.List {

    val httpClient = OkHttpClient()
    val request = Request.Builder()
            .url("https://api.myjson.com/bins/ed2qb")
            .build()
    val response = httpClient.newCall(request).execute()

    val responseText = response.body()!!.string()

    val products = Gson().fromJson(responseText, Product.List::class.java)

    val productList: Product.List = Product.List()

    for (item in products) {
        if (item.categoryId == id) {
            productList.add(item)
        }
    }

    Paper.book("for-product-" + id).write("product", productList)

    return productList
}

fun loadProductsByIdFromDb(id: String): Product.List{
    try {
        return Paper.book("for-product-" + id).read("product")
    }
    catch (e: Exception){
        return getDefaultProduct()
    }
}



fun loadCategoryByIdFromDb(id: String): Category.List {
    try {
        return Paper.book("for-category-" + id).read("category")
    }
    catch (e: Exception) {
        return getDefaultCategory()
    }
}



private fun getDefaultProduct(): Product.List{

    val defaultList: Product.List = Product.List()

    val default = Product(
            "1",
            "Something",
            "1",
            "Description",
            "Url",
            "Price",
            "Avalibility",
            "Manufacturer"
    )
    defaultList.add(default)

    return defaultList
}



private fun getDefaultCategory(): Category.List{

    val defaultList: Category.List = Category.List()

    val default = Category(
            "1",
            "Category Name",
            "1",
            "Url"
    )
    defaultList.add(default)

    return defaultList
}


fun loadCategoryById(id: String): Category.List {
    val client = OkHttpClient()
    val request = Request.Builder()
            .url("https://api.myjson.com/bins/k0h9f")
            .build()
    val response = client.newCall(request).execute()

    val responseText = response.body()!!.string()

    val categories = Gson().fromJson(responseText, Category.List::class.java)

    val categoryList: Category.List = Category.List()

    for (item in categories) {
        if (item.categoryTypeId == id) {
            categoryList.add(item)
        }
    }

    Paper.book("for-category-" + id).write("category", categoryList)

    return categoryList
}
