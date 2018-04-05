package com.vlada.shoesstore.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vlada.shoesstore.*
import com.vlada.shoesstore.adapters.CatalogCustomAdapter
import com.vlada.shoesstore.models.Category
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class Catalog : AppCompatActivity() {

    private lateinit var catalogRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val typeId = intent.extras.getString("id")
        val title = intent.extras.getString("title")

        setTitle(title)

        catalogRecyclerView = findViewById(R.id.catalogRecyclerView)
        catalogRecyclerView.layoutManager = LinearLayoutManager(this)

        if ((application as App).isOnline()) {
            launch(UI) {
            val catalogs = async (CommonPool) {
                    loadCategoryById(typeId)
                }.await()
                    catalogRecyclerView.adapter = CatalogCustomAdapter(catalogs) { category ->
                        onCategoryClick(category)
                    }
            }
        }
        else {
            catalogRecyclerView.adapter = CatalogCustomAdapter(loadCategoryByIdFromDb(typeId)) { category ->
                onCategoryClick(category)
            }
        }


    }



    private fun onCategoryClick(category: Category) {
        Toast.makeText(this, "${category.categoryName}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProductList::class.java)
        intent.putExtra("categoryId", category.id)
        intent.putExtra("title", category.categoryName)
        startActivity(intent)
    }


}