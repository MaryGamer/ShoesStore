package com.vlada.shoesstore.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.Product

/**
 * Created by Vlada on 21.03.2018.
 */
class ProductListAdapter(private val productList: ArrayList<Product>,
                         private val onProductClick: (Product) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.catalog_row, parent, false)

        return ViewHolder(view).apply {
            view.setOnClickListener {
                val position = adapterPosition

                if (position != RecyclerView.NO_POSITION) {
                    val name = productList[position]
                    onProductClick(name)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        TODO: надо заполнить
    }
}