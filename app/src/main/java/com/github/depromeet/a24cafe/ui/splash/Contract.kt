package com.github.depromeet.a24cafe.ui.splash

import android.content.Context

interface Contract{

    interface View{

    }

    interface Presenter{
        fun init(context: Context)

    }
}
