package com.github.depromeet.a24cafe.adapter

interface MainAdapterContract{

    interface Model{

        fun addItem()
    }

    interface View{
        fun notifyChange()
    }
}