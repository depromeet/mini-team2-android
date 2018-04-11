package com.github.depromeet.a24cafe.ui.main

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.depromeet.a24cafe.R
import com.github.depromeet.a24cafe.api.apiService

class MainViewHolder(itemView: View, val itemClick: (apiService.mainItem) -> Unit) : RecyclerView.ViewHolder(itemView) {

    val location = itemView.findViewById<TextView>(R.id.mainlist_location)  // 장소 이름
    val image = itemView.findViewById<ImageView>(R.id.mainlist_background)  // 배경 이미지
    val layer = itemView.findViewById<CardView>(R.id.mainlist_layer)    // 전체 배경
    val locationCount = itemView.findViewById<TextView>(R.id.mainlist_location_count)

    fun bind(item: MutableList<apiService.mainItem>, position: Int, context: Context) {

        Glide.with(context)
                .load(R.drawable.hongdae)
                .into(image)

        location.text = item[position].name
        locationCount.text = "17곳"

        layer.setOnClickListener {
            itemClick(item.get(position))
        }
    }

}