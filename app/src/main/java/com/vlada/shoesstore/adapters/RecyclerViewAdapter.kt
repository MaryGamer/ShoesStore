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
class RecyclerViewAdapter(val categoryTypeNameList: ArrayList<CategoryType>, val categoryClickListener: (CategoryType) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.category_type_list, parent, false)

        val categoryTypeCardView = view.findViewById<CardView>(R.id.categoryTypeCardView)
        //categoryTypeCardView.radius = 5.0F

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        holder.bindItems(categoryTypeNameList[position], categoryClickListener)

    }

    override fun getItemCount(): Int {
        return categoryTypeNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(categoryType: CategoryType, categoryClickListener: (CategoryType) -> Unit) {

            var categoryTypePhoto = itemView.findViewById<ImageView>(R.id.categoryTypePhoto)
            categoryTypePhoto.setImageResource(categoryType.photo)

            val categoryTypeText = itemView.findViewById<TextView>(R.id.categoryTypeText)
            categoryTypeText.text = categoryType.categoryTypeName

            itemView.setOnClickListener{
                categoryClickListener(categoryType)
            }
        }
    }
}