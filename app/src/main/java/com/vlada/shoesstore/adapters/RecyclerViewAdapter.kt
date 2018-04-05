package com.vlada.shoesstore.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.CategoryType


class RecyclerViewAdapter(private val categoryTypeNameList: ArrayList<CategoryType>,
                          private val onCategoryTypeClick: (CategoryType) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.category_type_list, parent, false)

        return ViewHolder(view).apply {
            view.setOnClickListener {
                val position = adapterPosition

                if (position != RecyclerView.NO_POSITION) {
                    val name = categoryTypeNameList[position]
                    onCategoryTypeClick(name)
                }
            }
        }
    }



    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        val category = categoryTypeNameList[position]

        holder.categoryTypePhoto?.setImageResource(category.photo)
        holder.categoryTypeText?.text = category.categoryTypeName

    }



    override fun getItemCount(): Int {
        return categoryTypeNameList.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryTypePhoto: ImageView? = null
        var categoryTypeText: TextView? = null

        init {
            this.categoryTypePhoto = itemView.findViewById<ImageView>(R.id.categoryTypePhoto)
            this.categoryTypeText = itemView.findViewById<TextView>(R.id.categoryTextView)
        }
    }
}