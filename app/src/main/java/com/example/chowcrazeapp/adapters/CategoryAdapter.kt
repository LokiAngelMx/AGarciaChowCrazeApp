package com.example.chowcrazeapp.adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.chowcrazeapp.models.Category
import com.example.chowcrazeapp.R
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CategoryAdapter(val categories: List<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val categoryImage: ImageView = itemView.findViewById(R.id.categoryImageView)
        val categoryName: TextView = itemView.findViewById(R.id.categoryNameTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryName.text = category.name
        Picasso.get().load(category.image).into(holder.categoryImage)
    }
}