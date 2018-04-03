package com.vlada.shoesstore.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.RecyclerViewAdapter
import com.vlada.shoesstore.models.CategoryType

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

        // val adapter = RecyclerViewAdapter(categoryTypes, {categoryType: CategoryType -> categoryTypeClick(categoryType)})
        // catalogTypeRecyclerView.adapter = adapter
    }

    private fun onCategoryTypeClick(categoryType: CategoryType) {
        Toast.makeText(this, "${categoryType.categoryTypeName}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Catalog::class.java) //здесь
        startActivity(intent)
    }

    /*
    * {
    *   "name" : "крч имя",
    *   "items" : ['Туфли','Босоножки']
    * }
    *
    * */
}
