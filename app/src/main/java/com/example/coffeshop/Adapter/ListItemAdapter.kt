package com.example.coffeshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeshop.Activity.DetailActivity
import com.example.coffeshop.Model.ItemsModel
import com.example.coffeshop.databinding.ViewholderItemBinding

class ListItemAdapter (val items:MutableList<ItemsModel>):
RecyclerView.Adapter<ListItemAdapter.Viewholder>(){
    private var context: Context?=null

    class Viewholder(val binding: ViewholderItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemAdapter.Viewholder {
        context=parent.context
        val binding =ViewholderItemBinding.inflate(
            LayoutInflater.from(context),parent,false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: ListItemAdapter.Viewholder, position: Int) {
        holder.binding.tittleText.text=items[position].title
        holder.binding.priceTxt.text="$"+items[position].price.toString()
        holder.binding.subtittleTxt.text=items[position].extra

        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .into(holder.binding.img)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("object",items[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int=items.size

}