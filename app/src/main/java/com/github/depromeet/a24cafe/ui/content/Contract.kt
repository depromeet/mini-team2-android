package com.github.depromeet.a24cafe.ui.content

import android.content.Context
import android.widget.LinearLayout

interface Contract{

    interface View{
        fun setMap(): LinearLayout
        fun setText(title: String, content: String, createdAt: String, phone: String?, time: String?, exit: String?)
    }

    interface Presenter{
        fun init(view: View, context: Context)

        // 지도세팅
        fun mapSetting()

        // 데이터 불러오기
        fun getData()
    }
}