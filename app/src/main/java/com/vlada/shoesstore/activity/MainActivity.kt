package com.vlada.shoesstore.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.RecyclerViewAdapter
import com.vlada.shoesstore.models.CategoryType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val catalogTypeRecyclerView = findViewById<RecyclerView>(R.id.catalogTypeRecyclerView)
        catalogTypeRecyclerView.layoutManager = LinearLayoutManager(this)

       // val logoImageView = findViewById<ImageView>(R.id.logoImageView)

        val categoryTypes = ArrayList<CategoryType>()
        categoryTypes.add(CategoryType(1,"Женская коллекция", R.drawable.canada))
        categoryTypes.add(CategoryType(2,"Мужская коллекция",  R.drawable.germany))
        categoryTypes.add(CategoryType(3,"Детская коллекция(девочки)", R.drawable.canada))
        categoryTypes.add(CategoryType(4,"Детская коллекция(мальчики)", R.drawable.germany))

        val adapter = RecyclerViewAdapter(categoryTypes, applicationContext)
        catalogTypeRecyclerView.adapter = adapter
    }
}
