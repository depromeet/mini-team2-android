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


    val location = itemView.findViewById<TextView>(R.id.mainlist_location)  // 장소 이름
    val image = itemView.findViewById<ImageView>(R.id.mainlist_background)  // 배경 이미지
    val layer = itemView.findViewById<CardView>(R.id.mainlist_layer)    // 전체 배경
    val locationCount = itemView.findViewById<TextView>(R.id.mainlist_location_count)



    fun bind(item: MutableList<dummy>, position: Int, context: Context) {

        when(position){
            0 -> {
                Glide.with(context)
                        .load(R.drawable.hongdae)
                        .into(image)
                location.text = "홍대입구"
                locationCount.text = "17곳"
            }

            1 -> {
                Glide.with(context)
                        .load(R.drawable.gangnam)
                        .into(image)
                location.text = "강남"
                locationCount.text = "21곳"
            }

            2 -> {
                Glide.with(context)
                        .load(R.drawable.shillim)
                        .into(image)
                location.text = "신림"
                locationCount.text = "14곳"
            }

        }
        layer.setOnClickListener {
            itemClick()
        }
    }

}