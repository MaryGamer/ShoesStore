package com.vlada.shoesstore

import com.google.gson.Gson
import com.vlada.shoesstore.activities.ProductList
import com.vlada.shoesstore.models.Category
import com.vlada.shoesstore.models.Product
import io.paperdb.Paper
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.*

/**
 * Created by Vlada on 04.04.2018.
 */

fun loadCategoryFromServer(): Category.List {
    val httpClient = OkHttpClient()

    val request = Request.Builder()
            .url("https://api.myjson.com/bins/qr98b")
            .build()
    val response = httpClient.newCall(request).execute()

    val responseText = response.body()!!.string()

    System.out.println(responseText)

    val categories = Gson().fromJson(responseText, Category.List::class.java)

    System.out.println(categories)

    Paper.book().write("category", categories)

    return categories
}


fun loadProductsById(id: String): Product.List{
    val httpClient = OkHttpClient()

    val request = Request.Builder()
            .url("https://api.myjson.com/bins/qr98b")
            .build()
    val response = httpClient.newCall(request).execute()

    val responseText = response.body()!!.string()

    val products = Gson().fromJson(responseText, Product.List::class.java)

    val requestById: Product.List = Product.List()

    for (item in products){
        if (item.categoryId == id){
            requestById.add(item)
        }
    }

    return requestById
}