package com.example.instagramscreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramscreen.R
import com.example.instagramscreen.databinding.LayoutImageItemBinding

class MyImagesAdapter(private val context: Context, private val images: ArrayList<String>) :
    RecyclerView.Adapter<MyImagesAdapter.MyViewHolder>() {


    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_image_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val path = images[position]

        Glide.with(context)
            .load(path)
            .into(holder.binding.ivImage)
    }

    inner class MyViewHolder(
        val binding: LayoutImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

}