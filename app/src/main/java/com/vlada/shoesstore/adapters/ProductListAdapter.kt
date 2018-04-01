package com.vlada.shoesstore.adapters

import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.Product

/**
 * Created by Vlada on 21.03.2018.
 */
class ProductListAdapter(private val productList: ArrayList<Product>,
                         private val onProductClick: (Product) -> Unit) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.product_list_row, parent, false)

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

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder?, position: Int) {

        var productList = productList[position]

        holder?.productText?.text = productList.productName
        holder?.productPhoto?.setImageResource(productList.photo)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var productText = itemView.findViewById<TextView>(R.id.ProductListTextView)
        var productPhoto = itemView.findViewById<ImageView>(R.id.imageViewProductList)
    }
}