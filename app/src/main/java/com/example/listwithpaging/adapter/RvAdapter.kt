package com.example.listwithpaging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listwithpaging.R
import com.example.listwithpaging.model.CharacterData

class RvAdapter : PagingDataAdapter<CharacterData, RvAdapter.MyViewHolder>(DiffUtilCallBack()) {
    override fun onBindViewHolder(holder: RvAdapter.MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.MyViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.row_rv, parent, false);

        return MyViewHolder(layoutInflater)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv: ImageView = view.findViewById<ImageView>(R.id.imageView);
        val txtName: TextView = view.findViewById<TextView>(R.id.txtName);
        val txtDesc: TextView = view.findViewById<TextView>(R.id.txtDesc);

        fun bind(item: CharacterData) {
            txtName.text = item.name
            txtDesc.text = item.species

            Glide.with(iv)
                .load(item.image)
                .circleCrop()
                .into(iv)
        }

    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name && oldItem.species == newItem.species
        }

    }
}


