package com.vlada.shoesstore.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.RecyclerViewAdapter
import com.vlada.shoesstore.models.CategoryType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val catalogTypeRecyclerView = findViewById<RecyclerView>(R.id.catalogTypeRecyclerView)
        catalogTypeRecyclerView.layoutManager = LinearLayoutManager(this)


        val categoryTypes = ArrayList<CategoryType>()
        categoryTypes.add(CategoryType(1,"Женская коллекция"))
        categoryTypes.add(CategoryType(2,"Мужская коллекция"))
        categoryTypes.add(CategoryType(3,"Детская коллекция(девочки)"))
        categoryTypes.add(CategoryType(4,"Детская коллекция(мальчики)"))

        val adapter = RecyclerViewAdapter(categoryTypes, applicationContext)
        catalogTypeRecyclerView.adapter = adapter
    }
}
