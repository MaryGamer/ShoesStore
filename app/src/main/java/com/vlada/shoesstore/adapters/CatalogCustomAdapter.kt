package com.vlada.shoesstore.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.Category


class CatalogCustomAdapter(private val categoryNameList: ArrayList<Category>,
                           private val onCategoryClick: (Category) -> Unit
) : RecyclerView.Adapter<CatalogCustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.catalog_row, parent, false)

        return ViewHolder(view).apply {
            view.setOnClickListener {
                val position = adapterPosition

                if (position != RecyclerView.NO_POSITION) {
                    val name = categoryNameList[position]
                    onCategoryClick(name)
                }
            }
        }
    }



    override fun onBindViewHolder(holder: CatalogCustomAdapter.ViewHolder, position: Int) {

        var category = categoryNameList[position]

        holder.categoryText.text = category.categoryName
        try {
            Picasso.get().load(category.photoUrl).into(holder.categoryPhoto)
        }
        catch (e: Exception) {
            holder.categoryPhoto?.setImageResource(R.drawable.girl)
        }
    }



    override fun getItemCount(): Int {
        return categoryNameList.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryText = itemView.findViewById<TextView>(R.id.categoryTextView)
        var categoryPhoto = itemView.findViewById<ImageView>(R.id.imageViewCatalog)
    }
}