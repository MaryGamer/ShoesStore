package com.vlada.shoesstore.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.vlada.shoesstore.R
import com.vlada.shoesstore.models.CategoryType

/**
 * Created by Vlada on 20.02.2018.
 */
class RecyclerViewAdapter(private val categoryTypeNameList: ArrayList<CategoryType>,
                          private val onCategoryTypeClick: (CategoryType) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.category_type_list, parent, false)

        //val categoryTypeCardView = view.findViewById<CardView>(R.id.categoryTypeCardView)

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

        var category = categoryTypeNameList[position]

        holder.categoryTypePhoto?.setImageResource(category.photo)
        holder.categoryTypeText?.text = category.categoryTypeName

    }

    override fun getItemCount(): Int {
        return categoryTypeNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryTypePhoto = itemView.findViewById<ImageView>(R.id.categoryTypePhoto)

        var categoryTypeText = itemView.findViewById<TextView>(R.id.categoryTextView)
    }
}