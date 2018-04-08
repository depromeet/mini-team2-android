package com.github.depromeet.a24cafe.ui.main

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.depromeet.a24cafe.R
import com.github.depromeet.a24cafe.model.dummy

class MainViewHolder(itemView: View, val itemClick: () -> Unit) : RecyclerView.ViewHolder(itemView) {


    val test = itemView.findViewById<TextView>(R.id.mainlist_location)
    val image = itemView.findViewById<ImageView>(R.id.mainlist_background)
    val layer = itemView.findViewById<CardView>(R.id.mainlist_layer)



    fun bind(item: MutableList<dummy>, position: Int, context: Context) {

        when(position){
            0 -> {
                Glide.with(context)
                        .load(R.drawable.hongdae)
                        .into(image)
                test.text = "홍대"
            }

            1 -> {
                Glide.with(context)
                        .load(R.drawable.gangnam)
                        .into(image)
                test.text = "강남"
            }

            2 -> {
                Glide.with(context)
                        .load(R.drawable.shillim)
                        .into(image)
                test.text = "신림"
            }

        }
        layer.setOnClickListener {
            itemClick()
        }
    }

}