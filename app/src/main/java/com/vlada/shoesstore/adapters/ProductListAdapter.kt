package com.vlada.shoesstore.adapters

import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.Product


class ProductListAdapter(private val productList: ArrayList<Product>,
                         private val onProductClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

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

        holder?.productName?.text = productList.productName
        holder?.productPrice?.text = productList.price
        holder?.productAvalibility?.text = productList.avalibility
        holder?.productManufacturer?.text = productList.manufacturer
        try {
            Picasso.get().load(productList.photoUrl).into(holder?.productPhoto)
        }
        catch (e: Exception){
            holder?.productPhoto?.setImageResource(R.drawable.girl)
        }
    }



    override fun getItemCount(): Int {
        return productList.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var productName = itemView.findViewById<TextView>(R.id.ProductListTextView)
        var productPhoto = itemView.findViewById<ImageView>(R.id.imageViewProductList)
        var productPrice = itemView.findViewById<TextView>(R.id.PriceProductListTextView)
        var productAvalibility = itemView.findViewById<TextView>(R.id.AvalibilityProductListTextView)
        var productManufacturer = itemView.findViewById<TextView>(R.id.ManufacturerListTextView)
    }
}