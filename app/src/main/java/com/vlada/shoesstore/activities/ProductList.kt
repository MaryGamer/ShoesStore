package com.vlada.shoesstore.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vlada.shoesstore.App
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.ProductListAdapter
import com.vlada.shoesstore.loadProductsById
import com.vlada.shoesstore.loadProductsByIdFromDb
import com.vlada.shoesstore.models.Product
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch


class ProductList : AppCompatActivity() {

    private lateinit var productListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val idCategory = intent.extras.getString("categoryId")
        val title = intent.extras.getString("title")

        setTitle(title)

        productListRecyclerView = findViewById(R.id.productListRecyclerView)
        productListRecyclerView.layoutManager = GridLayoutManager(this, 2)

        if ((application as App).isOnline()) {
            launch(UI) {
               val products =  async {
                   loadProductsById(idCategory)
               }.await()
                    productListRecyclerView.adapter = ProductListAdapter(products) { product ->
                        onProductClick(product)
                    }
            }
        }
        else {
            productListRecyclerView.adapter = ProductListAdapter(loadProductsByIdFromDb(idCategory)) { product ->
                onProductClick(product)
            }
        }
    }


    private fun onProductClick(product: Product) {
        Toast.makeText(this, product.productName, Toast.LENGTH_SHORT).show()
    }
}