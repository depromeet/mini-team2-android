package com.github.depromeet.a24cafe.adapter

import com.github.depromeet.a24cafe.api.apiService

interface MainAdapterContract{

    interface Model{

        // 아이템 추가
        fun addItem(e: MutableList<apiService.mainItem>)
    }

    interface View{

        // 리사이클러뷰 갱신
        fun notifyChange()
    }
}