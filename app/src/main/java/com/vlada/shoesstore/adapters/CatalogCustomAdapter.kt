package com.vlada.shoesstore.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.Category

/**
 * Created by Vlada on 28.02.2018.
 */
class CatalogCustomAdapter(val categoryNameList: ArrayList<Category>) : RecyclerView.Adapter<CatalogCustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.catalog_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogCustomAdapter.ViewHolder, position: Int) {

        holder.bindItems(categoryNameList[position])

    }

    override fun getItemCount(): Int {
        return categoryNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(category: Category) {

            var categoryText = itemView.findViewById<TextView>(R.id.categoryTextView)
            categoryText.text = category.categoryName

        }
    }
}