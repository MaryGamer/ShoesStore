package com.vlada.shoesstore.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.google.gson.Gson
import com.vlada.shoesstore.App
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.CatalogCustomAdapter
import com.vlada.shoesstore.loadCategoryFromServer
import com.vlada.shoesstore.loadCategoryFromServer
import com.vlada.shoesstore.models.Category
import com.vlada.shoesstore.models.CategoryType
import io.paperdb.Paper
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import okhttp3.*
import java.io.IOException
import java.lang.Integer.parseInt

/**
 * Created by Vlada on 28.02.2018.
 */
class Catalog : AppCompatActivity() {

    private lateinit var catalogRecyclerView: RecyclerView

    private lateinit var typeId: String

   // private val adapter = CatalogCustomAdapter(Category.catalog) { category -> onCategoryClick(category) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        typeId = getIntent().getExtras().getString("id")

        catalogRecyclerView = findViewById(R.id.catalogRecyclerView)
        catalogRecyclerView.layoutManager = LinearLayoutManager(this)

//        val catalog = ArrayList<Category>()
//        catalog.add(Category(1, "Босоножки", 1, R.drawable.high_heel1))
//        catalog.add(Category(2, "Кроссовки", 1, R.drawable.sneakers))
//        catalog.add(Category(3, "Сапоги", 1, R.drawable.high_heel))
//        catalog.add(Category(4, "Тапочки", 1, R.drawable.women_slippers))
//        catalog.add(Category(5, "Туфли", 1, R.drawable.high_heel2))


        if ((application as App).isOnline()) {

            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/b3rqj")
                    .build()
            client.newCall(request).enqueue(object : Callback {

                override fun onResponse(call: Call?, response: Response?) {
                    val responseText = response?.body()!!.string()

                    val category = Gson().fromJson(responseText, Category.List::class.java)

                    Paper.book().write("restaurants", category)

                    runOnUiThread {
                        catalogRecyclerView.adapter = CatalogCustomAdapter(category) { category ->
                            onCategoryClick(category)
                    }
                }
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    println("Failed to execute request")
                }
            })

        }
//        else {
//            catalogRecyclerView.adapter = CatalogCustomAdapter(loadCategoryFromServer()) { category ->
//                onCategoryClick(category)
//                }
//        }
//        catalogRecyclerView.adapter.notifyDataSetChanged()


//        val adapter = CatalogCustomAdapter(catalog, { category: Category -> onCategoryClick(category) })
//        catalogRecyclerView.adapter = adapter
    }

    private fun onCategoryClick(category: Category) {
        Toast.makeText(this, "${category.categoryName}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProductList::class.java)
        intent.putExtra("categoryId",category.id)
        startActivity(intent)
    }
}