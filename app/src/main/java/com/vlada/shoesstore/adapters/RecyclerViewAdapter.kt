package com.vlada.shoesstore.adapters


import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.vlada.shoesstore.R
import com.vlada.shoesstore.interfaces.RecyclerViewClickListener
import com.vlada.shoesstore.models.CategoryType

/**
 * Created by Vlada on 20.02.2018.
 */
class RecyclerViewAdapter(val categoryTypeNameList: ArrayList<CategoryType>, context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var mContext = context

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.category_type_list, parent, false)

        val categoryTypeCardView = view.findViewById<CardView>(R.id.categoryTypeCardView)
        //categoryTypeCardView.radius = 5.0F

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        holder.bindItems(categoryTypeNameList[position])

        holder.setOnRecyclerViewClickListener(object : RecyclerViewClickListener {
            override fun onRecyclerViewClickListener(view: View, position: Int) {
                Toast.makeText(mContext, "Когда-нибудь я это закончу", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun getItemCount(): Int {
        return categoryTypeNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var recyclerViewClickListener: RecyclerViewClickListener? = null

        fun setOnRecyclerViewClickListener(itemClickListener: RecyclerViewClickListener) {

            this.recyclerViewClickListener = itemClickListener

        }

        override fun onClick(p0: View?) {
            this.recyclerViewClickListener!!.onRecyclerViewClickListener(p0!!, adapterPosition)
        }

        fun bindItems(categoryType: CategoryType) {

            var categoryTypePhoto = itemView.findViewById<ImageView>(R.id.categoryTypePhoto)
            categoryTypePhoto.setImageResource(categoryType.photo)

            val categoryTypeText = itemView.findViewById<TextView>(R.id.categoryTypeText)
            categoryTypeText.text = categoryType.categoryTypeName

            itemView.setOnClickListener(this)
        }
    }
}