package com.github.depromeet.a24cafe.ui.content

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.depromeet.a24cafe.R

class ContentActivity : AppCompatActivity(), Contract.View {

    private lateinit var presenter: ContentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
    }

    fun init(){
        presenter = ContentPresenter()
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}
