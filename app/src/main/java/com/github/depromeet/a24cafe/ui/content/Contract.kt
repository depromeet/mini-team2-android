package com.github.depromeet.a24cafe.ui.content

import android.content.Context
import android.widget.LinearLayout

interface Contract{

    interface View{
        fun setMap(): LinearLayout
    }

    interface Presenter{
        fun init(view: View, context: Context)
        fun mapSetting()
    }
}