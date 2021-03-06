package com.github.depromeet.a24cafe.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.github.depromeet.a24cafe.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View {


    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        presenter.init(this, this)
        setRecyclerView()
    }

    private fun setRecyclerView() {

        val layoutmanager: LinearLayoutManager = LinearLayoutManager(this)

        main_recyclerview.setHasFixedSize(true)
        main_recyclerview.itemAnimator = DefaultItemAnimator()
        main_recyclerview.setNestedScrollingEnabled(false)
        main_recyclerview.layoutManager = layoutmanager
        main_recyclerview.scrollToPosition(0)

        // 서버로부터 데이터 받아오기
        presenter.getListData()
    }

    override fun setList(): RecyclerView {
        return main_recyclerview
    }
}
