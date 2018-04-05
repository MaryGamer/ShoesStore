package com.vlada.shoesstore.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.RecyclerViewAdapter
import com.vlada.shoesstore.models.CategoryType
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    private lateinit var catalogTypeRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catalogTypeRecyclerView = findViewById(R.id.catalogTypeRecyclerView)
        catalogTypeRecyclerView.layoutManager = GridLayoutManager(this, 2)

        catalogTypeRecyclerView.adapter = RecyclerViewAdapter(getCategoryTypes()) { categoryType: CategoryType ->
            onCategoryTypeClick(categoryType)
        }
    }



    private fun onCategoryTypeClick(categoryType: CategoryType) {
        Toast.makeText(this, categoryType.categoryTypeName, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Catalog::class.java)
        intent.putExtra("id", categoryType.id)
        intent.putExtra("title",categoryType.categoryTypeName)
        startActivity(intent)
    }



    private fun getCategoryTypes(): ArrayList<CategoryType> {

        val categoryTypes = ArrayList<CategoryType>()
        categoryTypes.add(CategoryType("1", "Женская коллекция", R.drawable.girl))
        categoryTypes.add(CategoryType("2", "Мужская коллекция", R.drawable.boy))
        categoryTypes.add(CategoryType("3", "Детская коллекция(девочки)", R.drawable.child_girl))
        categoryTypes.add(CategoryType("4", "Детская коллекция(мальчики)", R.drawable.child_boy))

        Paper.book().write("categoryTypes", categoryTypes)

        return categoryTypes
    }

}
