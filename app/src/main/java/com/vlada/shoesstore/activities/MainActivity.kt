package com.vlada.shoesstore.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.google.gson.Gson
import com.vlada.shoesstore.App
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.RecyclerViewAdapter
import com.vlada.shoesstore.models.Category
import com.vlada.shoesstore.models.CategoryType
import io.paperdb.Paper
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var catalogTypeRecyclerView: RecyclerView

    //private val adapter = RecyclerViewAdapter(CategoryType.categoryTypes) { categoryType -> onCategoryTypeClick(categoryType) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catalogTypeRecyclerView = findViewById(R.id.catalogTypeRecyclerView)
        catalogTypeRecyclerView.layoutManager = GridLayoutManager(this, 2)


        val categoryTypes = ArrayList<CategoryType>()
        categoryTypes.add(CategoryType(1, "Женская коллекция", R.drawable.girl))
        categoryTypes.add(CategoryType(2, "Мужская коллекция", R.drawable.boy))
        categoryTypes.add(CategoryType(3, "Детская коллекция(девочки)", R.drawable.child_girl))
        categoryTypes.add(CategoryType(4, "Детская коллекция(мальчики)", R.drawable.child_boy))

        val adapter = RecyclerViewAdapter(categoryTypes, { categoryType: CategoryType -> onCategoryTypeClick(categoryType) })
        catalogTypeRecyclerView.adapter = adapter


//        loadRestaurants()
    }

    private fun onCategoryTypeClick(categoryType: CategoryType) {
        Toast.makeText(this, "${categoryType.categoryTypeName}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Catalog::class.java) //здесь
        intent.putExtra("id","${categoryType.id}")
        startActivity(intent)
    }

    private fun loadRestaurants() {

        System.out.println("DAROU")

        val client = OkHttpClient()
        val request = Request.Builder()
                .url("https://api.myjson.com/bins/qr98b")
                .build()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val responseText = response?.body()!!.string()
                System.out.println(responseText)
                val restaurants = Gson().fromJson(responseText, Category.List::class.java)


                Paper.book().write("restaurants", restaurants)


                System.out.println(restaurants)
//                runOnUiThread {
//                    recyclerView.adapter = RestaurantAdapter(restaurants) { restaurant ->
//                        onRestaurantClick(restaurant)
//                    }
//                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })


    }
}
