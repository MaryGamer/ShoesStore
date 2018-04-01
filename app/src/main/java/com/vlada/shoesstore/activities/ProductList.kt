package com.vlada.shoesstore.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vlada.shoesstore.R
import com.vlada.shoesstore.adapters.ProductListAdapter
import com.vlada.shoesstore.models.Product

/**
 * Created by Vlada on 14.03.2018.
 */
class ProductList : AppCompatActivity() {

    private lateinit var productListRecyclerView: RecyclerView

    //private var adapter = ProductListAdapter(Product.productList) { product -> onProductClick(product) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        productListRecyclerView = findViewById(R.id.productListRecyclerView)
        productListRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val productList = ArrayList<Product>()
        productList.add(Product(1, "Босоножки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(2, "Босоножки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(3, "Босоножки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(4, "Босоножки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(5, "Босоножки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел123"))

        val adapter = ProductListAdapter(productList, { product: Product -> onProductClick(product) })
        productListRecyclerView.adapter = adapter
    }

    private fun onProductClick(product: Product) {
        Toast.makeText(this, "${product.productName}", Toast.LENGTH_SHORT).show()
        /*val intent = Intent(this, ProductActivity::class.java)
        startActivity(intent)*/
    }
}