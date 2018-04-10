package com.github.depromeet.a24cafe.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView

interface Contract{

    interface View{

        fun setList(): RecyclerView
    }

    interface Presenter{

        fun init(view: View, context: Context)
        fun getListData()
    }
}