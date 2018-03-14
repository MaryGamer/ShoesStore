package com.vlada.shoesstore.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.CatalogCustomAdapter
import com.vlada.shoesstore.models.Category
import com.vlada.shoesstore.models.CategoryType

/**
 * Created by Vlada on 28.02.2018.
 */
class Catalog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val catalogRecyclerView = findViewById<RecyclerView>(R.id.catalogRecyclerView)
        catalogRecyclerView.layoutManager = LinearLayoutManager(this)

        val catalog = ArrayList<Category>()
        catalog.add(Category(1, "Босоножки", 1))
        catalog.add(Category(2, "Кроссовки", 1))
        catalog.add(Category(3, "Сапоги", 1))
        catalog.add(Category(4, "Тапочки", 1))
        catalog.add(Category(5, "Туфли", 1))

        val adapter = CatalogCustomAdapter(catalog, {category: Category -> categoryClick(category)})
        catalogRecyclerView.adapter = adapter
    }

    private fun categoryClick(category: Category){
        Toast.makeText(this, "${category.categoryName}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProductList::class.java)
        startActivity(intent)
    }
}