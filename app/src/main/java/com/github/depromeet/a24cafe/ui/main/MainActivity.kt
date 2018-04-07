package com.github.depromeet.a24cafe.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.depromeet.a24cafe.R

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
