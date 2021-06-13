package com.kirei.march.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kirei.march.R
import com.kirei.march.models.Photo

class ImageItemAdapter(private val photos: MutableList<Photo>,private val  context: Context) :
    RecyclerView.Adapter<ImageItemAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val photo : ImageView = itemView.findViewById(R.id.photo)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_photo,parent,false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(photos[position].url.regular)
            .placeholder(ColorDrawable(Color.parseColor(photos[position].color)))
            .into(holder.photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}