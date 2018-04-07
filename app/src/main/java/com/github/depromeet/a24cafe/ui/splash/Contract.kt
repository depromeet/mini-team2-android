package com.github.depromeet.a24cafe.ui.splash

interface Contract{

    interface View{
        fun finishSplash()
    }

    interface Presenter{
        fun init(view: Contract.View)

    }
}
