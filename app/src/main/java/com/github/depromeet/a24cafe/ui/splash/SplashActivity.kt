package com.github.depromeet.a24cafe.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.github.depromeet.a24cafe.R
import com.github.depromeet.a24cafe.ui.main.MainActivity

class SplashActivity : AppCompatActivity(), Contract.View {

    private lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenter()
        presenter.init(this)


    }

    override fun finishSplash() {

        var mDelayHandler: Handler? = null
        val SPLASH_DELAY: Long = 3000

        val mRunnable: Runnable = Runnable {
            if (!isFinishing) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        mDelayHandler = Handler()
        mDelayHandler.postDelayed(mRunnable, SPLASH_DELAY)

    }
}
