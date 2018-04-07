package com.github.depromeet.a24cafe.ui.main

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.github.depromeet.a24cafe.R
import com.github.depromeet.a24cafe.model.dummy

class MainViewHolder(itemView: View, val itemClick: () -> Unit) : RecyclerView.ViewHolder(itemView) {


    val test = itemView.findViewById<TextView>(R.id.mainlist_test)
    val layer = itemView.findViewById<ConstraintLayout>(R.id.mainlist_layer)

    fun bind(item: MutableList<dummy>, position: Int, context: Context) {

        test.text = item[position].a.toString()

        layer.setOnClickListener {
            itemClick()
        }
    }

}