package com.github.depromeet.a24cafe.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.depromeet.a24cafe.R
import com.github.depromeet.a24cafe.model.dummy
import com.github.depromeet.a24cafe.ui.main.MainViewHolder

class MainAdapter(val context: Context, val itemClick: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(), MainAdapterContract.View, MainAdapterContract.Model {


    private lateinit var item: MutableList<dummy>

    init {
        item = ArrayList()

        for(i in 0..10){
            item.add(i, dummy("ds"))
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder = MainViewHolder(LayoutInflater.from(context).inflate(R.layout.mainlist_item, parent, false), itemClick)

        return viewHolder
    }

    override fun getItemCount(): Int {

        if(item.size >0) return item.size
        else return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as MainViewHolder).bind(item, position, context)
    }

    override fun addItem() {

    }

    override fun notifyChange() {

    }

}
