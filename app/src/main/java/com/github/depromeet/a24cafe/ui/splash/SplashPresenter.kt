package com.github.depromeet.a24cafe.ui.splash

import android.content.Context
import android.content.Intent
import com.github.depromeet.a24cafe.ui.main.MainActivity

class SplashPresenter : Contract.Presenter {

    private lateinit var context: Context

    override fun init(context: Context) {
        this.context = context

        intentActivity()
    }

    private fun intentActivity() {
        Thread.sleep(2000)
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}