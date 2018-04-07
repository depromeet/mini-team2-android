package com.github.depromeet.a24cafe.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.depromeet.a24cafe.R

class SplashActivity : AppCompatActivity(), Contract.View {


    private lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenter()
        presenter.init(this)

    }

    override fun finishSplash() {

       /* val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()*/
        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show()
    }
}
