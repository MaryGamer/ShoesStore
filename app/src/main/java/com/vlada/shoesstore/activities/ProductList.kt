package com.vlada.shoesstore.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.Product

/**
 * Created by Vlada on 14.03.2018.
 */
class ProductList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val productListRecyclerView = findViewById<RecyclerView>(R.id.productListRecyclerView)
        productListRecyclerView.layoutManager = LinearLayoutManager(this)

        val productList = ArrayList<Product>()
        productList.add(Product(1, "Босоножки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(2, "Кроссовки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(3, "Сапоги", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(4, "Тапочки", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел"))
        productList.add(Product(5, "Туфли", "lalalalalalalala", R.drawable.women, 6850.00, true, "Юничел123"))
    }
}